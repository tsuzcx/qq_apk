package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.functions.Action1;

public class OperatorOnBackpressureDrop<T>
  implements Observable.Operator<T, T>
{
  final Action1<? super T> onDrop;
  
  OperatorOnBackpressureDrop()
  {
    this(null);
  }
  
  public OperatorOnBackpressureDrop(Action1<? super T> paramAction1)
  {
    this.onDrop = paramAction1;
  }
  
  public static <T> OperatorOnBackpressureDrop<T> instance()
  {
    return OperatorOnBackpressureDrop.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    AtomicLong localAtomicLong = new AtomicLong();
    paramSubscriber.setProducer(new OperatorOnBackpressureDrop.1(this, localAtomicLong));
    return new OperatorOnBackpressureDrop.2(this, paramSubscriber, paramSubscriber, localAtomicLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureDrop
 * JD-Core Version:    0.7.0.1
 */