package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.observers.Subscribers;

public final class OnSubscribeAutoConnect<T>
  implements Observable.OnSubscribe<T>
{
  final AtomicInteger clients;
  final Action1<? super Subscription> connection;
  final int numberOfSubscribers;
  final ConnectableObservable<? extends T> source;
  
  public OnSubscribeAutoConnect(ConnectableObservable<? extends T> paramConnectableObservable, int paramInt, Action1<? super Subscription> paramAction1)
  {
    if (paramInt > 0)
    {
      this.source = paramConnectableObservable;
      this.numberOfSubscribers = paramInt;
      this.connection = paramAction1;
      this.clients = new AtomicInteger();
      return;
    }
    throw new IllegalArgumentException("numberOfSubscribers > 0 required");
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    this.source.unsafeSubscribe(Subscribers.wrap(paramSubscriber));
    if (this.clients.incrementAndGet() == this.numberOfSubscribers) {
      this.source.connect(this.connection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeAutoConnect
 * JD-Core Version:    0.7.0.1
 */