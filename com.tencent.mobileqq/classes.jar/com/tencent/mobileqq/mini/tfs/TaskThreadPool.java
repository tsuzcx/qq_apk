package com.tencent.mobileqq.mini.tfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TaskThreadPool
{
  private static final int PERIOD_TASK_QOS = 100;
  private static final int SIZE_CORE_POOL = 3;
  private static final int SIZE_MAX_POOL = 4;
  private static final int SIZE_WORK_QUEUE = 100;
  private static final int TIME_KEEP_ALIVE = 5000;
  private final Runnable mAccessBufferThread = new TaskThreadPool.2(this);
  private final RejectedExecutionHandler mHandler = new TaskThreadPool.1(this);
  protected final ScheduledFuture<?> mTaskHandler = this.scheduler.scheduleAtFixedRate(this.mAccessBufferThread, 0L, 100L, TimeUnit.MILLISECONDS);
  private final Queue<Runnable> mTaskQueue = new LinkedList();
  private final ThreadPoolExecutor mThreadPool;
  private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
  
  public TaskThreadPool(String paramString, int paramInt1, int paramInt2)
  {
    this.mThreadPool = new ThreadPoolExecutor(paramInt1, paramInt2, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue(100), new TaskThreadPool.CustomThreadFactory(paramString), this.mHandler);
  }
  
  private boolean hasMoreAcquire()
  {
    return !this.mTaskQueue.isEmpty();
  }
  
  public void addExecuteTask(Runnable paramRunnable)
  {
    if (paramRunnable != null) {
      this.mThreadPool.execute(paramRunnable);
    }
  }
  
  protected boolean isTaskEnd()
  {
    return this.mThreadPool.getActiveCount() == 0;
  }
  
  public void perpare()
  {
    if ((this.mThreadPool.isShutdown()) && (!this.mThreadPool.prestartCoreThread())) {
      this.mThreadPool.prestartAllCoreThreads();
    }
  }
  
  public void shutdown()
  {
    this.mTaskQueue.clear();
    this.mThreadPool.shutdown();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.TaskThreadPool
 * JD-Core Version:    0.7.0.1
 */