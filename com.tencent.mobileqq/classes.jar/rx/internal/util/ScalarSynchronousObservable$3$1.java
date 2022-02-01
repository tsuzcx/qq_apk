package rx.internal.util;

import rx.Scheduler.Worker;
import rx.functions.Action0;

class ScalarSynchronousObservable$3$1
  implements Action0
{
  ScalarSynchronousObservable$3$1(ScalarSynchronousObservable.3 param3, Action0 paramAction0, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      this.val$a.call();
      return;
    }
    finally
    {
      this.val$w.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.3.1
 * JD-Core Version:    0.7.0.1
 */