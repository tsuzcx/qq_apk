package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

public final class OnSubscribeTimerOnce
  implements Observable.OnSubscribe<Long>
{
  final Scheduler scheduler;
  final long time;
  final TimeUnit unit;
  
  public OnSubscribeTimerOnce(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.time = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
  }
  
  public void call(Subscriber<? super Long> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    paramSubscriber.add(localWorker);
    localWorker.schedule(new OnSubscribeTimerOnce.1(this, paramSubscriber), this.time, this.unit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeTimerOnce
 * JD-Core Version:    0.7.0.1
 */