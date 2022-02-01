package rx;

import java.util.concurrent.TimeUnit;
import rx.subscriptions.CompositeSubscription;

class Completable$16
  implements Completable.CompletableOnSubscribe
{
  Completable$16(Completable paramCompletable, Scheduler paramScheduler, long paramLong, TimeUnit paramTimeUnit, boolean paramBoolean) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    Scheduler.Worker localWorker = this.val$scheduler.createWorker();
    localCompositeSubscription.add(localWorker);
    this.this$0.subscribe(new Completable.16.1(this, localCompositeSubscription, localWorker, paramCompletableSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Completable.16
 * JD-Core Version:    0.7.0.1
 */