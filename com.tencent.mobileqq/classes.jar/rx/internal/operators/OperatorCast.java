package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorCast<T, R>
  implements Observable.Operator<R, T>
{
  final Class<R> castClass;
  
  public OperatorCast(Class<R> paramClass)
  {
    this.castClass = paramClass;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    return new OperatorCast.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorCast
 * JD-Core Version:    0.7.0.1
 */