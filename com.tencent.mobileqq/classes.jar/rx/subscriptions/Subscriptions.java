package rx.subscriptions;

import java.util.concurrent.Future;
import rx.Subscription;
import rx.functions.Action0;

public final class Subscriptions
{
  private static final Subscriptions.Unsubscribed UNSUBSCRIBED = new Subscriptions.Unsubscribed();
  
  private Subscriptions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static Subscription create(Action0 paramAction0)
  {
    return BooleanSubscription.create(paramAction0);
  }
  
  public static Subscription empty()
  {
    return BooleanSubscription.create();
  }
  
  public static Subscription from(Future<?> paramFuture)
  {
    return new Subscriptions.FutureSubscription(paramFuture);
  }
  
  public static CompositeSubscription from(Subscription... paramVarArgs)
  {
    return new CompositeSubscription(paramVarArgs);
  }
  
  public static Subscription unsubscribed()
  {
    return UNSUBSCRIBED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.subscriptions.Subscriptions
 * JD-Core Version:    0.7.0.1
 */