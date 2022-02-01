package rx.internal.operators;

import rx.Observable.Operator;
import rx.Subscriber;

public final class OperatorOnBackpressureLatest<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorOnBackpressureLatest<T> instance()
  {
    return OperatorOnBackpressureLatest.Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    OperatorOnBackpressureLatest.LatestEmitter localLatestEmitter = new OperatorOnBackpressureLatest.LatestEmitter(paramSubscriber);
    OperatorOnBackpressureLatest.LatestSubscriber localLatestSubscriber = new OperatorOnBackpressureLatest.LatestSubscriber(localLatestEmitter);
    localLatestEmitter.parent = localLatestSubscriber;
    paramSubscriber.add(localLatestSubscriber);
    paramSubscriber.add(localLatestEmitter);
    paramSubscriber.setProducer(localLatestEmitter);
    return localLatestSubscriber;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureLatest
 * JD-Core Version:    0.7.0.1
 */