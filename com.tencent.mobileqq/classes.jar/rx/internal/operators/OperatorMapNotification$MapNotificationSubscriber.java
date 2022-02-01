package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.functions.Func1;

final class OperatorMapNotification$MapNotificationSubscriber<T, R>
  extends Subscriber<T>
{
  static final long COMPLETED_FLAG = -9223372036854775808L;
  static final long REQUESTED_MASK = 9223372036854775807L;
  final Subscriber<? super R> actual;
  final AtomicLong missedRequested;
  final Func0<? extends R> onCompleted;
  final Func1<? super Throwable, ? extends R> onError;
  final Func1<? super T, ? extends R> onNext;
  long produced;
  final AtomicReference<Producer> producer;
  final AtomicLong requested;
  R value;
  
  public OperatorMapNotification$MapNotificationSubscriber(Subscriber<? super R> paramSubscriber, Func1<? super T, ? extends R> paramFunc1, Func1<? super Throwable, ? extends R> paramFunc11, Func0<? extends R> paramFunc0)
  {
    this.actual = paramSubscriber;
    this.onNext = paramFunc1;
    this.onError = paramFunc11;
    this.onCompleted = paramFunc0;
    this.requested = new AtomicLong();
    this.missedRequested = new AtomicLong();
    this.producer = new AtomicReference();
  }
  
  void accountProduced()
  {
    long l = this.produced;
    if ((l != 0L) && (this.producer.get() != null)) {
      BackpressureUtils.produced(this.requested, l);
    }
  }
  
  public void onCompleted()
  {
    accountProduced();
    try
    {
      this.value = this.onCompleted.call();
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.actual);
    }
    tryEmit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    accountProduced();
    try
    {
      this.value = this.onError.call(paramThrowable);
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.actual, paramThrowable);
    }
    tryEmit();
  }
  
  public void onNext(T paramT)
  {
    try
    {
      this.produced += 1L;
      this.actual.onNext(this.onNext.call(paramT));
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.actual, paramT);
    }
  }
  
  void requestInner(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong == 0L) {
        return;
      }
      long l1;
      long l2;
      do
      {
        long l3;
        do
        {
          l1 = this.requested.get();
          if ((l1 & 0x0) == 0L) {
            break;
          }
          l2 = 0xFFFFFFFF & l1;
          l3 = BackpressureUtils.addCap(l2, paramLong);
        } while (!this.requested.compareAndSet(l1, 0x0 | l3));
        if (l2 == 0L)
        {
          if (!this.actual.isUnsubscribed()) {
            this.actual.onNext(this.value);
          }
          if (!this.actual.isUnsubscribed()) {
            this.actual.onCompleted();
          }
        }
        return;
        l2 = BackpressureUtils.addCap(l1, paramLong);
      } while (!this.requested.compareAndSet(l1, l2));
      localObject = this.producer;
      Producer localProducer = (Producer)((AtomicReference)localObject).get();
      if (localProducer != null)
      {
        localProducer.request(paramLong);
        return;
      }
      BackpressureUtils.getAndAddRequest(this.missedRequested, paramLong);
      localObject = (Producer)((AtomicReference)localObject).get();
      if (localObject != null)
      {
        paramLong = this.missedRequested.getAndSet(0L);
        if (paramLong != 0L) {
          ((Producer)localObject).request(paramLong);
        }
      }
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("n >= 0 required but it was ");
    ((StringBuilder)localObject).append(paramLong);
    localObject = new IllegalArgumentException(((StringBuilder)localObject).toString());
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    if (this.producer.compareAndSet(null, paramProducer))
    {
      long l = this.missedRequested.getAndSet(0L);
      if (l != 0L) {
        paramProducer.request(l);
      }
      return;
    }
    throw new IllegalStateException("Producer already set!");
  }
  
  void tryEmit()
  {
    long l;
    do
    {
      l = this.requested.get();
      if ((l & 0x0) != 0L) {
        return;
      }
    } while (!this.requested.compareAndSet(l, 0x0 | l));
    if ((l != 0L) || (this.producer.get() == null))
    {
      if (!this.actual.isUnsubscribed()) {
        this.actual.onNext(this.value);
      }
      if (!this.actual.isUnsubscribed()) {
        this.actual.onCompleted();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorMapNotification.MapNotificationSubscriber
 * JD-Core Version:    0.7.0.1
 */