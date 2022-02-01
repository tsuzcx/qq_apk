package rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.subscriptions.Subscriptions;

class OnSubscribeToObservableFuture$ToObservableFuture<T>
  implements Observable.OnSubscribe<T>
{
  final Future<? extends T> that;
  private final long time;
  private final TimeUnit unit;
  
  public OnSubscribeToObservableFuture$ToObservableFuture(Future<? extends T> paramFuture)
  {
    this.that = paramFuture;
    this.time = 0L;
    this.unit = null;
  }
  
  public OnSubscribeToObservableFuture$ToObservableFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    this.that = paramFuture;
    this.time = paramLong;
    this.unit = paramTimeUnit;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    paramSubscriber.add(Subscriptions.create(new OnSubscribeToObservableFuture.ToObservableFuture.1(this)));
    try
    {
      if (paramSubscriber.isUnsubscribed()) {
        return;
      }
      Object localObject;
      if (this.unit == null) {
        localObject = this.that.get();
      } else {
        localObject = this.that.get(this.time, this.unit);
      }
      paramSubscriber.onNext(localObject);
      paramSubscriber.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      if (paramSubscriber.isUnsubscribed()) {
        return;
      }
      Exceptions.throwOrReport(localThrowable, paramSubscriber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture.ToObservableFuture
 * JD-Core Version:    0.7.0.1
 */