package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.functions.Action0;

class OperatorEagerConcatMap$EagerOuterSubscriber$1
  implements Action0
{
  OperatorEagerConcatMap$EagerOuterSubscriber$1(OperatorEagerConcatMap.EagerOuterSubscriber paramEagerOuterSubscriber) {}
  
  public void call()
  {
    OperatorEagerConcatMap.EagerOuterSubscriber localEagerOuterSubscriber = this.this$0;
    localEagerOuterSubscriber.cancelled = true;
    if (localEagerOuterSubscriber.wip.getAndIncrement() == 0) {
      this.this$0.cleanup();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber.1
 * JD-Core Version:    0.7.0.1
 */