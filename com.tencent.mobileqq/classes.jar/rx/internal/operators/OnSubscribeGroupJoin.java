package rx.internal.operators;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Subscriber;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R>
  implements Observable.OnSubscribe<R>
{
  protected final Observable<T1> left;
  protected final Func1<? super T1, ? extends Observable<D1>> leftDuration;
  protected final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
  protected final Observable<T2> right;
  protected final Func1<? super T2, ? extends Observable<D2>> rightDuration;
  
  public OnSubscribeGroupJoin(Observable<T1> paramObservable, Observable<T2> paramObservable1, Func1<? super T1, ? extends Observable<D1>> paramFunc1, Func1<? super T2, ? extends Observable<D2>> paramFunc11, Func2<? super T1, ? super Observable<T2>, ? extends R> paramFunc2)
  {
    this.left = paramObservable;
    this.right = paramObservable1;
    this.leftDuration = paramFunc1;
    this.rightDuration = paramFunc11;
    this.resultSelector = paramFunc2;
  }
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    OnSubscribeGroupJoin.ResultManager localResultManager = new OnSubscribeGroupJoin.ResultManager(this, new SerializedSubscriber(paramSubscriber));
    paramSubscriber.add(localResultManager);
    localResultManager.init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeGroupJoin
 * JD-Core Version:    0.7.0.1
 */