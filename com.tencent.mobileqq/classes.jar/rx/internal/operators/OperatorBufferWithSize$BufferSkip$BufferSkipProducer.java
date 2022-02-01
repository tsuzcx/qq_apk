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
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    OperatorBufferWithSize.BufferSkip localBufferSkip;
    if (paramLong != 0L)
    {
      localBufferSkip = this.this$0;
      if ((!get()) && (compareAndSet(false, true))) {
        OperatorBufferWithSize.BufferSkip.access$100(localBufferSkip, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(paramLong, localBufferSkip.count), BackpressureUtils.multiplyCap(localBufferSkip.skip - localBufferSkip.count, paramLong - 1L)));
      }
    }
    else
    {
      return;
    }
    OperatorBufferWithSize.BufferSkip.access$200(localBufferSkip, BackpressureUtils.multiplyCap(paramLong, localBufferSkip.skip));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferSkip.BufferSkipProducer
 * JD-Core Version:    0.7.0.1
 */