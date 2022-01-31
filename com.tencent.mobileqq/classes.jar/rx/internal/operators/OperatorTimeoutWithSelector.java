package rx.internal.operators;

import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

public class OperatorTimeoutWithSelector<T, U, V>
  extends OperatorTimeoutBase<T>
{
  public OperatorTimeoutWithSelector(Func0<? extends Observable<U>> paramFunc0, Func1<? super T, ? extends Observable<V>> paramFunc1, Observable<? extends T> paramObservable)
  {
    super(new OperatorTimeoutWithSelector.1(paramFunc0), new OperatorTimeoutWithSelector.2(paramFunc1), paramObservable, Schedulers.immediate());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector
 * JD-Core Version:    0.7.0.1
 */