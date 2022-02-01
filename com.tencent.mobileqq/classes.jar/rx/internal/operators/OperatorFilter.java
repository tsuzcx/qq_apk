package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorFilter<T>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, Boolean> predicate;
  
  public OperatorFilter(Func1<? super T, Boolean> paramFunc1)
  {
    this.predicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorFilter.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorFilter
 * JD-Core Version:    0.7.0.1
 */