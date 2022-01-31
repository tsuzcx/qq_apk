package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;
import rx.observers.SerializedSubscriber;

public final class OperatorSerialize<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorSerialize<T> instance()
  {
    return OperatorSerialize.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new SerializedSubscriber(new OperatorSerialize.1(this, paramSubscriber, paramSubscriber));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorSerialize
 * JD-Core Version:    0.7.0.1
 */