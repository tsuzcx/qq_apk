package rx;

import rx.functions.Action0;

class Observable$8
  implements Observer<T>
{
  Observable$8(Observable paramObservable, Action0 paramAction0) {}
  
  public final void onCompleted()
  {
    this.val$onCompleted.call();
  }
  
  public final void onError(Throwable paramThrowable) {}
  
  public final void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Observable.8
 * JD-Core Version:    0.7.0.1
 */