package com.tribe.async.async;

import com.tribe.async.log.SLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MonitorThreadPoolExecutor
  extends ThreadPoolExecutor
{
  private static final int QUEUE_SIZE_LIMIT = 200;
  private static final long RUN_TIME_LIMIT = 120000L;
  private static final String TAG = "async.boss.MonitorThreadPoolExecutor";
  private int mCore;
  private MonitorThreadPoolExecutor.ThreadPoolMonitorListener mMonitorListener;
  private String mName = "async.boss.MonitorThreadPoolExecutor";
  private int mQueueSizeLimit = 200;
  private long mRunTimeLimit = 120000L;
  private BlockingQueue<Runnable> mWorkerQueue;
  private final List<MonitorThreadPoolExecutor.WorkerHolder> mWorkingRunnables = new LinkedList();
  
  public MonitorThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue);
    this.mWorkerQueue = paramBlockingQueue;
    this.mCore = paramInt1;
  }
  
  public MonitorThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramRejectedExecutionHandler);
    this.mWorkerQueue = paramBlockingQueue;
    this.mCore = paramInt1;
  }
  
  public MonitorThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory);
    this.mWorkerQueue = paramBlockingQueue;
    this.mCore = paramInt1;
  }
  
  public MonitorThreadPoolExecutor(int paramInt1, int paramInt2, long paramLong, TimeUnit paramTimeUnit, BlockingQueue<Runnable> paramBlockingQueue, ThreadFactory paramThreadFactory, RejectedExecutionHandler paramRejectedExecutionHandler)
  {
    super(paramInt1, paramInt2, paramLong, paramTimeUnit, paramBlockingQueue, paramThreadFactory, paramRejectedExecutionHandler);
    this.mWorkerQueue = paramBlockingQueue;
    this.mCore = paramInt1;
  }
  
  private void checkRunning()
  {
    if (this.mMonitorListener == null) {
      return;
    }
    Object localObject3 = null;
    Object localObject4;
    Object localObject2;
    for (Runnable localRunnable = null;; localObject2 = localObject4) {
      synchronized (this.mWorkingRunnables)
      {
        if (this.mWorkingRunnables.size() > 0)
        {
          Iterator localIterator = this.mWorkingRunnables.iterator();
          localObject3 = localRunnable;
          if (localIterator.hasNext())
          {
            MonitorThreadPoolExecutor.WorkerHolder localWorkerHolder = (MonitorThreadPoolExecutor.WorkerHolder)localIterator.next();
            localObject4 = localRunnable;
            if (localWorkerHolder.getExecuteTime() <= this.mRunTimeLimit) {
              continue;
            }
            localObject3 = localRunnable;
            if (localRunnable == null) {
              localObject3 = new ArrayList(this.mWorkingRunnables.size());
            }
            localRunnable = (Runnable)localWorkerHolder.get();
            localObject4 = localObject3;
            if (localRunnable == null) {
              continue;
            }
            ((List)localObject3).add(localRunnable);
            localObject4 = localObject3;
            continue;
          }
        }
        int i = this.mWorkerQueue.size();
        if ((localObject3 != null) && (((List)localObject3).size() > 0)) {
          this.mMonitorListener.onWorkerExceedTime(this.mName, (List)localObject3, i);
        }
        if (i <= this.mQueueSizeLimit) {
          break;
        }
        this.mMonitorListener.onQueueExceedLimit(this.mName, i);
        return;
      }
    }
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable arg2)
  {
    synchronized (this.mWorkingRunnables)
    {
      this.mWorkingRunnables.remove(new MonitorThreadPoolExecutor.WorkerHolder(paramRunnable));
      return;
    }
  }
  
  protected void beforeExecute(Thread arg1, Runnable paramRunnable)
  {
    synchronized (this.mWorkingRunnables)
    {
      this.mWorkingRunnables.add(new MonitorThreadPoolExecutor.WorkerHolder(paramRunnable));
      return;
    }
  }
  
  public void execute(Runnable paramRunnable)
  {
    super.execute(paramRunnable);
    checkRunning();
  }
  
  public void setCore(int paramInt)
  {
    this.mCore = paramInt;
  }
  
  public void setMonitorListener(MonitorThreadPoolExecutor.ThreadPoolMonitorListener paramThreadPoolMonitorListener)
  {
    this.mMonitorListener = paramThreadPoolMonitorListener;
  }
  
  public void setName(String paramString)
  {
    this.mName = paramString;
  }
  
  public void setQueueSizeLimit(int paramInt)
  {
    this.mQueueSizeLimit = paramInt;
  }
  
  public void setRunTimeLimit(long paramLong)
  {
    this.mRunTimeLimit = paramLong;
  }
  
  protected void terminated()
  {
    SLog.e("async.boss.MonitorThreadPoolExecutor", this.mName + " is terminated!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tribe.async.async.MonitorThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */