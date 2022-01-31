package rx.internal.operators;

import rx.Producer;
import rx.functions.Action1;

class OperatorDoOnRequest$1
  implements Producer
{
  OperatorDoOnRequest$1(OperatorDoOnRequest paramOperatorDoOnRequest, OperatorDoOnRequest.ParentSubscriber paramParentSubscriber) {}
  
  public void request(long paramLong)
  {
    this.this$0.request.call(Long.valueOf(paramLong));
    OperatorDoOnRequest.ParentSubscriber.access$000(this.val$parent, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     rx.internal.operators.OperatorDoOnRequest.1
 * JD-Core Version:    0.7.0.1
 */