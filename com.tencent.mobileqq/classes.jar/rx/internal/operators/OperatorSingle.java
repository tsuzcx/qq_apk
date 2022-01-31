package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSingle<T>
  implements Observable.Operator<T, T>
{
  private final T defaultValue;
  private final boolean hasDefaultValue;
  
  OperatorSingle()
  {
    this(false, null);
  }
  
  public OperatorSingle(T paramT)
  {
    this(true, paramT);
  }
  
  private OperatorSingle(boolean paramBoolean, T paramT)
  {
    this.hasDefaultValue = paramBoolean;
    this.defaultValue = paramT;
  }
  
  public static <T> OperatorSingle<T> instance()
  {
    return OperatorSingle.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorSingle.ParentSubscriber localParentSubscriber = new OperatorSingle.ParentSubscriber(paramSubscriber, this.hasDefaultValue, this.defaultValue);
    paramSubscriber.setProducer(new OperatorSingle.1(this, localParentSubscriber));
    paramSubscriber.add(localParentSubscriber);
    return localParentSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OperatorSingle
 * JD-Core Version:    0.7.0.1
 */