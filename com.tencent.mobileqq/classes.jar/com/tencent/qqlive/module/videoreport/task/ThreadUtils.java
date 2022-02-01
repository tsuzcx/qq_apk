package com.tencent.qqlive.module.videoreport.task;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadUtils
{
  private static final Executor EXECUTOR = Executors.newFixedThreadPool(2, new ThreadUtils.1());
  private static final Handler HANDLER = new Handler(Looper.getMainLooper());
  private static final AtomicInteger NUMBER = new AtomicInteger(1);
  private static IThreadTaskInterceptor sTaskInterceptor = null;
  
  public static void cancelUiThreadRunnable(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      HANDLER.removeCallbacks(paramRunnable);
    }
  }
  
  public static void execTask(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      EXECUTOR.execute(paramRunnable);
    }
  }
  
  public static void execTask(Runnable paramRunnable, boolean paramBoolean)
  {
    if (paramRunnable == null) {
      return;
    }
    if (paramBoolean)
    {
      paramRunnable.run();
      return;
    }
    execTask(paramRunnable);
  }
  
  public static Handler getMainHandler()
  {
    return HANDLER;
  }
  
  public static void injectTaskInterceptor(IThreadTaskInterceptor paramIThreadTaskInterceptor)
  {
    sTaskInterceptor = paramIThreadTaskInterceptor;
  }
  
  public static void removeOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      HANDLER.removeCallbacks(paramRunnable);
    }
  }
  
  public static void runOnUiThread(Runnable paramRunnable)
  {
    if (paramRunnable == null) {}
    while (shouldIntercept(paramRunnable)) {
      return;
    }
    HANDLER.post(paramRunnable);
  }
  
  public static void runOnUiThreadDelay(Runnable paramRunnable, long paramLong)
  {
    if (paramRunnable != null) {
      HANDLER.postDelayed(paramRunnable, paramLong);
    }
  }
  
  private static boolean shouldIntercept(Runnable paramRunnable)
  {
    return (sTaskInterceptor != null) && (sTaskInterceptor.shouldInterceptTask(paramRunnable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.task.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */