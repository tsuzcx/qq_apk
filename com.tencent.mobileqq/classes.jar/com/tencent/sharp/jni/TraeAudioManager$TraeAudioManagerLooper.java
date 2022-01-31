package com.tencent.sharp.jni;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import bhmj;
import bhmk;
import bhmm;
import bhmn;
import bhmo;
import bhmq;
import bhms;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import mwd;

public class TraeAudioManager$TraeAudioManagerLooper
  extends Thread
{
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  Handler jdField_a_of_type_AndroidOsHandler = null;
  bhms jdField_a_of_type_Bhms = null;
  TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
  String jdField_a_of_type_JavaLangString = "";
  boolean jdField_a_of_type_Boolean = false;
  final boolean[] jdField_a_of_type_ArrayOfBoolean = { false };
  public int b;
  long jdField_b_of_type_Long = -1L;
  String jdField_b_of_type_JavaLangString = "";
  public int c;
  String c;
  String d = "";
  
  public TraeAudioManager$TraeAudioManagerLooper(TraeAudioManager arg1, TraeAudioManager paramTraeAudioManager2)
  {
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_b_of_type_Int = 0;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager = paramTraeAudioManager2;
    long l = SystemClock.elapsedRealtime();
    if (QLog.isColorLevel()) {
      QLog.e("TraeAudioManager", 2, "TraeAudioManagerLooper start...");
    }
    start();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 0) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait();
      label152:
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "  start used:" + (SystemClock.elapsedRealtime() - l) + "ms");
      }
      return;
      paramTraeAudioManager2 = finally;
      throw paramTraeAudioManager2;
    }
    catch (InterruptedException paramTraeAudioManager2)
    {
      break label152;
    }
  }
  
  int a()
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.this$0.jdField_a_of_type_Int);
    if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " am==null!!");
      }
    }
    do
    {
      return -1;
      if (this.this$0.jdField_a_of_type_Int == 1) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TraeAudioManager", 2, " not ACTIVE_RING!!");
    return -1;
    this.this$0.jdField_a_of_type_Int = 0;
    if (this.this$0.jdField_b_of_type_Int != -1) {
      this.this$0.a(this.this$0.jdField_b_of_type_Int);
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_b_of_type_Long));
    localHashMap.put("PARAM_OPERATION", this.d);
    Intent localIntent = new Intent();
    this.this$0.a(localIntent, localHashMap, 6);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  int a(int paramInt)
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_STREAMTYPE_UPDATE");
    localIntent.putExtra("EXTRA_DATA_STREAMTYPE", paramInt);
    try
    {
      this.this$0.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyStreamTypeUpdate e = " + localException);
        }
      }
    }
  }
  
  public int a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null)
    {
      StringBuilder localStringBuilder = new StringBuilder().append(" fail mMsgHandler==null _enabled:");
      if (this.jdField_a_of_type_Boolean) {}
      for (paramHashMap = "Y";; paramHashMap = "N")
      {
        AudioDeviceInterface.LogTraceEntry(paramHashMap + " activeMode:" + this.this$0.jdField_a_of_type_Int + " msg:" + paramInt);
        return -1;
      }
    }
    paramHashMap = Message.obtain(this.jdField_a_of_type_AndroidOsHandler, paramInt, paramHashMap);
    if (this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramHashMap)) {}
    for (paramInt = 0;; paramInt = -1) {
      return paramInt;
    }
  }
  
  int a(long paramLong)
  {
    int i = 0;
    Object localObject;
    boolean bool;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("interruptRing begin, _activeMode[").append(this.this$0.jdField_a_of_type_Int).append("], _preRingMode[").append(this.jdField_b_of_type_Int).append("], _am[");
      if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager != null)
      {
        bool = true;
        QLog.w("TraeAudioManager", 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager != null) {
        break label112;
      }
      i = -1;
    }
    label112:
    do
    {
      return i;
      bool = false;
      break;
      if (this.this$0.jdField_a_of_type_Int != 2) {
        return -1;
      }
      this.jdField_a_of_type_Bhms.a(paramLong);
      e();
      this.this$0.jdField_a_of_type_Int = 0;
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
      ((HashMap)localObject).put("PARAM_OPERATION", this.jdField_a_of_type_JavaLangString);
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
      mwd.a((HashMap)localObject, paramLong);
      this.this$0.a(localIntent, (HashMap)localObject, 4);
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 1, "interruptRing end, _activeMode[" + this.this$0.jdField_a_of_type_Int + "], seq[" + paramLong + "]");
    return 0;
  }
  
  int a(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    Object localObject = this.this$0.jdField_a_of_type_Bhmk.a();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.this$0.jdField_a_of_type_Bhmk.a());
    this.this$0.a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int a(boolean paramBoolean)
  {
    if (this.this$0.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_SERVICE_STATE");
    localIntent.putExtra("NOTIFY_SERVICE_STATE_DATE", paramBoolean);
    this.this$0.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
    return 0;
  }
  
  public void a()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    long l = SystemClock.elapsedRealtime();
    this.jdField_a_of_type_AndroidOsHandler.getLooper().quit();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      int i = this.jdField_a_of_type_ArrayOfBoolean[0];
      if (i != 1) {}
    }
    try
    {
      this.jdField_a_of_type_ArrayOfBoolean.wait(10000L);
      label58:
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "  quit used:" + (SystemClock.elapsedRealtime() - l) + "ms");
      }
      this.jdField_a_of_type_AndroidOsHandler = null;
      AudioDeviceInterface.LogTraceExit();
      return;
      localObject = finally;
      throw localObject;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label58;
    }
  }
  
  @TargetApi(8)
  void a(int paramInt)
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener != null);
        this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new bhmo(this);
      } while (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null);
      int i = this.this$0.jdField_a_of_type_AndroidMediaAudioManager.requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, paramInt, 2);
      if ((i != 1) && (QLog.isColorLevel())) {
        QLog.e("TraeAudioManager", 2, "request audio focus fail. " + i + " mode:" + this.this$0.jdField_a_of_type_AndroidMediaAudioManager.getMode());
      }
      this.jdField_c_of_type_Int = paramInt;
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "-------requestAudioFocus _focusSteamType:" + this.jdField_c_of_type_Int);
  }
  
  void a(long paramLong)
  {
    if (AudioHelper.e()) {
      QLog.w("TraeAudioManager", 1, "stopService, _enabled[" + this.jdField_a_of_type_Boolean + "], _activeMode[" + this.this$0.jdField_a_of_type_Int + "], _switchThread[" + this.this$0.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread + "], seq[" + paramLong + "]");
    }
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    if (this.this$0.jdField_a_of_type_Int == 1) {
      a();
    }
    for (;;)
    {
      if (this.this$0.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread != null)
      {
        this.this$0.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread.b(paramLong);
        this.this$0.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$switchThread = null;
      }
      if (this.jdField_a_of_type_Bhms != null) {
        this.jdField_a_of_type_Bhms.a(paramLong);
      }
      this.jdField_a_of_type_Bhms = null;
      this.jdField_a_of_type_Boolean = false;
      a(this.jdField_a_of_type_Boolean);
      if ((this.this$0.jdField_a_of_type_AndroidMediaAudioManager != null) && (this.this$0.jdField_a_of_type_AndroidContentContext != null)) {}
      try
      {
        this.this$0.a(0);
        QLog.w("TraeAudioManager", 2, "NeedForceVolumeType: -1");
        TraeAudioManager.a(this.this$0.jdField_a_of_type_AndroidMediaAudioManager, -1);
        label216:
        d();
        AudioDeviceInterface.LogTraceExit();
        return;
        if (this.this$0.jdField_a_of_type_Int != 2) {
          continue;
        }
        a(paramLong);
      }
      catch (Exception localException)
      {
        break label216;
      }
    }
  }
  
  public void a(Message paramMessage)
  {
    long l;
    do
    {
      try
      {
        HashMap localHashMap = (HashMap)paramMessage.obj;
        l = mwd.a(localHashMap);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "doHandleMessage, msg[" + paramMessage.what + "], _enabled[" + this.jdField_a_of_type_Boolean + "], seq[" + l + "]");
        }
        if (paramMessage.what == 32772)
        {
          a(localHashMap);
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localObject = null;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          paramMessage = new Intent();
          this.this$0.a(paramMessage, (HashMap)localObject, 1);
          return;
        }
        switch (paramMessage.what)
        {
        default: 
          return;
        }
      }
      a(l);
      return;
      a((HashMap)localObject);
      return;
      this.this$0.b((HashMap)localObject);
      return;
      this.this$0.c((HashMap)localObject);
      return;
      this.this$0.d((HashMap)localObject);
      return;
      b((HashMap)localObject);
      return;
      c((HashMap)localObject);
      return;
      paramMessage = (Integer)((HashMap)localObject).get("PARAM_STREAMTYPE");
      if (paramMessage != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TraeAudioManager", 2, " MESSAGE_VOICECALL_AUIDOPARAM_CHANGED params.get(PARAM_STREAMTYPE)==null!!");
    return;
    this.this$0.jdField_c_of_type_Int = paramMessage.intValue();
    a(paramMessage.intValue());
    return;
    d((HashMap)localObject);
    return;
    e((HashMap)localObject);
    return;
    e();
    return;
    a(this.this$0.jdField_c_of_type_Int);
    return;
    f((HashMap)localObject);
    return;
    this.this$0.a();
    return;
    this.this$0.a(l, (HashMap)localObject);
    return;
    this.this$0.a((HashMap)localObject);
    return;
    paramMessage = this.this$0.jdField_a_of_type_Bhmk.b();
    String str = this.this$0.jdField_a_of_type_Bhmk.d();
    Object localObject = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "doHandleMessage, connectedDev[" + str + "], highestDev[" + paramMessage + "], connectDeviceNameWhenServiceOn[" + (String)localObject + "], seq[" + l + "]");
    }
    if ((localObject != null) && (this.this$0.jdField_a_of_type_Bhmk.b((String)localObject)))
    {
      paramMessage = (Message)localObject;
      if (QLog.isColorLevel())
      {
        QLog.w("TraeAudioManager", 1, "doHandleMessage, reset, highestDev[" + (String)localObject + "], seq[" + l + "]");
        paramMessage = (Message)localObject;
      }
    }
    for (;;)
    {
      if (!paramMessage.equals(str))
      {
        this.this$0.a(l, paramMessage, null);
        return;
      }
      this.this$0.a();
      return;
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (this.this$0.a(l, paramMessage, null) == 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_AUTO_DEVICELIST_PLUGIN_UPDATE, connected fail, plugDev[" + paramMessage + "], sessionConnectedDev[" + this.this$0.jdField_b_of_type_JavaLangString + "], seq[" + l + "]");
      }
      this.this$0.a(l, this.this$0.jdField_a_of_type_Bhmk.b(), null);
      return;
      if (this.this$0.a(l, this.this$0.jdField_b_of_type_JavaLangString, null) == 0) {
        break;
      }
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_AUTO_DEVICELIST_PLUGOUT_UPDATE, connected fail, plugDev[" + paramMessage + "], sessionConnectedDev[" + this.this$0.jdField_b_of_type_JavaLangString + "], seq[" + l + "]");
      }
      this.this$0.a(l, this.this$0.jdField_a_of_type_Bhmk.b(), null);
      return;
      paramMessage = (String)((HashMap)localObject).get("PARAM_DEVICE");
      if (this.this$0.jdField_a_of_type_JavaLangString.equals("DEVICE_BLUETOOTHHEADSET"))
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_BLUETOOTH_SCO_DISCONNECTED, plugDev[" + paramMessage + "], BTDisConnectSessionConnectedDev[" + this.this$0.jdField_a_of_type_JavaLangString + "], seq[" + l + "]");
        }
        this.this$0.a(l, this.this$0.jdField_a_of_type_Bhmk.a("DEVICE_BLUETOOTHHEADSET"), null);
        return;
      }
      if (this.this$0.a(l, this.this$0.jdField_a_of_type_JavaLangString, null) == 0) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "doHandleMessage.MESSAGE_BLUETOOTH_SCO_DISCONNECTED, connected fail, plugDev[" + paramMessage + "], BTDisConnectSessionConnectedDev[" + this.this$0.jdField_a_of_type_JavaLangString + "], seq[" + l + "]");
      }
      this.this$0.a(l, this.this$0.jdField_a_of_type_Bhmk.a("DEVICE_BLUETOOTHHEADSET"), null);
      return;
    }
  }
  
  void a(HashMap<String, Object> paramHashMap)
  {
    long l = mwd.a(paramHashMap);
    String str = (String)paramHashMap.get("EXTRA_DATA_DEVICECONFIG");
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "startService begin, _enabled[" + this.jdField_a_of_type_Boolean + "], _activeMode[" + this.this$0.jdField_a_of_type_Int + "], seq[" + l + "], cfg[" + str + "]");
    }
    if ((str == null) || (this.this$0.jdField_a_of_type_AndroidContentContext == null)) {}
    do
    {
      do
      {
        return;
      } while ((str.length() <= 0) || ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_JavaLangString.equals(str))) || (this.this$0.jdField_a_of_type_Int != 0));
      if (this.jdField_a_of_type_Boolean) {
        a(l);
      }
      c();
      this.this$0.jdField_a_of_type_Bhmk.a();
      this.this$0.jdField_a_of_type_Bhmk.a(str);
      this.jdField_c_of_type_JavaLangString = str;
      if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager != null) {
        this.jdField_a_of_type_Int = this.this$0.jdField_a_of_type_AndroidMediaAudioManager.getMode();
      }
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Bhms == null) {
        this.jdField_a_of_type_Bhms = new bhms(this.this$0.jdField_a_of_type_AndroidContentContext, new bhmm(this));
      }
      paramHashMap = (String)paramHashMap.get("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON");
      this.this$0.a(l, paramHashMap);
      a(this.jdField_a_of_type_Boolean);
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 1, "startService end, _enabled[" + this.jdField_a_of_type_Boolean + "], _activeMode[" + this.this$0.jdField_a_of_type_Int + "], seq[" + l + "]");
  }
  
  int b(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.this$0.jdField_a_of_type_Int);
    if (paramHashMap == null) {
      return -1;
    }
    if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " InternalVoicecallPreprocess am==null!!");
      }
      return -1;
    }
    if (this.this$0.jdField_a_of_type_Int == 1)
    {
      localObject = new Intent();
      this.this$0.a((Intent)localObject, paramHashMap, 2);
      return -1;
    }
    this.jdField_b_of_type_Long = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
    this.d = ((String)paramHashMap.get("PARAM_OPERATION"));
    this.this$0.jdField_a_of_type_Int = 1;
    this.this$0.jdField_b_of_type_JavaLangString = "DEVICE_NONE";
    this.this$0.jdField_b_of_type_Int = this.this$0.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODEPOLICY");
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " params.get(PARAM_MODEPOLICY)==null!!");
      }
      this.this$0.d = -1;
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "  _modePolicy:" + this.this$0.d);
      }
      localObject = (Integer)paramHashMap.get("PARAM_STREAMTYPE");
      if (localObject != null) {
        break label375;
      }
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " params.get(PARAM_STREAMTYPE)==null!!");
      }
      this.this$0.jdField_c_of_type_Int = 0;
      label271:
      if ((!TraeAudioManager.a(this.this$0.d)) || (this.this$0.jdField_a_of_type_Int == 2) || (this.this$0.jdField_a_of_type_Bhmk == null)) {
        break label405;
      }
      if (!this.this$0.jdField_a_of_type_Bhmk.d().equals("DEVICE_SPEAKERPHONE")) {
        break label389;
      }
      this.this$0.a(0);
      a(3);
    }
    for (;;)
    {
      localObject = new Intent();
      this.this$0.a((Intent)localObject, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      this.this$0.d = ((Integer)localObject).intValue();
      break;
      label375:
      this.this$0.jdField_c_of_type_Int = ((Integer)localObject).intValue();
      break label271;
      label389:
      this.this$0.a(3);
      a(0);
      continue;
      label405:
      this.this$0.a(TraeAudioManager.c(this.this$0.d));
      a(this.this$0.jdField_c_of_type_Int);
    }
  }
  
  void b()
  {
    AudioDeviceInterface.LogTraceEntry("");
    try
    {
      this.this$0.jdField_a_of_type_Bhmq = new bhmq();
      this.this$0.jdField_a_of_type_Bhmk = new bhmk(this.this$0);
      TraeAudioManager.e = Process.myPid();
      this.this$0.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.this$0.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
      this.this$0.jdField_a_of_type_Bhmj = this.this$0.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_Bhmk);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.this$0.jdField_a_of_type_Bhmj.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.this$0.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      AudioDeviceInterface.LogTraceExit();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, "======7");
        }
      }
    }
  }
  
  void b(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "_uninit begin, seq[" + paramLong + "]");
    }
    try
    {
      a(paramLong);
      if (this.this$0.jdField_a_of_type_Bhmj != null) {
        this.this$0.jdField_a_of_type_Bhmj.a();
      }
      this.this$0.jdField_a_of_type_Bhmj = null;
      if (this.this$0.jdField_a_of_type_AndroidContentContext != null)
      {
        this.this$0.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
        this.this$0.jdField_a_of_type_AndroidContentContext = null;
      }
      if (this.this$0.jdField_a_of_type_Bhmk != null) {
        this.this$0.jdField_a_of_type_Bhmk.a();
      }
      this.this$0.jdField_a_of_type_Bhmk = null;
    }
    catch (Exception localException)
    {
      label130:
      break label130;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "_uninit end, seq[" + paramLong + "]");
    }
  }
  
  int c(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.this$0.jdField_a_of_type_Int);
    if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " InternalVoicecallPostprocess am==null!!");
      }
      return -1;
    }
    if (this.this$0.jdField_a_of_type_Int != 1)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " not ACTIVE_VOICECALL!!");
      }
      localIntent = new Intent();
      this.this$0.a(localIntent, paramHashMap, 3);
      return -1;
    }
    this.this$0.jdField_a_of_type_Int = 0;
    e();
    Intent localIntent = new Intent();
    this.this$0.a(localIntent, paramHashMap, 0);
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  void c()
  {
    try
    {
      this.this$0.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.this$0.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
      if (this.this$0.jdField_a_of_type_Bhmj == null) {
        this.this$0.jdField_a_of_type_Bhmj = this.this$0.a(this.this$0.jdField_a_of_type_AndroidContentContext, this.this$0.jdField_a_of_type_Bhmk);
      }
      this.this$0.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
      IntentFilter localIntentFilter = new IntentFilter();
      localIntentFilter.addAction("android.intent.action.HEADSET_PLUG");
      localIntentFilter.addAction("android.media.AUDIO_BECOMING_NOISY");
      this.this$0.jdField_a_of_type_Bhmj.b(localIntentFilter);
      localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
      this.this$0.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      return;
    }
    catch (Exception localException) {}
  }
  
  public void c(long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(this.jdField_a_of_type_Long));
    localHashMap.put("PARAM_OPERATION", "NOTIFY_RING_COMPLETION");
    mwd.a(localHashMap, paramLong);
    Intent localIntent = new Intent();
    localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
    this.this$0.a(localIntent, localHashMap, 0);
  }
  
  int d(HashMap<String, Object> paramHashMap)
  {
    long l = mwd.a(paramHashMap);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("InternalStartRing begin, _activeMode[").append(this.this$0.jdField_a_of_type_Int).append("], _am[");
      if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null) {
        break label98;
      }
    }
    label98:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.w("TraeAudioManager", 1, bool1 + "], seq[" + l + "]");
      if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager != null) {
        break;
      }
      return -1;
    }
    if (this.this$0.jdField_a_of_type_Int == 2) {
      a(l);
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Long = ((Long)paramHashMap.get("PARAM_SESSIONID")).longValue();
        this.jdField_a_of_type_JavaLangString = ((String)paramHashMap.get("PARAM_OPERATION"));
        this.jdField_b_of_type_JavaLangString = ((String)paramHashMap.get("PARAM_RING_USERDATA_STRING"));
        int i = ((Integer)paramHashMap.get("PARAM_RING_DATASOURCE")).intValue();
        int j = ((Integer)paramHashMap.get("PARAM_RING_RSID")).intValue();
        localObject = (Uri)paramHashMap.get("PARAM_RING_URI");
        String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
        boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
        int k = ((Integer)paramHashMap.get("PARAM_RING_LOOPCOUNT")).intValue();
        boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
        if (this.this$0.jdField_a_of_type_Int != 1) {
          this.this$0.jdField_a_of_type_Int = 2;
        }
        Intent localIntent = new Intent();
        localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
        this.this$0.a(localIntent, paramHashMap, 0);
        this.jdField_b_of_type_Int = this.this$0.jdField_a_of_type_AndroidMediaAudioManager.getMode();
        paramHashMap = this.jdField_a_of_type_Bhms;
        if (this.this$0.jdField_a_of_type_Int == 1)
        {
          bool1 = true;
          bool1 = paramHashMap.a(l, i, j, (Uri)localObject, str, bool2, k, bool3, bool1, this.this$0.jdField_c_of_type_Int);
          if (!this.jdField_a_of_type_Bhms.a()) {
            a(this.jdField_a_of_type_Bhms.a());
          }
          a(this.jdField_a_of_type_Bhms.a());
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "InternalStartRing end, Userdata[" + this.jdField_b_of_type_JavaLangString + "], dataSource[" + i + "], DurationMS[" + this.jdField_a_of_type_Bhms.b() + "], ret[" + bool1 + "], seq[" + l + "]");
          }
          return 0;
        }
      }
      catch (Exception paramHashMap)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "InternalStartRing Exception, seq[" + l + "]", paramHashMap);
        }
        return -1;
      }
      bool1 = false;
    }
  }
  
  void d()
  {
    try
    {
      if (this.this$0.jdField_a_of_type_Bhmj != null) {
        this.this$0.jdField_a_of_type_Bhmj.a();
      }
      this.this$0.jdField_a_of_type_Bhmj = null;
      if (this.this$0.jdField_a_of_type_AndroidContentContext != null)
      {
        this.this$0.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        localIntentFilter.addAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST");
        this.this$0.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager, localIntentFilter);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  int e(HashMap<String, Object> paramHashMap)
  {
    int i = 0;
    long l = mwd.a(paramHashMap);
    QLog.w("TraeAudioManager", 1, "InternalStopRing begin, _activeMode[" + this.this$0.jdField_a_of_type_Int + "], _preRingMode[" + this.jdField_b_of_type_Int + "], seq[" + l + "]");
    if ((this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_Bhms == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " InternalStopRing am==null!!");
      }
      i = -1;
    }
    do
    {
      return i;
      this.jdField_a_of_type_Bhms.a(l);
      if ((!this.jdField_a_of_type_Bhms.a()) && (this.this$0.jdField_a_of_type_Int == 2))
      {
        e();
        this.this$0.jdField_a_of_type_Int = 0;
      }
      Intent localIntent = new Intent();
      localIntent.putExtra("PARAM_RING_USERDATA_STRING", this.jdField_b_of_type_JavaLangString);
      this.this$0.a(localIntent, paramHashMap, 0);
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 1, "InternalStopRing end, _activeMode[" + this.this$0.jdField_a_of_type_Int + "], _preRingMode[" + this.jdField_b_of_type_Int + "], seq[" + l + "]");
    return 0;
  }
  
  @TargetApi(8)
  void e()
  {
    if (Build.VERSION.SDK_INT <= 8) {}
    while ((this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null) || (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "-------abandonAudioFocus _focusSteamType:" + this.jdField_c_of_type_Int);
    }
    this.this$0.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener);
    this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  }
  
  int f(HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" activeMode:" + this.this$0.jdField_a_of_type_Int + " _preRingMode:" + this.jdField_b_of_type_Int);
    if (this.this$0.jdField_a_of_type_AndroidMediaAudioManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, " InternalStopRing am==null!!");
      }
      return -1;
    }
    if (this.this$0.jdField_a_of_type_Int == 2) {}
    for (int i = this.jdField_a_of_type_Bhms.a();; i = this.this$0.jdField_c_of_type_Int)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("EXTRA_DATA_STREAMTYPE", i);
      this.this$0.a(localIntent, paramHashMap, 0);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
  }
  
  public void run()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "TraeAudioManagerLooper.run begin, seq[" + l + "]");
    }
    Looper.prepare();
    this.jdField_a_of_type_AndroidOsHandler = new bhmn(this);
    b();
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = true;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      Looper.loop();
      b(l);
    }
    synchronized (this.jdField_a_of_type_ArrayOfBoolean)
    {
      this.jdField_a_of_type_ArrayOfBoolean[0] = false;
      this.jdField_a_of_type_ArrayOfBoolean.notify();
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "TraeAudioManagerLooper.run end, seq[" + l + "]");
      }
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager.TraeAudioManagerLooper
 * JD-Core Version:    0.7.0.1
 */