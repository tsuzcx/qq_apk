package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class SerialSubscription
  implements Subscription
{
  final AtomicReference<SerialSubscription.State> state = new AtomicReference(new SerialSubscription.State(false, Subscriptions.empty()));
  
  public Subscription get()
  {
    return ((SerialSubscription.State)this.state.get()).subscription;
  }
  
  public boolean isUnsubscribed()
  {
    return ((SerialSubscription.State)this.state.get()).isUnsubscribed;
  }
  
  public void set(Subscription paramSubscription)
  {
    if (paramSubscription == null) {
      throw new IllegalArgumentException("Subscription can not be null");
    }
    AtomicReference localAtomicReference = this.state;
    SerialSubscription.State localState;
    do
    {
      localState = (SerialSubscription.State)localAtomicReference.get();
      if (localState.isUnsubscribed)
      {
        paramSubscription.unsubscribe();
        return;
      }
    } while (!localAtomicReference.compareAndSet(localState, localState.set(paramSubscription)));
    localState.subscription.unsubscribe();
  }
  
  public void unsubscribe()
  {
    AtomicReference localAtomicReference = this.state;
    SerialSubscription.State localState;
    do
    {
      localState = (SerialSubscription.State)localAtomicReference.get();
      if (localState.isUnsubscribed) {
        return;
      }
    } while (!localAtomicReference.compareAndSet(localState, localState.unsubscribe()));
    localState.subscription.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subscriptions.SerialSubscription
 * JD-Core Version:    0.7.0.1
 */