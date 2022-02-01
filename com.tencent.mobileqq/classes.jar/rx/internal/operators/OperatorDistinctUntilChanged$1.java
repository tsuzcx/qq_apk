package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class OperatorDistinctUntilChanged$1
  extends Subscriber<T>
{
  boolean hasPrevious;
  U previousKey;
  
  OperatorDistinctUntilChanged$1(OperatorDistinctUntilChanged paramOperatorDistinctUntilChanged, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    Object localObject1 = this.previousKey;
    try
    {
      Object localObject2 = this.this$0.keySelector.call(paramT);
      this.previousKey = localObject2;
      if (this.hasPrevious)
      {
        if ((localObject1 != localObject2) && ((localObject2 == null) || (!localObject2.equals(localObject1))))
        {
          this.val$child.onNext(paramT);
          return;
        }
        request(1L);
        return;
      }
      this.hasPrevious = true;
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
 * Qualified Name:     rx.internal.operators.OperatorDistinctUntilChanged.1
 * JD-Core Version:    0.7.0.1
 */