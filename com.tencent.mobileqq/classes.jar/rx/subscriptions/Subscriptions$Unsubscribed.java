package rx.subscriptions;

import rx.Subscription;

final class Subscriptions$Unsubscribed
  implements Subscription
{
  public boolean isUnsubscribed()
  {
    return true;
  }
  
  public void unsubscribe() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.subscriptions.Subscriptions.Unsubscribed
 * JD-Core Version:    0.7.0.1
 */