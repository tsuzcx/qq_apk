package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class OperatorFilter$1
  extends Subscriber<T>
{
  OperatorFilter$1(OperatorFilter paramOperatorFilter, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    try
    {
      if (((Boolean)this.this$0.predicate.call(paramT)).booleanValue())
      {
        this.val$child.onNext(paramT);
        return;
      }
      request(1L);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.val$child, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorFilter.1
 * JD-Core Version:    0.7.0.1
 */