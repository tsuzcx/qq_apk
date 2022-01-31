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
      if (this.unit != null) {
        break label64;
      }
      localObject1 = this.that.get();
    }
    catch (Throwable localThrowable)
    {
      Object localObject1;
      while (!paramSubscriber.isUnsubscribed())
      {
        Exceptions.throwOrReport(localThrowable, paramSubscriber);
        return;
        Object localObject2 = this.that.get(this.time, this.unit);
      }
    }
    paramSubscriber.onNext(localObject1);
    paramSubscriber.onCompleted();
    return;
    label64:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeToObservableFuture.ToObservableFuture
 * JD-Core Version:    0.7.0.1
 */