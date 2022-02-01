package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.observables.GroupedObservable;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

public final class OperatorGroupBy$GroupBySubscriber<T, K, V>
  extends Subscriber<T>
{
  static final AtomicIntegerFieldUpdater<GroupBySubscriber> CANCELLED;
  static final AtomicIntegerFieldUpdater<GroupBySubscriber> GROUP_COUNT = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "groupCount");
  static final Object NULL_KEY = new Object();
  static final AtomicLongFieldUpdater<GroupBySubscriber> REQUESTED;
  static final AtomicIntegerFieldUpdater<GroupBySubscriber> WIP = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "wip");
  final Subscriber<? super GroupedObservable<K, V>> actual;
  final int bufferSize;
  volatile int cancelled;
  final boolean delayError;
  volatile boolean done;
  Throwable error;
  volatile int groupCount;
  final Map<Object, OperatorGroupBy.GroupedUnicast<K, V>> groups;
  final Func1<? super T, ? extends K> keySelector;
  final OperatorGroupBy.GroupByProducer producer;
  final Queue<GroupedObservable<K, V>> queue;
  volatile long requested;
  final ProducerArbiter s;
  final Func1<? super T, ? extends V> valueSelector;
  volatile int wip;
  
  static
  {
    CANCELLED = AtomicIntegerFieldUpdater.newUpdater(GroupBySubscriber.class, "cancelled");
    REQUESTED = AtomicLongFieldUpdater.newUpdater(GroupBySubscriber.class, "requested");
  }
  
  public OperatorGroupBy$GroupBySubscriber(Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Func1<? super T, ? extends K> paramFunc1, Func1<? super T, ? extends V> paramFunc11, int paramInt, boolean paramBoolean)
  {
    this.actual = paramSubscriber;
    this.keySelector = paramFunc1;
    this.valueSelector = paramFunc11;
    this.bufferSize = paramInt;
    this.delayError = paramBoolean;
    this.groups = new ConcurrentHashMap();
    this.queue = new ConcurrentLinkedQueue();
    GROUP_COUNT.lazySet(this, 1);
    this.s = new ProducerArbiter();
    this.s.request(paramInt);
    this.producer = new OperatorGroupBy.GroupByProducer(this);
  }
  
  public void cancel()
  {
    if ((CANCELLED.compareAndSet(this, 0, 1)) && (GROUP_COUNT.decrementAndGet(this) == 0)) {
      unsubscribe();
    }
  }
  
  public void cancel(K paramK)
  {
    if (paramK == null) {
      paramK = NULL_KEY;
    }
    if ((this.groups.remove(paramK) != null) && (GROUP_COUNT.decrementAndGet(this) == 0)) {
      unsubscribe();
    }
  }
  
  boolean checkTerminated(boolean paramBoolean1, boolean paramBoolean2, Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Queue<?> paramQueue)
  {
    if (paramBoolean1)
    {
      Throwable localThrowable = this.error;
      if (localThrowable != null)
      {
        errorAll(paramSubscriber, paramQueue, localThrowable);
        return true;
      }
      if (paramBoolean2)
      {
        paramSubscriber = new ArrayList(this.groups.values());
        this.groups.clear();
        paramSubscriber = paramSubscriber.iterator();
        while (paramSubscriber.hasNext()) {
          ((OperatorGroupBy.GroupedUnicast)paramSubscriber.next()).onComplete();
        }
        this.actual.onCompleted();
        return true;
      }
    }
    return false;
  }
  
  void drain()
  {
    if (WIP.getAndIncrement(this) != 0) {
      return;
    }
    Queue localQueue = this.queue;
    Subscriber localSubscriber = this.actual;
    int i = 1;
    int j;
    do
    {
      if (checkTerminated(this.done, localQueue.isEmpty(), localSubscriber, localQueue)) {
        return;
      }
      long l2 = this.requested;
      if (l2 == 9223372036854775807L) {
        j = 1;
      } else {
        j = 0;
      }
      for (long l1 = 0L; l2 != 0L; l1 -= 1L)
      {
        boolean bool2 = this.done;
        GroupedObservable localGroupedObservable = (GroupedObservable)localQueue.poll();
        boolean bool1;
        if (localGroupedObservable == null) {
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
        localSubscriber.onNext(localGroupedObservable);
        l2 -= 1L;
      }
      if (l1 != 0L)
      {
        if (j == 0) {
          REQUESTED.addAndGet(this, l1);
        }
        this.s.request(-l1);
      }
      j = WIP.addAndGet(this, -i);
      i = j;
    } while (j != 0);
  }
  
  void errorAll(Subscriber<? super GroupedObservable<K, V>> paramSubscriber, Queue<?> paramQueue, Throwable paramThrowable)
  {
    paramQueue.clear();
    paramQueue = new ArrayList(this.groups.values());
    this.groups.clear();
    paramQueue = paramQueue.iterator();
    while (paramQueue.hasNext()) {
      ((OperatorGroupBy.GroupedUnicast)paramQueue.next()).onError(paramThrowable);
    }
    paramSubscriber.onError(paramThrowable);
  }
  
  public void onCompleted()
  {
    if (this.done) {
      return;
    }
    this.done = true;
    GROUP_COUNT.decrementAndGet(this);
    drain();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.done)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.error = paramThrowable;
    this.done = true;
    GROUP_COUNT.decrementAndGet(this);
    drain();
  }
  
  public void onNext(T paramT)
  {
    if (this.done) {
      return;
    }
    Queue localQueue = this.queue;
    Subscriber localSubscriber = this.actual;
    try
    {
      Object localObject2 = this.keySelector.call(paramT);
      int i = 1;
      Object localObject1;
      if (localObject2 != null) {
        localObject1 = localObject2;
      } else {
        localObject1 = NULL_KEY;
      }
      OperatorGroupBy.GroupedUnicast localGroupedUnicast2 = (OperatorGroupBy.GroupedUnicast)this.groups.get(localObject1);
      OperatorGroupBy.GroupedUnicast localGroupedUnicast1 = localGroupedUnicast2;
      if (localGroupedUnicast2 == null) {
        if (this.cancelled == 0)
        {
          localGroupedUnicast1 = OperatorGroupBy.GroupedUnicast.createWith(localObject2, this.bufferSize, this, this.delayError);
          this.groups.put(localObject1, localGroupedUnicast1);
          GROUP_COUNT.getAndIncrement(this);
          i = 0;
          localQueue.offer(localGroupedUnicast1);
          drain();
        }
        else
        {
          return;
        }
      }
      try
      {
        paramT = this.valueSelector.call(paramT);
        localGroupedUnicast1.onNext(paramT);
        if (i != 0) {
          this.s.request(1L);
        }
        return;
      }
      catch (Throwable paramT)
      {
        unsubscribe();
        errorAll(localSubscriber, localQueue, paramT);
        return;
      }
      return;
    }
    catch (Throwable paramT)
    {
      unsubscribe();
      errorAll(localSubscriber, localQueue, paramT);
    }
  }
  
  public void requestMore(long paramLong)
  {
    if (paramLong >= 0L)
    {
      BackpressureUtils.getAndAddRequest(REQUESTED, this, paramLong);
      drain();
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramLong);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.s.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupBySubscriber
 * JD-Core Version:    0.7.0.1
 */