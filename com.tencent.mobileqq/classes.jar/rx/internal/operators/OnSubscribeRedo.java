package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.observers.Subscribers;
import rx.schedulers.Schedulers;
import rx.subjects.BehaviorSubject;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeRedo<T>
  implements Observable.OnSubscribe<T>
{
  static final Func1<Observable<? extends Notification<?>>, Observable<?>> REDO_INFINITE = new OnSubscribeRedo.1();
  private final Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> controlHandlerFunction;
  private final Scheduler scheduler;
  final Observable<T> source;
  final boolean stopOnComplete;
  final boolean stopOnError;
  
  private OnSubscribeRedo(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, boolean paramBoolean1, boolean paramBoolean2, Scheduler paramScheduler)
  {
    this.source = paramObservable;
    this.controlHandlerFunction = paramFunc1;
    this.stopOnComplete = paramBoolean1;
    this.stopOnError = paramBoolean2;
    this.scheduler = paramScheduler;
  }
  
  public static <T> Observable<T> redo(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, false, paramScheduler));
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable)
  {
    return repeat(paramObservable, Schedulers.trampoline());
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, long paramLong)
  {
    return repeat(paramObservable, paramLong, Schedulers.trampoline());
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, long paramLong, Scheduler paramScheduler)
  {
    if (paramLong == 0L) {
      return Observable.empty();
    }
    if (paramLong < 0L) {
      throw new IllegalArgumentException("count >= 0 expected");
    }
    return repeat(paramObservable, new OnSubscribeRedo.RedoFinite(paramLong - 1L), paramScheduler);
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Scheduler paramScheduler)
  {
    return repeat(paramObservable, REDO_INFINITE, paramScheduler);
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, true, Schedulers.trampoline()));
  }
  
  public static <T> Observable<T> repeat(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, false, true, paramScheduler));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable)
  {
    return retry(paramObservable, REDO_INFINITE);
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, long paramLong)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("count >= 0 expected");
    }
    if (paramLong == 0L) {
      return paramObservable;
    }
    return retry(paramObservable, new OnSubscribeRedo.RedoFinite(paramLong));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, true, false, Schedulers.trampoline()));
  }
  
  public static <T> Observable<T> retry(Observable<T> paramObservable, Func1<? super Observable<? extends Notification<?>>, ? extends Observable<?>> paramFunc1, Scheduler paramScheduler)
  {
    return Observable.create(new OnSubscribeRedo(paramObservable, paramFunc1, true, false, paramScheduler));
  }
  
  public void call(Subscriber<? super T> paramSubscriber)
  {
    AtomicBoolean localAtomicBoolean = new AtomicBoolean(true);
    AtomicLong localAtomicLong = new AtomicLong();
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    paramSubscriber.add(localWorker);
    Object localObject = new SerialSubscription();
    paramSubscriber.add((Subscription)localObject);
    BehaviorSubject localBehaviorSubject = BehaviorSubject.create();
    localBehaviorSubject.subscribe(Subscribers.empty());
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    localObject = new OnSubscribeRedo.2(this, paramSubscriber, localBehaviorSubject, localProducerArbiter, localAtomicLong, (SerialSubscription)localObject);
    localWorker.schedule(new OnSubscribeRedo.4(this, (Observable)this.controlHandlerFunction.call(localBehaviorSubject.lift(new OnSubscribeRedo.3(this))), paramSubscriber, localAtomicLong, localWorker, (Action0)localObject, localAtomicBoolean));
    paramSubscriber.setProducer(new OnSubscribeRedo.5(this, localAtomicLong, localProducerArbiter, localAtomicBoolean, localWorker, (Action0)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo
 * JD-Core Version:    0.7.0.1
 */