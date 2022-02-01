package rx.internal.operators;

import rx.Subscriber;

class OperatorUnsubscribeOn$1
  extends Subscriber<T>
{
  OperatorUnsubscribeOn$1(OperatorUnsubscribeOn paramOperatorUnsubscribeOn, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this.val$subscriber.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$subscriber.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$subscriber.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn.1
 * JD-Core Version:    0.7.0.1
 */