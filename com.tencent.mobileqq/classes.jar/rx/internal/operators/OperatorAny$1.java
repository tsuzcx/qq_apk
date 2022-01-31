package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

class OperatorAny$1
  extends Subscriber<T>
{
  boolean done;
  boolean hasElements;
  
  OperatorAny$1(OperatorAny paramOperatorAny, SingleDelayedProducer paramSingleDelayedProducer, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    if (!this.done)
    {
      this.done = true;
      if (this.hasElements) {
        this.val$producer.setValue(Boolean.valueOf(false));
      }
    }
    else
    {
      return;
    }
    this.val$producer.setValue(Boolean.valueOf(this.this$0.returnOnEmpty));
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.hasElements = true;
    for (;;)
    {
      try
      {
        bool = ((Boolean)this.this$0.predicate.call(paramT)).booleanValue();
        if ((bool) && (!this.done))
        {
          this.done = true;
          paramT = this.val$producer;
          if (!this.this$0.returnOnEmpty)
          {
            bool = true;
            paramT.setValue(Boolean.valueOf(bool));
            unsubscribe();
          }
        }
        else
        {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this, paramT);
        return;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorAny.1
 * JD-Core Version:    0.7.0.1
 */