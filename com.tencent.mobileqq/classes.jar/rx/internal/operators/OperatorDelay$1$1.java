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
      OperatorDelay.1 local1 = this.this$1;
      local1.done = true;
      local1.val$child.onCompleted();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorDelay.1.1
 * JD-Core Version:    0.7.0.1
 */