package com.tencent.vas.update.module.thread;

import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.wrapper.VasUpdateWrapper;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadManager
{
  private static final int MAX_RUNNING_THREAD = 5;
  private static final int MAX_TIMER_THREAD = 2;
  private static final String TAG = "VasUpdate_ThreadManager";
  public static final int TYPE_DOWNLOAD = 1;
  public static final int TYPE_TIMER = 2;
  public static ThreadManager mInstance;
  private ScheduledExecutorService mRunnerExecutor;
  private ScheduledExecutorService mTimerExecutor;
  
  private ThreadManager()
  {
    try
    {
      this.mRunnerExecutor = new ScheduledThreadPoolExecutor(5, new CommonThreadFactory("vas_update_system_download"));
      this.mTimerExecutor = new ScheduledThreadPoolExecutor(2, new CommonThreadFactory("vas_update_system_timer"));
      return;
    }
    catch (Throwable localThrowable)
    {
      IVasLog localIVasLog = VasUpdateWrapper.getLog();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("new fixed thread pool failed: ");
      localStringBuilder.append(localThrowable.getMessage());
      localIVasLog.e("ThreadManager", localStringBuilder.toString(), localThrowable);
      this.mRunnerExecutor = new ScheduledThreadPoolExecutor(5, new CommonThreadFactory("vas_update_system_exp"));
      this.mTimerExecutor = new ScheduledThreadPoolExecutor(2, new CommonThreadFactory("vas_update_system_timer"));
    }
  }
  
  public static ThreadManager getInstance()
  {
    try
    {
      if (mInstance == null) {
        try
        {
          if (mInstance == null) {
            mInstance = new ThreadManager();
          }
        }
        finally {}
      }
      ThreadManager localThreadManager = mInstance;
      return localThreadManager;
    }
    finally {}
  }
  
  public void onDestory()
  {
    this.mRunnerExecutor.shutdownNow();
    this.mTimerExecutor.shutdownNow();
    mInstance = null;
  }
  
  public void post(int paramInt, Runnable paramRunnable)
  {
    if (paramInt == 1)
    {
      post(paramRunnable);
      return;
    }
    this.mTimerExecutor.submit(paramRunnable);
  }
  
  public void post(Runnable paramRunnable)
  {
    try
    {
      this.mRunnerExecutor.submit(paramRunnable);
      return;
    }
    catch (Throwable paramRunnable) {}
  }
  
  public ScheduledFuture postDelay(int paramInt, Runnable paramRunnable, long paramLong)
  {
    ScheduledExecutorService localScheduledExecutorService;
    if (paramInt == 2) {
      localScheduledExecutorService = this.mTimerExecutor;
    } else {
      localScheduledExecutorService = this.mRunnerExecutor;
    }
    return localScheduledExecutorService.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */