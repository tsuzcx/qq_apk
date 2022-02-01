package rx.internal.operators;

import rx.functions.Action0;

class OperatorGroupBy$1
  implements Action0
{
  OperatorGroupBy$1(OperatorGroupBy paramOperatorGroupBy, OperatorGroupBy.GroupBySubscriber paramGroupBySubscriber) {}
  
  public void call()
  {
    this.val$parent.cancel();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.1
 * JD-Core Version:    0.7.0.1
 */