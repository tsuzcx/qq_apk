package rx;

import rx.functions.Action0;

class Completable$33$1$1$1
  implements Action0
{
  Completable$33$1$1$1(Completable.33.1.1 param1, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      this.this$3.val$d.unsubscribe();
      return;
    }
    finally
    {
      this.val$w.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Completable.33.1.1.1
 * JD-Core Version:    0.7.0.1
 */