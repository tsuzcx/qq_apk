package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.Subscribers;

public class OperatorDoOnSubscribe<T>
  implements Observable.Operator<T, T>
{
  private final Action0 subscribe;
  
  public OperatorDoOnSubscribe(Action0 paramAction0)
  {
    this.subscribe = paramAction0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    this.subscribe.call();
    return Subscribers.wrap(paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorDoOnSubscribe
 * JD-Core Version:    0.7.0.1
 */