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
    long l2 = 0L;
    long l1 = 1L;
    Queue localQueue = this.queue;
    Subscriber localSubscriber = this.child;
    NotificationLite localNotificationLite = this.on;
    long l5 = this.requested.get();
    long l4 = 0L;
    long l3 = l2;
    for (;;)
    {
      Object localObject;
      boolean bool1;
      if (l5 != l4)
      {
        boolean bool2 = this.finished;
        localObject = localQueue.poll();
        if (localObject == null)
        {
          bool1 = true;
          if (!checkTerminated(bool2, bool1, localSubscriber, localQueue)) {
            break label90;
          }
        }
      }
      label90:
      do
      {
        do
        {
          return;
          bool1 = false;
          break;
          if (!bool1) {
            break label180;
          }
        } while ((l5 == l4) && (checkTerminated(this.finished, localQueue.isEmpty(), localSubscriber, localQueue)));
        if (l4 != 0L) {
          BackpressureUtils.produced(this.requested, l4);
        }
        l4 = this.counter.addAndGet(-l1);
        l1 = l4;
        l2 = l3;
        if (l4 != 0L) {
          break;
        }
      } while (l3 == 0L);
      request(l3);
      return;
      label180:
      localSubscriber.onNext(localNotificationLite.getValue(localObject));
      l3 += 1L;
      l4 = 1L + l4;
    }
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber, Queue<Object> paramQueue)
  {
    if (paramSubscriber.isUnsubscribed())
    {
      paramQueue.clear();
      return true;
    }
    if (paramBoolean1)
    {
      if (!this.delayError) {
        break label74;
      }
      if (paramBoolean2)
      {
        paramQueue = this.error;
        if (paramQueue == null) {
          break label57;
        }
      }
    }
    label57:
    label74:
    do
    {
      for (;;)
      {
        try
        {
          paramSubscriber.onError(paramQueue);
          return false;
        }
        finally
        {
          this.recursiveScheduler.unsubscribe();
        }
        paramSubscriber.onCompleted();
      }
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
    } while (!paramBoolean2);
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
  
  void init()
  {
    Subscriber localSubscriber = this.child;
    localSubscriber.setProducer(new OperatorObserveOn.ObserveOnSubscriber.1(this));
    localSubscriber.add(this.recursiveScheduler);
    localSubscriber.add(this);
  }
  
  public void onCompleted()
  {
    if ((isUnsubscribed()) || (this.finished)) {
      return;
    }
    this.finished = true;
    schedule();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if ((isUnsubscribed()) || (this.finished))
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.error = paramThrowable;
    this.finished = true;
    schedule();
  }
  
  public void onNext(T paramT)
  {
    if ((isUnsubscribed()) || (this.finished)) {
      return;
    }
    if (!this.queue.offer(this.on.next(paramT)))
    {
      onError(new MissingBackpressureException());
      return;
    }
    schedule();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorObserveOn.ObserveOnSubscriber
 * JD-Core Version:    0.7.0.1
 */