package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class MultipleAssignmentSubscription
  implements Subscription
{
  final AtomicReference<MultipleAssignmentSubscription.State> state = new AtomicReference(new MultipleAssignmentSubscription.State(false, Subscriptions.empty()));
  
  public Subscription get()
  {
    return ((MultipleAssignmentSubscription.State)this.state.get()).subscription;
  }
  
  public boolean isUnsubscribed()
  {
    return ((MultipleAssignmentSubscription.State)this.state.get()).isUnsubscribed;
  }
  
  public void set(Subscription paramSubscription)
  {
    if (paramSubscription == null) {
      throw new IllegalArgumentException("Subscription can not be null");
    }
    AtomicReference localAtomicReference = this.state;
    MultipleAssignmentSubscription.State localState;
    do
    {
      localState = (MultipleAssignmentSubscription.State)localAtomicReference.get();
      if (localState.isUnsubscribed)
      {
        paramSubscription.unsubscribe();
        return;
      }
    } while (!localAtomicReference.compareAndSet(localState, localState.set(paramSubscription)));
  }
  
  public void unsubscribe()
  {
    AtomicReference localAtomicReference = this.state;
    MultipleAssignmentSubscription.State localState;
    do
    {
      localState = (MultipleAssignmentSubscription.State)localAtomicReference.get();
      if (localState.isUnsubscribed) {
        return;
      }
    } while (!localAtomicReference.compareAndSet(localState, localState.unsubscribe()));
    localState.subscription.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subscriptions.MultipleAssignmentSubscription
 * JD-Core Version:    0.7.0.1
 */