package rx.internal.operators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.functions.FuncN;
import rx.internal.util.atomic.SpscLinkedArrayQueue;

final class OnSubscribeCombineLatest$LatestCoordinator<T, R>
  extends AtomicInteger
  implements Producer, Subscription
{
  static final Object MISSING = new Object();
  private static final long serialVersionUID = 8567835998786448817L;
  int active;
  final Subscriber<? super R> actual;
  final int bufferSize;
  volatile boolean cancelled;
  final FuncN<? extends R> combiner;
  int complete;
  final int count;
  final boolean delayError;
  volatile boolean done;
  final AtomicReference<Throwable> error;
  final Object[] latest;
  final SpscLinkedArrayQueue<Object> queue;
  final AtomicLong requested;
  final OnSubscribeCombineLatest.CombinerSubscriber<T, R>[] subscribers;
  
  public OnSubscribeCombineLatest$LatestCoordinator(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    this.actual = paramSubscriber;
    this.combiner = paramFuncN;
    this.count = paramInt1;
    this.bufferSize = paramInt2;
    this.delayError = paramBoolean;
    this.latest = new Object[paramInt1];
    Arrays.fill(this.latest, MISSING);
    this.subscribers = new OnSubscribeCombineLatest.CombinerSubscriber[paramInt1];
    this.queue = new SpscLinkedArrayQueue(paramInt2);
    this.requested = new AtomicLong();
    this.error = new AtomicReference();
  }
  
  void cancel(Queue<?> paramQueue)
  {
    paramQueue.clear();
    paramQueue = this.subscribers;
    int j = paramQueue.length;
    int i = 0;
    while (i < j)
    {
      paramQueue[i].unsubscribe();
      i += 1;
    }
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<?> paramSubscriber, Queue<?> paramQueue, boolean paramBoolean3)
  {
    if (this.cancelled)
    {
      cancel(paramQueue);
      return true;
    }
    if (paramBoolean1) {
      if (paramBoolean3)
      {
        if (paramBoolean2)
        {
          paramQueue = (Throwable)this.error.get();
          if (paramQueue != null)
          {
            paramSubscriber.onError(paramQueue);
            return true;
          }
          paramSubscriber.onCompleted();
          return true;
        }
      }
      else
      {
        Throwable localThrowable = (Throwable)this.error.get();
        if (localThrowable != null)
        {
          cancel(paramQueue);
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
  
  void combine(Object paramObject, int paramInt)
  {
    OnSubscribeCombineLatest.CombinerSubscriber localCombinerSubscriber = this.subscribers[paramInt];
    int k;
    Object localObject;
    int j;
    int i;
    try
    {
      k = this.latest.length;
      localObject = this.latest[paramInt];
      j = this.active;
      i = j;
      if (localObject == MISSING)
      {
        i = j + 1;
        this.active = i;
      }
      j = this.complete;
      if (paramObject == null)
      {
        paramInt = j + 1;
        this.complete = paramInt;
      }
      else
      {
        this.latest[paramInt] = localCombinerSubscriber.nl.getValue(paramObject);
        paramInt = j;
      }
    }
    finally {}
    if (paramInt != k)
    {
      paramInt = j;
      if (paramObject == null)
      {
        paramInt = j;
        if (localObject == MISSING) {
          break label243;
        }
      }
    }
    for (;;)
    {
      if (paramInt == 0)
      {
        if ((paramObject != null) && (i != 0)) {
          this.queue.offer(localCombinerSubscriber, this.latest.clone());
        } else if ((paramObject == null) && (this.error.get() != null) && ((localObject == MISSING) || (!this.delayError))) {
          this.done = true;
        }
      }
      else {
        this.done = true;
      }
      if ((i == 0) && (paramObject != null))
      {
        localCombinerSubscriber.requestMore(1L);
        return;
      }
      drain();
      return;
      j = 0;
      if (i == k)
      {
        i = 1;
        break;
      }
      i = 0;
      break;
      label243:
      paramInt = 1;
    }
  }
  
  void drain()
  {
    if (getAndIncrement() != 0) {
      return;
    }
    SpscLinkedArrayQueue localSpscLinkedArrayQueue = this.queue;
    Subscriber localSubscriber = this.actual;
    boolean bool2 = this.delayError;
    AtomicLong localAtomicLong = this.requested;
    int i = 1;
    int j;
    do
    {
      if (checkTerminated(this.done, localSpscLinkedArrayQueue.isEmpty(), localSubscriber, localSpscLinkedArrayQueue, bool2)) {
        return;
      }
      long l2 = localAtomicLong.get();
      if (l2 == 9223372036854775807L) {
        j = 1;
      } else {
        j = 0;
      }
      long l1 = 0L;
      while (l2 != 0L)
      {
        boolean bool3 = this.done;
        OnSubscribeCombineLatest.CombinerSubscriber localCombinerSubscriber = (OnSubscribeCombineLatest.CombinerSubscriber)localSpscLinkedArrayQueue.peek();
        boolean bool1;
        if (localCombinerSubscriber == null) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if (checkTerminated(bool3, bool1, localSubscriber, localSpscLinkedArrayQueue, bool2)) {
          return;
        }
        if (!bool1)
        {
          localSpscLinkedArrayQueue.poll();
          Object localObject = (Object[])localSpscLinkedArrayQueue.poll();
          if (localObject == null)
          {
            this.cancelled = true;
            cancel(localSpscLinkedArrayQueue);
            localSubscriber.onError(new IllegalStateException("Broken queue?! Sender received but not the array."));
            return;
          }
          try
          {
            localObject = this.combiner.call((Object[])localObject);
            localSubscriber.onNext(localObject);
            localCombinerSubscriber.requestMore(1L);
            l2 -= 1L;
            l1 -= 1L;
          }
          catch (Throwable localThrowable)
          {
            this.cancelled = true;
            cancel(localSpscLinkedArrayQueue);
            localSubscriber.onError(localThrowable);
            return;
          }
        }
      }
      if ((l1 != 0L) && (j == 0)) {
        localThrowable.addAndGet(l1);
      }
      j = addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancelled;
  }
  
  void onError(Throwable paramThrowable)
  {
    AtomicReference localAtomicReference = this.error;
    Throwable localThrowable;
    Object localObject;
    do
    {
      localThrowable = (Throwable)localAtomicReference.get();
      if (localThrowable != null)
      {
        if ((localThrowable instanceof CompositeException))
        {
          localObject = new ArrayList(((CompositeException)localThrowable).getExceptions());
          ((List)localObject).add(paramThrowable);
          localObject = new CompositeException((Collection)localObject);
        }
        else
        {
          localObject = new CompositeException(Arrays.asList(new Throwable[] { localThrowable, paramThrowable }));
        }
      }
      else {
        localObject = paramThrowable;
      }
    } while (!localAtomicReference.compareAndSet(localThrowable, localObject));
  }
  
  public void request(long paramLong)
  {
    if (paramLong >= 0L)
    {
      if (paramLong != 0L)
      {
        BackpressureUtils.getAndAddRequest(this.requested, paramLong);
        drain();
      }
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void subscribe(Observable<? extends T>[] paramArrayOfObservable)
  {
    OnSubscribeCombineLatest.CombinerSubscriber[] arrayOfCombinerSubscriber = this.subscribers;
    int k = arrayOfCombinerSubscriber.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      arrayOfCombinerSubscriber[i] = new OnSubscribeCombineLatest.CombinerSubscriber(this, i);
      i += 1;
    }
    lazySet(0);
    this.actual.add(this);
    this.actual.setProducer(this);
    i = j;
    while (i < k)
    {
      if (this.cancelled) {
        return;
      }
      paramArrayOfObservable[i].subscribe(arrayOfCombinerSubscriber[i]);
      i += 1;
    }
  }
  
  public void unsubscribe()
  {
    if (!this.cancelled)
    {
      this.cancelled = true;
      if (getAndIncrement() == 0) {
        cancel(this.queue);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest.LatestCoordinator
 * JD-Core Version:    0.7.0.1
 */