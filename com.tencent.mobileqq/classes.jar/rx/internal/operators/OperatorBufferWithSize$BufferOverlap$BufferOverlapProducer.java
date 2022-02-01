package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

final class OperatorBufferWithSize$BufferOverlap$BufferOverlapProducer
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = -4015894850868853147L;
  
  OperatorBufferWithSize$BufferOverlap$BufferOverlapProducer(OperatorBufferWithSize.BufferOverlap paramBufferOverlap) {}
  
  public void request(long paramLong)
  {
    OperatorBufferWithSize.BufferOverlap localBufferOverlap = this.this$0;
    if ((BackpressureUtils.postCompleteRequest(localBufferOverlap.requested, paramLong, localBufferOverlap.queue, localBufferOverlap.actual)) && (paramLong != 0L))
    {
      if ((!get()) && (compareAndSet(false, true))) {
        OperatorBufferWithSize.BufferOverlap.access$300(localBufferOverlap, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(localBufferOverlap.skip, paramLong - 1L), localBufferOverlap.count));
      }
    }
    else {
      return;
    }
    OperatorBufferWithSize.BufferOverlap.access$400(localBufferOverlap, BackpressureUtils.multiplyCap(localBufferOverlap.skip, paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize.BufferOverlap.BufferOverlapProducer
 * JD-Core Version:    0.7.0.1
 */