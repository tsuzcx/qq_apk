package rx.internal.operators;

import rx.Subscriber;

final class OperatorOnBackpressureLatest$LatestSubscriber<T>
  extends Subscriber<T>
{
  private final OperatorOnBackpressureLatest.LatestEmitter<T> producer;
  
  OperatorOnBackpressureLatest$LatestSubscriber(OperatorOnBackpressureLatest.LatestEmitter<T> paramLatestEmitter)
  {
    this.producer = paramLatestEmitter;
  }
  
  public void onCompleted()
  {
    this.producer.onCompleted();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.producer.onError(paramThrowable);
  }
  
  public void onNext(T paramT)
  {
    this.producer.onNext(paramT);
  }
  
  public void onStart()
  {
    request(0L);
  }
  
  void requestMore(long paramLong)
  {
    request(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorOnBackpressureLatest.LatestSubscriber
 * JD-Core Version:    0.7.0.1
 */