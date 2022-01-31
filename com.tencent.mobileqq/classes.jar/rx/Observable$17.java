package rx;

import rx.functions.Func0;
import rx.observables.ConnectableObservable;

class Observable$17
  implements Func0<ConnectableObservable<T>>
{
  Observable$17(Observable paramObservable, int paramInt) {}
  
  public ConnectableObservable<T> call()
  {
    return this.this$0.replay(this.val$bufferSize);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Observable.17
 * JD-Core Version:    0.7.0.1
 */