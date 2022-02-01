package rx;

import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$16
  implements Func0<ConnectableObservable<T>>
{
  Observable$16(Observable paramObservable) {}
  
  public ConnectableObservable<T> call()
  {
    return this.this$0.replay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Observable.16
 * JD-Core Version:    0.7.0.1
 */