package rx.observers;

import rx.Observer;
import rx.functions.Action0;
import rx.functions.Action1;

final class Observers$4
  implements Observer<T>
{
  Observers$4(Action0 paramAction0, Action1 paramAction11, Action1 paramAction12) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observers.Observers.4
 * JD-Core Version:    0.7.0.1
 */