package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

final class OperatorMerge$MergeProducer<T>
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = -1214379189873595503L;
  final OperatorMerge.MergeSubscriber<T> subscriber;
  
  public OperatorMerge$MergeProducer(OperatorMerge.MergeSubscriber<T> paramMergeSubscriber)
  {
    this.subscriber = paramMergeSubscriber;
  }
  
  public long produced(int paramInt)
  {
    return addAndGet(-paramInt);
  }
  
  public void request(long paramLong)
  {
    if (paramLong > 0L) {
      if (get() != 9223372036854775807L) {}
    }
    while (paramLong >= 0L)
    {
      return;
      BackpressureUtils.getAndAddRequest(this, paramLong);
      this.subscriber.emit();
      return;
    }
    throw new IllegalArgumentException("n >= 0 required");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorMerge.MergeProducer
 * JD-Core Version:    0.7.0.1
 */