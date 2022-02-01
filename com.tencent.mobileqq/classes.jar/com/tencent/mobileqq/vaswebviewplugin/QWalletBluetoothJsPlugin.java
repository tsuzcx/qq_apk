package com.tencent.mobileqq.vaswebviewplugin;

import android.annotation.TargetApi;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Handler;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QWalletBluetoothJsPlugin
  extends VasWebviewJsPlugin
{
  private static final String BASE_UUID_FORMAT = "%08x-0000-1000-8000-00805F9B34FB";
  private static final String BASE_UUID_SUFFIX = "-0000-1000-8000-00805F9B34FB";
  private static final int BLUETOOTH_CONNECTION_FAIL = 10003;
  private static final int BLUETOOTH_NOT_AVAILABLE = 10001;
  private static final int BLUETOOTH_NOT_INIT = 10000;
  private static final int BLUETOOTH_NO_CHARACTERISTIC = 10005;
  private static final int BLUETOOTH_NO_CONNECTION = 10006;
  private static final int BLUETOOTH_NO_DESCRIPTOR = 10010;
  private static final int BLUETOOTH_NO_DEVICE = 10002;
  private static final int BLUETOOTH_NO_SERVICE = 10004;
  private static final int BLUETOOTH_OK = 0;
  private static final int BLUETOOTH_PROPERTY_NOT_SUPPORT = 10007;
  private static final int BLUETOOTH_SYSTEM_ERROR = 10008;
  private static final int BLUETOOTH_SYS_NOT_SUPPORT = 10009;
  private static final String BROADCAST_ACTION_SCAN_CHANGED = "com.tencent.qwallet.bluetooth.scan.changed";
  private static final String CODE = "code";
  private static final long DISCOVER_SERVICES_TIME_OUT = 15000L;
  private static final String ERR_MSG = "errMsg";
  public static final String PLUGIN_NAMESPACE = "qw_bluetooth";
  private static final byte QWALLET_REQUEST_OPEN_BLUETOOTH = 1;
  private static final String QWB_BIND_ADAPTER_STATE_CHANGE = "onBluetoothAdapterStateChange";
  private static final String QWB_BIND_CONN_STATE_CHANGE = "onBLEConnectionStateChange";
  private static final String QWB_BIND_DEVICE_FOUND = "onBluetoothDeviceFound";
  private static final String QWB_BIND_VALUE_CHANGE = "onBLECharacteristicValueChange";
  private static final String QWB_CLOSE_ADAPTER = "closeBluetoothAdapter";
  private static final String QWB_CLOSE_CONN = "closeBLEConnection";
  private static final String QWB_CREATE_CONN = "createBLEConnection";
  private static final String QWB_GET_ADAPTER_STATE = "getBluetoothAdapterState";
  private static final String QWB_GET_CHARACTS = "getBLEDeviceCharacteristics";
  private static final String QWB_GET_CONN_DEVICES = "getConnectedBluetoothDevices";
  private static final String QWB_GET_DEVICES = "getBluetoothDevices";
  private static final String QWB_GET_SERVICES = "getBLEDeviceServices";
  private static final String QWB_NOTIFY_VALUE_CHANGE = "notifyBLECharacteristicValueChange";
  private static final String QWB_OPEN_ADAPTER = "openBluetoothAdapter";
  private static final String QWB_READ_VALUE = "readBLECharacteristicValue";
  private static final String QWB_START_DEVICE_DISCOVERY = "startBluetoothDevicesDiscovery";
  private static final String QWB_STOP_DEVICE_DISCOVERY = "stopBluetoothDevicesDiscovery";
  private static final String QWB_WRITE_VALUE = "writeBLECharacteristicValue";
  private static final long SCAN_PERIOD = 12000L;
  static final String TAG = "QWBluetoothJsPlugin";
  private static boolean sAvailable;
  private static boolean sDiscovering;
  private static boolean sIsReceiverRegister;
  private Runnable discoverServicesTimeOut;
  private Activity mActivity;
  private BluetoothAdapter mBluetoothAdapter;
  private BluetoothGattCallback mBluetoothGattCallback;
  private ArrayMap<String, BluetoothGatt> mBluetoothGatts;
  private BroadcastReceiver mBluetoothStateReceiver;
  private ArrayMap<String, String> mCallbacks;
  private Set<String> mConnectedDevices;
  private Set<String> mConnectingDevices;
  private Context mContext;
  private List<QWalletBluetoothJsPlugin.BluetoothDeviceExtend> mDevicesFound;
  private BluetoothGattCallback mGetServicesCallback;
  private Handler mHandler;
  private QWalletBluetoothJsPlugin.QWLeScanCallback mLeScanCallback;
  private Runnable stopScan;
  
  public QWalletBluetoothJsPlugin()
  {
    this.mPluginNameSpace = "qw_bluetooth";
  }
  
  private static byte[] base642Bytes(String paramString)
  {
    return Base64.decode(paramString, 2);
  }
  
  private static String bytes2Base64(byte[] paramArrayOfByte)
  {
    return Base64.encodeToString(paramArrayOfByte, 2);
  }
  
  @TargetApi(18)
  private void closeBLEConnection(String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      BluetoothGatt localBluetoothGatt = (BluetoothGatt)this.mBluetoothGatts.get(paramString);
      if (localBluetoothGatt == null)
      {
        localJSONObject.put("code", 10002);
        localJSONObject.put("errMsg", "DeviceId is not found");
      }
      else
      {
        localBluetoothGatt.disconnect();
        localBluetoothGatt.close();
        this.mConnectedDevices.remove(paramString);
        this.mBluetoothGatts.remove(paramString);
        localJSONObject.put("code", 0);
      }
      doCallback("closeBLEConnection", localJSONObject.toString());
      return;
    }
    catch (JSONException paramString) {}
  }
  
  @TargetApi(18)
  private void closeBluetoothAdapter()
  {
    unregisterReceiver();
    Object localObject = this.mBluetoothAdapter;
    if ((localObject != null) && (((BluetoothAdapter)localObject).isDiscovering())) {
      this.mBluetoothAdapter.cancelDiscovery();
    }
    localObject = this.mLeScanCallback;
    if (localObject != null) {
      ((QWalletBluetoothJsPlugin.QWLeScanCallback)localObject).stopTimer();
    }
    localObject = this.mBluetoothGatts.values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      BluetoothGatt localBluetoothGatt = (BluetoothGatt)((Iterator)localObject).next();
      localBluetoothGatt.disconnect();
      localBluetoothGatt.close();
    }
    doCallback("closeBluetoothAdapter", 0, "");
    this.mCallbacks.clear();
    this.mBluetoothGatts.clear();
    this.mConnectingDevices.clear();
    this.mDevicesFound.clear();
    this.mConnectedDevices.clear();
    this.mBluetoothAdapter = null;
  }
  
  @TargetApi(18)
  private void createBLEConnection(String paramString)
  {
    if (this.mBluetoothAdapter.getRemoteDevice(paramString).connectGatt(this.mContext, false, getBluetoothGattCallback()) == null)
    {
      doCallback("createBLEConnection", 10003, "connect failed");
      return;
    }
    this.mConnectingDevices.add(paramString);
  }
  
  private static String createSimpleCallback(int paramInt, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", paramInt);
      localJSONObject.put("errMsg", paramString);
      paramString = localJSONObject.toString();
      return paramString;
    }
    catch (JSONException paramString)
    {
      label31:
      break label31;
    }
    return "{'code':10008,'errMsg':'Parse json error'}";
  }
  
  private void doCallback(String paramString1, int paramInt, String paramString2)
  {
    doCallback(paramString1, createSimpleCallback(paramInt, paramString2));
  }
  
  private void doCallback(String paramString1, String paramString2)
  {
    paramString1 = (String)this.mCallbacks.get(paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      callJs(paramString1, new String[] { paramString2 });
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doCallback: ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("->");
      localStringBuilder.append(paramString2);
      Log.i("QWBluetoothJsPlugin", localStringBuilder.toString());
    }
  }
  
  @TargetApi(18)
  private void getBLEDeviceCharacteristics(String paramString, UUID paramUUID)
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        paramString = getService("getBLEDeviceCharacteristics", paramString, paramUUID);
        if (paramString != null)
        {
          paramUUID = paramString.getCharacteristics();
          int i = paramUUID.size();
          if (i == 0)
          {
            localJSONObject1.put("code", 10005);
            localJSONObject1.put("errMsg", "No characteristics");
          }
          paramString = new JSONArray();
          paramUUID = paramUUID.iterator();
          bool1 = paramUUID.hasNext();
          boolean bool2 = false;
          if (bool1)
          {
            BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)paramUUID.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uuid", localBluetoothGattCharacteristic.getUuid().toString());
            JSONObject localJSONObject3 = new JSONObject();
            i = localBluetoothGattCharacteristic.getProperties();
            if ((i & 0x2) > 0)
            {
              bool1 = true;
              localJSONObject3.put("read", bool1);
              if ((i & 0x8) <= 0) {
                break label299;
              }
              bool1 = true;
              localJSONObject3.put("write", bool1);
              if ((i & 0x10) <= 0) {
                break label305;
              }
              bool1 = true;
              localJSONObject3.put("notify", bool1);
              bool1 = bool2;
              if ((i & 0x20) > 0) {
                bool1 = true;
              }
              localJSONObject3.put("indicate", bool1);
              localJSONObject2.put("properties", localJSONObject3);
              paramString.put(localJSONObject2);
            }
          }
          else
          {
            localJSONObject1.put("characteristics", paramString);
            localJSONObject1.put("code", 0);
            doCallback("getBLEDeviceCharacteristics", localJSONObject1.toString());
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramString)
      {
        return;
      }
      boolean bool1 = false;
      continue;
      label299:
      bool1 = false;
      continue;
      label305:
      bool1 = false;
    }
  }
  
  @TargetApi(18)
  private void getBLEDeviceServices(String paramString)
  {
    Runnable localRunnable = this.discoverServicesTimeOut;
    if (localRunnable != null) {
      this.mHandler.removeCallbacks(localRunnable);
    }
    paramString = (BluetoothGatt)this.mBluetoothGatts.get(paramString);
    if (paramString == null)
    {
      doCallback("getBLEDeviceServices", 10002, "DeviceId is not found");
      return;
    }
    if (paramString.discoverServices())
    {
      this.discoverServicesTimeOut = new QWalletBluetoothJsPlugin.3(this);
      this.mHandler.postDelayed(this.discoverServicesTimeOut, 15000L);
      return;
    }
    doCallback("getBLEDeviceServices", 10008, "Discover services not start");
  }
  
  private void getBluetoothAdapterState()
  {
    sAvailable = this.mBluetoothAdapter.isEnabled();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("discovering", sDiscovering);
      localJSONObject.put("available", sAvailable);
      label40:
      doCallback("getBluetoothAdapterState", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException)
    {
      break label40;
    }
  }
  
  private void getBluetoothDevices()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = this.mDevicesFound.iterator();
      while (localIterator.hasNext()) {
        localJSONArray.put(parseDevice2Json((QWalletBluetoothJsPlugin.BluetoothDeviceExtend)localIterator.next()));
      }
      localJSONObject.put("devices", localJSONArray);
      localJSONObject.put("code", 0);
      doCallback("getBluetoothDevices", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  @TargetApi(18)
  private BluetoothGattCallback getBluetoothGattCallback()
  {
    if (this.mBluetoothGattCallback == null) {
      this.mBluetoothGattCallback = new QWalletBluetoothJsPlugin.4(this);
    }
    return this.mBluetoothGattCallback;
  }
  
  @TargetApi(18)
  private BluetoothGattCharacteristic getCharacteristic(String paramString1, String paramString2, UUID paramUUID1, UUID paramUUID2)
  {
    paramString2 = getService(paramString1, paramString2, paramUUID1);
    if (paramString2 != null)
    {
      paramString2 = paramString2.getCharacteristic(paramUUID2);
      if (paramString2 == null) {
        doCallback(paramString1, 10005, "No characteristics");
      } else {
        return paramString2;
      }
    }
    return null;
  }
  
  @TargetApi(18)
  private void getConnectedBluetoothDevices(String paramString)
  {
    List localList = ((BluetoothManager)this.mContext.getSystemService("bluetooth")).getConnectedDevices(7);
    Object localObject = localList.iterator();
    while (((Iterator)localObject).hasNext()) {
      if (((BluetoothDevice)((Iterator)localObject).next()).getType() != 2) {
        ((Iterator)localObject).remove();
      }
    }
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString).optJSONArray("services");
        boolean bool = localList.isEmpty();
        if (bool)
        {
          doCallback("getConnectedBluetoothDevices", 10002, "No Devices");
        }
        else if ((paramString != null) && (paramString.length() > 0))
        {
          localObject = new ArrayList();
          i = 0;
          if (i < paramString.length())
          {
            UUID localUUID = parseUuidFromStr(paramString.getString(i));
            if (localUUID == null) {
              break label254;
            }
            ((List)localObject).add(localUUID);
            break label254;
          }
          if (((List)localObject).size() > 0)
          {
            this.mGetServicesCallback = new QWalletBluetoothJsPlugin.ConnServicesCallback(this, (List)localObject, localList.size());
            paramString = localList.iterator();
            if (!paramString.hasNext()) {
              break;
            }
            ((BluetoothDevice)paramString.next()).connectGatt(this.mContext, false, this.mGetServicesCallback);
            continue;
          }
        }
        doCallback("getConnectedBluetoothDevices", 10003, "Missing parameters");
        return;
      }
      catch (JSONException paramString)
      {
        return;
      }
      label254:
      i += 1;
    }
  }
  
  @TargetApi(18)
  private BluetoothGattService getService(String paramString1, String paramString2, UUID paramUUID)
  {
    paramString2 = (BluetoothGatt)this.mBluetoothGatts.get(paramString2);
    if (paramString2 == null)
    {
      paramString2 = createSimpleCallback(10002, "No device");
    }
    else
    {
      paramString2 = paramString2.getService(paramUUID);
      if (paramString2 != null) {
        return paramString2;
      }
      paramString2 = createSimpleCallback(10004, "No services");
    }
    doCallback(paramString1, paramString2);
    return null;
    return paramString2;
  }
  
  private static List<UUID> getUuidsFromRecordData(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    while (paramArrayOfByte.remaining() > 2)
    {
      int i = paramArrayOfByte.get();
      if (i == 0) {
        return localArrayList;
      }
      int k = paramArrayOfByte.get();
      int j = i;
      if (k != 2)
      {
        j = i;
        if (k != 3)
        {
          j = i;
          if (k != 6)
          {
            j = i;
            if (k != 7)
            {
              paramArrayOfByte.position(paramArrayOfByte.position() + i - 1);
              continue;
            }
          }
          while (j >= 16)
          {
            long l = paramArrayOfByte.getLong();
            localArrayList.add(new UUID(paramArrayOfByte.getLong(), l));
            j = (byte)(j - 16);
          }
          continue;
        }
      }
      while (j >= 2)
      {
        localArrayList.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805F9B34FB", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) })));
        j = (byte)(j - 2);
      }
    }
    return localArrayList;
  }
  
  @TargetApi(18)
  private void notifyBLECharacteristicValueChange(String paramString, UUID paramUUID1, UUID paramUUID2, boolean paramBoolean)
  {
    try
    {
      paramUUID1 = getCharacteristic("readBLECharacteristicValue", paramString, paramUUID1, paramUUID2);
      if (paramUUID1 != null)
      {
        paramString = (BluetoothGatt)this.mBluetoothGatts.get(paramString);
        paramUUID2 = new JSONObject();
        int k = paramUUID1.getProperties();
        int j = 1;
        int i;
        if ((k & 0x10) > 0) {
          i = 1;
        } else {
          i = 0;
        }
        if ((k & 0x20) <= 0) {
          j = 0;
        }
        if (((i != 0) || (j != 0)) && (paramString.setCharacteristicNotification(paramUUID1, paramBoolean)))
        {
          paramUUID2.put("code", 0);
          paramUUID1 = paramUUID1.getDescriptor(parseUuidFromStr("2902"));
          if (paramUUID1 != null)
          {
            if (i != 0) {
              paramUUID1.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
            }
            if (j != 0) {
              paramUUID1.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
            }
            paramString.writeDescriptor(paramUUID1);
          }
        }
        else
        {
          paramUUID2.put("code", 10007);
          paramUUID2.put("errMsg", "Property is not support");
        }
        doCallback("notifyBLECharacteristicValueChange", paramUUID2.toString());
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  private void onBluetoothAdapterStateChange()
  {
    sAvailable = this.mBluetoothAdapter.isEnabled();
    if (this.mBluetoothStateReceiver == null) {
      this.mBluetoothStateReceiver = new QWalletBluetoothJsPlugin.1(this);
    }
    if ((this.mActivity != null) && (!sIsReceiverRegister))
    {
      IntentFilter localIntentFilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
      localIntentFilter.addAction("com.tencent.qwallet.bluetooth.scan.changed");
      this.mActivity.registerReceiver(this.mBluetoothStateReceiver, localIntentFilter);
      sIsReceiverRegister = true;
    }
  }
  
  private void openBluetoothAdapter()
  {
    JSONObject localJSONObject = new JSONObject();
    this.mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    try
    {
      boolean bool = this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
      if (!bool)
      {
        localJSONObject.put("code", 10009);
        localJSONObject.put("errMsg", "System does not support");
      }
      else if (this.mBluetoothAdapter != null)
      {
        if (this.mBluetoothAdapter.isEnabled()) {
          localJSONObject.put("code", 0);
        } else {
          startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), (byte)1);
        }
      }
      else
      {
        localJSONObject.put("code", 10001);
        localJSONObject.put("errMsg", "Bluetooth is not sAvailable");
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    if (localJSONObject.has("code")) {
      doCallback("openBluetoothAdapter", localJSONObject.toString());
    }
  }
  
  private void parseCallback(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      if (paramString2.toLowerCase().indexOf("callback") < 0) {
        return;
      }
      try
      {
        paramString2 = new JSONObject(paramString2).optString("callback");
        this.mCallbacks.put(paramString1, paramString2);
        return;
      }
      catch (JSONException paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private static JSONObject parseDevice2Json(QWalletBluetoothJsPlugin.BluetoothDeviceExtend paramBluetoothDeviceExtend)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("name", paramBluetoothDeviceExtend.getBluetoothDevice().getName());
      localJSONObject.put("deviceId", paramBluetoothDeviceExtend.getBluetoothDevice().getAddress());
      localJSONObject.put("RSSI", paramBluetoothDeviceExtend.getRssi());
      localJSONObject.put("advertisData", bytes2Base64(paramBluetoothDeviceExtend.getScanRecord()));
      return localJSONObject;
    }
    catch (JSONException paramBluetoothDeviceExtend)
    {
      label67:
      break label67;
    }
    return null;
  }
  
  private static UUID parseUuidFromStr(String paramString)
  {
    if (paramString != null) {
      if (paramString.isEmpty()) {
        return null;
      }
    }
    try
    {
      int i = paramString.length();
      if (i != 4)
      {
        if (i != 8) {
          return UUID.fromString(paramString);
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("-0000-1000-8000-00805F9B34FB");
        return UUID.fromString(localStringBuilder.toString());
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("0000");
      localStringBuilder.append(paramString);
      localStringBuilder.append("-0000-1000-8000-00805F9B34FB");
      paramString = UUID.fromString(localStringBuilder.toString());
      return paramString;
    }
    catch (IllegalArgumentException paramString) {}
    return null;
    return null;
  }
  
  @TargetApi(18)
  private void readBLECharacteristicValue(String paramString, UUID paramUUID1, UUID paramUUID2)
  {
    paramUUID1 = getCharacteristic("readBLECharacteristicValue", paramString, paramUUID1, paramUUID2);
    if ((paramUUID1 != null) && (!((BluetoothGatt)this.mBluetoothGatts.get(paramString)).readCharacteristic(paramUUID1))) {
      doCallback("readBLECharacteristicValue", 10007, "Initializing read operation was failed");
    }
  }
  
  @TargetApi(18)
  private void startBluetoothDevicesDiscovery(String paramString)
  {
    if (sDiscovering)
    {
      doCallback("startBluetoothDevicesDiscovery", 10008, "Bluetooth is scanning");
      return;
    }
    Object localObject2 = null;
    Object localObject1 = null;
    if (paramString != null) {
      localObject1 = localObject2;
    }
    try
    {
      localJSONObject = new JSONObject(paramString);
      localObject1 = localObject2;
      paramString = localJSONObject.optJSONArray("services");
      localObject1 = paramString;
      bool = localJSONObject.optBoolean("allowDuplicatesKey", false);
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        try
        {
          JSONObject localJSONObject;
          boolean bool;
          int i;
          if (this.mBluetoothAdapter != null)
          {
            sDiscovering = this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            bool = sDiscovering;
            if (bool)
            {
              paramString.put("code", 0);
              this.mContext.sendBroadcast(new Intent().setAction("com.tencent.qwallet.bluetooth.scan.changed"));
            }
            else
            {
              paramString.put("code", 10008);
              paramString.put("errMsg", "Start scan failed");
            }
            paramString.put("isDiscovering", sDiscovering);
            doCallback("startBluetoothDevicesDiscovery", paramString.toString());
          }
          return;
        }
        catch (JSONException paramString) {}
        paramString = paramString;
      }
    }
    try
    {
      i = localJSONObject.optInt("interval", 0);
    }
    catch (JSONException localJSONException)
    {
      break label87;
    }
    bool = false;
    paramString = (String)localObject1;
    label87:
    i = 0;
    this.mLeScanCallback = new QWalletBluetoothJsPlugin.QWLeScanCallback(this, paramString, bool, i);
    this.mDevicesFound.clear();
    this.stopScan = new QWalletBluetoothJsPlugin.2(this);
    this.mHandler.postDelayed(this.stopScan, 12000L);
    paramString = new JSONObject();
  }
  
  @TargetApi(18)
  private void stopBluetoothDevicesDiscovery()
  {
    Object localObject;
    if (this.mBluetoothAdapter != null)
    {
      this.mLeScanCallback.stopTimer();
      this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
      sDiscovering = false;
      sAvailable = this.mBluetoothAdapter.isEnabled();
      this.mContext.sendBroadcast(new Intent().setAction("com.tencent.qwallet.bluetooth.scan.changed"));
      localObject = this.stopScan;
      if (localObject != null) {
        this.mHandler.removeCallbacks((Runnable)localObject);
      }
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("code", 0);
      ((JSONObject)localObject).put("discovering", sDiscovering);
      ((JSONObject)localObject).put("available", sAvailable);
      doCallback("stopBluetoothDevicesDiscovery", ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void unregisterReceiver()
  {
    Activity localActivity = this.mActivity;
    if (localActivity != null)
    {
      BroadcastReceiver localBroadcastReceiver = this.mBluetoothStateReceiver;
      if ((localBroadcastReceiver != null) && (sIsReceiverRegister))
      {
        localActivity.unregisterReceiver(localBroadcastReceiver);
        sIsReceiverRegister = false;
      }
    }
  }
  
  @TargetApi(18)
  private void writeBLECharacteristicValue(String paramString1, UUID paramUUID1, UUID paramUUID2, String paramString2)
  {
    paramUUID1 = getCharacteristic("readBLECharacteristicValue", paramString1, paramUUID1, paramUUID2);
    if (paramUUID1 != null)
    {
      paramUUID1.setValue(base642Bytes(paramString2));
      if (!((BluetoothGatt)this.mBluetoothGatts.get(paramString1)).writeCharacteristic(paramUUID1)) {
        doCallback("writeBLECharacteristicValue", 10007, "Initializing write operation was failed");
      }
    }
  }
  
  protected boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      if (this.mContext == null) {
        return false;
      }
      if (!"qw_bluetooth".equals(paramString2)) {
        return false;
      }
      if (paramVarArgs.length > 0) {
        parseCallback(paramString3, paramVarArgs[0]);
      }
      if ("openBluetoothAdapter".equals(paramString3))
      {
        openBluetoothAdapter();
        return true;
      }
      if ("closeBluetoothAdapter".equals(paramString3))
      {
        closeBluetoothAdapter();
        return true;
      }
      if ((!"onBluetoothDeviceFound".equals(paramString3)) && (!"onBLEConnectionStateChange".equals(paramString3)))
      {
        if ("onBLECharacteristicValueChange".equals(paramString3)) {
          return true;
        }
        if (this.mBluetoothAdapter == null)
        {
          doCallback(paramString3, 10000, "Initialize first");
          return true;
        }
        if ("getBluetoothAdapterState".equals(paramString3))
        {
          getBluetoothAdapterState();
          return true;
        }
        if ("onBluetoothAdapterStateChange".equals(paramString3))
        {
          onBluetoothAdapterStateChange();
          return true;
        }
        if ("startBluetoothDevicesDiscovery".equals(paramString3))
        {
          if (paramVarArgs.length > 0)
          {
            startBluetoothDevicesDiscovery(paramVarArgs[0]);
            return true;
          }
          startBluetoothDevicesDiscovery(null);
          return true;
        }
        if ("stopBluetoothDevicesDiscovery".equals(paramString3))
        {
          stopBluetoothDevicesDiscovery();
          return true;
        }
        if ("getBluetoothDevices".equals(paramString3))
        {
          getBluetoothDevices();
          return true;
        }
        if ("getConnectedBluetoothDevices".equals(paramString3))
        {
          if (paramVarArgs.length > 0)
          {
            getConnectedBluetoothDevices(paramVarArgs[0]);
            return true;
          }
          doCallback("getConnectedBluetoothDevices", 10003, "Missing parameters");
          return true;
        }
      }
    }
    try
    {
      paramJsBridgeListener = createSimpleCallback(10003, "Missing parameters");
      if (paramVarArgs.length > 0)
      {
        paramString1 = new JSONObject(paramVarArgs[0]);
        paramString2 = paramString1.optString("deviceId").toUpperCase();
        if (BluetoothAdapter.checkBluetoothAddress(paramString2))
        {
          boolean bool = this.mConnectedDevices.contains(paramString2);
          if ((!bool) && (!"createBLEConnection".equals(paramString3)))
          {
            doCallback(paramString3, 10006, "connect the device first");
            return true;
          }
          paramVarArgs = parseUuidFromStr(paramString1.optString("serviceId"));
          UUID localUUID = parseUuidFromStr(paramString1.optString("characteristicId"));
          String str = paramString1.optString("value");
          bool = paramString1.optBoolean("state");
          if ("createBLEConnection".equals(paramString3))
          {
            createBLEConnection(paramString2);
            return true;
          }
          if ("closeBLEConnection".equals(paramString3))
          {
            closeBLEConnection(paramString2);
            return true;
          }
          if ("getBLEDeviceServices".equals(paramString3))
          {
            getBLEDeviceServices(paramString2);
            return true;
          }
          if ("getBLEDeviceCharacteristics".equals(paramString3))
          {
            if (paramVarArgs == null)
            {
              doCallback(paramString3, paramJsBridgeListener);
              return true;
            }
            getBLEDeviceCharacteristics(paramString2, paramVarArgs);
            return true;
          }
          if ("readBLECharacteristicValue".equals(paramString3))
          {
            if ((paramVarArgs != null) && (localUUID != null))
            {
              readBLECharacteristicValue(paramString2, paramVarArgs, localUUID);
              return true;
            }
            doCallback(paramString3, paramJsBridgeListener);
            return true;
          }
          if ("writeBLECharacteristicValue".equals(paramString3))
          {
            if ((paramVarArgs != null) && (localUUID != null) && (!str.isEmpty()))
            {
              writeBLECharacteristicValue(paramString2, paramVarArgs, localUUID, str);
              return true;
            }
            doCallback(paramString3, paramJsBridgeListener);
            return true;
          }
          if ("notifyBLECharacteristicValueChange".equals(paramString3))
          {
            if ((paramVarArgs != null) && (localUUID != null))
            {
              notifyBLECharacteristicValueChange(paramString2, paramVarArgs, localUUID, bool);
              return true;
            }
            doCallback(paramString3, paramJsBridgeListener);
            return true;
          }
        }
        else
        {
          doCallback(paramString3, paramJsBridgeListener);
          return true;
        }
      }
      else
      {
        doCallback(paramString3, paramJsBridgeListener);
      }
      return true;
    }
    catch (JSONException paramJsBridgeListener) {}
    return false;
    return true;
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 1)
    {
      paramIntent = new JSONObject();
      if (paramInt != -1) {}
    }
    try
    {
      paramIntent.put("code", 0);
      break label56;
      paramIntent.put("code", 10000);
      paramIntent.put("errMsg", "User refused");
      label56:
      doCallback("openBluetoothAdapter", paramIntent.toString());
      return;
    }
    catch (JSONException paramIntent) {}
  }
  
  protected void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.d();
      this.mActivity = localActivity;
      if (localActivity != null) {
        this.mContext = this.mActivity.getApplicationContext();
      }
    }
    this.mDevicesFound = new LinkedList();
    this.mCallbacks = new ArrayMap();
    this.mBluetoothGatts = new ArrayMap();
    this.mConnectingDevices = new HashSet();
    this.mConnectedDevices = new HashSet();
    sAvailable = false;
    sDiscovering = false;
    this.mHandler = new Handler();
  }
  
  protected void onDestroy()
  {
    if (this.mRuntime != null) {
      unregisterReceiver();
    }
    this.mLeScanCallback = null;
    this.mBluetoothGattCallback = null;
    this.mGetServicesCallback = null;
    this.mBluetoothStateReceiver = null;
    this.stopScan = null;
    this.discoverServicesTimeOut = null;
    super.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin
 * JD-Core Version:    0.7.0.1
 */