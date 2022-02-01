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
    if ((this.scheduler instanceof ImmediateScheduler)) {}
    while ((this.scheduler instanceof TrampolineScheduler)) {
      return paramSubscriber;
    }
    paramSubscriber = new OperatorObserveOn.ObserveOnSubscriber(this.scheduler, paramSubscriber, this.delayError);
    paramSubscriber.init();
    return paramSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorObserveOn
 * JD-Core Version:    0.7.0.1
 */