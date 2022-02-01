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
    if (paramLong >= 0L)
    {
      if (paramLong > 0L)
      {
        BackpressureUtils.getAndAddRequest(this, paramLong);
        this.parent.drain();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalStateException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap.EagerOuterProducer
 * JD-Core Version:    0.7.0.1
 */