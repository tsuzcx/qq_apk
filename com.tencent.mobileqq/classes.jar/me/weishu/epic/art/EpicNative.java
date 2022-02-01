package me.weishu.epic.art;

import android.util.Log;
import com.qq.android.dexposed.DeviceCheck;
import com.qq.android.dexposed.utility.Debug;
import com.qq.android.dexposed.utility.Logger;
import java.lang.reflect.Member;
import java.util.concurrent.atomic.AtomicInteger;

public final class EpicNative
{
  private static volatile boolean a = false;
  private static Object b;
  private static AtomicInteger c;
  
  static
  {
    for (;;)
    {
      try
      {
        System.loadLibrary("qqjhook");
        if ((DeviceCheck.a()) || (!isGetObjectAvailable())) {
          break label89;
        }
        bool = false;
        a = bool;
        StringBuilder localStringBuilder = new StringBuilder("use unsafe ? ");
        localStringBuilder.append(a);
        Log.i("EpicNative", localStringBuilder.toString());
      }
      catch (Throwable localThrowable)
      {
        Log.e("EpicNative", "init EpicNative error", localThrowable);
      }
      b = new Object();
      c = new AtomicInteger(0);
      return;
      label89:
      boolean bool = true;
    }
  }
  
  public static void a(byte[] paramArrayOfByte, long paramLong)
  {
    memput(paramArrayOfByte, paramLong);
  }
  
  public static boolean a(long paramLong, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder("Removing mapped memory of size ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" at ");
    localStringBuilder.append(Debug.a(paramLong));
    Logger.b("EpicNative", localStringBuilder.toString());
    return munmap(paramLong, paramInt);
  }
  
  static native boolean activateNative(long paramLong1, long paramLong2, long paramLong3, long paramLong4, byte[] paramArrayOfByte);
  
  public static byte[] b(long paramLong, int paramInt)
  {
    Object localObject = new StringBuilder("Reading ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" bytes from: ");
    ((StringBuilder)localObject).append(Debug.a(paramLong));
    Logger.b("EpicNative", ((StringBuilder)localObject).toString());
    localObject = memget(paramLong, paramInt);
    Logger.b("EpicNative", Debug.a((byte[])localObject, paramLong));
    return localObject;
  }
  
  public static native boolean cacheflush(long paramLong1, long paramLong2);
  
  private static native int cleanRefs(Object paramObject);
  
  public static native boolean compileMethod(Member paramMember, long paramLong);
  
  public static native void disableMovingGc(int paramInt);
  
  public static native long getMethodAddress(Member paramMember);
  
  public static native Object getObjectNative(long paramLong1, long paramLong2, Object paramObject);
  
  private static native boolean isGetObjectAvailable();
  
  public static native long malloc(int paramInt);
  
  public static native void memcpy(long paramLong1, long paramLong2, int paramInt);
  
  public static native byte[] memget(long paramLong, int paramInt);
  
  public static native void memput(byte[] paramArrayOfByte, long paramLong);
  
  public static native long mmap(int paramInt);
  
  public static native boolean munmap(long paramLong, int paramInt);
  
  public static native boolean munprotect(long paramLong1, long paramLong2);
  
  public static native void resumeAll(long paramLong);
  
  public static native void startJit(long paramLong);
  
  public static native long stopJit();
  
  public static native long suspendAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     me.weishu.epic.art.EpicNative
 * JD-Core Version:    0.7.0.1
 */