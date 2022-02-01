package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorTakeLastOne<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorTakeLastOne<T> instance()
  {
    return OperatorTakeLastOne.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorTakeLastOne.ParentSubscriber localParentSubscriber = new OperatorTakeLastOne.ParentSubscriber(paramSubscriber);
    paramSubscriber.setProducer(new OperatorTakeLastOne.1(this, localParentSubscriber));
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLastOne
 * JD-Core Version:    0.7.0.1
 */