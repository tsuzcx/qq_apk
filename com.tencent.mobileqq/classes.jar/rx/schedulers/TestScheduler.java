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
  static long counter = 0L;
  final Queue<TestScheduler.TimedAction> queue = new PriorityQueue(11, new TestScheduler.CompareActionsByTime());
  long time;
  
  private void triggerActions(long paramLong)
  {
    TestScheduler.TimedAction localTimedAction;
    if (!this.queue.isEmpty())
    {
      localTimedAction = (TestScheduler.TimedAction)this.queue.peek();
      if (localTimedAction.time <= paramLong) {}
    }
    else
    {
      this.time = paramLong;
      return;
    }
    if (localTimedAction.time == 0L) {}
    for (long l = this.time;; l = localTimedAction.time)
    {
      this.time = l;
      this.queue.remove();
      if (localTimedAction.scheduler.isUnsubscribed()) {
        break;
      }
      localTimedAction.action.call();
      break;
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.schedulers.TestScheduler
 * JD-Core Version:    0.7.0.1
 */