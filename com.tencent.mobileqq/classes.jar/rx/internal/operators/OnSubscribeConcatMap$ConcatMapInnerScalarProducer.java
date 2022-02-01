package rx.internal.operators;

import rx.Producer;

final class OnSubscribeConcatMap$ConcatMapInnerScalarProducer<T, R>
  implements Producer
{
  boolean once;
  final OnSubscribeConcatMap.ConcatMapSubscriber<T, R> parent;
  final R value;
  
  public OnSubscribeConcatMap$ConcatMapInnerScalarProducer(R paramR, OnSubscribeConcatMap.ConcatMapSubscriber<T, R> paramConcatMapSubscriber)
  {
    this.value = paramR;
    this.parent = paramConcatMapSubscriber;
  }
  
  public void request(long paramLong)
  {
    if (!this.once)
    {
      this.once = true;
      OnSubscribeConcatMap.ConcatMapSubscriber localConcatMapSubscriber = this.parent;
      localConcatMapSubscriber.innerNext(this.value);
      localConcatMapSubscriber.innerCompleted(1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeConcatMap.ConcatMapInnerScalarProducer
 * JD-Core Version:    0.7.0.1
 */