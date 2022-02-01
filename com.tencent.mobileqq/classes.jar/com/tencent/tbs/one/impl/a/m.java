package com.tencent.tbs.one.impl.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.support.annotation.VisibleForTesting;
import java.util.concurrent.Executor;

public final class m
{
  private static final Object b = new Object();
  private static HandlerThread c;
  private static Handler d;
  
  public static Handler a()
  {
    synchronized (b)
    {
      if (d == null)
      {
        localObject2 = new HandlerThread("TBSOneThread");
        c = (HandlerThread)localObject2;
        ((HandlerThread)localObject2).start();
        d = new Handler(c.getLooper());
      }
      Object localObject2 = d;
      return localObject2;
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    if (b())
    {
      paramRunnable.run();
      return;
    }
    a().post(paramRunnable);
  }
  
  public static void b(Runnable paramRunnable)
  {
    a().post(paramRunnable);
  }
  
  public static boolean b()
  {
    return a().getLooper() == Looper.myLooper();
  }
  
  @VisibleForTesting
  public static void c(Runnable paramRunnable)
  {
    a().postDelayed(paramRunnable, 2000L);
  }
  
  public static void d(Runnable paramRunnable)
  {
    AsyncTask.THREAD_POOL_EXECUTOR.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.a.m
 * JD-Core Version:    0.7.0.1
 */