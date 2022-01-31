package rx.internal.operators;

import rx.Producer;

class OnSubscribeConcatMap$1
  implements Producer
{
  OnSubscribeConcatMap$1(OnSubscribeConcatMap paramOnSubscribeConcatMap, OnSubscribeConcatMap.ConcatMapSubscriber paramConcatMapSubscriber) {}
  
  public void request(long paramLong)
  {
    this.val$parent.requestMore(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeConcatMap.1
 * JD-Core Version:    0.7.0.1
 */