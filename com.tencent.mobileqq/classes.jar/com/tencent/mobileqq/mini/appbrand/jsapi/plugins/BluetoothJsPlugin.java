package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

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
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BluetoothJsPlugin
  extends BaseJsPlugin
  implements Handler.Callback
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
  private static final String EVENT_CLOSE_BLE_CONNECTION = "closeBLEConnection";
  private static final String EVENT_CLOSE_BLUETOOTH_ADAPTER = "closeBluetoothAdapter";
  private static final String EVENT_CREATE_BLE_CONNECTION = "createBLEConnection";
  private static final String EVENT_GET_BLE_DEVICE_CHARACTERISTICS = "getBLEDeviceCharacteristics";
  private static final String EVENT_GET_BLE_DEVICE_SERVICES = "getBLEDeviceServices";
  private static final String EVENT_GET_BLUETOOTH_ADAPTER_STATE = "getBluetoothAdapterState";
  private static final String EVENT_GET_BLUETOOTH_DEVICES = "getBluetoothDevices";
  private static final String EVENT_GET_CONNECCTED_BLUETOOTH_DEVICES = "getConnectedBluetoothDevices";
  private static final String EVENT_NOTIFY_BLE_CHARACTERISTICS_VALUE_CHANGE = "notifyBLECharacteristicValueChange";
  private static final String EVENT_OPEN_BLUETOOTH_ADAPTER = "openBluetoothAdapter";
  private static final String EVENT_READ_BLE_CHARACTERISTICS_VALUE = "readBLECharacteristicValue";
  private static final String EVENT_START_BLUETOOTH_DEVICES_DISCOVERY = "startBluetoothDevicesDiscovery";
  private static final String EVENT_STOP_BLUETOOTH_DEVICES_DISCOVERY = "stopBluetoothDevicesDiscovery";
  private static final String EVENT_WRITE_BLE_CHARACTERISTICS_VALUE = "writeBLECharacteristicValue";
  private static final long FOUND_DEVICES_DEFAULT_INTERVAL = 500L;
  private static final long SCAN_MAX_TIME = 15000L;
  public static final String TAG = "[mini] BluetoothJsPlugin";
  private static final int UUID_BYTES_128_BIT = 128;
  private static final int UUID_BYTES_16_BIT = 16;
  private static final int UUID_BYTES_32_BIT = 32;
  private static final int WHAT_SCAN_CALLBACK = 2;
  private static final int WHAT_SCAN_TIMEOUT = 1;
  private HashMap<String, BluetoothJsPlugin.BluetoothDeviceExtend> allFoundDevices = new HashMap();
  private BluetoothJsPlugin.BLEScan bleScan = new BluetoothJsPlugin.BLEScan(this);
  private final Set<String> eventMap = new HashSet();
  private boolean isSettingBlueTooth;
  private boolean isSupportBlueTooth;
  private Activity mActivity;
  private BluetoothAdapter mBluetoothAdapter;
  BroadcastReceiver mBluetoothStateReceiver = new BluetoothJsPlugin.2(this);
  private boolean sIsReceiverRegister;
  private Handler subHandler;
  
  public BluetoothJsPlugin()
  {
    this.eventMap.add("openBluetoothAdapter");
    this.eventMap.add("closeBluetoothAdapter");
    this.eventMap.add("getBluetoothAdapterState");
    this.eventMap.add("startBluetoothDevicesDiscovery");
    this.eventMap.add("stopBluetoothDevicesDiscovery");
    this.eventMap.add("getBluetoothDevices");
    this.eventMap.add("getConnectedBluetoothDevices");
    this.eventMap.add("createBLEConnection");
    this.eventMap.add("closeBLEConnection");
    this.eventMap.add("getBLEDeviceServices");
    this.eventMap.add("getBLEDeviceCharacteristics");
    this.eventMap.add("readBLECharacteristicValue");
    this.eventMap.add("writeBLECharacteristicValue");
    this.eventMap.add("notifyBLECharacteristicValueChange");
    HandlerThread localHandlerThread = new HandlerThread("HandlerThread");
    localHandlerThread.start();
    this.subHandler = new Handler(localHandlerThread.getLooper(), this);
  }
  
  private void closeAdapter()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "closeAdapter......");
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
      throw new MiniAppException("closeAdapter fail, mBluetoothAdapter.disable fail");
    }
    unregisterBluetoothStateReceiver();
    this.mBluetoothStateReceiver = null;
    this.mBluetoothAdapter = null;
    this.isSettingBlueTooth = false;
  }
  
  @TargetApi(18)
  private void closeBLEConnection(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString2 = new JSONObject(paramString2).getString("deviceId");
      if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(paramString2))) {
        throw new Exception("closeBLEConnection fail, mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + paramString2);
      }
    }
    catch (Exception paramString2)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      return;
    }
    paramString2 = findBluetoothDeviceExtend(paramString2);
    boolean bool = false;
    if (paramString2 != null)
    {
      bool = paramString2.disconnectGatt();
      if (bool) {}
    }
    else
    {
      throw new Exception("closeBLEConnection fail! deviceExtend=" + paramString2 + ",disconnect=" + bool);
    }
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
  }
  
  @TargetApi(18)
  private void closeBluetoothAdapter(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "closeBluetoothAdapter callbackId=" + paramInt);
    try
    {
      closeAdapter();
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
    }
  }
  
  @TargetApi(18)
  private void createBLEConnection(String paramString1, String paramString2, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "createBLEConnection jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    for (;;)
    {
      long l;
      try
      {
        paramString2 = new JSONObject(paramString2);
        String str = paramString2.getString("deviceId");
        l = paramString2.optLong("timeout", 0L);
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(str))) {
          break label174;
        }
        paramString2 = findBluetoothDeviceExtend(str);
        if (paramString2 == null) {
          throw new Exception("createBLEConnection fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + paramString2);
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      paramString2.connectGatt(this.mActivity, false, l, paramInt);
      return;
      label174:
      paramString2 = null;
    }
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
  private void getBLEDeviceCharacteristics(String paramString1, String paramString2, int paramInt)
  {
    Object localObject3;
    try
    {
      paramString2 = new JSONObject(paramString2);
      localObject2 = paramString2.getString("deviceId");
      localObject3 = paramString2.getString("serviceId");
      if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty((CharSequence)localObject2))) {
        break label449;
      }
      localObject1 = findBluetoothDeviceExtend((String)localObject2);
      paramString2 = (String)localObject1;
      if (localObject1 != null)
      {
        if (((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).services == null) {
          paramString2 = (String)localObject1;
        }
      }
      else {
        throw new Exception("getBLEDeviceCharacteristics fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject2 + ",deviceExtend=" + paramString2);
      }
    }
    catch (Exception paramString2)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      return;
    }
    paramString2 = new JSONArray();
    Object localObject2 = new JSONObject();
    Object localObject1 = ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).services.iterator();
    Object localObject4;
    label219:
    JSONObject localJSONObject;
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (BluetoothGattService)((Iterator)localObject1).next();
      if (((String)localObject3).equalsIgnoreCase(((BluetoothGattService)localObject4).getUuid().toString()))
      {
        localObject1 = ((BluetoothGattService)localObject4).getCharacteristics().iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject3 = (BluetoothGattCharacteristic)((Iterator)localObject1).next();
          localObject4 = new JSONObject();
          ((JSONObject)localObject4).put("uuid", ((BluetoothGattCharacteristic)localObject3).getUuid().toString());
          localJSONObject = new JSONObject();
          int i = ((BluetoothGattCharacteristic)localObject3).getProperties();
          if ((i & 0x2) <= 0) {
            break label454;
          }
          bool = true;
          label293:
          localJSONObject.put("read", bool);
          if ((i & 0x8) <= 0) {
            break label460;
          }
          bool = true;
          label315:
          localJSONObject.put("write", bool);
          if ((i & 0x10) <= 0) {
            break label466;
          }
          bool = true;
          label337:
          localJSONObject.put("notify", bool);
          if ((i & 0x20) <= 0) {
            break label472;
          }
        }
      }
    }
    label449:
    label454:
    label460:
    label466:
    label472:
    for (boolean bool = true;; bool = false)
    {
      localJSONObject.put("indicate", bool);
      ((JSONObject)localObject4).put("properties", localJSONObject);
      paramString2.put(localObject4);
      break label219;
      QLog.d("[mini] BluetoothJsPlugin", 2, "getBLEDeviceCharacteristics characteristics=" + paramString2.toString());
      ((JSONObject)localObject2).put("characteristics", paramString2);
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, (JSONObject)localObject2, paramInt);
      return;
      paramString2 = null;
      break;
      bool = false;
      break label293;
      bool = false;
      break label315;
      bool = false;
      break label337;
    }
  }
  
  @TargetApi(18)
  private void getBLEDeviceServices(String paramString1, String paramString2, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str = new JSONObject(paramString2).getString("deviceId");
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty(str))) {
          break label119;
        }
        paramString2 = findBluetoothDeviceExtend(str);
        if (paramString2 == null) {
          throw new Exception("getBLEDeviceServices fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + str + ",deviceExtend=" + paramString2);
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      paramString2.getServices(paramInt);
      return;
      label119:
      paramString2 = null;
    }
  }
  
  private void getBluetoothAdapterState(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "getBluetoothAdapterState callbackId=" + paramInt);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      if (this.mBluetoothAdapter == null) {
        throw new MiniAppException("getBluetoothAdapterState fail, mBluetoothAdapter is null");
      }
    }
    catch (Exception localException)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    localException.put("available", this.mBluetoothAdapter.isEnabled());
    localException.put("discovering", BluetoothJsPlugin.BLEScan.access$000(this.bleScan));
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, localException, paramInt);
  }
  
  private void getBluetoothDevices(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "getBluetoothDevices callbackId=" + paramInt);
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
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    localJSONObject2.put("devices", localJSONArray);
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, localJSONObject2, paramInt);
  }
  
  @TargetApi(18)
  private void getConnectedBluetoothDevices(String paramString1, String paramString2, int paramInt)
  {
    int j = 0;
    QLog.d("[mini] BluetoothJsPlugin", 2, "getConnectedBluetoothDevices jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    Object localObject2;
    int i;
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject(paramString2).optJSONArray("services");
        paramString2 = new JSONArray();
        if (localObject2 != null)
        {
          i = ((JSONArray)localObject2).length();
          if (i >= 1) {
            break;
          }
          throw new MiniAppException("params services is empty!");
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
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
            paramString2.put(localJSONObject);
          }
        }
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("devices", paramString2);
        this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, (JSONObject)localObject1, paramInt);
        return;
      }
      j += 1;
    }
  }
  
  @TargetApi(18)
  private void notifyBLECharacteristicValueChange(String paramString1, String paramString2, int paramInt)
  {
    label198:
    label347:
    label352:
    for (;;)
    {
      Object localObject1;
      String str;
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject2 = paramString2.getString("deviceId");
        localObject1 = paramString2.getString("serviceId");
        str = paramString2.getString("characteristicId");
        bool = paramString2.getBoolean("state");
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str)) || (TextUtils.isEmpty(str))) {
          break label347;
        }
        paramString2 = findBluetoothDeviceExtend((String)localObject2);
        if (paramString2 == null) {
          break label352;
        }
        if (paramString2.services != null) {
          break label198;
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      throw new Exception("notifyBLECharacteristicValueChange fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject2 + ",serviceId=" + (String)localObject1 + ",characteristicId=" + str + ",deviceExtend=" + paramString2);
      Object localObject2 = paramString2.services.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        if (((String)localObject1).equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
        {
          localObject1 = localBluetoothGattService.getCharacteristics().iterator();
          do
          {
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            localObject2 = (BluetoothGattCharacteristic)((Iterator)localObject1).next();
          } while (!str.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString()));
        }
      }
      for (boolean bool = paramString2.notifyBLECharacteristicValueChange((BluetoothGattCharacteristic)localObject2, bool);; bool = false)
      {
        if (bool)
        {
          this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
          return;
        }
        throw new MiniAppException("notifyBLECharacteristicValueChange fail!");
      }
      paramString2 = null;
    }
  }
  
  private void notifyBluetoothStateChange()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "notifyBluetoothStateChange");
    if (this.mBluetoothStateReceiver != null) {
      this.mBluetoothStateReceiver.onReceive(this.mActivity, new Intent("android.bluetooth.adapter.action.STATE_CHANGED"));
    }
  }
  
  private void openBluetoothAdapter(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "openBluetoothAdapter callbackId=" + paramInt);
    this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    if ((!this.mActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) || (this.mBluetoothAdapter == null) || (this.isSettingBlueTooth))
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    registerBluetoothStateReceiver();
    if (this.mBluetoothAdapter.isEnabled())
    {
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    this.isSettingBlueTooth = true;
    MiniAppController.getInstance().setActivityResultListener(new BluetoothJsPlugin.1(this, paramString, paramInt));
    paramString = new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE");
    this.mActivity.startActivityForResult(paramString, 6);
  }
  
  private BluetoothJsPlugin.BluetoothDeviceExtend parseFromBytes(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    do
    {
      return null;
      paramBluetoothDevice = new BluetoothJsPlugin.BluetoothDeviceExtend(this, paramBluetoothDevice, paramInt, paramArrayOfByte);
      paramInt = 0;
      try
      {
        if (paramInt >= paramArrayOfByte.length) {
          break;
        }
        j = paramInt + 1;
        paramInt = paramArrayOfByte[paramInt] & 0xFF;
        if (paramInt != 0) {
          break label240;
        }
      }
      catch (Exception paramBluetoothDevice) {}
      parseServiceUuid(paramArrayOfByte, i, paramInt, 16, paramBluetoothDevice.mServiceUuids);
      break label364;
    } while (!QLog.isColorLevel());
    QLog.e("[mini] BluetoothJsPlugin", 4, "unable to parse scan record:", paramBluetoothDevice);
    return null;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 32, paramBluetoothDevice.mServiceUuids);
    break label364;
    parseServiceUuid(paramArrayOfByte, i, paramInt, 128, paramBluetoothDevice.mServiceUuids);
    break label364;
    paramBluetoothDevice.localName = new String(extractBytes(paramArrayOfByte, i, paramInt));
    break label364;
    Object localObject = parseUuidFromByte(extractBytes(paramArrayOfByte, i, 16));
    byte[] arrayOfByte = extractBytes(paramArrayOfByte, i + 16, paramInt - 16);
    paramBluetoothDevice.serviceData.put(localObject, arrayOfByte);
    break label364;
    int j = paramArrayOfByte[(i + 1)];
    int k = paramArrayOfByte[i];
    localObject = extractBytes(paramArrayOfByte, i + 2, paramInt - 2);
    paramBluetoothDevice.manufacturerData.put(((j & 0xFF) << 8) + (k & 0xFF), localObject);
    break label364;
    return paramBluetoothDevice;
    label240:
    paramInt -= 1;
    int i = j + 1;
    switch (paramArrayOfByte[j] & 0xFF)
    {
    }
    for (;;)
    {
      label364:
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
  private void readBLECharacteristicValue(String paramString1, String paramString2, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    Object localObject2;
    Object localObject1;
    int i;
    try
    {
      localObject2 = new JSONObject(paramString2);
      localObject1 = ((JSONObject)localObject2).getString("deviceId");
      paramString2 = ((JSONObject)localObject2).getString("serviceId");
      localObject2 = ((JSONObject)localObject2).getString("characteristicId");
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2))) {
        break label157;
      }
      throw new Exception("readBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject1 + ",characteristicId=" + (String)localObject2 + ",deviceExtend=" + null);
    }
    catch (Exception paramString2)
    {
      i = 10008;
    }
    if (i == 0)
    {
      this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, localJSONObject, paramInt);
      return;
      label157:
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
          while (localIterator.hasNext())
          {
            BluetoothGattService localBluetoothGattService = (BluetoothGattService)localIterator.next();
            if (paramString2.equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
            {
              localIterator = localBluetoothGattService.getCharacteristics().iterator();
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                paramString2 = (BluetoothGattCharacteristic)localIterator.next();
              } while (!((String)localObject2).equalsIgnoreCase(paramString2.getUuid().toString()));
            }
          }
          while (paramString2 != null)
          {
            i = ((BluetoothJsPlugin.BluetoothDeviceExtend)localObject1).readCharacteristic(paramString2);
            break;
            this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, localJSONObject, paramInt);
            return;
            paramString2 = null;
          }
          i = 10005;
        }
      }
    }
  }
  
  private void registerBluetoothStateReceiver()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "registerBluetoothStateReceiver sIsReceiverRegister=" + this.sIsReceiverRegister);
    if (!this.sIsReceiverRegister)
    {
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.bluetooth.adapter.action.STATE_CHANGED");
      this.mActivity.registerReceiver(this.mBluetoothStateReceiver, localIntentFilter);
      this.sIsReceiverRegister = true;
    }
  }
  
  private void startBluetoothDevicesDiscovery(String paramString1, String paramString2, int paramInt)
  {
    long l1 = 500L;
    int i = 0;
    QLog.d("[mini] BluetoothJsPlugin", 2, "startBluetoothDevicesDiscovery jsonParams=" + paramString2 + ",callbackId=" + paramInt);
    if ((this.mBluetoothAdapter == null) || (BluetoothJsPlugin.BLEScan.access$000(this.bleScan)))
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      return;
    }
    for (;;)
    {
      long l2;
      try
      {
        Object localObject = new JSONObject(paramString2);
        paramString2 = ((JSONObject)localObject).optJSONArray("services");
        boolean bool = ((JSONObject)localObject).optBoolean("allowDuplicatesKey", false);
        l2 = ((JSONObject)localObject).optLong("interval", 0L);
        if (l2 >= 500L) {
          break label323;
        }
        localObject = new ArrayList();
        if ((paramString2 != null) && (i < paramString2.length()))
        {
          ParcelUuid localParcelUuid = parseUuidFromStr(paramString2.optString(i));
          if (localParcelUuid == null) {
            break label330;
          }
          ((ArrayList)localObject).add(localParcelUuid.getUuid());
          break label330;
        }
        if (this.bleScan.startDiscovery(this.mBluetoothAdapter, (UUID[])((ArrayList)localObject).toArray(new UUID[0]), bool, l1))
        {
          paramString2 = new JSONObject();
          try
          {
            paramString2.put("available", this.mBluetoothAdapter.isEnabled());
            paramString2.put("discovering", BluetoothJsPlugin.BLEScan.access$000(this.bleScan));
            this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, paramString2, paramInt);
            return;
          }
          catch (JSONException paramString2)
          {
            this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
            return;
          }
        }
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      return;
      label323:
      l1 = l2;
      continue;
      label330:
      i += 1;
    }
  }
  
  private void stopBluetoothDevicesDiscovery(String paramString, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "stopBluetoothDevicesDiscovery callbackId=" + paramInt);
    if (this.mBluetoothAdapter == null)
    {
      this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
      return;
    }
    this.bleScan.stopDiscovery("stopBluetoothDevicesDiscovery");
    this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString, null, paramInt);
  }
  
  private void unregisterBluetoothStateReceiver()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "unregisterBluetoothStateReceiver");
    if ((this.sIsReceiverRegister) && (this.mBluetoothStateReceiver != null))
    {
      this.mActivity.unregisterReceiver(this.mBluetoothStateReceiver);
      this.sIsReceiverRegister = false;
    }
  }
  
  @TargetApi(18)
  private void writeBLECharacteristicValue(String paramString1, String paramString2, int paramInt)
  {
    label198:
    label357:
    label362:
    for (;;)
    {
      Object localObject1;
      String str1;
      String str2;
      try
      {
        paramString2 = new JSONObject(paramString2);
        localObject2 = paramString2.getString("deviceId");
        localObject1 = paramString2.getString("serviceId");
        str1 = paramString2.getString("characteristicId");
        str2 = paramString2.getString("value");
        if ((this.mBluetoothAdapter == null) || (TextUtils.isEmpty((CharSequence)localObject2)) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str1))) {
          break label357;
        }
        paramString2 = findBluetoothDeviceExtend((String)localObject2);
        if (paramString2 == null) {
          break label362;
        }
        if (paramString2.services != null) {
          break label198;
        }
      }
      catch (Exception paramString2)
      {
        this.jsPluginEngine.callbackJsEventFail(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
        return;
      }
      throw new Exception("writeBLECharacteristicValue fail! mBluetoothAdapter=" + this.mBluetoothAdapter + ",deviceId=" + (String)localObject2 + ",serviceId=" + (String)localObject1 + ",characteristicId=" + str1 + ",deviceExtend=" + paramString2);
      Object localObject2 = paramString2.services.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject2).next();
        if (((String)localObject1).equalsIgnoreCase(localBluetoothGattService.getUuid().toString()))
        {
          localObject1 = localBluetoothGattService.getCharacteristics().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (BluetoothGattCharacteristic)((Iterator)localObject1).next();
            if (str1.equalsIgnoreCase(((BluetoothGattCharacteristic)localObject2).getUuid().toString())) {
              ((BluetoothGattCharacteristic)localObject2).setValue(Base64.decode(str2, 2));
            }
          }
        }
      }
      for (boolean bool = paramString2.writeCharacteristic((BluetoothGattCharacteristic)localObject2);; bool = false)
      {
        if (bool)
        {
          this.jsPluginEngine.callbackJsEventOK(this.jsPluginEngine.getServiceRuntime(), paramString1, null, paramInt);
          return;
        }
        throw new MiniAppException("writeBLECharacteristicValue fail!");
      }
      paramString2 = null;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      this.bleScan.stopDiscovery("timeout");
      continue;
      this.bleScan.onBluetoothDeviceFound();
      if ((BluetoothJsPlugin.BLEScan.access$000(this.bleScan)) && (BluetoothJsPlugin.BLEScan.access$100(this.bleScan) > 0L)) {
        this.subHandler.sendEmptyMessageDelayed(2, BluetoothJsPlugin.BLEScan.access$100(this.bleScan));
      }
    }
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "handleNativeRequest eventName=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("openBluetoothAdapter".equals(paramString1)) {
      openBluetoothAdapter(paramString1, paramInt);
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("closeBluetoothAdapter".equals(paramString1)) {
        closeBluetoothAdapter(paramString1, paramInt);
      } else if ("getBluetoothAdapterState".equals(paramString1)) {
        getBluetoothAdapterState(paramString1, paramInt);
      } else if ("startBluetoothDevicesDiscovery".equals(paramString1)) {
        startBluetoothDevicesDiscovery(paramString1, paramString2, paramInt);
      } else if ("stopBluetoothDevicesDiscovery".equals(paramString1)) {
        stopBluetoothDevicesDiscovery(paramString1, paramInt);
      } else if ("getBluetoothDevices".equals(paramString1)) {
        getBluetoothDevices(paramString1, paramInt);
      } else if ("getConnectedBluetoothDevices".equals(paramString1)) {
        getConnectedBluetoothDevices(paramString1, paramString2, paramInt);
      } else if ("createBLEConnection".equals(paramString1)) {
        createBLEConnection(paramString1, paramString2, paramInt);
      } else if ("closeBLEConnection".equals(paramString1)) {
        closeBLEConnection(paramString1, paramString2, paramInt);
      } else if ("getBLEDeviceServices".equals(paramString1)) {
        getBLEDeviceServices(paramString1, paramString2, paramInt);
      } else if ("getBLEDeviceCharacteristics".equals(paramString1)) {
        getBLEDeviceCharacteristics(paramString1, paramString2, paramInt);
      } else if ("readBLECharacteristicValue".equals(paramString1)) {
        readBLECharacteristicValue(paramString1, paramString2, paramInt);
      } else if ("writeBLECharacteristicValue".equals(paramString1)) {
        writeBLECharacteristicValue(paramString1, paramString2, paramInt);
      } else if ("notifyBLECharacteristicValueChange".equals(paramString1)) {
        notifyBLECharacteristicValueChange(paramString1, paramString2, paramInt);
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    this.mActivity = paramBaseJsPluginEngine.appBrandRuntime.activity;
    this.isSupportBlueTooth = this.mActivity.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
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
  
  public Set<String> supportedEvents()
  {
    return this.eventMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin
 * JD-Core Version:    0.7.0.1
 */