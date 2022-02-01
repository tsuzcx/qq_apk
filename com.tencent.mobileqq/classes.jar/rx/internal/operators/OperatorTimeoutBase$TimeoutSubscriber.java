package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import rx.Observable;
import rx.Producer;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.producers.ProducerArbiter;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

final class OperatorTimeoutBase$TimeoutSubscriber<T>
  extends Subscriber<T>
{
  long actual;
  final ProducerArbiter arbiter;
  final Scheduler.Worker inner;
  final Observable<? extends T> other;
  final SerialSubscription serial;
  final SerializedSubscriber<T> serializedSubscriber;
  boolean terminated;
  final OperatorTimeoutBase.TimeoutStub<T> timeoutStub;
  
  OperatorTimeoutBase$TimeoutSubscriber(SerializedSubscriber<T> paramSerializedSubscriber, OperatorTimeoutBase.TimeoutStub<T> paramTimeoutStub, SerialSubscription paramSerialSubscription, Observable<? extends T> paramObservable, Scheduler.Worker paramWorker)
  {
    this.serializedSubscriber = paramSerializedSubscriber;
    this.timeoutStub = paramTimeoutStub;
    this.serial = paramSerialSubscription;
    this.other = paramObservable;
    this.inner = paramWorker;
    this.arbiter = new ProducerArbiter();
  }
  
  public void onCompleted()
  {
    for (;;)
    {
      try
      {
        boolean bool = this.terminated;
        i = 1;
        if (!bool)
        {
          this.terminated = true;
          if (i != 0)
          {
            this.serial.unsubscribe();
            this.serializedSubscriber.onCompleted();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    for (;;)
    {
      try
      {
        boolean bool = this.terminated;
        i = 1;
        if (!bool)
        {
          this.terminated = true;
          if (i != 0)
          {
            this.serial.unsubscribe();
            this.serializedSubscriber.onError(paramThrowable);
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void onNext(T paramT)
  {
    try
    {
      long l;
      int i;
      if (!this.terminated)
      {
        l = this.actual + 1L;
        this.actual = l;
        i = 1;
      }
      else
      {
        l = this.actual;
        i = 0;
      }
      if (i != 0)
      {
        this.serializedSubscriber.onNext(paramT);
        this.serial.set((Subscription)this.timeoutStub.call(this, Long.valueOf(l), paramT, this.inner));
      }
      return;
    }
    finally {}
  }
  
  public void onTimeout(long paramLong)
  {
    for (;;)
    {
      try
      {
        long l = this.actual;
        i = 1;
        if ((paramLong == l) && (!this.terminated))
        {
          this.terminated = true;
          if (i != 0)
          {
            if (this.other == null)
            {
              this.serializedSubscriber.onError(new TimeoutException());
              return;
            }
            OperatorTimeoutBase.TimeoutSubscriber.1 local1 = new OperatorTimeoutBase.TimeoutSubscriber.1(this);
            this.other.unsafeSubscribe(local1);
            this.serial.set(local1);
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase.TimeoutSubscriber
 * JD-Core Version:    0.7.0.1
 */