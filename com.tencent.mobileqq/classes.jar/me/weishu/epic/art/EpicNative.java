package me.weishu.epic.art;

import android.util.Log;
import com.taobao.android.dexposed.DeviceCheck;
import com.taobao.android.dexposed.utility.Debug;
import com.taobao.android.dexposed.utility.Logger;
import com.taobao.android.dexposed.utility.Unsafe;
import de.robv.android.xposed.XposedHelpers;
import java.lang.reflect.Member;

public final class EpicNative
{
  private static final String TAG = "EpicNative";
  private static volatile boolean useUnsafe = false;
  
  static
  {
    boolean bool = false;
    for (;;)
    {
      try
      {
        System.loadLibrary("epic");
        if ((!DeviceCheck.isYunOS()) && (isGetObjectAvailable()))
        {
          useUnsafe = bool;
          Log.i("EpicNative", "use unsafe ? " + useUnsafe);
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Log.e("EpicNative", "init EpicNative error", localThrowable);
        return;
      }
      bool = true;
    }
  }
  
  static native boolean activateNative(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte);
  
  public static native boolean cacheflush(long paramLong1, long paramLong2);
  
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
    return getObjectNative(paramLong1, paramLong2);
  }
  
  public static native Object getObjectNative(long paramLong1, long paramLong2);
  
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
    Logger.d("EpicNative", "Writing memory to: " + Debug.addrHex(paramLong));
    Logger.d("EpicNative", Debug.hexdump(paramArrayOfByte, paramLong));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     me.weishu.epic.art.EpicNative
 * JD-Core Version:    0.7.0.1
 */