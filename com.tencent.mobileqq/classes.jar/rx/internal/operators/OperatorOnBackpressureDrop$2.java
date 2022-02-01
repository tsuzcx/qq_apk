package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action1;

class OperatorOnBackpressureDrop$2
  extends Subscriber<T>
{
  OperatorOnBackpressureDrop$2(OperatorOnBackpressureDrop paramOperatorOnBackpressureDrop, Subscriber paramSubscriber1, Subscriber paramSubscriber2, AtomicLong paramAtomicLong)
  {
    super(paramSubscriber1);
  }
  
  public void onCompleted()
  {
    this.val$child.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$child.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (this.val$requested.get() > 0L)
    {
      this.val$child.onNext(paramT);
      this.val$requested.decrementAndGet();
      return;
    }
    if (this.this$0.onDrop != null) {
      try
      {
        this.this$0.onDrop.call(paramT);
        return;
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this.val$child, paramT);
      }
    }
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop.2
 * JD-Core Version:    0.7.0.1
 */