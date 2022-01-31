package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

class OperatorSingle$1
  implements Producer
{
  private final AtomicBoolean requestedTwo = new AtomicBoolean(false);
  
  OperatorSingle$1(OperatorSingle paramOperatorSingle, OperatorSingle.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    if ((paramLong > 0L) && (this.requestedTwo.compareAndSet(false, true))) {
      this.val$parent.requestMore(2L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorSingle.1
 * JD-Core Version:    0.7.0.1
 */