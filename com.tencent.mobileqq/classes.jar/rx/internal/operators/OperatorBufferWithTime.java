package rx.internal.operators;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;

public final class OperatorBufferWithTime<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final Scheduler scheduler;
  final long timeshift;
  final long timespan;
  final TimeUnit unit;
  
  public OperatorBufferWithTime(long paramLong1, long paramLong2, TimeUnit paramTimeUnit, int paramInt, Scheduler paramScheduler)
  {
    this.timespan = paramLong1;
    this.timeshift = paramLong2;
    this.unit = paramTimeUnit;
    this.count = paramInt;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    Object localObject = new SerializedSubscriber(paramSubscriber);
    if (this.timespan == this.timeshift)
    {
      localObject = new OperatorBufferWithTime.ExactSubscriber(this, (Subscriber)localObject, localWorker);
      ((OperatorBufferWithTime.ExactSubscriber)localObject).add(localWorker);
      paramSubscriber.add((Subscription)localObject);
      ((OperatorBufferWithTime.ExactSubscriber)localObject).scheduleExact();
      return localObject;
    }
    localObject = new OperatorBufferWithTime.InexactSubscriber(this, (Subscriber)localObject, localWorker);
    ((OperatorBufferWithTime.InexactSubscriber)localObject).add(localWorker);
    paramSubscriber.add((Subscription)localObject);
    ((OperatorBufferWithTime.InexactSubscriber)localObject).startNewChunk();
    ((OperatorBufferWithTime.InexactSubscriber)localObject).scheduleChunk();
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithTime
 * JD-Core Version:    0.7.0.1
 */