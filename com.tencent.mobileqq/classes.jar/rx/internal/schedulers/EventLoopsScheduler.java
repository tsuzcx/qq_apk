package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.RxThreadFactory;

public class EventLoopsScheduler
  extends Scheduler
  implements SchedulerLifecycle
{
  static final String KEY_MAX_THREADS = "rx.scheduler.max-computation-threads";
  static final int MAX_THREADS;
  static final EventLoopsScheduler.FixedSchedulerPool NONE = new EventLoopsScheduler.FixedSchedulerPool(0);
  static final EventLoopsScheduler.PoolWorker SHUTDOWN_WORKER;
  static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxComputationThreadPool-");
  private static final String THREAD_NAME_PREFIX = "RxComputationThreadPool-";
  final AtomicReference<EventLoopsScheduler.FixedSchedulerPool> pool = new AtomicReference(NONE);
  
  static
  {
    int j = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
    int k = Runtime.getRuntime().availableProcessors();
    int i;
    if (j > 0)
    {
      i = j;
      if (j <= k) {}
    }
    else
    {
      i = k;
    }
    MAX_THREADS = i;
    SHUTDOWN_WORKER = new EventLoopsScheduler.PoolWorker(new RxThreadFactory("RxComputationShutdown-"));
    SHUTDOWN_WORKER.unsubscribe();
  }
  
  public EventLoopsScheduler()
  {
    start();
  }
  
  public Scheduler.Worker createWorker()
  {
    return new EventLoopsScheduler.EventLoopWorker(((EventLoopsScheduler.FixedSchedulerPool)this.pool.get()).getEventLoop());
  }
  
  public Subscription scheduleDirect(Action0 paramAction0)
  {
    return ((EventLoopsScheduler.FixedSchedulerPool)this.pool.get()).getEventLoop().scheduleActual(paramAction0, -1L, TimeUnit.NANOSECONDS);
  }
  
  public void shutdown()
  {
    EventLoopsScheduler.FixedSchedulerPool localFixedSchedulerPool;
    do
    {
      localFixedSchedulerPool = (EventLoopsScheduler.FixedSchedulerPool)this.pool.get();
      if (localFixedSchedulerPool == NONE) {
        return;
      }
    } while (!this.pool.compareAndSet(localFixedSchedulerPool, NONE));
    localFixedSchedulerPool.shutdown();
  }
  
  public void start()
  {
    EventLoopsScheduler.FixedSchedulerPool localFixedSchedulerPool = new EventLoopsScheduler.FixedSchedulerPool(MAX_THREADS);
    if (!this.pool.compareAndSet(NONE, localFixedSchedulerPool)) {
      localFixedSchedulerPool.shutdown();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.schedulers.EventLoopsScheduler
 * JD-Core Version:    0.7.0.1
 */