package rx.schedulers;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.functions.Action0;

public class TestScheduler
  extends Scheduler
{
  static long counter;
  final Queue<TestScheduler.TimedAction> queue = new PriorityQueue(11, new TestScheduler.CompareActionsByTime());
  long time;
  
  private void triggerActions(long paramLong)
  {
    while (!this.queue.isEmpty())
    {
      TestScheduler.TimedAction localTimedAction = (TestScheduler.TimedAction)this.queue.peek();
      if (localTimedAction.time > paramLong) {
        break;
      }
      long l;
      if (localTimedAction.time == 0L) {
        l = this.time;
      } else {
        l = localTimedAction.time;
      }
      this.time = l;
      this.queue.remove();
      if (!localTimedAction.scheduler.isUnsubscribed()) {
        localTimedAction.action.call();
      }
    }
    this.time = paramLong;
  }
  
  public void advanceTimeBy(long paramLong, TimeUnit paramTimeUnit)
  {
    advanceTimeTo(this.time + paramTimeUnit.toNanos(paramLong), TimeUnit.NANOSECONDS);
  }
  
  public void advanceTimeTo(long paramLong, TimeUnit paramTimeUnit)
  {
    triggerActions(paramTimeUnit.toNanos(paramLong));
  }
  
  public Scheduler.Worker createWorker()
  {
    return new TestScheduler.InnerTestScheduler(this);
  }
  
  public long now()
  {
    return TimeUnit.NANOSECONDS.toMillis(this.time);
  }
  
  public void triggerActions()
  {
    triggerActions(this.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.TestScheduler
 * JD-Core Version:    0.7.0.1
 */