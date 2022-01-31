package com.tencent.sharp.jni;

import alyp;
import alyr;
import alys;
import alyt;
import alyu;
import alyy;
import alyz;
import alza;
import alzb;
import alzc;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.av.AVLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioManager
  extends BroadcastReceiver
{
  private static long jdField_a_of_type_Long = 5000L;
  static TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager;
  static ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  public static int e = -1;
  public int a;
  public alyt a;
  alyu jdField_a_of_type_Alyu = null;
  public alzc a;
  public Context a;
  public AudioManager a;
  public TraeAudioManager.DeviceConfigManager a;
  public TraeAudioSessionHost a;
  public String a;
  boolean jdField_a_of_type_Boolean = true;
  public int b;
  public String b;
  ReentrantLock b;
  public int c = 0;
  public int d = -1;
  
  TraeAudioManager(Context paramContext)
  {
    this.jdField_a_of_type_AndroidMediaAudioManager = null;
    this.jdField_a_of_type_AndroidContentContext = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioSessionHost = null;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager = null;
    this.jdField_a_of_type_Alyt = null;
    this.jdField_b_of_type_JavaLangString = "DEVICE_NONE";
    this.jdField_b_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_Alzc = null;
    AudioDeviceInterface.LogTraceEntry(" context:" + paramContext);
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Alyu = new alyu(this, this);
    if (this.jdField_a_of_type_Alyu != null) {}
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int a(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (a())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:" + 0);
        j = i;
      }
    }
    do
    {
      return j;
      int k = Build.VERSION.SDK_INT;
      if (paramInt >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
        }
        return paramInt;
      }
      i = j;
      if (k >= 11) {
        i = 7;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
    return i;
  }
  
  public static int a(int paramInt, HashMap paramHashMap)
  {
    int i = -1;
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null) {
      i = jdField_a_of_type_ComTencentSharpJniTraeAudioManager.b(paramInt, paramHashMap);
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    return i;
  }
  
  static int a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "setBluetoothConnectingTime,time: " + paramLong);
    }
    jdField_a_of_type_Long = paramLong;
    return 0;
  }
  
  public static int a(Context paramContext)
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager == null) {
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager = new TraeAudioManager(paramContext);
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    AudioDeviceInterface.LogTraceExit();
    return 0;
  }
  
  static int a(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32774, localHashMap);
  }
  
  static int a(String paramString, long paramLong, boolean paramBoolean, int paramInt)
  {
    if ((paramInt != 0) && (paramInt != 1)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_EARACTION", Integer.valueOf(paramInt));
    return a(32776, localHashMap);
  }
  
  static int a(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return a(32780, localHashMap);
  }
  
  static int a(String paramString1, long paramLong, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    return a(32775, localHashMap);
  }
  
  static int a(String paramString1, long paramLong, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString3);
    return a(32772, localHashMap);
  }
  
  public static int a(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString2);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_From", paramString1);
    return a(32783, localHashMap);
  }
  
  static int a(String paramString1, String paramString2, long paramLong, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString3, boolean paramBoolean2, int paramInt3, String paramString4, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString2);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString3);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString4);
    localHashMap.put("PARAM_From", paramString1);
    return a(32782, localHashMap);
  }
  
  public static int a(boolean paramBoolean, long paramLong, Context paramContext)
  {
    int i = -1;
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null)
    {
      if (!paramBoolean) {
        break label42;
      }
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioSessionHost.a(paramLong, paramContext);
    }
    for (;;)
    {
      i = 0;
      jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return i;
      label42:
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_ComTencentSharpJniTraeAudioSessionHost.a(paramLong);
    }
  }
  
  public static Object a(Object paramObject, String paramString, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      try
      {
        paramObject = paramObject.getClass().getMethod(paramString, paramArrayOfClass).invoke(paramObject, paramArrayOfObject);
        return paramObject;
      }
      catch (Exception paramObject) {}
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "invokeMethod Exception:" + paramObject.getMessage());
    return null;
  }
  
  public static Object a(String paramString1, String paramString2, Object[] paramArrayOfObject, Class[] paramArrayOfClass)
  {
    Object localObject = null;
    try
    {
      paramArrayOfObject = Class.forName(paramString1).getMethod(paramString2, paramArrayOfClass).invoke(null, paramArrayOfObject);
      return paramArrayOfObject;
    }
    catch (ClassNotFoundException paramString2)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "ClassNotFound:" + paramString1);
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "NoSuchMethod:" + paramString2);
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "IllegalArgument:" + paramString2);
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "IllegalAccess:" + paramString2);
      return null;
    }
    catch (InvocationTargetException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "InvocationTarget:" + paramString2);
      return null;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TRAE", 2, "invokeStaticMethod Exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  static String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "unknow";
  }
  
  static void a(int paramInt1, int paramInt2)
  {
    Object localObject = new Object[2];
    localObject[0] = Integer.valueOf(paramInt1);
    localObject[1] = Integer.valueOf(paramInt2);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    arrayOfClass[1] = Integer.TYPE;
    localObject = a("android.media.AudioSystem", "setForceUse", (Object[])localObject, arrayOfClass);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + a(paramInt2) + " res:" + localObject);
    }
  }
  
  public static void a(AudioManager paramAudioManager, int paramInt)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[arrayOfObject.length];
    arrayOfClass[0] = Integer.TYPE;
    paramAudioManager = a(paramAudioManager, "forceVolumeControlStream", arrayOfObject, arrayOfClass);
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
    }
  }
  
  static boolean a()
  {
    String str2 = Build.CPU_ABI;
    String str1 = "unknown";
    if (Build.VERSION.SDK_INT >= 8) {}
    try
    {
      str1 = (String)Build.class.getDeclaredField("CPU_ABI2").get(null);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
      }
      if ((b(str2)) && (b(str1))) {
        return true;
      }
    }
    catch (Exception localException)
    {
      return b(str2);
    }
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (paramInt != -1) {}
    do
    {
      do
      {
        return false;
        if (!Build.MANUFACTURER.equals("Xiaomi")) {
          break;
        }
        if (Build.MODEL.equals("MI 2")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2A")) {
          return true;
        }
        if (Build.MODEL.equals("MI 2S")) {
          return true;
        }
      } while (!Build.MODEL.equals("MI 2SC"));
      return true;
    } while ((!Build.MANUFACTURER.equals("samsung")) || (!Build.MODEL.equals("SCH-I959")));
    return true;
  }
  
  public static boolean a(String paramString)
  {
    if (paramString == null) {}
    while ((!"DEVICE_SPEAKERPHONE".equals(paramString)) && (!"DEVICE_EARPHONE".equals(paramString)) && (!"DEVICE_WIREDHEADSET".equals(paramString)) && (!"DEVICE_BLUETOOTHHEADSET".equals(paramString))) {
      return false;
    }
    return true;
  }
  
  static int b(int paramInt)
  {
    int i = 3;
    if (a())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + 3);
        j = i;
      }
      return j;
    }
    int j = Build.VERSION.SDK_INT;
    if (paramInt >= 0) {
      i = paramInt;
    }
    for (;;)
    {
      j = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("TRAE", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  static int b(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32784, localHashMap);
  }
  
  static int b(String paramString, long paramLong, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("PARAM_MODEPOLICY", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_STREAMTYPE", Integer.valueOf(paramInt2));
    return a(32788, localHashMap);
  }
  
  public static boolean b(String paramString)
  {
    if (paramString == null) {}
    do
    {
      return true;
      if (paramString.contains("x86")) {
        return false;
      }
      if (paramString.contains("mips")) {
        return false;
      }
    } while ((paramString.equalsIgnoreCase("armeabi")) || (!paramString.equalsIgnoreCase("armeabi-v7a")));
    return false;
  }
  
  public static int c(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (a())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TRAE", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:" + 0);
        j = i;
      }
    }
    do
    {
      return j;
      int k = Build.VERSION.SDK_INT;
      if (paramInt >= 0)
      {
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
        }
        return paramInt;
      }
      i = j;
      if (k >= 11) {
        i = 3;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
    return i;
  }
  
  static int c(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32773, localHashMap);
  }
  
  private boolean c()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_AndroidMediaAudioManager.isSpeakerphoneOn();
      return bool;
    }
    catch (Exception localException)
    {
      AVLog.e("TraeAudioManager", localException.getMessage());
    }
    return false;
  }
  
  static int d(int paramInt)
  {
    Object localObject = new Object[1];
    localObject[0] = Integer.valueOf(paramInt);
    Class[] arrayOfClass = new Class[localObject.length];
    arrayOfClass[0] = Integer.TYPE;
    localObject = a("android.media.AudioSystem", "getForceUse", (Object[])localObject, arrayOfClass);
    if (localObject != null) {}
    for (localObject = (Integer)localObject;; localObject = Integer.valueOf(0))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + a(((Integer)localObject).intValue()));
      }
      return ((Integer)localObject).intValue();
    }
  }
  
  static int d(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32789, localHashMap);
  }
  
  public static void d()
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null)
    {
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.e();
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    AudioDeviceInterface.LogTraceExit();
  }
  
  static int e(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32777, localHashMap);
  }
  
  static int f(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32778, localHashMap);
  }
  
  static int g(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32779, localHashMap);
  }
  
  static int h(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32781, localHashMap);
  }
  
  public int a()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Object localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a());
    try
    {
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      AudioDeviceInterface.LogTraceExit();
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyDeviceListUpdate e = " + localException);
        }
      }
    }
  }
  
  public int a(Context paramContext, boolean paramBoolean)
  {
    int j;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no context");
      }
      j = -1;
    }
    label155:
    label162:
    label169:
    int i;
    do
    {
      return j;
      AudioManager localAudioManager = (AudioManager)paramContext.getSystemService("audio");
      if (localAudioManager == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "Could not InternalSetSpeaker - no audio manager");
        }
        return -1;
      }
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("InternalSetSpeaker entry:speaker:");
        if (!localAudioManager.isSpeakerphoneOn()) {
          break label155;
        }
        paramContext = "Y";
        localStringBuilder = localStringBuilder.append(paramContext).append("-->:");
        if (!paramBoolean) {
          break label162;
        }
      }
      for (paramContext = "Y";; paramContext = "N")
      {
        QLog.w("TRAE", 2, paramContext);
        if ((!a(this.d)) || (this.jdField_a_of_type_Int == 2)) {
          break label169;
        }
        return a(localAudioManager, paramBoolean);
        paramContext = "N";
        break;
      }
      for (;;)
      {
        try
        {
          if (localAudioManager.isSpeakerphoneOn() != paramBoolean) {
            localAudioManager.setSpeakerphoneOn(paramBoolean);
          }
          boolean bool = localAudioManager.isSpeakerphoneOn();
          if (bool == paramBoolean) {
            i = 0;
          }
        }
        catch (Exception paramContext)
        {
          i = 0;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.w("TRAE", 2, "InternalSetSpeaker exit:" + paramBoolean + " res:" + i + " mode:" + localAudioManager.getMode());
          }
          return i;
        }
        catch (Exception paramContext)
        {
          break;
        }
        i = -1;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TRAE", 2, "InternalSetSpeaker e = " + paramContext);
    return i;
  }
  
  public int a(Intent paramIntent, HashMap paramHashMap, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramHashMap == null)) {
      return -1;
    }
    Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " sessonID:" + localLong + " " + (String)paramHashMap.get("PARAM_OPERATION"));
    }
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      a();
      if (QLog.isColorLevel()) {
        QLog.e("TRAE", 2, "sendResBroadcast sid null,don't send res");
      }
      return -1;
    }
    paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    paramIntent.putExtra("PARAM_SESSIONID", (Long)paramHashMap.get("PARAM_SESSIONID"));
    paramIntent.putExtra("PARAM_OPERATION", (String)paramHashMap.get("PARAM_OPERATION"));
    paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
    try
    {
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramIntent);
      return 0;
    }
    catch (Exception paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, "sendResBroadcast e = " + paramIntent);
        }
      }
    }
  }
  
  int a(AudioManager paramAudioManager, boolean paramBoolean)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this.c + " media_force_use:" + d(1));
    }
    if (paramBoolean)
    {
      a(0);
      paramAudioManager.setSpeakerphoneOn(true);
      a(1, 1);
      if (paramAudioManager.isSpeakerphoneOn() != paramBoolean) {
        break label176;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      return i;
      a(3);
      paramAudioManager.setSpeakerphoneOn(false);
      a(1, 0);
      break;
      label176:
      i = -1;
    }
  }
  
  public int a(String paramString, HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry(" devName:" + paramString);
    if (paramString == null) {}
    do
    {
      do
      {
        return -1;
        if ((!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d().equals("DEVICE_NONE")) && (paramString.equals(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d()))) {
          return 0;
        }
        if ((a(paramString) == true) && (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b(paramString) == true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TRAE", 2, " checkDevName fail");
      return -1;
      if (b() == true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TRAE", 2, " InternalIsDeviceChangeable fail");
    return -1;
    if (this.jdField_a_of_type_Alzc != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "_switchThread:" + this.jdField_a_of_type_Alzc.a());
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_Alzc.f();
      this.jdField_a_of_type_Alzc = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this.jdField_a_of_type_Alzc = new alyz(this);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Alzc != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_Alzc.a(paramHashMap);
        paramHashMap = new Intent();
        paramHashMap.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        paramHashMap.putExtra("PARAM_OPERATION", "NOTIFY_BEGIN_CONNECTED_DEVICE");
        paramHashMap.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
      }
      try
      {
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramHashMap);
        this.jdField_a_of_type_Alzc.start();
        AudioDeviceInterface.LogTraceExit();
        return 0;
        if (paramString.equals("DEVICE_SPEAKERPHONE"))
        {
          this.jdField_a_of_type_Alzc = new alzb(this);
          continue;
        }
        if (paramString.equals("DEVICE_WIREDHEADSET"))
        {
          this.jdField_a_of_type_Alzc = new alza(this);
          continue;
        }
        if (!paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
          continue;
        }
        this.jdField_a_of_type_Alzc = new alyy(this);
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "InternalConnectDevice notify error, e = " + paramString);
          }
        }
      }
    }
  }
  
  public int a(HashMap paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return -1;
    }
    String str = (String)paramHashMap.get("PARAM_DEVICE");
    boolean bool = b();
    int i;
    if (a(str) != true) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = str;
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("sessonID:").append((Long)paramHashMap.get("PARAM_SESSIONID")).append(" devName:").append(str).append(" bChangabled:");
        if (!bool) {
          break label214;
        }
      }
      label214:
      for (Object localObject = "Y";; localObject = "N")
      {
        QLog.w("TRAE", 2, (String)localObject + " err:" + i);
        if (i == 0) {
          break label222;
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        a((Intent)localObject, paramHashMap, i);
        return -1;
        if (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b(str))
        {
          i = 8;
          break;
        }
        if (bool) {
          break label318;
        }
        this.jdField_b_of_type_JavaLangString = str;
        i = 9;
        break;
      }
      label222:
      if (str.equals(this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d()))
      {
        if (QLog.isColorLevel()) {
          QLog.e("TRAE", 2, " --has connected!");
        }
        localObject = new Intent();
        ((Intent)localObject).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        a((Intent)localObject, paramHashMap, i);
        return 0;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " --connecting...");
      }
      a(str, paramHashMap);
      AudioDeviceInterface.LogTraceExit();
      return 0;
      label318:
      i = 0;
    }
  }
  
  public alyt a(Context paramContext, TraeAudioManager.DeviceConfigManager paramDeviceConfigManager)
  {
    Object localObject1;
    Object localObject2;
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT != 18))
    {
      localObject1 = new alyp(this);
      localObject2 = localObject1;
      if (!((alyt)localObject1).a(paramContext, paramDeviceConfigManager)) {
        localObject2 = new alyr(this);
      }
      if (QLog.isColorLevel())
      {
        paramDeviceConfigManager = new StringBuilder().append("CreateBluetoothCheck:").append(((alyt)localObject2).a()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label142;
        }
      }
    }
    label142:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TRAE", 2, paramContext);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new alys(this);
        break;
      }
      localObject1 = new alyr(this);
      break;
    }
  }
  
  void a()
  {
    int j = 0;
    AudioDeviceInterface.LogTraceEntry("");
    int k = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   ConnectedDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   ConnectingDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.c());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   prevConnectedDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.e());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   AHPDevice:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "   deviceNamber:" + k);
    }
    int i = 0;
    while (i < k)
    {
      localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(i);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "      " + i + " devName:" + (String)localObject + " Visible:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b((String)localObject) + " Priority:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a((String)localObject));
      }
      i += 1;
    }
    Object localObject = (String[])this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a().toArray(new String[0]);
    i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TRAE", 2, "   AvailableNamber:" + localObject.length);
      i = j;
    }
    while (i < localObject.length)
    {
      String str = localObject[i];
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "      " + i + " devName:" + str + " Visible:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b(str) + " Priority:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str));
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, "SetMode entry:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "setMode:" + paramInt + " fail am=null");
      }
    }
    do
    {
      return;
      this.jdField_a_of_type_AndroidMediaAudioManager.setMode(paramInt);
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder().append("setMode:").append(paramInt);
    if (this.jdField_a_of_type_AndroidMediaAudioManager.getMode() != paramInt) {}
    for (String str = "fail";; str = "success")
    {
      QLog.w("TRAE", 2, str);
      return;
    }
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unkonw";
    }
    localObject = "" + " [" + paramContext + "] ";
    int i = paramIntent.getIntExtra("state", -1);
    paramContext = (Context)localObject;
    if (i != -1)
    {
      localObject = new StringBuilder().append((String)localObject);
      if (i == 0)
      {
        paramContext = "unplugged";
        paramContext = paramContext;
      }
    }
    else
    {
      localObject = paramContext + " mic:";
      int j = paramIntent.getIntExtra("microphone", -1);
      paramContext = (Context)localObject;
      if (j != -1)
      {
        paramIntent = new StringBuilder().append((String)localObject);
        if (j != 1) {
          break label255;
        }
        paramContext = "Y";
        label168:
        paramContext = paramContext;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHeadsetPlug:: " + paramContext);
      }
      paramContext = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager;
      if (1 != i) {
        break label262;
      }
    }
    label262:
    for (boolean bool = true;; bool = false)
    {
      paramContext.a("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "onHeadsetPlug exit");
      }
      return;
      paramContext = "plugged";
      break;
      label255:
      paramContext = "unkown";
      break label168;
    }
  }
  
  public void a(String paramString)
  {
    int j = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a();
    int i = 0;
    if (i < j)
    {
      String str = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(i);
      boolean bool;
      if (str != null) {
        if (str.equals("DEVICE_BLUETOOTHHEADSET")) {
          if (this.jdField_a_of_type_Alyt == null) {
            bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str, false);
          }
        }
      }
      for (;;)
      {
        if ((bool == true) && (QLog.isColorLevel())) {
          QLog.w("TRAE", 2, "pollUpdateDevice dev:" + str + " Visible:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b(str));
        }
        i += 1;
        break;
        bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str, this.jdField_a_of_type_Alyt.a());
        continue;
        if (str.equals("DEVICE_WIREDHEADSET"))
        {
          bool = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str, this.jdField_a_of_type_AndroidMediaAudioManager.isWiredHeadsetOn());
        }
        else
        {
          if (str.equals("DEVICE_SPEAKERPHONE")) {
            this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a(str, true);
          }
          bool = false;
        }
      }
    }
    b(paramString);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a() == true) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label116;
        }
      }
    }
    label116:
    for (Object localObject = " piugin";; localObject = " plugout")
    {
      QLog.w("TRAE", 2, (String)localObject + " connectedDev:" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d());
      b();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b();
      if (!paramBoolean) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      b(32786, (HashMap)localObject);
      return;
    }
    localObject = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d();
    if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      b(32787, (HashMap)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
    }
    b(32793, new HashMap());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICECHANGABLE_UPDATE");
    localIntent.putExtra("NOTIFY_DEVICECHANGABLE_UPDATE_DATE", b());
    try
    {
      this.jdField_a_of_type_AndroidContentContext.sendBroadcast(localIntent);
      return 0;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "InternalNotifyDeviceChangableUpdate e = " + localException);
        }
      }
    }
  }
  
  int b(int paramInt, HashMap paramHashMap)
  {
    int i = -1;
    if (this.jdField_a_of_type_Alyu != null) {
      i = this.jdField_a_of_type_Alyu.a(paramInt, paramHashMap);
    }
    return i;
  }
  
  public int b(HashMap paramHashMap)
  {
    return 0;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_WIREDHEADSET"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, " detected headset plugin,so disable earphone");
      }
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_EARPHONE", false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TRAE", 2, " detected headset plugout,so enable earphone");
    }
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a("DEVICE_EARPHONE", true);
  }
  
  void b(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.a() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TRAE", 2, "checkAutoDeviceListUpdate got update!");
      }
      b();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b();
      HashMap localHashMap = new HashMap();
      localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString);
      b(32785, localHashMap);
    }
  }
  
  boolean b()
  {
    String str = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.c();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  public int c(HashMap paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", b());
    a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  public void c()
  {
    b(null);
  }
  
  public int d(HashMap paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.d());
    a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  public int e(HashMap paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.c());
    a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  public void e()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_Alyu != null)
    {
      this.jdField_a_of_type_Alyu.a();
      this.jdField_a_of_type_Alyu = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TRAE", 2, "onReceive intent or context is null!");
      }
    }
    for (;;)
    {
      return;
      try
      {
        String str2 = paramIntent.getAction();
        String str1 = paramIntent.getStringExtra("PARAM_OPERATION");
        if (QLog.isColorLevel()) {
          QLog.w("TRAE", 2, "TraeAudioManager|onReceive::Action:" + paramIntent.getAction());
        }
        if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TRAE", 2, "_deviceConfigManager null!");
          }
        }
        else
        {
          boolean bool1 = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_WIREDHEADSET");
          boolean bool2 = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET");
          if ("android.intent.action.HEADSET_PLUG".equals(paramIntent.getAction()))
          {
            a(paramContext, paramIntent);
            if ((!bool1) && (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_WIREDHEADSET") == true)) {
              a("DEVICE_WIREDHEADSET", true);
            }
            if ((bool1 == true) && (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_WIREDHEADSET"))) {
              a("DEVICE_WIREDHEADSET", false);
            }
          }
          else if (!"android.media.AUDIO_BECOMING_NOISY".equals(paramIntent.getAction()))
          {
            int i;
            int j;
            String str3;
            int k;
            if ("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE.qav", 2, "   OPERATION:" + str1);
              }
              if ("OPERATION_REGISTERAUDIOSESSION".equals(str1))
              {
                a(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
                return;
              }
              if ("OPERATION_STARTSERVICE".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
                return;
              }
              if ("OPERATION_STOPSERVICE".equals(str1))
              {
                c(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETDEVICELIST".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETSTREAMTYPE".equals(str1))
              {
                b(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_CONNECTDEVICE".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
                return;
              }
              if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
              {
                d(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_EARACTION".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
                return;
              }
              if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
              {
                e(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
              {
                f(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
              {
                g(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
              {
                h(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                b(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_STARTRING".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
                j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
                paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
                str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
                bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
                str3 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
                k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
                bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
                a("TraeAudioManager_onReceive", str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, str3, bool2);
                return;
              }
              if ("OPERATION_STOPRING".equals(str1)) {
                a("TraeAudioManager_onReceive", str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              }
            }
            else if (("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str2)) && (BaseApplicationImpl.processName != null) && (BaseApplicationImpl.processName.endsWith("groupvideo")))
            {
              if (QLog.isColorLevel()) {
                QLog.w("TRAE.gvideo", 2, "   OPERATION:" + str1);
              }
              if ("OPERATION_REGISTERAUDIOSESSION".equals(str1))
              {
                a(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
                return;
              }
              if ("OPERATION_STARTSERVICE".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
                return;
              }
              if ("OPERATION_STOPSERVICE".equals(str1))
              {
                c(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETDEVICELIST".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETSTREAMTYPE".equals(str1))
              {
                b(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_CONNECTDEVICE".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
                return;
              }
              if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(str1))
              {
                d(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_EARACTION".equals(str1))
              {
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
                return;
              }
              if ("OPERATION_ISDEVICECHANGABLED".equals(str1))
              {
                e(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTEDDEVICE".equals(str1))
              {
                f(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_GETCONNECTINGDEVICE".equals(str1))
              {
                g(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_PREPROCESS".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                a(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_VOICECALL_POSTROCESS".equals(str1))
              {
                h(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
                return;
              }
              if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
                j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
                b(str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
                return;
              }
              if ("OPERATION_STARTRING".equals(str1))
              {
                i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
                j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
                paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
                str2 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
                bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
                str3 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
                k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
                bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
                a("TraeAudioManager_onReceive", str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str2, bool1, k, str3, bool2);
                return;
              }
              if ("OPERATION_STOPRING".equals(str1)) {
                a("TraeAudioManager_onReceive", str1, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
              }
            }
            else if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager != null)
            {
              if (this.jdField_a_of_type_Alyt != null) {
                this.jdField_a_of_type_Alyt.a(paramContext, paramIntent, this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager);
              }
              if ((!bool2) && (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET") == true)) {
                a("DEVICE_BLUETOOTHHEADSET", true);
              }
              if ((bool2 == true) && (!this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$DeviceConfigManager.b("DEVICE_BLUETOOTHHEADSET")))
              {
                a("DEVICE_BLUETOOTHHEADSET", false);
                return;
              }
            }
          }
        }
      }
      catch (Exception paramContext) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */