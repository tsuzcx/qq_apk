package com.tencent.upload.utils.pool;

import android.util.Log;

class ThreadPool$Worker<T>
  implements Future<T>, ThreadPool.JobContext, Runnable
{
  private static final String TAG = "Worker";
  private ThreadPool.CancelListener mCancelListener;
  private volatile boolean mIsCancelled;
  private boolean mIsDone;
  private ThreadPool.Job<T> mJob;
  private FutureListener<T> mListener;
  private T mResult;
  
  public ThreadPool$Worker(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    this.mJob = paramFutureListener;
    Object localObject;
    this.mListener = localObject;
  }
  
  public void cancel()
  {
    try
    {
      boolean bool = this.mIsCancelled;
      if (bool) {
        return;
      }
      this.mIsCancelled = true;
      if (this.mCancelListener != null) {
        this.mCancelListener.onCancel();
      }
      return;
    }
    finally {}
  }
  
  public T get()
  {
    try
    {
      for (;;)
      {
        boolean bool = this.mIsDone;
        if (bool) {
          break;
        }
        try
        {
          wait();
        }
        catch (Exception localException)
        {
          Log.w("Worker", "ignore exception", localException);
        }
      }
      Object localObject1 = this.mResult;
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public boolean isCancelled()
  {
    return this.mIsCancelled;
  }
  
  public boolean isDone()
  {
    try
    {
      boolean bool = this.mIsDone;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void run()
  {
    FutureListener localFutureListener;
    if (setMode(1)) {
      try
      {
        Object localObject1 = this.mJob.run(this);
      }
      catch (Throwable localThrowable)
      {
        Log.w("Worker", "Exception in running a job", localThrowable);
      }
    } else {
      localFutureListener = null;
    }
    try
    {
      setMode(0);
      this.mResult = localFutureListener;
      this.mIsDone = true;
      notifyAll();
      localFutureListener = this.mListener;
      if (localFutureListener != null) {
        localFutureListener.onFutureDone(this);
      }
      return;
    }
    finally {}
  }
  
  public void setCancelListener(ThreadPool.CancelListener paramCancelListener)
  {
    try
    {
      this.mCancelListener = paramCancelListener;
      if ((this.mIsCancelled) && (this.mCancelListener != null)) {
        this.mCancelListener.onCancel();
      }
      return;
    }
    finally
    {
      paramCancelListener = finally;
      throw paramCancelListener;
    }
  }
  
  public boolean setMode(int paramInt)
  {
    return isCancelled() ^ true;
  }
  
  public void waitDone()
  {
    get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPool.Worker
 * JD-Core Version:    0.7.0.1
 */