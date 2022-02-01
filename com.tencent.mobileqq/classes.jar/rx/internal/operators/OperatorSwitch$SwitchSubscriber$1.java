package rx.internal.operators;

import rx.Producer;
import rx.internal.producers.ProducerArbiter;

class OperatorSwitch$SwitchSubscriber$1
  implements Producer
{
  OperatorSwitch$SwitchSubscriber$1(OperatorSwitch.SwitchSubscriber paramSwitchSubscriber) {}
  
  public void request(long paramLong)
  {
    if (paramLong > 0L) {
      this.this$0.arbiter.request(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSwitch.SwitchSubscriber.1
 * JD-Core Version:    0.7.0.1
 */