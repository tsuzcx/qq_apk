package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R>
  implements Observable.OnSubscribe<R>
{
  final Observable<TLeft> left;
  final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
  final Func2<TLeft, TRight, R> resultSelector;
  final Observable<TRight> right;
  final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;
  
  public OnSubscribeJoin(Observable<TLeft> paramObservable, Observable<TRight> paramObservable1, Func1<TLeft, Observable<TLeftDuration>> paramFunc1, Func1<TRight, Observable<TRightDuration>> paramFunc11, Func2<TLeft, TRight, R> paramFunc2)
  {
    this.left = paramObservable;
    this.right = paramObservable1;
    this.leftDurationSelector = paramFunc1;
    this.rightDurationSelector = paramFunc11;
    this.resultSelector = paramFunc2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    new OnSubscribeJoin.ResultSink(this, new SerializedSubscriber(paramSubscriber)).run();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeJoin
 * JD-Core Version:    0.7.0.1
 */