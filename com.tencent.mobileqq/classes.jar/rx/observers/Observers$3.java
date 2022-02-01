package rx.observers;

import rx.Observer;
import rx.functions.Action1;

final class Observers$3
  implements Observer<T>
{
  Observers$3(Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted() {}
  
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
 * Qualified Name:     rx.observers.Observers.3
 * JD-Core Version:    0.7.0.1
 */