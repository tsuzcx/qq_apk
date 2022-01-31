package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.functions.Func2;
import rx.internal.producers.ProducerArbiter;
import rx.schedulers.Schedulers;
import rx.subscriptions.SerialSubscription;

public final class OperatorRetryWithPredicate<T>
  implements Observable.Operator<T, Observable<T>>
{
  final Func2<Integer, Throwable, Boolean> predicate;
  
  public OperatorRetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public Subscriber<? super Observable<T>> call(Subscriber<? super T> paramSubscriber)
  {
    Scheduler.Worker localWorker = Schedulers.trampoline().createWorker();
    paramSubscriber.add(localWorker);
    SerialSubscription localSerialSubscription = new SerialSubscription();
    paramSubscriber.add(localSerialSubscription);
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    paramSubscriber.setProducer(localProducerArbiter);
    return new OperatorRetryWithPredicate.SourceSubscriber(paramSubscriber, this.predicate, localWorker, localSerialSubscription, localProducerArbiter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorRetryWithPredicate
 * JD-Core Version:    0.7.0.1
 */