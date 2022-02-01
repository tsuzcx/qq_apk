package com.tencent.msf.boot.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.tencent.feedback.eup.CrashReport;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c.j;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeConfigStore
{
  public static boolean isLoaded;
  public static int soLoadResultCode;
  private static String tag = "MSF.C.NativeConfigStore";
  Context context;
  public AtomicBoolean loadSaveRootSucc = new AtomicBoolean(true);
  
  static
  {
    isLoaded = false;
    soLoadResultCode = 0;
    loadSo();
  }
  
  public NativeConfigStore(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static String getConfigIMEI()
  {
    try
    {
      String str = ((TelephonyManager)BaseApplication.getContext().getSystemService("phone")).getDeviceId();
      return str;
    }
    catch (Exception localException)
    {
      QLog.w(tag, 1, "get imei failed ", localException);
    }
    return null;
  }
  
  public static void loadSo()
  {
    long l = SystemClock.elapsedRealtime();
    soLoadResultCode = StringUtils.msfLoadSo(tag, "msfbootV2");
    isLoaded = StringUtils.getLoadResult(soLoadResultCode);
    if (!isLoaded) {}
    try
    {
      localApplicationInfo = BaseApplication.getContext().getApplicationInfo();
      if (localApplicationInfo == null) {}
    }
    catch (Exception localException)
    {
      try
      {
        Object localObject1 = localApplicationInfo.getClass().getDeclaredField("primaryCpuAbi");
        ((Field)localObject1).setAccessible(true);
        localObject1 = (String)((Field)localObject1).get(localApplicationInfo);
        QLog.e(tag, 1, "load msfbootV2 failed CPU_ABI=" + Build.CPU_ABI + ", CPU_ABI2=" + Build.CPU_ABI2 + ", nativeLibraryDir=" + localApplicationInfo.nativeLibraryDir + ", primaryCpuAbi=" + (String)localObject1 + ", classLoader=" + BaseApplication.getContext().getClassLoader());
        QLog.e(tag, 1, "loadso msfbootV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - l));
        return;
        localException = localException;
        QLog.e(tag, 1, "load msfbootV2 failed getApplicationInfo exception=" + localException);
        ApplicationInfo localApplicationInfo = null;
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        for (;;)
        {
          QLog.e(tag, 1, "load msfbootV2 failed get primaryCpuAbi NoSuchFieldException=" + localNoSuchFieldException);
          Object localObject2 = null;
        }
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        for (;;)
        {
          QLog.e(tag, 1, "load msfbootV2 failed get primaryCpuAbi IllegalAccessException=" + localIllegalAccessException);
          Object localObject3 = null;
        }
      }
    }
  }
  
  public synchronized native String getConfig(String paramString);
  
  public synchronized native String[] getConfigList(String paramString);
  
  public synchronized native int loadConfig(Context paramContext, boolean paramBoolean);
  
  /* Error */
  public String[] n_getConfigList(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 197	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +21 -> 30
    //   12: getstatic 20	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   15: iconst_1
    //   16: ldc 199
    //   18: invokestatic 201	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: iconst_0
    //   22: anewarray 119	java/lang/String
    //   25: astore_1
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_1
    //   29: areturn
    //   30: aload_0
    //   31: aload_1
    //   32: invokevirtual 203	com/tencent/msf/boot/config/NativeConfigStore:getConfigList	(Ljava/lang/String;)[Ljava/lang/String;
    //   35: astore_1
    //   36: goto -10 -> 26
    //   39: astore_1
    //   40: aload_0
    //   41: monitorexit
    //   42: aload_1
    //   43: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	44	0	this	NativeConfigStore
    //   0	44	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	26	39	finally
    //   30	36	39	finally
  }
  
  /* Error */
  public void n_removeConfig(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 197	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +15 -> 24
    //   12: getstatic 20	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   15: iconst_1
    //   16: ldc 199
    //   18: invokestatic 201	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 208	com/tencent/msf/boot/config/NativeConfigStore:removeConfig	(Ljava/lang/String;)I
    //   29: pop
    //   30: goto -9 -> 21
    //   33: astore_1
    //   34: aload_0
    //   35: monitorexit
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	this	NativeConfigStore
    //   0	38	1	paramString	String
    // Exception table:
    //   from	to	target	type
    //   2	21	33	finally
    //   24	30	33	finally
  }
  
  /* Error */
  public void n_setConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 39	com/tencent/msf/boot/config/NativeConfigStore:loadSaveRootSucc	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: invokevirtual 197	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   9: ifne +15 -> 24
    //   12: getstatic 20	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   15: iconst_1
    //   16: ldc 199
    //   18: invokestatic 201	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_0
    //   25: aload_1
    //   26: aload_2
    //   27: invokevirtual 213	com/tencent/msf/boot/config/NativeConfigStore:setConfig	(Ljava/lang/String;Ljava/lang/String;)I
    //   30: pop
    //   31: goto -10 -> 21
    //   34: astore_1
    //   35: aload_0
    //   36: monitorexit
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	NativeConfigStore
    //   0	39	1	paramString1	String
    //   0	39	2	paramString2	String
    // Exception table:
    //   from	to	target	type
    //   2	21	34	finally
    //   24	31	34	finally
  }
  
  public int removeConfig(String paramString)
  {
    try
    {
      i = removeConfigNative(paramString);
      if (i != 0)
      {
        paramString = new HashMap(8);
        paramString.put("ret", i + "");
        MsfCore.sCore.statReporter.a("EvtRemoveCfgRenameReport", true, 0L, 0L, paramString, false, false);
      }
      return i;
    }
    catch (UnsatisfiedLinkError paramString)
    {
      for (;;)
      {
        QLog.e(tag, 2, "removeConfig fail ", paramString);
        int i = -10000;
      }
    }
    finally {}
  }
  
  public native int removeConfigNative(String paramString);
  
  public int setConfig(String paramString1, String paramString2)
  {
    int j = -1;
    try
    {
      i = setConfigNative(paramString1, paramString2);
      if ((i != 0) && (MsfCore.sCore != null) && (MsfCore.sCore.statReporter != null))
      {
        paramString1 = new HashMap(8);
        paramString1.put("ret", i + "");
        MsfCore.sCore.statReporter.a("EvtSetCfgRenameReport", true, 0L, 0L, paramString1, false, false);
      }
      return i;
    }
    catch (UnsatisfiedLinkError paramString1)
    {
      for (;;)
      {
        QLog.e(tag, 1, "setConfig error:", paramString1);
        int i = j;
        if (new Random().nextInt(100) < 1)
        {
          CrashReport.handleCatchException(Thread.currentThread(), paramString1, "NativeConfigStoreCatchedException", null);
          i = j;
        }
      }
    }
    finally {}
  }
  
  public native int setConfigNative(String paramString1, String paramString2);
  
  public synchronized native void setSaveRootPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.msf.boot.config.NativeConfigStore
 * JD-Core Version:    0.7.0.1
 */