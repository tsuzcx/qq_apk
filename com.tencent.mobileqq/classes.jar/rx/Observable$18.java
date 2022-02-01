package rx;

import java.util.concurrent.TimeUnit;
import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$18
  implements Func0<ConnectableObservable<T>>
{
  Observable$18(Observable paramObservable, int paramInt, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler) {}
  
  public ConnectableObservable<T> call()
  {
    return this.this$0.replay(this.val$bufferSize, this.val$time, this.val$unit, this.val$scheduler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Observable.18
 * JD-Core Version:    0.7.0.1
 */