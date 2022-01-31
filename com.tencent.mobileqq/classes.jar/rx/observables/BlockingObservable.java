package rx.observables;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.annotations.Experimental;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.functions.Actions;
import rx.functions.Func1;
import rx.internal.operators.BlockingOperatorLatest;
import rx.internal.operators.BlockingOperatorMostRecent;
import rx.internal.operators.BlockingOperatorNext;
import rx.internal.operators.BlockingOperatorToFuture;
import rx.internal.operators.BlockingOperatorToIterator;
import rx.internal.operators.NotificationLite;
import rx.internal.util.BlockingUtils;
import rx.internal.util.UtilityFunctions;
import rx.subscriptions.Subscriptions;

public final class BlockingObservable<T>
{
  static final Object ON_START = new Object();
  static final Object SET_PRODUCER = new Object();
  static final Object UNSUBSCRIBE = new Object();
  private final Observable<? extends T> o;
  
  private BlockingObservable(Observable<? extends T> paramObservable)
  {
    this.o = paramObservable;
  }
  
  private T blockForSingle(Observable<? extends T> paramObservable)
  {
    AtomicReference localAtomicReference1 = new AtomicReference();
    AtomicReference localAtomicReference2 = new AtomicReference();
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    BlockingUtils.awaitForComplete(localCountDownLatch, paramObservable.subscribe(new BlockingObservable.3(this, localCountDownLatch, localAtomicReference2, localAtomicReference1)));
    if (localAtomicReference2.get() != null)
    {
      if ((localAtomicReference2.get() instanceof RuntimeException)) {
        throw ((RuntimeException)localAtomicReference2.get());
      }
      throw new RuntimeException((Throwable)localAtomicReference2.get());
    }
    return localAtomicReference1.get();
  }
  
  public static <T> BlockingObservable<T> from(Observable<? extends T> paramObservable)
  {
    return new BlockingObservable(paramObservable);
  }
  
  public T first()
  {
    return blockForSingle(this.o.first());
  }
  
