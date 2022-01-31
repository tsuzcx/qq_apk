package com.tencent.qapmsdk.socket.util;

import android.os.Handler;
import android.os.HandlerThread;
import android.support.annotation.RestrictTo;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY})
public class ThreadUtils
{
  private static Handler sHandler;
  
  static
  {
    HandlerThread localHandlerThread = new HandlerThread("TrafficSingle");
    localHandlerThread.start();
    sHandler = new Handler(localHandlerThread.getLooper());
  }
  
  public static void removeSingle(Runnable paramRunnable)
  {
    sHandler.removeCallbacks(paramRunnable);
  }
  
  public static void replaceSingle(Runnable paramRunnable, long paramLong)
  {
    sHandler.removeCallbacks(paramRunnable);
    sHandler.postDelayed(paramRunnable, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qapmsdk.socket.util.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */