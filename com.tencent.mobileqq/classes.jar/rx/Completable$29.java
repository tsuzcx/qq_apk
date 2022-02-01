package rx;

class Completable$29
  implements Completable.CompletableOnSubscribe
{
  Completable$29(Completable paramCompletable, Scheduler paramScheduler) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    Scheduler.Worker localWorker = this.val$scheduler.createWorker();
    localWorker.schedule(new Completable.29.1(this, paramCompletableSubscriber, localWorker));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.29
 * JD-Core Version:    0.7.0.1
 */