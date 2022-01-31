package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import android.os.ParcelUuid;
import android.text.TextUtils;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.mobileqq.mini.sdk.MiniAppException;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(18)
class BluetoothJsPlugin$BluetoothDeviceExtend
  extends BluetoothGattCallback
{
  List<Integer> blueToothConnListeners = new ArrayList();
  List<Integer> blueToothServiceListeners = new ArrayList();
  Runnable connTimeoutJob;
  BluetoothGatt gatt;
  long lastConnectionTime;
  String localName = "";
  BluetoothDevice mBluetoothDevice;
  String mDevicesId;
  int mRssi;
  byte[] mScanRecord;
  List<ParcelUuid> mServiceUuids = new ArrayList();
  SparseArray<byte[]> manufacturerData = new SparseArray();
  String name;
  Map<ParcelUuid, byte[]> serviceData = new HashMap();
  List<BluetoothGattService> services = null;
  int state = 0;
  
  BluetoothJsPlugin$BluetoothDeviceExtend(BluetoothJsPlugin paramBluetoothJsPlugin, BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    this.mBluetoothDevice = paramBluetoothDevice;
    this.mRssi = paramInt;
    this.mScanRecord = paramArrayOfByte;
    this.mDevicesId = this.mBluetoothDevice.getAddress();
    if (this.mDevicesId == null) {
      this.mDevicesId = "";
    }
    this.name = this.mBluetoothDevice.getName();
    this.connTimeoutJob = new BluetoothJsPlugin.BluetoothDeviceExtend.1(this, paramBluetoothJsPlugin);
  }
  
  public void connectGatt(Context paramContext, boolean paramBoolean, long paramLong, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.connectGatt autoConnect=" + paramBoolean + ",timeout=" + paramLong + ",callbackId=" + paramInt);
    if (!this.blueToothConnListeners.contains(Integer.valueOf(paramInt))) {
      this.blueToothConnListeners.add(Integer.valueOf(paramInt));
    }
    if ((this.state == 2) && (this.gatt != null)) {
      onConnectionStateChange(this.gatt, 0, this.state);
    }
    do
    {
      return;
      if (this.gatt != null) {
        this.gatt.close();
      }
      this.gatt = this.mBluetoothDevice.connectGatt(paramContext, paramBoolean, this);
      if (this.gatt == null) {
        throw new MiniAppException("connectGatt is null");
      }
      BluetoothJsPlugin.access$500(this.this$0).removeCallbacks(this.connTimeoutJob);
    } while (paramLong <= 0L);
    BluetoothJsPlugin.access$500(this.this$0).postDelayed(this.connTimeoutJob, paramLong);
  }
  
  public boolean containsUUID(List<ParcelUuid> paramList)
  {
    if ((this.mServiceUuids == null) || (this.mServiceUuids.size() < 1) || (paramList == null) || (paramList.size() < 1)) {
      return false;
    }
    return this.mServiceUuids.containsAll(paramList);
  }
  
  public void destory()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.destory,,,,,,");
    disconnectGatt();
    synchronized (this.blueToothServiceListeners)
    {
      this.blueToothServiceListeners.clear();
      return;
    }
  }
  
  public boolean disconnectGatt()
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.disconnectGatt,,,,,,");
    this.state = 0;
    BluetoothJsPlugin.access$500(this.this$0).removeCallbacks(this.connTimeoutJob);
    if (this.gatt == null) {
      return false;
    }
    this.gatt.disconnect();
    return true;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof BluetoothDeviceExtend))
    {
      paramObject = (BluetoothDeviceExtend)paramObject;
      if ((paramObject.mDevicesId != null) && (paramObject.mDevicesId.equals(this.mDevicesId))) {
        return true;
      }
    }
    return false;
  }
  
  public String getDeviceName()
  {
    if (!TextUtils.isEmpty(this.name)) {
      return this.name;
    }
    if (!TextUtils.isEmpty(this.localName)) {
      return this.localName;
    }
    return "";
  }
  
  public void getServices(int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.getServices callbackId=" + paramInt);
    if (this.gatt == null) {
      throw new MiniAppException("getService exception, state=" + this.state + ",gatt=" + this.gatt);
    }
    if (!this.blueToothServiceListeners.contains(Integer.valueOf(paramInt))) {
      this.blueToothServiceListeners.add(Integer.valueOf(paramInt));
    }
    if (this.services != null) {
      onServicesDiscovered(this.gatt, 0);
    }
    do
    {
      return;
      if (this.lastConnectionTime + 600L > System.currentTimeMillis())
      {
        BluetoothJsPlugin.access$500(this.this$0).postDelayed(new BluetoothJsPlugin.BluetoothDeviceExtend.2(this, paramInt), 600L);
        return;
      }
    } while (this.gatt.discoverServices());
    this.this$0.jsPluginEngine.callbackJsEventFail(this.this$0.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", null, paramInt);
  }
  
  public boolean notifyBLECharacteristicValueChange(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    int j = 1;
    boolean bool2 = false;
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.notifyBLECharacteristicValueChange c=" + paramBluetoothGattCharacteristic + ",state=" + paramBoolean);
    boolean bool1 = bool2;
    if (this.gatt != null)
    {
      if (paramBluetoothGattCharacteristic == null) {
        bool1 = bool2;
      }
    }
    else {
      return bool1;
    }
    int k = paramBluetoothGattCharacteristic.getProperties();
    int i;
    if ((k & 0x10) > 0)
    {
      i = 1;
      label80:
      if ((k & 0x20) <= 0) {
        break label170;
      }
    }
    for (;;)
    {
      if (i == 0)
      {
        bool1 = bool2;
        if (j == 0) {
          break;
        }
      }
      paramBoolean = this.gatt.setCharacteristicNotification(paramBluetoothGattCharacteristic, paramBoolean);
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getDescriptor(UUID.fromString("2902"));
      bool1 = paramBoolean;
      if (paramBluetoothGattCharacteristic == null) {
        break;
      }
      if (i != 0) {
        paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
      }
      if (j != 0) {
        paramBluetoothGattCharacteristic.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
      }
      this.gatt.writeDescriptor(paramBluetoothGattCharacteristic);
      return paramBoolean;
      i = 0;
      break label80;
      label170:
      j = 0;
    }
  }
  
  public void onCharacteristicChanged(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    try
    {
      paramBluetoothGatt = paramBluetoothGattCharacteristic.getService();
      if (paramBluetoothGatt == null) {
        return;
      }
      paramBluetoothGatt = paramBluetoothGatt.getUuid().toString();
      String str = paramBluetoothGattCharacteristic.getUuid().toString();
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceId", this.mDevicesId);
      localJSONObject.put("serviceId", paramBluetoothGatt);
      localJSONObject.put("characteristicId", str);
      localJSONObject.put("value", Base64.encodeToString(paramBluetoothGattCharacteristic.getValue(), 2));
      this.this$0.jsPluginEngine.getServiceRuntime().evaluateSubcribeJS("onBLECharacteristicValueChange", localJSONObject.toString(), 0);
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.onCharacteristicRead gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.onCharacteristicWrite gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
  }
  
  /* Error */
  public void onConnectionStateChange(BluetoothGatt arg1, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 105
    //   2: iconst_2
    //   3: new 107	java/lang/StringBuilder
    //   6: dup
    //   7: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   10: ldc_w 380
    //   13: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   16: aload_0
    //   17: getfield 153	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
    //   20: invokevirtual 238	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   23: ldc_w 375
    //   26: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: iload_2
    //   30: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   33: ldc_w 382
    //   36: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload_3
    //   40: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   43: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   53: invokestatic 178	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$500	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Landroid/os/Handler;
    //   56: aload_0
    //   57: getfield 100	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:connTimeoutJob	Ljava/lang/Runnable;
    //   60: invokevirtual 184	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   63: aload_0
    //   64: iload_3
    //   65: putfield 49	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
    //   68: aload_0
    //   69: getfield 49	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
    //   72: iconst_2
    //   73: if_icmpne +186 -> 259
    //   76: aload_0
    //   77: invokestatic 252	java/lang/System:currentTimeMillis	()J
    //   80: putfield 244	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:lastConnectionTime	J
    //   83: aload_0
    //   84: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   87: invokestatic 386	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$800	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   97: invokestatic 386	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$800	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
    //   100: aload_0
    //   101: getfield 88	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
    //   104: invokevirtual 389	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   107: ifne +19 -> 126
    //   110: aload_0
    //   111: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   114: invokestatic 386	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:access$800	(Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
    //   117: aload_0
    //   118: getfield 88	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
    //   121: aload_0
    //   122: invokevirtual 392	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: aload_1
    //   127: monitorexit
    //   128: iconst_1
    //   129: istore 4
    //   131: aload_0
    //   132: getfield 72	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
    //   135: astore_1
    //   136: aload_1
    //   137: monitorenter
    //   138: aload_0
    //   139: getfield 72	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
    //   142: invokeinterface 396 1 0
    //   147: astore 5
    //   149: aload 5
    //   151: invokeinterface 401 1 0
    //   156: ifeq +155 -> 311
    //   159: aload 5
    //   161: invokeinterface 405 1 0
    //   166: checkcast 138	java/lang/Integer
    //   169: invokevirtual 408	java/lang/Integer:intValue	()I
    //   172: istore_2
    //   173: ldc 105
    //   175: iconst_2
    //   176: new 107	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 108	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 410
    //   186: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: iload 4
    //   191: invokevirtual 117	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   194: ldc_w 412
    //   197: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: iload_2
    //   201: invokevirtual 127	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   204: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 136	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: iload 4
    //   212: ifeq +71 -> 283
    //   215: aload_0
    //   216: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   219: getfield 264	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   222: aload_0
    //   223: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   226: getfield 264	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   229: invokevirtual 270	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getServiceRuntime	()Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   232: ldc_w 414
    //   235: aconst_null
    //   236: iload_2
    //   237: invokevirtual 417	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventOK	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   240: goto -91 -> 149
    //   243: astore 5
    //   245: aload_1
    //   246: monitorexit
    //   247: aload 5
    //   249: athrow
    //   250: astore_1
    //   251: return
    //   252: astore 5
    //   254: aload_1
    //   255: monitorexit
    //   256: aload 5
    //   258: athrow
    //   259: iload_3
    //   260: ifne +17 -> 277
    //   263: aload_0
    //   264: getfield 153	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
    //   267: ifnull +10 -> 277
    //   270: aload_0
    //   271: getfield 153	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
    //   274: invokevirtual 162	android/bluetooth/BluetoothGatt:close	()V
    //   277: iconst_0
    //   278: istore 4
    //   280: goto -149 -> 131
    //   283: aload_0
    //   284: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   287: getfield 264	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   290: aload_0
    //   291: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   294: getfield 264	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   297: invokevirtual 270	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getServiceRuntime	()Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   300: ldc_w 414
    //   303: aconst_null
    //   304: iload_2
    //   305: invokevirtual 276	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:callbackJsEventFail	(Lcom/tencent/mobileqq/mini/webview/JsRuntime;Ljava/lang/String;Lorg/json/JSONObject;I)V
    //   308: goto -159 -> 149
    //   311: aload_0
    //   312: getfield 72	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
    //   315: invokeinterface 210 1 0
    //   320: aload_1
    //   321: monitorexit
    //   322: new 336	org/json/JSONObject
    //   325: dup
    //   326: invokespecial 337	org/json/JSONObject:<init>	()V
    //   329: astore_1
    //   330: aload_1
    //   331: ldc_w 339
    //   334: aload_0
    //   335: getfield 88	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
    //   338: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   341: pop
    //   342: aload_1
    //   343: ldc_w 419
    //   346: iload 4
    //   348: invokevirtual 422	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   351: pop
    //   352: aload_0
    //   353: getfield 44	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin;
    //   356: getfield 264	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BluetoothJsPlugin:jsPluginEngine	Lcom/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine;
    //   359: invokevirtual 270	com/tencent/mobileqq/mini/appbrand/jsapi/plugins/BaseJsPluginEngine:getServiceRuntime	()Lcom/tencent/mobileqq/mini/webview/JsRuntime;
    //   362: ldc_w 424
    //   365: aload_1
    //   366: invokevirtual 361	org/json/JSONObject:toString	()Ljava/lang/String;
    //   369: iconst_0
    //   370: invokeinterface 367 4 0
    //   375: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	376	0	this	BluetoothDeviceExtend
    //   0	376	2	paramInt1	int
    //   0	376	3	paramInt2	int
    //   129	218	4	bool	boolean
    //   147	13	5	localIterator	Iterator
    //   243	5	5	localObject1	Object
    //   252	5	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   138	149	243	finally
    //   149	210	243	finally
    //   215	240	243	finally
    //   245	247	243	finally
    //   283	308	243	finally
    //   311	322	243	finally
    //   49	93	250	org/json/JSONException
    //   131	138	250	org/json/JSONException
    //   247	250	250	org/json/JSONException
    //   256	259	250	org/json/JSONException
    //   263	277	250	org/json/JSONException
    //   322	375	250	org/json/JSONException
    //   93	126	252	finally
    //   126	128	252	finally
    //   254	256	252	finally
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.onServicesDiscovered gatt=" + paramBluetoothGatt + ",status=" + paramInt);
    Object localObject;
    boolean bool;
    if (paramInt == 0)
    {
      this.services = paramBluetoothGatt.getServices();
      try
      {
        localObject = new JSONArray();
        if (this.services.size() > 0)
        {
          paramBluetoothGatt = this.services.iterator();
          for (;;)
          {
            if (paramBluetoothGatt.hasNext())
            {
              BluetoothGattService localBluetoothGattService = (BluetoothGattService)paramBluetoothGatt.next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("uuid", localBluetoothGattService.getUuid().toString());
              if (localBluetoothGattService.getType() == 0)
              {
                bool = true;
                localJSONObject.put("isPrimary", bool);
                ((JSONArray)localObject).put(localJSONObject);
                continue;
                localObject = this.blueToothServiceListeners.iterator();
              }
            }
          }
        }
      }
      catch (JSONException paramBluetoothGatt)
      {
        paramBluetoothGatt = null;
      }
    }
    for (;;)
    {
      if (((Iterator)localObject).hasNext())
      {
        paramInt = ((Integer)((Iterator)localObject).next()).intValue();
        if (paramBluetoothGatt != null)
        {
          this.this$0.jsPluginEngine.callbackJsEventOK(this.this$0.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", paramBluetoothGatt, paramInt);
          continue;
          bool = false;
          break;
          paramBluetoothGatt = new JSONObject();
        }
      }
      try
      {
        paramBluetoothGatt.put("services", localObject);
      }
      catch (JSONException localJSONException) {}
      this.this$0.jsPluginEngine.callbackJsEventFail(this.this$0.jsPluginEngine.getServiceRuntime(), "getBLEDeviceServices", null, paramInt);
      continue;
      return;
      continue;
      paramBluetoothGatt = null;
    }
  }
  
  public int readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.readCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
    if (paramBluetoothGattCharacteristic == null) {
      throw new MiniAppException("readCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
    }
    if ((this.gatt == null) || (this.state != 2)) {
      return 10006;
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0x2) < 1) {
      return 10007;
    }
    if (this.gatt.readCharacteristic(paramBluetoothGattCharacteristic)) {
      return 0;
    }
    return 10008;
  }
  
  public JSONObject toJson()
  {
    Object localObject3;
    Object localObject4;
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.putOpt("name", getDeviceName());
      localJSONObject.putOpt("localName", getDeviceName());
      localJSONObject.put("deviceId", this.mDevicesId);
      localJSONObject.put("RSSI", this.mRssi);
      ??? = new StringBuilder();
      if ((this.manufacturerData != null) && (this.manufacturerData.size() > 0))
      {
        int i = 0;
        while (i < this.manufacturerData.size())
        {
          ((StringBuilder)???).append(Base64.encodeToString((byte[])this.manufacturerData.valueAt(i), 2));
          i += 1;
        }
      }
      localJSONObject.put("advertisData", ???);
      localObject3 = new JSONArray();
      if ((this.mServiceUuids != null) && (this.mServiceUuids.size() > 0)) {
        synchronized (this.mServiceUuids)
        {
          localObject4 = this.mServiceUuids.iterator();
          if (((Iterator)localObject4).hasNext()) {
            ((JSONArray)localObject3).put(((ParcelUuid)((Iterator)localObject4).next()).toString().toUpperCase());
          }
        }
      }
    }
    catch (JSONException localJSONException)
    {
      return null;
    }
    localJSONException.put("advertisServiceUUIDs", localObject3);
    ??? = new JSONObject();
    if ((this.serviceData != null) && (this.serviceData.size() > 0))
    {
      localObject3 = this.serviceData.entrySet().iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Map.Entry)((Iterator)localObject3).next();
        ((JSONObject)???).put(((ParcelUuid)((Map.Entry)localObject4).getKey()).getUuid().toString().toUpperCase(), Base64.encodeToString((byte[])((Map.Entry)localObject4).getValue(), 2));
      }
    }
    localJSONException.put("serviceData", ???);
    return localJSONException;
  }
  
  public boolean writeCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    QLog.d("[mini] BluetoothJsPlugin", 2, "BluetoothDeviceExtend.writeCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
    if ((this.gatt == null) || (paramBluetoothGattCharacteristic == null)) {
      throw new MiniAppException("writeCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0x8) > 0) {
      return this.gatt.writeCharacteristic(paramBluetoothGattCharacteristic);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BluetoothJsPlugin.BluetoothDeviceExtend
 * JD-Core Version:    0.7.0.1
 */