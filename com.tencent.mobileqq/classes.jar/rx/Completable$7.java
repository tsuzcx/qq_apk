package rx;

import rx.subscriptions.Subscriptions;

final class Completable$7
  implements Completable.CompletableOnSubscribe
{
  Completable$7(Throwable paramThrowable) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
    paramCompletableSubscriber.onError(this.val$error);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.7
 * JD-Core Version:    0.7.0.1
 */