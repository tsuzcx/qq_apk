package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class OperatorReplay$3
  implements Observable.OnSubscribe<T>
{
  OperatorReplay$3(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    this.val$observable.unsafeSubscribe(new OperatorReplay.3.1(this, paramSubscriber, paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.3
 * JD-Core Version:    0.7.0.1
 */