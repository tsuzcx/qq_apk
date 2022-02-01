package rx.internal.operators;

import rx.Scheduler;
import rx.Subscriber;

class OperatorThrottleFirst$1
  extends Subscriber<T>
{
  private long lastOnNext = 0L;
  
  OperatorThrottleFirst$1(OperatorThrottleFirst paramOperatorThrottleFirst, Subscriber paramSubscriber1, Subscriber paramSubscriber2)
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
    if ((this.lastOnNext == 0L) || (l - this.lastOnNext >= this.this$0.timeInMilliseconds))
    {
      this.lastOnNext = l;
      this.val$subscriber.onNext(paramT);
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorThrottleFirst.1
 * JD-Core Version:    0.7.0.1
 */