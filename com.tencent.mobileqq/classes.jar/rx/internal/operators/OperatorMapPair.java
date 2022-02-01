package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OperatorMapPair<T, U, R>
  implements Observable.Operator<Observable<? extends R>, T>
{
  final Func1<? super T, ? extends Observable<? extends U>> collectionSelector;
  final Func2<? super T, ? super U, ? extends R> resultSelector;
  
  public OperatorMapPair(Func1<? super T, ? extends Observable<? extends U>> paramFunc1, Func2<? super T, ? super U, ? extends R> paramFunc2)
  {
    this.collectionSelector = paramFunc1;
    this.resultSelector = paramFunc2;
  }
  
  public static <T, U> Func1<T, Observable<U>> convertSelector(Func1<? super T, ? extends Iterable<? extends U>> paramFunc1)
  {
    return new OperatorMapPair.1(paramFunc1);
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<? extends R>> paramSubscriber)
  {
    return new OperatorMapPair.2(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorMapPair
 * JD-Core Version:    0.7.0.1
 */