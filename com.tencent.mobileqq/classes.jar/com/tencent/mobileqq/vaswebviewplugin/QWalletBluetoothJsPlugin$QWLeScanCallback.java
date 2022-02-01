package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.UUID;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
class QWalletBluetoothJsPlugin$QWLeScanCallback
  implements BluetoothAdapter.LeScanCallback
{
  private boolean mAllowDuplicatesKey;
  private int mInterval;
  private ArrayList<UUID> mServices;
  private Timer mTimer;
  private List<QWalletBluetoothJsPlugin.BluetoothDeviceExtend> tempDevices;
  
  QWalletBluetoothJsPlugin$QWLeScanCallback(QWalletBluetoothJsPlugin paramQWalletBluetoothJsPlugin, JSONArray paramJSONArray, boolean paramBoolean, int paramInt)
  {
    int i;
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      this.mServices = new ArrayList();
      i = 0;
    }
    while (i < paramJSONArray.length())
    {
      UUID localUUID = QWalletBluetoothJsPlugin.access$700(paramJSONArray.optString(i));
      if (localUUID != null) {
        this.mServices.add(localUUID);
      }
      i += 1;
      continue;
      this.mServices = null;
    }
    this.mAllowDuplicatesKey = paramBoolean;
    this.mInterval = paramInt;
    this.tempDevices = new ArrayList();
    if (this.mInterval > 0)
    {
      paramQWalletBluetoothJsPlugin = new QWalletBluetoothJsPlugin.QWLeScanCallback.1(this, paramQWalletBluetoothJsPlugin);
      ThreadManager.getUIHandler().postDelayed(paramQWalletBluetoothJsPlugin, this.mInterval * 1000);
    }
  }
  
  void addTempDevices(QWalletBluetoothJsPlugin.BluetoothDeviceExtend paramBluetoothDeviceExtend)
  {
    try
    {
      this.tempDevices.add(paramBluetoothDeviceExtend);
      return;
    }
    finally
    {
      paramBluetoothDeviceExtend = finally;
      throw paramBluetoothDeviceExtend;
    }
  }
  
  List<QWalletBluetoothJsPlugin.BluetoothDeviceExtend> getTempDevices()
  {
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.addAll(this.tempDevices);
      this.tempDevices.clear();
      return localArrayList;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject;
    if (paramBluetoothDevice != null)
    {
      localObject = QWalletBluetoothJsPlugin.access$1000(paramArrayOfByte);
      ArrayList localArrayList = this.mServices;
      if ((localArrayList != null) && (localArrayList.size() > 0) && (!((List)localObject).containsAll(this.mServices))) {
        return;
      }
      paramBluetoothDevice = new QWalletBluetoothJsPlugin.BluetoothDeviceExtend(this.this$0, paramBluetoothDevice, paramInt, paramArrayOfByte);
      paramInt = QWalletBluetoothJsPlugin.access$1100(this.this$0).contains(paramBluetoothDevice) ^ true;
      if (paramInt != 0) {
        QWalletBluetoothJsPlugin.access$1100(this.this$0).add(paramBluetoothDevice);
      }
      if (((paramInt != 0) || (this.mAllowDuplicatesKey)) && (this.mInterval != 0)) {}
    }
    try
    {
      paramArrayOfByte = new JSONObject();
      localObject = new JSONArray();
      ((JSONArray)localObject).put(QWalletBluetoothJsPlugin.access$800(paramBluetoothDevice));
      paramArrayOfByte.put("devices", localObject);
      QWalletBluetoothJsPlugin.access$200(this.this$0, "onBluetoothDeviceFound", paramArrayOfByte.toString());
      return;
    }
    catch (JSONException paramBluetoothDevice) {}
    addTempDevices(paramBluetoothDevice);
    return;
  }
  
  public void stopTimer()
  {
    Timer localTimer = this.mTimer;
    if (localTimer != null) {
      localTimer.cancel();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.QWLeScanCallback
 * JD-Core Version:    0.7.0.1
 */