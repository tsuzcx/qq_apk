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
    if (paramInnerProducer == null) {
      throw new NullPointerException();
    }
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
  
  void init()
  {
    add(Subscriptions.create(new OperatorReplay.ReplaySubscriber.1(this)));
  }
  
  void manageRequests()
  {
    if (isUnsubscribed()) {}
    for (;;)
    {
      return;
      try
      {
        if (this.emitting)
        {
          this.missed = true;
          return;
        }
      }
      finally {}
      this.emitting = true;
      while (!isUnsubscribed())
      {
        Object localObject2 = (OperatorReplay.InnerProducer[])this.producers.get();
        long l2 = this.maxChildRequested;
        int j = localObject2.length;
        int i = 0;
        long l1 = l2;
        while (i < j)
        {
          l1 = Math.max(l1, localObject2[i].totalRequested.get());
          i += 1;
        }
        long l3 = this.maxUpstreamRequested;
        localObject2 = this.producer;
        l2 = l1 - l2;
        if (l2 != 0L)
        {
          this.maxChildRequested = l1;
          if (localObject2 != null) {
            if (l3 != 0L)
            {
              this.maxUpstreamRequested = 0L;
              ((Producer)localObject2).request(l3 + l2);
            }
          }
        }
        for (;;)
        {
          try
          {
            if (this.missed) {
              break;
            }
            this.emitting = false;
            return;
          }
          finally {}
          localObject3.request(l2);
          continue;
          l2 = l3 + l2;
          l1 = l2;
          if (l2 < 0L) {
            l1 = 9223372036854775807L;
          }
          this.maxUpstreamRequested = l1;
          continue;
          if ((l3 != 0L) && (localObject3 != null))
          {
            this.maxUpstreamRequested = 0L;
            localObject3.request(l3);
          }
        }
        this.missed = false;
      }
    }
  }
  
  public void onCompleted()
  {
    if (!this.done) {
      this.done = true;
    }
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
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.done) {
      this.done = true;
    }
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
    OperatorReplay.InnerProducer[] arrayOfInnerProducer2 = (OperatorReplay.InnerProducer[])this.producers.get();
    if ((arrayOfInnerProducer2 == EMPTY) || (arrayOfInnerProducer2 == TERMINATED)) {}
    int m;
    int i;
    label39:
    int j;
    do
    {
      return;
      int k = -1;
      m = arrayOfInnerProducer2.length;
      i = 0;
      j = k;
      if (i < m)
      {
        if (!arrayOfInnerProducer2[i].equals(paramInnerProducer)) {
          break;
        }
        j = i;
      }
    } while (j < 0);
    OperatorReplay.InnerProducer[] arrayOfInnerProducer1;
    if (m == 1) {
      arrayOfInnerProducer1 = EMPTY;
    }
    while (this.producers.compareAndSet(arrayOfInnerProducer2, arrayOfInnerProducer1))
    {
      return;
      i += 1;
      break label39;
      arrayOfInnerProducer1 = new OperatorReplay.InnerProducer[m - 1];
      System.arraycopy(arrayOfInnerProducer2, 0, arrayOfInnerProducer1, 0, j);
      System.arraycopy(arrayOfInnerProducer2, j + 1, arrayOfInnerProducer1, j, m - j - 1);
    }
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
    if (this.producer != null) {
      throw new IllegalStateException("Only a single producer can be set on a Subscriber.");
    }
    this.producer = paramProducer;
    manageRequests();
    replay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorReplay.ReplaySubscriber
 * JD-Core Version:    0.7.0.1
 */