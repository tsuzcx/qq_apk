package rx;

import rx.subscriptions.Subscriptions;

final class Completable$1
  implements Completable.CompletableOnSubscribe
{
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
    paramCompletableSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Completable.1
 * JD-Core Version:    0.7.0.1
 */