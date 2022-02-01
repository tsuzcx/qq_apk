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
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 48	com/tencent/upload/utils/pool/ThreadPool$Worker:mIsCancelled	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 48	com/tencent/upload/utils/pool/ThreadPool$Worker:mIsCancelled	Z
    //   19: aload_0
    //   20: getfield 50	com/tencent/upload/utils/pool/ThreadPool$Worker:mCancelListener	Lcom/tencent/upload/utils/pool/ThreadPool$CancelListener;
    //   23: ifnull -12 -> 11
    //   26: aload_0
    //   27: getfield 50	com/tencent/upload/utils/pool/ThreadPool$Worker:mCancelListener	Lcom/tencent/upload/utils/pool/ThreadPool$CancelListener;
    //   30: invokeinterface 55 1 0
    //   35: goto -24 -> 11
    //   38: astore_2
    //   39: aload_0
    //   40: monitorexit
    //   41: aload_2
    //   42: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	43	0	this	Worker
    //   6	2	1	bool	boolean
    //   38	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	38	finally
    //   14	35	38	finally
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
      localObject2 = this.mResult;
    }
    finally {}
    Object localObject2;
    return localObject2;
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
    Object localObject4 = null;
    Object localObject1 = localObject4;
    if (setMode(1)) {}
    try
    {
      localObject1 = this.mJob.run(this);
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          setMode(0);
          this.mResult = localObject1;
          this.mIsDone = true;
          notifyAll();
          if (this.mListener != null) {
            this.mListener.onFutureDone(this);
          }
          return;
        }
        finally {}
        localThrowable = localThrowable;
        Log.w("Worker", "Exception in running a job", localThrowable);
        Object localObject2 = localObject4;
      }
    }
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
    return !isCancelled();
  }
  
  public void waitDone()
  {
    get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.upload.utils.pool.ThreadPool.Worker
 * JD-Core Version:    0.7.0.1
 */