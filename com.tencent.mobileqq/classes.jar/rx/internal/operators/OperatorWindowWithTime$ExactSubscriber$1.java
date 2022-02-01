package rx.internal.operators;

import rx.functions.Action0;

class OperatorWindowWithTime$ExactSubscriber$1
  implements Action0
{
  OperatorWindowWithTime$ExactSubscriber$1(OperatorWindowWithTime.ExactSubscriber paramExactSubscriber, OperatorWindowWithTime paramOperatorWindowWithTime) {}
  
  public void call()
  {
    if (this.this$1.state.consumer == null) {
      this.this$1.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithTime.ExactSubscriber.1
 * JD-Core Version:    0.7.0.1
 */