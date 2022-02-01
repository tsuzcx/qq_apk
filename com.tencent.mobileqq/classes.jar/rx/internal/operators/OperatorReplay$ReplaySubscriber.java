package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

final class OperatorReplay$ReplaySubscriber<T>
  extends Subscriber<T>
  implements Subscription
{
  static final OperatorReplay.InnerProducer[] EMPTY = new OperatorReplay.InnerProducer[0];
  static final OperatorReplay.InnerProducer[] TERMINATED = new OperatorReplay.InnerProducer[0];
  final OperatorReplay.ReplayBuffer<T> buffer;
  boolean done;
  boolean emitting;
  long maxChildRequested;
  long maxUpstreamRequested;
  boolean missed;
  final NotificationLite<T> nl;
  volatile Producer producer;
  final AtomicReference<OperatorReplay.InnerProducer[]> producers;
  final AtomicBoolean shouldConnect;
  
  public OperatorReplay$ReplaySubscriber(AtomicReference<ReplaySubscriber<T>> paramAtomicReference, OperatorReplay.ReplayBuffer<T> paramReplayBuffer)
  {
    this.buffer = paramReplayBuffer;
    this.nl = NotificationLite.instance();
    this.producers = new AtomicReference(EMPTY);
    this.shouldConnect = new AtomicBoolean();
    request(0L);
  }
  
  boolean add(OperatorReplay.InnerProducer<T> paramInnerProducer)
  {
    if (paramInnerProducer != null)
    {
      OperatorReplay.InnerProducer[] arrayOfInnerProducer1;
      OperatorReplay.InnerProducer[] arrayOfInnerProducer2;
      do
      {
        arrayOfInnerProducer1 = (OperatorReplay.InnerProducer[])this.producers.get();
        if (arrayOfInnerProducer1 == TERMINATED) {
          return false;
        }
        int i = arrayOfInnerProducer1.length;
        arrayOfInnerProducer2 = new OperatorReplay.InnerProducer[i + 1];
        System.arraycopy(arrayOfInnerProducer1, 0, arrayOfInnerProducer2, 0, i);
        arrayOfInnerProducer2[i] = paramInnerProducer;
      } while (!this.producers.compareAndSet(arrayOfInnerProducer1, arrayOfInnerProducer2));
      return true;
    }
    paramInnerProducer = new NullPointerException();
    for (;;)
    {
      throw paramInnerProducer;
    }
  }
  
  void init()
  {
    add(Subscriptions.create(new OperatorReplay.ReplaySubscriber.1(this)));
  }
  
  void manageRequests()
  {
    if (isUnsubscribed()) {
      return;
    }
    try
    {
      if (this.emitting)
      {
        this.missed = true;
        return;
      }
      this.emitting = true;
      for (;;)
      {
        if (isUnsubscribed()) {
          return;
        }
        Object localObject1 = (OperatorReplay.InnerProducer[])this.producers.get();
        long l2 = this.maxChildRequested;
        int j = localObject1.length;
        long l1 = l2;
        int i = 0;
        while (i < j)
        {
          l1 = Math.max(l1, localObject1[i].totalRequested.get());
          i += 1;
        }
        long l3 = this.maxUpstreamRequested;
        localObject1 = this.producer;
        l2 = l1 - l2;
        if (l2 != 0L)
        {
          this.maxChildRequested = l1;
          if (localObject1 != null)
          {
            if (l3 != 0L)
            {
              this.maxUpstreamRequested = 0L;
              ((Producer)localObject1).request(l3 + l2);
            }
            else
            {
              ((Producer)localObject1).request(l2);
            }
          }
          else
          {
            l2 = l3 + l2;
            l1 = l2;
            if (l2 < 0L) {
              l1 = 9223372036854775807L;
            }
            this.maxUpstreamRequested = l1;
          }
        }
        else if ((l3 != 0L) && (localObject1 != null))
        {
          this.maxUpstreamRequested = 0L;
          ((Producer)localObject1).request(l3);
        }
        try
        {
          if (!this.missed)
          {
            this.emitting = false;
            return;
          }
          this.missed = false;
        }
        finally {}
      }
      throw localObject3;
    }
    finally {}
    for (;;) {}
  }
  
  public void onCompleted()
  {
    if (!this.done)
    {
      this.done = true;
      try
      {
        this.buffer.complete();
        replay();
        return;
      }
      finally
      {
        unsubscribe();
      }
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.done)
    {
      this.done = true;
      try
      {
        this.buffer.error(paramThrowable);
        replay();
        return;
      }
      finally
      {
        unsubscribe();
      }
    }
  }
  
  public void onNext(T paramT)
  {
    if (!this.done)
    {
      this.buffer.next(paramT);
      replay();
    }
  }
  
  void remove(OperatorReplay.InnerProducer<T> paramInnerProducer)
  {
    OperatorReplay.InnerProducer[] arrayOfInnerProducer2;
    OperatorReplay.InnerProducer[] arrayOfInnerProducer1;
    do
    {
      arrayOfInnerProducer2 = (OperatorReplay.InnerProducer[])this.producers.get();
      if (arrayOfInnerProducer2 == EMPTY) {
        break;
      }
      if (arrayOfInnerProducer2 == TERMINATED) {
        return;
      }
      int k = -1;
      int m = arrayOfInnerProducer2.length;
      int i = 0;
      int j;
      for (;;)
      {
        j = k;
        if (i >= m) {
          break;
        }
        if (arrayOfInnerProducer2[i].equals(paramInnerProducer))
        {
          j = i;
          break;
        }
        i += 1;
      }
      if (j < 0) {
        return;
      }
      if (m == 1)
      {
        arrayOfInnerProducer1 = EMPTY;
      }
      else
      {
        arrayOfInnerProducer1 = new OperatorReplay.InnerProducer[m - 1];
        System.arraycopy(arrayOfInnerProducer2, 0, arrayOfInnerProducer1, 0, j);
        System.arraycopy(arrayOfInnerProducer2, j + 1, arrayOfInnerProducer1, j, m - j - 1);
      }
    } while (!this.producers.compareAndSet(arrayOfInnerProducer2, arrayOfInnerProducer1));
  }
  
  void replay()
  {
    OperatorReplay.InnerProducer[] arrayOfInnerProducer = (OperatorReplay.InnerProducer[])this.producers.get();
    int j = arrayOfInnerProducer.length;
    int i = 0;
    while (i < j)
    {
      OperatorReplay.InnerProducer localInnerProducer = arrayOfInnerProducer[i];
      this.buffer.replay(localInnerProducer);
      i += 1;
    }
  }
  
  public void setProducer(Producer paramProducer)
  {
    if (this.producer == null)
    {
      this.producer = paramProducer;
      manageRequests();
      replay();
      return;
    }
    throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.ReplaySubscriber
 * JD-Core Version:    0.7.0.1
 */