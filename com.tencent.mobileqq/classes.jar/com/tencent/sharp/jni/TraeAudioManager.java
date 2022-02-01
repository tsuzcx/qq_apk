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
  private static volatile TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager;
  int jdField_a_of_type_Int = 0;
  long jdField_a_of_type_Long = -1L;
  private Context jdField_a_of_type_AndroidContentContext;
  AudioManager.OnAudioFocusChangeListener jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager = null;
  private HandlerThread jdField_a_of_type_AndroidOsHandlerThread = null;
  BluetoothHelper jdField_a_of_type_ComTencentSharpJniBluetoothHelper = null;
  DeviceConfigManager jdField_a_of_type_ComTencentSharpJniDeviceConfigManager = null;
  private DeviceSwitchThread jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread;
  private TraeAudioManager.CustomHandler jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler = null;
  TraeMediaPlayerApiImpl jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl = null;
  String jdField_a_of_type_JavaLangString = "";
  private CopyOnWriteArrayList<TraeAudioManager.Notifier> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private volatile boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = "";
  private boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = 0;
  String jdField_c_of_type_JavaLangString = "DEVICE_NONE";
  int d = -1;
  int e = 0;
  
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
    if ((DeviceConfigManager.a(paramString)) && (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c(paramString)) && (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b()))
    {
      if ((!this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c().equals("DEVICE_NONE")) && (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c().equals(paramString)))
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
      this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b(paramString);
      localObject = this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread;
      if (localObject != null)
      {
        ((DeviceSwitchThread)localObject).a();
        this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread = null;
      }
      this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread = DeviceSwitchThread.a(this.jdField_a_of_type_AndroidContentContext, paramString);
      paramString = this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread;
      if (paramString != null) {
        paramString.a(new TraeAudioManager.DeviceConnectStatusListener(this, paramHashMap), this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper);
      }
      return 0;
    }
    paramHashMap = new StringBuilder();
    paramHashMap.append("checkDeviceName [");
    paramHashMap.append(DeviceConfigManager.a(paramString));
    paramHashMap.append("], visible[");
    paramHashMap.append(this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c(paramString));
    paramHashMap.append("], changeable[");
    paramHashMap.append(this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b());
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
      localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((TraeAudioManager.Notifier)((Iterator)localObject).next()).notify(6, paramHashMap);
      }
      return 0;
    }
    h();
    return -1;
  }
  
  private BluetoothHelper a(Context paramContext)
  {
    BluetoothHelper localBluetoothHelper = new BluetoothHelper();
    if (!localBluetoothHelper.a(paramContext, new TraeAudioManager.BluetoothStatusListener(this, null))) {
      return null;
    }
    return localBluetoothHelper;
  }
  
  public static TraeAudioManager a()
  {
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager == null) {
          jdField_a_of_type_ComTencentSharpJniTraeAudioManager = new TraeAudioManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentSharpJniTraeAudioManager;
  }
  
  private void a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_STREAM_TYPE", Integer.valueOf(paramInt));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TraeAudioManager.Notifier)localIterator.next()).notify(5, localHashMap);
    }
  }
  
  private void a(Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("name");
    boolean bool = false;
    int i = paramIntent.getIntExtra("state", 0);
    int j = paramIntent.getIntExtra("microphone", 0);
    paramIntent = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager;
    if (i == 1) {
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
      localStringBuilder.append(i);
      localStringBuilder.append("], microphone[");
      localStringBuilder.append(j);
      localStringBuilder.append("]");
      QLog.i("TraeAudioManager", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a())
    {
      g();
      this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b();
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_CONNECT_DEVICE_WHEN_START_SERVICE", paramString);
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler.a(32869, localHashMap);
    }
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a())
    {
      g();
      this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b();
      HashMap localHashMap = new HashMap();
      localHashMap.put("PARAM_DEVICE_NAME", paramString);
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler.a(32870, localHashMap);
        return;
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler.a(32871, localHashMap);
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
    if (this.jdField_b_of_type_Boolean) {
      if ((!this.jdField_a_of_type_JavaLangString.equals(str)) && (this.jdField_a_of_type_Int == 0))
      {
        b();
      }
      else
      {
        if (QLog.isColorLevel())
        {
          paramHashMap = new StringBuilder();
          paramHashMap.append("startService failed, config[");
          paramHashMap.append(str);
          paramHashMap.append("], lastConfig[");
          paramHashMap.append(this.jdField_a_of_type_JavaLangString);
          paramHashMap.append("], mActiveMode[");
          paramHashMap.append(this.jdField_a_of_type_Int);
          paramHashMap.append("]");
          QLog.e("TraeAudioManager", 2, paramHashMap.toString());
        }
        return;
      }
    }
    this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
    this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b(str);
    this.jdField_a_of_type_JavaLangString = str;
    this.jdField_b_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl == null)
    {
      this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl = new TraeMediaPlayerApiImpl();
      this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.init(this.jdField_a_of_type_AndroidContentContext, new TraeAudioManager.1(this));
    }
    paramHashMap = (String)paramHashMap.get("PARAM_CONNECT_DEVICE_WHEN_START_SERVICE");
    int j = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
    int i = 0;
    while (i < j)
    {
      str = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a(i);
      if (str != null) {
        if (str.equals("DEVICE_BLUETOOTH_HEADSET"))
        {
          DeviceConfigManager localDeviceConfigManager = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager;
          BluetoothHelper localBluetoothHelper = this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper;
          boolean bool;
          if ((localBluetoothHelper != null) && (localBluetoothHelper.a())) {
            bool = true;
          } else {
            bool = false;
          }
          localDeviceConfigManager.a(str, bool);
        }
        else if (str.equals("DEVICE_WIRED_HEADSET"))
        {
          this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a(str, this.jdField_a_of_type_AndroidMediaAudioManager.isWiredHeadsetOn());
        }
        else if (str.equals("DEVICE_SPEAKERPHONE"))
        {
          this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a(str, true);
        }
      }
      i += 1;
    }
    a(paramHashMap);
    a(true);
  }
  
  private void a(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_SERVICE_STATE", Boolean.valueOf(paramBoolean));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TraeAudioManager.Notifier)localIterator.next()).notify(2, localHashMap);
    }
  }
  
  private void b()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 1) {
      e();
    } else if (i == 2) {
      f();
    }
    Object localObject = this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread;
    if (localObject != null)
    {
      ((DeviceSwitchThread)localObject).a();
      this.jdField_a_of_type_ComTencentSharpJniDeviceSwitchThread = null;
    }
    localObject = this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl;
    if (localObject != null)
    {
      ((TraeMediaPlayerApiImpl)localObject).stopRing(0L);
      this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl = null;
    }
    this.jdField_b_of_type_Boolean = false;
    a(false);
    try
    {
      TraeUtils.a(this.jdField_a_of_type_AndroidContentContext, 0);
      TraeUtils.a(this.jdField_a_of_type_AndroidMediaAudioManager, -1);
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("internalStopService exception[");
      localStringBuilder.append(localException.getMessage());
      localStringBuilder.append("]");
      QLog.e("TraeAudioManager", 1, localStringBuilder.toString());
    }
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener == null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = new TraeAudioManager.2(this);
      Object localObject = this.jdField_a_of_type_AndroidMediaAudioManager;
      if (localObject != null)
      {
        int i = ((AudioManager)localObject).requestAudioFocus(this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener, paramInt, 2);
        if ((i != 1) && (QLog.isColorLevel()))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("requestAudioFocus fail, ret[");
          ((StringBuilder)localObject).append(i);
          ((StringBuilder)localObject).append("], mode[");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_AndroidMediaAudioManager.getMode());
          ((StringBuilder)localObject).append("]");
          QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
        }
        this.e = paramInt;
      }
    }
  }
  
  private void b(String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_CHANGEABLE_STATE", Boolean.valueOf(this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b()));
    localHashMap.put("EXTRA_CONNECT_DEVICE_NAME", paramString);
    paramString = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (paramString.hasNext()) {
      ((TraeAudioManager.Notifier)paramString.next()).notify(3, localHashMap);
    }
  }
  
  private void b(HashMap<String, Object> paramHashMap)
  {
    ArrayList localArrayList = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
    String str1 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c();
    String str2 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.d();
    String str3 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
    paramHashMap.put("EXTRA_DATA_VISIBLE_DEVICE_LIST", localArrayList.toArray(new String[0]));
    paramHashMap.put("EXTRA_DATA_CONNECTED_DEVICE", str1);
    paramHashMap.put("EXTRA_DATA_PREV_CONNECTED_DEVICE", str2);
    paramHashMap.put("EXTRA_DATA_BLUETOOTH_NAME", str3);
    a(paramHashMap, 0);
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 0;
    j();
  }
  
  private void c(HashMap<String, Object> paramHashMap)
  {
    int i;
    if (this.jdField_a_of_type_Int == 2) {
      i = this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.getStreamType();
    } else {
      i = this.jdField_c_of_type_Int;
    }
    paramHashMap.put("EXTRA_DATA_STREAM_TYPE", Integer.valueOf(i));
    a(paramHashMap, 0);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.stopRing(0L);
    if ((!this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.hasCall()) && (this.jdField_a_of_type_Int == 2))
    {
      j();
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  private void d(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap != null)
    {
      if (this.jdField_a_of_type_AndroidContentContext == null) {
        return;
      }
      String str = (String)paramHashMap.get("PARAM_DEVICE_NAME");
      int i = 0;
      boolean bool = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.b();
      if (!DeviceConfigManager.a(str))
      {
        i = 4;
      }
      else if (!this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c(str))
      {
        i = 5;
      }
      else if (!bool)
      {
        i = 6;
        this.jdField_c_of_type_JavaLangString = str;
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
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        QLog.w("TraeAudioManager", 1, localStringBuilder.toString());
      }
      if ((i == 0) && (!this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c().equals(str)))
      {
        a(str, paramHashMap);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(" internalSessionConnectDevice error[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("], connectedDevice[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c());
        ((StringBuilder)localObject).append("]");
        QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
      }
      paramHashMap.put("EXTRA_CONNECT_DEVICE_NAME", str);
      a(paramHashMap, i);
    }
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Int != 1)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("interruptVoiceCall failed, mActiveMode[");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("]");
        QLog.e("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    this.jdField_a_of_type_Int = 0;
    int i = this.jdField_b_of_type_Int;
    if (i != -1) {
      TraeUtils.a(this.jdField_a_of_type_AndroidContentContext, i);
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("KEY_SESSION_ID", Long.valueOf(this.jdField_a_of_type_Long));
    ((HashMap)localObject).put("KEY_OPERATION", this.jdField_b_of_type_JavaLangString);
    a((HashMap)localObject, 3);
  }
  
  private void e(HashMap<String, Object> paramHashMap)
  {
    paramHashMap.put("EXTRA_DATA_CONNECTED_DEVICE_NAME", this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c());
    a(paramHashMap, 0);
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_Int != 2)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("interruptRing failed, mActiveMode[");
        localStringBuilder.append(this.jdField_a_of_type_Int);
        localStringBuilder.append("]");
        QLog.e("TraeAudioManager", 2, localStringBuilder.toString());
      }
      return;
    }
    this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.stopRing(0L);
    j();
    this.jdField_a_of_type_Int = 0;
  }
  
  private void f(HashMap<String, Object> paramHashMap)
  {
    if (paramHashMap == null) {
      return;
    }
    if (this.jdField_a_of_type_Int == 1)
    {
      a(paramHashMap, 2);
      return;
    }
    this.jdField_a_of_type_Long = ((Long)paramHashMap.get("KEY_SESSION_ID")).longValue();
    this.jdField_b_of_type_JavaLangString = ((String)paramHashMap.get("KEY_OPERATION"));
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_b_of_type_Int = this.jdField_a_of_type_AndroidMediaAudioManager.getMode();
    Object localObject = (Integer)paramHashMap.get("PARAM_MODE_POLICY");
    Integer localInteger = (Integer)paramHashMap.get("PARAM_STREAM_TYPE");
    int i;
    if (localObject == null) {
      i = -1;
    } else {
      i = ((Integer)localObject).intValue();
    }
    this.d = i;
    if (localInteger == null) {
      i = 0;
    } else {
      i = localInteger.intValue();
    }
    this.jdField_c_of_type_Int = i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("internalVoiceCallPreProcess, mode[");
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("], mStreamType[");
      ((StringBuilder)localObject).append(this.jdField_c_of_type_Int);
      ((StringBuilder)localObject).append("]");
      QLog.d("TraeAudioManager", 2, ((StringBuilder)localObject).toString());
    }
    TraeUtils.a(this.jdField_a_of_type_AndroidContentContext, TraeUtils.c(this.d));
    b(this.jdField_c_of_type_Int);
    a(paramHashMap, 0);
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c("DEVICE_WIRED_HEADSET"))
    {
      this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_EARPHONE", false);
      return;
    }
    this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a("DEVICE_EARPHONE", true);
  }
  
  private void g(HashMap<String, Object> paramHashMap)
  {
    if (this.jdField_a_of_type_Int == 2) {
      f();
    }
    try
    {
      localObject = (String)paramHashMap.get("PARAM_RING_USERDATA_STRING");
      int i = ((Integer)paramHashMap.get("PARAM_RING_DATA_SOURCE")).intValue();
      int j = ((Integer)paramHashMap.get("PARAM_RING_RESOURCE_ID")).intValue();
      Uri localUri = (Uri)paramHashMap.get("PARAM_RING_URI");
      String str = (String)paramHashMap.get("PARAM_RING_FILEPATH");
      boolean bool2 = ((Boolean)paramHashMap.get("PARAM_RING_LOOP")).booleanValue();
      int k = ((Integer)paramHashMap.get("PARAM_RING_LOOP_COUNT")).intValue();
      boolean bool3 = ((Boolean)paramHashMap.get("PARAM_RING_MODE")).booleanValue();
      if (this.jdField_a_of_type_Int != 1) {
        this.jdField_a_of_type_Int = 2;
      }
      paramHashMap = this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl;
      if (this.jdField_a_of_type_Int == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      boolean bool1 = paramHashMap.playRing(0L, i, j, localUri, str, bool2, k, bool3, bool1, this.jdField_c_of_type_Int);
      if (!this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.hasCall()) {
        b(this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.getStreamType());
      }
      a(this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.getStreamType());
      if (QLog.isColorLevel())
      {
        paramHashMap = new StringBuilder();
        paramHashMap.append("InternalStartRing end, Userdata[");
        paramHashMap.append((String)localObject);
        paramHashMap.append("], dataSource[");
        paramHashMap.append(i);
        paramHashMap.append("], DurationMS[");
        paramHashMap.append(this.jdField_a_of_type_ComTencentSharpJniApiImplTraeMediaPlayerApiImpl.getDuration());
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
    Object localObject = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
    String str1 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c();
    String str2 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.d();
    String str3 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
    HashMap localHashMap = new HashMap();
    localHashMap.put("EXTRA_DATA_VISIBLE_DEVICE_LIST", ((ArrayList)localObject).toArray(new String[0]));
    localHashMap.put("EXTRA_DATA_CONNECTED_DEVICE", str1);
    localHashMap.put("EXTRA_DATA_PREV_CONNECTED_DEVICE", str2);
    localHashMap.put("EXTRA_DATA_BLUETOOTH_NAME", str3);
    localObject = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((TraeAudioManager.Notifier)((Iterator)localObject).next()).notify(4, localHashMap);
    }
  }
  
  private void i()
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
    while (localIterator.hasNext()) {
      ((TraeAudioManager.Notifier)localIterator.next()).notify(1, localHashMap);
    }
  }
  
  private void j()
  {
    AudioManager.OnAudioFocusChangeListener localOnAudioFocusChangeListener = this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener;
    if (localOnAudioFocusChangeListener != null)
    {
      this.jdField_a_of_type_AndroidMediaAudioManager.abandonAudioFocus(localOnAudioFocusChangeListener);
      this.jdField_a_of_type_AndroidMediaAudioManager$OnAudioFocusChangeListener = null;
    }
  }
  
  public int a(int paramInt, HashMap<String, Object> paramHashMap)
  {
    TraeAudioManager.CustomHandler localCustomHandler = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler;
    if (localCustomHandler != null) {
      return localCustomHandler.a(paramInt, paramHashMap);
    }
    return -1;
  }
  
  public void a()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        QLog.e("TraeAudioManager", 1, "already release");
        return;
      }
      this.jdField_a_of_type_Boolean = false;
      b();
      if (this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager != null)
      {
        this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.a();
        this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager = null;
      }
      if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper != null)
      {
        this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a();
        this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper = null;
      }
      if (this.jdField_a_of_type_AndroidContentContext != null)
      {
        this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this);
        this.jdField_a_of_type_AndroidContentContext = null;
      }
      if (this.jdField_a_of_type_AndroidOsHandlerThread != null)
      {
        this.jdField_a_of_type_AndroidOsHandlerThread.quit();
        this.jdField_a_of_type_AndroidOsHandlerThread = null;
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler = null;
      }
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
      return;
    }
    finally {}
  }
  
  public void a(Context paramContext)
  {
    if (paramContext != null) {}
    try
    {
      if (!this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidContentContext = paramContext;
        this.jdField_a_of_type_AndroidMediaAudioManager = ((AudioManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("audio"));
        this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager = DeviceConfigManager.a();
        this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper = a(this.jdField_a_of_type_AndroidContentContext);
        paramContext = new IntentFilter();
        paramContext.addAction("android.intent.action.HEADSET_PLUG");
        BluetoothHelper.a(paramContext);
        this.jdField_a_of_type_AndroidContentContext.registerReceiver(this, paramContext);
        this.jdField_a_of_type_AndroidOsHandlerThread = new HandlerThread("TraeAudioManager");
        this.jdField_a_of_type_AndroidOsHandlerThread.start();
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$CustomHandler = new TraeAudioManager.CustomHandler(this, this.jdField_a_of_type_AndroidOsHandlerThread.getLooper());
        this.jdField_a_of_type_Boolean = true;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("context[");
      localStringBuilder.append(paramContext);
      localStringBuilder.append("], isInit[");
      localStringBuilder.append(this.jdField_a_of_type_Boolean);
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
      if (this.jdField_a_of_type_Boolean) {
        if (paramBoolean) {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramNotifier);
        } else {
          this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramNotifier);
        }
      }
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
          bool2 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c("DEVICE_WIRED_HEADSET");
          a(paramIntent);
          if (bool2 != this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c("DEVICE_WIRED_HEADSET"))
          {
            if (!bool2) {
              bool1 = true;
            }
            a("DEVICE_WIRED_HEADSET", bool1);
          }
        }
        else
        {
          bool3 = this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c("DEVICE_BLUETOOTH_HEADSET");
          if (this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper != null) {
            this.jdField_a_of_type_ComTencentSharpJniBluetoothHelper.a(paramIntent);
          }
          if (bool3 != this.jdField_a_of_type_ComTencentSharpJniDeviceConfigManager.c("DEVICE_BLUETOOTH_HEADSET"))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */