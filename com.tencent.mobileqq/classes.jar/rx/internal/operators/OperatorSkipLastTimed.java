package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;

public class OperatorSkipLastTimed<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  final long timeInMillis;
  
  public OperatorSkipLastTimed(long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler)
  {
    this.timeInMillis = paramTimeUnit.toMillis(paramLong);
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorSkipLastTimed.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipLastTimed
 * JD-Core Version:    0.7.0.1
 */