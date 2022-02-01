package com.tencent.qqmini.sdk.plugins;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
class BluetoothJsPlugin$BLEScan
  implements BluetoothAdapter.LeScanCallback
{
  private List<BluetoothJsPlugin.BluetoothDeviceExtend> foundDevices = new LinkedList();
  private boolean hasNewDevice;
  private boolean isDiscovering;
  private boolean mAllowDuplicatesKey;
  private long mInterval;
  
  BluetoothJsPlugin$BLEScan(BluetoothJsPlugin paramBluetoothJsPlugin) {}
  
  public void onBluetoothDeviceFound()
  {
    QMLog.d("BluetoothJsPlugin", "BLEScan.onBluetoothDeviceFound foundDevices size =" + this.foundDevices.size());
    JSONArray localJSONArray;
    if (this.hasNewDevice)
    {
      this.hasNewDevice = false;
      try
      {
        if (this.foundDevices.size() > 0)
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONArray = new JSONArray();
          synchronized (this.foundDevices)
          {
            Iterator localIterator = this.foundDevices.iterator();
            if (!localIterator.hasNext()) {
              break label128;
            }
            localJSONArray.put(((BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next()).toJson());
          }
        }
        return;
      }
      catch (JSONException localJSONException) {}
    }
    label128:
    localObject.put("devices", localJSONArray);
    String str = localObject.toString();
    QMLog.d("BluetoothJsPlugin", "BLEScan.onBluetoothDeviceFound callback data =" + str);
    BluetoothJsPlugin.access$700(this.this$0, "onBluetoothDeviceFound", str);
  }
  
  public void onLeScan(BluetoothDevice arg1, int paramInt, byte[] paramArrayOfByte)
  {
    QMLog.d("BluetoothJsPlugin", "BLEScan.onLeScan device =" + ??? + ",rssi=" + paramInt + ",scanRecord=" + paramArrayOfByte);
    if ((??? == null) || (paramArrayOfByte == null) || (!this.isDiscovering)) {}
    for (;;)
    {
      return;
      paramArrayOfByte = BluetoothJsPlugin.access$800(this.this$0, ???, paramInt, paramArrayOfByte);
      if (paramArrayOfByte == null) {
        continue;
      }
      synchronized (this.foundDevices)
      {
        if (!this.foundDevices.contains(paramArrayOfByte))
        {
          this.foundDevices.add(paramArrayOfByte);
          this.hasNewDevice = true;
        }
        while (!this.mAllowDuplicatesKey)
        {
          if (!this.hasNewDevice) {
            break;
          }
          synchronized (BluetoothJsPlugin.access$900(this.this$0))
          {
            if (!BluetoothJsPlugin.access$900(this.this$0).containsKey(paramArrayOfByte.mDevicesId)) {
              BluetoothJsPlugin.access$900(this.this$0).put(paramArrayOfByte.mDevicesId, paramArrayOfByte);
            }
            return;
          }
        }
        Iterator localIterator = this.foundDevices.iterator();
        while (localIterator.hasNext())
        {
          BluetoothJsPlugin.BluetoothDeviceExtend localBluetoothDeviceExtend = (BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next();
          if (localBluetoothDeviceExtend.mDevicesId.equalsIgnoreCase(???.getAddress())) {
            localBluetoothDeviceExtend.mRssi = paramInt;
          }
        }
        this.hasNewDevice = true;
      }
    }
  }
  
  public boolean startDiscovery(BluetoothAdapter paramBluetoothAdapter, UUID[] paramArrayOfUUID, boolean paramBoolean, long paramLong)
  {
    QMLog.d("BluetoothJsPlugin", "BLEScan.startDiscovery serviceUUID=" + paramArrayOfUUID + ",allowDuplicatesKey=" + paramBoolean + ",timeout=" + paramLong);
    boolean bool;
    if ((this.isDiscovering) || (paramBluetoothAdapter == null))
    {
      bool = false;
      return bool;
    }
    BluetoothJsPlugin.access$500(this.this$0).removeMessages(2);
    BluetoothJsPlugin.access$500(this.this$0).removeMessages(1);
    for (;;)
    {
      synchronized (this.foundDevices)
      {
        this.foundDevices.clear();
        this.mAllowDuplicatesKey = paramBoolean;
        this.mInterval = paramLong;
        if ((paramArrayOfUUID != null) && (paramArrayOfUUID.length > 0))
        {
          paramBoolean = paramBluetoothAdapter.startLeScan(paramArrayOfUUID, this);
          bool = paramBoolean;
          if (!paramBoolean) {
            break;
          }
          this.isDiscovering = true;
          BluetoothJsPlugin.access$600(this.this$0);
          BluetoothJsPlugin.access$500(this.this$0).sendEmptyMessageDelayed(1, 15000L);
          BluetoothJsPlugin.access$500(this.this$0).sendEmptyMessageDelayed(2, this.mInterval);
          return paramBoolean;
        }
      }
      paramBoolean = paramBluetoothAdapter.startLeScan(this);
    }
  }
  
  public void stopDiscovery(String arg1)
  {
    QMLog.d("BluetoothJsPlugin", "BLEScan.stopDiscovery......from=" + ???);
    BluetoothJsPlugin.access$500(this.this$0).removeMessages(1);
    BluetoothJsPlugin.access$500(this.this$0).removeMessages(2);
    if (BluetoothJsPlugin.access$000(this.this$0) != null) {
      BluetoothJsPlugin.access$000(this.this$0).stopLeScan(this);
    }
    synchronized (this.foundDevices)
    {
      this.foundDevices.clear();
      this.isDiscovering = false;
      BluetoothJsPlugin.access$600(this.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.BluetoothJsPlugin.BLEScan
 * JD-Core Version:    0.7.0.1
 */