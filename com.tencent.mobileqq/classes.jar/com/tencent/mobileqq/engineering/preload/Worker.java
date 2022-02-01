package com.tencent.mobileqq.engineering.preload;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.engineering.preload.inter.IWorker;
import com.tencent.mobileqq.engineering.preload.inter.OnPreLoadListener;
import com.tencent.mobileqq.engineering.preload.inter.OnTaskListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Worker<T>
  implements IWorker, OnPreLoadListener<T>, Runnable
{
  private static final ThreadFactory FACTORY = new Worker.1();
  private static ExecutorService mDefaultThreadPoolExecutor = new ThreadPoolExecutor(2, 2147483647, 60L, TimeUnit.SECONDS, new SynchronousQueue(), FACTORY);
  BasePreLoadTask<T> mBasePreLoadTask;
  private final Handler mMainThreadHandler = new Handler(Looper.getMainLooper());
  private volatile OnTaskListener<T> mOnCompleteListener = null;
  private String mPreloadId;
  private T[] mResponse;
  private long mRspTimeStamp;
  private int mSeq = 0;
  private volatile String mState = "";
  private ExecutorService mThreadPoolExecutor;
  
  Worker(String paramString, BasePreLoadTask<T> paramBasePreLoadTask, OnTaskListener<T> paramOnTaskListener, int paramInt)
  {
    this.mPreloadId = paramString;
    this.mSeq = paramInt;
    init(paramBasePreLoadTask);
    if (paramOnTaskListener != null) {
      this.mOnCompleteListener = paramOnTaskListener;
    }
  }
  
  private void init(BasePreLoadTask<T> paramBasePreLoadTask)
  {
    this.mBasePreLoadTask = paramBasePreLoadTask;
    setState(State.Initialed);
  }
  
  private boolean isMainThread()
  {
    return Looper.getMainLooper() == Looper.myLooper();
  }
  
  private void safeListenData(OnTaskListener<T> paramOnTaskListener, T... paramVarArgs)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      long l2 = this.mBasePreLoadTask.mPreloadExpiredTime;
      StringBuilder localStringBuilder;
      if ((l2 > 0L) && (l1 - this.mRspTimeStamp > this.mBasePreLoadTask.mPreloadExpiredTime * 1000L))
      {
        paramVarArgs = new StringBuilder();
        paramVarArgs.append("id=");
        paramVarArgs.append(this.mPreloadId);
        paramVarArgs.append(", seq=");
        paramVarArgs.append(this.mSeq);
        paramVarArgs.append(", response is expored! mPreloadExpiredTime ");
        paramVarArgs.append(this.mBasePreLoadTask.mPreloadExpiredTime);
        PreLoader.log(paramVarArgs.toString());
        paramVarArgs = null;
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id=");
        localStringBuilder.append(this.mPreloadId);
        localStringBuilder.append(", seq=");
        localStringBuilder.append(this.mSeq);
        localStringBuilder.append(", response isn't expored! mPreloadExpiredTime ");
        localStringBuilder.append(this.mBasePreLoadTask.mPreloadExpiredTime);
        PreLoader.log(localStringBuilder.toString());
      }
      if (isMainThread())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id=");
        localStringBuilder.append(this.mPreloadId);
        localStringBuilder.append(", seq=");
        localStringBuilder.append(this.mSeq);
        localStringBuilder.append(", is in mainThread");
        PreLoader.log(localStringBuilder.toString());
        paramOnTaskListener.onComplete(paramVarArgs);
        if (this.mBasePreLoadTask.mIsOnlyRunOnce) {
          PreLoader.remove(this.mPreloadId);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("id=");
        localStringBuilder.append(this.mPreloadId);
        localStringBuilder.append(", seq=");
        localStringBuilder.append(this.mSeq);
        localStringBuilder.append(", is not in mainThread");
        PreLoader.log(localStringBuilder.toString());
        this.mMainThreadHandler.post(new Worker.2(this, paramOnTaskListener, paramVarArgs));
        return;
      }
    }
    catch (Exception paramOnTaskListener)
    {
      PreLoader.log(paramOnTaskListener);
    }
  }
  
  static void setDefaultThreadPoolExecutor(ExecutorService paramExecutorService)
  {
    if (paramExecutorService != null) {
      mDefaultThreadPoolExecutor = paramExecutorService;
    }
  }
  
  private void setState(String paramString)
  {
    this.mState = paramString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.mPreloadId);
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.mSeq);
    localStringBuilder.append(", set state to ");
    localStringBuilder.append(paramString);
    PreLoader.log(localStringBuilder.toString());
  }
  
  public void doPreLoad()
  {
    ExecutorService localExecutorService = this.mThreadPoolExecutor;
    if (localExecutorService != null) {
      localExecutorService.execute(this);
    } else {
      mDefaultThreadPoolExecutor.execute(this);
    }
    setState(State.Loading);
  }
  
  public void onLoaded(T... paramVarArgs)
  {
    this.mResponse = paramVarArgs;
    this.mRspTimeStamp = System.currentTimeMillis();
    setState(State.Done);
    if (this.mOnCompleteListener != null)
    {
      safeListenData(this.mOnCompleteListener, paramVarArgs);
      return;
    }
    paramVarArgs = new StringBuilder();
    paramVarArgs.append("id=");
    paramVarArgs.append(this.mPreloadId);
    paramVarArgs.append(", seq=");
    paramVarArgs.append(this.mSeq);
    paramVarArgs.append(", done but listener is null");
    PreLoader.log(paramVarArgs.toString());
  }
  
  public void onRemove()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(this.mPreloadId);
      localStringBuilder.append(", seq=");
      localStringBuilder.append(this.mSeq);
      localStringBuilder.append(", on remove worker");
      PreLoader.log(localStringBuilder.toString());
      this.mBasePreLoadTask.onRemove();
      return;
    }
    catch (Exception localException)
    {
      PreLoader.log(localException);
    }
  }
  
  public void removeListener(OnTaskListener paramOnTaskListener)
  {
    paramOnTaskListener = new StringBuilder();
    paramOnTaskListener.append("id=");
    paramOnTaskListener.append(this.mPreloadId);
    paramOnTaskListener.append(", seq=");
    paramOnTaskListener.append(this.mSeq);
    paramOnTaskListener.append(", remove listener");
    PreLoader.log(paramOnTaskListener.toString());
    this.mOnCompleteListener = null;
  }
  
  public void run()
  {
    try
    {
      this.mBasePreLoadTask.startLoadData(this);
      return;
    }
    catch (Exception localException)
    {
      PreLoader.log(localException);
    }
  }
  
  public void setListener(OnTaskListener paramOnTaskListener)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("id=");
    localStringBuilder.append(this.mPreloadId);
    localStringBuilder.append(", seq=");
    localStringBuilder.append(this.mSeq);
    localStringBuilder.append(", setListener listener ");
    boolean bool;
    if (paramOnTaskListener != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    PreLoader.log(localStringBuilder.toString());
    if (paramOnTaskListener != null)
    {
      this.mOnCompleteListener = paramOnTaskListener;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("id=");
      localStringBuilder.append(this.mPreloadId);
      localStringBuilder.append(", seq=");
      localStringBuilder.append(this.mSeq);
      localStringBuilder.append(", cur state ");
      localStringBuilder.append(this.mState);
      PreLoader.log(localStringBuilder.toString());
      if (State.Done.equals(this.mState)) {
        safeListenData(paramOnTaskListener, this.mResponse);
      }
    }
  }
  
  public void setThreadPoolExecutor(ExecutorService paramExecutorService)
  {
    if (paramExecutorService != null) {
      this.mThreadPoolExecutor = paramExecutorService;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.engineering.preload.Worker
 * JD-Core Version:    0.7.0.1
 */