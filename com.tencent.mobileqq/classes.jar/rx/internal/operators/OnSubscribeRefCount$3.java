package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

class OnSubscribeRefCount$3
  implements Action0
{
  OnSubscribeRefCount$3(OnSubscribeRefCount paramOnSubscribeRefCount, CompositeSubscription paramCompositeSubscription) {}
  
  public void call()
  {
    this.this$0.lock.lock();
    try
    {
      if ((this.this$0.baseSubscription == this.val$current) && (this.this$0.subscriptionCount.decrementAndGet() == 0))
      {
        this.this$0.baseSubscription.unsubscribe();
        this.this$0.baseSubscription = new CompositeSubscription();
      }
      return;
    }
    finally
    {
      this.this$0.lock.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount.3
 * JD-Core Version:    0.7.0.1
 */