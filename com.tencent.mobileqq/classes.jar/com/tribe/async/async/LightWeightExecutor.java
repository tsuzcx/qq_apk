package com.tribe.async.async;

import android.os.Looper;
import android.support.annotation.NonNull;
import com.tribe.async.dispatch.AbsEventBatcher;
import com.tribe.async.log.SLog;
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
  private LightWeightExecutor.RunnableHolder mRunnableHolder;
  
  public LightWeightExecutor(Looper paramLooper, int paramInt)
  {
    super(paramLooper, new RunnableQueue(), paramInt);
  }
  
  private void checkRunning()
  {
    if (this.mMonitorListener == null) {
      return;
    }
    int i = getEnqueueSize();
    if (i > this.mQueueSizeLimit)
    {
      this.mMonitorListener.onQueueExceedLimit("async.boss.LightWeightExecutor", i);
      ??? = new StringBuilder();
      ((StringBuilder)???).append("cur state = ");
      ((StringBuilder)???).append(getCurState());
      SLog.d("async.boss.LightWeightExecutor", ((StringBuilder)???).toString());
      synchronized (this.holderLock)
      {
        if (this.mRunnableHolder != null)
        {
          Runnable localRunnable1 = (Runnable)this.mRunnableHolder.get();
          if (localRunnable1 != null)
          {
            localObject5 = new StringBuilder();
            ((StringBuilder)localObject5).append("cur runnable = ");
            ((StringBuilder)localObject5).append(localRunnable1);
            SLog.d("async.boss.LightWeightExecutor", ((StringBuilder)localObject5).toString());
          }
        }
        dumpAllEvent();
      }
    }
    Object localObject4 = null;
    Object localObject5 = this.holderLock;
    ??? = localObject4;
    try
    {
      if (this.mRunnableHolder != null)
      {
        Runnable localRunnable2 = (Runnable)this.mRunnableHolder.get();
        ??? = localObject4;
        if (localRunnable2 != null)
        {
          ??? = localObject4;
          if (this.mRunnableHolder.getItemRunTimes() > this.mRunTimeLimit)
          {
            ??? = new ArrayList();
            ((List)???).add(localRunnable2);
          }
        }
      }
      if ((??? != null) && (((List)???).size() > 0)) {
        this.mMonitorListener.onWorkerExceedTime("async.boss.LightWeightExecutor", (List)???, 1);
      }
      return;
    }
    finally {}
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
      this.mRunnableHolder = new LightWeightExecutor.RunnableHolder(???);
      ???.run();
      synchronized (this.holderLock)
      {
        this.mRunnableHolder = null;
        return;
      }
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.async.LightWeightExecutor
 * JD-Core Version:    0.7.0.1
 */