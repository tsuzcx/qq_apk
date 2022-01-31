package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.internal.operators.BackpressureUtils;

public final class QueuedProducer<T>
  extends AtomicLong
  implements Observer<T>, Producer
{
  static final Object NULL_SENTINEL = new Object();
  private static final long serialVersionUID = 7277121710709137047L;
  final Subscriber<? super T> child;
  volatile boolean done;
  Throwable error;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber) {}
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    this.child = paramSubscriber;
    this.queue = paramQueue;
    this.wip = new AtomicInteger();
  }
  
  private boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.child.isUnsubscribed()) {
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable = this.error;
      if (localThrowable != null)
      {
        this.queue.clear();
        this.child.onError(localThrowable);
        return true;
      }
      if (paramBoolean2)
      {
        this.child.onCompleted();
        return true;
      }
    }
    return false;
  }
  
  private void drain()
  {
    Subscriber localSubscriber;
    Queue localQueue;
    if (this.wip.getAndIncrement() == 0)
    {
      localSubscriber = this.child;
      localQueue = this.queue;
      if (!checkTerminated(this.done, localQueue.isEmpty())) {}
    }
    else
    {
      label40:
      return;
    }
    this.wip.lazySet(1);
    long l2 = get();
    for (long l1 = 0L;; l1 = 1L + l1)
    {
      boolean bool2;
      Object localObject;
      if (l2 != 0L)
      {
        bool2 = this.done;
        localObject = localQueue.poll();
        if (localObject != null) {
          break label136;
        }
      }
      label136:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (checkTerminated(bool2, bool1)) {
          break label140;
        }
        if (localObject != null) {
          break label142;
        }
        if ((l1 != 0L) && (get() != 9223372036854775807L)) {
          addAndGet(-l1);
        }
        if (this.wip.decrementAndGet() != 0) {
          break;
        }
        return;
      }
      label140:
      break label40;
      try
      {
        label142:
        if (localObject == NULL_SENTINEL) {
          localSubscriber.onNext(null);
        } else {
          localSubscriber.onNext(localObject);
        }
      }
      catch (Throwable localThrowable)
      {
        if (localObject == NULL_SENTINEL) {}
      }
      for (;;)
      {
        Exceptions.throwOrReport(localThrowable, localSubscriber, localObject);
        return;
        localObject = null;
      }
      l2 -= 1L;
    }
  }
  
  public boolean offer(T paramT)
  {
    if (paramT == null)
    {
      if (this.queue.offer(NULL_SENTINEL)) {}
    }
    else {
      while (!this.queue.offer(paramT)) {
        return false;
      }
    }
    drain();
    return true;
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
    if (!offer(paramT)) {
      onError(new MissingBackpressureException());
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required");
    }
    if (paramLong > 0L)
    {
      BackpressureUtils.getAndAddRequest(this, paramLong);
      drain();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.producers.QueuedProducer
 * JD-Core Version:    0.7.0.1
 */