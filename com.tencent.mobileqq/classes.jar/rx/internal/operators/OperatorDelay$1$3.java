package rx.internal.operators;

import rx.Subscriber;
import rx.functions.Action0;

class OperatorDelay$1$3
  implements Action0
{
  OperatorDelay$1$3(OperatorDelay.1 param1, Object paramObject) {}
  
  public void call()
  {
    if (!this.this$1.done) {
      this.this$1.val$child.onNext(this.val$t);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorDelay.1.3
 * JD-Core Version:    0.7.0.1
 */