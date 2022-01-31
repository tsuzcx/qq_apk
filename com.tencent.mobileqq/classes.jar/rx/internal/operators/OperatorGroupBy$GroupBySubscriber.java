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
    if (paramK != null) {}
    for (;;)
    {
      if ((this.groups.remove(paramK) != null) && (GROUP_COUNT.decrementAndGet(this) == 0)) {
        unsubscribe();
      }
      return;
      paramK = NULL_KEY;
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
    label25:
    long l2;
    int j;
    if (!checkTerminated(this.done, localQueue.isEmpty(), localSubscriber, localQueue))
    {
      l2 = this.requested;
      if (l2 != 9223372036854775807L) {
        break label164;
      }
      j = 1;
    }
    label64:
    for (long l1 = 0L;; l1 -= 1L)
    {
      boolean bool2;
      GroupedObservable localGroupedObservable;
      if (l2 != 0L)
      {
        bool2 = this.done;
        localGroupedObservable = (GroupedObservable)localQueue.poll();
        if (localGroupedObservable != null) {
          break label169;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        if (checkTerminated(bool2, bool1, localSubscriber, localQueue)) {
          break label173;
        }
        if (!bool1) {
          break label175;
        }
        if (l1 != 0L)
        {
          if (j == 0) {
            REQUESTED.addAndGet(this, l1);
          }
          this.s.request(-l1);
        }
        i = WIP.addAndGet(this, -i);
        if (i == 0) {
          break;
        }
        break label25;
        break;
        j = 0;
        break label64;
      }
      break;
      localSubscriber.onNext(localGroupedObservable);
      l2 -= 1L;
    }
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
    for (;;)
    {
      OperatorGroupBy.GroupedUnicast localGroupedUnicast;
      try
      {
        Object localObject2 = this.keySelector.call(paramT);
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          localGroupedUnicast = (OperatorGroupBy.GroupedUnicast)this.groups.get(localObject1);
          if (localGroupedUnicast != null) {
            break label189;
          }
          if (this.cancelled != 0) {
            break;
          }
          localObject2 = OperatorGroupBy.GroupedUnicast.createWith(localObject2, this.bufferSize, this, this.delayError);
          this.groups.put(localObject1, localObject2);
          GROUP_COUNT.getAndIncrement(this);
          i = 0;
          localQueue.offer(localObject2);
          drain();
          localObject1 = localObject2;
        }
      }
      catch (Throwable paramT)
      {
        try
        {
          paramT = this.valueSelector.call(paramT);
          localObject1.onNext(paramT);
          if (i == 0) {
            break;
          }
          this.s.request(1L);
          return;
        }
        catch (Throwable paramT)
        {
          unsubscribe();
          errorAll(localSubscriber, localQueue, paramT);
          return;
        }
        paramT = paramT;
        unsubscribe();
        errorAll(localSubscriber, localQueue, paramT);
        return;
      }
      Object localObject1 = NULL_KEY;
      continue;
      label189:
      int i = 1;
      localObject1 = localGroupedUnicast;
    }
  }
  
  public void requestMore(long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("n >= 0 required but it was " + paramLong);
    }
    BackpressureUtils.getAndAddRequest(REQUESTED, this, paramLong);
    drain();
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