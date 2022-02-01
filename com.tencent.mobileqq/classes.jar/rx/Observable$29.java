package rx;

import rx.functions.Action0;
import rx.functions.Action1;

class Observable$29
  extends Subscriber<T>
{
  Observable$29(Observable paramObservable, Action0 paramAction0, Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted()
  {
    this.val$onComplete.call();
  }
  
  public final void onError(Throwable paramThrowable)
  {
    this.val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    this.val$onNext.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.Observable.29
 * JD-Core Version:    0.7.0.1
 */