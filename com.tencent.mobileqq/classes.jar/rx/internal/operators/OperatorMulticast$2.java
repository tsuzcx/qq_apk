package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;

class OperatorMulticast$2
  implements Action0
{
  OperatorMulticast$2(OperatorMulticast paramOperatorMulticast, AtomicReference paramAtomicReference) {}
  
  public void call()
  {
    synchronized (this.this$0.guard)
    {
      if (this.this$0.guardedSubscription == this.val$gs.get())
      {
        Subscriber localSubscriber = this.this$0.subscription;
        this.this$0.subscription = null;
        this.this$0.guardedSubscription = null;
        this.this$0.connectedSubject.set(null);
        if (localSubscriber != null) {
          localSubscriber.unsubscribe();
        }
        return;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorMulticast.2
 * JD-Core Version:    0.7.0.1
 */