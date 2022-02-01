package com.tribe.async.async;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.log.SLog;
import com.tribe.async.utils.AssertUtils;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Worker<Progress, Result>
  extends FutureTask<Result>
  implements Dispatcher.Dispatchable
{
  private static final String TAG = "async.boss.Worker";
  private Exception mException;
  private CopyOnWriteArrayList<FutureListener<Progress, Result>> mFutureListeners = new CopyOnWriteArrayList();
  private final Job<?, Progress, Result> mJob;
  private final DefaultJobContext<Progress> mJobContext = new DefaultJobContext(this);
  private Result mResult;
  
  public Worker(Job<?, Progress, Result> paramJob)
  {
    super(paramJob);
    this.mJob = paramJob;
    this.mJob.setJobContext(this.mJobContext);
  }
  
  private void notifyCanceled()
  {
    Iterator localIterator = this.mFutureListeners.iterator();
    while (localIterator.hasNext()) {
      ((FutureListener)localIterator.next()).onFutureCanceled();
    }
    this.mJobContext.notifyCancelListener();
  }
  
  private void notifyDone(Result paramResult)
  {
    Iterator localIterator = this.mFutureListeners.iterator();
    while (localIterator.hasNext()) {
      ((FutureListener)localIterator.next()).onFutureDone(paramResult);
    }
    this.mJob.onResult(this.mResult);
  }
  
  public void addFutureListener(FutureListener<Progress, Result> paramFutureListener)
  {
    AssertUtils.checkNotNull(paramFutureListener);
    this.mFutureListeners.add(paramFutureListener);
  }
  
  public boolean cancel(boolean paramBoolean)
  {
    this.mJobContext.setJobCancelled(true);
    this.mJob.onCancelled();
    super.cancel(paramBoolean);
    return true;
  }
  
  protected void done()
  {
    if (isCancelled()) {
      notifyCanceled();
    }
    for (;;)
    {
      this.mJobContext.setCancelListener(null);
      return;
      try
      {
        this.mResult = get();
        notifyDone(this.mResult);
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          this.mException = localInterruptedException;
          SLog.e("async.boss.Worker", "InterruptedException", localInterruptedException);
        }
      }
      catch (ExecutionException localExecutionException)
      {
        this.mException = localExecutionException;
        throw new RuntimeException("ExecutionException", localExecutionException);
      }
    }
  }
  
  @Nullable
  public Exception getException()
  {
    return this.mException;
  }
  
  @NonNull
  public Job getJob()
  {
    return this.mJob;
  }
  
  int getJobType()
  {
    return this.mJob.getJobType();
  }
  
  @Nullable
  public Result getResult()
  {
    return this.mResult;
  }
  
  void notifyProgress(Progress paramProgress)
  {
    Iterator localIterator = this.mFutureListeners.iterator();
    while (localIterator.hasNext()) {
      ((FutureListener)localIterator.next()).onFutureProgress(paramProgress);
    }
  }
  
  public void removeFutureListener(FutureListener<Progress, Result> paramFutureListener)
  {
    AssertUtils.checkNotNull(paramFutureListener);
    this.mFutureListeners.remove(paramFutureListener);
  }
  
  public String toString()
  {
    return "Worker:" + this.mJob.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tribe.async.async.Worker
 * JD-Core Version:    0.7.0.1
 */