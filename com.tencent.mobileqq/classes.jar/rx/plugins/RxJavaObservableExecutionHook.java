package rx.plugins;

import rx.Observable;
import rx.Observable.OnSubscribe;
import rx.Observable.Operator;
import rx.Subscription;

public abstract class RxJavaObservableExecutionHook
{
  public <T> Observable.OnSubscribe<T> onCreate(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    return paramOnSubscribe;
  }
  
  public <T, R> Observable.Operator<? extends R, ? super T> onLift(Observable.Operator<? extends R, ? super T> paramOperator)
  {
    return paramOperator;
  }
  
  public <T> Throwable onSubscribeError(Throwable paramThrowable)
  {
    return paramThrowable;
  }
  
  public <T> Subscription onSubscribeReturn(Subscription paramSubscription)
  {
    return paramSubscription;
  }
  
  public <T> Observable.OnSubscribe<T> onSubscribeStart(Observable<? extends T> paramObservable, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    return paramOnSubscribe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.plugins.RxJavaObservableExecutionHook
 * JD-Core Version:    0.7.0.1
 */