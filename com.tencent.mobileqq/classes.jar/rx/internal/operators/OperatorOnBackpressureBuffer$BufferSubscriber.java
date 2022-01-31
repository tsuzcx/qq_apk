package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.BackpressureOverflow.Strategy;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.BackpressureDrainManager;
import rx.internal.util.BackpressureDrainManager.BackpressureQueueCallback;

final class OperatorOnBackpressureBuffer$BufferSubscriber<T>
  extends Subscriber<T>
  implements BackpressureDrainManager.BackpressureQueueCallback
{
  private final Long baseCapacity;
  private final AtomicLong capacity;
  private final Subscriber<? super T> child;
  private final BackpressureDrainManager manager;
  private final NotificationLite<T> on = NotificationLite.instance();
  private final Action0 onOverflow;
  private final BackpressureOverflow.Strategy overflowStrategy;
  private final ConcurrentLinkedQueue<Object> queue = new ConcurrentLinkedQueue();
  private final AtomicBoolean saturated = new AtomicBoolean(false);
  
  public OperatorOnBackpressureBuffer$BufferSubscriber(Subscriber<? super T> paramSubscriber, Long paramLong, Action0 paramAction0, BackpressureOverflow.Strategy paramStrategy)
  {
    this.child = paramSubscriber;
    this.baseCapacity = paramLong;
    if (paramLong != null) {}
    for (paramSubscriber = new AtomicLong(paramLong.longValue());; paramSubscriber = null)
    {
      this.capacity = paramSubscriber;
      this.onOverflow = paramAction0;
      this.manager = new BackpressureDrainManager(this);
      this.overflowStrategy = paramStrategy;
      return;
    }
  }
  
  private boolean assertCapacity()
  {
    if (this.capacity == null) {
      return true;
    }
    long l;
    label125:
    do
    {
      l = this.capacity.get();
      if (l <= 0L) {
        for (;;)
        {
          try
          {
            if (!this.overflowStrategy.mayAttemptDrop()) {
              continue;
            }
            Object localObject = poll();
            if (localObject == null) {
              continue;
            }
            i = 1;
          }
          catch (MissingBackpressureException localMissingBackpressureException)
          {
            if (!this.saturated.compareAndSet(false, true)) {
              continue;
            }
            unsubscribe();
            this.child.onError(localMissingBackpressureException);
            int i = 0;
            continue;
          }
          if (this.onOverflow != null) {}
          try
          {
            this.onOverflow.call();
            if (i != 0) {
              break label125;
            }
            return false;
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwIfFatal(localThrowable);
            this.manager.terminateAndDrain(localThrowable);
            return false;
          }
          i = 0;
        }
      }
    } while (!this.capacity.compareAndSet(l, l - 1L));
    return true;
  }
  
  public boolean accept(Object paramObject)
  {
    return this.on.accept(this.child, paramObject);
  }
  
  public void complete(Throwable paramThrowable)
  {
    if (paramThrowable != null)
    {
      this.child.onError(paramThrowable);
      return;
    }
    this.child.onCompleted();
  }
  
  protected Producer manager()
  {
    return this.manager;
  }
  
  public void onCompleted()
  {
    if (!this.saturated.get()) {
      this.manager.terminateAndDrain();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.saturated.get()) {
      this.manager.terminateAndDrain(paramThrowable);
    }
  }
  
  public void onNext(T paramT)
  {
    if (!assertCapacity()) {
      return;
    }
    this.queue.offer(this.on.next(paramT));
    this.manager.drain();
  }
  
  public void onStart()
  {
    request(9223372036854775807L);
  }
  
  public Object peek()
  {
    return this.queue.peek();
  }
  
  public Object poll()
  {
    Object localObject = this.queue.poll();
    if ((this.capacity != null) && (localObject != null)) {
      this.capacity.incrementAndGet();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBuffer.BufferSubscriber
 * JD-Core Version:    0.7.0.1
 */