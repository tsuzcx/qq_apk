package rx.internal.operators;

import rx.Producer;
import rx.Subscriber;
import rx.internal.producers.ProducerArbiter;

final class OnSubscribeConcatMap$ConcatMapInnerSubscriber<T, R>
  extends Subscriber<R>
{
  final OnSubscribeConcatMap.ConcatMapSubscriber<T, R> parent;
  long produced;
  
  public OnSubscribeConcatMap$ConcatMapInnerSubscriber(OnSubscribeConcatMap.ConcatMapSubscriber<T, R> paramConcatMapSubscriber)
  {
    this.parent = paramConcatMapSubscriber;
  }
  
  public void onCompleted()
  {
    this.parent.innerCompleted(this.produced);
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.parent.innerError(paramThrowable, this.produced);
  }
  
  public void onNext(R paramR)
  {
    this.produced += 1L;
    this.parent.innerNext(paramR);
  }
  
  public void setProducer(Producer paramProducer)
  {
    this.parent.arbiter.setProducer(paramProducer);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeConcatMap.ConcatMapInnerSubscriber
 * JD-Core Version:    0.7.0.1
 */