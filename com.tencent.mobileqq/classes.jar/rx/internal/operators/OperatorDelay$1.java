package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;

class OperatorDelay$1
  extends Subscriber<T>
{
  boolean done;
  
  OperatorDelay$1(OperatorDelay paramOperatorDelay, Subscriber paramSubscriber1, Scheduler.Worker paramWorker, Subscriber paramSubscriber2)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$worker.schedule(new OperatorDelay.1.1(this), this.this$0.delay, this.this$0.unit);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$worker.schedule(new OperatorDelay.1.2(this, paramThrowable));
  }
  
  public void onNext(T paramT)
  {
    this.val$worker.schedule(new OperatorDelay.1.3(this, paramT), this.this$0.delay, this.this$0.unit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorDelay.1
 * JD-Core Version:    0.7.0.1
 */