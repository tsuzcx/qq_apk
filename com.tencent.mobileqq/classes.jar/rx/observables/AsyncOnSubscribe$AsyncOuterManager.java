package rx.observables;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Observable;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.internal.operators.BufferUntilSubscriber;
import rx.observers.SerializedObserver;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

final class AsyncOnSubscribe$AsyncOuterManager<S, T>
  implements Observer<Observable<? extends T>>, Producer, Subscription
{
  private static final AtomicIntegerFieldUpdater<AsyncOuterManager> IS_UNSUBSCRIBED = AtomicIntegerFieldUpdater.newUpdater(AsyncOuterManager.class, "isUnsubscribed");
  Producer concatProducer;
  boolean emitting;
  long expectedDelivery;
  private boolean hasTerminated;
  private volatile int isUnsubscribed;
  private final AsyncOnSubscribe.UnicastSubject<Observable<T>> merger;
  private boolean onNextCalled;
  private final AsyncOnSubscribe<S, T> parent;
  List<Long> requests;
  private final SerializedObserver<Observable<? extends T>> serializedSubscriber;
  private S state;
  final CompositeSubscription subscriptions = new CompositeSubscription();
  
  public AsyncOnSubscribe$AsyncOuterManager(AsyncOnSubscribe<S, T> paramAsyncOnSubscribe, S paramS, AsyncOnSubscribe.UnicastSubject<Observable<T>> paramUnicastSubject)
  {
    this.parent = paramAsyncOnSubscribe;
    this.serializedSubscriber = new SerializedObserver(this);
    this.state = paramS;
    this.merger = paramUnicastSubject;
  }
  
  private void handleThrownError(Throwable paramThrowable)
  {
    if (this.hasTerminated)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.hasTerminated = true;
    this.merger.onError(paramThrowable);
    cleanup();
  }
  
  private void subscribeBufferToObservable(Observable<? extends T> paramObservable)
  {
    BufferUntilSubscriber localBufferUntilSubscriber = BufferUntilSubscriber.create();
    AsyncOnSubscribe.AsyncOuterManager.1 local1 = new AsyncOnSubscribe.AsyncOuterManager.1(this, this.expectedDelivery, localBufferUntilSubscriber);
    this.subscriptions.add(local1);
    paramObservable.doOnTerminate(new AsyncOnSubscribe.AsyncOuterManager.2(this, local1)).subscribe(local1);
    this.merger.onNext(localBufferUntilSubscriber);
  }
  
  void cleanup()
  {
    this.subscriptions.unsubscribe();
    try
    {
      this.parent.onUnsubscribe(this.state);
      return;
    }
    catch (Throwable localThrowable)
    {
      handleThrownError(localThrowable);
    }
  }
  
  public boolean isUnsubscribed()
  {
    return this.isUnsubscribed != 0;
  }
  
  public void nextIteration(long paramLong)
  {
    this.state = this.parent.next(this.state, paramLong, this.serializedSubscriber);
  }
  
  public void onCompleted()
  {
    if (this.hasTerminated) {
      throw new IllegalStateException("Terminal event already emitted.");
    }
    this.hasTerminated = true;
    this.merger.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.hasTerminated) {
      throw new IllegalStateException("Terminal event already emitted.");
    }
    this.hasTerminated = true;
    this.merger.onError(paramThrowable);
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    if (this.onNextCalled) {
      throw new IllegalStateException("onNext called multiple times!");
    }
    this.onNextCalled = true;
    if (this.hasTerminated) {
      return;
    }
    subscribeBufferToObservable(paramObservable);
  }
  
  public void request(long paramLong)
  {
    int i = 1;
    if (paramLong == 0L) {
      return;
    }
    if (paramLong < 0L) {
      throw new IllegalStateException("Request can't be negative! " + paramLong);
    }
    label93:
    Iterator localIterator;
    label162:
    do
    {
      while (!localIterator.hasNext())
      {
        try
        {
          if (this.emitting)
          {
            List localList = this.requests;
            Object localObject1 = localList;
            if (localList == null)
            {
              localObject1 = new ArrayList();
              this.requests = ((List)localObject1);
            }
            ((List)localObject1).add(Long.valueOf(paramLong));
            this.concatProducer.request(paramLong);
            if ((i != 0) || (tryEmit(paramLong))) {
              break;
            }
            try
            {
              localObject1 = this.requests;
              if (localObject1 != null) {
                break label162;
              }
              this.emitting = false;
              return;
            }
            finally {}
          }
          this.emitting = true;
          i = 0;
          break label93;
          this.requests = null;
        }
        finally {}
        localIterator = localObject3.iterator();
      }
    } while (!tryEmit(((Long)localIterator.next()).longValue()));
  }
  
  public void requestRemaining(long paramLong)
  {
    if (paramLong == 0L) {}
    do
    {
      return;
      if (paramLong < 0L) {
        throw new IllegalStateException("Request can't be negative! " + paramLong);
      }
      try
      {
        if (this.emitting)
        {
          List localList2 = this.requests;
          Object localObject1 = localList2;
          if (localList2 == null)
          {
            localObject1 = new ArrayList();
            this.requests = ((List)localObject1);
          }
          ((List)localObject1).add(Long.valueOf(paramLong));
          return;
        }
      }
      finally {}
      this.emitting = true;
    } while (tryEmit(paramLong));
    Iterator localIterator;
    do
    {
      while (!localIterator.hasNext())
      {
        try
        {
          List localList1 = this.requests;
          if (localList1 == null)
          {
            this.emitting = false;
            return;
          }
        }
        finally {}
        this.requests = null;
        localIterator = localObject3.iterator();
      }
    } while (!tryEmit(((Long)localIterator.next()).longValue()));
  }
  
  void setConcatProducer(Producer paramProducer)
  {
    if (this.concatProducer != null) {
      throw new IllegalStateException("setConcatProducer may be called at most once!");
    }
    this.concatProducer = paramProducer;
  }
  
  boolean tryEmit(long paramLong)
  {
    if (isUnsubscribed())
    {
      cleanup();
      return true;
    }
    try
    {
      this.onNextCalled = false;
      this.expectedDelivery = paramLong;
      nextIteration(paramLong);
      if ((this.hasTerminated) || (isUnsubscribed()))
      {
        cleanup();
        return true;
      }
    }
    catch (Throwable localThrowable)
    {
      handleThrownError(localThrowable);
      return true;
    }
    if (!this.onNextCalled)
    {
      handleThrownError(new IllegalStateException("No events emitted!"));
      return true;
    }
    return false;
  }
  
  public void unsubscribe()
  {
    if (IS_UNSUBSCRIBED.compareAndSet(this, 0, 1)) {
      try
      {
        if (this.emitting)
        {
          this.requests = new ArrayList();
          this.requests.add(Long.valueOf(0L));
          return;
        }
        this.emitting = true;
        cleanup();
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.AsyncOuterManager
 * JD-Core Version:    0.7.0.1
 */