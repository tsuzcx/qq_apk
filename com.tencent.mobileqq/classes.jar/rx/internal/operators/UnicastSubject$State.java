package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable.OnSubscribe;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.exceptions.OnErrorThrowable;
import rx.functions.Action0;
import rx.internal.util.atomic.SpscLinkedAtomicQueue;
import rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import rx.internal.util.unsafe.SpscLinkedQueue;
import rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import rx.internal.util.unsafe.UnsafeAccess;
import rx.subscriptions.Subscriptions;

final class UnicastSubject$State<T>
  extends AtomicLong
  implements Observable.OnSubscribe<T>, Observer<T>, Producer, Action0
{
  private static final long serialVersionUID = -9044104859202255786L;
  volatile boolean caughtUp;
  volatile boolean done;
  boolean emitting;
  Throwable error;
  boolean missed;
  final NotificationLite<T> nl = NotificationLite.instance();
  final Queue<Object> queue;
  final AtomicReference<Subscriber<? super T>> subscriber = new AtomicReference();
  final AtomicReference<Action0> terminateOnce;
  
  public UnicastSubject$State(int paramInt, Action0 paramAction0)
  {
    if (paramAction0 != null)
    {
      paramAction0 = new AtomicReference(paramAction0);
      this.terminateOnce = paramAction0;
      if (paramInt <= 1) {
        break label83;
      }
      if (!UnsafeAccess.isUnsafeAvailable()) {
        break label71;
      }
      paramAction0 = new SpscUnboundedArrayQueue(paramInt);
    }
    for (;;)
    {
      this.queue = paramAction0;
      return;
      paramAction0 = null;
      break;
      label71:
      paramAction0 = new SpscUnboundedAtomicArrayQueue(paramInt);
      continue;
      label83:
      if (UnsafeAccess.isUnsafeAvailable()) {
        paramAction0 = new SpscLinkedQueue();
      } else {
        paramAction0 = new SpscLinkedAtomicQueue();
      }
    }
  }
  
  public void call()
  {
    doTerminate();
    this.done = true;
    try
    {
      if (this.emitting) {
        return;
      }
      this.emitting = true;
      this.queue.clear();
      return;
    }
    finally {}
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    if (this.subscriber.compareAndSet(null, paramSubscriber))
    {
      paramSubscriber.add(Subscriptions.create(this));
      paramSubscriber.setProducer(this);
      return;
    }
    paramSubscriber.onError(new IllegalStateException("Only a single subscriber is allowed"));
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super T> paramSubscriber)
  {
    if (paramSubscriber.isUnsubscribed())
    {
      this.queue.clear();
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable = this.error;
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
    return false;
  }
  
  void doTerminate()
  {
    AtomicReference localAtomicReference = this.terminateOnce;
    if (localAtomicReference != null)
    {
      Action0 localAction0 = (Action0)localAtomicReference.get();
      if ((localAction0 != null) && (localAtomicReference.compareAndSet(localAction0, null))) {
        localAction0.call();
      }
    }
  }
  
  public void onCompleted()
  {
    int i = 1;
    if (!this.done)
    {
      doTerminate();
      this.done = true;
      if (this.caughtUp) {}
    }
    else
    {
      try
      {
        if (!this.caughtUp) {}
        for (;;)
        {
          if (i == 0) {
            break;
          }
          replay();
          return;
          i = 0;
        }
        ((Subscriber)this.subscriber.get()).onCompleted();
      }
      finally {}
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    int i = 1;
    if (!this.done)
    {
      doTerminate();
      this.error = paramThrowable;
      this.done = true;
      if (this.caughtUp) {}
    }
    else
    {
      try
      {
        if (!this.caughtUp) {}
        for (;;)
        {
          if (i == 0) {
            break;
          }
          replay();
          return;
          i = 0;
        }
        ((Subscriber)this.subscriber.get()).onError(paramThrowable);
      }
      finally {}
    }
  }
  
  public void onNext(T paramT)
  {
    int i;
    if (!this.done)
    {
      if (!this.caughtUp) {
        i = 0;
      }
    }
    else {
      try
      {
        if (!this.caughtUp)
        {
          this.queue.offer(this.nl.next(paramT));
          i = 1;
        }
        if (i != 0)
        {
          replay();
          return;
        }
      }
      finally {}
    }
    Subscriber localSubscriber = (Subscriber)this.subscriber.get();
    try
    {
      localSubscriber.onNext(paramT);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, localSubscriber, paramT);
    }
  }
  
  void replay()
  {
    for (;;)
    {
      Subscriber localSubscriber;
      long l2;
      long l1;
      try
      {
        if (this.emitting)
        {
          this.missed = true;
          return;
        }
        this.emitting = true;
        Queue localQueue = this.queue;
        localSubscriber = (Subscriber)this.subscriber.get();
        int j = 0;
        if (localSubscriber != null)
        {
          if (checkTerminated(this.done, localQueue.isEmpty(), localSubscriber)) {
            break;
          }
          l2 = get();
          if (l2 != 9223372036854775807L) {
            break label209;
          }
          i = 1;
          l1 = 0L;
          if (l2 != 0L)
          {
            boolean bool2 = this.done;
            localObject3 = localQueue.poll();
            if (localObject3 != null) {
              break label214;
            }
            bool1 = true;
            if (checkTerminated(bool2, bool1, localSubscriber)) {
              break;
            }
            if (!bool1) {
              break label220;
            }
          }
          j = i;
          if (i == 0)
          {
            j = i;
            if (l1 != 0L)
            {
              addAndGet(-l1);
              j = i;
            }
          }
        }
        try
        {
          if (this.missed) {
            break label278;
          }
          if ((j != 0) && (localQueue.isEmpty())) {
            this.caughtUp = true;
          }
          this.emitting = false;
          return;
        }
        finally {}
        int i = 0;
      }
      finally {}
      label209:
      continue;
      label214:
      boolean bool1 = false;
      continue;
      label220:
      Object localObject3 = this.nl.getValue(localObject3);
      try
      {
        localSubscriber.onNext(localObject3);
        l2 -= 1L;
        l1 = 1L + l1;
      }
      catch (Throwable localThrowable)
      {
        localObject2.clear();
        Exceptions.throwIfFatal(localThrowable);
        localSubscriber.onError(OnErrorThrowable.addValueAsLastCause(localThrowable, localObject3));
        return;
      }
      label278:
      this.missed = false;
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
      replay();
    }
    while (!this.done) {
      return;
    }
    replay();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.UnicastSubject.State
 * JD-Core Version:    0.7.0.1
 */