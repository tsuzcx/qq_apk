package rx.internal.operators;

import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.TimeInterval;

class OperatorTimeInterval$1
  extends Subscriber<T>
{
  private long lastTimestamp = this.this$0.scheduler.now();
  
  OperatorTimeInterval$1(OperatorTimeInterval paramOperatorTimeInterval, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
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
    long l = this.this$0.scheduler.now();
    this.val$subscriber.onNext(new TimeInterval(l - this.lastTimestamp, paramT));
    this.lastTimestamp = l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeInterval.1
 * JD-Core Version:    0.7.0.1
 */