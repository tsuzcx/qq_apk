package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

final class OperatorEagerConcatMap$EagerOuterSubscriber<T, R>
  extends Subscriber<T>
{
  final Subscriber<? super R> actual;
  final int bufferSize;
  volatile boolean cancelled;
  volatile boolean done;
  Throwable error;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  private OperatorEagerConcatMap.EagerOuterProducer sharedProducer;
  final LinkedList<OperatorEagerConcatMap.EagerInnerSubscriber<R>> subscribers;
  final AtomicInteger wip;
  
  public OperatorEagerConcatMap$EagerOuterSubscriber(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt, Subscriber<? super R> paramSubscriber)
  {
    this.mapper = paramFunc1;
    this.bufferSize = paramInt;
    this.actual = paramSubscriber;
    this.subscribers = new LinkedList();
    this.wip = new AtomicInteger();
  }
  
  void cleanup()
  {
    synchronized (this.subscribers)
    {
      ArrayList localArrayList = new ArrayList(this.subscribers);
      this.subscribers.clear();
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((Subscription)((Iterator)???).next()).unsubscribe();
      }
    }
  }
  
  void drain()
  {
    if (this.wip.getAndIncrement() != 0) {
      return;
    }
    OperatorEagerConcatMap.EagerOuterProducer localEagerOuterProducer = this.sharedProducer;
    Subscriber localSubscriber = this.actual;
    NotificationLite localNotificationLite = NotificationLite.instance();
    int i = 1;
    label30:
    if (this.cancelled)
    {
      cleanup();
      return;
    }
    boolean bool = this.done;
    OperatorEagerConcatMap.EagerInnerSubscriber localEagerInnerSubscriber;
    int j;
    for (;;)
    {
      synchronized (this.subscribers)
      {
        localEagerInnerSubscriber = (OperatorEagerConcatMap.EagerInnerSubscriber)this.subscribers.peek();
        if (localEagerInnerSubscriber == null)
        {
          j = 1;
          if (!bool) {
            break label130;
          }
          ??? = this.error;
          if (??? == null) {
            break;
          }
          cleanup();
          localSubscriber.onError((Throwable)???);
          return;
        }
      }
      j = 0;
    }
    if (j != 0)
    {
      localObject1.onCompleted();
      return;
    }
    label130:
    long l2;
    long l1;
    Queue localQueue;
    int n;
    if (j == 0)
    {
      l2 = localEagerOuterProducer.get();
      l1 = 0L;
      if (l2 == 9223372036854775807L)
      {
        j = 1;
        localQueue = localEagerInnerSubscriber.queue;
        n = 0;
      }
    }
    for (;;)
    {
      bool = localEagerInnerSubscriber.done;
      ??? = localQueue.peek();
      int k;
      if (??? == null) {
        k = 1;
      }
      for (;;)
      {
        if (bool)
        {
          Throwable localThrowable2 = localEagerInnerSubscriber.error;
          if (localThrowable2 != null)
          {
            cleanup();
            localObject1.onError(localThrowable2);
            return;
            j = 0;
            break;
            k = 0;
            continue;
          }
          if (k == 0) {}
        }
      }
      do
      {
        do
        {
          synchronized (this.subscribers)
          {
            this.subscribers.poll();
            localEagerInnerSubscriber.unsubscribe();
            m = 1;
            if (l1 != 0L)
            {
              if (j == 0) {
                localEagerOuterProducer.addAndGet(l1);
              }
              if (m == 0) {
                localEagerInnerSubscriber.requestMore(-l1);
              }
            }
            if (m != 0) {
              break label30;
            }
            i = this.wip.addAndGet(-i);
            if (i == 0) {
              break;
            }
          }
          m = n;
        } while (k != 0);
        int m = n;
      } while (l2 == 0L);
      localQueue.poll();
      try
      {
        localObserver.onNext(localNotificationLite.getValue(???));
        l2 -= 1L;
        l1 -= 1L;
      }
      catch (Throwable localThrowable1)
      {
        Exceptions.throwOrReport(localThrowable1, localObserver, ???);
      }
    }
  }
  
  void init()
  {
    this.sharedProducer = new OperatorEagerConcatMap.EagerOuterProducer(this);
    add(Subscriptions.create(new OperatorEagerConcatMap.EagerOuterSubscriber.1(this)));
    this.actual.add(this);
    this.actual.setProducer(this.sharedProducer);
  }
  
  public void onCompleted()
  {
    this.done = true;
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.error = paramThrowable;
    this.done = true;
    drain();
  }
  
  public void onNext(T arg1)
  {
    OperatorEagerConcatMap.EagerInnerSubscriber localEagerInnerSubscriber;
    do
    {
      try
      {
        Observable localObservable = (Observable)this.mapper.call(???);
        localEagerInnerSubscriber = new OperatorEagerConcatMap.EagerInnerSubscriber(this, this.bufferSize);
        if (this.cancelled) {
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        Exceptions.throwOrReport(localThrowable, this.actual, ???);
        return;
      }
      synchronized (this.subscribers)
      {
        if (this.cancelled) {
          return;
        }
      }
      this.subscribers.add(localEagerInnerSubscriber);
    } while (this.cancelled);
    localObject.unsafeSubscribe(localEagerInnerSubscriber);
    drain();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber
 * JD-Core Version:    0.7.0.1
 */