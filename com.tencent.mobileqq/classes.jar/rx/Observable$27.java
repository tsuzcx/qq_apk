package rx;

import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

class Observable$27
  extends Subscriber<T>
{
  Observable$27(Observable paramObservable, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    this.val$onNext.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.Observable.27
 * JD-Core Version:    0.7.0.1
 */