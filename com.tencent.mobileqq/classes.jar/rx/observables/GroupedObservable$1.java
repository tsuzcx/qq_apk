package rx.observables;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;

final class GroupedObservable$1
  implements Observable.OnSubscribe<T>
{
  GroupedObservable$1(Observable paramObservable) {}
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    this.val$o.unsafeSubscribe(paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observables.GroupedObservable.1
 * JD-Core Version:    0.7.0.1
 */