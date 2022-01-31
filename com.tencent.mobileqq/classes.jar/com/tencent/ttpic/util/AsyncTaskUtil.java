package com.tencent.ttpic.util;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AsyncTaskUtil
{
  private static final int CORE_POOL_SIZE = CPU_COUNT * 2 + 1;
  private static final int CPU_COUNT;
  public static ThreadPoolExecutor DUAL_THREAD_EXECUTOR;
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 10 + 1;
  private static String TAG = AsyncTaskUtil.class.getSimpleName();
  private static final ThreadFactory sThreadFactory = new ThreadFactory()
  {
    private final AtomicInteger mCount = new AtomicInteger(1);
    
    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      return new Thread(paramAnonymousRunnable, "AsyncTask #" + this.mCount.getAndIncrement());
    }
  };
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
  }
  
  public static Executor getDualThreadExecutor()
  {
    try
    {
      if ((DUAL_THREAD_EXECUTOR == null) || (DUAL_THREAD_EXECUTOR.isShutdown()))
      {
        Log.v(TAG, "getDualThreadExecutor(), executor ");
        DUAL_THREAD_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), sThreadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
      }
      ThreadPoolExecutor localThreadPoolExecutor = DUAL_THREAD_EXECUTOR;
      return localThreadPoolExecutor;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.util.AsyncTaskUtil
 * JD-Core Version:    0.7.0.1
 */