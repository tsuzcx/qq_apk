package rx.internal.operators;

import rx.Subscriber;

class OperatorIgnoreElements$1
  extends Subscriber<T>
{
  OperatorIgnoreElements$1(OperatorIgnoreElements paramOperatorIgnoreElements, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorIgnoreElements.1
 * JD-Core Version:    0.7.0.1
 */