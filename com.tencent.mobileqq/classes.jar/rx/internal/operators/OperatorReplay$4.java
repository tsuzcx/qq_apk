package rx.internal.operators;

import rx.Observable.OnSubscribe;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;

final class OperatorReplay$4
  extends ConnectableObservable<T>
{
  OperatorReplay$4(Observable.OnSubscribe paramOnSubscribe, ConnectableObservable paramConnectableObservable)
  {
    super(paramOnSubscribe);
  }
  
  public void connect(Action1<? super Subscription> paramAction1)
  {
    this.val$co.connect(paramAction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.4
 * JD-Core Version:    0.7.0.1
 */