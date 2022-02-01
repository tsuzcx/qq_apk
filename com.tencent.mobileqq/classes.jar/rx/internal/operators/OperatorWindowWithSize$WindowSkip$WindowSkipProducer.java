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
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        localObject = this.this$0;
        if ((!get()) && (compareAndSet(false, true)))
        {
          OperatorWindowWithSize.WindowSkip.access$100((OperatorWindowWithSize.WindowSkip)localObject, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(paramLong, ((OperatorWindowWithSize.WindowSkip)localObject).size), BackpressureUtils.multiplyCap(((OperatorWindowWithSize.WindowSkip)localObject).skip - ((OperatorWindowWithSize.WindowSkip)localObject).size, paramLong - 1L)));
          return;
        }
        OperatorWindowWithSize.WindowSkip.access$200((OperatorWindowWithSize.WindowSkip)localObject, BackpressureUtils.multiplyCap(paramLong, ((OperatorWindowWithSize.WindowSkip)localObject).skip));
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("n >= 0 required but it was ");
    ((StringBuilder)localObject).append(paramLong);
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowSkip.WindowSkipProducer
 * JD-Core Version:    0.7.0.1
 */