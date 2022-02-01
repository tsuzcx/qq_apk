package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V>
  implements Observable.Operator<Observable<T>, T>
{
  final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
  final Observable<? extends U> windowOpenings;
  
  public OperatorWindowWithStartEndObservable(Observable<? extends U> paramObservable, Func1<? super U, ? extends Observable<? extends V>> paramFunc1)
  {
    this.windowOpenings = paramObservable;
    this.windowClosingSelector = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    paramSubscriber.add(localCompositeSubscription);
    paramSubscriber = new OperatorWindowWithStartEndObservable.SourceSubscriber(this, paramSubscriber, localCompositeSubscription);
    OperatorWindowWithStartEndObservable.1 local1 = new OperatorWindowWithStartEndObservable.1(this, paramSubscriber);
    localCompositeSubscription.add(paramSubscriber);
    localCompositeSubscription.add(local1);
    this.windowOpenings.unsafeSubscribe(local1);
    return paramSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithStartEndObservable
 * JD-Core Version:    0.7.0.1
 */