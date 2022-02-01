package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

class OperatorScan$2
  extends Subscriber<T>
{
  boolean once;
  R value;
  
  OperatorScan$2(OperatorScan paramOperatorScan, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    Object localObject;
    if (!this.once) {
      this.once = true;
    } else {
      localObject = this.value;
    }
    try
    {
      localObject = this.this$0.accumulator.call(localObject, paramT);
      paramT = localObject;
      this.value = paramT;
      this.val$child.onNext(paramT);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.val$child, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorScan.2
 * JD-Core Version:    0.7.0.1
 */