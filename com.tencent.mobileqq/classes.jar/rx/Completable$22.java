package rx;

import rx.internal.util.SubscriptionList;

class Completable$22
  implements Completable.CompletableOnSubscribe
{
  Completable$22(Completable paramCompletable, Scheduler paramScheduler) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    SubscriptionList localSubscriptionList = new SubscriptionList();
    Scheduler.Worker localWorker = this.val$scheduler.createWorker();
    localSubscriptionList.add(localWorker);
    paramCompletableSubscriber.onSubscribe(localSubscriptionList);
    this.this$0.subscribe(new Completable.22.1(this, localWorker, paramCompletableSubscriber, localSubscriptionList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.22
 * JD-Core Version:    0.7.0.1
 */