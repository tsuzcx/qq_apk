package com.tencent.rainbow.common;

import android.util.Log;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskThreadPool
{
  private static final int CORE_POOL_SIZE = 5;
  private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
  private static final Long KEEP_ALIVE_TIME = Long.valueOf(1L);
  private static final int MAX_POOL_SIZE = Math.max(5, CPU_COUNT * 2 + 1);
  private static final int QUEUE_CAPACITY = 100;
  public static final String TAG = "TaskThreadPool";
  private static volatile TaskThreadPool sInstance;
  private ThreadPoolExecutor mThreadPool;
  
  public static TaskThreadPool getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new TaskThreadPool();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private void initThreadPool()
  {
    if (this.mThreadPool == null) {
      this.mThreadPool = new ThreadPoolExecutor(5, MAX_POOL_SIZE, KEEP_ALIVE_TIME.longValue(), TimeUnit.SECONDS, new LinkedBlockingDeque(100), new TaskThreadPool.1(this));
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    if (this.mThreadPool == null)
    {
      Log.d("TaskThreadPool", "execute error, thread pool did not init");
      initThreadPool();
    }
    if (paramRunnable == null)
    {
      Log.d("TaskThreadPool", "execute error, runnable is null");
      return;
    }
    this.mThreadPool.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rainbow.common.TaskThreadPool
 * JD-Core Version:    0.7.0.1
 */