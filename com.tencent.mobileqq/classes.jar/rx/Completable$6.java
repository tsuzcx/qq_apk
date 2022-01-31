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
      label22:
      Object localObject = localThrowable1;
      if (localThrowable1 == null) {
        localObject = new NullPointerException("The error supplied is null");
      }
      paramCompletableSubscriber.onError((Throwable)localObject);
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.6
 * JD-Core Version:    0.7.0.1
 */