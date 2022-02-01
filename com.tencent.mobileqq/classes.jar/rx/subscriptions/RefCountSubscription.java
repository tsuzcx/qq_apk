package rx.subscriptions;

import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;

public final class RefCountSubscription
  implements Subscription
{
  static final RefCountSubscription.State EMPTY_STATE = new RefCountSubscription.State(false, 0);
  private final Subscription actual;
  final AtomicReference<RefCountSubscription.State> state = new AtomicReference(EMPTY_STATE);
  
  public RefCountSubscription(Subscription paramSubscription)
  {
    if (paramSubscription == null) {
      throw new IllegalArgumentException("s");
    }
    this.actual = paramSubscription;
  }
  
  private void unsubscribeActualIfApplicable(RefCountSubscription.State paramState)
  {
    if ((paramState.isUnsubscribed) && (paramState.children == 0)) {
      this.actual.unsubscribe();
    }
  }
  
  public Subscription get()
  {
    AtomicReference localAtomicReference = this.state;
    RefCountSubscription.State localState;
    do
    {
      localState = (RefCountSubscription.State)localAtomicReference.get();
      if (localState.isUnsubscribed) {
        return Subscriptions.unsubscribed();
      }
    } while (!localAtomicReference.compareAndSet(localState, localState.addChild()));
    return new RefCountSubscription.InnerSubscription(this);
  }
  
  public boolean isUnsubscribed()
  {
    return ((RefCountSubscription.State)this.state.get()).isUnsubscribed;
  }
  
  public void unsubscribe()
  {
    AtomicReference localAtomicReference = this.state;
    RefCountSubscription.State localState1;
    RefCountSubscription.State localState2;
    do
    {
      localState1 = (RefCountSubscription.State)localAtomicReference.get();
      if (localState1.isUnsubscribed) {
        return;
      }
      localState2 = localState1.unsubscribe();
    } while (!localAtomicReference.compareAndSet(localState1, localState2));
    unsubscribeActualIfApplicable(localState2);
  }
  
  void unsubscribeAChild()
  {
    AtomicReference localAtomicReference = this.state;
    RefCountSubscription.State localState1;
    RefCountSubscription.State localState2;
    do
    {
      localState1 = (RefCountSubscription.State)localAtomicReference.get();
      localState2 = localState1.removeChild();
    } while (!localAtomicReference.compareAndSet(localState1, localState2));
    unsubscribeActualIfApplicable(localState2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.subscriptions.RefCountSubscription
 * JD-Core Version:    0.7.0.1
 */