package com.example.BTRemoteControl0;

import java.util.Set;

//import com.android2ee.android.tuto.communication.bluetooth.gui.arrayadapter.BluetoothDevicesAdapter;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;

public class MainActivity extends Activity {

	BluetoothAdapter mBluetoothAdapter;
	ArrayAdapter mArrayAdapter;
	ListView mListView;
	TableLayout tl0;
	LinearLayout ll2;
	
	//TextView	mTextView;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);
		
		//mTextView = (TextView) findViewById(R.id.textView1);
		//mTextView.setText("HAHAHAAA");
		
		ll2 = (LinearLayout) findViewById(R.id.linearLayout2);
		//ll2.setVisibility(View.GONE);  // View.Gone, View.INVISIBLE or View.VISIBLE 
		
		tl0 = (TableLayout) findViewById(R.id.tableLayout0);
		tl0.setVisibility(View.GONE);
		
		mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
		mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
	
		
	}

		
	@Override
	protected void onStart() {
		super.onStart();
		
		Set<BluetoothDevice> pairedDevices = mBluetoothAdapter.getBondedDevices();
		// If there are paired devices
		if (pairedDevices.size() > 0) {
		    // Loop through paired devices
		    for (BluetoothDevice device : pairedDevices) {
		        // Add the name and address to an array adapter to show in a ListView
		        mArrayAdapter.add(device.getName() + "\n" + device.getAddress());
		    }
		    mListView = (ListView) findViewById(R.id.listView1);
		    mListView.setAdapter(mArrayAdapter);
		    
		}
		
		mListView.setOnItemClickListener(mOnItemClickedHandler);
		
	}
	
	
	@Override
	protected void onStop() {
		super.onStop();
		
	}

	private ListView.OnItemClickListener mOnItemClickedHandler = new ListView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView parent, View v, int position, long id) {
				// TODO Auto-generated method stub
				
				//Log.v("TAG", "onItemClick");
				Log.v("TAG", parent.getItemAtPosition(position).toString());
				tl0.setVisibility(View.VISIBLE);
				ll2.setVisibility(View.GONE);
				
				
			}
	};	
}
