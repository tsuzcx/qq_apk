package com.tencent.weiyun.utils.thread;

import android.util.Log;

class ThreadPool$Worker<T>
  implements Future<T>, ThreadPool.JobContext, Comparable<Worker>, Runnable
{
  private static final String TAG = "Worker";
  private ThreadPool.CancelListener mCancelListener;
  private volatile boolean mIsCancelled;
  private boolean mIsDone;
  private final ThreadPool.Job<T> mJob;
  private final FutureListener<T> mListener;
  private int mMode;
  private T mResult;
  private ThreadPool.ResourceCounter mWaitOnResource;
  
  public ThreadPool$Worker(ThreadPool.Job<T> paramJob, FutureListener<T> paramFutureListener)
  {
    this.mJob = paramFutureListener;
    Object localObject;
    this.mListener = localObject;
  }
  
  /* Error */
  private boolean acquireResource(ThreadPool.ResourceCounter paramResourceCounter)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mIsCancelled	Z
    //   6: ifeq +12 -> 18
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 59	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mWaitOnResource	Lcom/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter;
    //   14: aload_0
    //   15: monitorexit
    //   16: iconst_0
    //   17: ireturn
    //   18: aload_0
    //   19: aload_1
    //   20: putfield 59	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mWaitOnResource	Lcom/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter;
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: monitorenter
    //   27: aload_1
    //   28: getfield 64	com/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter:value	I
    //   31: ifle +31 -> 62
    //   34: aload_1
    //   35: aload_1
    //   36: getfield 64	com/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter:value	I
    //   39: iconst_1
    //   40: isub
    //   41: putfield 64	com/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter:value	I
    //   44: aload_1
    //   45: monitorexit
    //   46: aload_0
    //   47: monitorenter
    //   48: aload_0
    //   49: aconst_null
    //   50: putfield 59	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mWaitOnResource	Lcom/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter;
    //   53: aload_0
    //   54: monitorexit
    //   55: iconst_1
    //   56: ireturn
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_1
    //   63: invokevirtual 67	java/lang/Object:wait	()V
    //   66: aload_1
    //   67: monitorexit
    //   68: goto -68 -> 0
    //   71: astore_2
    //   72: aload_1
    //   73: monitorexit
    //   74: aload_2
    //   75: athrow
    //   76: astore_1
    //   77: aload_0
    //   78: monitorexit
    //   79: goto +5 -> 84
    //   82: aload_1
    //   83: athrow
    //   84: goto -2 -> 82
    //   87: astore_2
    //   88: goto -22 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	91	0	this	Worker
    //   0	91	1	paramResourceCounter	ThreadPool.ResourceCounter
    //   71	4	2	localObject	Object
    //   87	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   48	55	57	finally
    //   58	60	57	finally
    //   27	46	71	finally
    //   62	66	71	finally
    //   66	68	71	finally
    //   72	74	71	finally
    //   2	16	76	finally
    //   18	25	76	finally
    //   77	79	76	finally
    //   62	66	87	java/lang/InterruptedException
  }
  
  private ThreadPool.ResourceCounter modeToCounter(int paramInt)
  {
    if (paramInt == 1) {
      return this.this$0.mCpuCounter;
    }
    if (paramInt == 2) {
      return this.this$0.mNetworkCounter;
    }
    return null;
  }
  
  private void releaseResource(ThreadPool.ResourceCounter paramResourceCounter)
  {
    try
    {
      paramResourceCounter.value += 1;
      paramResourceCounter.notifyAll();
      return;
    }
    finally {}
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
      if (this.mWaitOnResource != null) {
        synchronized (this.mWaitOnResource)
        {
          this.mWaitOnResource.notifyAll();
        }
      }
      if (this.mCancelListener != null) {
        this.mCancelListener.onCancel();
      }
      return;
    }
    finally {}
  }
  
  public int compareTo(Worker paramWorker)
  {
    return ((Comparable)this.mJob).compareTo(paramWorker.mJob);
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
    Object localObject1;
    if (setMode(1)) {
      localObject1 = this.mJob.run(this);
    } else {
      localObject1 = null;
    }
    try
    {
      setMode(0);
      this.mResult = localObject1;
      this.mIsDone = true;
      notifyAll();
      localObject1 = this.mListener;
      if (localObject1 != null) {
        ((FutureListener)localObject1).onFutureDone(this);
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
    ThreadPool.ResourceCounter localResourceCounter = modeToCounter(this.mMode);
    if (localResourceCounter != null) {
      releaseResource(localResourceCounter);
    }
    this.mMode = 0;
    localResourceCounter = modeToCounter(paramInt);
    if (localResourceCounter != null)
    {
      if (!acquireResource(localResourceCounter)) {
        return false;
      }
      this.mMode = paramInt;
    }
    return true;
  }
  
  public void waitDone()
  {
    get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool.Worker
 * JD-Core Version:    0.7.0.1
 */