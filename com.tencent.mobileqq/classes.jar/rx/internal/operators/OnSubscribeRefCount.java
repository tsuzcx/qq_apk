package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.observables.ConnectableObservable;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

public final class OnSubscribeRefCount<T>
  implements Observable.OnSubscribe<T>
{
  volatile CompositeSubscription baseSubscription = new CompositeSubscription();
  final ReentrantLock lock = new ReentrantLock();
  private final ConnectableObservable<? extends T> source;
  final AtomicInteger subscriptionCount = new AtomicInteger(0);
  
  public OnSubscribeRefCount(ConnectableObservable<? extends T> paramConnectableObservable)
  {
    this.source = paramConnectableObservable;
  }
  
  private Subscription disconnect(CompositeSubscription paramCompositeSubscription)
  {
    return Subscriptions.create(new OnSubscribeRefCount.3(this, paramCompositeSubscription));
  }
  
  private Action1<Subscription> onSubscribe(Subscriber<? super T> paramSubscriber, AtomicBoolean paramAtomicBoolean)
  {
    return new OnSubscribeRefCount.1(this, paramSubscriber, paramAtomicBoolean);
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    this.lock.lock();
    if (this.subscriptionCount.incrementAndGet() == 1)
    {
      AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
      try
      {
        this.source.connect(onSubscribe(paramSubscriber, localAtomicBoolean));
        return;
      }
      finally
      {
        if (localAtomicBoolean.get()) {
          this.lock.unlock();
        }
      }
    }
    try
    {
      doSubscribe(paramSubscriber, this.baseSubscription);
      return;
    }
    finally
    {
      this.lock.unlock();
    }
  }
  
  void doSubscribe(Subscriber<? super T> paramSubscriber, CompositeSubscription paramCompositeSubscription)
  {
    paramSubscriber.add(disconnect(paramCompositeSubscription));
    this.source.unsafeSubscribe(new OnSubscribeRefCount.2(this, paramSubscriber, paramSubscriber, paramCompositeSubscription));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount
 * JD-Core Version:    0.7.0.1
 */