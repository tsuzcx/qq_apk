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
import bcdp;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
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
      for (;;)
      {
        doCallback("closeBLEConnection", localJSONObject.toString());
        return;
        localBluetoothGatt.disconnect();
        localBluetoothGatt.close();
        this.mConnectedDevices.remove(paramString);
        this.mBluetoothGatts.remove(paramString);
        localJSONObject.put("code", 0);
      }
      return;
    }
    catch (JSONException paramString) {}
  }
  
  @TargetApi(18)
  private void closeBluetoothAdapter()
  {
    unregisterReceiver();
    if ((this.mBluetoothAdapter != null) && (this.mBluetoothAdapter.isDiscovering())) {
      this.mBluetoothAdapter.cancelDiscovery();
    }
    if (this.mLeScanCallback != null) {
      this.mLeScanCallback.stopTimer();
    }
    Iterator localIterator = this.mBluetoothGatts.values().iterator();
    while (localIterator.hasNext())
    {
      BluetoothGatt localBluetoothGatt = (BluetoothGatt)localIterator.next();
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
    catch (JSONException paramString) {}
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
      Log.i("QWBluetoothJsPlugin", "doCallback: " + paramString1 + "->" + paramString2);
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
          if (paramUUID.size() == 0)
          {
            localJSONObject1.put("code", 10005);
            localJSONObject1.put("errMsg", "No characteristics");
          }
          paramString = new JSONArray();
          paramUUID = paramUUID.iterator();
          if (paramUUID.hasNext())
          {
            BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)paramUUID.next();
            JSONObject localJSONObject2 = new JSONObject();
            localJSONObject2.put("uuid", localBluetoothGattCharacteristic.getUuid().toString());
            JSONObject localJSONObject3 = new JSONObject();
            int i = localBluetoothGattCharacteristic.getProperties();
            if ((i & 0x2) <= 0) {
              break label271;
            }
            bool = true;
            localJSONObject3.put("read", bool);
            if ((i & 0x8) <= 0) {
              break label277;
            }
            bool = true;
            localJSONObject3.put("write", bool);
            if ((i & 0x10) <= 0) {
              break label283;
            }
            bool = true;
            localJSONObject3.put("notify", bool);
            if ((i & 0x20) <= 0) {
              break label289;
            }
            bool = true;
            localJSONObject3.put("indicate", bool);
            localJSONObject2.put("properties", localJSONObject3);
            paramString.put(localJSONObject2);
            continue;
          }
          localJSONObject1.put("characteristics", paramString);
          localJSONObject1.put("code", 0);
          doCallback("getBLEDeviceCharacteristics", localJSONObject1.toString());
          return;
        }
      }
      catch (JSONException paramString) {}
      return;
      label271:
      boolean bool = false;
      continue;
      label277:
      bool = false;
      continue;
      label283:
      bool = false;
      continue;
      label289:
      bool = false;
    }
  }
  
  @TargetApi(18)
  private void getBLEDeviceServices(String paramString)
  {
    if (this.discoverServicesTimeOut != null) {
      this.mHandler.removeCallbacks(this.discoverServicesTimeOut);
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
      paramUUID1 = paramString2.getCharacteristic(paramUUID2);
      paramString2 = paramUUID1;
      if (paramUUID1 == null) {
        doCallback(paramString1, 10005, "No characteristics");
      }
    }
    else
    {
      paramString2 = null;
    }
    return paramString2;
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
        if (localList.isEmpty())
        {
          doCallback("getConnectedBluetoothDevices", 10002, "No Devices");
          doCallback("getConnectedBluetoothDevices", 10003, "Missing parameters");
          return;
        }
        if ((paramString == null) || (paramString.length() <= 0)) {
          continue;
        }
        localObject = new ArrayList();
        i = 0;
        if (i < paramString.length())
        {
          UUID localUUID = parseUuidFromStr(paramString.getString(i));
          if (localUUID != null) {
            ((List)localObject).add(localUUID);
          }
        }
        else
        {
          if (((List)localObject).size() <= 0) {
            continue;
          }
          this.mGetServicesCallback = new QWalletBluetoothJsPlugin.ConnServicesCallback(this, (List)localObject, localList.size());
          paramString = localList.iterator();
          if (paramString.hasNext())
          {
            ((BluetoothDevice)paramString.next()).connectGatt(this.mContext, false, this.mGetServicesCallback);
            continue;
          }
          return;
        }
      }
      catch (JSONException paramString) {}
      i += 1;
    }
  }
  
  @TargetApi(18)
  private BluetoothGattService getService(String paramString1, String paramString2, UUID paramUUID)
  {
    paramString2 = (BluetoothGatt)this.mBluetoothGatts.get(paramString2);
    if (paramString2 == null) {}
    for (paramString2 = createSimpleCallback(10002, "No device");; paramString2 = createSimpleCallback(10004, "No services"))
    {
      doCallback(paramString1, paramString2);
      paramString2 = null;
      do
      {
        return paramString2;
        paramUUID = paramString2.getService(paramUUID);
        paramString2 = paramUUID;
      } while (paramUUID != null);
    }
  }
  
  private static List<UUID> getUuidsFromRecordData(byte[] paramArrayOfByte)
  {
    ArrayList localArrayList = new ArrayList();
    paramArrayOfByte = ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN);
    for (;;)
    {
      int i;
      if (paramArrayOfByte.remaining() > 2)
      {
        i = paramArrayOfByte.get();
        if (i != 0) {}
      }
      else
      {
        return localArrayList;
      }
      int j = i;
      int k = i;
      switch (paramArrayOfByte.get())
      {
      case 4: 
      case 5: 
      default: 
        paramArrayOfByte.position(i + paramArrayOfByte.position() - 1);
        break;
      case 2: 
      case 3: 
        while (j >= 2)
        {
          localArrayList.add(UUID.fromString(String.format("%08x-0000-1000-8000-00805F9B34FB", new Object[] { Short.valueOf(paramArrayOfByte.getShort()) })));
          j = (byte)(j - 2);
        }
      case 6: 
      case 7: 
        while (k >= 16)
        {
          long l = paramArrayOfByte.getLong();
          localArrayList.add(new UUID(paramArrayOfByte.getLong(), l));
          k = (byte)(k - 16);
        }
      }
    }
  }
  
  @TargetApi(18)
  private void notifyBLECharacteristicValueChange(String paramString, UUID paramUUID1, UUID paramUUID2, boolean paramBoolean)
  {
    int j = 1;
    label133:
    label158:
    label179:
    label180:
    label190:
    for (;;)
    {
      int k;
      int i;
      try
      {
        paramUUID1 = getCharacteristic("readBLECharacteristicValue", paramString, paramUUID1, paramUUID2);
        if (paramUUID1 == null) {
          break label179;
        }
        paramString = (BluetoothGatt)this.mBluetoothGatts.get(paramString);
        paramUUID2 = new JSONObject();
        k = paramUUID1.getProperties();
        if ((k & 0x10) <= 0) {
          break label180;
        }
        i = 1;
      }
      catch (JSONException paramString)
      {
        return;
      }
      if (paramString.setCharacteristicNotification(paramUUID1, paramBoolean))
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
        doCallback("notifyBLECharacteristicValueChange", paramUUID2.toString());
        return;
      }
      paramUUID2.put("code", 10007);
      paramUUID2.put("errMsg", "Property is not support");
      continue;
      if ((k & 0x20) > 0) {}
      for (;;)
      {
        if (i != 0) {
          break label190;
        }
        if (j == 0) {
          break label133;
        }
        break;
        return;
        i = 0;
        break label158;
        j = 0;
      }
    }
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
      if (!this.mContext.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le"))
      {
        localJSONObject.put("code", 10009);
        localJSONObject.put("errMsg", "System does not support");
      }
      for (;;)
      {
        if (localJSONObject.has("code")) {
          doCallback("openBluetoothAdapter", localJSONObject.toString());
        }
        return;
        if (this.mBluetoothAdapter == null) {
          break label125;
        }
        if (!this.mBluetoothAdapter.isEnabled()) {
          break;
        }
        localJSONObject.put("code", 0);
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), (byte)1);
        continue;
        label125:
        localJSONObject.put("code", 10001);
        localJSONObject.put("errMsg", "Bluetooth is not sAvailable");
      }
    }
  }
  
  private void parseCallback(String paramString1, String paramString2)
  {
    if ((TextUtils.isEmpty(paramString2)) || (paramString2.toLowerCase().indexOf("callback") < 0)) {
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
    catch (JSONException paramBluetoothDeviceExtend) {}
    return null;
  }
  
  private static UUID parseUuidFromStr(String paramString)
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
          return UUID.fromString(paramString);
        }
      }
      catch (IllegalArgumentException paramString)
      {
        return null;
      }
      return UUID.fromString("0000" + paramString + "-0000-1000-8000-00805F9B34FB");
      paramString = UUID.fromString(paramString + "-0000-1000-8000-00805F9B34FB");
      return paramString;
    }
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
    int i = 0;
    if (sDiscovering)
    {
      doCallback("startBluetoothDevicesDiscovery", 10008, "Bluetooth is scanning");
      return;
    }
    if (paramString != null) {}
    for (;;)
    {
      try
      {
        localJSONObject = new JSONObject(paramString);
        paramString = localJSONObject.optJSONArray("services");
      }
      catch (JSONException localJSONException1)
      {
        try
        {
          JSONObject localJSONObject;
          bool = localJSONObject.optBoolean("allowDuplicatesKey", false);
          try
          {
            int j = localJSONObject.optInt("interval", 0);
            i = j;
          }
          catch (JSONException localJSONException2)
          {
            continue;
          }
          this.mLeScanCallback = new QWalletBluetoothJsPlugin.QWLeScanCallback(this, paramString, bool, i);
          this.mDevicesFound.clear();
          this.stopScan = new QWalletBluetoothJsPlugin.2(this);
          this.mHandler.postDelayed(this.stopScan, 12000L);
          paramString = new JSONObject();
        }
        catch (JSONException paramString)
        {
          try
          {
            if (this.mBluetoothAdapter == null) {
              break;
            }
            sDiscovering = this.mBluetoothAdapter.startLeScan(this.mLeScanCallback);
            if (sDiscovering)
            {
              paramString.put("code", 0);
              this.mContext.sendBroadcast(new Intent().setAction("com.tencent.qwallet.bluetooth.scan.changed"));
              paramString.put("isDiscovering", sDiscovering);
              doCallback("startBluetoothDevicesDiscovery", paramString.toString());
              return;
            }
            paramString.put("code", 10008);
            paramString.put("errMsg", "Start scan failed");
            continue;
            paramString = paramString;
            paramString = null;
            bool = false;
          }
          catch (JSONException paramString) {}
          localJSONException1 = localJSONException1;
          bool = false;
          continue;
        }
      }
      paramString = null;
      boolean bool = false;
    }
  }
  
  @TargetApi(18)
  private void stopBluetoothDevicesDiscovery()
  {
    if (this.mBluetoothAdapter != null)
    {
      this.mLeScanCallback.stopTimer();
      this.mBluetoothAdapter.stopLeScan(this.mLeScanCallback);
      sDiscovering = false;
      sAvailable = this.mBluetoothAdapter.isEnabled();
      this.mContext.sendBroadcast(new Intent().setAction("com.tencent.qwallet.bluetooth.scan.changed"));
      if (this.stopScan != null) {
        this.mHandler.removeCallbacks(this.stopScan);
      }
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("code", 0);
      localJSONObject.put("discovering", sDiscovering);
      localJSONObject.put("available", sAvailable);
      doCallback("stopBluetoothDevicesDiscovery", localJSONObject.toString());
      return;
    }
    catch (JSONException localJSONException) {}
  }
  
  private void unregisterReceiver()
  {
    if ((this.mActivity != null) && (this.mBluetoothStateReceiver != null) && (sIsReceiverRegister))
    {
      this.mActivity.unregisterReceiver(this.mBluetoothStateReceiver);
      sIsReceiverRegister = false;
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
  
  public boolean handleJsRequest(JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    if ((TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3)) || (this.mContext == null)) {}
    while (!"qw_bluetooth".equals(paramString2)) {
      return false;
    }
    if (paramVarArgs.length > 0) {
      parseCallback(paramString3, paramVarArgs[0]);
    }
    if ("openBluetoothAdapter".equals(paramString3)) {
      openBluetoothAdapter();
    }
    for (;;)
    {
      return true;
      if ("closeBluetoothAdapter".equals(paramString3)) {
        closeBluetoothAdapter();
      } else if ((!"onBluetoothDeviceFound".equals(paramString3)) && (!"onBLEConnectionStateChange".equals(paramString3)) && (!"onBLECharacteristicValueChange".equals(paramString3))) {
        if (this.mBluetoothAdapter == null) {
          doCallback(paramString3, 10000, "Initialize first");
        } else if ("getBluetoothAdapterState".equals(paramString3)) {
          getBluetoothAdapterState();
        } else if ("onBluetoothAdapterStateChange".equals(paramString3)) {
          onBluetoothAdapterStateChange();
        } else if ("startBluetoothDevicesDiscovery".equals(paramString3))
        {
          if (paramVarArgs.length > 0) {
            startBluetoothDevicesDiscovery(paramVarArgs[0]);
          } else {
            startBluetoothDevicesDiscovery(null);
          }
        }
        else if ("stopBluetoothDevicesDiscovery".equals(paramString3)) {
          stopBluetoothDevicesDiscovery();
        } else if ("getBluetoothDevices".equals(paramString3)) {
          getBluetoothDevices();
        } else if ("getConnectedBluetoothDevices".equals(paramString3))
        {
          if (paramVarArgs.length > 0) {
            getConnectedBluetoothDevices(paramVarArgs[0]);
          } else {
            doCallback("getConnectedBluetoothDevices", 10003, "Missing parameters");
          }
        }
        else {
          try
          {
            paramJsBridgeListener = createSimpleCallback(10003, "Missing parameters");
            UUID localUUID;
            String str;
            boolean bool;
            if (paramVarArgs.length > 0)
            {
              paramString1 = new JSONObject(paramVarArgs[0]);
              paramString2 = paramString1.optString("deviceId").toUpperCase();
              if (BluetoothAdapter.checkBluetoothAddress(paramString2))
              {
                if ((!this.mConnectedDevices.contains(paramString2)) && (!"createBLEConnection".equals(paramString3)))
                {
                  doCallback(paramString3, 10006, "connect the device first");
                  return true;
                }
              }
              else
              {
                doCallback(paramString3, paramJsBridgeListener);
                return true;
              }
              paramVarArgs = parseUuidFromStr(paramString1.optString("serviceId"));
              localUUID = parseUuidFromStr(paramString1.optString("characteristicId"));
              str = paramString1.optString("value");
              bool = paramString1.optBoolean("state");
              if ("createBLEConnection".equals(paramString3)) {
                createBLEConnection(paramString2);
              }
            }
            else
            {
              doCallback(paramString3, paramJsBridgeListener);
              return true;
            }
            if ("closeBLEConnection".equals(paramString3)) {
              closeBLEConnection(paramString2);
            } else if ("getBLEDeviceServices".equals(paramString3)) {
              getBLEDeviceServices(paramString2);
            } else if ("getBLEDeviceCharacteristics".equals(paramString3))
            {
              if (paramVarArgs == null) {
                doCallback(paramString3, paramJsBridgeListener);
              } else {
                getBLEDeviceCharacteristics(paramString2, paramVarArgs);
              }
            }
            else if ("readBLECharacteristicValue".equals(paramString3))
            {
              if ((paramVarArgs == null) || (localUUID == null)) {
                doCallback(paramString3, paramJsBridgeListener);
              } else {
                readBLECharacteristicValue(paramString2, paramVarArgs, localUUID);
              }
            }
            else if ("writeBLECharacteristicValue".equals(paramString3))
            {
              if ((paramVarArgs == null) || (localUUID == null) || (str.isEmpty())) {
                doCallback(paramString3, paramJsBridgeListener);
              } else {
                writeBLECharacteristicValue(paramString2, paramVarArgs, localUUID, str);
              }
            }
            else if ("notifyBLECharacteristicValueChange".equals(paramString3)) {
              if ((paramVarArgs == null) || (localUUID == null)) {
                doCallback(paramString3, paramJsBridgeListener);
              } else {
                notifyBLECharacteristicValueChange(paramString2, paramVarArgs, localUUID, bool);
              }
            }
          }
          catch (JSONException paramJsBridgeListener) {}
        }
      }
    }
  }
  
  public void onActivityResult(Intent paramIntent, byte paramByte, int paramInt)
  {
    super.onActivityResult(paramIntent, paramByte, paramInt);
    if (paramByte == 1)
    {
      paramIntent = new JSONObject();
      if (paramInt == -1) {}
      for (;;)
      {
        try
        {
          paramIntent.put("code", 0);
          doCallback("openBluetoothAdapter", paramIntent.toString());
          return;
        }
        catch (JSONException paramIntent) {}
        paramIntent.put("code", 10000);
        paramIntent.put("errMsg", "User refused");
      }
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    if (this.mRuntime != null)
    {
      Activity localActivity = this.mRuntime.a();
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
  
  public void onDestroy()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.QWalletBluetoothJsPlugin
 * JD-Core Version:    0.7.0.1
 */