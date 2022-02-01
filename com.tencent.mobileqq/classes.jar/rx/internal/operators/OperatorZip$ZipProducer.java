package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

final class OperatorZip$ZipProducer<R>
  extends AtomicLong
  implements Producer
{
  private static final long serialVersionUID = -1216676403723546796L;
  private OperatorZip.Zip<R> zipper;
  
  public OperatorZip$ZipProducer(OperatorZip.Zip<R> paramZip)
  {
    this.zipper = paramZip;
  }
  
  public void request(long paramLong)
  {
    BackpressureUtils.getAndAddRequest(this, paramLong);
    this.zipper.tick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorZip.ZipProducer
 * JD-Core Version:    0.7.0.1
 */