package rx.internal.operators;

import rx.Notification;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorDematerialize<T>
  implements Observable.Operator<T, Notification<T>>
{
  public static OperatorDematerialize instance()
  {
    return OperatorDematerialize.Holder.INSTANCE;
  }
  
  public Subscriber<? super Notification<T>> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorDematerialize.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorDematerialize
 * JD-Core Version:    0.7.0.1
 */