package rx;

import rx.functions.Func0;
import rx.subscriptions.Subscriptions;

final class Completable$6
  implements Completable.CompletableOnSubscribe
{
  Completable$6(Func0 paramFunc0) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
    try
    {
      Throwable localThrowable1 = (Throwable)this.val$errorFunc0.call();
    }
    catch (Throwable localThrowable2) {}
    Object localObject = localThrowable2;
    if (localThrowable2 == null) {
      localObject = new NullPointerException("The error supplied is null");
    }
    paramCompletableSubscriber.onError((Throwable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.6
 * JD-Core Version:    0.7.0.1
 */