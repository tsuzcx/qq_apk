package com.tencent.qplus.swingworker;

import android.os.Handler;
import android.os.Looper;

public class WorkerUtilities
{
  private static Handler handler = new Handler();
  
  public static void initMainLooper() {}
  
  public static void invokeInLooper(Runnable paramRunnable)
  {
    handler.post(paramRunnable);
  }
  
  public static void invokeInLooper(Runnable paramRunnable, long paramLong)
  {
    handler.postDelayed(paramRunnable, paramLong);
  }
  
  public static boolean isUIThread()
  {
    return Thread.currentThread() == handler.getLooper().getThread();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qplus.swingworker.WorkerUtilities
 * JD-Core Version:    0.7.0.1
 */