package com.tencent.qqmini.sdk.launcher.core.utils;

import android.os.Handler;
import android.os.Looper;

public class AppBrandTask
{
  private static Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  
  public static void runTaskOnUiThread(Runnable paramRunnable)
  {
    if (Looper.getMainLooper().getThread().getId() == Thread.currentThread().getId())
    {
      paramRunnable.run();
      return;
    }
    mMainThreadHandler.post(paramRunnable);
  }
  
  public static void runTaskOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    mMainThreadHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void clearTask()
  {
    mMainThreadHandler.removeCallbacksAndMessages(null);
  }
  
  public void clearTask(Runnable paramRunnable)
  {
    mMainThreadHandler.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask
 * JD-Core Version:    0.7.0.1
 */