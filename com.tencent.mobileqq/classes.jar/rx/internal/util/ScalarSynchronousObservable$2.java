package rx.internal.util;

import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.schedulers.EventLoopsScheduler;

class ScalarSynchronousObservable$2
  implements Func1<Action0, Subscription>
{
  ScalarSynchronousObservable$2(ScalarSynchronousObservable paramScalarSynchronousObservable, EventLoopsScheduler paramEventLoopsScheduler) {}
  
  public Subscription call(Action0 paramAction0)
  {
    return this.val$els.scheduleDirect(paramAction0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.2
 * JD-Core Version:    0.7.0.1
 */