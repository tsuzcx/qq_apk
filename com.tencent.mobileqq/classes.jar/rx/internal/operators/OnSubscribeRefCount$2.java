package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.Subscriber;
import rx.subscriptions.CompositeSubscription;

class OnSubscribeRefCount$2
  extends Subscriber<T>
{
  OnSubscribeRefCount$2(OnSubscribeRefCount paramOnSubscribeRefCount, Subscriber paramSubscriber1, Subscriber paramSubscriber2, CompositeSubscription paramCompositeSubscription)
  {
    super(paramSubscriber1);
  }
  
  void cleanup()
  {
    this.this$0.lock.lock();
    try
    {
      if (this.this$0.baseSubscription == this.val$currentBase)
      {
        this.this$0.baseSubscription.unsubscribe();
        this.this$0.baseSubscription = new CompositeSubscription();
        this.this$0.subscriptionCount.set(0);
      }
      return;
    }
    finally
    {
      this.this$0.lock.unlock();
    }
  }
  
  public void onCompleted()
  {
    cleanup();
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    cleanup();
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$subscriber.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount.2
 * JD-Core Version:    0.7.0.1
 */