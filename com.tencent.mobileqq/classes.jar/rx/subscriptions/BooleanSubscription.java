package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.functions.Action0;

public final class BooleanSubscription
  implements Subscription
{
  static final Action0 EMPTY_ACTION = new BooleanSubscription.1();
  final AtomicReference<Action0> actionRef;
  
  public BooleanSubscription()
  {
    this.actionRef = new AtomicReference();
  }
  
  private BooleanSubscription(Action0 paramAction0)
  {
    this.actionRef = new AtomicReference(paramAction0);
  }
  
  public static BooleanSubscription create()
  {
    return new BooleanSubscription();
  }
  
  public static BooleanSubscription create(Action0 paramAction0)
  {
    return new BooleanSubscription(paramAction0);
  }
  
  public boolean isUnsubscribed()
  {
    return this.actionRef.get() == EMPTY_ACTION;
  }
  
  public final void unsubscribe()
  {
    Action0 localAction01 = (Action0)this.actionRef.get();
    Action0 localAction02 = EMPTY_ACTION;
    if (localAction01 != localAction02)
    {
      localAction01 = (Action0)this.actionRef.getAndSet(localAction02);
      if ((localAction01 != null) && (localAction01 != EMPTY_ACTION)) {
        localAction01.call();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.subscriptions.BooleanSubscription
 * JD-Core Version:    0.7.0.1
 */