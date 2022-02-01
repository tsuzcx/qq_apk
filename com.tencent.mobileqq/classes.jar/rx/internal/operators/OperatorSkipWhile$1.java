package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

class OperatorSkipWhile$1
  extends Subscriber<T>
{
  int index;
  boolean skipping = true;
  
  OperatorSkipWhile$1(OperatorSkipWhile paramOperatorSkipWhile, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    if (!this.skipping)
    {
      this.val$child.onNext(paramT);
      return;
    }
    try
    {
      Func2 localFunc2 = this.this$0.predicate;
      int i = this.index;
      this.index = (i + 1);
      boolean bool = ((Boolean)localFunc2.call(paramT, Integer.valueOf(i))).booleanValue();
      if (!bool)
      {
        this.skipping = false;
        this.val$child.onNext(paramT);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.val$child, paramT);
      return;
    }
    request(1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipWhile.1
 * JD-Core Version:    0.7.0.1
 */