package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorDoOnRequest<T>
  implements Observable.Operator<T, T>
{
  final Action1<Long> request;
  
  public OperatorDoOnRequest(Action1<Long> paramAction1)
  {
    this.request = paramAction1;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorDoOnRequest.ParentSubscriber localParentSubscriber = new OperatorDoOnRequest.ParentSubscriber(paramSubscriber);
    paramSubscriber.setProducer(new OperatorDoOnRequest.1(this, localParentSubscriber));
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorDoOnRequest
 * JD-Core Version:    0.7.0.1
 */