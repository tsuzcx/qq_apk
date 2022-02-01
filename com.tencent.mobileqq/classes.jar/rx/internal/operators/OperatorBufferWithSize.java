package rx.internal.operators;

import java.util.List;
import rx.Observable.Operator;
import rx.Subscriber;
import rx.Subscription;

public final class OperatorBufferWithSize<T>
  implements Observable.Operator<List<T>, T>
{
  final int count;
  final int skip;
  
  public OperatorBufferWithSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 > 0)
      {
        this.count = paramInt1;
        this.skip = paramInt2;
        return;
      }
      throw new IllegalArgumentException("skip must be greater than 0");
    }
    throw new IllegalArgumentException("count must be greater than 0");
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    int i = this.skip;
    int j = this.count;
    if (i == j)
    {
      localObject = new OperatorBufferWithSize.BufferExact(paramSubscriber, j);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer(((OperatorBufferWithSize.BufferExact)localObject).createProducer());
      return localObject;
    }
    if (i > j)
    {
      localObject = new OperatorBufferWithSize.BufferSkip(paramSubscriber, j, i);
      paramSubscriber.add((Subscription)localObject);
      paramSubscriber.setProducer(((OperatorBufferWithSize.BufferSkip)localObject).createProducer());
      return localObject;
    }
    Object localObject = new OperatorBufferWithSize.BufferOverlap(paramSubscriber, j, i);
    paramSubscriber.add((Subscription)localObject);
    paramSubscriber.setProducer(((OperatorBufferWithSize.BufferOverlap)localObject).createProducer());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorBufferWithSize
 * JD-Core Version:    0.7.0.1
 */