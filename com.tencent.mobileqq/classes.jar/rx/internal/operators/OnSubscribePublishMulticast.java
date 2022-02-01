package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;

public final class OnSubscribePublishMulticast<T>
  extends AtomicInteger
  implements Observable.OnSubscribe<T>, Observer<T>, Subscription
{
  static final OnSubscribePublishMulticast.PublishProducer<?>[] EMPTY = new OnSubscribePublishMulticast.PublishProducer[0];
  static final OnSubscribePublishMulticast.PublishProducer<?>[] TERMINATED = new OnSubscribePublishMulticast.PublishProducer[0];
  private static final long serialVersionUID = -3741892510772238743L;
  final boolean delayError;
  volatile boolean done;
  Throwable error;
  final OnSubscribePublishMulticast.ParentSubscriber<T> parent;
  final int prefetch;
  volatile Producer producer;
  final Queue<T> queue;
  volatile OnSubscribePublishMulticast.PublishProducer<T>[] subscribers;
  
  public OnSubscribePublishMulticast(int paramInt, boolean paramBoolean)
  {
    if (paramInt <= 0) {
      throw new IllegalArgumentException("prefetch > 0 required but it was " + paramInt);
    }
    this.prefetch = paramInt;
    this.delayError = paramBoolean;
    if (UnsafeAccess.isUnsafeAvailable()) {}
    for (this.queue = new SpscArrayQueue(paramInt);; this.queue = new SpscAtomicArrayQueue(paramInt))
    {
      this.subscribers = ((OnSubscribePublishMulticast.PublishProducer[])EMPTY);
      this.parent = new OnSubscribePublishMulticast.ParentSubscriber(this);
      return;
    }
  }
  
  boolean add(OnSubscribePublishMulticast.PublishProducer<T> paramPublishProducer)
  {
    if (this.subscribers == TERMINATED) {
      return false;
    }
    OnSubscribePublishMulticast.PublishProducer[] arrayOfPublishProducer1;
    try
    {
      arrayOfPublishProducer1 = this.subscribers;
      if (arrayOfPublishProducer1 == TERMINATED) {
        return false;
      }
    }
    finally {}
    int i = arrayOfPublishProducer1.length;
    OnSubscribePublishMulticast.PublishProducer[] arrayOfPublishProducer2 = new OnSubscribePublishMulticast.PublishProducer[i + 1];
    System.arraycopy(arrayOfPublishProducer1, 0, arrayOfPublishProducer2, 0, i);
    arrayOfPublishProducer2[i] = paramPublishProducer;
    this.subscribers = arrayOfPublishProducer2;
    return true;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    Object localObject = new OnSubscribePublishMulticast.PublishProducer(paramSubscriber, this);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer((Producer)localObject);
    if (add((OnSubscribePublishMulticast.PublishProducer)localObject))
    {
      if (((OnSubscribePublishMulticast.PublishProducer)localObject).isUnsubscribed())
      {
        remove((OnSubscribePublishMulticast.PublishProducer)localObject);
        return;
      }
      drain();
      return;
    }
    localObject = this.error;
    if (localObject != null)
    {
      paramSubscriber.onError((Throwable)localObject);
      return;
    }
    paramSubscriber.onCompleted();
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = true;
    int j = 0;
    int k = 0;
    int m = 0;
    int i = 0;
    if (paramBoolean1)
    {
      Object localObject1;
      Object localObject2;
      if (this.delayError)
      {
        if (paramBoolean2)
        {
          localObject1 = terminate();
          localObject2 = this.error;
          if (localObject2 != null)
          {
            j = localObject1.length;
            for (;;)
            {
              paramBoolean1 = bool;
              if (i >= j) {
                break;
              }
              localObject1[i].actual.onError((Throwable)localObject2);
              i += 1;
            }
          }
          k = localObject1.length;
          i = j;
          for (;;)
          {
            paramBoolean1 = bool;
            if (i >= k) {
              break;
            }
            localObject1[i].actual.onCompleted();
            i += 1;
          }
        }
      }
      else
      {
        localObject1 = this.error;
        if (localObject1 != null)
        {
          this.queue.clear();
          localObject2 = terminate();
          j = localObject2.length;
          i = k;
          for (;;)
          {
            paramBoolean1 = bool;
            if (i >= j) {
              break;
            }
            localObject2[i].actual.onError((Throwable)localObject1);
            i += 1;
          }
        }
        if (paramBoolean2)
        {
          localObject1 = terminate();
          j = localObject1.length;
          i = m;
          for (;;)
          {
            paramBoolean1 = bool;
            if (i >= j) {
              break;
            }
            localObject1[i].actual.onCompleted();
            i += 1;
          }
        }
      }
    }
    paramBoolean1 = false;
    return paramBoolean1;
  }
  
  void drain()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    Queue localQueue = this.queue;
    int i = 0;
    int j;
    label200:
    label204:
    label206:
    label245:
    do
    {
      OnSubscribePublishMulticast.PublishProducer[] arrayOfPublishProducer = this.subscribers;
      int k = arrayOfPublishProducer.length;
      int m = arrayOfPublishProducer.length;
      long l1 = 9223372036854775807L;
      j = 0;
      while (j < m)
      {
        l1 = Math.min(l1, arrayOfPublishProducer[j].get());
        j += 1;
      }
      if (k != 0) {
        for (long l2 = 0L;; l2 = 1L + l2)
        {
          boolean bool2;
          Object localObject;
          if (l2 != l1)
          {
            bool2 = this.done;
            localObject = localQueue.poll();
            if (localObject != null) {
              break label200;
            }
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            if (checkTerminated(bool2, bool1)) {
              break label204;
            }
            if (!bool1) {
              break label206;
            }
            if ((l2 == l1) && (checkTerminated(this.done, localQueue.isEmpty()))) {
              break;
            }
            if (l2 == 0L) {
              break label245;
            }
            localObject = this.producer;
            if (localObject != null) {
              ((Producer)localObject).request(l2);
            }
            k = arrayOfPublishProducer.length;
            j = 0;
            while (j < k)
            {
              BackpressureUtils.produced(arrayOfPublishProducer[j], l2);
              j += 1;
            }
          }
          break;
          k = arrayOfPublishProducer.length;
          j = 0;
          while (j < k)
          {
            arrayOfPublishProducer[j].actual.onNext(localObject);
            j += 1;
          }
        }
      }
      j = addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  public boolean isUnsubscribed()
  {
    return this.parent.isUnsubscribed();
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
  
  public void onNext(T paramT)
  {
    if (!this.queue.offer(paramT))
    {
      this.parent.unsubscribe();
      this.error = new MissingBackpressureException("Queue full?!");
      this.done = true;
    }
    drain();
  }
  
  void remove(OnSubscribePublishMulticast.PublishProducer<T> paramPublishProducer)
  {
    int i = 0;
    OnSubscribePublishMulticast.PublishProducer[] arrayOfPublishProducer = this.subscribers;
    if ((arrayOfPublishProducer == TERMINATED) || (arrayOfPublishProducer == EMPTY)) {
      return;
    }
    try
    {
      arrayOfPublishProducer = this.subscribers;
      if ((arrayOfPublishProducer == TERMINATED) || (arrayOfPublishProducer == EMPTY)) {
        return;
      }
    }
    finally {}
    int k = -1;
    int m = arrayOfPublishProducer.length;
    break label132;
    int j;
    if (j < 0) {
      return;
    }
    if (m == 1) {
      paramPublishProducer = (OnSubscribePublishMulticast.PublishProducer[])EMPTY;
    }
    for (;;)
    {
      this.subscribers = paramPublishProducer;
      return;
      paramPublishProducer = new OnSubscribePublishMulticast.PublishProducer[m - 1];
      System.arraycopy(arrayOfPublishProducer, 0, paramPublishProducer, 0, j);
      System.arraycopy(arrayOfPublishProducer, j + 1, paramPublishProducer, j, m - j - 1);
    }
    for (;;)
    {
      label132:
      j = k;
      if (i >= m) {
        break;
      }
      if (arrayOfPublishProducer[i] == paramPublishProducer)
      {
        j = i;
        break;
      }
      i += 1;
    }
  }
  
  void setProducer(Producer paramProducer)
  {
    this.producer = paramProducer;
    paramProducer.request(this.prefetch);
  }
  
  public Subscriber<T> subscriber()
  {
    return this.parent;
  }
  
  OnSubscribePublishMulticast.PublishProducer<T>[] terminate()
  {
    OnSubscribePublishMulticast.PublishProducer[] arrayOfPublishProducer = this.subscribers;
    if (arrayOfPublishProducer != TERMINATED) {
      try
      {
        arrayOfPublishProducer = this.subscribers;
        if (arrayOfPublishProducer != TERMINATED) {
          this.subscribers = ((OnSubscribePublishMulticast.PublishProducer[])TERMINATED);
        }
        return arrayOfPublishProducer;
      }
      finally {}
    }
    return arrayOfPublishProducer1;
  }
  
  public void unsubscribe()
  {
    this.parent.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OnSubscribePublishMulticast
 * JD-Core Version:    0.7.0.1
 */