package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

final class OperatorBufferWithSize$BufferSkip$BufferSkipProducer
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = 3428177408082367154L;
  
  OperatorBufferWithSize$BufferSkip$BufferSkipProducer(OperatorBufferWithSize.BufferSkip paramBufferSkip) {}
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        localObject = this.this$0;
        if ((!get()) && (compareAndSet(false, true)))
        {
          OperatorBufferWithSize.BufferSkip.access$100((OperatorBufferWithSize.BufferSkip)localObject, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(paramLong, ((OperatorBufferWithSize.BufferSkip)localObject).count), BackpressureUtils.multiplyCap(((OperatorBufferWithSize.BufferSkip)localObject).skip - ((OperatorBufferWithSize.BufferSkip)localObject).count, paramLong - 1L)));
          return;
        }
        OperatorBufferWithSize.BufferSkip.access$200((OperatorBufferWithSize.BufferSkip)localObject, BackpressureUtils.multiplyCap(paramLong, ((OperatorBufferWithSize.BufferSkip)localObject).skip));
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("n >= 0 required but it was ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferSkip.BufferSkipProducer
 * JD-Core Version:    0.7.0.1
 */