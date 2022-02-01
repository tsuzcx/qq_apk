package rx;

import rx.subscriptions.Subscriptions;

final class Completable$2
  implements Completable.CompletableOnSubscribe
{
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    paramCompletableSubscriber.onSubscribe(Subscriptions.unsubscribed());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.2
 * JD-Core Version:    0.7.0.1
 */