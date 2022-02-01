package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

final class OperatorEagerConcatMap$EagerOuterProducer
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = -657299606803478389L;
  final OperatorEagerConcatMap.EagerOuterSubscriber<?, ?> parent;
  
  public OperatorEagerConcatMap$EagerOuterProducer(OperatorEagerConcatMap.EagerOuterSubscriber<?, ?> paramEagerOuterSubscriber)
  {
    this.parent = paramEagerOuterSubscriber;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalStateException("n >= 0 required but it was " + paramLong);
    }
    if (paramLong > 0L)
    {
      BackpressureUtils.getAndAddRequest(this, paramLong);
      this.parent.drain();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap.EagerOuterProducer
 * JD-Core Version:    0.7.0.1
 */