package rx;

import rx.internal.util.SubscriptionList;

class Completable$22$1
  implements Completable.CompletableSubscriber
{
  Completable$22$1(Completable.22 param22, Scheduler.Worker paramWorker, Completable.CompletableSubscriber paramCompletableSubscriber, SubscriptionList paramSubscriptionList) {}
  
  public void onCompleted()
  {
    this.val$w.schedule(new Completable.22.1.1(this));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$w.schedule(new Completable.22.1.2(this, paramThrowable));
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$ad.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Completable.22.1
 * JD-Core Version:    0.7.0.1
 */