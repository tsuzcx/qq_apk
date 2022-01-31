package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;

public final class OperatorTakeLastTimed<T>
  implements Observable.Operator<T, T>
{
  final long ageMillis;
  final int count;
  final Scheduler scheduler;
  
  public OperatorTakeLastTimed(int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    if (paramInt < 0) {
      throw new IndexOutOfBoundsException("count could not be negative");
    }
    this.ageMillis = paramTimeUnit.toMillis(paramLong);
    this.scheduler = paramScheduler;
    this.count = paramInt;
  }
  
  public OperatorTakeLastTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.ageMillis = paramTimeUnit.toMillis(paramLong);
    this.scheduler = paramScheduler;
    this.count = -1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ArrayDeque localArrayDeque1 = new ArrayDeque();
    ArrayDeque localArrayDeque2 = new ArrayDeque();
    NotificationLite localNotificationLite = NotificationLite.instance();
    TakeLastQueueProducer localTakeLastQueueProducer = new TakeLastQueueProducer(localNotificationLite, localArrayDeque1, paramSubscriber);
    paramSubscriber.setProducer(localTakeLastQueueProducer);
    return new OperatorTakeLastTimed.1(this, paramSubscriber, localArrayDeque1, localArrayDeque2, localNotificationLite, paramSubscriber, localTakeLastQueueProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLastTimed
 * JD-Core Version:    0.7.0.1
 */