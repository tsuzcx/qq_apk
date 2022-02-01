package rx;

import rx.functions.Action1;

class Observable$11
  implements Observer<T>
{
  Observable$11(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable) {}
  
  public final void onNext(T paramT)
  {
    this.val$onNext.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Observable.11
 * JD-Core Version:    0.7.0.1
 */