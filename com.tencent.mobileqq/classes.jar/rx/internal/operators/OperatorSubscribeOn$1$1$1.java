package rx.internal.operators;

import rx.Producer;
import rx.Scheduler.Worker;

class OperatorSubscribeOn$1$1$1
  implements Producer
{
  OperatorSubscribeOn$1$1$1(OperatorSubscribeOn.1.1 param1, Producer paramProducer) {}
  
  public void request(long paramLong)
  {
    if (this.this$2.val$t == Thread.currentThread())
    {
      this.val$p.request(paramLong);
      return;
    }
    this.this$2.this$1.val$inner.schedule(new OperatorSubscribeOn.1.1.1.1(this, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorSubscribeOn.1.1.1
 * JD-Core Version:    0.7.0.1
 */