package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;

public final class OperatorWindowWithTime<T>
  implements Observable.Operator<Observable<T>, T>
{
  static final Object NEXT_SUBJECT = new Object();
  static final NotificationLite<Object> nl = NotificationLite.instance();
  final Scheduler scheduler;
  final int size;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorWindowWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    this.timespan = paramLong1;
    this.timeshift = paramLong2;
    this.unit = paramTimeUnit;
    this.size = paramInt;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    if (this.timespan == this.timeshift)
    {
      paramSubscriber = new OperatorWindowWithTime.ExactSubscriber(this, paramSubscriber, localWorker);
      paramSubscriber.add(localWorker);
      paramSubscriber.scheduleExact();
      return paramSubscriber;
    }
    paramSubscriber = new OperatorWindowWithTime.InexactSubscriber(this, paramSubscriber, localWorker);
    paramSubscriber.add(localWorker);
    paramSubscriber.startNewChunk();
    paramSubscriber.scheduleChunk();
    return paramSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime
 * JD-Core Version:    0.7.0.1
 */