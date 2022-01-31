package rx.internal.operators;

import rx.Notification;
import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public final class OnSubscribeRedo$RetryWithPredicate
  implements Func1<Observable<? extends Notification<?>>, Observable<? extends Notification<?>>>
{
  final Func2<Integer, Throwable, Boolean> predicate;
  
  public OnSubscribeRedo$RetryWithPredicate(Func2<Integer, Throwable, Boolean> paramFunc2)
  {
    this.predicate = paramFunc2;
  }
  
  public Observable<? extends Notification<?>> call(Observable<? extends Notification<?>> paramObservable)
  {
    return paramObservable.scan(Notification.createOnNext(Integer.valueOf(0)), new OnSubscribeRedo.RetryWithPredicate.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeRedo.RetryWithPredicate
 * JD-Core Version:    0.7.0.1
 */