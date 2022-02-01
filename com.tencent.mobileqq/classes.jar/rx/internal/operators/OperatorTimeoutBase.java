package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.Subscription;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.SerialSubscription;

class OperatorTimeoutBase<T>
  implements Observable.Operator<T, T>
{
  final OperatorTimeoutBase.FirstTimeoutStub<T> firstTimeoutStub;
  final Observable<? extends T> other;
  final Scheduler scheduler;
  final OperatorTimeoutBase.TimeoutStub<T> timeoutStub;
  
  OperatorTimeoutBase(OperatorTimeoutBase.FirstTimeoutStub<T> paramFirstTimeoutStub, OperatorTimeoutBase.TimeoutStub<T> paramTimeoutStub, Observable<? extends T> paramObservable, Scheduler paramScheduler)
  {
    this.firstTimeoutStub = paramFirstTimeoutStub;
    this.timeoutStub = paramTimeoutStub;
    this.other = paramObservable;
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = this.scheduler.createWorker();
    paramSubscriber.add(localWorker);
    paramSubscriber = new SerializedSubscriber(paramSubscriber);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    OperatorTimeoutBase.TimeoutSubscriber localTimeoutSubscriber = new OperatorTimeoutBase.TimeoutSubscriber(paramSubscriber, this.timeoutStub, localSerialSubscription, this.other, localWorker);
    paramSubscriber.add(localTimeoutSubscriber);
    paramSubscriber.setProducer(localTimeoutSubscriber.arbiter);
    localSerialSubscription.set((Subscription)this.firstTimeoutStub.call(localTimeoutSubscriber, Long.valueOf(0L), localWorker));
    return localTimeoutSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutBase
 * JD-Core Version:    0.7.0.1
 */