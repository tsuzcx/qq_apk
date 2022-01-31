package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Action0;

class OperatorDelay$1$2
  implements Action0
{
  OperatorDelay$1$2(OperatorDelay.1 param1, Throwable paramThrowable) {}
  
  public void call()
  {
    if (!this.this$1.done)
    {
      this.this$1.done = true;
      this.this$1.val$child.onError(this.val$e);
      this.this$1.val$worker.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorDelay.1.2
 * JD-Core Version:    0.7.0.1
 */