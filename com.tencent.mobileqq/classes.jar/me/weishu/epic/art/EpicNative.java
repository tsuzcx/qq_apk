package me.weishu.epic.art;

import android.os.SystemClock;
import android.util.Log;
import com.qq.android.dexposed.DeviceCheck;
import com.qq.android.dexposed.XposedHelpers;
import com.qq.android.dexposed.utility.Debug;
import com.qq.android.dexposed.utility.Logger;
import com.qq.android.dexposed.utility.Unsafe;
import java.lang.reflect.Member;
import java.util.concurrent.atomic.AtomicInteger;

public final class EpicNative
{
  public static final int CLEAN_DURATION = 300000;
  public static final int CLEAN_DURATION_DANGEROUS = 30000;
  public static final int CLEAN_DURATION_VERY_DANGEROUS = 1000;
  private static final String TAG = "EpicNative";
  private static volatile long sLastClean = 0L;
  private static Object sLock;
  private static AtomicInteger sRefCounts;
  private static volatile boolean useUnsafe = false;
  
  static
  {
    for (;;)
    {
      try
      {
        System.loadLibrary("qqjhook");
        if ((DeviceCheck.isYunOS()) || (!isGetObjectAvailable())) {
          break label89;
        }
        bool = false;
        useUnsafe = bool;
        StringBuilder localStringBuilder = new StringBuilder("use unsafe ? ");
        localStringBuilder.append(useUnsafe);
        Log.i("EpicNative", localStringBuilder.toString());
      }
      catch (Throwable localThrowable)
      {
        Log.e("EpicNative", "init EpicNative error", localThrowable);
      }
      sLock = new Object();
      sRefCounts = new AtomicInteger(0);
      return;
      label89:
      boolean bool = true;
    }
  }
  
  static native boolean activateNative(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte);
  
  public static native boolean cacheflush(long paramLong1, long paramLong2);
  
  private static void cleanRefIfNeed()
  {
    int i = sRefCounts.incrementAndGet();
    if (i > 10000) {
      i = 30000;
    } else if (i > 25000) {
      i = 1000;
    } else {
      i = 300000;
    }
    if (SystemClock.uptimeMillis() - sLastClean > i)
    {
      StringBuilder localStringBuilder = new StringBuilder("begin cleanRef size ");
      localStringBuilder.append(sRefCounts.get());
      Log.d("harlan", localStringBuilder.toString());
      System.gc();
      long l = SystemClock.uptimeMillis();
      i = cleanRefs(sLock);
      sLastClean = SystemClock.uptimeMillis();
      localStringBuilder = new StringBuilder("end cleanRef size ");
      localStringBuilder.append(i);
      localStringBuilder.append(" cost ");
      localStringBuilder.append(sLastClean - l);
      Log.d("harlan", localStringBuilder.toString());
      sRefCounts.set(i);
    }
  }
  
  private static native int cleanRefs(Object paramObject);
  
  public static boolean compileMethod(Member paramMember)
  {
    return compileMethod(paramMember, XposedHelpers.getLongField(Thread.currentThread(), "nativePeer"));
  }
  
  public static native boolean compileMethod(Member paramMember, long paramLong);
  
  public static void copy(long paramLong1, long paramLong2, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("Copy ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" bytes form ");
    localStringBuilder.append(Debug.addrHex(paramLong1));
    localStringBuilder.append(" to ");
    localStringBuilder.append(Debug.addrHex(paramLong2));
    Logger.d("EpicNative", localStringBuilder.toString());
    memcpy(paramLong1, paramLong2, paramInt);
  }
  
  public static native void disableMovingGc(int paramInt);
  
  public static byte[] get(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder("Reading ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" bytes from: ");
    ((StringBuilder)localObject).append(Debug.addrHex(paramLong));
    Logger.d("EpicNative", ((StringBuilder)localObject).toString());
    localObject = memget(paramLong, paramInt);
    Logger.d("EpicNative", Debug.hexdump((byte[])localObject, paramLong));
    return localObject;
  }
  
  public static native long getMethodAddress(Member paramMember);
  
  public static Object getObject(long paramLong)
  {
    return getObject(XposedHelpers.getLongField(Thread.currentThread(), "nativePeer"), paramLong);
  }
  
  public static Object getObject(long paramLong1, long paramLong2)
  {
    if (useUnsafe) {
      return Unsafe.getObject(paramLong2);
    }
    cleanRefIfNeed();
    return getObjectNative(paramLong1, paramLong2, sLock);
  }
  
  public static native Object getObjectNative(long paramLong1, long paramLong2, Object paramObject);
  
  private static native boolean isGetObjectAvailable();
  
  public static native long malloc(int paramInt);
  
  public static long map(int paramInt)
  {
    long l = mmap(paramInt);
    StringBuilder localStringBuilder = new StringBuilder("Mapped memory of size ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" at ");
    localStringBuilder.append(Debug.addrHex(l));
    Logger.i("EpicNative", localStringBuilder.toString());
    return l;
  }
  
  public static native void memcpy(long paramLong1, long paramLong2, int paramInt);
  
  public static native byte[] memget(long paramLong, int paramInt);
  
  public static native void memput(byte[] paramArrayOfByte, long paramLong);
  
  public static native long mmap(int paramInt);
  
  public static native boolean munmap(long paramLong, int paramInt);
  
  public static native boolean munprotect(long paramLong1, long paramLong2);
  
  public static void put(byte[] paramArrayOfByte, long paramLong)
  {
    memput(paramArrayOfByte, paramLong);
  }
  
  public static native void resumeAll(long paramLong);
  
  public static native void startJit(long paramLong);
  
  public static native long stopJit();
  
  public static native long suspendAll();
  
  public static boolean unmap(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("Removing mapped memory of size ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" at ");
    localStringBuilder.append(Debug.addrHex(paramLong));
    Logger.d("EpicNative", localStringBuilder.toString());
    return munmap(paramLong, paramInt);
  }
  
  public static boolean unprotect(long paramLong1, long paramLong2)
  {
    StringBuilder localStringBuilder = new StringBuilder("Disabling mprotect from ");
    localStringBuilder.append(Debug.addrHex(paramLong1));
    Logger.d("EpicNative", localStringBuilder.toString());
    return munprotect(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.EpicNative
 * JD-Core Version:    0.7.0.1
 */