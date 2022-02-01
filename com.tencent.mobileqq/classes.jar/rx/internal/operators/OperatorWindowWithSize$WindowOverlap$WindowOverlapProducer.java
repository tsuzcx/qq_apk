package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

final class OperatorWindowWithSize$WindowOverlap$WindowOverlapProducer
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = 4625807964358024108L;
  
  OperatorWindowWithSize$WindowOverlap$WindowOverlapProducer(OperatorWindowWithSize.WindowOverlap paramWindowOverlap) {}
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    OperatorWindowWithSize.WindowOverlap localWindowOverlap;
    if (paramLong != 0L)
    {
      localWindowOverlap = this.this$0;
      if ((get()) || (!compareAndSet(false, true))) {
        break label103;
      }
      OperatorWindowWithSize.WindowOverlap.access$300(localWindowOverlap, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(localWindowOverlap.skip, paramLong - 1L), localWindowOverlap.size));
    }
    for (;;)
    {
      BackpressureUtils.getAndAddRequest(localWindowOverlap.requested, paramLong);
      localWindowOverlap.drain();
      return;
      label103:
      long l = BackpressureUtils.multiplyCap(localWindowOverlap.skip, paramLong);
      OperatorWindowWithSize.WindowOverlap.access$400(this.this$0, l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowOverlap.WindowOverlapProducer
 * JD-Core Version:    0.7.0.1
 */