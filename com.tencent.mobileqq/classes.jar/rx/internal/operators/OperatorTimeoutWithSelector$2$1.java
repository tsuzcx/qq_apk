package rx.internal.operators;

import rx.Subscriber;

class OperatorTimeoutWithSelector$2$1
  extends Subscriber<V>
{
  OperatorTimeoutWithSelector$2$1(OperatorTimeoutWithSelector.2 param2, OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber, Long paramLong) {}
  
  public void onCompleted()
  {
    this.val$timeoutSubscriber.onTimeout(this.val$seqId.longValue());
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$timeoutSubscriber.onError(paramThrowable);
  }
  
  public void onNext(V paramV)
  {
    this.val$timeoutSubscriber.onTimeout(this.val$seqId.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.2.1
 * JD-Core Version:    0.7.0.1
 */