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
          if (paramQueue != null) {
            paramSubscriber.onError(paramQueue);
          }
          for (;;)
          {
            return true;
            paramSubscriber.onCompleted();
          }
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
    int j = 0;
    OnSubscribeCombineLatest.CombinerSubscriber localCombinerSubscriber = this.subscribers[paramInt];
    for (;;)
    {
      int m;
      int i;
      try
      {
        m = this.latest.length;
        Object localObject = this.latest[paramInt];
        int k = this.active;
        i = k;
        if (localObject == MISSING)
        {
          i = k + 1;
          this.active = i;
        }
        k = this.complete;
        if (paramObject == null)
        {
          paramInt = k + 1;
          this.complete = paramInt;
          break label227;
          if (paramInt == m) {
            break label238;
          }
          paramInt = j;
          if (paramObject == null)
          {
            paramInt = j;
            if (localObject == MISSING) {
              break label238;
            }
          }
          if (paramInt != 0) {
            break label214;
          }
          if ((paramObject != null) && (i != 0))
          {
            this.queue.offer(localCombinerSubscriber, this.latest.clone());
            if ((i != 0) || (paramObject == null)) {
              break label222;
            }
            localCombinerSubscriber.requestMore(1L);
          }
        }
        else
        {
          this.latest[paramInt] = localCombinerSubscriber.nl.getValue(paramObject);
          paramInt = k;
          break label227;
        }
        if ((paramObject != null) || (this.error.get() == null) || ((localObject != MISSING) && (this.delayError))) {
          continue;
        }
        this.done = true;
        continue;
        this.done = true;
      }
      finally {}
      label214:
      continue;
      label222:
      drain();
      return;
      label227:
      if (i == m)
      {
        i = 1;
        continue;
        label238:
        paramInt = 1;
      }
      else
      {
        i = 0;
      }
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
    label34:
    long l2;
    int j;
    label76:
    long l1;
    if (!checkTerminated(this.done, localSpscLinkedArrayQueue.isEmpty(), localSubscriber, localSpscLinkedArrayQueue, bool2))
    {
      l2 = localAtomicLong.get();
      if (l2 != 9223372036854775807L) {
        break label164;
      }
      j = 1;
      l1 = 0L;
    }
    for (;;)
    {
      boolean bool3;
      OnSubscribeCombineLatest.CombinerSubscriber localCombinerSubscriber;
      if (l2 != 0L)
      {
        bool3 = this.done;
        localCombinerSubscriber = (OnSubscribeCombineLatest.CombinerSubscriber)localSpscLinkedArrayQueue.peek();
        if (localCombinerSubscriber != null) {
          break label169;
        }
      }
      label164:
      label169:
      for (boolean bool1 = true;; bool1 = false)
      {
        if (checkTerminated(bool3, bool1, localSubscriber, localSpscLinkedArrayQueue, bool2)) {
          break label172;
        }
        if (!bool1) {
          break label174;
        }
        if ((l1 != 0L) && (j == 0)) {
          localAtomicLong.addAndGet(l1);
        }
        i = addAndGet(-i);
        if (i == 0) {
          break;
        }
        break label34;
        break;
        j = 0;
        break label76;
      }
      label172:
      break;
      label174:
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
      }
    }
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancelled;
  }
  
  void onError(Throwable paramThrowable)
  {
    AtomicReference localAtomicReference = this.error;
    for (;;)
    {
      Throwable localThrowable = (Throwable)localAtomicReference.get();
      Object localObject;
      if (localThrowable != null) {
        if ((localThrowable instanceof CompositeException))
        {
          localObject = new ArrayList(((CompositeException)localThrowable).getExceptions());
          ((List)localObject).add(paramThrowable);
          localObject = new CompositeException((Collection)localObject);
        }
      }
      while (localAtomicReference.compareAndSet(localThrowable, localObject))
      {
        return;
        localObject = new CompositeException(Arrays.asList(new Throwable[] { localThrowable, paramThrowable }));
        continue;
        localObject = paramThrowable;
      }
    }
  }
  
  public void request(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= required but it was " + paramLong);
    }
    if (paramLong != 0L)
    {
      BackpressureUtils.getAndAddRequest(this.requested, paramLong);
      drain();
    }
  }
  
  public void subscribe(Observable<? extends T>[] paramArrayOfObservable)
  {
    int j = 0;
    OnSubscribeCombineLatest.CombinerSubscriber[] arrayOfCombinerSubscriber = this.subscribers;
    int k = arrayOfCombinerSubscriber.length;
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
    for (;;)
    {
      if ((i >= k) || (this.cancelled)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeCombineLatest.LatestCoordinator
 * JD-Core Version:    0.7.0.1
 */