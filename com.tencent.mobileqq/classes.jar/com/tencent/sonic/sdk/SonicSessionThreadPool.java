package com.tencent.sonic.sdk;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class SonicSessionThreadPool
{
  private static final String TAG = "SonicSdk_SonicSessionThreadPool";
  private static final SonicSessionThreadPool sInstance = new SonicSessionThreadPool();
  private final ExecutorService executorServiceImpl = new ThreadPoolExecutor(1, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new SonicSessionThreadPool.SessionThreadFactory());
  
  private boolean execute(Runnable paramRunnable)
  {
    try
    {
      this.executorServiceImpl.execute(paramRunnable);
      return true;
    }
    catch (Throwable paramRunnable)
    {
      SonicUtils.log("SonicSdk_SonicSessionThreadPool", 6, "execute task error:" + paramRunnable.getMessage());
    }
    return false;
  }
  
  static boolean postTask(Runnable paramRunnable)
  {
    return sInstance.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionThreadPool
 * JD-Core Version:    0.7.0.1
 */