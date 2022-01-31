package rx.subscriptions;

import rx.Subscription;

final class SerialSubscription$State
{
  final boolean isUnsubscribed;
  final Subscription subscription;
  
  SerialSubscription$State(boolean paramBoolean, Subscription paramSubscription)
  {
    this.isUnsubscribed = paramBoolean;
    this.subscription = paramSubscription;
  }
  
  State set(Subscription paramSubscription)
  {
    return new State(this.isUnsubscribed, paramSubscription);
  }
  
  State unsubscribe()
  {
    return new State(true, this.subscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.subscriptions.SerialSubscription.State
 * JD-Core Version:    0.7.0.1
 */