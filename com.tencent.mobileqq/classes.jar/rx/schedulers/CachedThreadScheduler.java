package rx.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.internal.schedulers.SchedulerLifecycle;
import rx.internal.util.RxThreadFactory;

final class CachedThreadScheduler
  extends Scheduler
  implements SchedulerLifecycle
{
  static final RxThreadFactory EVICTOR_THREAD_FACTORY;
  private static final String EVICTOR_THREAD_NAME_PREFIX = "RxCachedWorkerPoolEvictor-";
  private static final long KEEP_ALIVE_TIME = 60L;
  private static final TimeUnit KEEP_ALIVE_UNIT;
  static final CachedThreadScheduler.CachedWorkerPool NONE;
  static final CachedThreadScheduler.ThreadWorker SHUTDOWN_THREADWORKER;
  static final RxThreadFactory WORKER_THREAD_FACTORY = new RxThreadFactory("RxCachedThreadScheduler-");
  private static final String WORKER_THREAD_NAME_PREFIX = "RxCachedThreadScheduler-";
  final AtomicReference<CachedThreadScheduler.CachedWorkerPool> pool = new AtomicReference(NONE);
  
  static
  {
    EVICTOR_THREAD_FACTORY = new RxThreadFactory("RxCachedWorkerPoolEvictor-");
    KEEP_ALIVE_UNIT = TimeUnit.SECONDS;
    SHUTDOWN_THREADWORKER = new CachedThreadScheduler.ThreadWorker(new RxThreadFactory("RxCachedThreadSchedulerShutdown-"));
    SHUTDOWN_THREADWORKER.unsubscribe();
    NONE = new CachedThreadScheduler.CachedWorkerPool(0L, null);
    NONE.shutdown();
  }
  
  public CachedThreadScheduler()
  {
    start();
  }
  
  public Scheduler.Worker createWorker()
  {
    return new CachedThreadScheduler.EventLoopWorker((CachedThreadScheduler.CachedWorkerPool)this.pool.get());
  }
  
  public void shutdown()
  {
    CachedThreadScheduler.CachedWorkerPool localCachedWorkerPool;
    do
    {
      localCachedWorkerPool = (CachedThreadScheduler.CachedWorkerPool)this.pool.get();
      if (localCachedWorkerPool == NONE) {
        return;
      }
    } while (!this.pool.compareAndSet(localCachedWorkerPool, NONE));
    localCachedWorkerPool.shutdown();
  }
  
  public void start()
  {
    CachedThreadScheduler.CachedWorkerPool localCachedWorkerPool = new CachedThreadScheduler.CachedWorkerPool(60L, KEEP_ALIVE_UNIT);
    if (!this.pool.compareAndSet(NONE, localCachedWorkerPool)) {
      localCachedWorkerPool.shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.schedulers.CachedThreadScheduler
 * JD-Core Version:    0.7.0.1
 */