package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

class OperatorDelay$1$1
  implements Action0
{
  OperatorDelay$1$1(OperatorDelay.1 param1) {}
  
  public void call()
  {
    if (!this.this$1.done)
    {
      this.this$1.done = true;
      this.this$1.val$child.onCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorDelay.1.1
 * JD-Core Version:    0.7.0.1
 */