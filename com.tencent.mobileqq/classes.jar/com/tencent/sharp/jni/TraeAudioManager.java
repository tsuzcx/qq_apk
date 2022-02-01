package com.tencent.sharp.jni;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import bkwq;
import bkwr;
import bkws;
import bkwt;
import bkwu;
import bkxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import lbd;
import mur;

public class TraeAudioManager
  extends BroadcastReceiver
{
  private static long jdField_a_of_type_Long = 5000L;
  static TraeAudioManager jdField_a_of_type_ComTencentSharpJniTraeAudioManager;
  static ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "FORCE_NONE", "FORCE_SPEAKER", "FORCE_HEADPHONES", "FORCE_BT_SCO", "FORCE_BT_A2DP", "FORCE_WIRED_ACCESSORY", "FORCE_BT_CAR_DOCK", "FORCE_BT_DESK_DOCK", "FORCE_ANALOG_DOCK", "FORCE_NO_BT_A2DP", "FORCE_DIGITAL_DOCK" };
  static int e = -1;
  public int a;
  private Context jdField_a_of_type_AndroidContentContext;
  private AudioManager jdField_a_of_type_AndroidMediaAudioManager;
  bkwt jdField_a_of_type_Bkwt = null;
  bkwu jdField_a_of_type_Bkwu = null;
  bkxa jdField_a_of_type_Bkxa = null;
  private TraeAudioManager.SwitchThread jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread;
  TraeAudioManager.TraeAudioManagerLooper jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper = null;
  String jdField_a_of_type_JavaLangString = "DEVICE_NONE";
  boolean jdField_a_of_type_Boolean = true;
  int jdField_b_of_type_Int = 0;
  String jdField_b_of_type_JavaLangString = "DEVICE_NONE";
  int c = 0;
  int d = -1;
  private int f = 4;
  
  TraeAudioManager(Context paramContext)
  {
    this.jdField_a_of_type_Int = 0;
    AudioDeviceInterface.LogTraceEntry(" context:" + paramContext);
    if (paramContext == null) {
      return;
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper = new TraeAudioManager.TraeAudioManagerLooper(this, this);
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
        QLog.w("TraeAudioManager", 2, "[Config] armeabi low Version, getAudioSource _audioSourcePolicy:" + paramInt + " source:" + 0);
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
          QLog.w("TraeAudioManager", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + paramInt);
        }
        return paramInt;
      }
      i = j;
      if (k >= 11) {
        i = 7;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "[Config] getAudioSource _audioSourcePolicy:" + paramInt + " source:" + i);
    return i;
  }
  
  public static int a(int paramInt, HashMap<String, Object> paramHashMap)
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
      QLog.w("TraeAudioManager", 2, "setBluetoothConnectingTime,time: " + paramLong);
    }
    jdField_a_of_type_Long = paramLong;
    return 0;
  }
  
  static int a(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    mur.a(localHashMap, paramLong1);
    return a(32778, localHashMap);
  }
  
  static int a(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean1, int paramInt1, int paramInt2, Uri paramUri, String paramString2, boolean paramBoolean2, int paramInt3, String paramString3, boolean paramBoolean3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean1));
    localHashMap.put("PARAM_RING_DATASOURCE", Integer.valueOf(paramInt1));
    localHashMap.put("PARAM_RING_RSID", Integer.valueOf(paramInt2));
    localHashMap.put("PARAM_RING_URI", paramUri);
    localHashMap.put("PARAM_RING_FILEPATH", paramString2);
    localHashMap.put("PARAM_RING_LOOP", Boolean.valueOf(paramBoolean2));
    localHashMap.put("PARAM_RING_LOOPCOUNT", Integer.valueOf(paramInt3));
    localHashMap.put("PARAM_RING_MODE", Boolean.valueOf(paramBoolean3));
    localHashMap.put("PARAM_RING_USERDATA_STRING", paramString3);
    mur.a(localHashMap, paramLong1);
    return a(32782, localHashMap);
  }
  
  static int a(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean, String paramString2)
  {
    if (paramString2 == null) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("CONNECTDEVICE_DEVICENAME", paramString2);
    localHashMap.put("PARAM_DEVICE", paramString2);
    mur.a(localHashMap, paramLong1);
    return a(32775, localHashMap);
  }
  
  static int a(long paramLong1, String paramString1, long paramLong2, boolean paramBoolean, String paramString2, String paramString3)
  {
    if ((paramString2 == null) || (paramString2.length() <= 0)) {
      return -1;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString1);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    localHashMap.put("EXTRA_DATA_DEVICECONFIG", paramString2);
    localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString3);
    mur.a(localHashMap, paramLong1);
    return a(32772, localHashMap);
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
  
  public static int a(boolean paramBoolean, long paramLong, Context paramContext)
  {
    int j = -1;
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    int i = j;
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null)
    {
      i = j;
      if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bkxa != null)
      {
        if (!paramBoolean) {
          break label59;
        }
        jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bkxa.a(paramLong, paramContext);
      }
    }
    for (;;)
    {
      i = 0;
      jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
      return i;
      label59:
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.jdField_a_of_type_Bkxa.a(paramLong);
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
    QLog.w("TraeAudioManager", 2, "invokeMethod Exception:" + paramObject.getMessage());
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
      QLog.w("TraeAudioManager", 2, "ClassNotFound:" + paramString1);
      return null;
    }
    catch (NoSuchMethodException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "NoSuchMethod:" + paramString2);
      return null;
    }
    catch (IllegalArgumentException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "IllegalArgument:" + paramString2);
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "IllegalAccess:" + paramString2);
      return null;
    }
    catch (InvocationTargetException paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "InvocationTarget:" + paramString2);
      return null;
    }
    catch (Exception paramString1)
    {
      do
      {
        paramArrayOfObject = localObject;
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "invokeStaticMethod Exception:" + paramString1.getMessage());
    }
    return null;
  }
  
  static String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < jdField_a_of_type_ArrayOfJavaLangString.length)) {
      return jdField_a_of_type_ArrayOfJavaLangString[paramInt];
    }
    return "unknown";
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
      QLog.w("TraeAudioManager", 2, "setForceUse  usage:" + paramInt1 + " config:" + paramInt2 + " ->" + a(paramInt2) + " res:" + localObject);
    }
  }
  
  private void a(Context paramContext, Intent paramIntent, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE.qav onReceiveManagerRequest", 2, "   OPERATION:" + paramString);
    }
    if ("OPERATION_REGISTERAUDIOSESSION".equals(paramString)) {
      a(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
    }
    do
    {
      return;
      if ("OPERATION_STARTSERVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
        return;
      }
      if ("OPERATION_STOPSERVICE".equals(paramString))
      {
        c(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETDEVICELIST".equals(paramString))
      {
        a(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(paramString))
      {
        b(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_CONNECTDEVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
        return;
      }
      if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(paramString))
      {
        d(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_EARACTION".equals(paramString))
      {
        a(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
        return;
      }
      if ("OPERATION_ISDEVICECHANGABLED".equals(paramString))
      {
        e(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETCONNECTEDDEVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(paramString))
      {
        f(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      int i;
      int j;
      if ("OPERATION_VOICECALL_PREPROCESS".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
        j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
        a(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
        return;
      }
      if ("OPERATION_VOICECALL_POSTROCESS".equals(paramString))
      {
        g(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
        j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
        b(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
        return;
      }
      if ("OPERATION_STARTRING".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
        j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
        paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
        String str1 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
        boolean bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
        String str2 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
        boolean bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str1, bool1, k, str2, bool2);
        return;
      }
    } while (!"OPERATION_STOPRING".equals(paramString));
    b(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
  }
  
  static void a(AudioManager paramAudioManager, int paramInt)
  {
    if (Build.MANUFACTURER.equals("Google")) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Google phone nothing to do");
      }
    }
    do
    {
      do
      {
        return;
        if (Build.VERSION.SDK_INT < 28) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.w("TraeAudioManager", 2, "forceVolumeControlStream, Android P system nothing to do, version: " + Build.VERSION.SDK_INT);
      return;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      Class[] arrayOfClass = new Class[arrayOfObject.length];
      arrayOfClass[0] = Integer.TYPE;
      paramAudioManager = a(paramAudioManager, "forceVolumeControlStream", arrayOfObject, arrayOfClass);
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "forceVolumeControlStream  streamType:" + paramInt + " res:" + paramAudioManager);
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
        QLog.w("TraeAudioManager", 2, "IsEabiVersion CPU_ABI:" + str2 + " CPU_ABI2:" + str1);
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
  
  static boolean a(int paramInt)
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
        QLog.w("TraeAudioManager", 2, "[Config] armeabi low Version, getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + 3);
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
      QLog.w("TraeAudioManager", 2, "[Config] getAudioStreamType audioStreamTypePolicy:" + paramInt + " streamType:" + i);
      return i;
      if (j >= 9) {
        i = 0;
      }
    }
  }
  
  public static int b(long paramLong1, String paramString, long paramLong2, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong2));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    mur.a(localHashMap, paramLong1);
    return a(32783, localHashMap);
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
      do
      {
        return true;
        if (paramString.contains("x86")) {
          return false;
        }
        if (paramString.contains("mips")) {
          return false;
        }
      } while (paramString.equalsIgnoreCase("armeabi"));
      if (paramString.equalsIgnoreCase("armeabi-v7a")) {
        return false;
      }
    } while (!paramString.equalsIgnoreCase("arm64-v8a"));
    return false;
  }
  
  static int c(int paramInt)
  {
    int j = 0;
    int i = 0;
    if (a())
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.w("TraeAudioManager", 2, "[Config] armeabi low Version, getCallAudioMode modePolicy:" + paramInt + " mode:" + 0);
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
          QLog.w("TraeAudioManager", 2, "[Config] getCallAudioMode modePolicy:" + paramInt + " mode:" + paramInt);
        }
        return paramInt;
      }
      i = j;
      if (k >= 11) {
        i = 3;
      }
      j = i;
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 2, "[Config] getCallAudioMode _modePolicy:" + paramInt + " mode:" + i + "facturer:" + Build.MANUFACTURER + " model:" + Build.MODEL);
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
  
  public static void c()
  {
    AudioDeviceInterface.LogTraceEntry(" _ginstance:" + jdField_a_of_type_ComTencentSharpJniTraeAudioManager);
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.lock();
    if (jdField_a_of_type_ComTencentSharpJniTraeAudioManager != null)
    {
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager.d();
      jdField_a_of_type_ComTencentSharpJniTraeAudioManager = null;
    }
    jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock.unlock();
    AudioDeviceInterface.LogTraceExit();
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
      lbd.h("TraeAudioManager", localException.getMessage());
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
        QLog.w("TraeAudioManager", 2, "getForceUse  usage:" + paramInt + " config:" + localObject + " ->" + a(((Integer)localObject).intValue()));
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
    return a(32779, localHashMap);
  }
  
  static int g(String paramString, long paramLong, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("PARAM_SESSIONID", Long.valueOf(paramLong));
    localHashMap.put("PARAM_OPERATION", paramString);
    localHashMap.put("PARAM_ISHOSTSIDE", Boolean.valueOf(paramBoolean));
    return a(32781, localHashMap);
  }
  
  int a()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      return -1;
    }
    Object localObject = this.jdField_a_of_type_Bkwu.a();
    ArrayList localArrayList = (ArrayList)((HashMap)localObject).get("EXTRA_DATA_AVAILABLEDEVICE_LIST");
    String str = (String)((HashMap)localObject).get("EXTRA_DATA_CONNECTEDDEVICE");
    localObject = (String)((HashMap)localObject).get("EXTRA_DATA_PREV_CONNECTEDDEVICE");
    Intent localIntent = new Intent();
    localIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
    localIntent.putExtra("PARAM_OPERATION", "NOTIFY_DEVICELISTUPDATE");
    localIntent.putExtra("EXTRA_DATA_AVAILABLEDEVICE_LIST", (String[])localArrayList.toArray(new String[0]));
    localIntent.putExtra("EXTRA_DATA_CONNECTEDDEVICE", str);
    localIntent.putExtra("EXTRA_DATA_PREV_CONNECTEDDEVICE", (String)localObject);
    localIntent.putExtra("EXTRA_DATA_IF_HAS_BLUETOOTH_THIS_IS_NAME", this.jdField_a_of_type_Bkwu.a());
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
  
  int a(long paramLong, Context paramContext, boolean paramBoolean)
  {
    int i = -1;
    int j;
    if (paramContext == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no context");
      }
      j = -1;
    }
    do
    {
      return j;
      paramContext = (AudioManager)paramContext.getSystemService("audio");
      if (paramContext == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("TraeAudioManager", 2, "Could not InternalSetSpeaker - no audio manager");
        }
        return -1;
      }
      boolean bool = a(this.d);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, isSpeakerphoneOn[" + paramContext.isSpeakerphoneOn() + "], speakerOn[" + paramBoolean + "], isCloseSystemAPM[" + bool + "], _activeMode[" + this.jdField_a_of_type_Int + "], seq[" + paramLong + "]");
      }
      if ((bool) && (this.jdField_a_of_type_Int != 2)) {
        return a(paramContext, paramBoolean);
      }
      try
      {
        if (paramContext.isSpeakerphoneOn() != paramBoolean) {
          paramContext.setSpeakerphoneOn(paramBoolean);
        }
        bool = paramContext.isSpeakerphoneOn();
        if (bool == paramBoolean) {
          i = 0;
        }
        j = i;
      }
      catch (Exception paramContext)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, res[" + i + "], mode[" + paramContext.getMode() + "], seq[" + paramLong + "]");
          }
          return i;
        }
        catch (Exception paramContext)
        {
          continue;
        }
        paramContext = paramContext;
        i = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.w("TraeAudioManager", 1, "InternalSetSpeaker, seq[" + paramLong + "]", paramContext);
    return i;
  }
  
  int a(long paramLong, String paramString, HashMap<String, Object> paramHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "InternalConnectDevice, devName[" + paramString + "], seq[" + paramLong + "]");
    }
    if (paramString == null) {}
    do
    {
      do
      {
        return -1;
        if ((!this.jdField_a_of_type_Bkwu.d().equals("DEVICE_NONE")) && (paramString.equals(this.jdField_a_of_type_Bkwu.d()))) {
          return 0;
        }
        if ((a(paramString) == true) && (this.jdField_a_of_type_Bkwu.b(paramString) == true)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("TraeAudioManager", 2, " checkDevName fail");
      return -1;
      if (b() == true) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.e("TraeAudioManager", 2, " InternalIsDeviceChangeable fail");
    return -1;
    this.jdField_a_of_type_Bkwu.c(paramString);
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread != null)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "InternalConnectDevice, quit, _switchThread[" + this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread.a() + "], running_stat[" + this.jdField_a_of_type_Boolean + "], seq[" + paramLong + "]");
      }
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread.b(paramLong);
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread = null;
    }
    if (paramString.equals("DEVICE_EARPHONE")) {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread = new TraeAudioManager.EarphoneSwitchThread(this, paramLong);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread != null)
      {
        this.jdField_a_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread.a(paramHashMap);
        paramHashMap = new Intent();
        paramHashMap.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_NOTIFY");
        paramHashMap.putExtra("PARAM_OPERATION", "NOTIFY_BEGIN_CONNECTED_DEVICE");
        paramHashMap.putExtra("CONNECTDEVICE_DEVICENAME", paramString);
        mur.a(paramHashMap, paramLong);
      }
      try
      {
        this.jdField_a_of_type_AndroidContentContext.sendBroadcast(paramHashMap);
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread.a(paramLong);
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 1, "InternalConnectDevice.end, devName[" + paramString + "], seq[" + paramLong + "]");
        }
        return 0;
        if (paramString.equals("DEVICE_SPEAKERPHONE"))
        {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread = new TraeAudioManager.speakerSwitchThread(this, paramLong);
          continue;
        }
        if (paramString.equals("DEVICE_WIREDHEADSET"))
        {
          this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread = new TraeAudioManager.headsetSwitchThread(this, paramLong);
          continue;
        }
        if (!paramString.equals("DEVICE_BLUETOOTHHEADSET")) {
          continue;
        }
        this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$SwitchThread = new TraeAudioManager.bluetoothHeadsetSwitchThread(this, paramLong);
      }
      catch (Exception paramHashMap)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, "InternalConnectDevice notify error, e = " + paramHashMap);
          }
        }
      }
    }
  }
  
  int a(long paramLong, HashMap<String, Object> paramHashMap)
  {
    AudioDeviceInterface.LogTraceEntry("");
    if ((paramHashMap == null) || (this.jdField_a_of_type_AndroidContentContext == null)) {
      return -1;
    }
    Object localObject1 = (String)paramHashMap.get("PARAM_DEVICE");
    boolean bool = b();
    int i;
    if (!a((String)localObject1)) {
      i = 7;
    }
    for (;;)
    {
      this.jdField_a_of_type_JavaLangString = ((String)localObject1);
      Object localObject2 = paramHashMap.get("PARAM_SESSIONID");
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "InternalSessionConnectDevice, sessionId[" + localObject2 + "], devName[" + (String)localObject1 + "], changeable[" + bool + "], err[" + i + "], seq[" + paramLong + "]");
      }
      if (i != 0)
      {
        localObject1 = new Intent();
        ((Intent)localObject1).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
        a((Intent)localObject1, paramHashMap, i);
        return -1;
        if (!this.jdField_a_of_type_Bkwu.b((String)localObject1))
        {
          i = 8;
          continue;
        }
        if (!bool)
        {
          i = 9;
          this.jdField_b_of_type_JavaLangString = ((String)localObject1);
        }
      }
      else
      {
        if (((String)localObject1).equals(this.jdField_a_of_type_Bkwu.d()))
        {
          if (QLog.isColorLevel()) {
            QLog.e("TraeAudioManager", 2, " --has connected!");
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("CONNECTDEVICE_RESULT_DEVICENAME", (String)paramHashMap.get("PARAM_DEVICE"));
          a((Intent)localObject1, paramHashMap, i);
          return 0;
        }
        if (QLog.isColorLevel()) {
          QLog.w("TraeAudioManager", 2, " --connecting...");
        }
        a(paramLong, (String)localObject1, paramHashMap);
        AudioDeviceInterface.LogTraceExit();
        return 0;
      }
      i = 0;
    }
  }
  
  int a(Intent paramIntent, HashMap<String, Object> paramHashMap, int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidContentContext == null) || (paramHashMap == null)) {
      return -1;
    }
    Long localLong = (Long)paramHashMap.get("PARAM_SESSIONID");
    String str = (String)paramHashMap.get("PARAM_OPERATION");
    long l = mur.a(paramHashMap);
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 1, "sendResBroadcast, operation[" + str + "], sessionID[" + localLong + "], seq[" + l + "]");
    }
    if ((localLong == null) || (localLong.longValue() == -9223372036854775808L))
    {
      a();
      return -1;
    }
    paramIntent.setAction("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_RES");
    paramIntent.putExtra("PARAM_SESSIONID", localLong);
    paramIntent.putExtra("PARAM_OPERATION", str);
    paramIntent.putExtra("PARAM_RES_ERRCODE", paramInt);
    mur.a(paramHashMap, l);
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
          QLog.w("TraeAudioManager", 1, "sendResBroadcast Exception, operation[" + str + "], seq[" + l + "]", paramIntent);
        }
      }
    }
  }
  
  int a(AudioManager paramAudioManager, boolean paramBoolean)
  {
    j = 0;
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "InternalSetSpeakerSpe fac:" + Build.MANUFACTURER + " model:" + Build.MODEL + " st:" + this.c + " media_force_use:" + d(1));
    }
    if (paramBoolean)
    {
      a(0);
      paramAudioManager.setSpeakerphoneOn(true);
      a(1, 1);
    }
    for (;;)
    {
      try
      {
        boolean bool = paramAudioManager.isSpeakerphoneOn();
        if (bool != paramBoolean) {
          continue;
        }
        i = j;
      }
      catch (Exception localException)
      {
        int i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("TraeAudioManager", 1, "InternalSetSpeakerSpe fail", localException);
        i = j;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "InternalSetSpeakerSpe exit:" + paramBoolean + " res:" + i + " mode:" + paramAudioManager.getMode());
      }
      return i;
      a(3);
      paramAudioManager.setSpeakerphoneOn(false);
      a(1, 0);
      continue;
      i = -1;
    }
  }
  
  int a(HashMap<String, Object> paramHashMap)
  {
    return 0;
  }
  
  public bkwt a(Context paramContext, bkwu parambkwu)
  {
    Object localObject1;
    Object localObject2;
    if ((Build.VERSION.SDK_INT >= 11) && (Build.VERSION.SDK_INT != 18))
    {
      localObject1 = new bkwq(this);
      localObject2 = localObject1;
      if (!((bkwt)localObject1).a(paramContext, parambkwu)) {
        localObject2 = new bkwr(this);
      }
      if (QLog.isColorLevel())
      {
        parambkwu = new StringBuilder().append("CreateBluetoothCheck:").append(((bkwt)localObject2).a()).append(" skip android4.3:");
        if (Build.VERSION.SDK_INT != 18) {
          break label142;
        }
      }
    }
    label142:
    for (paramContext = "Y";; paramContext = "N")
    {
      QLog.w("TraeAudioManager", 2, paramContext);
      return localObject2;
      if (Build.VERSION.SDK_INT != 18)
      {
        localObject1 = new bkws(this);
        break;
      }
      localObject1 = new bkwr(this);
      break;
    }
  }
  
  public void a()
  {
    int j = 0;
    AudioDeviceInterface.LogTraceEntry("");
    int k = this.jdField_a_of_type_Bkwu.a();
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   ConnectedDevice:" + this.jdField_a_of_type_Bkwu.d());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   ConnectingDevice:" + this.jdField_a_of_type_Bkwu.c());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   prevConnectedDevice:" + this.jdField_a_of_type_Bkwu.e());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   AHPDevice:" + this.jdField_a_of_type_Bkwu.b());
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "   deviceNamber:" + k);
    }
    int i = 0;
    while (i < k)
    {
      localObject = this.jdField_a_of_type_Bkwu.a(i);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "      " + i + " devName:" + (String)localObject + " Visible:" + this.jdField_a_of_type_Bkwu.b((String)localObject) + " Priority:" + this.jdField_a_of_type_Bkwu.a((String)localObject));
      }
      i += 1;
    }
    Object localObject = (String[])this.jdField_a_of_type_Bkwu.a().toArray(new String[0]);
    i = j;
    if (QLog.isColorLevel())
    {
      QLog.w("TraeAudioManager", 2, "   AvailableNamber:" + localObject.length);
      i = j;
    }
    while (i < localObject.length)
    {
      String str = localObject[i];
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "      " + i + " devName:" + str + " Visible:" + this.jdField_a_of_type_Bkwu.b(str) + " Priority:" + this.jdField_a_of_type_Bkwu.a(str));
      }
      i += 1;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, "SetMode entry:" + paramInt);
    }
    if (this.jdField_a_of_type_AndroidMediaAudioManager == null) {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "setMode:" + paramInt + " fail am=null");
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
      QLog.w("TraeAudioManager", 2, str);
      return;
    }
  }
  
  void a(long paramLong)
  {
    b(paramLong, null);
  }
  
  void a(long paramLong, String paramString)
  {
    int j = this.jdField_a_of_type_Bkwu.a();
    Object localObject;
    boolean bool;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("updateDeviceStatus, connectDeviceNameWhenServiceOn[").append(paramString).append("], getDeviceNumber[").append(j).append("], _bluetoothCheck[");
      if (this.jdField_a_of_type_Bkwt != null)
      {
        bool = true;
        QLog.w("TraeAudioManager", 1, bool + "], seq[" + paramLong + "]");
      }
    }
    else
    {
      i = 0;
      label96:
      if (i >= j) {
        break label317;
      }
      localObject = this.jdField_a_of_type_Bkwu.a(i);
      if (localObject == null) {
        break label311;
      }
      if (!((String)localObject).equals("DEVICE_BLUETOOTHHEADSET")) {
        break label257;
      }
      if (this.jdField_a_of_type_Bkwt != null) {
        break label236;
      }
      bool = this.jdField_a_of_type_Bkwu.a((String)localObject, false);
    }
    for (;;)
    {
      if ((bool) && (QLog.isColorLevel())) {
        QLog.w("TraeAudioManager", 1, "updateDeviceStatus, devName[" + (String)localObject + "], Visible[" + this.jdField_a_of_type_Bkwu.b((String)localObject) + "], seq[" + paramLong + "]");
      }
      i += 1;
      break label96;
      bool = false;
      break;
      label236:
      bool = this.jdField_a_of_type_Bkwu.a((String)localObject, this.jdField_a_of_type_Bkwt.a());
      continue;
      label257:
      if (((String)localObject).equals("DEVICE_WIREDHEADSET"))
      {
        bool = this.jdField_a_of_type_Bkwu.a((String)localObject, this.jdField_a_of_type_AndroidMediaAudioManager.isWiredHeadsetOn());
      }
      else
      {
        if (((String)localObject).equals("DEVICE_SPEAKERPHONE")) {
          this.jdField_a_of_type_Bkwu.a((String)localObject, true);
        }
        label311:
        bool = false;
      }
    }
    label317:
    b(paramLong, paramString);
  }
  
  void a(long paramLong, String paramString, Intent paramIntent, Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.w("TRAE.gvideo", 2, "   OPERATION:" + paramString);
    }
    if ("OPERATION_REGISTERAUDIOSESSION".equals(paramString)) {
      a(paramIntent.getBooleanExtra("REGISTERAUDIOSESSION_ISREGISTER", false), paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), paramContext);
    }
    do
    {
      return;
      if ("OPERATION_STARTSERVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("EXTRA_DATA_DEVICECONFIG"), paramIntent.getStringExtra("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON"));
        return;
      }
      if ("OPERATION_STOPSERVICE".equals(paramString))
      {
        c(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETDEVICELIST".equals(paramString))
      {
        a(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETSTREAMTYPE".equals(paramString))
      {
        b(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_CONNECTDEVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getStringExtra("CONNECTDEVICE_DEVICENAME"));
        return;
      }
      if ("OPERATION_CONNECT_HIGHEST_PRIORITY_DEVICE".equals(paramString))
      {
        d(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_EARACTION".equals(paramString))
      {
        a(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, paramIntent.getIntExtra("EXTRA_EARACTION", -1));
        return;
      }
      if ("OPERATION_ISDEVICECHANGABLED".equals(paramString))
      {
        e(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETCONNECTEDDEVICE".equals(paramString))
      {
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_GETCONNECTINGDEVICE".equals(paramString))
      {
        f(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      int i;
      int j;
      if ("OPERATION_VOICECALL_PREPROCESS".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
        j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
        a(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
        return;
      }
      if ("OPERATION_VOICECALL_POSTROCESS".equals(paramString))
      {
        g(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
        return;
      }
      if ("OPERATION_VOICECALL_AUDIOPARAM_CHANGED".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_MODEPOLICY", -1);
        j = paramIntent.getIntExtra("PARAM_STREAMTYPE", -1);
        b(paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j);
        return;
      }
      if ("OPERATION_STARTRING".equals(paramString))
      {
        i = paramIntent.getIntExtra("PARAM_RING_DATASOURCE", -1);
        j = paramIntent.getIntExtra("PARAM_RING_RSID", -1);
        paramContext = (Uri)paramIntent.getParcelableExtra("PARAM_RING_URI");
        String str1 = paramIntent.getStringExtra("PARAM_RING_FILEPATH");
        boolean bool1 = paramIntent.getBooleanExtra("PARAM_RING_LOOP", false);
        String str2 = paramIntent.getStringExtra("PARAM_RING_USERDATA_STRING");
        int k = paramIntent.getIntExtra("PARAM_RING_LOOPCOUNT", 1);
        boolean bool2 = paramIntent.getBooleanExtra("PARAM_RING_MODE", false);
        a(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false, i, j, paramContext, str1, bool1, k, str2, bool2);
        return;
      }
    } while (!"OPERATION_STOPRING".equals(paramString));
    b(paramLong, paramString, paramIntent.getLongExtra("PARAM_SESSIONID", -9223372036854775808L), false);
  }
  
  void a(Context paramContext, Intent paramIntent)
  {
    Object localObject = paramIntent.getStringExtra("name");
    paramContext = (Context)localObject;
    if (localObject == null) {
      paramContext = "unknown";
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
        QLog.w("TraeAudioManager", 2, "onHeadsetPlug:: " + paramContext);
      }
      paramContext = this.jdField_a_of_type_Bkwu;
      if (1 != i) {
        break label262;
      }
    }
    label262:
    for (boolean bool = true;; bool = false)
    {
      paramContext.a("DEVICE_WIREDHEADSET", bool);
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, "onHeadsetPlug exit");
      }
      return;
      paramContext = "plugged";
      break;
      label255:
      paramContext = "unknown";
      break label168;
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    StringBuilder localStringBuilder;
    if (this.jdField_a_of_type_Bkwu.a()) {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder().append("checkDevicePlug got update dev:").append(paramString);
        if (!paramBoolean) {
          break label115;
        }
      }
    }
    label115:
    for (Object localObject = " piugin";; localObject = " plugout")
    {
      QLog.w("TraeAudioManager", 2, (String)localObject + " connectedDev:" + this.jdField_a_of_type_Bkwu.d());
      b();
      this.jdField_a_of_type_Bkwu.b();
      if (!paramBoolean) {
        break;
      }
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      b(32786, (HashMap)localObject);
      return;
    }
    localObject = this.jdField_a_of_type_Bkwu.d();
    if ((((String)localObject).equals(paramString)) || (((String)localObject).equals("DEVICE_NONE")))
    {
      localObject = new HashMap();
      ((HashMap)localObject).put("PARAM_DEVICE", paramString);
      b(32787, (HashMap)localObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " ---No switch,plugout:" + paramString + " connectedDev:" + (String)localObject);
    }
    b(32793, new HashMap());
  }
  
  int b()
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
  
  int b(int paramInt, HashMap<String, Object> paramHashMap)
  {
    int i = -1;
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper != null) {
      i = this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper.a(paramInt, paramHashMap);
    }
    return i;
  }
  
  int b(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("ISDEVICECHANGABLED_REULT_ISCHANGABLED", b());
    a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  void b()
  {
    if (this.jdField_a_of_type_Bkwu.b("DEVICE_WIREDHEADSET"))
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 2, " detected headset plugin,so disable earphone");
      }
      this.jdField_a_of_type_Bkwu.a("DEVICE_EARPHONE", false);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("TraeAudioManager", 2, " detected headset plugout,so enable earphone");
    }
    this.jdField_a_of_type_Bkwu.a("DEVICE_EARPHONE", true);
  }
  
  void b(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Bkwu.a() == true)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TraeAudioManager", 1, "checkAutoDeviceListUpdate, connectDeviceNameWhenServiceOn[" + paramString + "], seq[" + paramLong + "]");
      }
      b();
      this.jdField_a_of_type_Bkwu.b();
      HashMap localHashMap = new HashMap();
      localHashMap.put("EXTRA_DATA_CONNECTDEVICENAMEWHENSERVICEON", paramString);
      mur.a(localHashMap, paramLong);
      b(32785, localHashMap);
    }
  }
  
  boolean b()
  {
    String str = this.jdField_a_of_type_Bkwu.c();
    return (str == null) || (str.equals("DEVICE_NONE")) || (str.equals(""));
  }
  
  int c(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTEDDEVICE_REULT_LIST", this.jdField_a_of_type_Bkwu.d());
    a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  int d(HashMap<String, Object> paramHashMap)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("GETCONNECTINGDEVICE_REULT_LIST", this.jdField_a_of_type_Bkwu.c());
    a(localIntent, paramHashMap, 0);
    return 0;
  }
  
  public void d()
  {
    AudioDeviceInterface.LogTraceEntry("");
    if (this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper != null)
    {
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper.a();
      this.jdField_a_of_type_ComTencentSharpJniTraeAudioManager$TraeAudioManagerLooper = null;
    }
    AudioDeviceInterface.LogTraceExit();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramContext == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("TraeAudioManager", 2, "onReceive intent or context is null!");
      }
    }
    boolean bool2;
    do
    {
      String str1;
      String str2;
      long l;
      do
      {
        boolean bool1;
        do
        {
          for (;;)
          {
            return;
            try
            {
              str1 = paramIntent.getAction();
              str2 = paramIntent.getStringExtra("PARAM_OPERATION");
              l = mur.a(paramIntent);
              if (QLog.isColorLevel()) {
                QLog.w("TraeAudioManager", 1, "onReceive, strAction[" + str1 + "], strOption[" + str2 + "], seq[" + l + "]");
              }
              if (this.jdField_a_of_type_Bkwu == null)
              {
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("TraeAudioManager", 2, "_deviceConfigManager null!");
              }
            }
            catch (Exception paramContext)
            {
              QLog.w("TraeAudioManager", 2, "Deal TraeAudioManager.onReceive error", paramContext);
              return;
            }
          }
          bool1 = this.jdField_a_of_type_Bkwu.b("DEVICE_WIREDHEADSET");
          bool2 = this.jdField_a_of_type_Bkwu.b("DEVICE_BLUETOOTHHEADSET");
          if (!"android.intent.action.HEADSET_PLUG".equals(str1)) {
            break;
          }
          a(paramContext, paramIntent);
          if ((!bool1) && (this.jdField_a_of_type_Bkwu.b("DEVICE_WIREDHEADSET"))) {
            a("DEVICE_WIREDHEADSET", true);
          }
        } while ((!bool1) || (this.jdField_a_of_type_Bkwu.b("DEVICE_WIREDHEADSET")));
        a("DEVICE_WIREDHEADSET", false);
        return;
      } while ("android.media.AUDIO_BECOMING_NOISY".equals(str1));
      if ("com.tencent.av.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str1))
      {
        a(paramContext, paramIntent, str2, l);
        return;
      }
      if (("com.tencent.sharp.ACTION_TRAEAUDIOMANAGER_REQUEST".equals(str1)) && (BaseApplicationImpl.processName != null) && (BaseApplicationImpl.processName.endsWith("groupvideo")))
      {
        a(l, str2, paramIntent, paramContext);
        return;
      }
    } while (this.jdField_a_of_type_Bkwu == null);
    if (this.jdField_a_of_type_Bkwt != null) {
      this.jdField_a_of_type_Bkwt.a(paramContext, paramIntent, this.jdField_a_of_type_Bkwu);
    }
    for (;;)
    {
      if ((!bool2) && (this.jdField_a_of_type_Bkwu.b("DEVICE_BLUETOOTHHEADSET"))) {
        a("DEVICE_BLUETOOTHHEADSET", true);
      }
      if ((!bool2) || (this.jdField_a_of_type_Bkwu.b("DEVICE_BLUETOOTHHEADSET"))) {
        break;
      }
      a("DEVICE_BLUETOOTHHEADSET", false);
      return;
      QLog.w("TraeAudioManager", 2, "Deal TraeAudioManager.onReceive mDeviceConfigManager != null--> mBluetoothCheck = null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sharp.jni.TraeAudioManager
 * JD-Core Version:    0.7.0.1
 */