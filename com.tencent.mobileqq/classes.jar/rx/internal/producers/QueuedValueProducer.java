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
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber)
  {
    this(paramSubscriber, (Queue)localObject);
  }
  
  public QueuedValueProducer(Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    this.child = paramSubscriber;
    this.queue = paramQueue;
    this.wip = new AtomicInteger();
  }
  
  private void drain()
  {
    if (this.wip.getAndIncrement() == 0)
    {
      Subscriber localSubscriber = this.child;
      Queue localQueue = this.queue;
      do
      {
        if (localSubscriber.isUnsubscribed()) {
          return;
        }
        this.wip.lazySet(1);
        long l2 = get();
        long l1 = 0L;
        while (l2 != 0L)
        {
          Object localObject = localQueue.poll();
          if (localObject != null) {
            try
            {
              if (localObject == NULL_SENTINEL) {
                localSubscriber.onNext(null);
              } else {
                localSubscriber.onNext(localObject);
              }
              if (localSubscriber.isUnsubscribed()) {
                return;
              }
              l2 -= 1L;
              l1 += 1L;
            }
            catch (Throwable localThrowable)
            {
              if (localObject == NULL_SENTINEL) {
                localObject = null;
              }
              Exceptions.throwOrReport(localThrowable, localSubscriber, localObject);
              return;
            }
          }
        }
        if ((l1 != 0L) && (get() != 9223372036854775807L)) {
          addAndGet(-l1);
        }
      } while (this.wip.decrementAndGet() != 0);
    }
  }
  
  public boolean offer(T paramT)
  {
    if (paramT == null)
    {
      if (!this.queue.offer(NULL_SENTINEL)) {
        return false;
      }
    }
    else if (!this.queue.offer(paramT)) {
      return false;
    }
    drain();
    return true;
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong > 0L)
      {
        BackpressureUtils.getAndAddRequest(this, paramLong);
        drain();
      }
      return;
    }
    throw new IllegalArgumentException("n >= 0 required");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.producers.QueuedValueProducer
 * JD-Core Version:    0.7.0.1
 */