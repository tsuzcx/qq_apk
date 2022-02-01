package rx.internal.operators;

import rx.Producer;

class OperatorTakeLastOne$1
  implements Producer
{
  OperatorTakeLastOne$1(OperatorTakeLastOne paramOperatorTakeLastOne, OperatorTakeLastOne.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    this.val$parent.requestMore(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTakeLastOne.1
 * JD-Core Version:    0.7.0.1
 */