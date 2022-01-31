package rx.internal.operators;

import java.util.Iterator;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

class OperatorZipIterable$1
  extends Subscriber<T1>
{
  boolean done;
  
  OperatorZipIterable$1(OperatorZipIterable paramOperatorZipIterable, Subscriber paramSubscriber1, Subscriber paramSubscriber2, Iterator paramIterator)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    if (this.done) {
      return;
    }
    this.done = true;
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      Exceptions.throwIfFatal(paramThrowable);
      return;
    }
    this.done = true;
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T1 paramT1)
  {
    if (this.done) {}
    for (;;)
    {
      return;
      try
      {
        this.val$subscriber.onNext(this.this$0.zipFunction.call(paramT1, this.val$iterator.next()));
        if (!this.val$iterator.hasNext())
        {
          onCompleted();
          return;
        }
      }
      catch (Throwable paramT1)
      {
        Exceptions.throwOrReport(paramT1, this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorZipIterable.1
 * JD-Core Version:    0.7.0.1
 */