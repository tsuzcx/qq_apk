package rx.internal.operators;

import rx.Producer;

class OperatorTakeUntilPredicate$1
  implements Producer
{
  OperatorTakeUntilPredicate$1(OperatorTakeUntilPredicate paramOperatorTakeUntilPredicate, OperatorTakeUntilPredicate.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    this.val$parent.downstreamRequest(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeUntilPredicate.1
 * JD-Core Version:    0.7.0.1
 */