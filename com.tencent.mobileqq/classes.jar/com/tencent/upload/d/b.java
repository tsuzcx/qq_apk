package com.tencent.upload.d;

import com.tencent.upload.common.Const;
import com.tencent.upload.common.Const.UploadRetCode;
import com.tencent.upload.common.Const.b;
import com.tencent.upload.e.a.e;
import com.tencent.upload.e.c.a;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class b
  implements Runnable
{
  private static final String TAG = "BaseTask";
  protected volatile boolean mCanceled = false;
  protected StringBuffer mFlowRecoder = new StringBuffer();
  protected Future<?> mFuture = null;
  protected int mRetCode = Const.UploadRetCode.SUCCEED.getCode();
  protected String mRetMsg = Const.UploadRetCode.SUCCEED.getDesc();
  private volatile c mState = c.a;
  protected volatile boolean mSuspended = false;
  protected int mTaskId = UUID.randomUUID().hashCode();
  protected ThreadPoolExecutor mThreadPool;
  
  private boolean terminateJob(Future<?> paramFuture)
  {
    if ((paramFuture.cancel(true) == true) && (paramFuture.isCancelled()))
    {
      com.tencent.upload.common.b.c("BaseTask", "task is canceled. task id=" + getTaskId());
      if (getTaskState() == c.a)
      {
        if (this.mCanceled) {
          setState(c.e);
        }
      }
      else {
        return true;
      }
      setState(c.d);
      return true;
    }
    com.tencent.upload.common.b.d("BaseTask", "task can not be canceled. task id=" + getTaskId());
    return false;
  }
  
  public void bindThreadPool(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    this.mThreadPool = paramThreadPoolExecutor;
  }
  
  /* Error */
  public boolean cancel()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +49 -> 59
    //   13: ldc 10
    //   15: new 92	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   22: ldc 140
    //   24: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 102	com/tencent/upload/d/b:getTaskId	()I
    //   31: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 142	com/tencent/upload/common/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 59	com/tencent/upload/d/b:mCanceled	Z
    //   45: aload_0
    //   46: getstatic 121	com/tencent/upload/d/c:e	Lcom/tencent/upload/d/c;
    //   49: invokevirtual 125	com/tencent/upload/d/b:setState	(Lcom/tencent/upload/d/c;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    //   59: aload_2
    //   60: invokeinterface 145 1 0
    //   65: ifeq +46 -> 111
    //   68: ldc 10
    //   70: new 92	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   77: ldc 147
    //   79: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 102	com/tencent/upload/d/b:getTaskId	()I
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 114	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_1
    //   105: ireturn
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 59	com/tencent/upload/d/b:mCanceled	Z
    //   116: aload_0
    //   117: aload_2
    //   118: invokespecial 149	com/tencent/upload/d/b:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   121: istore_1
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   129: aload_0
    //   130: monitorexit
    //   131: iload_1
    //   132: ireturn
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload_0
    //   140: monitorenter
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore_2
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	b
    //   121	11	1	bool	boolean
    //   6	4	2	localFuture1	Future
    //   54	6	2	localObject1	Object
    //   106	12	2	localFuture2	Future
    //   133	4	2	localObject2	Object
    //   138	11	2	localObject3	Object
    //   150	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	54	finally
    //   55	57	54	finally
    //   97	104	106	finally
    //   107	109	106	finally
    //   124	131	133	finally
    //   134	136	133	finally
    //   111	122	138	finally
    //   141	148	150	finally
    //   151	153	150	finally
  }
  
  public abstract Const.b getFileType();
  
  public int getRetCode()
  {
    return this.mRetCode;
  }
  
  public String getRetMsg()
  {
    return this.mRetMsg;
  }
  
  protected c getState()
  {
    try
    {
      c localc = this.mState;
      return localc;
    }
    finally {}
  }
  
  public int getTaskId()
  {
    return this.mTaskId;
  }
  
  public c getTaskState()
  {
    return this.mState;
  }
  
  public boolean isAlive()
  {
    return (!this.mCanceled) && (!this.mSuspended);
  }
  
  public abstract void onError(int paramInt, String paramString);
  
  protected abstract boolean onRun();
  
  /* Error */
  public boolean pause()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +49 -> 59
    //   13: ldc 10
    //   15: new 92	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   22: ldc 140
    //   24: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 102	com/tencent/upload/d/b:getTaskId	()I
    //   31: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 142	com/tencent/upload/common/b:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 61	com/tencent/upload/d/b:mSuspended	Z
    //   45: aload_0
    //   46: getstatic 128	com/tencent/upload/d/c:d	Lcom/tencent/upload/d/c;
    //   49: invokevirtual 125	com/tencent/upload/d/b:setState	(Lcom/tencent/upload/d/c;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    //   59: aload_2
    //   60: invokeinterface 145 1 0
    //   65: ifeq +46 -> 111
    //   68: ldc 10
    //   70: new 92	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 93	java/lang/StringBuilder:<init>	()V
    //   77: ldc 147
    //   79: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 102	com/tencent/upload/d/b:getTaskId	()I
    //   86: invokevirtual 105	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 108	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 114	com/tencent/upload/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   102: aload_0
    //   103: monitorexit
    //   104: iconst_1
    //   105: ireturn
    //   106: astore_2
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_2
    //   110: athrow
    //   111: aload_0
    //   112: iconst_1
    //   113: putfield 61	com/tencent/upload/d/b:mSuspended	Z
    //   116: aload_0
    //   117: aload_2
    //   118: invokespecial 149	com/tencent/upload/d/b:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   121: istore_1
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   129: aload_0
    //   130: monitorexit
    //   131: iload_1
    //   132: ireturn
    //   133: astore_2
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_2
    //   137: athrow
    //   138: astore_2
    //   139: aload_0
    //   140: monitorenter
    //   141: aload_0
    //   142: aconst_null
    //   143: putfield 57	com/tencent/upload/d/b:mFuture	Ljava/util/concurrent/Future;
    //   146: aload_0
    //   147: monitorexit
    //   148: aload_2
    //   149: athrow
    //   150: astore_2
    //   151: aload_0
    //   152: monitorexit
    //   153: aload_2
    //   154: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	155	0	this	b
    //   121	11	1	bool	boolean
    //   6	4	2	localFuture1	Future
    //   54	6	2	localObject1	Object
    //   106	12	2	localFuture2	Future
    //   133	4	2	localObject2	Object
    //   138	11	2	localObject3	Object
    //   150	4	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   2	9	54	finally
    //   55	57	54	finally
    //   97	104	106	finally
    //   107	109	106	finally
    //   124	131	133	finally
    //   134	136	133	finally
    //   111	122	138	finally
    //   141	148	150	finally
    //   151	153	150	finally
  }
  
  protected abstract void report(int paramInt, String paramString);
  
  public void resetWaitState()
  {
    try
    {
      this.mState = c.a;
      com.tencent.upload.common.b.b("BaseTask", "resetWaitState task id:" + getTaskId());
      return;
    }
    finally {}
  }
  
  public void run()
  {
    for (;;)
    {
      try
      {
        boolean bool = onRun();
        if (bool != true) {
          continue;
        }
      }
      catch (Throwable localThrowable)
      {
        com.tencent.upload.common.b.c("BaseTask", "taskId:" + getTaskId() + " onRun has Exception:", localThrowable);
        if (this.mRetCode != 0) {
          continue;
        }
        this.mRetCode = Const.UploadRetCode.UNKNOWN_EXCEPTION.getCode();
        onError(this.mRetCode, Const.a(this.mRetCode).getDesc());
        setState(c.f);
        a.a(this, localThrowable);
        continue;
        setState(c.d);
        continue;
        setState(c.f);
        continue;
      }
      try
      {
        this.mFuture = null;
        notifyAll();
        return;
      }
      finally {}
      if ((!Thread.interrupted()) && (isAlive())) {
        continue;
      }
      if (!this.mCanceled) {
        continue;
      }
      setState(c.e);
    }
  }
  
  public void setRetCode(int paramInt)
  {
    this.mRetCode = paramInt;
  }
  
  public void setRetMsg(String paramString)
  {
    this.mRetMsg = paramString;
  }
  
  protected void setState(c paramc)
  {
    try
    {
      this.mState = paramc;
      com.tencent.upload.common.b.b("BaseTask", "setState: " + this.mState + " ---> " + paramc);
      return;
    }
    finally {}
  }
  
  public void setTaskId(int paramInt)
  {
    this.mTaskId = paramInt;
  }
  
  protected boolean setTaskStatus(c paramc)
  {
    com.tencent.upload.common.b.c("BaseTask", "setTaskStatus " + this.mState + " --> " + paramc);
    if (this.mState == paramc) {
      return false;
    }
    this.mState = paramc;
    return true;
  }
  
  public boolean start()
  {
    if (this.mThreadPool == null)
    {
      com.tencent.upload.common.b.e("BaseTask", "thread pool is null!");
      return false;
    }
    try
    {
      Future localFuture = this.mFuture;
      if (localFuture != null) {}
      try
      {
        com.tencent.upload.common.b.b("BaseTask", "start wait ...");
        wait();
        try
        {
          this.mCanceled = false;
          this.mSuspended = false;
          setState(c.a);
          localFuture = submit(this.mThreadPool);
          if (localFuture != null) {
            break label128;
          }
          com.tencent.upload.common.b.d("BaseTask", "submit task failed! task id=" + getTaskId());
          return false;
        }
        catch (Exception localException)
        {
          com.tencent.upload.common.b.b("BaseTask", "submit task failed!", localException);
          return false;
        }
        localObject1 = finally;
      }
      catch (Throwable localThrowable)
      {
        com.tencent.upload.common.b.c("BaseTask", "thread exception !", localThrowable);
        return false;
      }
    }
    finally {}
    try
    {
      label128:
      if (!localObject1.isDone()) {
        this.mFuture = localObject1;
      }
      com.tencent.upload.common.b.c("BaseTask", "submit task ok. task id=" + getTaskId() + " thread pool:" + e.a().toString());
      return true;
    }
    finally {}
  }
  
  protected Future<?> submit(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return paramThreadPoolExecutor.submit(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.upload.d.b
 * JD-Core Version:    0.7.0.1
 */