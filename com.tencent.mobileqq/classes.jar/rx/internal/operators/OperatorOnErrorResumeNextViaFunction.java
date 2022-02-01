package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.internal.producers.ProducerArbiter;
import rx.subscriptions.SerialSubscription;

public final class OperatorOnErrorResumeNextViaFunction<T>
  implements Observable.Operator<T, T>
{
  final Func1<Throwable, ? extends Observable<? extends T>> resumeFunction;
  
  public OperatorOnErrorResumeNextViaFunction(Func1<Throwable, ? extends Observable<? extends T>> paramFunc1)
  {
    this.resumeFunction = paramFunc1;
  }
  
  public static <T> OperatorOnErrorResumeNextViaFunction<T> withException(Observable<? extends T> paramObservable)
  {
    return new OperatorOnErrorResumeNextViaFunction(new OperatorOnErrorResumeNextViaFunction.3(paramObservable));
  }
  
  public static <T> OperatorOnErrorResumeNextViaFunction<T> withOther(Observable<? extends T> paramObservable)
  {
    return new OperatorOnErrorResumeNextViaFunction(new OperatorOnErrorResumeNextViaFunction.2(paramObservable));
  }
  
  public static <T> OperatorOnErrorResumeNextViaFunction<T> withSingle(Func1<Throwable, ? extends T> paramFunc1)
  {
    return new OperatorOnErrorResumeNextViaFunction(new OperatorOnErrorResumeNextViaFunction.1(paramFunc1));
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    ProducerArbiter localProducerArbiter = new ProducerArbiter();
    SerialSubscription localSerialSubscription = new SerialSubscription();
    OperatorOnErrorResumeNextViaFunction.4 local4 = new OperatorOnErrorResumeNextViaFunction.4(this, paramSubscriber, localProducerArbiter, localSerialSubscription);
    localSerialSubscription.set(local4);
    paramSubscriber.add(localSerialSubscription);
    paramSubscriber.setProducer(localProducerArbiter);
    return local4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorOnErrorResumeNextViaFunction
 * JD-Core Version:    0.7.0.1
 */