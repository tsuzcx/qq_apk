package com.tencent.tkd.comment.util;

import android.os.Handler;
import android.os.Looper;

public class UiThreadUtil
{
  private static Handler sHandler = new Handler(Looper.getMainLooper());
  
  public static void forcePost(Runnable paramRunnable)
  {
    post(paramRunnable, 0);
  }
  
  public static boolean isUIThread()
  {
    return Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId();
  }
  
  public static void post(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    if (isUIThread())
    {
      paramRunnable.run();
      return;
    }
    sHandler.post(paramRunnable);
  }
  
  public static void post(Runnable paramRunnable, int paramInt)
  {
    if (paramRunnable == null) {
      return;
    }
    sHandler.postDelayed(paramRunnable, paramInt);
  }
  
  public static void remove(Runnable paramRunnable)
  {
    if (paramRunnable == null) {
      return;
    }
    sHandler.removeCallbacks(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.comment.util.UiThreadUtil
 * JD-Core Version:    0.7.0.1
 */