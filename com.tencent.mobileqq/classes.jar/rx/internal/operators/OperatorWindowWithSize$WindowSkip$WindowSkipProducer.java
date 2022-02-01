package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

final class OperatorWindowWithSize$WindowSkip$WindowSkipProducer
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = 4625807964358024108L;
  
  OperatorWindowWithSize$WindowSkip$WindowSkipProducer(OperatorWindowWithSize.WindowSkip paramWindowSkip) {}
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    OperatorWindowWithSize.WindowSkip localWindowSkip;
    if (paramLong != 0L)
    {
      localWindowSkip = this.this$0;
      if ((!get()) && (compareAndSet(false, true))) {
        OperatorWindowWithSize.WindowSkip.access$100(localWindowSkip, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(paramLong, localWindowSkip.size), BackpressureUtils.multiplyCap(localWindowSkip.skip - localWindowSkip.size, paramLong - 1L)));
      }
    }
    else
    {
      return;
    }
    OperatorWindowWithSize.WindowSkip.access$200(localWindowSkip, BackpressureUtils.multiplyCap(paramLong, localWindowSkip.skip));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowSkip.WindowSkipProducer
 * JD-Core Version:    0.7.0.1
 */