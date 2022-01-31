package rx.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.internal.util.SubscriptionList;

final class ScheduledAction$Remover2
  extends AtomicBoolean
  implements Subscription
{
  private static final long serialVersionUID = 247232374289553518L;
  final SubscriptionList parent;
  final ScheduledAction s;
  
  public ScheduledAction$Remover2(ScheduledAction paramScheduledAction, SubscriptionList paramSubscriptionList)
  {
    this.s = paramScheduledAction;
    this.parent = paramSubscriptionList;
  }
  
  public boolean isUnsubscribed()
  {
    return this.s.isUnsubscribed();
  }
  
  public void unsubscribe()
  {
    if (compareAndSet(false, true)) {
      this.parent.remove(this.s);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.schedulers.ScheduledAction.Remover2
 * JD-Core Version:    0.7.0.1
 */