package com.tencent.qqmini.sdk.core.plugins;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import bglv;
import bgnk;
import bgok;
import com.tencent.qqmini.sdk.log.QMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BluetoothJsPlugin
  extends BaseJsPlugin
{
  private static final String BASE_UUID_SUFFIX = "-0000-1000-8000-00805F9B34FB";
  private static final int DATA_TYPE_FLAGS = 1;
  private static final int DATA_TYPE_LOCAL_NAME_COMPLETE = 9;
  private static final int DATA_TYPE_LOCAL_NAME_SHORT = 8;
  private static final int DATA_TYPE_MANUFACTURER_SPECIFIC_DATA = 255;
  private static final int DATA_TYPE_SERVICE_DATA = 22;
  private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_COMPLETE = 7;
  private static final int DATA_TYPE_SERVICE_UUIDS_128_BIT_PARTIAL = 6;
  private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_COMPLETE = 3;
  private static final int DATA_TYPE_SERVICE_UUIDS_16_BIT_PARTIAL = 2;
  private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_COMPLETE = 5;
  private static final int DATA_TYPE_SERVICE_UUIDS_32_BIT_PARTIAL = 4;
  private static final int DATA_TYPE_TX_POWER_LEVEL = 10;
  private static final String ERR_CODE = "errCode";
  private static final int ERR_CODE_CONN_FAIL = 10003;
  private static final int ERR_CODE_NOT_AVAILABLE = 10001;
  private static final int ERR_CODE_NOT_CONN = 10006;
  private static final int ERR_CODE_NOT_INIT = 10000;
  private static final int ERR_CODE_NO_CHARACTERISTIC = 10005;
  private static final int ERR_CODE_NO_DEVICE = 10002;
  private static final int ERR_CODE_NO_SERVICE = 10004;
  private static final int ERR_CODE_PROPERTY_NOT_SUPPORT = 10007;
  private static final int ERR_CODE_SUCC = 0;
  private static final int ERR_CODE_SYSTEM_ERROR = 10008;
  private static final int ERR_CODE_SYSTEM_NOT_SUPPORT = 10009;
  private static final String EVENT_CREATE_BLE_CONNECTION = "createBLEConnection";
  private static final String EVENT_GET_BLE_DEVICE_SERVICES = "getBLEDeviceServices";
  private static final long FOUND_DEVICES_DEFAULT_INTERVAL = 500L;
  private static final long SCAN_MAX_TIME = 15000L;
  public static final String TAG = "BluetoothJsPlugin";
  private static final int UUID_BYTES_128_BIT = 128;
  private static final int UUID_BYTES_16_BIT = 16;
  private static final int UUID_BYTES_32_BIT = 32;
  private static final int WHAT_SCAN_CALLBACK = 2;
  private static final int WHAT_SCAN_TIMEOUT = 1;
  private HashMap<String, BluetoothJsPlugin.BluetoothDeviceExtend> allFoundDevices = new HashMap();
  private BluetoothJsPlugin.BLEScan bleScan = new BluetoothJsPlugin.BLEScan(this);
  private boolean isSettingBlueTooth;
  private boolean isSupportBlueTooth;
  private Activity mActivity;
  private BluetoothAdapter mBluetoothAdapter;
  BroadcastReceiver mBluetoothStateReceiver = new BluetoothJsPlugin.2(this);
  private boolean sIsReceiverRegister;
  private Handler subHandler;
  
  private void closeAdapter()
  {
    QMLog.d("BluetoothJsPlugin", "closeAdapter......");
    this.bleScan.stopDiscovery("closeAdapter");
    synchronized (this.allFoundDevices)
    {
      Iterator localIterator = this.allFoundDevices.values().iterator();
      if (localIterator.hasNext()) {
        ((BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next()).destory();
      }
    }
    this.allFoundDevices.clear();
    if ((this.mBluetoothAdapter != null) && (this.mBluetoothAdapter.disable())) {
      throw new RuntimeException("closeAdapter fail, mBluetoothAdapter.disable fail");
    }
    unregisterBluetoothStateReceiver();
    this.mBluetoothStateReceiver = null;
    this.mBluetoothAdapter = null;
    this.isSettingBlueTooth = false;
  }
  
  @TargetApi(18)
  private void closeBLEConnection(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).getString("deviceId");
      if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(str))) {
        throw new Exception("closeBLEConnection fail, mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str);
      }
    }
    catch (Exception localException)
    {
      parambgok.b();
      return;
    }
    BluetoothJsPlugin.BluetoothDeviceExtend localBluetoothDeviceExtend = findBluetoothDeviceExtend(localException);
    boolean bool = false;
    if (localBluetoothDeviceExtend != null)
    {
      bool = localBluetoothDeviceExtend.disconnectGatt();
      if (bool) {}
    }
    else
    {
      throw new Exception("closeBLEConnection fail! deviceExtend=" + localBluetoothDeviceExtend + ",disconnect=" + bool);
    }
    parambgok.a();
  }
  
  @TargetApi(18)
  private void closeBluetoothAdapter(bgok parambgok)
  {
    QMLog.d("BluetoothJsPlugin", "closeBluetoothAdapter callbackId=" + parambgok.jdField_b_of_type_Int);
    try
    {
      closeAdapter();
      parambgok.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      parambgok.b();
    }
  }
  
  @TargetApi(18)
  private void createBLEConnection(bgok parambgok)
  {
    QMLog.d("BluetoothJsPlugin", "createBLEConnection jsonParams=" + parambgok.jdField_b_of_type_JavaLangString + ",callbackId=" + parambgok.jdField_b_of_type_Int);
    long l;
    try
    {
      Object localObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      String str = ((JSONObject)localObject1).getString("deviceId");
      l = ((JSONObject)localObject1).optLong("timeout", 0L);
      Object localObject2 = null;
      localObject1 = localObject2;
      if (this.mBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = findBluetoothDeviceExtend(str);
          if (localObject1 != null) {
            break label172;
          }
        }
      }
      throw new Exception("createBLEConnection fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + localObject1);
    }
    catch (Exception localException)
    {
      parambgok.b();
      return;
    }
    label172:
    localException.connectGatt(this.mActivity, false, l, parambgok.jdField_b_of_type_Int);
  }
  
  private static byte[] extractBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  private BluetoothJsPlugin.BluetoothDeviceExtend findBluetoothDeviceExtend(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return (BluetoothJsPlugin.BluetoothDeviceExtend)this.allFoundDevices.get(paramString);
  }
  
  @TargetApi(18)
  private void getBLEDeviceCharacteristics(bgok parambgok)
  {
    Object localObject4;
    try
    {
      Object localObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      localObject3 = ((JSONObject)localObject1).getString("deviceId");
      localObject4 = ((JSONObject)localObject1).getString("serviceId");
      localObject2 = null;
      localObject1 = localObject2;
      if (this.mBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty((CharSequence)localObject3))
        {
          localObject2 = findBluetoothDeviceExtend((String)localObject3);
          localObject1 = localObject2;
          if (localObject2 != null)
          {
            if (((BluetoothJsPlugin.BluetoothDeviceExtend)localObject2).services != null) {
              break label147;
            }
            localObject1 = localObject2;
          }
        }
      }
      throw new Exception("getBLEDeviceCharacteristics fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject3 + ",deviceExtend=" + localObject1);
    }
    catch (Exception localException)
    {
      parambgok.b();
      return;
    }
    label147:
    JSONArray localJSONArray = new JSONArray();
    Object localObject3 = new JSONObject();
    Object localObject2 = ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject2).services.iterator();
    Object localObject5;
    JSONObject localJSONObject;
    while (((Iterator)localObject2).hasNext())
    {
      localObject5 = (BluetoothGattService)((Iterator)localObject2).next();
      if (((String)localObject4).equalsIgnoreCase(((BluetoothGattService)localObject5).getUuid().toString()))
      {
        localObject2 = ((BluetoothGattService)localObject5).getCharacteristics().iterator();
        if (((Iterator)localObject2).hasNext())
        {
          localObject4 = (BluetoothGattCharacteristic)((Iterator)localObject2).next();
          localObject5 = new JSONObject();
          ((JSONObject)localObject5).put("uuid", ((BluetoothGattCharacteristic)localObject4).getUuid().toString());
          localJSONObject = new JSONObject();
          int i = ((BluetoothGattCharacteristic)localObject4).getProperties();
          if ((i & 0x2) <= 0) {
            break label435;
          }
          bool = true;
          label298:
          localJSONObject.put("read", bool);
          if ((i & 0x8) <= 0) {
            break label440;
          }
          bool = true;
          label317:
          localJSONObject.put("write", bool);
          if ((i & 0x10) <= 0) {
            break label445;
          }
          bool = true;
          label336:
          localJSONObject.put("notify", bool);
          if ((i & 0x20) <= 0) {
            break label450;
          }
        }
      }
    }
    label435:
    label440:
    label445:
    label450:
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("indicate", bool);
      ((JSONObject)localObject5).put("properties", localJSONObject);
      localJSONArray.put(localObject5);
      break;
      QMLog.d("BluetoothJsPlugin", "getBLEDeviceCharacteristics characteristics=" + localJSONArray.toString());
      ((JSONObject)localObject3).put("characteristics", localJSONArray);
      parambgok.a((JSONObject)localObject3);
      return;
      bool = false;
      break label298;
      bool = false;
      break label317;
      bool = false;
      break label336;
    }
  }
  
  @TargetApi(18)
  private void getBLEDeviceServices(bgok parambgok)
  {
    try
    {
      String str = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).getString("deviceId");
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.mBluetoothAdapter != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(str))
        {
          localObject1 = findBluetoothDeviceExtend(str);
          if (localObject1 != null) {
            break label108;
          }
        }
      }
      throw new Exception("getBLEDeviceServices fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + localObject1);
    }
    catch (Exception localException)
    {
      parambgok.b();
      return;
    }
    label108:
    localException.getServices(parambgok);
  }
  
  private void getBluetoothAdapterState(bgok parambgok)
  {
    QMLog.d("BluetoothJsPlugin", "getBluetoothAdapterState callbackId=" + parambgok.jdField_b_of_type_Int);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.mBluetoothAdapter == null) {
        throw new RuntimeException("getBluetoothAdapterState fail, mBluetoothAdapter is null");
      }
    }
    catch (Exception localException)
    {
      parambgok.b();
      return;
    }
    localException.put("available", this.mBluetoothAdapter.isEnabled());
    localException.put("discovering", BluetoothJsPlugin.BLEScan.access$300(this.bleScan));
    parambgok.a();
  }
  
  private void getBluetoothDevices(bgok parambgok)
  {
    QMLog.d("BluetoothJsPlugin", "getBluetoothDevices callbackId=" + parambgok.jdField_b_of_type_Int);
    JSONArray localJSONArray;
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      localJSONArray = new JSONArray();
      synchronized (this.allFoundDevices)
      {
        Iterator localIterator = this.allFoundDevices.values().iterator();
        if (localIterator.hasNext()) {
          localJSONArray.put(((BluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next()).toJson());
        }
      }
    }
    catch (JSONException localJSONException)
    {
      parambgok.b();
      return;
    }
    localJSONObject2.put("devices", localJSONArray);
    parambgok.a(localJSONObject2);
  }
  
  @TargetApi(18)
  private void getConnectedBluetoothDevices(bgok parambgok)
  {
    int j = 0;
    QMLog.d("BluetoothJsPlugin", "getConnectedBluetoothDevices jsonParams=" + parambgok.jdField_b_of_type_JavaLangString + ",callbackId=" + parambgok.jdField_b_of_type_Int);
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString).optJSONArray("services");
        JSONArray localJSONArray = new JSONArray();
        if (localObject2 != null)
        {
          i = ((JSONArray)localObject2).length();
          if (i >= 1) {
            break;
          }
          throw new RuntimeException("params services is empty!");
        }
      }
      catch (Exception localException)
      {
        parambgok.b();
        return;
      }
      i = 0;
    }
    Object localObject1 = new ArrayList();
    for (;;)
    {
      Object localObject3;
      if (j < i)
      {
        localObject3 = parseUuidFromStr(((JSONArray)localObject2).getString(j));
        if (localObject3 != null) {
          ((List)localObject1).add(localObject3);
        }
      }
      else
      {
        localObject2 = this.allFoundDevices.values().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (BluetoothJsPlugin.BluetoothDeviceExtend)((Iterator)localObject2).next();
          if ((((BluetoothJsPlugin.BluetoothDeviceExtend)localObject3).state == 2) && (((BluetoothJsPlugin.BluetoothDeviceExtend)localObject3).containsUUID((List)localObject1)))
          {
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.putOpt("name", ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject3).getDeviceName());
            localJSONObject.put("deviceId", ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject3).mDevicesId);
            localException.put(localJSONObject);
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("devices", localException);
        parambgok.a((JSONObject)localObject1);
        return;
      }
      j += 1;
    }
  }
  
  @TargetApi(18)
  private void notifyBLECharacteristicValueChange(bgok parambgok)
  {
    label204:
    label337:
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      String str;
      try
      {
        Object localObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
        localObject3 = ((JSONObject)localObject1).getString("deviceId");
        localObject2 = ((JSONObject)localObject1).getString("serviceId");
        str = ((JSONObject)localObject1).getString("characteristicId");
        bool = ((JSONObject)localObject1).getBoolean("state");
        localIterator = null;
        localObject1 = localIterator;
        if (this.mBluetoothAdapter != null)
        {
          localObject1 = localIterator;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = localIterator;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localIterator;
              if (!TextUtils.isEmpty(str))
              {
                localObject1 = localIterator;
                if (!TextUtils.isEmpty(str))
                {
                  localObject1 = findBluetoothDeviceExtend((String)localObject3);
                  if (localObject1 == null) {
                    break label337;
                  }
                  if (((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).services != null) {
                    break label204;
                  }
                  break label337;
                }
              }
            }
          }
        }
        throw new Exception("notifyBLECharacteristicValueChange fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject3 + ",serviceId=" + (String)localObject2 + ",characteristicId=" + str + ",deviceExtend=" + localObject1);
      }
      catch (Exception localException)
      {
        parambgok.b();
        return;
      }
      Iterator localIterator = localException.services.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (BluetoothGattService)localIterator.next();
        if (((String)localObject2).equalsIgnoreCase(((BluetoothGattService)localObject3).getUuid().toString()))
        {
          localIterator = ((BluetoothGattService)localObject3).getCharacteristics().iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject2 = (BluetoothGattCharacteristic)localIterator.next();
          } while (!str.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString()));
        }
      }
      for (boolean bool = localException.notifyBLECharacteristicValueChange((BluetoothGattCharacteristic)localObject2, bool);; bool = false)
      {
        if (bool)
        {
          parambgok.a();
          return;
        }
        throw new RuntimeException("notifyBLECharacteristicValueChange fail!");
      }
    }
  }
  
  private void notifyBluetoothStateChange()
  {
    QMLog.d("BluetoothJsPlugin", "notifyBluetoothStateChange");
    if (this.mBluetoothStateReceiver != null) {
      this.mBluetoothStateReceiver.onReceive(this.mActivity, new Intent("android.bluetooth.adapter.action.STATE_CHANGED"));
    }
  }
  
  private BluetoothJsPlugin.BluetoothDeviceExtend parseFromBytes(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    paramBluetoothDevice = new BluetoothJsPlugin.BluetoothDeviceExtend(this, paramBluetoothDevice, paramInt, paramArrayOfByte);
    paramInt = 0;
    try
    {
      if (paramInt >= paramArrayOfByte.length) {
        break label231;
      }
      j = paramInt + 1;
      paramInt = paramArrayOfByte[paramInt] & 0xFF;
      if (paramInt != 0) {
        break label233;
      }
    }
    catch (Exception paramBluetoothDevice)
    {
      QMLog.e("BluetoothJsPlugin", "unable to parse scan record:", paramBluetoothDevice);
      return null;
    }
    parseServiceUuid(paramArrayOfByte, i, paramInt, 16, paramBluetoothDevice.mServiceUuids);
    break label356;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 32, paramBluetoothDevice.mServiceUuids);
    break label356;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 128, paramBluetoothDevice.mServiceUuids);
    break label356;
    paramBluetoothDevice.localName = new String(extractBytes(paramArrayOfByte, i, paramInt));
    break label356;
    Object localObject = parseUuidFromByte(extractBytes(paramArrayOfByte, i, 16));
    byte[] arrayOfByte = extractBytes(paramArrayOfByte, i + 16, paramInt - 16);
    paramBluetoothDevice.serviceData.put(localObject, arrayOfByte);
    break label356;
    int j = paramArrayOfByte[(i + 1)];
    int k = paramArrayOfByte[i];
    localObject = extractBytes(paramArrayOfByte, i + 2, paramInt - 2);
    paramBluetoothDevice.manufacturerData.put(((j & 0xFF) << 8) + (k & 0xFF), localObject);
    break label356;
    label231:
    return paramBluetoothDevice;
    label233:
    paramInt -= 1;
    int i = j + 1;
    switch (paramArrayOfByte[j] & 0xFF)
    {
    }
    for (;;)
    {
      label356:
      paramInt += i;
      break;
      j = paramArrayOfByte[i];
      continue;
      j = paramArrayOfByte[i];
    }
  }
  
  private static int parseServiceUuid(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    while (paramInt2 > 0)
    {
      paramList.add(parseUuidFromByte(extractBytes(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    return paramInt1;
  }
  
  private static ParcelUuid parseUuidFromByte(byte[] paramArrayOfByte)
  {
    return new ParcelUuid(UUID.nameUUIDFromBytes(paramArrayOfByte));
  }
  
  private static ParcelUuid parseUuidFromStr(String paramString)
  {
    if ((paramString == null) || (paramString.isEmpty())) {
      return null;
    }
    for (;;)
    {
      try
      {
        switch (paramString.length())
        {
        case 4: 
          return ParcelUuid.fromString(paramString);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
      return ParcelUuid.fromString("0000" + paramString + "-0000-1000-8000-00805F9B34FB");
      paramString = ParcelUuid.fromString(paramString + "-0000-1000-8000-00805F9B34FB");
      return paramString;
    }
  }
  
  @TargetApi(18)
  private void readBLECharacteristicValue(bgok parambgok)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
      localObject1 = ((JSONObject)localObject2).getString("deviceId");
      String str = ((JSONObject)localObject2).getString("serviceId");
      localObject2 = ((JSONObject)localObject2).getString("characteristicId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break label145;
      }
      throw new Exception("readBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject1 + ",characteristicId=" + (String)localObject2 + ",deviceExtend=" + null);
    }
    catch (Exception localException)
    {
      i = 10008;
    }
    if (i == 0)
    {
      parambgok.a(localJSONObject);
      return;
      label145:
      if (!this.isSupportBlueTooth) {
        i = 10009;
      }
    }
    for (;;)
    {
      localJSONObject.put("errCode", i);
      break;
      if (this.mBluetoothAdapter == null)
      {
        i = 10000;
      }
      else if (!this.mBluetoothAdapter.isEnabled())
      {
        i = 10001;
      }
      else
      {
        localObject1 = findBluetoothDeviceExtend((String)localObject1);
        if (localObject1 == null)
        {
          i = 10002;
        }
        else if (((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).services == null)
        {
          i = 10004;
        }
        else
        {
          Iterator localIterator = ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).services.iterator();
          BluetoothGattCharacteristic localBluetoothGattCharacteristic;
          while (localIterator.hasNext())
          {
            BluetoothGattService localBluetoothGattService = (BluetoothGattService)localIterator.next();
            if (localException.equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
            {
              localIterator = localBluetoothGattService.getCharacteristics().iterator();
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)localIterator.next();
              } while (!((String)localObject2).equalsIgnoreCase(localBluetoothGattCharacteristic.getUuid().toString()));
            }
          }
          while (localBluetoothGattCharacteristic != null)
          {
            i = ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).readCharacteristic(localBluetoothGattCharacteristic);
            break;
            parambgok.a(localJSONObject, null);
            return;
            localBluetoothGattCharacteristic = null;
          }
          i = 10005;
        }
      }
    }
  }
  
  private void registerBluetoothStateReceiver()
  {
    QMLog.d("BluetoothJsPlugin", "registerBluetoothStateReceiver sIsReceiverRegister=" + this.sIsReceiverRegister);
    if (!this.sIsReceiverRegister)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      this.mActivity.registerReceiver(this.mBluetoothStateReceiver, localIntentFilter);
      this.sIsReceiverRegister = true;
    }
  }
  
  private void startBluetoothDevicesDiscovery(bgok parambgok)
  {
    long l1 = 500L;
    int i = 0;
    QMLog.d("BluetoothJsPlugin", "startBluetoothDevicesDiscovery jsonParams=" + parambgok.jdField_b_of_type_JavaLangString + ",callbackId=" + parambgok.jdField_b_of_type_Int);
    if ((this.mBluetoothAdapter == null) || (BluetoothJsPlugin.BLEScan.access$300(this.bleScan)))
    {
      parambgok.b();
      return;
    }
    for (;;)
    {
      long l2;
      try
      {
        Object localObject2 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
        Object localObject1 = ((JSONObject)localObject2).optJSONArray("services");
        boolean bool = ((JSONObject)localObject2).optBoolean("allowDuplicatesKey", false);
        l2 = ((JSONObject)localObject2).optLong("interval", 0L);
        if (l2 >= 500L) {
          break label277;
        }
        localObject2 = new ArrayList();
        if ((localObject1 != null) && (i < ((JSONArray)localObject1).length()))
        {
          ParcelUuid localParcelUuid = parseUuidFromStr(((JSONArray)localObject1).optString(i));
          if (localParcelUuid == null) {
            break label283;
          }
          ((ArrayList)localObject2).add(localParcelUuid.getUuid());
          break label283;
        }
        if (this.bleScan.startDiscovery(this.mBluetoothAdapter, (UUID[])((ArrayList)localObject2).toArray(new UUID[0]), bool, l1))
        {
          localObject1 = new JSONObject();
          try
          {
            ((JSONObject)localObject1).put("available", this.mBluetoothAdapter.isEnabled());
            ((JSONObject)localObject1).put("discovering", BluetoothJsPlugin.BLEScan.access$300(this.bleScan));
            parambgok.a((JSONObject)localObject1);
            return;
          }
          catch (JSONException localJSONException)
          {
            parambgok.b();
            return;
          }
        }
        parambgok.b();
      }
      catch (Exception localException)
      {
        parambgok.b();
        return;
      }
      return;
      label277:
      l1 = l2;
      continue;
      label283:
      i += 1;
    }
  }
  
  private void stopBluetoothDevicesDiscovery(bgok parambgok)
  {
    QMLog.d("BluetoothJsPlugin", "stopBluetoothDevicesDiscovery callbackId=" + parambgok.jdField_b_of_type_Int);
    if (this.mBluetoothAdapter == null)
    {
      parambgok.b();
      return;
    }
    this.bleScan.stopDiscovery("stopBluetoothDevicesDiscovery");
    parambgok.a();
  }
  
  private void unregisterBluetoothStateReceiver()
  {
    QMLog.d("BluetoothJsPlugin", "unregisterBluetoothStateReceiver");
    if ((this.sIsReceiverRegister) && (this.mBluetoothStateReceiver != null))
    {
      this.mActivity.unregisterReceiver(this.mBluetoothStateReceiver);
      this.sIsReceiverRegister = false;
    }
  }
  
  @TargetApi(18)
  private void writeBLECharacteristicValue(bgok parambgok)
  {
    label205:
    label349:
    for (;;)
    {
      Object localObject3;
      Object localObject2;
      String str1;
      String str2;
      try
      {
        Object localObject1 = new JSONObject(parambgok.jdField_b_of_type_JavaLangString);
        localObject3 = ((JSONObject)localObject1).getString("deviceId");
        localObject2 = ((JSONObject)localObject1).getString("serviceId");
        str1 = ((JSONObject)localObject1).getString("characteristicId");
        str2 = ((JSONObject)localObject1).getString("value");
        localIterator = null;
        localObject1 = localIterator;
        if (this.mBluetoothAdapter != null)
        {
          localObject1 = localIterator;
          if (!TextUtils.isEmpty((CharSequence)localObject3))
          {
            localObject1 = localIterator;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              localObject1 = localIterator;
              if (!TextUtils.isEmpty(str1))
              {
                localObject1 = localIterator;
                if (!TextUtils.isEmpty(str1))
                {
                  localObject1 = findBluetoothDeviceExtend((String)localObject3);
                  if (localObject1 == null) {
                    break label349;
                  }
                  if (((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).services != null) {
                    break label205;
                  }
                  break label349;
                }
              }
            }
          }
        }
        throw new Exception("writeBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject3 + ",serviceId=" + (String)localObject2 + ",characteristicId=" + str1 + ",deviceExtend=" + localObject1);
      }
      catch (Exception localException)
      {
        parambgok.b();
        return;
      }
      Iterator localIterator = localException.services.iterator();
      while (localIterator.hasNext())
      {
        localObject3 = (BluetoothGattService)localIterator.next();
        if (((String)localObject2).equalsIgnoreCase(((BluetoothGattService)localObject3).getUuid().toString()))
        {
          localIterator = ((BluetoothGattService)localObject3).getCharacteristics().iterator();
          while (localIterator.hasNext())
          {
            localObject2 = (BluetoothGattCharacteristic)localIterator.next();
            if (str1.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString())) {
              ((BluetoothGattCharacteristic)localObject2).setValue(Base64.decode(str2, 2));
            }
          }
        }
      }
      for (boolean bool = localException.writeCharacteristic((BluetoothGattCharacteristic)localObject2);; bool = false)
      {
        if (bool)
        {
          parambgok.a();
          return;
        }
        throw new RuntimeException("writeBLECharacteristicValue fail!");
      }
    }
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    this.mActivity = parambglv.a();
  }
  
  public void onDestroy()
  {
    try
    {
      closeAdapter();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void openBluetoothAdapter(bgok parambgok)
  {
    if (this.mActivity == null)
    {
      QMLog.d("BluetoothJsPlugin", "Failed to openBluetoothAdapter. Activity is null. callbackId=" + parambgok.jdField_b_of_type_Int);
      return;
    }
    QMLog.d("BluetoothJsPlugin", "openBluetoothAdapter callbackId=" + parambgok.jdField_b_of_type_Int);
    this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((!this.mActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) || (this.mBluetoothAdapter == null) || (this.isSettingBlueTooth))
    {
      parambgok.b();
      return;
    }
    registerBluetoothStateReceiver();
    if (this.mBluetoothAdapter.isEnabled())
    {
      parambgok.a();
      return;
    }
    this.isSettingBlueTooth = true;
    bgnk.a().a(new BluetoothJsPlugin.1(this, parambgok));
    parambgok = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
    this.mActivity.startActivityForResult(parambgok, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BluetoothJsPlugin
 * JD-Core Version:    0.7.0.1
 */