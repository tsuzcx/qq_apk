package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.Subscription;
import rx.functions.Func0;
import rx.functions.Func2;

public final class OperatorScan<R, T>
  implements Observable.Operator<R, T>
{
  private static final Object NO_INITIAL_VALUE = new Object();
  final Func2<R, ? super T, R> accumulator;
  private final Func0<R> initialValueFactory;
  
  public OperatorScan(R paramR, Func2<R, ? super T, R> paramFunc2)
  {
    this(new OperatorScan.1(paramR), paramFunc2);
  }
  
  public OperatorScan(Func0<R> paramFunc0, Func2<R, ? super T, R> paramFunc2)
  {
    this.initialValueFactory = paramFunc0;
    this.accumulator = paramFunc2;
  }
  
  public OperatorScan(Func2<R, ? super T, R> paramFunc2)
  {
    this(NO_INITIAL_VALUE, paramFunc2);
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    Object localObject = this.initialValueFactory.call();
    if (localObject == NO_INITIAL_VALUE) {
      return new OperatorScan.2(this, paramSubscriber, paramSubscriber);
    }
    OperatorScan.InitialProducer localInitialProducer = new OperatorScan.InitialProducer(localObject, paramSubscriber);
    localObject = new OperatorScan.3(this, localObject, localInitialProducer);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer(localInitialProducer);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorScan
 * JD-Core Version:    0.7.0.1
 */