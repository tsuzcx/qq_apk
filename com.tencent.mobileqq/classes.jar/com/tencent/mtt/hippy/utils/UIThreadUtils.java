package com.tencent.mtt.hippy.utils;

import android.os.Handler;
import android.os.Looper;

public class UIThreadUtils
{
  private static Handler sMainHandler = new Handler(Looper.getMainLooper());
  
  public static void assertOnUiThread()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
      return;
    }
    throw new RuntimeException("must run on ui thread!");
  }
  
  public static boolean isOnUiThread()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    sMainHandler.post(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.utils.UIThreadUtils
 * JD-Core Version:    0.7.0.1
 */