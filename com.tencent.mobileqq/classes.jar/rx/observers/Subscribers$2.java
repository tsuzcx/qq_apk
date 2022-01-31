package rx.observers;

import rx.Subscriber;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

final class Subscribers$2
  extends Subscriber<T>
{
  Subscribers$2(Action1 paramAction1) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observers.Subscribers.2
 * JD-Core Version:    0.7.0.1
 */