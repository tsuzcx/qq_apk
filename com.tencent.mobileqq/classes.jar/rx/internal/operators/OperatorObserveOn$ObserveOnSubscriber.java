package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.functions.Action0;
import rx.internal.util.RxRingBuffer;
import rx.internal.util.atomic.SpscAtomicArrayQueue;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

final class OperatorObserveOn$ObserveOnSubscriber<T>
  extends Subscriber<T>
  implements Action0
{
  final Subscriber<? super T> child;
  final AtomicLong counter = new AtomicLong();
  final boolean delayError;
  Throwable error;
  volatile boolean finished;
  final NotificationLite<T> on;
  final Queue<Object> queue;
  final Scheduler.Worker recursiveScheduler;
  final AtomicLong requested = new AtomicLong();
  
  public OperatorObserveOn$ObserveOnSubscriber(Scheduler paramScheduler, Subscriber<? super T> paramSubscriber, boolean paramBoolean)
  {
    this.child = paramSubscriber;
    this.recursiveScheduler = paramScheduler.createWorker();
    this.delayError = paramBoolean;
    this.on = NotificationLite.instance();
    if (UnsafeAccess.isUnsafeAvailable())
    {
      this.queue = new SpscArrayQueue(RxRingBuffer.SIZE);
      return;
    }
    this.queue = new SpscAtomicArrayQueue(RxRingBuffer.SIZE);
  }
  
  public void call()
  {
    Queue localQueue = this.queue;
    Subscriber localSubscriber = this.child;
    NotificationLite localNotificationLite = this.on;
    long l1 = 0L;
    long l2 = 1L;
    for (;;)
    {
      long l4 = this.requested.get();
      long l3 = 0L;
      while (l4 != l3)
      {
        boolean bool2 = this.finished;
        Object localObject = localQueue.poll();
        boolean bool1;
        if (localObject == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (checkTerminated(bool2, bool1, localSubscriber, localQueue)) {
          return;
        }
        if (bool1) {
          break;
        }
        localSubscriber.onNext(localNotificationLite.getValue(localObject));
        l3 += 1L;
        l1 += 1L;
      }
      if ((l4 == l3) && (checkTerminated(this.finished, localQueue.isEmpty(), localSubscriber, localQueue))) {
        return;
      }
      if (l3 != 0L) {
        BackpressureUtils.produced(this.requested, l3);
      }
      l2 = this.counter.addAndGet(-l2);
      if (l2 == 0L)
      {
        if (l1 != 0L) {
          request(l1);
        }
        return;
      }
    }
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    if (paramSubscriber.isUnsubscribed())
    {
      paramQueue.clear();
      return true;
    }
    if (paramBoolean1) {
      if (this.delayError)
      {
        if (paramBoolean2)
        {
          paramQueue = this.error;
          if (paramQueue != null) {}
          try
          {
            paramSubscriber.onError(paramQueue);
            break label55;
            paramSubscriber.onCompleted();
          }
          finally
          {
            label55:
            this.recursiveScheduler.unsubscribe();
          }
        }
      }
      else
      {
        Throwable localThrowable = this.error;
        if (localThrowable != null)
        {
          paramQueue.clear();
          try
          {
            paramSubscriber.onError(localThrowable);
            return true;
          }
          finally
          {
            this.recursiveScheduler.unsubscribe();
          }
        }
        if (paramBoolean2) {
          try
          {
            paramSubscriber.onCompleted();
            return true;
          }
          finally
          {
            this.recursiveScheduler.unsubscribe();
          }
        }
      }
    }
    return false;
  }
  
  void init()
  {
    Subscriber localSubscriber = this.child;
    localSubscriber.setProducer(new OperatorObserveOn.ObserveOnSubscriber.1(this));
    localSubscriber.add(this.recursiveScheduler);
    localSubscriber.add(this);
  }
  
  public void onCompleted()
  {
    if (!isUnsubscribed())
    {
      if (this.finished) {
        return;
      }
      this.finished = true;
      schedule();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if ((!isUnsubscribed()) && (!this.finished))
    {
      this.error = paramThrowable;
      this.finished = true;
      schedule();
      return;
    }
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    if (!isUnsubscribed())
    {
      if (this.finished) {
        return;
      }
      if (!this.queue.offer(this.on.next(paramT)))
      {
        onError(new MissingBackpressureException());
        return;
      }
      schedule();
    }
  }
  
  public void onStart()
  {
    request(RxRingBuffer.SIZE);
  }
  
  protected void schedule()
  {
    if (this.counter.getAndIncrement() == 0L) {
      this.recursiveScheduler.schedule(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber
 * JD-Core Version:    0.7.0.1
 */