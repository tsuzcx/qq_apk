package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Action0;
import rx.functions.Func1;

final class ScalarSynchronousObservable$ScalarAsyncProducer<T>
  extends AtomicBoolean
  implements Producer, Action0
{
  private static final long serialVersionUID = -2466317989629281651L;
  final Subscriber<? super T> actual;
  final Func1<Action0, Subscription> onSchedule;
  final T value;
  
  public ScalarSynchronousObservable$ScalarAsyncProducer(Subscriber<? super T> paramSubscriber, T paramT, Func1<Action0, Subscription> paramFunc1)
  {
    this.actual = paramSubscriber;
    this.value = paramT;
    this.onSchedule = paramFunc1;
  }
  
  public void call()
  {
    Subscriber localSubscriber = this.actual;
    if (localSubscriber.isUnsubscribed()) {
      return;
    }
    Object localObject = this.value;
    try
    {
      localSubscriber.onNext(localObject);
      if (localSubscriber.isUnsubscribed()) {
        return;
      }
      localSubscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, localSubscriber, localObject);
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if ((paramLong != 0L) && (compareAndSet(false, true))) {
        this.actual.add((Subscription)this.onSchedule.call(this));
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScalarAsyncProducer[");
    localStringBuilder.append(this.value);
    localStringBuilder.append(", ");
    localStringBuilder.append(get());
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.util.ScalarSynchronousObservable.ScalarAsyncProducer
 * JD-Core Version:    0.7.0.1
 */