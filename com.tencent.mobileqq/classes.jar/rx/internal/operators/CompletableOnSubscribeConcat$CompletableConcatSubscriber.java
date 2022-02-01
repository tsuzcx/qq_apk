package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import rx.Completable;
import rx.Completable.CompletableSubscriber;
import rx.Subscriber;
import rx.exceptions.MissingBackpressureException;
import rx.internal.util.unsafe.SpscArrayQueue;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.SerialSubscription;

final class CompletableOnSubscribeConcat$CompletableConcatSubscriber
  extends Subscriber<Completable>
{
  static final AtomicIntegerFieldUpdater<CompletableConcatSubscriber> ONCE = AtomicIntegerFieldUpdater.newUpdater(CompletableConcatSubscriber.class, "once");
  final Completable.CompletableSubscriber actual;
  volatile boolean done;
  final CompletableOnSubscribeConcat.CompletableConcatSubscriber.ConcatInnerSubscriber inner;
  volatile int once;
  final int prefetch;
  final SpscArrayQueue<Completable> queue;
  final SerialSubscription sr;
  final AtomicInteger wip;
  
  public CompletableOnSubscribeConcat$CompletableConcatSubscriber(Completable.CompletableSubscriber paramCompletableSubscriber, int paramInt)
  {
    this.actual = paramCompletableSubscriber;
    this.prefetch = paramInt;
    this.queue = new SpscArrayQueue(paramInt);
    this.sr = new SerialSubscription();
    this.inner = new CompletableOnSubscribeConcat.CompletableConcatSubscriber.ConcatInnerSubscriber(this);
    this.wip = new AtomicInteger();
    add(this.sr);
    request(paramInt);
  }
  
  void innerComplete()
  {
    if (this.wip.decrementAndGet() != 0) {
      next();
    }
    if (!this.done) {
      request(1L);
    }
  }
  
  void innerError(Throwable paramThrowable)
  {
    unsubscribe();
    onError(paramThrowable);
  }
  
  void next()
  {
    boolean bool = this.done;
    Completable localCompletable = (Completable)this.queue.poll();
    if (localCompletable == null)
    {
      if (bool)
      {
        if (ONCE.compareAndSet(this, 0, 1)) {
          this.actual.onCompleted();
        }
        return;
      }
      RxJavaPlugins.getInstance().getErrorHandler().handleError(new IllegalStateException("Queue is empty?!"));
      return;
    }
    localCompletable.subscribe(this.inner);
  }
  
  public void onCompleted()
  {
    if (this.done) {}
    do
    {
      return;
      this.done = true;
    } while (this.wip.getAndIncrement() != 0);
    next();
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (ONCE.compareAndSet(this, 0, 1))
    {
      this.actual.onError(paramThrowable);
      return;
    }
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  public void onNext(Completable paramCompletable)
  {
    if (!this.queue.offer(paramCompletable)) {
      onError(new MissingBackpressureException());
    }
    while (this.wip.getAndIncrement() != 0) {
      return;
    }
    next();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeConcat.CompletableConcatSubscriber
 * JD-Core Version:    0.7.0.1
 */