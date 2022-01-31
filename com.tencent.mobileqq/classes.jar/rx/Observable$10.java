package rx;

import rx.functions.Action1;

class Observable$10
  implements Observer<T>
{
  Observable$10(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    this.val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Observable.10
 * JD-Core Version:    0.7.0.1
 */