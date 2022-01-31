package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

public final class SingleProducer<T>
  extends AtomicBoolean
  implements Producer
{
  private static final long serialVersionUID = -3353584923995471404L;
  final Subscriber<? super T> child;
  final T value;
  
  public SingleProducer(Subscriber<? super T> paramSubscriber, T paramT)
  {
    this.child = paramSubscriber;
    this.value = paramT;
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if (paramLong == 0L) {
      break label22;
    }
    for (;;)
    {
      label22:
      return;
      if (compareAndSet(false, true))
      {
        Subscriber localSubscriber = this.child;
        Object localObject = this.value;
        if (localSubscriber.isUnsubscribed()) {
          break;
        }
        try
        {
          localSubscriber.onNext(localObject);
          if (!localSubscriber.isUnsubscribed())
          {
            localSubscriber.onCompleted();
            return;
          }
        }
        catch (Throwable localThrowable)
        {
          Exceptions.throwOrReport(localThrowable, localSubscriber, localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.producers.SingleProducer
 * JD-Core Version:    0.7.0.1
 */