package rx.internal.operators;

import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.ImmediateScheduler;
import rx.schedulers.TrampolineScheduler;

public final class OperatorObserveOn<T>
  implements Observable.Operator<T, T>
{
  private final boolean delayError;
  private final Scheduler scheduler;
  
  public OperatorObserveOn(Scheduler paramScheduler, boolean paramBoolean)
  {
    this.scheduler = paramScheduler;
    this.delayError = paramBoolean;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler localScheduler = this.scheduler;
    if ((localScheduler instanceof ImmediateScheduler)) {
      return paramSubscriber;
    }
    if ((localScheduler instanceof TrampolineScheduler)) {
      return paramSubscriber;
    }
    paramSubscriber = new OperatorObserveOn.ObserveOnSubscriber(localScheduler, paramSubscriber, this.delayError);
    paramSubscriber.init();
    return paramSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorObserveOn
 * JD-Core Version:    0.7.0.1
 */