package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

class EventLoopsScheduler$EventLoopWorker
  extends Scheduler.Worker
{
  private final SubscriptionList both = new SubscriptionList(new Subscription[] { this.serial, this.timed });
  private final EventLoopsScheduler.PoolWorker poolWorker;
  private final SubscriptionList serial = new SubscriptionList();
  private final CompositeSubscription timed = new CompositeSubscription();
  
  EventLoopsScheduler$EventLoopWorker(EventLoopsScheduler.PoolWorker paramPoolWorker)
  {
    this.poolWorker = paramPoolWorker;
  }
  
  public boolean isUnsubscribed()
  {
    return this.both.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    if (isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    return this.poolWorker.scheduleActual(paramAction0, 0L, null, this.serial);
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    return this.poolWorker.scheduleActual(paramAction0, paramLong, paramTimeUnit, this.timed);
  }
  
  public void unsubscribe()
  {
    this.both.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.schedulers.EventLoopsScheduler.EventLoopWorker
 * JD-Core Version:    0.7.0.1
 */