package rx.internal.util;

import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class ScalarSynchronousObservable$WeakSingleProducer<T>
  implements Producer
{
  final Subscriber<? super T> actual;
  boolean once;
  final T value;
  
  public ScalarSynchronousObservable$WeakSingleProducer(Subscriber<? super T> paramSubscriber, T paramT)
  {
    this.actual = paramSubscriber;
    this.value = paramT;
  }
  
  public void request(long paramLong)
  {
    if (this.once) {}
    for (;;)
    {
      return;
      if (paramLong < 0L) {
        throw new IllegalStateException("n >= required but it was " + paramLong);
      }
      if (paramLong != 0L)
      {
        this.once = true;
        Subscriber localSubscriber = this.actual;
        if (!localSubscriber.isUnsubscribed())
        {
          Object localObject = this.value;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.WeakSingleProducer
 * JD-Core Version:    0.7.0.1
 */