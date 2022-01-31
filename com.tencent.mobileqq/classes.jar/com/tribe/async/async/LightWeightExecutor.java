package com.tribe.async.async;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tribe.async.dispatch.AbsEventBatcher;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;
import com.tribe.async.log.SLog;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class LightWeightExecutor
  extends AbsEventBatcher<Runnable>
  implements Executor
{
  private static final int QUEUE_SIZE_LIMIT = 200;
  private static final long RUN_TIME_LIMIT = 120000L;
  private static final String TAG = "async.boss.LightWeightExecutor";
  private final byte[] holderLock = new byte[0];
  private MonitorThreadPoolExecutor.ThreadPoolMonitorListener mMonitorListener;
  private int mQueueSizeLimit = 200;
  private long mRunTimeLimit = 120000L;
  private RunnableHolder mRunnableHolder;
  
  public LightWeightExecutor(int paramInt)
  {
    super(Dispatchers.get().getDefaultLooper(), new RunnableQueue(), paramInt);
  }
  
  private void checkRunning()
  {
    if (this.mMonitorListener == null) {}
    for (;;)
    {
      return;
      int i = getEnqueueSize();
      if (i > this.mQueueSizeLimit)
      {
        this.mMonitorListener.onQueueExceedLimit("async.boss.LightWeightExecutor", i);
        SLog.d("async.boss.LightWeightExecutor", "cur state = " + getCurState());
      }
      Runnable localRunnable1;
      byte[] arrayOfByte;
      synchronized (this.holderLock)
      {
        if (this.mRunnableHolder != null)
        {
          localRunnable1 = (Runnable)this.mRunnableHolder.get();
          if (localRunnable1 != null) {
            SLog.d("async.boss.LightWeightExecutor", "cur runnable = " + localRunnable1);
          }
        }
        dumpAllEvent();
        localRunnable1 = null;
        arrayOfByte = this.holderLock;
        ??? = localRunnable1;
      }
      Runnable localRunnable2;
      try
      {
        if (this.mRunnableHolder != null)
        {
          localRunnable2 = (Runnable)this.mRunnableHolder.get();
          ??? = localRunnable1;
          if (localRunnable2 != null)
          {
            ??? = localRunnable1;
            if (this.mRunnableHolder.getItemRunTimes() > this.mRunTimeLimit) {
              ??? = new ArrayList();
            }
          }
        }
      }
      finally {}
      try
      {
        ((List)???).add(localRunnable2);
        if ((??? != null) && (((List)???).size() > 0))
        {
          this.mMonitorListener.onWorkerExceedTime("async.boss.LightWeightExecutor", (List)???, 1);
          return;
        }
      }
      finally {}
    }
    localObject4 = finally;
    throw localObject4;
    throw localObject2;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    enqueue(paramRunnable);
    checkRunning();
  }
  
  protected void handleItem(Runnable arg1)
  {
    synchronized (this.holderLock)
    {
      this.mRunnableHolder = new RunnableHolder(???);
      ???.run();
    }
    synchronized (this.holderLock)
    {
      this.mRunnableHolder = null;
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public void setMonitorListener(MonitorThreadPoolExecutor.ThreadPoolMonitorListener paramThreadPoolMonitorListener)
  {
    this.mMonitorListener = paramThreadPoolMonitorListener;
  }
  
  public void setQueueSizeLimit(int paramInt)
  {
    this.mQueueSizeLimit = paramInt;
  }
  
  public void setRunTimeLimit(long paramLong)
  {
    this.mRunTimeLimit = paramLong;
  }
  
  private static class RunnableHolder
    extends WeakReference<Runnable>
  {
    private long mRunStartTime = SystemClock.elapsedRealtime();
    
    public RunnableHolder(Runnable paramRunnable)
    {
      super();
    }
    
    public RunnableHolder(Runnable paramRunnable, ReferenceQueue<? super Runnable> paramReferenceQueue)
    {
      super(paramReferenceQueue);
    }
    
    public long getItemRunTimes()
    {
      return SystemClock.elapsedRealtime() - this.mRunStartTime;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tribe.async.async.LightWeightExecutor
 * JD-Core Version:    0.7.0.1
 */