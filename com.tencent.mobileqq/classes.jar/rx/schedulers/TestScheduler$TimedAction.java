package rx.schedulers;

import rx.Scheduler.Worker;
import rx.functions.Action0;

final class TestScheduler$TimedAction
{
  final Action0 action;
  private final long count;
  final Scheduler.Worker scheduler;
  final long time;
  
  TestScheduler$TimedAction(Scheduler.Worker paramWorker, long paramLong, Action0 paramAction0)
  {
    long l = TestScheduler.counter;
    TestScheduler.counter = 1L + l;
    this.count = l;
    this.time = paramLong;
    this.action = paramAction0;
    this.scheduler = paramWorker;
  }
  
  public String toString()
  {
    return String.format("TimedAction(time = %d, action = %s)", new Object[] { Long.valueOf(this.time), this.action.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.schedulers.TestScheduler.TimedAction
 * JD-Core Version:    0.7.0.1
 */