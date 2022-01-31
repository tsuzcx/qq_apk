package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func2;

class OperatorTakeWhile$2
  extends Subscriber<T>
{
  private int counter = 0;
  private boolean done = false;
  
  OperatorTakeWhile$2(OperatorTakeWhile paramOperatorTakeWhile, Subscriber paramSubscriber1, boolean paramBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1, paramBoolean);
  }
  
  public void onCompleted()
  {
    if (!this.done) {
      this.val$subscriber.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.done) {
      this.val$subscriber.onError(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      Func2 localFunc2 = this.this$0.predicate;
      int i = this.counter;
      this.counter = (i + 1);
      boolean bool = ((Boolean)localFunc2.call(paramT, Integer.valueOf(i))).booleanValue();
      if (bool)
      {
        this.val$subscriber.onNext(paramT);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.done = true;
      Exceptions.throwOrReport(localThrowable, this.val$subscriber, paramT);
      unsubscribe();
      return;
    }
    this.done = true;
    this.val$subscriber.onCompleted();
    unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeWhile.2
 * JD-Core Version:    0.7.0.1
 */