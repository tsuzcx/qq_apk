package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

final class OperatorRetryWithPredicate$SourceSubscriber<T>
  extends Subscriber<Observable<T>>
{
  final AtomicInteger attempts = new AtomicInteger();
  final Subscriber<? super T> child;
  final Scheduler.Worker inner;
  final ProducerArbiter pa;
  final Func2<Integer, Throwable, Boolean> predicate;
  final SerialSubscription serialSubscription;
  
  public OperatorRetryWithPredicate$SourceSubscriber(Subscriber<? super T> paramSubscriber, Func2<Integer, Throwable, Boolean> paramFunc2, Scheduler.Worker paramWorker, SerialSubscription paramSerialSubscription, ProducerArbiter paramProducerArbiter)
  {
    this.child = paramSubscriber;
    this.predicate = paramFunc2;
    this.inner = paramWorker;
    this.serialSubscription = paramSerialSubscription;
    this.pa = paramProducerArbiter;
  }
  
  public void onCompleted() {}
  
  public void onError(Throwable paramThrowable)
  {
    this.child.onError(paramThrowable);
  }
  
  public void onNext(Observable<T> paramObservable)
  {
    this.inner.schedule(new OperatorRetryWithPredicate.SourceSubscriber.1(this, paramObservable));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate.SourceSubscriber
 * JD-Core Version:    0.7.0.1
 */