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
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        localObject = this.this$0;
        if ((!get()) && (compareAndSet(false, true)))
        {
          OperatorWindowWithSize.WindowOverlap.access$300((OperatorWindowWithSize.WindowOverlap)localObject, BackpressureUtils.addCap(BackpressureUtils.multiplyCap(((OperatorWindowWithSize.WindowOverlap)localObject).skip, paramLong - 1L), ((OperatorWindowWithSize.WindowOverlap)localObject).size));
        }
        else
        {
          long l = BackpressureUtils.multiplyCap(((OperatorWindowWithSize.WindowOverlap)localObject).skip, paramLong);
          OperatorWindowWithSize.WindowOverlap.access$400(this.this$0, l);
        }
        BackpressureUtils.getAndAddRequest(((OperatorWindowWithSize.WindowOverlap)localObject).requested, paramLong);
        ((OperatorWindowWithSize.WindowOverlap)localObject).drain();
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
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowOverlap.WindowOverlapProducer
 * JD-Core Version:    0.7.0.1
 */