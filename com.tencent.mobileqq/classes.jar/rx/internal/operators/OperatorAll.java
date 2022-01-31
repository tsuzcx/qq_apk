package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.producers.SingleDelayedProducer;

public final class OperatorAll<T>
  implements Observable.Operator<Boolean, T>
{
  final Func1<? super T, Boolean> predicate;
  
  public OperatorAll(Func1<? super T, Boolean> paramFunc1)
  {
    this.predicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Boolean> paramSubscriber)
  {
    SingleDelayedProducer localSingleDelayedProducer = new SingleDelayedProducer(paramSubscriber);
    OperatorAll.1 local1 = new OperatorAll.1(this, localSingleDelayedProducer, paramSubscriber);
    paramSubscriber.add(local1);
    paramSubscriber.setProducer(localSingleDelayedProducer);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorAll
 * JD-Core Version:    0.7.0.1
 */