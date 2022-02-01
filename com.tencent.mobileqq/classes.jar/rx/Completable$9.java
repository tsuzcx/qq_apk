package rx;

import java.util.concurrent.Callable;
import rx.subscriptions.BooleanSubscription;

final class Completable$9
  implements Completable.CompletableOnSubscribe
{
  Completable$9(Callable paramCallable) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    BooleanSubscription localBooleanSubscription = new BooleanSubscription();
    paramCompletableSubscriber.onSubscribe(localBooleanSubscription);
    try
    {
      this.val$callable.call();
      if (!localBooleanSubscription.isUnsubscribed()) {
        paramCompletableSubscriber.onCompleted();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (localBooleanSubscription.isUnsubscribed()) {}
      paramCompletableSubscriber.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Completable.9
 * JD-Core Version:    0.7.0.1
 */