package rx;

import rx.subscriptions.CompositeSubscription;

class Completable$16$1
  implements Completable.CompletableSubscriber
{
  Completable$16$1(Completable.16 param16, CompositeSubscription paramCompositeSubscription, Scheduler.Worker paramWorker, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    this.val$set.add(this.val$w.schedule(new Completable.16.1.1(this), this.this$1.val$delay, this.this$1.val$unit));
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.this$1.val$delayError)
    {
      this.val$set.add(this.val$w.schedule(new Completable.16.1.2(this, paramThrowable), this.this$1.val$delay, this.this$1.val$unit));
      return;
    }
    this.val$s.onError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$set.add(paramSubscription);
    this.val$s.onSubscribe(this.val$set);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Completable.16.1
 * JD-Core Version:    0.7.0.1
 */