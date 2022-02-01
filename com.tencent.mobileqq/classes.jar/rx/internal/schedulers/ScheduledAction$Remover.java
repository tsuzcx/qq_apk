package rx.internal.schedulers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

final class ScheduledAction$Remover
  extends AtomicBoolean
  implements Subscription
{
  private static final long serialVersionUID = 247232374289553518L;
  final CompositeSubscription parent;
  final ScheduledAction s;
  
  public ScheduledAction$Remover(ScheduledAction paramScheduledAction, CompositeSubscription paramCompositeSubscription)
  {
    this.s = paramScheduledAction;
    this.parent = paramCompositeSubscription;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.schedulers.ScheduledAction.Remover
 * JD-Core Version:    0.7.0.1
 */