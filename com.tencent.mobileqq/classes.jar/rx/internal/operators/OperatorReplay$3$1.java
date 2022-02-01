package rx.internal.operators;

import rx.Subscriber;

class OperatorReplay$3$1
  extends Subscriber<T>
{
  OperatorReplay$3$1(OperatorReplay.3 param3, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    this.val$child.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.3.1
 * JD-Core Version:    0.7.0.1
 */