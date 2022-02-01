package rx.internal.operators;

import rx.Subscriber;

class OperatorTakeUntil$2
  extends Subscriber<E>
{
  OperatorTakeUntil$2(OperatorTakeUntil paramOperatorTakeUntil, Subscriber paramSubscriber) {}
  
  public void onCompleted()
  {
    this.val$main.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$main.onError(paramThrowable);
  }
  
  public void onNext(E paramE)
  {
    onCompleted();
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntil.2
 * JD-Core Version:    0.7.0.1
 */