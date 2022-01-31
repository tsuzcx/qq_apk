package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

class OnSubscribeRefCount$1
  implements Action1<Subscription>
{
  OnSubscribeRefCount$1(OnSubscribeRefCount paramOnSubscribeRefCount, Subscriber paramSubscriber, AtomicBoolean paramAtomicBoolean) {}
  
  public void call(Subscription paramSubscription)
  {
    try
    {
      this.this$0.baseSubscription.add(paramSubscription);
      this.this$0.doSubscribe(this.val$subscriber, this.this$0.baseSubscription);
      return;
    }
    finally
    {
      this.this$0.lock.unlock();
      this.val$writeLocked.set(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRefCount.1
 * JD-Core Version:    0.7.0.1
 */