package com.tencent.mobileqq.vaswebviewplugin;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class QWalletBluetoothJsPlugin$4
  extends BluetoothGattCallback
{
  QWalletBluetoothJsPlugin$4(QWalletBluetoothJsPlugin paramQWalletBluetoothJsPlugin) {}
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    super.onCharacteristicChanged(paramBluetoothGatt, paramBluetoothGattCharacteristic);
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceId", paramBluetoothGatt.getDevice().getAddress());
      localJSONObject.put("serviceId", paramBluetoothGattCharacteristic.getService().getUuid().toString());
      localJSONObject.put("characteristicId", paramBluetoothGattCharacteristic.getUuid().toString());
      localJSONObject.put("value", QWalletBluetoothJsPlugin.access$1400(paramBluetoothGattCharacteristic.getValue()));
      QWalletBluetoothJsPlugin.access$200(this.this$0, "onBLECharacteristicValueChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    try
    {
      paramBluetoothGatt = new JSONObject();
      if (paramInt == 0)
      {
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("uuid", paramBluetoothGattCharacteristic.getUuid().toString());
        localJSONObject.put("serviceId", paramBluetoothGattCharacteristic.getService().getUuid().toString());
        localJSONObject.put("value", QWalletBluetoothJsPlugin.access$1400(paramBluetoothGattCharacteristic.getValue()));
        paramBluetoothGatt.put("characteristic", localJSONObject);
        paramBluetoothGatt.put("code", 0);
      }
      else
      {
        paramBluetoothGatt.put("code", 10007);
        paramBluetoothGatt.put("errMsg", "Read failed");
      }
      QWalletBluetoothJsPlugin.access$200(this.this$0, "readBLECharacteristicValue", paramBluetoothGatt.toString());
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    try
    {
      paramBluetoothGatt = new JSONObject();
      if (paramInt == 0)
      {
        paramBluetoothGatt.put("code", 0);
      }
      else
      {
        paramBluetoothGatt.put("code", 10007);
        paramBluetoothGatt.put("errMsg", "Write failed");
      }
      QWalletBluetoothJsPlugin.access$200(this.this$0, "writeBLECharacteristicValue", paramBluetoothGatt.toString());
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
  
  public void onConnectionStateChange(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    super.onConnectionStateChange(paramBluetoothGatt, paramInt1, paramInt2);
    String str = paramBluetoothGatt.getDevice().getAddress();
    try
    {
      boolean bool2 = QWalletBluetoothJsPlugin.access$1500(this.this$0).contains(str);
      boolean bool1 = false;
      if (bool2)
      {
        QWalletBluetoothJsPlugin.access$1500(this.this$0).remove(str);
        JSONObject localJSONObject = new JSONObject();
        if ((paramInt1 == 0) && (paramInt2 == 2))
        {
          QWalletBluetoothJsPlugin.access$1600(this.this$0).put(str, paramBluetoothGatt);
          localJSONObject.put("code", 0);
        }
        else
        {
          localJSONObject.put("code", 10003);
          localJSONObject.put("errMsg", "connect failed");
        }
        QWalletBluetoothJsPlugin.access$200(this.this$0, "createBLEConnection", localJSONObject.toString());
      }
      if (paramInt2 == 2) {
        QWalletBluetoothJsPlugin.access$1700(this.this$0).add(str);
      } else {
        QWalletBluetoothJsPlugin.access$1700(this.this$0).remove(str);
      }
      paramBluetoothGatt = new JSONObject();
      paramBluetoothGatt.put("deviceId", str);
      if (paramInt2 == 2) {
        bool1 = true;
      }
      paramBluetoothGatt.put("connected", bool1);
      QWalletBluetoothJsPlugin.access$200(this.this$0, "onBLEConnectionStateChange", paramBluetoothGatt.toString());
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    if (QWalletBluetoothJsPlugin.access$1200(this.this$0) != null)
    {
      QWalletBluetoothJsPlugin.access$1300(this.this$0).removeCallbacks(QWalletBluetoothJsPlugin.access$1200(this.this$0));
      QWalletBluetoothJsPlugin.access$1202(this.this$0, null);
    }
    super.onServicesDiscovered(paramBluetoothGatt, paramInt);
    Object localObject = paramBluetoothGatt.getServices();
    try
    {
      paramBluetoothGatt = new JSONObject();
      paramInt = ((List)localObject).size();
      if (paramInt == 0)
      {
        paramBluetoothGatt.put("code", 10004);
        paramBluetoothGatt.put("errMsg", "No Service");
      }
      else
      {
        JSONArray localJSONArray = new JSONArray();
        localObject = ((List)localObject).iterator();
        for (;;)
        {
          boolean bool2 = ((Iterator)localObject).hasNext();
          boolean bool1 = false;
          if (!bool2) {
            break;
          }
          BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uuid", localBluetoothGattService.getUuid().toString());
          if (localBluetoothGattService.getType() == 0) {
            bool1 = true;
          }
          localJSONObject.put("isPrimary", bool1);
          localJSONArray.put(localJSONObject);
        }
        paramBluetoothGatt.put("services", localJSONArray);
        paramBluetoothGatt.put("code", 0);
      }
      QWalletBluetoothJsPlugin.access$200(this.this$0, "getBLEDeviceServices", paramBluetoothGatt.toString());
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */