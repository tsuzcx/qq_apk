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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("terminateJob | task is canceled. task id=");
      localStringBuilder.append(getTaskId());
      localStringBuilder.append(" , lastState:");
      localStringBuilder.append(paramFuture);
      UploadLog.i("BaseTask", localStringBuilder.toString());
      if (paramFuture == TaskState.WAITING)
      {
        if (this.mCanceled)
        {
          setState(TaskState.CANCEL);
          return true;
        }
        setState(TaskState.PAUSE);
      }
      return true;
    }
    paramFuture = new StringBuilder();
    paramFuture.append("task can not be canceled. task id=");
    paramFuture.append(getTaskId());
    UploadLog.w("BaseTask", paramFuture.toString());
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
    //   10: ifnonnull +50 -> 60
    //   13: new 96	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 146
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   33: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 10
    //   39: aload_2
    //   40: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 149	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 59	com/tencent/upload/task/BaseTask:mCanceled	Z
    //   51: aload_0
    //   52: getstatic 126	com/tencent/upload/task/TaskState:CANCEL	Lcom/tencent/upload/task/TaskState;
    //   55: invokevirtual 130	com/tencent/upload/task/BaseTask:setState	(Lcom/tencent/upload/task/TaskState;)V
    //   58: iconst_1
    //   59: ireturn
    //   60: aload_2
    //   61: invokeinterface 152 1 0
    //   66: ifeq +52 -> 118
    //   69: new 96	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: ldc 154
    //   80: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: aload_0
    //   86: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   89: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 10
    //   95: aload_2
    //   96: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 123	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: monitorenter
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_1
    //   112: ireturn
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 59	com/tencent/upload/task/BaseTask:mCanceled	Z
    //   123: aload_0
    //   124: aload_2
    //   125: invokespecial 156	com/tencent/upload/task/BaseTask:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   128: istore_1
    //   129: aload_0
    //   130: monitorenter
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   136: aload_0
    //   137: monitorexit
    //   138: iload_1
    //   139: ireturn
    //   140: astore_2
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: astore_2
    //   146: aload_0
    //   147: monitorenter
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	BaseTask
    //   128	11	1	bool	boolean
    //   6	90	2	localObject1	Object
    //   113	12	2	localFuture	Future
    //   140	4	2	localObject2	Object
    //   145	11	2	localObject3	Object
    //   157	4	2	localObject4	Object
    //   162	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   104	111	113	finally
    //   114	116	113	finally
    //   131	138	140	finally
    //   141	143	140	finally
    //   118	129	145	finally
    //   148	155	157	finally
    //   158	160	157	finally
    //   2	9	162	finally
    //   163	165	162	finally
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
    //   10: ifnonnull +50 -> 60
    //   13: new 96	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   20: astore_2
    //   21: aload_2
    //   22: ldc 146
    //   24: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: aload_0
    //   30: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   33: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: ldc 10
    //   39: aload_2
    //   40: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 149	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   46: aload_0
    //   47: iconst_1
    //   48: putfield 61	com/tencent/upload/task/BaseTask:mSuspended	Z
    //   51: aload_0
    //   52: getstatic 133	com/tencent/upload/task/TaskState:PAUSE	Lcom/tencent/upload/task/TaskState;
    //   55: invokevirtual 130	com/tencent/upload/task/BaseTask:setState	(Lcom/tencent/upload/task/TaskState;)V
    //   58: iconst_1
    //   59: ireturn
    //   60: aload_2
    //   61: invokeinterface 152 1 0
    //   66: ifeq +52 -> 118
    //   69: new 96	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   76: astore_2
    //   77: aload_2
    //   78: ldc 154
    //   80: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload_2
    //   85: aload_0
    //   86: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   89: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: ldc 10
    //   95: aload_2
    //   96: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   99: invokestatic 123	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   102: aload_0
    //   103: monitorenter
    //   104: aload_0
    //   105: aconst_null
    //   106: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   109: aload_0
    //   110: monitorexit
    //   111: iconst_1
    //   112: ireturn
    //   113: astore_2
    //   114: aload_0
    //   115: monitorexit
    //   116: aload_2
    //   117: athrow
    //   118: aload_0
    //   119: iconst_1
    //   120: putfield 61	com/tencent/upload/task/BaseTask:mSuspended	Z
    //   123: aload_0
    //   124: aload_2
    //   125: invokespecial 156	com/tencent/upload/task/BaseTask:terminateJob	(Ljava/util/concurrent/Future;)Z
    //   128: istore_1
    //   129: aload_0
    //   130: monitorenter
    //   131: aload_0
    //   132: aconst_null
    //   133: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   136: aload_0
    //   137: monitorexit
    //   138: iload_1
    //   139: ireturn
    //   140: astore_2
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: astore_2
    //   146: aload_0
    //   147: monitorenter
    //   148: aload_0
    //   149: aconst_null
    //   150: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_2
    //   156: athrow
    //   157: astore_2
    //   158: aload_0
    //   159: monitorexit
    //   160: aload_2
    //   161: athrow
    //   162: astore_2
    //   163: aload_0
    //   164: monitorexit
    //   165: aload_2
    //   166: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	167	0	this	BaseTask
    //   128	11	1	bool	boolean
    //   6	90	2	localObject1	Object
    //   113	12	2	localFuture	Future
    //   140	4	2	localObject2	Object
    //   145	11	2	localObject3	Object
    //   157	4	2	localObject4	Object
    //   162	4	2	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   104	111	113	finally
    //   114	116	113	finally
    //   131	138	140	finally
    //   141	143	140	finally
    //   118	129	145	finally
    //   148	155	157	finally
    //   158	160	157	finally
    //   2	9	162	finally
    //   163	165	162	finally
  }
  
  protected abstract void report(int paramInt, String paramString);
  
  public void resetWaitState()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resetWaitState task id:");
      localStringBuilder.append(getTaskId());
      UploadLog.d("BaseTask", localStringBuilder.toString());
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
    try
    {
      if (onRun() != true) {
        if ((!Thread.interrupted()) && (isAlive()))
        {
          setState(TaskState.FAILED);
        }
        else
        {
          StringBuilder localStringBuilder1 = new StringBuilder();
          localStringBuilder1.append("task id:");
          localStringBuilder1.append(getTaskId());
          localStringBuilder1.append(" Thread.interrupted():");
          localStringBuilder1.append(Thread.interrupted());
          localStringBuilder1.append(" mCanceled:");
          localStringBuilder1.append(this.mCanceled);
          localStringBuilder1.append(" mSuspended:");
          localStringBuilder1.append(this.mSuspended);
          UploadLog.d("BaseTask", localStringBuilder1.toString());
          if (this.mCanceled) {
            setState(TaskState.CANCEL);
          } else {
            setState(TaskState.PAUSE);
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("taskId:");
      localStringBuilder2.append(getTaskId());
      localStringBuilder2.append(" onRun has Exception:");
      localStringBuilder2.append(localThrowable.getMessage());
      UploadLog.e("BaseTask", localStringBuilder2.toString());
      if (this.mRetCode == 0) {
        this.mRetCode = Const.UploadRetCode.UNKNOWN_EXCEPTION.getCode();
      }
      int i = this.mRetCode;
      onError(i, Const.getRetCode(i).getDesc());
      setState(TaskState.FAILED);
      UploadFlowTracker.trackException(this, localThrowable);
    }
    try
    {
      this.mFuture = null;
      notifyAll();
      return;
    }
    finally {}
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("taskid:");
      localStringBuilder.append(this.mTaskId);
      localStringBuilder.append(" setState: ");
      localStringBuilder.append(this.mState);
      localStringBuilder.append(" ---> ");
      localStringBuilder.append(paramTaskState);
      UploadLog.d("BaseTask", localStringBuilder.toString());
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setTaskStatus ");
    localStringBuilder.append(this.mState);
    localStringBuilder.append(" --> ");
    localStringBuilder.append(paramTaskState);
    UploadLog.i("BaseTask", localStringBuilder.toString());
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
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 144	com/tencent/upload/task/BaseTask:mThreadPool	Ljava/util/concurrent/ThreadPoolExecutor;
    //   6: ifnonnull +14 -> 20
    //   9: ldc 10
    //   11: ldc 247
    //   13: invokestatic 149	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: monitorexit
    //   18: iconst_0
    //   19: ireturn
    //   20: aload_0
    //   21: getfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   24: astore_1
    //   25: aload_1
    //   26: ifnull +30 -> 56
    //   29: ldc 10
    //   31: ldc 249
    //   33: invokestatic 173	com/tencent/upload/utils/UploadLog:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   36: aload_0
    //   37: invokevirtual 252	java/lang/Object:wait	()V
    //   40: goto +16 -> 56
    //   43: astore_1
    //   44: ldc 10
    //   46: ldc 254
    //   48: aload_1
    //   49: invokestatic 257	com/tencent/upload/utils/UploadLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   52: aload_0
    //   53: monitorexit
    //   54: iconst_0
    //   55: ireturn
    //   56: aload_0
    //   57: iconst_0
    //   58: putfield 59	com/tencent/upload/task/BaseTask:mCanceled	Z
    //   61: aload_0
    //   62: iconst_0
    //   63: putfield 61	com/tencent/upload/task/BaseTask:mSuspended	Z
    //   66: aload_0
    //   67: getstatic 35	com/tencent/upload/task/TaskState:WAITING	Lcom/tencent/upload/task/TaskState;
    //   70: invokevirtual 130	com/tencent/upload/task/BaseTask:setState	(Lcom/tencent/upload/task/TaskState;)V
    //   73: aload_0
    //   74: aload_0
    //   75: getfield 144	com/tencent/upload/task/BaseTask:mThreadPool	Ljava/util/concurrent/ThreadPoolExecutor;
    //   78: invokevirtual 261	com/tencent/upload/task/BaseTask:submit	(Ljava/util/concurrent/ThreadPoolExecutor;)Ljava/util/concurrent/Future;
    //   81: astore_1
    //   82: aload_1
    //   83: ifnonnull +41 -> 124
    //   86: new 96	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   93: astore_1
    //   94: aload_1
    //   95: ldc_w 263
    //   98: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: aload_1
    //   103: aload_0
    //   104: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   107: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   110: pop
    //   111: ldc 10
    //   113: aload_1
    //   114: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 138	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: aload_0
    //   121: monitorexit
    //   122: iconst_0
    //   123: ireturn
    //   124: aload_1
    //   125: invokeinterface 152 1 0
    //   130: ifne +8 -> 138
    //   133: aload_0
    //   134: aload_1
    //   135: putfield 57	com/tencent/upload/task/BaseTask:mFuture	Ljava/util/concurrent/Future;
    //   138: new 96	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 97	java/lang/StringBuilder:<init>	()V
    //   145: astore_1
    //   146: aload_1
    //   147: ldc_w 265
    //   150: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_1
    //   155: aload_0
    //   156: invokevirtual 106	com/tencent/upload/task/BaseTask:getTaskId	()I
    //   159: invokevirtual 109	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_1
    //   164: ldc_w 267
    //   167: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: aload_1
    //   172: invokestatic 273	com/tencent/upload/utils/pool/UploadThreadManager:getInstance	()Lcom/tencent/upload/utils/pool/UploadThreadManager;
    //   175: invokevirtual 274	com/tencent/upload/utils/pool/UploadThreadManager:toString	()Ljava/lang/String;
    //   178: invokevirtual 103	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: ldc 10
    //   184: aload_1
    //   185: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 123	com/tencent/upload/utils/UploadLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: aload_0
    //   192: monitorexit
    //   193: iconst_1
    //   194: ireturn
    //   195: astore_1
    //   196: ldc 10
    //   198: ldc_w 276
    //   201: aload_1
    //   202: invokestatic 278	com/tencent/upload/utils/UploadLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   205: aload_0
    //   206: monitorexit
    //   207: iconst_0
    //   208: ireturn
    //   209: astore_1
    //   210: aload_0
    //   211: monitorexit
    //   212: aload_1
    //   213: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	214	0	this	BaseTask
    //   24	2	1	localFuture	Future
    //   43	6	1	localThrowable	Throwable
    //   81	104	1	localObject1	Object
    //   195	7	1	localException	java.lang.Exception
    //   209	4	1	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   29	40	43	java/lang/Throwable
    //   56	82	195	java/lang/Exception
    //   86	120	195	java/lang/Exception
    //   2	16	209	finally
    //   20	25	209	finally
    //   29	40	209	finally
    //   44	52	209	finally
    //   56	82	209	finally
    //   86	120	209	finally
    //   124	138	209	finally
    //   138	191	209	finally
    //   196	205	209	finally
  }
  
  protected Future<?> submit(ThreadPoolExecutor paramThreadPoolExecutor)
  {
    return paramThreadPoolExecutor.submit(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.upload.task.BaseTask
 * JD-Core Version:    0.7.0.1
 */