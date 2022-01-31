package rx;

import rx.exceptions.OnErrorNotImplementedException;

class Single$14
  extends Subscriber<T>
{
  Single$14(Single paramSingle) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    throw new OnErrorNotImplementedException(paramThrowable);
  }
  
  public final void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Single.14
 * JD-Core Version:    0.7.0.1
 */