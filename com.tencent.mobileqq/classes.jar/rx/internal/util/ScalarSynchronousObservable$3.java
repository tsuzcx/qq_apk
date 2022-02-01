package rx.internal.util;

import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;

class ScalarSynchronousObservable$3
  implements Func1<Action0, Subscription>
{
  ScalarSynchronousObservable$3(ScalarSynchronousObservable paramScalarSynchronousObservable, Scheduler paramScheduler) {}
  
  public Subscription call(Action0 paramAction0)
  {
    Scheduler.Worker localWorker = this.val$scheduler.createWorker();
    localWorker.schedule(new ScalarSynchronousObservable.3.1(this, paramAction0, localWorker));
    return localWorker;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.3
 * JD-Core Version:    0.7.0.1
 */