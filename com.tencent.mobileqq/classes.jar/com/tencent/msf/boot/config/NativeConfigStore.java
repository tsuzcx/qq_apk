package com.tencent.msf.boot.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.qmethodmonitor.monitor.PhoneInfoMonitor;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

public class NativeConfigStore
{
  public static boolean isLoaded = false;
  public static int soLoadResultCode = 0;
  private static String tag = "MSF.C.NativeConfigStore";
  Context context;
  public AtomicBoolean loadSaveRootSucc = new AtomicBoolean(true);
  
  static {}
  
  public NativeConfigStore(Context paramContext)
  {
    this.context = paramContext;
  }
  
  public static String getConfigIMEI()
  {
    try
    {
      String str = PhoneInfoMonitor.getDeviceId((TelephonyManager)BaseApplication.getContext().getSystemService("phone"));
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
    if (!isLoaded)
    {
      localObject2 = null;
      Object localObject3;
      Object localObject4;
      try
      {
        ApplicationInfo localApplicationInfo = BaseApplication.getContext().getApplicationInfo();
      }
      catch (Exception localException)
      {
        localObject3 = tag;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("load msfbootV2 failed getApplicationInfo exception=");
        ((StringBuilder)localObject4).append(localException);
        QLog.e((String)localObject3, 1, ((StringBuilder)localObject4).toString());
        localObject1 = null;
      }
      if (localObject1 != null)
      {
        try
        {
          localObject3 = localObject1.getClass().getDeclaredField("primaryCpuAbi");
          ((Field)localObject3).setAccessible(true);
          localObject3 = (String)((Field)localObject3).get(localObject1);
          localObject2 = localObject3;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          localObject4 = tag;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("load msfbootV2 failed get primaryCpuAbi IllegalAccessException=");
          localStringBuilder.append(localIllegalAccessException);
          QLog.e((String)localObject4, 1, localStringBuilder.toString());
        }
        catch (NoSuchFieldException localNoSuchFieldException)
        {
          localObject4 = tag;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("load msfbootV2 failed get primaryCpuAbi NoSuchFieldException=");
          localStringBuilder.append(localNoSuchFieldException);
          QLog.e((String)localObject4, 1, localStringBuilder.toString());
        }
        String str = tag;
        localObject4 = new StringBuilder("load msfbootV2 failed CPU_ABI=");
        ((StringBuilder)localObject4).append(Build.CPU_ABI);
        ((StringBuilder)localObject4).append(", CPU_ABI2=");
        ((StringBuilder)localObject4).append(Build.CPU_ABI2);
        ((StringBuilder)localObject4).append(", nativeLibraryDir=");
        ((StringBuilder)localObject4).append(((ApplicationInfo)localObject1).nativeLibraryDir);
        ((StringBuilder)localObject4).append(", primaryCpuAbi=");
        ((StringBuilder)localObject4).append((String)localObject2);
        ((StringBuilder)localObject4).append(", classLoader=");
        ((StringBuilder)localObject4).append(BaseApplication.getContext().getClassLoader());
        QLog.e(str, 1, ((StringBuilder)localObject4).toString());
      }
    }
    Object localObject1 = tag;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("loadso msfbootV2 ");
    ((StringBuilder)localObject2).append(isLoaded);
    ((StringBuilder)localObject2).append(" resultCode=");
    ((StringBuilder)localObject2).append(soLoadResultCode);
    ((StringBuilder)localObject2).append(" cost=");
    ((StringBuilder)localObject2).append(SystemClock.elapsedRealtime() - l);
    QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
  }
  
  public synchronized native String getConfig(String paramString);
  
  public synchronized native String[] getConfigList(String paramString);
  
  public synchronized native int loadConfig(Context paramContext, boolean paramBoolean);
  
  public String[] n_getConfigList(String paramString)
  {
    try
    {
      if (!this.loadSaveRootSucc.get())
      {
        QLog.w(tag, 1, "loadSaveRootFailed,return");
        return new String[0];
      }
      paramString = getConfigList(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void n_removeConfig(String paramString)
  {
    try
    {
      if (!this.loadSaveRootSucc.get())
      {
        QLog.w(tag, 1, "loadSaveRootFailed,return");
        return;
      }
      removeConfig(paramString);
      return;
    }
    finally {}
  }
  
  public void n_setConfig(String paramString1, String paramString2)
  {
    try
    {
      if (!this.loadSaveRootSucc.get())
      {
        QLog.w(tag, 1, "loadSaveRootFailed,return");
        return;
      }
      setConfig(paramString1, paramString2);
      return;
    }
    finally {}
  }
  
  /* Error */
  public int removeConfig(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_1
    //   4: invokevirtual 222	com/tencent/msf/boot/config/NativeConfigStore:removeConfigNative	(Ljava/lang/String;)I
    //   7: istore_2
    //   8: goto +22 -> 30
    //   11: astore_1
    //   12: goto +85 -> 97
    //   15: astore_1
    //   16: getstatic 62	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   19: iconst_2
    //   20: ldc 224
    //   22: aload_1
    //   23: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   26: sipush -10000
    //   29: istore_2
    //   30: iload_2
    //   31: ifeq +62 -> 93
    //   34: new 228	java/util/HashMap
    //   37: dup
    //   38: bipush 8
    //   40: invokespecial 231	java/util/HashMap:<init>	(I)V
    //   43: astore_1
    //   44: new 102	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   51: astore_3
    //   52: aload_3
    //   53: iload_2
    //   54: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: aload_3
    //   59: ldc 233
    //   61: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_1
    //   66: ldc 235
    //   68: aload_3
    //   69: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   72: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: getstatic 245	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   79: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   82: ldc 251
    //   84: iconst_1
    //   85: lconst_0
    //   86: lconst_0
    //   87: aload_1
    //   88: iconst_0
    //   89: iconst_0
    //   90: invokevirtual 257	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   93: aload_0
    //   94: monitorexit
    //   95: iload_2
    //   96: ireturn
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	101	0	this	NativeConfigStore
    //   0	101	1	paramString	String
    //   7	89	2	i	int
    //   51	18	3	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   2	8	11	finally
    //   16	26	11	finally
    //   34	93	11	finally
    //   2	8	15	java/lang/UnsatisfiedLinkError
  }
  
  public native int removeConfigNative(String paramString);
  
  /* Error */
  public int setConfig(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_m1
    //   3: istore 4
    //   5: aload_0
    //   6: aload_1
    //   7: aload_2
    //   8: invokevirtual 260	com/tencent/msf/boot/config/NativeConfigStore:setConfigNative	(Ljava/lang/String;Ljava/lang/String;)I
    //   11: istore_3
    //   12: goto +53 -> 65
    //   15: astore_1
    //   16: goto +132 -> 148
    //   19: astore_1
    //   20: getstatic 62	com/tencent/msf/boot/config/NativeConfigStore:tag	Ljava/lang/String;
    //   23: iconst_1
    //   24: ldc_w 262
    //   27: aload_1
    //   28: invokestatic 226	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   31: iload 4
    //   33: istore_3
    //   34: new 264	java/util/Random
    //   37: dup
    //   38: invokespecial 265	java/util/Random:<init>	()V
    //   41: bipush 100
    //   43: invokevirtual 269	java/util/Random:nextInt	(I)I
    //   46: iconst_1
    //   47: if_icmpge +18 -> 65
    //   50: invokestatic 275	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   53: aload_1
    //   54: ldc_w 277
    //   57: aconst_null
    //   58: invokestatic 283	com/tencent/feedback/eup/CrashReport:handleCatchException	(Ljava/lang/Thread;Ljava/lang/Throwable;Ljava/lang/String;[B)Z
    //   61: pop
    //   62: iload 4
    //   64: istore_3
    //   65: iload_3
    //   66: ifeq +78 -> 144
    //   69: getstatic 245	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   72: ifnull +72 -> 144
    //   75: getstatic 245	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   78: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   81: ifnull +63 -> 144
    //   84: new 228	java/util/HashMap
    //   87: dup
    //   88: bipush 8
    //   90: invokespecial 231	java/util/HashMap:<init>	(I)V
    //   93: astore_1
    //   94: new 102	java/lang/StringBuilder
    //   97: dup
    //   98: invokespecial 103	java/lang/StringBuilder:<init>	()V
    //   101: astore_2
    //   102: aload_2
    //   103: iload_3
    //   104: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_2
    //   109: ldc 233
    //   111: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: aload_1
    //   116: ldc 235
    //   118: aload_2
    //   119: invokevirtual 115	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokevirtual 239	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   125: pop
    //   126: getstatic 245	com/tencent/mobileqq/msf/core/MsfCore:sCore	Lcom/tencent/mobileqq/msf/core/MsfCore;
    //   129: getfield 249	com/tencent/mobileqq/msf/core/MsfCore:statReporter	Lcom/tencent/mobileqq/msf/core/d/j;
    //   132: ldc_w 285
    //   135: iconst_1
    //   136: lconst_0
    //   137: lconst_0
    //   138: aload_1
    //   139: iconst_0
    //   140: iconst_0
    //   141: invokevirtual 257	com/tencent/mobileqq/msf/core/d/j:a	(Ljava/lang/String;ZJJLjava/util/Map;ZZ)V
    //   144: aload_0
    //   145: monitorexit
    //   146: iload_3
    //   147: ireturn
    //   148: aload_0
    //   149: monitorexit
    //   150: aload_1
    //   151: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	NativeConfigStore
    //   0	152	1	paramString1	String
    //   0	152	2	paramString2	String
    //   11	136	3	i	int
    //   3	60	4	j	int
    // Exception table:
    //   from	to	target	type
    //   5	12	15	finally
    //   20	31	15	finally
    //   34	62	15	finally
    //   69	144	15	finally
    //   5	12	19	java/lang/UnsatisfiedLinkError
  }
  
  public native int setConfigNative(String paramString1, String paramString2);
  
  public synchronized native void setSaveRootPath(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.msf.boot.config.NativeConfigStore
 * JD-Core Version:    0.7.0.1
 */