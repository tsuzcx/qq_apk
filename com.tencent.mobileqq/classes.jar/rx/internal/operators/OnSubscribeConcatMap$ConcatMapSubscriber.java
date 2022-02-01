package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.internal.util.ExceptionsUtils;
import rx.internal.util.ScalarSynchronousObservable;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

final class OnSubscribeConcatMap$ConcatMapSubscriber<T, R>
  extends Subscriber<T>
{
  volatile boolean active;
  final Subscriber<? super R> actual;
  final ProducerArbiter arbiter;
  final int delayErrorMode;
  volatile boolean done;
  final AtomicReference<Throwable> error;
  final SerialSubscription inner;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public OnSubscribeConcatMap$ConcatMapSubscriber(Subscriber<? super R> paramSubscriber, Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt1, int paramInt2)
  {
    this.actual = paramSubscriber;
    this.mapper = paramFunc1;
    this.delayErrorMode = paramInt2;
    this.arbiter = new ProducerArbiter();
    this.wip = new AtomicInteger();
    this.error = new AtomicReference();
    if (UnsafeAccess.isUnsafeAvailable()) {
      paramSubscriber = new SpscArrayQueue(paramInt1);
    } else {
      paramSubscriber = new SpscAtomicArrayQueue(paramInt1);
    }
    this.queue = paramSubscriber;
    this.inner = new SerialSubscription();
    request(paramInt1);
  }
  
  void drain()
  {
    if (this.wip.getAndIncrement() != 0) {
      return;
    }
    int j = this.delayErrorMode;
    do
    {
      if (this.actual.isUnsubscribed()) {
        return;
      }
      if (!this.active)
      {
        if ((j == 1) && (this.error.get() != null))
        {
          localObject = ExceptionsUtils.terminate(this.error);
          if (!ExceptionsUtils.isTerminated((Throwable)localObject)) {
            this.actual.onError((Throwable)localObject);
          }
          return;
        }
        boolean bool = this.done;
        Object localObject = this.queue.poll();
        int i;
        if (localObject == null) {
          i = 1;
        } else {
          i = 0;
        }
        if ((bool) && (i != 0))
        {
          localObject = ExceptionsUtils.terminate(this.error);
          if (localObject == null)
          {
            this.actual.onCompleted();
            return;
          }
          if (!ExceptionsUtils.isTerminated((Throwable)localObject)) {
            this.actual.onError((Throwable)localObject);
          }
          return;
        }
        if (i == 0) {
          try
          {
            localObject = (Observable)this.mapper.call(NotificationLite.instance().getValue(localObject));
            if (localObject == null)
            {
              drainError(new NullPointerException("The source returned by the mapper was null"));
              return;
            }
            if (localObject != Observable.empty()) {
              if ((localObject instanceof ScalarSynchronousObservable))
              {
                localObject = (ScalarSynchronousObservable)localObject;
                this.arbiter.setProducer(new OnSubscribeConcatMap.ConcatMapInnerScalarProducer(((ScalarSynchronousObservable)localObject).get(), this));
              }
              else
              {
                OnSubscribeConcatMap.ConcatMapInnerSubscriber localConcatMapInnerSubscriber = new OnSubscribeConcatMap.ConcatMapInnerSubscriber(this);
                this.inner.set(localConcatMapInnerSubscriber);
                if (!localConcatMapInnerSubscriber.isUnsubscribed())
                {
                  this.active = true;
                  ((Observable)localObject).unsafeSubscribe(localConcatMapInnerSubscriber);
                }
                else
                {
                  return;
                }
              }
            }
            request(1L);
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwIfFatal(localThrowable);
            drainError(localThrowable);
            return;
          }
        }
      }
    } while (this.wip.decrementAndGet() != 0);
  }
  
  void drainError(Throwable paramThrowable)
  {
    unsubscribe();
    if (ExceptionsUtils.addThrowable(this.error, paramThrowable))
    {
      paramThrowable = ExceptionsUtils.terminate(this.error);
      if (!ExceptionsUtils.isTerminated(paramThrowable)) {
        this.actual.onError(paramThrowable);
      }
    }
    else
    {
      pluginError(paramThrowable);
    }
  }
  
  void innerCompleted(long paramLong)
  {
    if (paramLong != 0L) {
      this.arbiter.produced(paramLong);
    }
    this.active = false;
    drain();
  }
  
  void innerError(Throwable paramThrowable, long paramLong)
  {
    if (!ExceptionsUtils.addThrowable(this.error, paramThrowable))
    {
      pluginError(paramThrowable);
      return;
    }
    if (this.delayErrorMode == 0)
    {
      paramThrowable = ExceptionsUtils.terminate(this.error);
      if (!ExceptionsUtils.isTerminated(paramThrowable)) {
        this.actual.onError(paramThrowable);
      }
      unsubscribe();
      return;
    }
    if (paramLong != 0L) {
      this.arbiter.produced(paramLong);
    }
    this.active = false;
    drain();
  }
  
  void innerNext(R paramR)
  {
    this.actual.onNext(paramR);
  }
  
  public void onCompleted()
  {
    this.done = true;
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (ExceptionsUtils.addThrowable(this.error, paramThrowable))
    {
      this.done = true;
      if (this.delayErrorMode == 0)
      {
        paramThrowable = ExceptionsUtils.terminate(this.error);
        if (!ExceptionsUtils.isTerminated(paramThrowable)) {
          this.actual.onError(paramThrowable);
        }
        this.inner.unsubscribe();
        return;
      }
      drain();
      return;
    }
    pluginError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!this.queue.offer(NotificationLite.instance().next(paramT)))
    {
      unsubscribe();
      onError(new MissingBackpressureException());
      return;
    }
    drain();
  }
  
  void pluginError(Throwable paramThrowable)
  {
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  void requestMore(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.arbiter.request(paramLong);
      return;
    }
    if (paramLong >= 0L) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeConcatMap.ConcatMapSubscriber
 * JD-Core Version:    0.7.0.1
 */