package rx.internal.operators;

import rx.Subscriber;

class OperatorTakeUntil$1
  extends Subscriber<T>
{
  OperatorTakeUntil$1(OperatorTakeUntil paramOperatorTakeUntil, Subscriber paramSubscriber1, boolean paramBoolean, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1, paramBoolean);
  }
  
  public void onCompleted()
  {
    try
    {
      this.val$serial.onCompleted();
      return;
    }
    finally
    {
      this.val$serial.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.val$serial.onError(paramThrowable);
      return;
    }
    finally
    {
      this.val$serial.unsubscribe();
    }
  }
  
  public void onNext(T paramT)
  {
    this.val$serial.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil.1
 * JD-Core Version:    0.7.0.1
 */