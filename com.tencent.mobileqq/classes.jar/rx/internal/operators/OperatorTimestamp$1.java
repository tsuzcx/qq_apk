package rx.internal.operators;

import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Timestamped;

class OperatorTimestamp$1
  extends Subscriber<T>
{
  OperatorTimestamp$1(OperatorTimestamp paramOperatorTimestamp, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    this.val$o.onNext(new Timestamped(this.this$0.scheduler.now(), paramT));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorTimestamp.1
 * JD-Core Version:    0.7.0.1
 */