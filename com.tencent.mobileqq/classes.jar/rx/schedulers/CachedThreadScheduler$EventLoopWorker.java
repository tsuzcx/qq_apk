package rx.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

final class CachedThreadScheduler$EventLoopWorker
  extends Scheduler.Worker
{
  static final AtomicIntegerFieldUpdater<EventLoopWorker> ONCE_UPDATER = AtomicIntegerFieldUpdater.newUpdater(EventLoopWorker.class, "once");
  private final CompositeSubscription innerSubscription = new CompositeSubscription();
  volatile int once;
  private final CachedThreadScheduler.CachedWorkerPool pool;
  private final CachedThreadScheduler.ThreadWorker threadWorker;
  
  CachedThreadScheduler$EventLoopWorker(CachedThreadScheduler.CachedWorkerPool paramCachedWorkerPool)
  {
    this.pool = paramCachedWorkerPool;
    this.threadWorker = paramCachedWorkerPool.get();
  }
  
  public boolean isUnsubscribed()
  {
    return this.innerSubscription.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    return schedule(paramAction0, 0L, null);
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.innerSubscription.isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    paramAction0 = this.threadWorker.scheduleActual(paramAction0, paramLong, paramTimeUnit);
    this.innerSubscription.add(paramAction0);
    paramAction0.addParent(this.innerSubscription);
    return paramAction0;
  }
  
  public void unsubscribe()
  {
    if (ONCE_UPDATER.compareAndSet(this, 0, 1)) {
      this.pool.release(this.threadWorker);
    }
    this.innerSubscription.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.CachedThreadScheduler.EventLoopWorker
 * JD-Core Version:    0.7.0.1
 */