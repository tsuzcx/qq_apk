package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
class QWalletBluetoothJsPlugin$ConnServicesCallback
  extends BluetoothGattCallback
{
  private int cur;
  private int mCount;
  private List<BluetoothDevice> mDevices;
  private Runnable mRunnable;
  private List<UUID> mSearchUuids;
  
  QWalletBluetoothJsPlugin$ConnServicesCallback(List<UUID> paramList, int paramInt)
  {
    this.mSearchUuids = paramInt;
    this.mDevices = new ArrayList();
    int i;
    this.mCount = i;
    this.cur = 0;
    this.mRunnable = new QWalletBluetoothJsPlugin.ConnServicesCallback.1(this, paramList);
    QWalletBluetoothJsPlugin.access$1300(paramList).postDelayed(this.mRunnable, 15000L);
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    super.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 2)) {
      paramBluetoothGatt.discoverServices();
    }
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    super.onServicesDiscovered(paramBluetoothGatt, paramInt);
    Object localObject1 = new ArrayList();
    Iterator localIterator = paramBluetoothGatt.getServices().iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (BluetoothGattService)localIterator.next();
      if (((BluetoothGattService)localObject2).getType() == 0) {
        ((List)localObject1).add(((BluetoothGattService)localObject2).getUuid());
      }
    }
    this.cur += 1;
    if (((List)localObject1).containsAll(this.mSearchUuids)) {
      this.mDevices.add(paramBluetoothGatt.getDevice());
    }
    if (this.cur == this.mCount)
    {
      QWalletBluetoothJsPlugin.access$1300(this.this$0).removeCallbacks(this.mRunnable);
      try
      {
        paramBluetoothGatt = new JSONObject();
        localObject1 = new JSONArray();
        localIterator = this.mDevices.iterator();
        while (localIterator.hasNext())
        {
          localObject2 = (BluetoothDevice)localIterator.next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.putOpt("name", ((BluetoothDevice)localObject2).getName());
          localJSONObject.put("deviceId", ((BluetoothDevice)localObject2).getAddress());
          ((JSONArray)localObject1).put(localJSONObject);
        }
        paramBluetoothGatt.put("devices", localObject1);
        paramBluetoothGatt.put("code", 0);
        QWalletBluetoothJsPlugin.access$200(this.this$0, "getConnectedBluetoothDevices", paramBluetoothGatt.toString());
        return;
      }
      catch (JSONException paramBluetoothGatt) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.ConnServicesCallback
 * JD-Core Version:    0.7.0.1
 */