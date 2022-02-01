package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorDistinctUntilChanged<T, U>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, ? extends U> keySelector;
  
  public OperatorDistinctUntilChanged(Func1<? super T, ? extends U> paramFunc1)
  {
    this.keySelector = paramFunc1;
  }
  
  public static <T> OperatorDistinctUntilChanged<T, T> instance()
  {
    return OperatorDistinctUntilChanged.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorDistinctUntilChanged.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorDistinctUntilChanged
 * JD-Core Version:    0.7.0.1
 */