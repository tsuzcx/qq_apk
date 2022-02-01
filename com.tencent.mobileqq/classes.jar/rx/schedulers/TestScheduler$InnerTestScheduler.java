package rx.schedulers;

import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.subscriptions.BooleanSubscription;
import rx.subscriptions.Subscriptions;

final class TestScheduler$InnerTestScheduler
  extends Scheduler.Worker
{
  private final BooleanSubscription s = new BooleanSubscription();
  
  TestScheduler$InnerTestScheduler(TestScheduler paramTestScheduler) {}
  
  public boolean isUnsubscribed()
  {
    return this.s.isUnsubscribed();
  }
  
  public long now()
  {
    return this.this$0.now();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    paramAction0 = new TestScheduler.TimedAction(this, 0L, paramAction0);
    this.this$0.queue.add(paramAction0);
    return Subscriptions.create(new TestScheduler.InnerTestScheduler.2(this, paramAction0));
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    paramAction0 = new TestScheduler.TimedAction(this, this.this$0.time + paramTimeUnit.toNanos(paramLong), paramAction0);
    this.this$0.queue.add(paramAction0);
    return Subscriptions.create(new TestScheduler.InnerTestScheduler.1(this, paramAction0));
  }
  
  public void unsubscribe()
  {
    this.s.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.schedulers.TestScheduler.InnerTestScheduler
 * JD-Core Version:    0.7.0.1
 */