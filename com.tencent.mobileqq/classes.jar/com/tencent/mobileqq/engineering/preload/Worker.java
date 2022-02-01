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
      long l = System.currentTimeMillis();
      if ((this.mBasePreLoadTask.mPreloadExpiredTime > 0L) && (l - this.mRspTimeStamp > this.mBasePreLoadTask.mPreloadExpiredTime * 1000L))
      {
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", response is expored! mPreloadExpiredTime " + this.mBasePreLoadTask.mPreloadExpiredTime);
        paramVarArgs = null;
      }
      while (isMainThread())
      {
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", is in mainThread");
        paramOnTaskListener.onComplete(paramVarArgs);
        if (!this.mBasePreLoadTask.mIsOnlyRunOnce) {
          return;
        }
        PreLoader.remove(this.mPreloadId);
        return;
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", response isn't expored! mPreloadExpiredTime " + this.mBasePreLoadTask.mPreloadExpiredTime);
      }
      PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", is not in mainThread");
    }
    catch (Exception paramOnTaskListener)
    {
      PreLoader.log(paramOnTaskListener);
      return;
    }
    this.mMainThreadHandler.post(new Worker.2(this, paramOnTaskListener, paramVarArgs));
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
    PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", set state to " + paramString);
  }
  
  public void doPreLoad()
  {
    if (this.mThreadPoolExecutor != null) {
      this.mThreadPoolExecutor.execute(this);
    }
    for (;;)
    {
      setState(State.Loading);
      return;
      mDefaultThreadPoolExecutor.execute(this);
    }
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
    PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", done but listener is null");
  }
  
  public void onRemove()
  {
    try
    {
      PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", on remove worker");
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
    PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", remove listener");
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
    StringBuilder localStringBuilder = new StringBuilder().append("id=").append(this.mPreloadId).append(", seq=").append(this.mSeq).append(", setListener listener ");
    if (paramOnTaskListener != null) {}
    for (boolean bool = true;; bool = false)
    {
      PreLoader.log(bool);
      if (paramOnTaskListener != null)
      {
        this.mOnCompleteListener = paramOnTaskListener;
        PreLoader.log("id=" + this.mPreloadId + ", seq=" + this.mSeq + ", cur state " + this.mState);
        if (State.Done.equals(this.mState)) {
          safeListenData(paramOnTaskListener, this.mResponse);
        }
      }
      return;
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