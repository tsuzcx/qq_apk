package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

class OperatorAll$1
  extends Subscriber<T>
{
  boolean done;
  
  OperatorAll$1(OperatorAll paramOperatorAll, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!this.done)
    {
      this.done = true;
      this.val$producer.setValue(Boolean.valueOf(true));
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Boolean localBoolean = (Boolean)this.this$0.predicate.call(paramT);
      if ((!localBoolean.booleanValue()) && (!this.done))
      {
        this.done = true;
        this.val$producer.setValue(Boolean.valueOf(false));
        unsubscribe();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorAll.1
 * JD-Core Version:    0.7.0.1
 */