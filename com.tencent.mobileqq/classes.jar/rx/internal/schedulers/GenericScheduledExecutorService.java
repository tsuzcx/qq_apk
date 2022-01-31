package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;
import rx.internal.util.RxThreadFactory;

public final class GenericScheduledExecutorService
  implements SchedulerLifecycle
{
  public static final GenericScheduledExecutorService INSTANCE = new GenericScheduledExecutorService();
  private static final ScheduledExecutorService[] NONE;
  private static final ScheduledExecutorService SHUTDOWN;
  private static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxScheduledExecutorPool-");
  private static final String THREAD_NAME_PREFIX = "RxScheduledExecutorPool-";
  private static int roundRobin;
  private final AtomicReference<ScheduledExecutorService[]> executor = new AtomicReference(NONE);
  
  static
  {
    NONE = new ScheduledExecutorService[0];
    SHUTDOWN = Executors.newScheduledThreadPool(0);
    SHUTDOWN.shutdown();
  }
  
  private GenericScheduledExecutorService()
  {
    start();
  }
  
  public static ScheduledExecutorService getInstance()
  {
    ScheduledExecutorService[] arrayOfScheduledExecutorService = (ScheduledExecutorService[])INSTANCE.executor.get();
    if (arrayOfScheduledExecutorService == NONE) {
      return SHUTDOWN;
    }
    int j = roundRobin + 1;
    int i = j;
    if (j >= arrayOfScheduledExecutorService.length) {
      i = 0;
    }
    roundRobin = i;
    return arrayOfScheduledExecutorService[i];
  }
  
  public void shutdown()
  {
    ScheduledExecutorService[] arrayOfScheduledExecutorService = (ScheduledExecutorService[])this.executor.get();
    if (arrayOfScheduledExecutorService == NONE) {}
    for (;;)
    {
      return;
      if (!this.executor.compareAndSet(arrayOfScheduledExecutorService, NONE)) {
        break;
      }
      int j = arrayOfScheduledExecutorService.length;
      int i = 0;
      while (i < j)
      {
        ScheduledExecutorService localScheduledExecutorService = arrayOfScheduledExecutorService[i];
        NewThreadWorker.deregisterExecutor(localScheduledExecutorService);
        localScheduledExecutorService.shutdownNow();
        i += 1;
      }
    }
  }
  
  public void start()
  {
    int j = 8;
    int k = 0;
    int m = Runtime.getRuntime().availableProcessors();
    int i = m;
    if (m > 4) {
      i = m / 2;
    }
    if (i > 8) {
      i = j;
    }
    for (;;)
    {
      ScheduledExecutorService[] arrayOfScheduledExecutorService = new ScheduledExecutorService[i];
      j = 0;
      while (j < i)
      {
        arrayOfScheduledExecutorService[j] = Executors.newScheduledThreadPool(1, THREAD_FACTORY);
        j += 1;
      }
      if (this.executor.compareAndSet(NONE, arrayOfScheduledExecutorService))
      {
        j = arrayOfScheduledExecutorService.length;
        i = k;
        while (i < j)
        {
          ScheduledExecutorService localScheduledExecutorService = arrayOfScheduledExecutorService[i];
          if ((!NewThreadWorker.tryEnableCancelPolicy(localScheduledExecutorService)) && ((localScheduledExecutorService instanceof ScheduledThreadPoolExecutor))) {
            NewThreadWorker.registerExecutor((ScheduledThreadPoolExecutor)localScheduledExecutorService);
          }
          i += 1;
        }
      }
      j = arrayOfScheduledExecutorService.length;
      i = 0;
      while (i < j)
      {
        arrayOfScheduledExecutorService[i].shutdownNow();
        i += 1;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.schedulers.GenericScheduledExecutorService
 * JD-Core Version:    0.7.0.1
 */