package com.tribe.async.async;

import android.os.SystemClock;
import com.tribe.async.log.SLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
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
  private ThreadPoolMonitorListener mMonitorListener;
  private String mName = "async.boss.MonitorThreadPoolExecutor";
  private int mQueueSizeLimit = 200;
  private long mRunTimeLimit = 120000L;
  private BlockingQueue<Runnable> mWorkerQueue;
  private final List<WorkerHolder> mWorkingRunnables = new LinkedList();
  
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
    ArrayList localArrayList = null;
    label202:
    label205:
    label207:
    label212:
    for (;;)
    {
      synchronized (this.mWorkingRunnables)
      {
        Iterator localIterator;
        if (this.mWorkingRunnables.size() > 0)
        {
          localIterator = this.mWorkingRunnables.iterator();
          localArrayList = null;
        }
        try
        {
          if (!localIterator.hasNext()) {
            break label212;
          }
          localObject4 = (WorkerHolder)localIterator.next();
          if (((WorkerHolder)localObject4).getExecuteTime() <= this.mRunTimeLimit) {
            break label205;
          }
          if (localArrayList != null) {
            break label202;
          }
          localArrayList = new ArrayList(this.mWorkingRunnables.size());
        }
        finally
        {
          Runnable localRunnable;
          int i;
          continue;
          continue;
          Object localObject4 = localObject2;
          Object localObject3 = localObject4;
        }
        localRunnable = (Runnable)((WorkerHolder)localObject4).get();
        localObject4 = localArrayList;
        if (localRunnable != null)
        {
          localArrayList.add(localRunnable);
          localObject4 = localArrayList;
          break label207;
          i = this.mWorkerQueue.size();
          if ((localArrayList != null) && (localArrayList.size() > 0)) {
            this.mMonitorListener.onWorkerExceedTime(this.mName, localArrayList, i);
          }
          if (i <= this.mQueueSizeLimit) {
            break;
          }
          this.mMonitorListener.onQueueExceedLimit(this.mName, i);
          return;
        }
      }
    }
  }
  
  protected void afterExecute(Runnable paramRunnable, Throwable arg2)
  {
    synchronized (this.mWorkingRunnables)
    {
      this.mWorkingRunnables.remove(new WorkerHolder(paramRunnable));
      return;
    }
  }
  
  protected void beforeExecute(Thread arg1, Runnable paramRunnable)
  {
    synchronized (this.mWorkingRunnables)
    {
      this.mWorkingRunnables.add(new WorkerHolder(paramRunnable));
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
  
  public void setMonitorListener(ThreadPoolMonitorListener paramThreadPoolMonitorListener)
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
  
  public static abstract interface ThreadPoolMonitorListener
  {
    public abstract void onQueueExceedLimit(String paramString, int paramInt);
    
    public abstract void onWorkerExceedTime(String paramString, List<Runnable> paramList, int paramInt);
  }
  
  private static class WorkerHolder
    extends WeakReference<Runnable>
  {
    private long mExecuteStartTime = SystemClock.elapsedRealtime();
    
    public WorkerHolder(Runnable paramRunnable)
    {
      super();
    }
    
    public WorkerHolder(Runnable paramRunnable, ReferenceQueue<? super Runnable> paramReferenceQueue)
    {
      super(paramReferenceQueue);
    }
    
    public static boolean objEquals(Object paramObject1, Object paramObject2)
    {
      if (paramObject1 == null) {
        return paramObject2 == null;
      }
      return paramObject1.equals(paramObject2);
    }
    
    public boolean equals(Object paramObject)
    {
      if ((paramObject instanceof WorkerHolder)) {
        return objEquals(((WorkerHolder)paramObject).get(), get());
      }
      if ((paramObject instanceof Runnable)) {
        return objEquals(paramObject, get());
      }
      return false;
    }
    
    public long getExecuteTime()
    {
      return SystemClock.elapsedRealtime() - this.mExecuteStartTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.MonitorThreadPoolExecutor
 * JD-Core Version:    0.7.0.1
 */