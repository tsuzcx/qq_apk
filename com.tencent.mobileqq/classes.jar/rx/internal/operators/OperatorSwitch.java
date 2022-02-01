package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSwitch<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  final boolean delayError;
  
  OperatorSwitch(boolean paramBoolean)
  {
    this.delayError = paramBoolean;
  }
  
  public static <T> OperatorSwitch<T> instance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return OperatorSwitch.HolderDelayError.INSTANCE;
    }
    return OperatorSwitch.Holder.INSTANCE;
  }
  
  public Subscriber<? super Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorSwitch.SwitchSubscriber localSwitchSubscriber = new OperatorSwitch.SwitchSubscriber(paramSubscriber, this.delayError);
    paramSubscriber.add(localSwitchSubscriber);
    localSwitchSubscriber.init();
    return localSwitchSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSwitch
 * JD-Core Version:    0.7.0.1
 */