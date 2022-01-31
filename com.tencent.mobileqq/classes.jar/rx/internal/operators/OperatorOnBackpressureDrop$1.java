package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;

class OperatorOnBackpressureDrop$1
  implements Producer
{
  OperatorOnBackpressureDrop$1(OperatorOnBackpressureDrop paramOperatorOnBackpressureDrop, AtomicLong paramAtomicLong) {}
  
  public void request(long paramLong)
  {
    BackpressureUtils.getAndAddRequest(this.val$requested, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop.1
 * JD-Core Version:    0.7.0.1
 */