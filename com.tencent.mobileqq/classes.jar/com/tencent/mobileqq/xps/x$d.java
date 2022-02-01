package com.tencent.mobileqq.xps;

import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import java.util.concurrent.CountDownLatch;

final class x$d
{
  static
  {
    String str = new StringBuilder("spx").reverse().toString();
    if (Process.myPid() == Process.myTid())
    {
      System.loadLibrary(str);
      return;
    }
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    new Handler(Looper.getMainLooper()).postAtFrontOfQueue(new x.d.1(str, localCountDownLatch));
    try
    {
      localCountDownLatch.await();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  static native byte[] aa(int paramInt1, int paramInt2);
  
  static native int ba(String paramString);
  
  static native int bb(String paramString);
  
  static native void bc(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.xps.x.d
 * JD-Core Version:    0.7.0.1
 */