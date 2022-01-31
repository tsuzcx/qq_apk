package com.tencent.upload.task;

import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.Const.FileType;
import com.tencent.upload.utils.Const.UploadRetCode;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.watcher.UploadFlowTracker;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class BaseTask
  implements Runnable
{
  private static final String TAG = "BaseTask";
  protected volatile boolean mCanceled = false;
  protected StringBuffer mFlowRecoder = new StringBuffer();
  protected Future<?> mFuture = null;
  protected int mRetCode = Const.UploadRetCode.SUCCEED.getCode();
  protected String mRetMsg = Const.UploadRetCode.SUCCEED.getDesc();
  private volatile TaskState mState = TaskState.WAITING;
  protected volatile boolean mSuspended = false;
  protected int mTaskId = UUID.randomUUID().hashCode();
  protected ThreadPoolExecutor mThreadPool;
  
  private boolean terminateJob(Future<?> paramFuture)
  {
    if ((paramFuture.cancel(true) == true) && (paramFuture.isCancelled()))
    {
      paramFuture = getTaskState();
      UploadLog.i("BaseTask", "terminateJob | task is canceled. task id=" + getTaskId() + " , lastState:" + paramFuture);
      if (paramFuture == TaskState.WAITING)
      {
        if (this.mCanceled) {
          setState(TaskState.CANCEL);
        }
      }
      else {
        return true;
      }
      setState(TaskState.PAUSE);
      return true;
    }
    UploadLog.w("BaseTask", "task can not be canceled. task id=" + getTaskId());
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
    //   3: getfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +49 -> 59
    //   13: ldc 10
    //   15: new 96	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   22: ldc 146
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   31: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 149	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 59	com/tencent/upload/task/BaseTask:mCanceled	Z
    //   45: aload_0
    //   46: getstatic 126	com/tencent/upload/task/TaskState:CANCEL	Lcom/tencent/upload/task/TaskState;
    //   49: invokevirtual 130	com/tencent/upload/task/BaseTask:setState	(Lcom/tencent/upload/task/TaskState;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    //   59: aload_2
    //   60: invokeinterface 152 1 0
    //   65: ifeq +46 -> 111
    //   68: ldc 10
    //   70: new 96	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   77: ldc 154
    //   79: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   86: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 123	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
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
    //   113: putfield 59	com/tencent/upload/task/BaseTask:mCanceled	Z
    //   116: aload_0
    //   117: aload_2
    //   118: invokespecial 156	com/tencent/upload/task/BaseTask:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   121: istore_1
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
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
    //   143: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
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
    //   0	155	0	this	BaseTask
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
  
  public abstract Const.FileType getFileType();
  
  public int getRetCode()
  {
    return this.mRetCode;
  }
  
  public String getRetMsg()
  {
    return this.mRetMsg;
  }
  
  protected TaskState getState()
  {
    try
    {
      TaskState localTaskState = this.mState;
      return localTaskState;
    }
    finally {}
  }
  
  public int getTaskId()
  {
    return this.mTaskId;
  }
  
  public TaskState getTaskState()
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
    //   3: getfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   6: astore_2
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_2
    //   10: ifnonnull +49 -> 59
    //   13: ldc 10
    //   15: new 96	java/lang/StringBuilder
    //   18: dup
    //   19: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   22: ldc 146
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   31: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   34: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 149	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: iconst_1
    //   42: putfield 61	com/tencent/upload/task/BaseTask:mSuspended	Z
    //   45: aload_0
    //   46: getstatic 133	com/tencent/upload/task/TaskState:PAUSE	Lcom/tencent/upload/task/TaskState;
    //   49: invokevirtual 130	com/tencent/upload/task/BaseTask:setState	(Lcom/tencent/upload/task/TaskState;)V
    //   52: iconst_1
    //   53: ireturn
    //   54: astore_2
    //   55: aload_0
    //   56: monitorexit
    //   57: aload_2
    //   58: athrow
    //   59: aload_2
    //   60: invokeinterface 152 1 0
    //   65: ifeq +46 -> 111
    //   68: ldc 10
    //   70: new 96	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   77: ldc 154
    //   79: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   86: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   89: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 123	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   95: aload_0
    //   96: monitorenter
    //   97: aload_0
    //   98: aconst_null
    //   99: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
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
    //   113: putfield 61	com/tencent/upload/task/BaseTask:mSuspended	Z
    //   116: aload_0
    //   117: aload_2
    //   118: invokespecial 156	com/tencent/upload/task/BaseTask:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   121: istore_1
    //   122: aload_0
    //   123: monitorenter
    //   124: aload_0
    //   125: aconst_null
    //   126: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
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
    //   143: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
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
    //   0	155	0	this	BaseTask
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
      UploadLog.d("BaseTask", "resetWaitState task id:" + getTaskId());
      setState(TaskState.PAUSE);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
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
        UploadLog.e("BaseTask", "taskId:" + getTaskId() + " onRun has Exception:", localThrowable);
        if (this.mRetCode != 0) {
          continue;
        }
        this.mRetCode = Const.UploadRetCode.UNKNOWN_EXCEPTION.getCode();
        onError(this.mRetCode, Const.getRetCode(this.mRetCode).getDesc());
        setState(TaskState.FAILED);
        UploadFlowTracker.trackException(this, localThrowable);
        continue;
        setState(TaskState.PAUSE);
        continue;
        setState(TaskState.FAILED);
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
      UploadLog.d("BaseTask", "task id:" + getTaskId() + " Thread.interrupted():" + Thread.interrupted() + " mCanceled:" + this.mCanceled + " mSuspended:" + this.mSuspended);
      if (!this.mCanceled) {
        continue;
      }
      setState(TaskState.CANCEL);
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
  
  public void setState(TaskState paramTaskState)
  {
    try
    {
      UploadLog.d("BaseTask", "taskid:" + this.mTaskId + " setState: " + this.mState + " ---> " + paramTaskState);
      this.mState = paramTaskState;
      return;
    }
    finally
    {
      paramTaskState = finally;
      throw paramTaskState;
    }
  }
  
  public void setTaskId(int paramInt)
  {
    this.mTaskId = paramInt;
  }
  
  protected boolean setTaskStatus(TaskState paramTaskState)
  {
    UploadLog.i("BaseTask", "setTaskStatus " + this.mState + " --> " + paramTaskState);
    if (this.mState == paramTaskState) {
      return false;
    }
    this.mState = paramTaskState;
    return true;
  }
  
  /* Error */
  public boolean start()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: aload_0
    //   3: monitorenter
    //   4: aload_0
    //   5: getfield 144	com/tencent/upload/task/BaseTask:mThreadPool	Ljava/util/concurrent/ThreadPoolExecutor;
    //   8: ifnonnull +14 -> 22
    //   11: ldc 10
    //   13: ldc 247
    //   15: invokestatic 149	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   18: aload_0
    //   19: monitorexit
    //   20: iload_1
    //   21: ireturn
    //   22: aload_0
    //   23: getfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +14 -> 42
    //   31: ldc 10
    //   33: ldc 249
    //   35: invokestatic 173	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   38: aload_0
    //   39: invokevirtual 252	java/lang/Object:wait	()V
    //   42: aload_0
    //   43: iconst_0
    //   44: putfield 59	com/tencent/upload/task/BaseTask:mCanceled	Z
    //   47: aload_0
    //   48: iconst_0
    //   49: putfield 61	com/tencent/upload/task/BaseTask:mSuspended	Z
    //   52: aload_0
    //   53: getstatic 35	com/tencent/upload/task/TaskState:WAITING	Lcom/tencent/upload/task/TaskState;
    //   56: invokevirtual 130	com/tencent/upload/task/BaseTask:setState	(Lcom/tencent/upload/task/TaskState;)V
    //   59: aload_0
    //   60: aload_0
    //   61: getfield 144	com/tencent/upload/task/BaseTask:mThreadPool	Ljava/util/concurrent/ThreadPoolExecutor;
    //   64: invokevirtual 256	com/tencent/upload/task/BaseTask:submit	(Ljava/util/concurrent/ThreadPoolExecutor;)Ljava/util/concurrent/Future;
    //   67: astore_2
    //   68: aload_2
    //   69: ifnonnull +65 -> 134
    //   72: ldc 10
    //   74: new 96	java/lang/StringBuilder
    //   77: dup
    //   78: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   81: ldc_w 258
    //   84: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: aload_0
    //   88: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   91: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   94: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 138	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: goto -82 -> 18
    //   103: astore_2
    //   104: ldc 10
    //   106: ldc_w 260
    //   109: aload_2
    //   110: invokestatic 262	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   113: goto -95 -> 18
    //   116: astore_2
    //   117: aload_0
    //   118: monitorexit
    //   119: aload_2
    //   120: athrow
    //   121: astore_2
    //   122: ldc 10
    //   124: ldc_w 264
    //   127: aload_2
    //   128: invokestatic 206	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   131: goto -113 -> 18
    //   134: aload_2
    //   135: invokeinterface 152 1 0
    //   140: ifne +8 -> 148
    //   143: aload_0
    //   144: aload_2
    //   145: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   148: ldc 10
    //   150: new 96	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 266
    //   160: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_0
    //   164: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   167: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   170: ldc_w 268
    //   173: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: invokestatic 274	com/tencent/upload/utils/pool/UploadThreadManager:getInstance	()Lcom/tencent/upload/utils/pool/UploadThreadManager;
    //   179: invokevirtual 275	com/tencent/upload/utils/pool/UploadThreadManager:toString	()Ljava/lang/String;
    //   182: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 123	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: iconst_1
    //   192: istore_1
    //   193: goto -175 -> 18
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	196	0	this	BaseTask
    //   1	192	1	bool	boolean
    //   26	43	2	localFuture	Future
    //   103	7	2	localException	java.lang.Exception
    //   116	4	2	localObject	Object
    //   121	24	2	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   42	68	103	java/lang/Exception
    //   72	100	103	java/lang/Exception
    //   4	18	116	finally
    //   22	27	116	finally
    //   31	42	116	finally
    //   42	68	116	finally
    //   72	100	116	finally
    //   104	113	116	finally
    //   122	131	116	finally
    //   134	148	116	finally
    //   148	191	116	finally
    //   31	42	121	java/lang/Throwable
  }
  
  protected Future<?> submit(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return paramThreadPoolExecutor.submit(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.upload.task.BaseTask
 * JD-Core Version:    0.7.0.1
 */