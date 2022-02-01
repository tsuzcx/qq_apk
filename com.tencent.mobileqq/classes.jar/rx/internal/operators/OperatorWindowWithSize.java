package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorWindowWithSize<T>
  implements Observable.Operator<Observable<T>, T>
{
  final int size;
  final int skip;
  
  public OperatorWindowWithSize(int paramInt1, int paramInt2)
  {
    this.size = paramInt1;
    this.skip = paramInt2;
  }
  
  public Subscriber<? super T> call(Subscriber<? super Observable<T>> paramSubscriber)
  {
    int i = this.skip;
    int j = this.size;
    if (i == j)
    {
      localObject = new OperatorWindowWithSize.WindowExact(paramSubscriber, j);
      paramSubscriber.add(((OperatorWindowWithSize.WindowExact)localObject).cancel);
      paramSubscriber.setProducer(((OperatorWindowWithSize.WindowExact)localObject).createProducer());
      return localObject;
    }
    if (i > j)
    {
      localObject = new OperatorWindowWithSize.WindowSkip(paramSubscriber, j, i);
      paramSubscriber.add(((OperatorWindowWithSize.WindowSkip)localObject).cancel);
      paramSubscriber.setProducer(((OperatorWindowWithSize.WindowSkip)localObject).createProducer());
      return localObject;
    }
    Object localObject = new OperatorWindowWithSize.WindowOverlap(paramSubscriber, j, i);
    paramSubscriber.add(((OperatorWindowWithSize.WindowOverlap)localObject).cancel);
    paramSubscriber.setProducer(((OperatorWindowWithSize.WindowOverlap)localObject).createProducer());
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorWindowWithSize
 * JD-Core Version:    0.7.0.1
 */