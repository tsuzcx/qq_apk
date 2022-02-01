package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;

class OperatorCast$1
  extends Subscriber<T>
{
  OperatorCast$1(OperatorCast paramOperatorCast, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$o.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$o.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    try
    {
      this.val$o.onNext(this.this$0.castClass.cast(paramT));
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorCast.1
 * JD-Core Version:    0.7.0.1
 */