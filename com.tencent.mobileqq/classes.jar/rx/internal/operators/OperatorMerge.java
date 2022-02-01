package rx.internal.operators;

import rx.Observable;
import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorMerge<T>
  implements Observable.Operator<T, Observable<? extends T>>
{
  final boolean delayErrors;
  final int maxConcurrent;
  
  OperatorMerge(boolean paramBoolean, int paramInt)
  {
    this.delayErrors = paramBoolean;
    this.maxConcurrent = paramInt;
  }
  
  public static <T> OperatorMerge<T> instance(boolean paramBoolean)
  {
    if (paramBoolean) {
      return OperatorMerge.HolderDelayErrors.INSTANCE;
    }
    return OperatorMerge.HolderNoDelay.INSTANCE;
  }
  
  public static <T> OperatorMerge<T> instance(boolean paramBoolean, int paramInt)
  {
    if (paramInt > 0)
    {
      if (paramInt == 2147483647) {
        return instance(paramBoolean);
      }
      return new OperatorMerge(paramBoolean, paramInt);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("maxConcurrent > 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Subscriber<Observable<? extends T>> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorMerge.MergeSubscriber localMergeSubscriber = new OperatorMerge.MergeSubscriber(paramSubscriber, this.delayErrors, this.maxConcurrent);
    OperatorMerge.MergeProducer localMergeProducer = new OperatorMerge.MergeProducer(localMergeSubscriber);
    localMergeSubscriber.producer = localMergeProducer;
    paramSubscriber.add(localMergeSubscriber);
    paramSubscriber.setProducer(localMergeProducer);
    return localMergeSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorMerge
 * JD-Core Version:    0.7.0.1
 */