  public T first(Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.first(paramFunc1));
  }
  
  public T firstOrDefault(T paramT)
  {
    return blockForSingle(this.o.map(UtilityFunctions.identity()).firstOrDefault(paramT));
  }
  
  public T firstOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.filter(paramFunc1).map(UtilityFunctions.identity()).firstOrDefault(paramT));
  }
  
  public void forEach(Action1<? super T> paramAction1)
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    AtomicReference localAtomicReference = new AtomicReference();
    BlockingUtils.awaitForComplete(localCountDownLatch, this.o.subscribe(new BlockingObservable.1(this, localCountDownLatch, localAtomicReference, paramAction1)));
    if (localAtomicReference.get() != null)
    {
      if ((localAtomicReference.get() instanceof RuntimeException)) {
        throw ((RuntimeException)localAtomicReference.get());
      }
      throw new RuntimeException((Throwable)localAtomicReference.get());
    }
  }
  
  public Iterator<T> getIterator()
  {
    return BlockingOperatorToIterator.toIterator(this.o);
  }
  
  public T last()
  {
    return blockForSingle(this.o.last());
  }
  
  public T last(Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.last(paramFunc1));
  }
  
  public T lastOrDefault(T paramT)
  {
    return blockForSingle(this.o.map(UtilityFunctions.identity()).lastOrDefault(paramT));
  }
  
  public T lastOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.filter(paramFunc1).map(UtilityFunctions.identity()).lastOrDefault(paramT));
  }
  
  public Iterable<T> latest()
  {
    return BlockingOperatorLatest.latest(this.o);
  }
  
  public Iterable<T> mostRecent(T paramT)
  {
    return BlockingOperatorMostRecent.mostRecent(this.o, paramT);
  }
  
  public Iterable<T> next()
  {
    return BlockingOperatorNext.next(this.o);
  }
  
  public T single()
  {
    return blockForSingle(this.o.single());
  }
  
  public T single(Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.single(paramFunc1));
  }
  
  public T singleOrDefault(T paramT)
  {
    return blockForSingle(this.o.map(UtilityFunctions.identity()).singleOrDefault(paramT));
  }
  
  public T singleOrDefault(T paramT, Func1<? super T, Boolean> paramFunc1)
  {
    return blockForSingle(this.o.filter(paramFunc1).map(UtilityFunctions.identity()).singleOrDefault(paramT));
  }
  
  @Experimental
  public void subscribe()
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    Throwable[] arrayOfThrowable = new Throwable[1];
    arrayOfThrowable[0] = null;
    BlockingUtils.awaitForComplete(localCountDownLatch, this.o.subscribe(new BlockingObservable.4(this, arrayOfThrowable, localCountDownLatch)));
    localCountDownLatch = arrayOfThrowable[0];
    if (localCountDownLatch != null)
    {
      if ((localCountDownLatch instanceof RuntimeException)) {
        throw ((RuntimeException)localCountDownLatch);
      }
      throw new RuntimeException(localCountDownLatch);
    }
  }
  
  @Experimental
  public void subscribe(Observer<? super T> paramObserver)
  {
    NotificationLite localNotificationLite = NotificationLite.instance();
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    Subscription localSubscription = this.o.subscribe(new BlockingObservable.5(this, localLinkedBlockingQueue, localNotificationLite));
    try
    {
      boolean bool;
      do
      {
        Object localObject2 = localLinkedBlockingQueue.poll();
        Object localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = localLinkedBlockingQueue.take();
        }
        bool = localNotificationLite.accept(paramObserver, localObject1);
      } while (!bool);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      Thread.currentThread().interrupt();
      paramObserver.onError(localInterruptedException);
      return;
    }
    finally
    {
      localSubscription.unsubscribe();
    }
  }
  
  @Experimental
  public void subscribe(Subscriber<? super T> paramSubscriber)
  {
    NotificationLite localNotificationLite = NotificationLite.instance();
    LinkedBlockingQueue localLinkedBlockingQueue = new LinkedBlockingQueue();
    Producer[] arrayOfProducer = new Producer[1];
    arrayOfProducer[0] = null;
    BlockingObservable.6 local6 = new BlockingObservable.6(this, localLinkedBlockingQueue, localNotificationLite, arrayOfProducer);
    paramSubscriber.add(local6);
    paramSubscriber.add(Subscriptions.create(new BlockingObservable.7(this, localLinkedBlockingQueue)));
    this.o.subscribe(local6);
    boolean bool;
    do
    {
      try
      {
        for (;;)
        {
          bool = paramSubscriber.isUnsubscribed();
          if (bool) {}
          Object localObject1;
          do
          {
            return;
            Object localObject2 = localLinkedBlockingQueue.poll();
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = localLinkedBlockingQueue.take();
            }
          } while ((paramSubscriber.isUnsubscribed()) || (localObject1 == UNSUBSCRIBE));
          if (localObject1 != ON_START) {
            break;
          }
          paramSubscriber.onStart();
        }
      }
      catch (InterruptedException localInterruptedException)
      {
        for (;;)
        {
          Thread.currentThread().interrupt();
          paramSubscriber.onError(localInterruptedException);
          return;
          if (localInterruptedException != SET_PRODUCER) {
            break;
          }
          paramSubscriber.setProducer(arrayOfProducer[0]);
        }
      }
      finally
      {
        local6.unsubscribe();
      }
      bool = localNotificationLite.accept(paramSubscriber, localInterruptedException);
    } while (!bool);
    local6.unsubscribe();
  }
  
  @Experimental
  public void subscribe(Action1<? super T> paramAction1)
  {
    subscribe(paramAction1, new BlockingObservable.8(this), Actions.empty());
  }
  
  @Experimental
  public void subscribe(Action1<? super T> paramAction1, Action1<? super Throwable> paramAction11)
  {
    subscribe(paramAction1, paramAction11, Actions.empty());
  }
  
  @Experimental
  public void subscribe(Action1<? super T> paramAction1, Action1<? super Throwable> paramAction11, Action0 paramAction0)
  {
    subscribe(new BlockingObservable.9(this, paramAction1, paramAction11, paramAction0));
  }
  
  public Future<T> toFuture()
  {
    return BlockingOperatorToFuture.toFuture(this.o);
  }
  
  public Iterable<T> toIterable()
  {
    return new BlockingObservable.2(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.observables.BlockingObservable
 * JD-Core Version:    0.7.0.1
 */