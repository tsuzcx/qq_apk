package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import rx.Observable.OnSubscribe;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.internal.producers.ProducerArbiter;

final class OperatorGroupBy$State<T, K>
  extends AtomicInteger
  implements Observable.OnSubscribe<T>, Producer, Subscription
{
  static final AtomicReferenceFieldUpdater<State, Subscriber> ACTUAL = AtomicReferenceFieldUpdater.newUpdater(State.class, Subscriber.class, "actual");
  static final AtomicIntegerFieldUpdater<State> CANCELLED;
  static final AtomicIntegerFieldUpdater<State> ONCE = AtomicIntegerFieldUpdater.newUpdater(State.class, "once");
  static final AtomicLongFieldUpdater<State> REQUESTED = AtomicLongFieldUpdater.newUpdater(State.class, "requested");
  private static final long serialVersionUID = -3852313036005250360L;
  volatile Subscriber<? super T> actual;
  volatile int cancelled;
  final boolean delayError;
  volatile boolean done;
  Throwable error;
  final K key;
  volatile int once;
  final OperatorGroupBy.GroupBySubscriber<?, K, T> parent;
  final Queue<Object> queue = new ConcurrentLinkedQueue();
  volatile long requested;
  
  static
  {
    CANCELLED = AtomicIntegerFieldUpdater.newUpdater(State.class, "cancelled");
  }
  
  public OperatorGroupBy$State(int paramInt, OperatorGroupBy.GroupBySubscriber<?, K, T> paramGroupBySubscriber, K paramK, boolean paramBoolean)
  {
    this.parent = paramGroupBySubscriber;
    this.key = paramK;
    this.delayError = paramBoolean;
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    if (ONCE.compareAndSet(this, 0, 1))
    {
      paramSubscriber.add(this);
      paramSubscriber.setProducer(this);
      ACTUAL.lazySet(this, paramSubscriber);
      drain();
      return;
    }
    paramSubscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber, boolean paramBoolean3)
  {
    if (this.cancelled != 0)
    {
      this.queue.clear();
      this.parent.cancel(this.key);
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable;
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          localThrowable = this.error;
          if (localThrowable != null)
          {
            paramSubscriber.onError(localThrowable);
            return true;
          }
          paramSubscriber.onCompleted();
          return true;
        }
      }
      else
      {
        localThrowable = this.error;
        if (localThrowable != null)
        {
          this.queue.clear();
          paramSubscriber.onError(localThrowable);
          return true;
        }
        if (paramBoolean2)
        {
          paramSubscriber.onCompleted();
          return true;
        }
      }
    }
    return false;
  }
  
  void drain()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    Queue localQueue = this.queue;
    boolean bool2 = this.delayError;
    Subscriber localSubscriber = this.actual;
    NotificationLite localNotificationLite = NotificationLite.instance();
    int i = 1;
    label33:
    label77:
    label223:
    for (;;)
    {
      long l2;
      int j;
      if (localSubscriber != null)
      {
        if (checkTerminated(this.done, localQueue.isEmpty(), localSubscriber, bool2)) {
          break;
        }
        l2 = this.requested;
        if (l2 != 9223372036854775807L) {
          break label186;
        }
        j = 1;
      }
      for (long l1 = 0L;; l1 -= 1L)
      {
        boolean bool3;
        Object localObject;
        if (l2 != 0L)
        {
          bool3 = this.done;
          localObject = localQueue.poll();
          if (localObject != null) {
            break label191;
          }
        }
        for (boolean bool1 = true;; bool1 = false)
        {
          if (checkTerminated(bool3, bool1, localSubscriber, bool2)) {
            break label194;
          }
          if (!bool1) {
            break label196;
          }
          if (l1 != 0L)
          {
            if (j == 0) {
              REQUESTED.addAndGet(this, l1);
            }
            this.parent.s.request(-l1);
          }
          i = addAndGet(-i);
          if (i == 0) {
            break;
          }
          if (localSubscriber != null) {
            break label223;
          }
          localSubscriber = this.actual;
          break label33;
          j = 0;
          break label77;
        }
        break;
        localSubscriber.onNext(localNotificationLite.getValue(localObject));
        l2 -= 1L;
      }
    }
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancelled != 0;
  }
  
  public void onComplete()
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
    if (paramT == null)
    {
      this.error = new NullPointerException();
      this.done = true;
    }
    for (;;)
    {
      drain();
      return;
      this.queue.offer(NotificationLite.instance().next(paramT));
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= required but it was " + paramLong);
    }
    if (paramLong != 0L)
    {
      BackpressureUtils.getAndAddRequest(REQUESTED, this, paramLong);
      drain();
    }
  }
  
  public void unsubscribe()
  {
    if ((CANCELLED.compareAndSet(this, 0, 1)) && (getAndIncrement() == 0)) {
      this.parent.cancel(this.key);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.State
 * JD-Core Version:    0.7.0.1
 */