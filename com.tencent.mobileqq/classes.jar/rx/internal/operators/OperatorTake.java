package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorTake<T>
  implements Observable.Operator<T, T>
{
  final int limit;
  
  public OperatorTake(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("limit >= 0 required but it was " + paramInt);
    }
    this.limit = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorTake.1 local1 = new OperatorTake.1(this, paramSubscriber);
    if (this.limit == 0)
    {
      paramSubscriber.onCompleted();
      local1.unsubscribe();
    }
    paramSubscriber.add(local1);
    return local1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorTake
 * JD-Core Version:    0.7.0.1
 */