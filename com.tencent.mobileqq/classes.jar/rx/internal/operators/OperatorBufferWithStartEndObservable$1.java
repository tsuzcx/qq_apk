package rx.internal.operators;

import rx.Subscriber;

class OperatorBufferWithStartEndObservable$1
  extends Subscriber<TOpening>
{
  OperatorBufferWithStartEndObservable$1(OperatorBufferWithStartEndObservable paramOperatorBufferWithStartEndObservable, OperatorBufferWithStartEndObservable.BufferingSubscriber paramBufferingSubscriber) {}
  
  public void onCompleted()
  {
    this.val$bsub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$bsub.onError(paramThrowable);
  }
  
  public void onNext(TOpening paramTOpening)
  {
    this.val$bsub.startBuffer(paramTOpening);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithStartEndObservable.1
 * JD-Core Version:    0.7.0.1
 */