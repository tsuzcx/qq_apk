package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.UnsafeAccess;

final class OperatorScan$InitialProducer<R>
  implements Observer<R>, Producer
{
  final Subscriber<? super R> child;
  volatile boolean done;
  boolean emitting;
  Throwable error;
  boolean missed;
  long missedRequested;
  volatile Producer producer;
  final Queue<Object> queue;
  final AtomicLong requested;
  
  public OperatorScan$InitialProducer(R paramR, Subscriber<? super R> paramSubscriber)
  {
    this.child = paramSubscriber;
    if (UnsafeAccess.isUnsafeAvailable()) {
      paramSubscriber = new SpscLinkedQueue();
    } else {
      paramSubscriber = new SpscLinkedAtomicQueue();
    }
    this.queue = paramSubscriber;
    paramSubscriber.offer(NotificationLite.instance().next(paramR));
    this.requested = new AtomicLong();
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super R> paramSubscriber)
  {
    if (paramSubscriber.isUnsubscribed()) {
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable = this.error;
      if (localThrowable != null)
      {
        paramSubscriber.onError(localThrowable);
        return true;
      }
      if (paramBoolean2)
      {
        paramSubscriber.onCompleted();
        return true;
      }
    }
    return false;
  }
  
  void emit()
  {
    try
    {
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
      this.emitting = true;
      emitLoop();
      return;
    }
    finally {}
  }
  
  void emitLoop()
  {
    Subscriber localSubscriber = this.child;
    Queue localQueue = this.queue;
    NotificationLite localNotificationLite = NotificationLite.instance();
    AtomicLong localAtomicLong = this.requested;
    long l1 = localAtomicLong.get();
    for (;;)
    {
      int i;
      if (l1 == 9223372036854775807L) {
        i = 1;
      } else {
        i = 0;
      }
      if (checkTerminated(this.done, localQueue.isEmpty(), localSubscriber)) {
        return;
      }
      long l3 = 0L;
      while (l1 != 0L)
      {
        boolean bool2 = this.done;
        Object localObject2 = localQueue.poll();
        boolean bool1;
        if (localObject2 == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (checkTerminated(bool2, bool1, localSubscriber)) {
          return;
        }
        if (!bool1)
        {
          localObject2 = localNotificationLite.getValue(localObject2);
          try
          {
            localSubscriber.onNext(localObject2);
            l1 -= 1L;
            l3 -= 1L;
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwOrReport(localThrowable, localSubscriber, localObject2);
            return;
          }
        }
      }
      long l2 = l1;
      if (l3 != 0L)
      {
        l2 = l1;
        if (i == 0) {
          l2 = localAtomicLong.addAndGet(l3);
        }
      }
      try
      {
        if (!this.missed)
        {
          this.emitting = false;
          return;
        }
        this.missed = false;
        l1 = l2;
      }
      finally {}
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void onCompleted()
  {
    this.done = true;
    emit();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.error = paramThrowable;
    this.done = true;
    emit();
  }
  
  public void onNext(R paramR)
  {
    this.queue.offer(NotificationLite.instance().next(paramR));
    emit();
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        BackpressureUtils.getAndAddRequest(this.requested, paramLong);
        ??? = this.producer;
        Object localObject1 = ???;
        if (??? == null) {
          synchronized (this.requested)
          {
            localObject1 = this.producer;
            if (localObject1 == null) {
              this.missedRequested = BackpressureUtils.addCap(this.missedRequested, paramLong);
            }
          }
        }
        if (localObject2 != null) {
          localObject2.request(paramLong);
        }
        emit();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setProducer(Producer paramProducer)
  {
    if (paramProducer != null) {
      synchronized (this.requested)
      {
        if (this.producer == null)
        {
          long l2 = this.missedRequested;
          long l1 = l2;
          if (l2 != 9223372036854775807L) {
            l1 = l2 - 1L;
          }
          this.missedRequested = 0L;
          this.producer = paramProducer;
          if (l1 > 0L) {
            paramProducer.request(l1);
          }
          emit();
          return;
        }
        throw new IllegalStateException("Can't set more than one Producer!");
      }
    }
    throw new NullPointerException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorScan.InitialProducer
 * JD-Core Version:    0.7.0.1
 */