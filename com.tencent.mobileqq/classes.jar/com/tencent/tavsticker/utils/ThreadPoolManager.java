package com.tencent.tavsticker.utils;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolManager
{
  private static final int MAX_RUNNING_THREAD = 5;
  private static volatile ThreadPoolManager _instance;
  private ScheduledExecutorService executor = null;
  
  private ThreadPoolManager()
  {
    try
    {
      this.executor = Executors.newScheduledThreadPool(5, new ThreadPoolManager.CommonThreadFactory("ThreadPool"));
      return;
    }
    catch (Throwable localThrowable)
    {
      label27:
      break label27;
    }
    this.executor = Executors.newScheduledThreadPool(5, new ThreadPoolManager.CommonThreadFactory("ThreadPool"));
  }
  
  public static ThreadPoolManager get()
  {
    if (_instance == null) {
      try
      {
        if (_instance == null) {
          _instance = new ThreadPoolManager();
        }
      }
      finally {}
    }
    return _instance;
  }
  
  public void start(Runnable paramRunnable)
  {
    ScheduledExecutorService localScheduledExecutorService = this.executor;
    if (localScheduledExecutorService != null)
    {
      paramRunnable = localScheduledExecutorService.submit(paramRunnable);
      try
      {
        paramRunnable.get();
        return;
      }
      catch (Throwable paramRunnable)
      {
        paramRunnable.printStackTrace();
        return;
      }
      catch (ExecutionException paramRunnable)
      {
        paramRunnable.printStackTrace();
        return;
      }
      catch (InterruptedException paramRunnable)
      {
        paramRunnable.printStackTrace();
      }
    }
  }
  
  public void startDelayed(Runnable paramRunnable, long paramLong)
  {
    ScheduledExecutorService localScheduledExecutorService = this.executor;
    if (localScheduledExecutorService != null) {
      localScheduledExecutorService.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.utils.ThreadPoolManager
 * JD-Core Version:    0.7.0.1
 */