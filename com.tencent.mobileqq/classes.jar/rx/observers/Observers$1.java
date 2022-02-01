package rx.observers;

import rx.Observer;
import rx.exceptions.OnErrorNotImplementedException;

final class Observers$1
  implements Observer<Object>
{
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observers.Observers.1
 * JD-Core Version:    0.7.0.1
 */