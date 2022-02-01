package rx.internal.operators;

import rx.Subscriber;

class OperatorMulticast$3
  extends Subscriber<R>
{
  OperatorMulticast$3(OperatorMulticast paramOperatorMulticast, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
  
  public void onNext(R paramR)
  {
    this.val$s.onNext(paramR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorMulticast.3
 * JD-Core Version:    0.7.0.1
 */