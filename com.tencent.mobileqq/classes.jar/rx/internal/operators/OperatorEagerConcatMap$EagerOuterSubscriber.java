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
      while (((Iterator)???).hasNext()) {
        ((Subscription)((Iterator)???).next()).unsubscribe();
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
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
    for (;;)
    {
      if (this.cancelled)
      {
        cleanup();
        return;
      }
      boolean bool = this.done;
      synchronized (this.subscribers)
      {
        OperatorEagerConcatMap.EagerInnerSubscriber localEagerInnerSubscriber = (OperatorEagerConcatMap.EagerInnerSubscriber)this.subscribers.peek();
        if (localEagerInnerSubscriber == null) {
          j = 1;
        } else {
          j = 0;
        }
        if (bool)
        {
          ??? = this.error;
          if (??? != null)
          {
            cleanup();
            localSubscriber.onError((Throwable)???);
            return;
          }
          if (j != 0)
          {
            localSubscriber.onCompleted();
            return;
          }
        }
        if (j == 0)
        {
          long l2 = localEagerOuterProducer.get();
          if (l2 == 9223372036854775807L) {
            j = 1;
          } else {
            j = 0;
          }
          Queue localQueue = localEagerInnerSubscriber.queue;
          long l1 = 0L;
          for (;;)
          {
            bool = localEagerInnerSubscriber.done;
            ??? = localQueue.peek();
            int k;
            if (??? == null) {
              k = 1;
            } else {
              k = 0;
            }
            if (bool)
            {
              Throwable localThrowable2 = localEagerInnerSubscriber.error;
              if (localThrowable2 != null)
              {
                cleanup();
                localSubscriber.onError(localThrowable2);
                return;
              }
              if (k != 0) {
                synchronized (this.subscribers)
                {
                  this.subscribers.poll();
                  localEagerInnerSubscriber.unsubscribe();
                  k = 1;
                }
              }
            }
            if ((k != 0) || (l2 == 0L))
            {
              k = 0;
              if (l1 != 0L)
              {
                if (j == 0) {
                  localEagerOuterProducer.addAndGet(l1);
                }
                if (k == 0) {
                  localEagerInnerSubscriber.requestMore(-l1);
                }
              }
              if (k == 0) {
                break label359;
              }
              break;
            }
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
              return;
            }
          }
        }
        label359:
        int j = this.wip.addAndGet(-i);
        i = j;
        if (j == 0) {
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject1;
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
    try
    {
      Observable localObservable = (Observable)this.mapper.call(???);
      OperatorEagerConcatMap.EagerInnerSubscriber localEagerInnerSubscriber = new OperatorEagerConcatMap.EagerInnerSubscriber(this, this.bufferSize);
      if (this.cancelled) {
        return;
      }
      synchronized (this.subscribers)
      {
        if (this.cancelled) {
          return;
        }
        this.subscribers.add(localEagerInnerSubscriber);
        if (this.cancelled) {
          return;
        }
        localObservable.unsafeSubscribe(localEagerInnerSubscriber);
        drain();
        return;
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.actual, ???);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap.EagerOuterSubscriber
 * JD-Core Version:    0.7.0.1
 */