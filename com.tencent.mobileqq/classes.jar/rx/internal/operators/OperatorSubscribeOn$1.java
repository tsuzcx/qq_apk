package rx.internal.operators;

import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorSubscribeOn$1
  implements Action0
{
  OperatorSubscribeOn$1(OperatorSubscribeOn paramOperatorSubscribeOn, Subscriber paramSubscriber, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    Object localObject = Thread.currentThread();
    localObject = new OperatorSubscribeOn.1.1(this, this.val$subscriber, (Thread)localObject);
    this.this$0.source.unsafeSubscribe((Subscriber)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1
 * JD-Core Version:    0.7.0.1
 */