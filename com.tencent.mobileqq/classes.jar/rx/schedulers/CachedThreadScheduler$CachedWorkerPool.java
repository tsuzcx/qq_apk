package rx.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import rx.internal.schedulers.NewThreadWorker;
import rx.subscriptions.CompositeSubscription;

final class CachedThreadScheduler$CachedWorkerPool
{
  private final CompositeSubscription allWorkers;
  private final ScheduledExecutorService evictorService;
  private final Future<?> evictorTask;
  private final ConcurrentLinkedQueue<CachedThreadScheduler.ThreadWorker> expiringWorkerQueue;
  private final long keepAliveTime;
  
  CachedThreadScheduler$CachedWorkerPool(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramTimeUnit != null) {
      paramLong = paramTimeUnit.toNanos(paramLong);
    } else {
      paramLong = 0L;
    }
    this.keepAliveTime = paramLong;
    this.expiringWorkerQueue = new ConcurrentLinkedQueue();
    this.allWorkers = new CompositeSubscription();
    Object localObject2 = null;
    Object localObject1;
    if (paramTimeUnit != null)
    {
      paramTimeUnit = Executors.newScheduledThreadPool(1, CachedThreadScheduler.EVICTOR_THREAD_FACTORY);
      NewThreadWorker.tryEnableCancelPolicy(paramTimeUnit);
      localObject1 = new CachedThreadScheduler.CachedWorkerPool.1(this);
      paramLong = this.keepAliveTime;
      localObject1 = paramTimeUnit.scheduleWithFixedDelay((Runnable)localObject1, paramLong, paramLong, TimeUnit.NANOSECONDS);
    }
    else
    {
      localObject1 = null;
      paramTimeUnit = localObject2;
    }
    this.evictorService = paramTimeUnit;
    this.evictorTask = ((Future)localObject1);
  }
  
  void evictExpiredWorkers()
  {
    if (!this.expiringWorkerQueue.isEmpty())
    {
      long l = now();
      Iterator localIterator = this.expiringWorkerQueue.iterator();
      while (localIterator.hasNext())
      {
        CachedThreadScheduler.ThreadWorker localThreadWorker = (CachedThreadScheduler.ThreadWorker)localIterator.next();
        if (localThreadWorker.getExpirationTime() > l) {
          break;
        }
        if (this.expiringWorkerQueue.remove(localThreadWorker)) {
          this.allWorkers.remove(localThreadWorker);
        }
      }
    }
  }
  
  CachedThreadScheduler.ThreadWorker get()
  {
    if (this.allWorkers.isUnsubscribed()) {
      return CachedThreadScheduler.SHUTDOWN_THREADWORKER;
    }
    while (!this.expiringWorkerQueue.isEmpty())
    {
      localThreadWorker = (CachedThreadScheduler.ThreadWorker)this.expiringWorkerQueue.poll();
      if (localThreadWorker != null) {
        return localThreadWorker;
      }
    }
    CachedThreadScheduler.ThreadWorker localThreadWorker = new CachedThreadScheduler.ThreadWorker(CachedThreadScheduler.WORKER_THREAD_FACTORY);
    this.allWorkers.add(localThreadWorker);
    return localThreadWorker;
  }
  
  long now()
  {
    return System.nanoTime();
  }
  
  void release(CachedThreadScheduler.ThreadWorker paramThreadWorker)
  {
    paramThreadWorker.setExpirationTime(now() + this.keepAliveTime);
    this.expiringWorkerQueue.offer(paramThreadWorker);
  }
  
  void shutdown()
  {
    try
    {
      if (this.evictorTask != null) {
        this.evictorTask.cancel(true);
      }
      if (this.evictorService != null) {
        this.evictorService.shutdownNow();
      }
      return;
    }
    finally
    {
      this.allWorkers.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.CachedWorkerPool
 * JD-Core Version:    0.7.0.1
 */