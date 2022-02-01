package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.RefCountSubscription;

final class OnSubscribeGroupJoin$WindowObservableFunc<T>
  implements Observable.OnSubscribe<T>
{
  final RefCountSubscription refCount;
  final Observable<T> underlying;
  
  public OnSubscribeGroupJoin$WindowObservableFunc(Observable<T> paramObservable, RefCountSubscription paramRefCountSubscription)
  {
    this.refCount = paramRefCountSubscription;
    this.underlying = paramObservable;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Subscription localSubscription = this.refCount.get();
    paramSubscriber = new OnSubscribeGroupJoin.WindowObservableFunc.WindowSubscriber(this, paramSubscriber, localSubscription);
    paramSubscriber.add(localSubscription);
    this.underlying.unsafeSubscribe(paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin.WindowObservableFunc
 * JD-Core Version:    0.7.0.1
 */