package com.tencent.mobileqq.nativememorymonitor.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;

public class NativeMemoryMonitor
{
  public static final String ALL_SO_HOOK = "all_so_hook";
  public static final long FLAG_JNI_CALLXXMETHOD_MONITOR = 32L;
  public static final long FLAG_JNI_GLOBAL_REF_MONITOR = 1L;
  public static final long FLAG_JNI_LOCAL_REF_MONITOR = 2L;
  public static final long FLAG_JNI_LONG_SET_FIELD_MONITOR = 8L;
  public static final long FLAG_JNI_NATIVE_THREAD_MONITOR = 64L;
  public static final long FLAG_JNI_PRIMITIVE_ARRAY_MONITOR = 4L;
  public static final long FLAG_JNI_WEAK_GLOBAL_REF_MONITOR = 16L;
  public static final long FLAG_LARGE_OBJECT_ALLOC_MONITOR = 4294967296L;
  public static final long FLAG_LOG_ALL = 4611686018427387904L;
  public static final long FLAG_OVER_ALLOCATE_PER_TIME_MONITOR = 2147483648L;
  private static final String TAG = "NativeMemoryMonitor";
  private static ExternalProvider externalProvider;
  private static volatile boolean sSoLoadRes = false;
  private static volatile boolean sSoLoaded = false;
  private boolean mInit = false;
  private boolean mInitThreadHook = false;
  
  private native boolean applyHiddenApiPolicyCrack(ApplicationInfo paramApplicationInfo);
  
  public static NativeMemoryMonitor getInstance(Context paramContext)
  {
    loadSoIfNeeded(paramContext);
    return NativeMemoryMonitor.Holder.access$000();
  }
  
  private static void loadSoIfNeeded(Context paramContext)
  {
    if (!sSoLoaded) {
      if ((!SoLoadUtilNew.loadSoByName(paramContext, "c++_shared")) || (!SoLoadUtilNew.loadSoByName(paramContext, "native-memory-library-lib"))) {
        break label59;
      }
    }
    label59:
    for (boolean bool = true;; bool = false)
    {
      sSoLoadRes = bool;
      logErrorFromNative("load so res: " + sSoLoadRes);
      sSoLoaded = true;
      return;
    }
  }
  
  private static void logErrorFromNative(String paramString)
  {
    try
    {
      QLog.e("NativeMemoryMonitor", 1, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("NativeMemoryMonitor", "try to log " + paramString + " but QLog is not found");
    }
  }
  
  private static void logInfoFromNative(String paramString)
  {
    try
    {
      QLog.i("NativeMemoryMonitor", 2, paramString);
      return;
    }
    catch (Throwable localThrowable)
    {
      Log.d("NativeMemoryMonitor", "try to log " + paramString + " but QLog is not found");
    }
  }
  
  private native void nativeDump();
  
  private native int nativeGetJavaThreadPeakCount();
  
  private native void nativeInit(long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4);
  
  private native void nativeSoLoadHook(String paramString1, String paramString2);
  
  private native void nativeThreadCreateHookInit(String paramString);
  
  private native void nativeThreadHook();
  
  private static void onSoLoad(String paramString1, String paramString2)
  {
    ExternalProvider localExternalProvider = externalProvider;
    if (localExternalProvider != null)
    {
      String str = paramString2.replaceAll("\\t", " ");
      if (paramString2.equals(str)) {}
      paramString2 = str;
      if (str.startsWith("java.lang.Throwable: \n")) {
        paramString2 = str.substring("java.lang.Throwable: \n".length());
      }
      localExternalProvider.onSoLoad(paramString1, paramString2);
    }
  }
  
  public boolean applyHiddenApiPolicyCrack(Context paramContext)
  {
    return applyHiddenApiPolicyCrack(paramContext.getApplicationInfo());
  }
  
  public void dump()
  {
    try
    {
      nativeDump();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int getJavaThreadPeakCount()
  {
    if (!sSoLoadRes) {
      return 0;
    }
    return nativeGetJavaThreadPeakCount();
  }
  
  public native String getUndetachThreads();
  
  public void init(long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.mInit;
        if (bool) {
          return;
        }
        if (!sSoLoadRes)
        {
          logErrorFromNative("SoLoad fail");
          continue;
        }
        logErrorFromNative("init");
      }
      finally {}
      logInfoFromNative("init");
      nativeInit(paramLong1, paramArrayOfString, paramLong2, paramLong3, paramLong4);
      this.mInit = true;
    }
  }
  
  /* Error */
  public void initThreadHook(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 55	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:sSoLoadRes	Z
    //   5: istore_2
    //   6: iload_2
    //   7: ifne +6 -> 13
    //   10: aload_0
    //   11: monitorexit
    //   12: return
    //   13: aload_0
    //   14: getfield 63	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:mInitThreadHook	Z
    //   17: ifne -7 -> 10
    //   20: aload_0
    //   21: iconst_1
    //   22: putfield 63	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:mInitThreadHook	Z
    //   25: aload_0
    //   26: aload_1
    //   27: invokespecial 201	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeThreadCreateHookInit	(Ljava/lang/String;)V
    //   30: aload_0
    //   31: invokespecial 203	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeThreadHook	()V
    //   34: goto -24 -> 10
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	42	0	this	NativeMemoryMonitor
    //   0	42	1	paramString	String
    //   5	2	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	6	37	finally
    //   13	34	37	finally
  }
  
  public native void setupASanCallback();
  
  public void setupSoLoadHook(Context paramContext, ExternalProvider paramExternalProvider)
  {
    try
    {
      externalProvider = paramExternalProvider;
      paramExternalProvider = paramContext.getApplicationInfo();
      nativeSoLoadHook(paramContext.getPackageName(), paramExternalProvider.nativeLibraryDir);
      return;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor
 * JD-Core Version:    0.7.0.1
 */