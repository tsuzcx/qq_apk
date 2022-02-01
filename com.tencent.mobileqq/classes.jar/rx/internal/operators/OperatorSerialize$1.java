package rx.internal.operators;

import rx.Subscriber;

class OperatorSerialize$1
  extends Subscriber<T>
{
  OperatorSerialize$1(OperatorSerialize paramOperatorSerialize, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$s.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$s.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.val$s.onNext(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorSerialize.1
 * JD-Core Version:    0.7.0.1
 */