package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.functions.Action0;

class OperatorReplay$ReplaySubscriber$1
  implements Action0
{
  OperatorReplay$ReplaySubscriber$1(OperatorReplay.ReplaySubscriber paramReplaySubscriber) {}
  
  public void call()
  {
    this.this$0.producers.getAndSet(OperatorReplay.ReplaySubscriber.TERMINATED);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.ReplaySubscriber.1
 * JD-Core Version:    0.7.0.1
 */