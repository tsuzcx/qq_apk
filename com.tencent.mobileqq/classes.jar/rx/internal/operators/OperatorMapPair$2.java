package rx.internal.operators;

import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

class OperatorMapPair$2
  extends Subscriber<T>
{
  OperatorMapPair$2(OperatorMapPair paramOperatorMapPair, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
      this.val$o.onNext(((Observable)this.this$0.collectionSelector.call(paramT)).map(new OperatorMapPair.2.1(this, paramT)));
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.val$o, paramT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorMapPair.2
 * JD-Core Version:    0.7.0.1
 */