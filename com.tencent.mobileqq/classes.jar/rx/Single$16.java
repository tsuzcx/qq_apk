package rx;

import rx.functions.Action1;

class Single$16
  extends Subscriber<T>
{
  Single$16(Single paramSingle, Action1 paramAction11, Action1 paramAction12) {}
  
  public final void onCompleted() {}
  
  public final void onError(Throwable paramThrowable)
  {
    this.val$onError.call(paramThrowable);
  }
  
  public final void onNext(T paramT)
  {
    this.val$onSuccess.call(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Single.16
 * JD-Core Version:    0.7.0.1
 */