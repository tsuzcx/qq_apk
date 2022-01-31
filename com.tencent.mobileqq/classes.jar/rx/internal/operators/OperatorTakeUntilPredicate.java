package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Func1;

public final class OperatorTakeUntilPredicate<T>
  implements Observable.Operator<T, T>
{
  final Func1<? super T, Boolean> stopPredicate;
  
  public OperatorTakeUntilPredicate(Func1<? super T, Boolean> paramFunc1)
  {
    this.stopPredicate = paramFunc1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorTakeUntilPredicate.ParentSubscriber localParentSubscriber = new OperatorTakeUntilPredicate.ParentSubscriber(this, paramSubscriber);
    paramSubscriber.add(localParentSubscriber);
    paramSubscriber.setProducer(new OperatorTakeUntilPredicate.1(this, localParentSubscriber));
    return localParentSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate
 * JD-Core Version:    0.7.0.1
 */