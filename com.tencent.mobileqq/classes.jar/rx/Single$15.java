package rx;

import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;

class Single$15
  extends Subscriber<T>
{
  Single$15(Single paramSingle, Action1 paramAction1) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    this.val$onSuccess.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.15
 * JD-Core Version:    0.7.0.1
 */