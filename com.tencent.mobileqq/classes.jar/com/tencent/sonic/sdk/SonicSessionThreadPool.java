package com.tencent.sonic.sdk;

import android.support.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class SonicSessionThreadPool
{
  private static final String TAG = "SonicSdk_SonicSessionThreadPool";
  private static final SonicSessionThreadPool sInstance = new SonicSessionThreadPool();
  private final ExecutorService executorServiceImpl = new ThreadPoolExecutor(1, 6, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new SessionThreadFactory());
  
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
  
  private static class SessionThreadFactory
    implements ThreadFactory
  {
    private static final String NAME_PREFIX = "pool-sonic-session-thread-";
    private final ThreadGroup group;
    private final AtomicInteger threadNumber = new AtomicInteger(1);
    
    SessionThreadFactory()
    {
      Object localObject = System.getSecurityManager();
      if (localObject != null) {}
      for (localObject = ((SecurityManager)localObject).getThreadGroup();; localObject = Thread.currentThread().getThreadGroup())
      {
        this.group = ((ThreadGroup)localObject);
        return;
      }
    }
    
    public Thread newThread(@NonNull Runnable paramRunnable)
    {
      paramRunnable = new Thread(this.group, paramRunnable, "pool-sonic-session-thread-" + this.threadNumber.getAndIncrement(), 0L);
      if (paramRunnable.isDaemon()) {
        paramRunnable.setDaemon(false);
      }
      if (paramRunnable.getPriority() != 5) {
        paramRunnable.setPriority(5);
      }
      return paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicSessionThreadPool
 * JD-Core Version:    0.7.0.1
 */