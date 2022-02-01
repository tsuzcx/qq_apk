package com.tencent.mobileqq.nativememorymonitor.library;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.util.Log;
import com.tencent.commonsdk.soload.SoLoadUtilNew;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

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
  private static volatile boolean sFileHooked = false;
  private static volatile boolean sSoLoadRes = false;
  private static volatile boolean sSoLoaded = false;
  private final Set<IFileMonitor> fileMonitors = new HashSet();
  private ReadWriteLock fileMonitorsLock = new ReentrantReadWriteLock();
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
    if (!sSoLoaded)
    {
      boolean bool;
      if ((SoLoadUtilNew.loadSoByName(paramContext, "c++_shared")) && (SoLoadUtilNew.loadSoByName(paramContext, "native-memory-library-lib"))) {
        bool = true;
      } else {
        bool = false;
      }
      sSoLoadRes = bool;
      paramContext = new StringBuilder();
      paramContext.append("load so res: ");
      paramContext.append(sSoLoadRes);
      logErrorFromNative(paramContext.toString());
      sSoLoaded = true;
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
      label8:
      StringBuilder localStringBuilder;
      break label8;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("try to log ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" but QLog is not found");
    Log.d("NativeMemoryMonitor", localStringBuilder.toString());
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
      label8:
      StringBuilder localStringBuilder;
      break label8;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("try to log ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" but QLog is not found");
    Log.d("NativeMemoryMonitor", localStringBuilder.toString());
  }
  
  private native void nativeDump();
  
  private native void nativeFileHook(long paramLong1, long paramLong2);
  
  private native int nativeGetJavaThreadPeakCount();
  
  private native void nativeInit(long paramLong1, String[] paramArrayOfString, long paramLong2, long paramLong3, long paramLong4);
  
  private native void nativeJniHookInit(long paramLong1, long paramLong2);
  
  private native void nativeSoLoadHook(String paramString1, String paramString2, long paramLong);
  
  private native void nativeThreadCreateHookInit(String paramString);
  
  private native void nativeThreadHook();
  
  private void onFileRemove(String paramString)
  {
    try
    {
      this.fileMonitorsLock.readLock().lock();
      Iterator localIterator = this.fileMonitors.iterator();
      while (localIterator.hasNext())
      {
        IFileMonitor localIFileMonitor = (IFileMonitor)localIterator.next();
        try
        {
          localIFileMonitor.onFileRemove(paramString);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("NativeMemoryMonitor", 1, localThrowable, new Object[0]);
        }
      }
      this.fileMonitorsLock.readLock().unlock();
      return;
    }
    finally
    {
      this.fileMonitorsLock.readLock().unlock();
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  private void onFileRename(String paramString1, String paramString2)
  {
    try
    {
      this.fileMonitorsLock.readLock().lock();
      Iterator localIterator = this.fileMonitors.iterator();
      while (localIterator.hasNext())
      {
        IFileMonitor localIFileMonitor = (IFileMonitor)localIterator.next();
        try
        {
          localIFileMonitor.onFileRename(paramString1, paramString2);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("NativeMemoryMonitor", 1, localThrowable, new Object[0]);
        }
      }
      this.fileMonitorsLock.readLock().unlock();
      return;
    }
    finally
    {
      this.fileMonitorsLock.readLock().unlock();
    }
    for (;;)
    {
      throw paramString1;
    }
  }
  
  private static void onSoLoad(String paramString1, String paramString2)
  {
    ExternalProvider localExternalProvider = externalProvider;
    if (localExternalProvider != null)
    {
      String str = paramString2.replaceAll("\\t", " ");
      paramString2 = str;
      if (str.startsWith("java.lang.Throwable: \n")) {
        paramString2 = str.substring(22);
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
    try
    {
      boolean bool = this.mInit;
      if (bool) {
        return;
      }
      if (!sSoLoadRes)
      {
        logErrorFromNative("SoLoad fail");
        return;
      }
      logErrorFromNative("init");
      logInfoFromNative("init");
      nativeInit(paramLong1, paramArrayOfString, paramLong2, paramLong3, paramLong4);
      this.mInit = true;
      return;
    }
    finally {}
  }
  
  public void initThreadHook(String paramString)
  {
    try
    {
      boolean bool = sSoLoadRes;
      if (!bool) {
        return;
      }
      bool = this.mInitThreadHook;
      if (bool) {
        return;
      }
      this.mInitThreadHook = true;
      nativeThreadCreateHookInit(paramString);
      nativeThreadHook();
      return;
    }
    finally {}
  }
  
  public void removeFileMonitor(IFileMonitor paramIFileMonitor)
  {
    try
    {
      this.fileMonitorsLock.writeLock().lock();
      this.fileMonitors.remove(paramIFileMonitor);
      return;
    }
    finally
    {
      this.fileMonitorsLock.writeLock().unlock();
    }
  }
  
  public native void setupASanCallback();
  
  /* Error */
  public void setupFileHook(@android.support.annotation.NonNull IFileMonitor paramIFileMonitor)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 76	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:fileMonitorsLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   6: invokeinterface 263 1 0
    //   11: invokeinterface 172 1 0
    //   16: aload_0
    //   17: getfield 71	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:fileMonitors	Ljava/util/Set;
    //   20: aload_1
    //   21: invokeinterface 273 2 0
    //   26: pop
    //   27: aload_0
    //   28: getfield 76	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:fileMonitorsLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   31: invokeinterface 263 1 0
    //   36: invokeinterface 198 1 0
    //   41: invokestatic 278	com/tencent/mobileqq/nativememorymonitor/library/ClassToFindJniOffset:initFromJava	()V
    //   44: aload_0
    //   45: getstatic 281	com/tencent/mobileqq/nativememorymonitor/library/ClassToFindJniOffset:markArtMethod	J
    //   48: getstatic 284	com/tencent/mobileqq/nativememorymonitor/library/ClassToFindJniOffset:mark2ArtMethod	J
    //   51: invokespecial 286	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeJniHookInit	(JJ)V
    //   54: getstatic 288	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:sFileHooked	Z
    //   57: ifne +128 -> 185
    //   60: iconst_1
    //   61: putstatic 288	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:sFileHooked	Z
    //   64: getstatic 294	android/os/Build$VERSION:SDK_INT	I
    //   67: bipush 28
    //   69: if_icmple +51 -> 120
    //   72: aload_0
    //   73: ldc_w 296
    //   76: ldc_w 297
    //   79: iconst_1
    //   80: anewarray 299	java/lang/Class
    //   83: dup
    //   84: iconst_0
    //   85: ldc 211
    //   87: aastore
    //   88: invokestatic 305	com/tencent/mobileqq/nativememorymonitor/library/Utils:getHiddenArtMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)J
    //   91: ldc_w 296
    //   94: ldc_w 307
    //   97: iconst_2
    //   98: anewarray 299	java/lang/Class
    //   101: dup
    //   102: iconst_0
    //   103: ldc 211
    //   105: aastore
    //   106: dup
    //   107: iconst_1
    //   108: ldc 211
    //   110: aastore
    //   111: invokestatic 305	com/tencent/mobileqq/nativememorymonitor/library/Utils:getHiddenArtMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)J
    //   114: invokespecial 309	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeFileHook	(JJ)V
    //   117: goto +68 -> 185
    //   120: getstatic 294	android/os/Build$VERSION:SDK_INT	I
    //   123: bipush 28
    //   125: if_icmpne +54 -> 179
    //   128: aload_0
    //   129: ldc_w 311
    //   132: ldc_w 313
    //   135: iconst_1
    //   136: anewarray 299	java/lang/Class
    //   139: dup
    //   140: iconst_0
    //   141: ldc_w 315
    //   144: aastore
    //   145: invokestatic 305	com/tencent/mobileqq/nativememorymonitor/library/Utils:getHiddenArtMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)J
    //   148: ldc_w 311
    //   151: ldc_w 317
    //   154: iconst_2
    //   155: anewarray 299	java/lang/Class
    //   158: dup
    //   159: iconst_0
    //   160: ldc_w 315
    //   163: aastore
    //   164: dup
    //   165: iconst_1
    //   166: ldc_w 315
    //   169: aastore
    //   170: invokestatic 305	com/tencent/mobileqq/nativememorymonitor/library/Utils:getHiddenArtMethod	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Class;)J
    //   173: invokespecial 309	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeFileHook	(JJ)V
    //   176: goto +9 -> 185
    //   179: aload_0
    //   180: lconst_0
    //   181: lconst_0
    //   182: invokespecial 309	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:nativeFileHook	(JJ)V
    //   185: aload_0
    //   186: monitorexit
    //   187: return
    //   188: astore_1
    //   189: aload_0
    //   190: getfield 76	com/tencent/mobileqq/nativememorymonitor/library/NativeMemoryMonitor:fileMonitorsLock	Ljava/util/concurrent/locks/ReadWriteLock;
    //   193: invokeinterface 263 1 0
    //   198: invokeinterface 198 1 0
    //   203: aload_1
    //   204: athrow
    //   205: astore_1
    //   206: aload_0
    //   207: monitorexit
    //   208: aload_1
    //   209: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	210	0	this	NativeMemoryMonitor
    //   0	210	1	paramIFileMonitor	IFileMonitor
    // Exception table:
    //   from	to	target	type
    //   2	27	188	finally
    //   27	117	205	finally
    //   120	176	205	finally
    //   179	185	205	finally
    //   189	205	205	finally
  }
  
  public void setupSoLoadHook(Context paramContext, ExternalProvider paramExternalProvider)
  {
    try
    {
      externalProvider = paramExternalProvider;
      paramExternalProvider = paramContext.getApplicationInfo();
      ClassToFindJniOffset.initFromJava();
      nativeJniHookInit(ClassToFindJniOffset.markArtMethod, ClassToFindJniOffset.mark2ArtMethod);
      paramContext = paramContext.getPackageName();
      paramExternalProvider = paramExternalProvider.nativeLibraryDir;
      long l;
      if (Build.VERSION.SDK_INT < 30) {
        l = 0L;
      } else {
        l = Utils.getArtMethod(Runtime.class, "nativeLoad", new Class[] { String.class, ClassLoader.class, Class.class });
      }
      nativeSoLoadHook(paramContext, paramExternalProvider, l);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.nativememorymonitor.library.NativeMemoryMonitor
 * JD-Core Version:    0.7.0.1
 */