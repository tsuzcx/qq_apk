package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.observables.ConnectableObservable;

final class OperatorReplay$2
  implements Observable.OnSubscribe<R>
{
  OperatorReplay$2(Func0 paramFunc0, Func1 paramFunc1) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    try
    {
      ConnectableObservable localConnectableObservable = (ConnectableObservable)this.val$connectableFactory.call();
      Observable localObservable = (Observable)this.val$selector.call(localConnectableObservable);
      localObservable.subscribe(paramSubscriber);
      localConnectableObservable.connect(new OperatorReplay.2.1(this, paramSubscriber));
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.2
 * JD-Core Version:    0.7.0.1
 */