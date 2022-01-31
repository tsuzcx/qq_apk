package rx;

import rx.functions.Action0;

class Completable$29$1
  implements Action0
{
  Completable$29$1(Completable.29 param29, Completable.CompletableSubscriber paramCompletableSubscriber, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      this.this$1.this$0.subscribe(this.val$s);
      return;
    }
    finally
    {
      this.val$w.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Completable.29.1
 * JD-Core Version:    0.7.0.1
 */