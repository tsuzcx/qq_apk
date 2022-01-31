package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorMap<T, R>
  implements Observable.Operator<R, T>
{
  final Func1<? super T, ? extends R> transformer;
  
  public OperatorMap(Func1<? super T, ? extends R> paramFunc1)
  {
    this.transformer = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return new OperatorMap.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorMap
 * JD-Core Version:    0.7.0.1
 */