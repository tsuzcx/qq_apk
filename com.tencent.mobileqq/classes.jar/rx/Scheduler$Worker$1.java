package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Action0;
import rx.subscriptions.MultipleAssignmentSubscription;

class Scheduler$Worker$1
  implements Action0
{
  long count;
  long lastNowNanos = this.val$firstNowNanos;
  long startInNanos = this.val$firstStartInNanos;
  
  Scheduler$Worker$1(Scheduler.Worker paramWorker, long paramLong1, long paramLong2, MultipleAssignmentSubscription paramMultipleAssignmentSubscription, Action0 paramAction0, long paramLong3) {}
  
  public void call()
  {
    long l2;
    long l1;
    long l3;
    if (!this.val$mas.isUnsubscribed())
    {
      this.val$action.call();
      l2 = TimeUnit.MILLISECONDS.toNanos(this.this$0.now());
      if ((Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS + l2 >= this.lastNowNanos) && (l2 < this.lastNowNanos + this.val$periodInNanos + Scheduler.CLOCK_DRIFT_TOLERANCE_NANOS)) {
        break label129;
      }
      l1 = this.val$periodInNanos + l2;
      l3 = this.val$periodInNanos;
      long l4 = this.count + 1L;
      this.count = l4;
      this.startInNanos = (l1 - l3 * l4);
    }
    for (;;)
    {
      this.lastNowNanos = l2;
      this.val$mas.set(this.this$0.schedule(this, l1 - l2, TimeUnit.NANOSECONDS));
      return;
      label129:
      l1 = this.startInNanos;
      l3 = this.count + 1L;
      this.count = l3;
      l1 += l3 * this.val$periodInNanos;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Scheduler.Worker.1
 * JD-Core Version:    0.7.0.1
 */