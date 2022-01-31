package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;

final class Subscriptions$FutureSubscription
  implements Subscription
{
  final Future<?> f;
  
  public Subscriptions$FutureSubscription(Future<?> paramFuture)
  {
    this.f = paramFuture;
  }
  
  public boolean isUnsubscribed()
  {
    return this.f.isCancelled();
  }
  
  public void unsubscribe()
  {
    this.f.cancel(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subscriptions.Subscriptions.FutureSubscription
 * JD-Core Version:    0.7.0.1
 */