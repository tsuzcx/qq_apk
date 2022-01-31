package com.tencent.ttpic.thread;

import android.util.Log;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy;
import java.util.concurrent.TimeUnit;

public class VideoThreadPool
{
  private static final int CORE_POOL_SIZE = CPU_COUNT * 2 + 1;
  private static final int CPU_COUNT;
  private static final int MAXIMUM_POOL_SIZE = CPU_COUNT * 10 + 1;
  private static String TAG = VideoThreadPool.class.getSimpleName();
  private final ThreadPoolExecutor DUAL_THREAD_EXECUTOR;
  private final ThreadFactory sThreadFactory = new VideoThreadFactory(10);
  
  static
  {
    CPU_COUNT = Runtime.getRuntime().availableProcessors();
  }
  
  private VideoThreadPool()
  {
    Log.v(TAG, "getDualThreadExecutor(), executor ");
    this.DUAL_THREAD_EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAXIMUM_POOL_SIZE, 100L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), this.sThreadFactory, new ThreadPoolExecutor.DiscardOldestPolicy());
  }
  
  public static VideoThreadPool getInstance()
  {
    return VideoThreadPoolHolder.INSTANCE;
  }
  
  public Executor getDualThreadExecutor()
  {
    try
    {
      ThreadPoolExecutor localThreadPoolExecutor = this.DUAL_THREAD_EXECUTOR;
      return localThreadPoolExecutor;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void submit(Runnable paramRunnable)
  {
    this.DUAL_THREAD_EXECUTOR.execute(paramRunnable);
  }
  
  private static class VideoThreadPoolHolder
  {
    private static final VideoThreadPool INSTANCE = new VideoThreadPool(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ttpic.thread.VideoThreadPool
 * JD-Core Version:    0.7.0.1
 */