package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;

class OperatorTimeoutBase$TimeoutSubscriber$1
  extends Subscriber<T>
{
  OperatorTimeoutBase$TimeoutSubscriber$1(OperatorTimeoutBase.TimeoutSubscriber paramTimeoutSubscriber) {}
  
  public void onCompleted()
  {
    this.this$0.serializedSubscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$0.serializedSubscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.this$0.serializedSubscriber.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.this$0.arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber.1
 * JD-Core Version:    0.7.0.1
 */