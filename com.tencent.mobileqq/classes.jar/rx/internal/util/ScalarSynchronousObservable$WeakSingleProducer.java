package rx.internal.util;

import rx.Observer;
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
    if (this.once) {
      return;
    }
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        this.once = true;
        localObject1 = this.actual;
        if (((Subscriber)localObject1).isUnsubscribed()) {
          return;
        }
        Object localObject2 = this.value;
        try
        {
          ((Subscriber)localObject1).onNext(localObject2);
          if (((Subscriber)localObject1).isUnsubscribed()) {
            return;
          }
          ((Subscriber)localObject1).onCompleted();
          return;
        }
        catch (Throwable localThrowable)
        {
          Exceptions.throwOrReport(localThrowable, (Observer)localObject1, localObject2);
        }
      }
      return;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("n >= required but it was ");
    ((StringBuilder)localObject1).append(paramLong);
    throw new IllegalStateException(((StringBuilder)localObject1).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.WeakSingleProducer
 * JD-Core Version:    0.7.0.1
 */