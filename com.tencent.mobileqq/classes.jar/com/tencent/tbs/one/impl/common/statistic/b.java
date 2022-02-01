package com.tencent.tbs.one.impl.common.statistic;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class b
{
  private static final int a = Runtime.getRuntime().availableProcessors();
  private static final int b = Math.max(2, Math.min(a - 1, 4));
  private static final int c = a * 2 + 1;
  private static final BlockingQueue<Runnable> d = new LinkedBlockingQueue(128);
  private static final Executor e;
  private static final ThreadFactory f = new b.1();
  private static final Object g = new Object();
  private static volatile Executor h = new b.2();
  private static b i;
  
  static
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(b, c, 30L, TimeUnit.SECONDS, d, f);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    e = localThreadPoolExecutor;
  }
  
  public static b a()
  {
    if (i == null) {}
    synchronized (g)
    {
      if (i == null) {
        i = new b();
      }
      return i;
    }
  }
  
  public static void a(Runnable paramRunnable)
  {
    h.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.b
 * JD-Core Version:    0.7.0.1
 */