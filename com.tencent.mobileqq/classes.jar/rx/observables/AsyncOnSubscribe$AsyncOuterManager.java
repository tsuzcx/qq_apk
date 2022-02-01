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
    if (!this.hasTerminated)
    {
      this.hasTerminated = true;
      this.merger.onCompleted();
      return;
    }
    throw new IllegalStateException("Terminal event already emitted.");
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.hasTerminated)
    {
      this.hasTerminated = true;
      this.merger.onError(paramThrowable);
      return;
    }
    throw new IllegalStateException("Terminal event already emitted.");
  }
  
  public void onNext(Observable<? extends T> paramObservable)
  {
    if (!this.onNextCalled)
    {
      this.onNextCalled = true;
      if (this.hasTerminated) {
        return;
      }
      subscribeBufferToObservable(paramObservable);
      return;
    }
    throw new IllegalStateException("onNext called multiple times!");
  }
  
  public void request(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (paramLong >= 0L) {
      try
      {
        boolean bool = this.emitting;
        int i = 1;
        Object localObject1;
        if (bool)
        {
          List localList = this.requests;
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = new ArrayList();
            this.requests = ((List)localObject1);
          }
          ((List)localObject1).add(Long.valueOf(paramLong));
        }
        else
        {
          this.emitting = true;
          i = 0;
        }
        this.concatProducer.request(paramLong);
        if (i != 0) {
          return;
        }
        if (tryEmit(paramLong)) {
          return;
        }
        for (;;)
        {
          try
          {
            localObject1 = this.requests;
            if (localObject1 == null)
            {
              this.emitting = false;
              return;
            }
            this.requests = null;
            localObject1 = ((List)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
            } while (!tryEmit(((Long)((Iterator)localObject1).next()).longValue()));
            return;
          }
          finally {}
        }
        localObject4 = new StringBuilder();
      }
      finally {}
    }
    ((StringBuilder)localObject4).append("Request can't be negative! ");
    ((StringBuilder)localObject4).append(paramLong);
    Object localObject4 = new IllegalStateException(((StringBuilder)localObject4).toString());
    for (;;)
    {
      throw ((Throwable)localObject4);
    }
  }
  
  public void requestRemaining(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    if (paramLong >= 0L) {
      try
      {
        Object localObject1;
        if (this.emitting)
        {
          List localList = this.requests;
          localObject1 = localList;
          if (localList == null)
          {
            localObject1 = new ArrayList();
            this.requests = ((List)localObject1);
          }
          ((List)localObject1).add(Long.valueOf(paramLong));
          return;
        }
        this.emitting = true;
        if (tryEmit(paramLong)) {
          return;
        }
        for (;;)
        {
          try
          {
            localObject1 = this.requests;
            if (localObject1 == null)
            {
              this.emitting = false;
              return;
            }
            this.requests = null;
            localObject1 = ((List)localObject1).iterator();
            do
            {
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
            } while (!tryEmit(((Long)((Iterator)localObject1).next()).longValue()));
            return;
          }
          finally {}
        }
        localObject4 = new StringBuilder();
      }
      finally {}
    }
    ((StringBuilder)localObject4).append("Request can't be negative! ");
    ((StringBuilder)localObject4).append(paramLong);
    Object localObject4 = new IllegalStateException(((StringBuilder)localObject4).toString());
    for (;;)
    {
      throw ((Throwable)localObject4);
    }
  }
  
  void setConcatProducer(Producer paramProducer)
  {
    if (this.concatProducer == null)
    {
      this.concatProducer = paramProducer;
      return;
    }
    throw new IllegalStateException("setConcatProducer may be called at most once!");
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
      if ((!this.hasTerminated) && (!isUnsubscribed()))
      {
        if (!this.onNextCalled)
        {
          handleThrownError(new IllegalStateException("No events emitted!"));
          return true;
        }
      }
      else
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.observables.AsyncOnSubscribe.AsyncOuterManager
 * JD-Core Version:    0.7.0.1
 */