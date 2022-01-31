package rx.internal.operators;

import rx.Subscriber;

class OperatorWindowWithStartEndObservable$1
  extends Subscriber<U>
{
  OperatorWindowWithStartEndObservable$1(OperatorWindowWithStartEndObservable paramOperatorWindowWithStartEndObservable, OperatorWindowWithStartEndObservable.SourceSubscriber paramSourceSubscriber) {}
  
  public void onCompleted()
  {
    this.val$sub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$sub.onError(paramThrowable);
  }
  
  public void onNext(U paramU)
  {
    this.val$sub.beginWindow(paramU);
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable.1
 * JD-Core Version:    0.7.0.1
 */