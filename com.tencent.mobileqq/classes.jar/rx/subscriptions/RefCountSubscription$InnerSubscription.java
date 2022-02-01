package rx.subscriptions;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Subscription;

final class RefCountSubscription$InnerSubscription
  extends AtomicInteger
  implements Subscription
{
  final RefCountSubscription parent;
  
  public RefCountSubscription$InnerSubscription(RefCountSubscription paramRefCountSubscription)
  {
    this.parent = paramRefCountSubscription;
  }
  
  public boolean isUnsubscribed()
  {
    return get() != 0;
  }
  
  public void unsubscribe()
  {
    if (compareAndSet(0, 1)) {
      this.parent.unsubscribeAChild();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.subscriptions.RefCountSubscription.InnerSubscription
 * JD-Core Version:    0.7.0.1
 */