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
  private static volatile long sLastClean;
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
          continue;
        }
        bool = false;
        useUnsafe = bool;
        Log.i("EpicNative", "use unsafe ? " + useUnsafe);
      }
      catch (Throwable localThrowable)
      {
        boolean bool;
        Log.e("EpicNative", "init EpicNative error", localThrowable);
        continue;
      }
      sLock = new Object();
      sRefCounts = new AtomicInteger(0);
      return;
      bool = true;
    }
  }
  
  static native boolean activateNative(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte);
  
  public static native boolean cacheflush(long paramLong1, long paramLong2);
  
  private static void cleanRefIfNeed()
  {
    int i = 300000;
    int j = sRefCounts.incrementAndGet();
    if (j > 10000) {
      i = 30000;
    }
    for (;;)
    {
      if (SystemClock.uptimeMillis() - sLastClean > i)
      {
        Log.d("harlan", "begin cleanRef size " + sRefCounts.get());
        System.gc();
        long l = SystemClock.uptimeMillis();
        i = cleanRefs(sLock);
        sLastClean = SystemClock.uptimeMillis();
        Log.d("harlan", "end cleanRef size " + i + " cost " + (sLastClean - l));
        sRefCounts.set(i);
      }
      return;
      if (j > 25000) {
        i = 1000;
      }
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
    Logger.d("EpicNative", "Copy " + paramInt + " bytes form " + Debug.addrHex(paramLong1) + " to " + Debug.addrHex(paramLong2));
    memcpy(paramLong1, paramLong2, paramInt);
  }
  
  public static native void disableMovingGc(int paramInt);
  
  public static byte[] get(long paramLong, int paramInt)
  {
    Logger.d("EpicNative", "Reading " + paramInt + " bytes from: " + Debug.addrHex(paramLong));
    byte[] arrayOfByte = memget(paramLong, paramInt);
    Logger.d("EpicNative", Debug.hexdump(arrayOfByte, paramLong));
    return arrayOfByte;
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
    Logger.i("EpicNative", "Mapped memory of size " + paramInt + " at " + Debug.addrHex(l));
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
    Logger.d("EpicNative", "Removing mapped memory of size " + paramInt + " at " + Debug.addrHex(paramLong));
    return munmap(paramLong, paramInt);
  }
  
  public static boolean unprotect(long paramLong1, long paramLong2)
  {
    Logger.d("EpicNative", "Disabling mprotect from " + Debug.addrHex(paramLong1));
    return munprotect(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     me.weishu.epic.art.EpicNative
 * JD-Core Version:    0.7.0.1
 */