package rx;

import rx.functions.Action0;

class Completable$12$1
  implements Action0
{
  Completable$12$1(Completable.12 param12, Completable.CompletableSubscriber paramCompletableSubscriber, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      this.val$s.onCompleted();
      return;
    }
    finally
    {
      this.val$w.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Completable.12.1
 * JD-Core Version:    0.7.0.1
 */