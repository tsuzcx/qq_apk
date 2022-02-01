package rx.schedulers;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

class ImmediateScheduler$InnerImmediateScheduler
  extends Scheduler.Worker
  implements Subscription
{
  final BooleanSubscription innerSubscription = new BooleanSubscription();
  
  ImmediateScheduler$InnerImmediateScheduler(ImmediateScheduler paramImmediateScheduler) {}
  
  public boolean isUnsubscribed()
  {
    return this.innerSubscription.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    paramAction0.call();
    return Subscriptions.unsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    return schedule(new SleepingAction(paramAction0, this, this.this$0.now() + paramTimeUnit.toMillis(paramLong)));
  }
  
  public void unsubscribe()
  {
    this.innerSubscription.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.schedulers.ImmediateScheduler.InnerImmediateScheduler
 * JD-Core Version:    0.7.0.1
 */