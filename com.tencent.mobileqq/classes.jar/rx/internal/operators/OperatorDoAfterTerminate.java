package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action0;

public final class OperatorDoAfterTerminate<T>
  implements Observable.Operator<T, T>
{
  final Action0 action;
  
  public OperatorDoAfterTerminate(Action0 paramAction0)
  {
    if (paramAction0 == null) {
      throw new NullPointerException("Action can not be null");
    }
    this.action = paramAction0;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorDoAfterTerminate.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorDoAfterTerminate
 * JD-Core Version:    0.7.0.1
 */