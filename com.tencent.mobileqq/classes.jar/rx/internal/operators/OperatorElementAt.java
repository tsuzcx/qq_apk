package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorElementAt<T>
  implements Observable.Operator<T, T>
{
  final T defaultValue;
  final boolean hasDefault;
  final int index;
  
  public OperatorElementAt(int paramInt)
  {
    this(paramInt, null, false);
  }
  
  public OperatorElementAt(int paramInt, T paramT)
  {
    this(paramInt, paramT, true);
  }
  
  private OperatorElementAt(int paramInt, T paramT, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      this.index = paramInt;
      this.defaultValue = paramT;
      this.hasDefault = paramBoolean;
      return;
    }
    paramT = new StringBuilder();
    paramT.append(paramInt);
    paramT.append(" is out of bounds");
    throw new IndexOutOfBoundsException(paramT.toString());
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorElementAt.1 local1 = new OperatorElementAt.1(this, paramSubscriber);
    paramSubscriber.add(local1);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorElementAt
 * JD-Core Version:    0.7.0.1
 */