package com.tencent.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sharp.jni.api.impl.TraeMediaPlayerApiImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class TraeAudioManager
  extends BroadcastReceiver
{
  private static volatile TraeAudioManager n;
  DeviceConfigManager a = null;
  BluetoothHelper b = null;
  TraeMediaPlayerApiImpl c = null;
  String d = "";
  int e = 0;
  int f = 0;
  long g = -1L;
  String h = "";
  int i = 0;
  int j = -1;
  String k = "DEVICE_NONE";
  AudioManager.OnAudioFocusChangeListener l = null;
  int m = 0;
  private Context o;
  private AudioManager p = null;
  private DeviceSwitchThread q;
  private HandlerThread r = null;
  private TraeAudioManager.CustomHandler s = null;
  private volatile boolean t = false;
  private boolean u = false;
  private CopyOnWriteArrayList<TraeAudioManager.Notifier> v = new CopyOnWriteArrayList();
  
  private int a(String paramString, HashMap<String, Object> paramHashMap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalConnectDevice, deviceName[");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((DeviceConfigManager.a(paramString)) && (this.a.d(paramString)) && (this.a.k()))
    {
      if ((!this.a.h().equals("DEVICE_NONE")) && (this.a.h().equals(paramString)))
      {
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("internalConnectDevice, already connected[");
          paramHashMap.append(paramString);
          paramHashMap.append("]");
          QLog.i("TraeAudioManager", 2, paramHashMap.toString());
        }
        return 0;
      }
      this.a.f(paramString);
      localObject = this.q;
      if (localObject != null)
      {
        ((DeviceSwitchThread)localObject).a();
        this.q = null;
      }
      this.q = DeviceSwitchThread.a(this.o, paramString);
      paramString = this.q;
      if (paramString != null) {
        paramString.a(new TraeAudioManager.DeviceConnectStatusListener(this, paramHashMap), this.b);
      }
      return 0;
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("checkDeviceName [");
    paramHashMap.append(DeviceConfigManager.a(paramString));
    paramHashMap.append("], visible[");
    paramHashMap.append(this.a.d(paramString));
    paramHashMap.append("], changeable[");
    paramHashMap.append(this.a.k());
    paramHashMap.append("]");
    QLog.e("TraeAudioManager", 1, paramHashMap.toString());
    return -1;
  }
  
  private int a(HashMap<String, Object> paramHashMap, int paramInt)
  {
    if (paramHashMap == null)
    {
      QLog.e("TraeAudioManager", 1, "sendResMessage, empty params");
      return -1;
    }
    Object localObject = (Long)paramHashMap.get("KEY_SESSION_ID");
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendResMessage, sessionID[");
      localStringBuilder.append(localObject);
      localStringBuilder.append("]");
      QLog.w("TraeAudioManager", 2, localStringBuilder.toString());
    }
    if ((localObject != null) && (((Long)localObject).longValue() != -9223372036854775808L))
    {
      paramHashMap.put("EXTRA_RES_ERROR_CODE", Integer.valueOf(paramInt));
      localObject = this.v.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TraeAudioManager.Notifier)((Iterator)localObject).next()).notify(6, paramHashMap);
      }
      return 0;
    }
    k();
    return -1;
  }
  
  public static TraeAudioManager a()
  {
    if (n == null) {
      try
      {
        if (n == null) {
          n = new TraeAudioManager();
        }
      }
      finally {}
    }
    return n;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_STREAM_TYPE", Integer.valueOf(paramInt));
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      ((TraeAudioManager.Notifier)localIterator.next()).notify(5, localHashMap);
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("name");
    boolean bool = false;
    int i1 = paramIntent.getIntExtra("state", 0);
    int i2 = paramIntent.getIntExtra("microphone", 0);
    paramIntent = this.a;
    if (i1 == 1) {
      bool = true;
    }
    paramIntent.a("DEVICE_WIRED_HEADSET", bool);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("receive wire headset plug, name[");
      paramIntent = str;
      if (str == null) {
        paramIntent = "unknown";
      }
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("], state[");
      localStringBuilder.append(i1);
      localStringBuilder.append("], microphone[");
      localStringBuilder.append(i2);
      localStringBuilder.append("]");
      QLog.i("TraeAudioManager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString)
  {
    if (this.a.c())
    {
      j();
      this.a.d();
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_CONNECT_DEVICE_WHEN_START_SERVICE", paramString);
      this.s.a(32869, localHashMap);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.a.c())
    {
      j();
      this.a.d();
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_DEVICE_NAME", paramString);
      if (paramBoolean)
      {
        this.s.a(32870, localHashMap);
        return;
      }
      this.s.a(32871, localHashMap);
    }
  }
  
  private void a(HashMap<String, Object> paramHashMap)
  {
    String str = (String)paramHashMap.get("PARAM_DEVICE_CONFIG");
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "startService, empty config");
      }
      return;
    }
    if (this.u) {
      if ((!this.d.equals(str)) && (this.e == 0))
      {
        e();
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("startService failed, config[");
          paramHashMap.append(str);
          paramHashMap.append("], lastConfig[");
          paramHashMap.append(this.d);
          paramHashMap.append("], mActiveMode[");
          paramHashMap.append(this.e);
          paramHashMap.append("]");
          QLog.e("TraeAudioManager", 2, paramHashMap.toString());
        }
        return;
      }
    }
    c();
    this.a.b();
    this.a.b(str);
    this.d = str;
    this.u = true;
    if (this.c == null)
    {
      this.c = new TraeMediaPlayerApiImpl();
      this.c.init(this.o, new TraeAudioManager.1(this));
    }
    paramHashMap = (String)paramHashMap.get("PARAM_CONNECT_DEVICE_WHEN_START_SERVICE");
    int i2 = this.a.f();
    int i1 = 0;
    while (i1 < i2)
    {
      str = this.a.a(i1);
      if (str != null) {
        if (str.equals("DEVICE_BLUETOOTH_HEADSET"))
        {
          DeviceConfigManager localDeviceConfigManager = this.a;
          BluetoothHelper localBluetoothHelper = this.b;
          boolean bool;
          if ((localBluetoothHelper != null) && (localBluetoothHelper.c())) {
            bool = true;
          } else {
            bool = false;
          }
          localDeviceConfigManager.a(str, bool);
        }
        else if (str.equals("DEVICE_WIRED_HEADSET"))
        {
          this.a.a(str, this.p.isWiredHeadsetOn());
        }
        else if (str.equals("DEVICE_SPEAKERPHONE"))
        {
          this.a.a(str, true);
        }
      }
      i1 += 1;
    }
    a(paramHashMap);
    a(true);
  }
  
  private void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_SERVICE_STATE", Boolean.valueOf(paramBoolean));
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      ((TraeAudioManager.Notifier)localIterator.next()).notify(2, localHashMap);
    }
  }
  
  private BluetoothHelper b(Context paramContext)
  {
    BluetoothHelper localBluetoothHelper = new BluetoothHelper();
    if (!localBluetoothHelper.a(paramContext, new TraeAudioManager.BluetoothStatusListener(this, null))) {
      return null;
    }
    return localBluetoothHelper;
  }
  
  private void b(int paramInt)
  {
    if (this.l == null)
    {
      this.l = new TraeAudioManager.2(this);
      Object localObject = this.p;
      if (localObject != null)
      {
        int i1 = ((AudioManager)localObject).requestAudioFocus(this.l, paramInt, 2);
        if ((i1 != 1) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestAudioFocus fail, ret[");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append("], mode[");
          ((StringBuilder)localObject).append(this.p.getMode());
          ((StringBuilder)localObject).append("]");
          QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
        }
        this.m = paramInt;
      }
    }
  }
  
  private void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_CHANGEABLE_STATE", Boolean.valueOf(this.a.k()));
    localHashMap.put("EXTRA_CONNECT_DEVICE_NAME", paramString);
    paramString = this.v.iterator();
    while (paramString.hasNext()) {
      ((TraeAudioManager.Notifier)paramString.next()).notify(3, localHashMap);
    }
  }
  
  private void b(HashMap<String, Object> paramHashMap)
  {
    ArrayList localArrayList = this.a.j();
    String str1 = this.a.h();
    String str2 = this.a.i();
    String str3 = this.a.e();
    paramHashMap.put("EXTRA_DATA_VISIBLE_DEVICE_LIST", localArrayList.toArray(new String[0]));
    paramHashMap.put("EXTRA_DATA_CONNECTED_DEVICE", str1);
    paramHashMap.put("EXTRA_DATA_PREV_CONNECTED_DEVICE", str2);
    paramHashMap.put("EXTRA_DATA_BLUETOOTH_NAME", str3);
    a(paramHashMap, 0);
  }
  
  private void c()
  {
    try
    {
      if ((this.b == null) && (this.o != null))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "prev_startService");
        }
        this.b = b(this.o);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void c(HashMap<String, Object> paramHashMap)
  {
    int i1;
    if (this.e == 2) {
      i1 = this.c.getStreamType();
    } else {
      i1 = this.i;
    }
    paramHashMap.put("EXTRA_DATA_STREAM_TYPE", Integer.valueOf(i1));
    a(paramHashMap, 0);
  }
  
  private void d()
  {
    try
    {
      if (this.b != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "post_stopService");
        }
        this.b.a();
        this.b = null;
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private void d(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (this.o == null) {
        return;
      }
      String str = (String)paramHashMap.get("PARAM_DEVICE_NAME");
      int i1 = 0;
      boolean bool = this.a.k();
      if (!DeviceConfigManager.a(str))
      {
        i1 = 4;
      }
      else if (!this.a.d(str))
      {
        i1 = 5;
      }
      else if (!bool)
      {
        i1 = 6;
        this.k = str;
      }
      Object localObject = paramHashMap.get("KEY_SESSION_ID");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("internalSessionConnectDevice, sessionId[");
        localStringBuilder.append(localObject);
        localStringBuilder.append("], devName[");
        localStringBuilder.append(str);
        localStringBuilder.append("], changeable[");
        localStringBuilder.append(bool);
        localStringBuilder.append("], errorCode[");
        localStringBuilder.append(i1);
        localStringBuilder.append("]");
        QLog.w("TraeAudioManager", 1, localStringBuilder.toString());
      }
      if ((i1 == 0) && (!this.a.h().equals(str)))
      {
        a(str, paramHashMap);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" internalSessionConnectDevice error[");
        ((StringBuilder)localObject).append(i1);
        ((StringBuilder)localObject).append("], connectedDevice[");
        ((StringBuilder)localObject).append(this.a.h());
        ((StringBuilder)localObject).append("]");
        QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
      }
      paramHashMap.put("EXTRA_CONNECT_DEVICE_NAME", str);
      a(paramHashMap, i1);
    }
  }
  
  private void e()
  {
    if (!this.u) {
      return;
    }
    int i1 = this.e;
    if (i1 == 1) {
      h();
    } else if (i1 == 2) {
      i();
    }
    Object localObject = this.q;
    if (localObject != null)
    {
      ((DeviceSwitchThread)localObject).a();
      this.q = null;
    }
    localObject = this.c;
    if (localObject != null)
    {
      ((TraeMediaPlayerApiImpl)localObject).stopRing(0L);
      this.c = null;
    }
    this.u = false;
    a(false);
    try
    {
      TraeUtils.a(this.o, 0);
      TraeUtils.a(this.p, -1);
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("internalStopService exception[");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("]");
      QLog.e("TraeAudioManager", 1, localStringBuilder.toString());
    }
    d();
  }
  
  private void e(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("EXTRA_DATA_CONNECTED_DEVICE_NAME", this.a.h());
    a(paramHashMap, 0);
  }
  
  private void f()
  {
    this.e = 0;
    m();
  }
  
  private void f(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    if (this.e == 1)
    {
      a(paramHashMap, 2);
      return;
    }
    this.g = ((Long)paramHashMap.get("KEY_SESSION_ID")).longValue();
    this.h = ((String)paramHashMap.get("KEY_OPERATION"));
    this.e = 1;
    this.k = "DEVICE_NONE";
    this.f = this.p.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODE_POLICY");
    Integer localInteger = (Integer)paramHashMap.get("PARAM_STREAM_TYPE");
    int i1;
    if (localObject == null) {
      i1 = -1;
    } else {
      i1 = ((Integer)localObject).intValue();
    }
    this.j = i1;
    if (localInteger == null) {
      i1 = 0;
    } else {
      i1 = localInteger.intValue();
    }
    this.i = i1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalVoiceCallPreProcess, mode[");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append("], mStreamType[");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append("]");
      QLog.d("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    TraeUtils.a(this.o, TraeUtils.c(this.j));
    b(this.i);
    a(paramHashMap, 0);
  }
  
  private void g()
  {
    this.c.stopRing(0L);
    if ((!this.c.hasCall()) && (this.e == 2))
    {
      m();
      this.e = 0;
    }
  }
  
  private void g(HashMap<String, Object> paramHashMap)
  {
    if (this.e == 2) {
      i();
    }
    try
    {
      localObject = (String)paramHashMap.get("PARAM_RING_USERDATA_STRING");
      int i1 = ((Integer)paramHashMap.get("PARAM_RING_DATA_SOURCE")).intValue();
      int i2 = ((Integer)paramHashMap.get("PARAM_RING_RESOURCE_ID")).intValue();
      Uri localUri = (Uri)paramHashMap.get("PARAM_RING_URI");
      String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
      boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
      int i3 = ((Integer)paramHashMap.get("PARAM_RING_LOOP_COUNT")).intValue();
      boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
      if (this.e != 1) {
        this.e = 2;
      }
      paramHashMap = this.c;
      if (this.e == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool1 = paramHashMap.playRing(0L, i1, i2, localUri, str, bool2, i3, bool3, bool1, this.i);
      if (!this.c.hasCall()) {
        b(this.c.getStreamType());
      }
      a(this.c.getStreamType());
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("InternalStartRing end, Userdata[");
        paramHashMap.append((String)localObject);
        paramHashMap.append("], dataSource[");
        paramHashMap.append(i1);
        paramHashMap.append("], DurationMS[");
        paramHashMap.append(this.c.getDuration());
        paramHashMap.append("], ret[");
        paramHashMap.append(bool1);
        paramHashMap.append("]");
        QLog.w("TraeAudioManager", 1, paramHashMap.toString());
      }
      return;
    }
    catch (Exception paramHashMap)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("InternalStartRing exception[");
      ((StringBuilder)localObject).append(paramHashMap.getMessage());
      ((StringBuilder)localObject).append("]");
      QLog.w("TraeAudioManager", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  private void h()
  {
    if (this.e != 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("interruptVoiceCall failed, mActiveMode[");
        ((StringBuilder)localObject).append(this.e);
        ((StringBuilder)localObject).append("]");
        QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.e = 0;
    int i1 = this.f;
    if (i1 != -1) {
      TraeUtils.a(this.o, i1);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("KEY_SESSION_ID", Long.valueOf(this.g));
    ((HashMap)localObject).put("KEY_OPERATION", this.h);
    a((HashMap)localObject, 3);
  }
  
  private void i()
  {
    if (this.e != 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("interruptRing failed, mActiveMode[");
        localStringBuilder.append(this.e);
        localStringBuilder.append("]");
        QLog.e("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return;
    }
    this.c.stopRing(0L);
    m();
    this.e = 0;
  }
  
  private void j()
  {
    if (this.a.d("DEVICE_WIRED_HEADSET"))
    {
      this.a.a("DEVICE_EARPHONE", false);
      return;
    }
    this.a.a("DEVICE_EARPHONE", true);
  }
  
  private void k()
  {
    Object localObject = this.a.j();
    String str1 = this.a.h();
    String str2 = this.a.i();
    String str3 = this.a.e();
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_VISIBLE_DEVICE_LIST", ((ArrayList)localObject).toArray(new String[0]));
    localHashMap.put("EXTRA_DATA_CONNECTED_DEVICE", str1);
    localHashMap.put("EXTRA_DATA_PREV_CONNECTED_DEVICE", str2);
    localHashMap.put("EXTRA_DATA_BLUETOOTH_NAME", str3);
    localObject = this.v.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TraeAudioManager.Notifier)((Iterator)localObject).next()).notify(4, localHashMap);
    }
  }
  
  private void l()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.v.iterator();
    while (localIterator.hasNext()) {
      ((TraeAudioManager.Notifier)localIterator.next()).notify(1, localHashMap);
    }
  }
  
  private void m()
  {
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.l;
    if (localOnAudioFocusChangeListener != null)
    {
      this.p.abandonAudioFocus(localOnAudioFocusChangeListener);
      this.l = null;
    }
  }
  
  public int a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    TraeAudioManager.CustomHandler localCustomHandler = this.s;
    if (localCustomHandler != null) {
      return localCustomHandler.a(paramInt, paramHashMap);
    }
    return -1;
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      if (!this.t)
      {
        this.o = paramContext;
        this.p = ((AudioManager)this.o.getSystemService("audio"));
        this.a = DeviceConfigManager.a();
        this.b = b(this.o);
        paramContext = new IntentFilter();
        paramContext.addAction("android.intent.action.HEADSET_PLUG");
        BluetoothHelper.a(paramContext);
        this.o.registerReceiver(this, paramContext);
        this.r = new HandlerThread("TraeAudioManager");
        this.r.start();
        this.s = new TraeAudioManager.CustomHandler(this, this.r.getLooper());
        this.t = true;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], isInit[");
      localStringBuilder.append(this.t);
      localStringBuilder.append("]");
      QLog.e("TraeAudioManager", 1, localStringBuilder.toString());
      return;
    }
    finally {}
  }
  
  public void a(boolean paramBoolean, TraeAudioManager.Notifier paramNotifier)
  {
    try
    {
      if (this.t) {
        if (paramBoolean) {
          this.v.add(paramNotifier);
        } else {
          this.v.remove(paramNotifier);
        }
      }
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      if (!this.t)
      {
        QLog.e("TraeAudioManager", 1, "already release");
        return;
      }
      this.t = false;
      e();
      if (this.a != null)
      {
        this.a.b();
        this.a = null;
      }
      if (this.b != null)
      {
        this.b.a();
        this.b = null;
      }
      if (this.o != null)
      {
        this.o.unregisterReceiver(this);
        this.o = null;
      }
      if (this.r != null)
      {
        this.r.quit();
        this.r = null;
        this.s = null;
      }
      n = null;
      return;
    }
    finally {}
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent != null) && (paramContext != null))
    {
      try
      {
        boolean bool3 = "android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction());
        boolean bool2 = false;
        boolean bool1 = false;
        if (bool3)
        {
          bool2 = this.a.d("DEVICE_WIRED_HEADSET");
          a(paramIntent);
          if (bool2 != this.a.d("DEVICE_WIRED_HEADSET"))
          {
            if (!bool2) {
              bool1 = true;
            }
            a("DEVICE_WIRED_HEADSET", bool1);
          }
        }
        else
        {
          bool3 = this.a.d("DEVICE_BLUETOOTH_HEADSET");
          if (this.b != null) {
            this.b.a(paramIntent);
          }
          if (bool3 != this.a.d("DEVICE_BLUETOOTH_HEADSET"))
          {
            bool1 = bool2;
            if (!bool3) {
              bool1 = true;
            }
            a("DEVICE_BLUETOOTH_HEADSET", bool1);
            return;
          }
        }
      }
      catch (Exception paramContext)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive exception[");
        paramIntent.append(paramContext.getMessage());
        paramIntent.append("]");
        QLog.w("TraeAudioManager", 1, paramIntent.toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onReceive, intent[");
      localStringBuilder.append(paramIntent);
      localStringBuilder.append("], context[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("]");
      QLog.d("TraeAudioManager", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */