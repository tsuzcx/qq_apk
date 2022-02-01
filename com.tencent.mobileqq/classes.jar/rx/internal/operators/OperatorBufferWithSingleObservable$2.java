package rx.internal.operators;

import rx.Subscriber;

class OperatorBufferWithSingleObservable$2
  extends Subscriber<TClosing>
{
  OperatorBufferWithSingleObservable$2(OperatorBufferWithSingleObservable paramOperatorBufferWithSingleObservable, OperatorBufferWithSingleObservable.BufferingSubscriber paramBufferingSubscriber) {}
  
  public void onCompleted()
  {
    this.val$bsub.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$bsub.onError(paramThrowable);
  }
  
  public void onNext(TClosing paramTClosing)
  {
    this.val$bsub.emit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSingleObservable.2
 * JD-Core Version:    0.7.0.1
 */