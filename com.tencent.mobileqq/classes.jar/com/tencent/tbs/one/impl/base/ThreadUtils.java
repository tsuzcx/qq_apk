package com.tencent.tbs.one.impl.base;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;

public final class ThreadUtils
{
  private static HandlerThread sCoreThread;
  private static Handler sHandler;
  private static final Object sLock;
  private static boolean sThreadAssertsDisabled;
  
  static
  {
    if (!ThreadUtils.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      sLock = new Object();
      return;
    }
  }
  
  public static void assertOnBackgroundThread()
  {
    if (sThreadAssertsDisabled) {}
    while (($assertionsDisabled) || (!runningOnCoreThread())) {
      return;
    }
    throw new AssertionError("Must be called on a thread other than core thread.");
  }
  
  public static void assertOnCoreThread()
  {
    if (sThreadAssertsDisabled) {}
    while (($assertionsDisabled) || (runningOnCoreThread())) {
      return;
    }
    throw new AssertionError("Must be called on the core thread.");
  }
  
  public static void checkCoreThread()
  {
    if ((!sThreadAssertsDisabled) && (!runningOnCoreThread())) {
      throw new IllegalStateException("Must be called on the core thread.");
    }
  }
  
  public static Handler getCoreThreadHandler()
  {
    synchronized (sLock)
    {
      if (sHandler == null)
      {
        sCoreThread = new HandlerThread("TBSOneThread");
        sCoreThread.start();
        sHandler = new Handler(sCoreThread.getLooper());
      }
      Handler localHandler = sHandler;
      return localHandler;
    }
  }
  
  public static void postOnBackgroundThread(Runnable paramRunnable)
  {
    AsyncTask.THREAD_POOL_EXECUTOR.execute(paramRunnable);
  }
  
  public static <T> FutureTask<T> postOnCoreThread(FutureTask<T> paramFutureTask)
  {
    getCoreThreadHandler().post(paramFutureTask);
    return paramFutureTask;
  }
  
  public static void postOnCoreThread(Runnable paramRunnable)
  {
    getCoreThreadHandler().post(paramRunnable);
  }
  
  @VisibleForTesting
  public static void postOnCoreThreadDelayed(Runnable paramRunnable, long paramLong)
  {
    getCoreThreadHandler().postDelayed(paramRunnable, paramLong);
  }
  
  public static <T> FutureTask<T> runOnCoreThread(Callable<T> paramCallable)
  {
    return runOnCoreThread(new FutureTask(paramCallable));
  }
  
  public static <T> FutureTask<T> runOnCoreThread(FutureTask<T> paramFutureTask)
  {
    if (runningOnCoreThread())
    {
      paramFutureTask.run();
      return paramFutureTask;
    }
    postOnCoreThread(paramFutureTask);
    return paramFutureTask;
  }
  
  public static void runOnCoreThread(Runnable paramRunnable)
  {
    if (runningOnCoreThread())
    {
      paramRunnable.run();
      return;
    }
    getCoreThreadHandler().post(paramRunnable);
  }
  
  public static <T> T runOnCoreThreadBlocking(Callable<T> paramCallable)
  {
    paramCallable = new FutureTask(paramCallable);
    runOnCoreThread(paramCallable);
    try
    {
      paramCallable = paramCallable.get();
      return paramCallable;
    }
    catch (InterruptedException paramCallable)
    {
      throw new RuntimeException("Interrupted waiting for callable", paramCallable);
    }
  }
  
  public static void runOnCoreThreadBlocking(Runnable paramRunnable)
  {
    if (runningOnCoreThread())
    {
      paramRunnable.run();
      return;
    }
    paramRunnable = new FutureTask(paramRunnable, null);
    postOnCoreThread(paramRunnable);
    try
    {
      paramRunnable.get();
      return;
    }
    catch (Exception paramRunnable)
    {
      throw new RuntimeException("Exception occurred while waiting for runnable", paramRunnable);
    }
  }
  
  @VisibleForTesting
  public static <T> T runOnCoreThreadBlockingNoException(Callable<T> paramCallable)
  {
    try
    {
      paramCallable = runOnCoreThreadBlocking(paramCallable);
      return paramCallable;
    }
    catch (ExecutionException paramCallable)
    {
      throw new RuntimeException("Error occurred waiting for callable", paramCallable);
    }
  }
  
  public static boolean runningOnCoreThread()
  {
    return getCoreThreadHandler().getLooper() == Looper.myLooper();
  }
  
  public static void setThreadAssertsDisabledForTesting(boolean paramBoolean)
  {
    sThreadAssertsDisabled = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.base.ThreadUtils
 * JD-Core Version:    0.7.0.1
 */