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
      VasUpdateWrapper.getLog().e("ThreadManager", "new fixed thread pool failed: " + localThrowable.getMessage(), localThrowable);
      this.mRunnerExecutor = new ScheduledThreadPoolExecutor(5, new CommonThreadFactory("vas_update_system_exp"));
      this.mTimerExecutor = new ScheduledThreadPoolExecutor(2, new CommonThreadFactory("vas_update_system_timer"));
    }
  }
  
  /* Error */
  public static ThreadManager getInstance()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 82	com/tencent/vas/update/module/thread/ThreadManager:mInstance	Lcom/tencent/vas/update/module/thread/ThreadManager;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 82	com/tencent/vas/update/module/thread/ThreadManager:mInstance	Lcom/tencent/vas/update/module/thread/ThreadManager;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/vas/update/module/thread/ThreadManager
    //   21: dup
    //   22: invokespecial 83	com/tencent/vas/update/module/thread/ThreadManager:<init>	()V
    //   25: putstatic 82	com/tencent/vas/update/module/thread/ThreadManager:mInstance	Lcom/tencent/vas/update/module/thread/ThreadManager;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 82	com/tencent/vas/update/module/thread/ThreadManager:mInstance	Lcom/tencent/vas/update/module/thread/ThreadManager;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localThreadManager	ThreadManager
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
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
    if (paramInt == 2) {}
    for (ScheduledExecutorService localScheduledExecutorService = this.mTimerExecutor;; localScheduledExecutorService = this.mRunnerExecutor) {
      return localScheduledExecutorService.schedule(paramRunnable, paramLong, TimeUnit.MILLISECONDS);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.thread.ThreadManager
 * JD-Core Version:    0.7.0.1
 */