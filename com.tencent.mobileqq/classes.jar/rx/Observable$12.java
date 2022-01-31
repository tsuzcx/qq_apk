package rx;

import rx.functions.Action0;

class Observable$12
  implements Observer<T>
{
  Observable$12(Observable paramObservable, Action0 paramAction0) {}
  
  public final void onCompleted()
  {
    this.val$onTerminate.call();
  }
  
  public final void onError(Throwable paramThrowable)
  {
    this.val$onTerminate.call();
  }
  
  public final void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.12
 * JD-Core Version:    0.7.0.1
 */