package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;

class OperatorElementAt$InnerProducer
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = 1L;
  final Producer actual;
  
  public OperatorElementAt$InnerProducer(Producer paramProducer)
  {
    this.actual = paramProducer;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if ((paramLong > 0L) && (compareAndSet(false, true))) {
      this.actual.request(9223372036854775807L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorElementAt.InnerProducer
 * JD-Core Version:    0.7.0.1
 */