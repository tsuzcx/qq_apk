package rx.internal.producers;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;

public final class QueuedValueProducer<T>
  extends AtomicLong
  implements Producer
{
  static final Object NULL_SENTINEL = new Object();
  private static final long serialVersionUID = 7277121710709137047L;
  final Subscriber<? super T> child;
  final Queue<Object> queue;
  final AtomicInteger wip;
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber) {}
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    this.child = paramSubscriber;
    this.queue = paramQueue;
    this.wip = new AtomicInteger();
  }
  
  private void drain()
  {
    Subscriber localSubscriber;
    Queue localQueue;
    if (this.wip.getAndIncrement() == 0)
    {
      localSubscriber = this.child;
      localQueue = this.queue;
    }
    label46:
    do
    {
      if (localSubscriber.isUnsubscribed()) {}
      long l1;
      Object localObject;
      for (;;)
      {
        return;
        this.wip.lazySet(1);
        long l2 = get();
        l1 = 0L;
        if (l2 == 0L) {
          break label135;
        }
        localObject = localQueue.poll();
        if (localObject == null) {
          break label135;
        }
        try
        {
          if (localObject == NULL_SENTINEL) {
            localSubscriber.onNext(null);
          }
          while (!localSubscriber.isUnsubscribed())
          {
            l2 -= 1L;
            l1 += 1L;
            break label46;
            localSubscriber.onNext(localObject);
          }
          Exceptions.throwOrReport(localThrowable, localSubscriber, localObject);
        }
        catch (Throwable localThrowable)
        {
          if (localObject == NULL_SENTINEL) {}
        }
      }
      for (;;)
      {
        return;
        localObject = null;
      }
      if ((l1 != 0L) && (get() != 9223372036854775807L)) {
        addAndGet(-l1);
      }
    } while (this.wip.decrementAndGet() != 0);
    label135:
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
 * Qualified Name:     rx.internal.producers.QueuedValueProducer
 * JD-Core Version:    0.7.0.1
 */