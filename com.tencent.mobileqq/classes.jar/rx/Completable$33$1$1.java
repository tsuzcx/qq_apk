package rx;

import rx.functions.Action0;

class Completable$33$1$1
  implements Action0
{
  Completable$33$1$1(Completable.33.1 param1, Subscription paramSubscription) {}
  
  public void call()
  {
    Scheduler.Worker localWorker = this.this$2.this$1.val$scheduler.createWorker();
    localWorker.schedule(new Completable.33.1.1.1(this, localWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.33.1.1
 * JD-Core Version:    0.7.0.1
 */