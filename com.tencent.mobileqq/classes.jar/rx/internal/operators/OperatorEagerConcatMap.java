package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorEagerConcatMap<T, R>
  implements Observable.Operator<R, T>
{
  final int bufferSize;
  final Func1<? super T, ? extends Observable<? extends R>> mapper;
  
  public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> paramFunc1, int paramInt)
  {
    this.mapper = paramFunc1;
    this.bufferSize = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super R> paramSubscriber)
  {
    paramSubscriber = new OperatorEagerConcatMap.EagerOuterSubscriber(this.mapper, this.bufferSize, paramSubscriber);
    paramSubscriber.init();
    return paramSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorEagerConcatMap
 * JD-Core Version:    0.7.0.1
 */