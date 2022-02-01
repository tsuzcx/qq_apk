package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.util.atomic.SpscLinkedArrayQueue;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

final class OperatorWindowWithSize$WindowOverlap<T>
  extends Subscriber<T>
  implements Action0
{
  final Subscriber<? super Observable<T>> actual;
  final Subscription cancel;
  volatile boolean done;
  final AtomicInteger drainWip;
  Throwable error;
  int index;
  int produced;
  final Queue<Subject<T, T>> queue;
  final AtomicLong requested;
  final int size;
  final int skip;
  final ArrayDeque<Subject<T, T>> windows;
  final AtomicInteger wip;
  
  public OperatorWindowWithSize$WindowOverlap(Subscriber<? super Observable<T>> paramSubscriber, int paramInt1, int paramInt2)
  {
    this.actual = paramSubscriber;
    this.size = paramInt1;
    this.skip = paramInt2;
    this.wip = new AtomicInteger(1);
    this.windows = new ArrayDeque();
    this.drainWip = new AtomicInteger();
    this.requested = new AtomicLong();
    this.cancel = Subscriptions.create(this);
    add(this.cancel);
    request(0L);
    this.queue = new SpscLinkedArrayQueue((paramInt1 + (paramInt2 - 1)) / paramInt2);
  }
  
  public void call()
  {
    if (this.wip.decrementAndGet() == 0) {
      unsubscribe();
    }
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super Subject<T, T>> paramSubscriber, Queue<Subject<T, T>> paramQueue)
  {
    if (paramSubscriber.isUnsubscribed())
    {
      paramQueue.clear();
      return true;
    }
    if (paramBoolean1)
    {
      Throwable localThrowable = this.error;
      if (localThrowable != null)
      {
        paramQueue.clear();
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
  
  Producer createProducer()
  {
    return new OperatorWindowWithSize.WindowOverlap.WindowOverlapProducer(this);
  }
  
  void drain()
  {
    AtomicInteger localAtomicInteger = this.drainWip;
    if (localAtomicInteger.getAndIncrement() != 0) {
      return;
    }
    Subscriber localSubscriber = this.actual;
    Queue localQueue = this.queue;
    int i = 1;
    int j;
    do
    {
      long l2 = this.requested.get();
      for (long l1 = 0L; l1 != l2; l1 += 1L)
      {
        boolean bool2 = this.done;
        Subject localSubject = (Subject)localQueue.poll();
        boolean bool1;
        if (localSubject == null) {
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
        localSubscriber.onNext(localSubject);
      }
      if ((l1 == l2) && (checkTerminated(this.done, localQueue.isEmpty(), localSubscriber, localQueue))) {
        return;
      }
      if ((l1 != 0L) && (l2 != 9223372036854775807L)) {
        this.requested.addAndGet(-l1);
      }
      j = localAtomicInteger.addAndGet(-i);
      i = j;
    } while (j != 0);
  }
  
  public void onCompleted()
  {
    Iterator localIterator = this.windows.iterator();
    while (localIterator.hasNext()) {
      ((Subject)localIterator.next()).onCompleted();
    }
    this.windows.clear();
    this.done = true;
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    Iterator localIterator = this.windows.iterator();
    while (localIterator.hasNext()) {
      ((Subject)localIterator.next()).onError(paramThrowable);
    }
    this.windows.clear();
    this.error = paramThrowable;
    this.done = true;
    drain();
  }
  
  public void onNext(T paramT)
  {
    int i = this.index;
    ArrayDeque localArrayDeque = this.windows;
    if ((i == 0) && (!this.actual.isUnsubscribed()))
    {
      this.wip.getAndIncrement();
      localObject = UnicastSubject.create(16, this);
      localArrayDeque.offer(localObject);
      this.queue.offer(localObject);
      drain();
    }
    Object localObject = this.windows.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Subject)((Iterator)localObject).next()).onNext(paramT);
    }
    int j = this.produced + 1;
    if (j == this.size)
    {
      this.produced = (j - this.skip);
      paramT = (Subject)localArrayDeque.poll();
      if (paramT != null) {
        paramT.onCompleted();
      }
    }
    else
    {
      this.produced = j;
    }
    i += 1;
    if (i == this.skip)
    {
      this.index = 0;
      return;
    }
    this.index = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize.WindowOverlap
 * JD-Core Version:    0.7.0.1
 */