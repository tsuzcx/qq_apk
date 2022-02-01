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
  
  public QueuedProducer(Subscriber<? super T> paramSubscriber)
  {
    this(paramSubscriber, (Queue)localObject);
  }
  
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
    if (this.wip.getAndIncrement() == 0)
    {
      Subscriber localSubscriber = this.child;
      Queue localQueue = this.queue;
      do
      {
        if (checkTerminated(this.done, localQueue.isEmpty())) {
          return;
        }
        this.wip.lazySet(1);
        long l2 = get();
        long l1 = 0L;
        while (l2 != 0L)
        {
          boolean bool2 = this.done;
          Object localObject2 = localQueue.poll();
          boolean bool1;
          if (localObject2 == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          if (checkTerminated(bool2, bool1)) {
            return;
          }
          if (localObject2 != null)
          {
            Object localObject1 = null;
            try
            {
              if (localObject2 == NULL_SENTINEL) {
                localSubscriber.onNext(null);
              } else {
                localSubscriber.onNext(localObject2);
              }
              l2 -= 1L;
              l1 += 1L;
            }
            catch (Throwable localThrowable)
            {
              if (localObject2 != NULL_SENTINEL) {
                localObject1 = localObject2;
              }
              Exceptions.throwOrReport(localThrowable, localSubscriber, localObject1);
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
 * Qualified Name:     rx.internal.producers.QueuedProducer
 * JD-Core Version:    0.7.0.1
 */