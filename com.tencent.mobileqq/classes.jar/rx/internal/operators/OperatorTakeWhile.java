package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorTakeWhile<T>
  implements Observable.Operator<T, T>
{
  final Func2<? super T, ? super Integer, Boolean> predicate;
  
  public OperatorTakeWhile(Func1<? super T, Boolean> paramFunc1)
  {
    this(new OperatorTakeWhile.1(paramFunc1));
  }
  
  public OperatorTakeWhile(Func2<? super T, ? super Integer, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorTakeWhile.2 local2 = new OperatorTakeWhile.2(this, paramSubscriber, false, paramSubscriber);
    paramSubscriber.add(local2);
    return local2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeWhile
 * JD-Core Version:    0.7.0.1
 */