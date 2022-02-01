package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;

public abstract class Scheduler$Worker
  implements Subscription
{
  public long now()
  {
    return System.currentTimeMillis();
  }
  
  public abstract Subscription schedule(Action0 paramAction0);
  
  public abstract Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit);
  
  public Subscription schedulePeriodically(Action0 paramAction0, long paramLong1, long paramLong2, TimeUnit paramTimeUnit)
  {
    paramLong2 = paramTimeUnit.toNanos(paramLong2);
    long l1 = TimeUnit.MILLISECONDS.toNanos(now());
    long l2 = paramTimeUnit.toNanos(paramLong1);
    MultipleAssignmentSubscription localMultipleAssignmentSubscription1 = new MultipleAssignmentSubscription();
    paramAction0 = new Scheduler.Worker.1(this, l1, l1 + l2, localMultipleAssignmentSubscription1, paramAction0, paramLong2);
    MultipleAssignmentSubscription localMultipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
    localMultipleAssignmentSubscription1.set(localMultipleAssignmentSubscription2);
    localMultipleAssignmentSubscription2.set(schedule(paramAction0, paramLong1, paramTimeUnit));
    return localMultipleAssignmentSubscription1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Scheduler.Worker
 * JD-Core Version:    0.7.0.1
 */