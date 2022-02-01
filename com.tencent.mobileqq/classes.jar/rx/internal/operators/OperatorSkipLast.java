package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public class OperatorSkipLast<T>
  implements Observable.Operator<T, T>
{
  final int count;
  
  public OperatorSkipLast(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.count = paramInt;
      return;
    }
    throw new IndexOutOfBoundsException("count could not be negative");
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return new OperatorSkipLast.1(this, paramSubscriber, paramSubscriber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorSkipLast
 * JD-Core Version:    0.7.0.1
 */