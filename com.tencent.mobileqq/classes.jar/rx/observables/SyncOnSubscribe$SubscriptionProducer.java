package rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observer;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.internal.operators.BackpressureUtils;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;

class SyncOnSubscribe$SubscriptionProducer<S, T>
  extends AtomicLong
  implements Observer<T>, Producer, Subscription
{
  private static final long serialVersionUID = -3736864024352728072L;
  private final Subscriber<? super T> actualSubscriber;
  private boolean hasTerminated;
  private boolean onNextCalled;
  private final SyncOnSubscribe<S, T> parent;
  private S state;
  
  SyncOnSubscribe$SubscriptionProducer(Subscriber<? super T> paramSubscriber, SyncOnSubscribe<S, T> paramSyncOnSubscribe, S paramS)
  {
    this.actualSubscriber = paramSubscriber;
    this.parent = paramSyncOnSubscribe;
    this.state = paramS;
  }
  
  private void doUnsubscribe()
  {
    try
    {
      this.parent.onUnsubscribe(this.state);
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwIfFatal(localThrowable);
      RxJavaPlugins.getInstance().getErrorHandler().handleError(localThrowable);
    }
  }
  
  private void fastpath()
  {
    SyncOnSubscribe localSyncOnSubscribe = this.parent;
    Subscriber localSubscriber = this.actualSubscriber;
    try
    {
      do
      {
        this.onNextCalled = false;
        nextIteration(localSyncOnSubscribe);
      } while (!tryUnsubscribe());
      return;
    }
    catch (Throwable localThrowable)
    {
      handleThrownError(localSubscriber, localThrowable);
    }
  }
  
  private void handleThrownError(Subscriber<? super T> paramSubscriber, Throwable paramThrowable)
  {
    if (this.hasTerminated)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
      return;
    }
    this.hasTerminated = true;
    paramSubscriber.onError(paramThrowable);
    unsubscribe();
  }
  
  private void nextIteration(SyncOnSubscribe<S, T> paramSyncOnSubscribe)
  {
    this.state = paramSyncOnSubscribe.next(this.state, this);
  }
  
  private void slowPath(long paramLong)
  {
    SyncOnSubscribe localSyncOnSubscribe = this.parent;
    Subscriber localSubscriber = this.actualSubscriber;
    for (;;)
    {
      long l1 = paramLong;
      try
      {
        long l2;
        do
        {
          this.onNextCalled = false;
          nextIteration(localSyncOnSubscribe);
          if (tryUnsubscribe()) {
            return;
          }
          l2 = l1;
          if (this.onNextCalled) {
            l2 = l1 - 1L;
          }
          l1 = l2;
        } while (l2 != 0L);
        l1 = addAndGet(-paramLong);
        paramLong = l1;
        if (l1 <= 0L)
        {
          tryUnsubscribe();
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        handleThrownError(localSubscriber, localThrowable);
      }
    }
  }
  
  private boolean tryUnsubscribe()
  {
    if ((!this.hasTerminated) && (get() >= -1L)) {
      return false;
    }
    set(-1L);
    doUnsubscribe();
    return true;
  }
  
  public boolean isUnsubscribed()
  {
    return get() < 0L;
  }
  
  public void onCompleted()
  {
    if (!this.hasTerminated)
    {
      this.hasTerminated = true;
      if (!this.actualSubscriber.isUnsubscribed()) {
        this.actualSubscriber.onCompleted();
      }
      return;
    }
    throw new IllegalStateException("Terminal event already emitted.");
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (!this.hasTerminated)
    {
      this.hasTerminated = true;
      if (!this.actualSubscriber.isUnsubscribed()) {
        this.actualSubscriber.onError(paramThrowable);
      }
      return;
    }
    throw new IllegalStateException("Terminal event already emitted.");
  }
  
  public void onNext(T paramT)
  {
    if (!this.onNextCalled)
    {
      this.onNextCalled = true;
      this.actualSubscriber.onNext(paramT);
      return;
    }
    throw new IllegalStateException("onNext called multiple times!");
  }
  
  public void request(long paramLong)
  {
    if ((paramLong > 0L) && (BackpressureUtils.getAndAddRequest(this, paramLong) == 0L))
    {
      if (paramLong == 9223372036854775807L)
      {
        fastpath();
        return;
      }
      slowPath(paramLong);
    }
  }
  
  public void unsubscribe()
  {
    long l;
    do
    {
      l = get();
      if (compareAndSet(0L, -1L))
      {
        doUnsubscribe();
        return;
      }
    } while (!compareAndSet(l, -2L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.observables.SyncOnSubscribe.SubscriptionProducer
 * JD-Core Version:    0.7.0.1
 */