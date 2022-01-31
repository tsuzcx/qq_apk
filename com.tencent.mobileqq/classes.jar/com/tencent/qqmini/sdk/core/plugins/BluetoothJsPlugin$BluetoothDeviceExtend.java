package com.tencent.qqmini.sdk.core.plugins;

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
import bgkd;
import com.tencent.qqmini.sdk.log.QMLog;
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
  Map<Integer, bgkd> blueToothServiceListeners = new HashMap();
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
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.connectGatt autoConnect=" + paramBoolean + ",timeout=" + paramLong + ",callbackId=" + paramInt);
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
        throw new RuntimeException("connectGatt is null");
      }
      BluetoothJsPlugin.access$400(this.this$0).removeCallbacks(this.connTimeoutJob);
    } while (paramLong <= 0L);
    BluetoothJsPlugin.access$400(this.this$0).postDelayed(this.connTimeoutJob, paramLong);
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
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.destory,,,,,,");
    disconnectGatt();
    synchronized (this.blueToothServiceListeners)
    {
      this.blueToothServiceListeners.clear();
      return;
    }
  }
  
  public boolean disconnectGatt()
  {
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.disconnectGatt,,,,,,");
    this.state = 0;
    BluetoothJsPlugin.access$400(this.this$0).removeCallbacks(this.connTimeoutJob);
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
  
  public void getServices(bgkd parambgkd)
  {
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.getServices callbackId=" + parambgkd.b);
    if (this.gatt == null) {
      throw new RuntimeException("getService exception, state=" + this.state + ",gatt=" + this.gatt);
    }
    if (!this.blueToothServiceListeners.containsKey(Integer.valueOf(parambgkd.b))) {
      this.blueToothServiceListeners.put(Integer.valueOf(parambgkd.b), parambgkd);
    }
    if (this.services != null) {
      onServicesDiscovered(this.gatt, 0);
    }
    do
    {
      return;
      if (this.lastConnectionTime + 600L > System.currentTimeMillis())
      {
        BluetoothJsPlugin.access$400(this.this$0).postDelayed(new BluetoothJsPlugin.BluetoothDeviceExtend.2(this, parambgkd), 600L);
        return;
      }
    } while (this.gatt.discoverServices());
    parambgkd.b();
  }
  
  public boolean notifyBLECharacteristicValueChange(BluetoothGattCharacteristic paramBluetoothGattCharacteristic, boolean paramBoolean)
  {
    int j = 1;
    boolean bool2 = false;
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.notifyBLECharacteristicValueChange c=" + paramBluetoothGattCharacteristic + ",state=" + paramBoolean);
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
      label79:
      if ((k & 0x20) <= 0) {
        break label169;
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
      break label79;
      label169:
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
      this.this$0.sendSubscribeEvent("onBLECharacteristicValueChange", localJSONObject.toString());
      return;
    }
    catch (JSONException paramBluetoothGatt) {}
  }
  
  public void onCharacteristicRead(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.onCharacteristicRead gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
  }
  
  public void onCharacteristicWrite(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.onCharacteristicWrite gatt=" + paramBluetoothGatt + ",characteristic=" + paramBluetoothGattCharacteristic + ",status=" + paramInt);
  }
  
  /* Error */
  public void onConnectionStateChange(BluetoothGatt arg1, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: ldc 106
    //   2: new 108	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   9: ldc_w 377
    //   12: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: aload_0
    //   16: getfield 154	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
    //   19: invokevirtual 246	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   22: ldc_w 372
    //   25: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: iload_2
    //   29: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   32: ldc_w 379
    //   35: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload_3
    //   39: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   42: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 137	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   48: aload_0
    //   49: getfield 45	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;
    //   52: invokestatic 179	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin:access$400	(Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;)Landroid/os/Handler;
    //   55: aload_0
    //   56: getfield 101	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:connTimeoutJob	Ljava/lang/Runnable;
    //   59: invokevirtual 185	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   62: aload_0
    //   63: iload_3
    //   64: putfield 50	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
    //   67: aload_0
    //   68: getfield 50	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:state	I
    //   71: iconst_2
    //   72: if_icmpne +184 -> 256
    //   75: aload_0
    //   76: invokestatic 267	java/lang/System:currentTimeMillis	()J
    //   79: putfield 259	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:lastConnectionTime	J
    //   82: aload_0
    //   83: getfield 45	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;
    //   86: invokestatic 383	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin:access$700	(Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
    //   89: astore_1
    //   90: aload_1
    //   91: monitorenter
    //   92: aload_0
    //   93: getfield 45	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;
    //   96: invokestatic 383	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin:access$700	(Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
    //   99: aload_0
    //   100: getfield 89	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
    //   103: invokevirtual 384	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   106: ifne +19 -> 125
    //   109: aload_0
    //   110: getfield 45	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;
    //   113: invokestatic 383	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin:access$700	(Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;)Ljava/util/HashMap;
    //   116: aload_0
    //   117: getfield 89	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
    //   120: aload_0
    //   121: invokevirtual 385	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   124: pop
    //   125: aload_1
    //   126: monitorexit
    //   127: iconst_1
    //   128: istore 4
    //   130: aload_0
    //   131: getfield 73	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
    //   134: astore_1
    //   135: aload_1
    //   136: monitorenter
    //   137: aload_0
    //   138: getfield 73	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
    //   141: invokeinterface 389 1 0
    //   146: astore 5
    //   148: aload 5
    //   150: invokeinterface 394 1 0
    //   155: ifeq +134 -> 289
    //   158: aload 5
    //   160: invokeinterface 398 1 0
    //   165: checkcast 139	java/lang/Integer
    //   168: invokevirtual 401	java/lang/Integer:intValue	()I
    //   171: istore_2
    //   172: ldc 106
    //   174: new 108	java/lang/StringBuilder
    //   177: dup
    //   178: invokespecial 109	java/lang/StringBuilder:<init>	()V
    //   181: ldc_w 403
    //   184: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: iload 4
    //   189: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   192: ldc_w 405
    //   195: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: iload_2
    //   199: invokevirtual 128	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   202: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   205: invokestatic 137	com/tencent/qqmini/sdk/log/QMLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: aload_0
    //   209: getfield 75	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothServiceListeners	Ljava/util/Map;
    //   212: iload_2
    //   213: invokestatic 143	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   216: invokeinterface 409 2 0
    //   221: checkcast 236	bgkd
    //   224: astore 6
    //   226: iload 4
    //   228: ifeq +52 -> 280
    //   231: aload 6
    //   233: invokevirtual 412	bgkd:a	()Ljava/lang/String;
    //   236: pop
    //   237: goto -89 -> 148
    //   240: astore 5
    //   242: aload_1
    //   243: monitorexit
    //   244: aload 5
    //   246: athrow
    //   247: astore_1
    //   248: return
    //   249: astore 5
    //   251: aload_1
    //   252: monitorexit
    //   253: aload 5
    //   255: athrow
    //   256: iload_3
    //   257: ifne +17 -> 274
    //   260: aload_0
    //   261: getfield 154	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
    //   264: ifnull +10 -> 274
    //   267: aload_0
    //   268: getfield 154	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:gatt	Landroid/bluetooth/BluetoothGatt;
    //   271: invokevirtual 163	android/bluetooth/BluetoothGatt:close	()V
    //   274: iconst_0
    //   275: istore 4
    //   277: goto -147 -> 130
    //   280: aload 6
    //   282: invokevirtual 277	bgkd:b	()Ljava/lang/String;
    //   285: pop
    //   286: goto -138 -> 148
    //   289: aload_0
    //   290: getfield 73	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:blueToothConnListeners	Ljava/util/List;
    //   293: invokeinterface 413 1 0
    //   298: aload_1
    //   299: monitorexit
    //   300: new 337	org/json/JSONObject
    //   303: dup
    //   304: invokespecial 338	org/json/JSONObject:<init>	()V
    //   307: astore_1
    //   308: aload_1
    //   309: ldc_w 340
    //   312: aload_0
    //   313: getfield 89	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:mDevicesId	Ljava/lang/String;
    //   316: invokevirtual 343	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   319: pop
    //   320: aload_1
    //   321: ldc_w 415
    //   324: iload 4
    //   326: invokevirtual 418	org/json/JSONObject:put	(Ljava/lang/String;Z)Lorg/json/JSONObject;
    //   329: pop
    //   330: aload_0
    //   331: getfield 45	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin$BluetoothDeviceExtend:this$0	Lcom/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin;
    //   334: ldc_w 420
    //   337: aload_1
    //   338: invokevirtual 361	org/json/JSONObject:toString	()Ljava/lang/String;
    //   341: invokevirtual 364	com/tencent/qqmini/sdk/core/plugins/BluetoothJsPlugin:sendSubscribeEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   344: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	BluetoothDeviceExtend
    //   0	345	2	paramInt1	int
    //   0	345	3	paramInt2	int
    //   128	197	4	bool	boolean
    //   146	13	5	localIterator	Iterator
    //   240	5	5	localObject1	Object
    //   249	5	5	localObject2	Object
    //   224	57	6	localbgkd	bgkd
    // Exception table:
    //   from	to	target	type
    //   137	148	240	finally
    //   148	226	240	finally
    //   231	237	240	finally
    //   242	244	240	finally
    //   280	286	240	finally
    //   289	300	240	finally
    //   48	92	247	org/json/JSONException
    //   130	137	247	org/json/JSONException
    //   244	247	247	org/json/JSONException
    //   253	256	247	org/json/JSONException
    //   260	274	247	org/json/JSONException
    //   300	344	247	org/json/JSONException
    //   92	125	249	finally
    //   125	127	249	finally
    //   251	253	249	finally
  }
  
  public void onServicesDiscovered(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.onServicesDiscovered gatt=" + paramBluetoothGatt + ",status=" + paramInt);
    Object localObject1 = null;
    Object localObject2;
    boolean bool;
    if (paramInt == 0)
    {
      this.services = paramBluetoothGatt.getServices();
      try
      {
        localObject1 = new JSONArray();
        if (this.services.size() > 0)
        {
          paramBluetoothGatt = this.services.iterator();
          for (;;)
          {
            if (paramBluetoothGatt.hasNext())
            {
              localObject2 = (BluetoothGattService)paramBluetoothGatt.next();
              JSONObject localJSONObject = new JSONObject();
              localJSONObject.put("uuid", ((BluetoothGattService)localObject2).getUuid().toString());
              if (((BluetoothGattService)localObject2).getType() == 0)
              {
                bool = true;
                localJSONObject.put("isPrimary", bool);
                ((JSONArray)localObject1).put(localJSONObject);
                continue;
                localObject1 = paramBluetoothGatt;
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
      paramBluetoothGatt = this.blueToothServiceListeners.keySet().iterator();
      for (;;)
      {
        for (;;)
        {
          if (!paramBluetoothGatt.hasNext()) {
            break label273;
          }
          paramInt = ((Integer)paramBluetoothGatt.next()).intValue();
          localObject2 = (bgkd)this.blueToothServiceListeners.get(Integer.valueOf(paramInt));
          if (localObject1 != null)
          {
            ((bgkd)localObject2).a((JSONObject)localObject1);
            continue;
            bool = false;
            break;
            paramBluetoothGatt = new JSONObject();
          }
          try
          {
            paramBluetoothGatt.put("services", localObject1);
            localObject1 = paramBluetoothGatt;
          }
          catch (JSONException localJSONException) {}
        }
        ((bgkd)localObject2).b();
      }
      label273:
      return;
    }
  }
  
  public int readCharacteristic(BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.readCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
    if (paramBluetoothGattCharacteristic == null) {
      throw new RuntimeException("readCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
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
    QMLog.d("BluetoothJsPlugin", "BluetoothDeviceExtend.writeCharacteristic c=" + paramBluetoothGattCharacteristic + ",state=" + this.state + ",gatt=" + this.gatt);
    if ((this.gatt == null) || (paramBluetoothGattCharacteristic == null)) {
      throw new RuntimeException("writeCharacteristic exception, state=" + this.state + ",gatt=" + this.gatt);
    }
    if ((paramBluetoothGattCharacteristic.getProperties() & 0x8) > 0) {
      return this.gatt.writeCharacteristic(paramBluetoothGattCharacteristic);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.BluetoothJsPlugin.BluetoothDeviceExtend
 * JD-Core Version:    0.7.0.1
 */