package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeTimeout
  implements Completable.CompletableOnSubscribe
{
  final Completable other;
  final Scheduler scheduler;
  final Completable source;
  final long timeout;
  final TimeUnit unit;
  
  public CompletableOnSubscribeTimeout(Completable paramCompletable1, long paramLong, TimeUnit paramTimeUnit, Scheduler paramScheduler, Completable paramCompletable2)
  {
    this.source = paramCompletable1;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
    this.scheduler = paramScheduler;
    this.other = paramCompletable2;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    paramCompletableSubscriber.onSubscribe(localCompositeSubscription);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    localCompositeSubscription.add(localWorker);
    localWorker.schedule(new CompletableOnSubscribeTimeout.1(this, localAtomicBoolean, localCompositeSubscription, paramCompletableSubscriber), this.timeout, this.unit);
    this.source.subscribe(new CompletableOnSubscribeTimeout.2(this, localCompositeSubscription, localAtomicBoolean, paramCompletableSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeTimeout
 * JD-Core Version:    0.7.0.1
 */