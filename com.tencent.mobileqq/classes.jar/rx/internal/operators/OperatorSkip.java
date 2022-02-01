package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorSkip<T>
  implements Observable.Operator<T, T>
{
  final int toSkip;
  
  public OperatorSkip(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.toSkip = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("n >= 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorSkip.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSkip
 * JD-Core Version:    0.7.0.1
 */