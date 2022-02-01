package rx.internal.operators;

import rx.Observable.Operator;
import rx.Scheduler;
import rx.Subscriber;
import rx.subscriptions.Subscriptions;

public class OperatorUnsubscribeOn<T>
  implements Observable.Operator<T, T>
{
  final Scheduler scheduler;
  
  public OperatorUnsubscribeOn(Scheduler paramScheduler)
  {
    this.scheduler = paramScheduler;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorUnsubscribeOn.1 local1 = new OperatorUnsubscribeOn.1(this, paramSubscriber);
    paramSubscriber.add(Subscriptions.create(new OperatorUnsubscribeOn.2(this, local1)));
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorUnsubscribeOn
 * JD-Core Version:    0.7.0.1
 */