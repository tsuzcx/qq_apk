package com.tencent.tbs.one.impl.common.statistic;

import com.tencent.tbs.one.impl.base.Logging;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StatisticExecutor
{
  private static final int CORE_POOL_SIZE;
  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final int KEEP_ALIVE_SECONDS = 30;
  private static final int MAXIMUM_POOL_SIZE;
  private static final String TAG = "StatisticExecutor";
  private static final Executor THREAD_POOL_EXECUTOR;
  private static StatisticExecutor instance;
  private static final Object lock = new Object();
  private static volatile Executor sDefaultExecutor;
  private static final BlockingQueue<Runnable> sPoolWorkQueue;
  private static final ThreadFactory sThreadFactory;
  
  static
  {
    CORE_POOL_SIZE = Math.max(2, Math.min(CPU_COUNT - 1, 4));
    MAXIMUM_POOL_SIZE = CPU_COUNT * 2 + 1;
    sPoolWorkQueue = new LinkedBlockingQueue(128);
    sThreadFactory = new StatisticExecutor.1();
    sDefaultExecutor = new StatisticExecutor.2();
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 30L, TimeUnit.SECONDS, sPoolWorkQueue, sThreadFactory);
    localThreadPoolExecutor.allowCoreThreadTimeOut(true);
    THREAD_POOL_EXECUTOR = localThreadPoolExecutor;
  }
  
  public static StatisticExecutor getInstance()
  {
    if (instance == null) {}
    synchronized (lock)
    {
      if (instance == null) {
        instance = new StatisticExecutor();
      }
      return instance;
    }
  }
  
  public void exeParallel(Runnable paramRunnable)
  {
    Logging.d("Statistic executor execute...", new Object[0]);
    sDefaultExecutor.execute(paramRunnable);
  }
  
  public void exeSerial(Runnable paramRunnable)
  {
    Logging.d("Statistic executor execute...", new Object[0]);
    sDefaultExecutor.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.common.statistic.StatisticExecutor
 * JD-Core Version:    0.7.0.1
 */