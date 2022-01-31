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
    //   79: aload_1
    //   80: athrow
    //   81: astore_2
    //   82: goto -16 -> 66
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	85	0	this	Worker
    //   0	85	1	paramResourceCounter	ThreadPool.ResourceCounter
    //   71	4	2	localObject	Object
    //   81	1	2	localInterruptedException	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   2	16	57	finally
    //   18	25	57	finally
    //   58	60	57	finally
    //   27	46	71	finally
    //   62	66	71	finally
    //   66	68	71	finally
    //   72	74	71	finally
    //   48	55	76	finally
    //   77	79	76	finally
    //   62	66	81	java/lang/InterruptedException
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
  
  /* Error */
  public void cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mIsCancelled	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 57	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mIsCancelled	Z
    //   19: aload_0
    //   20: getfield 59	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mWaitOnResource	Lcom/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter;
    //   23: ifnull +19 -> 42
    //   26: aload_0
    //   27: getfield 59	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mWaitOnResource	Lcom/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter;
    //   30: astore_2
    //   31: aload_2
    //   32: monitorenter
    //   33: aload_0
    //   34: getfield 59	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mWaitOnResource	Lcom/tencent/weiyun/utils/thread/ThreadPool$ResourceCounter;
    //   37: invokevirtual 82	java/lang/Object:notifyAll	()V
    //   40: aload_2
    //   41: monitorexit
    //   42: aload_0
    //   43: getfield 85	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mCancelListener	Lcom/tencent/weiyun/utils/thread/ThreadPool$CancelListener;
    //   46: ifnull -35 -> 11
    //   49: aload_0
    //   50: getfield 85	com/tencent/weiyun/utils/thread/ThreadPool$Worker:mCancelListener	Lcom/tencent/weiyun/utils/thread/ThreadPool$CancelListener;
    //   53: invokeinterface 90 1 0
    //   58: goto -47 -> 11
    //   61: astore_2
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_2
    //   65: athrow
    //   66: astore_3
    //   67: aload_2
    //   68: monitorexit
    //   69: aload_3
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	this	Worker
    //   6	2	1	bool	boolean
    //   61	7	2	localObject1	Object
    //   66	4	3	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	61	finally
    //   14	33	61	finally
    //   42	58	61	finally
    //   69	71	61	finally
    //   33	42	66	finally
    //   67	69	66	finally
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
    Object localObject1 = null;
    if (setMode(1)) {
      localObject1 = this.mJob.run(this);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.utils.thread.ThreadPool.Worker
 * JD-Core Version:    0.7.0.1
 */