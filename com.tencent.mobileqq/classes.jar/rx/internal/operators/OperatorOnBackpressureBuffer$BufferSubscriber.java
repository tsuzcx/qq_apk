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
    if (paramLong != null) {
      paramSubscriber = new AtomicLong(paramLong.longValue());
    } else {
      paramSubscriber = null;
    }
    this.capacity = paramSubscriber;
    this.onOverflow = paramAction0;
    this.manager = new BackpressureDrainManager(this);
    this.overflowStrategy = paramStrategy;
  }
  
  private boolean assertCapacity()
  {
    if (this.capacity == null) {
      return true;
    }
    long l;
    do
    {
      l = this.capacity.get();
      if (l <= 0L)
      {
        int i;
        try
        {
          if (this.overflowStrategy.mayAttemptDrop())
          {
            Object localObject = poll();
            if (localObject != null) {
              i = 1;
            }
          }
        }
        catch (MissingBackpressureException localMissingBackpressureException)
        {
          if (this.saturated.compareAndSet(false, true))
          {
            unsubscribe();
            this.child.onError(localMissingBackpressureException);
          }
          i = 0;
        }
        Action0 localAction0 = this.onOverflow;
        if (localAction0 != null) {
          try
          {
            localAction0.call();
          }
          catch (Throwable localThrowable)
          {
            Exceptions.throwIfFatal(localThrowable);
            this.manager.terminateAndDrain(localThrowable);
            return false;
          }
        }
        if (i == 0) {
          return false;
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
    AtomicLong localAtomicLong = this.capacity;
    if ((localAtomicLong != null) && (localObject != null)) {
      localAtomicLong.incrementAndGet();
    }
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureBuffer.BufferSubscriber
 * JD-Core Version:    0.7.0.1
 */