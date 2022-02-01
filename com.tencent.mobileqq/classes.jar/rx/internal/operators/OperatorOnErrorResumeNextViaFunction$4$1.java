package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

class OperatorOnErrorResumeNextViaFunction$4$1
  extends Subscriber<T>
{
  OperatorOnErrorResumeNextViaFunction$4$1(OperatorOnErrorResumeNextViaFunction.4 param4) {}
  
  public void onCompleted()
  {
    this.this$1.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.this$1.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.this$1.val$child.onNext(paramT);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.this$1.val$pa.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction.4.1
 * JD-Core Version:    0.7.0.1
 */