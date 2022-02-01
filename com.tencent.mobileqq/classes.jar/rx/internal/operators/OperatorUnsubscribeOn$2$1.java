package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorUnsubscribeOn$2$1
  implements Action0
{
  OperatorUnsubscribeOn$2$1(OperatorUnsubscribeOn.2 param2, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    this.this$1.val$parent.unsubscribe();
    this.val$inner.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn.2.1
 * JD-Core Version:    0.7.0.1
 */