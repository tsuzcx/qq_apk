package rx;

import rx.subscriptions.Subscriptions;

class Completable$33$1
  implements Completable.CompletableSubscriber
{
  Completable$33$1(Completable.33 param33, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$s.onSubscribe(Subscriptions.create(new Completable.33.1.1(this, paramSubscription)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.33.1
 * JD-Core Version:    0.7.0.1
 */