package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;

public final class OperatorTimeout<T>
  extends OperatorTimeoutBase<T>
{
  public OperatorTimeout(long paramLong, TimeUnit paramTimeUnit, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    super(new OperatorTimeout.1(paramLong, paramTimeUnit), new OperatorTimeout.2(paramLong, paramTimeUnit), paramObservable, paramScheduler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeout
 * JD-Core Version:    0.7.0.1
 */