package com.tencent.qapmsdk.socket.d;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class e
{
  private static Handler a;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("TrafficSingle");
    localHandlerThread.start();
    a = new Handler(localHandlerThread.getLooper());
  }
  
  public static void a(Runnable paramRunnable, long paramLong)
  {
    a.removeCallbacks(paramRunnable);
    a.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.d.e
 * JD-Core Version:    0.7.0.1
 */