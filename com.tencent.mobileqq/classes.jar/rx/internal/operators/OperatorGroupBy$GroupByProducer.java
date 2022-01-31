package rx.internal.operators;

import rx.Producer;

public final class OperatorGroupBy$GroupByProducer
  implements Producer
{
  final OperatorGroupBy.GroupBySubscriber<?, ?, ?> parent;
  
  public OperatorGroupBy$GroupByProducer(OperatorGroupBy.GroupBySubscriber<?, ?, ?> paramGroupBySubscriber)
  {
    this.parent = paramGroupBySubscriber;
  }
  
  public void request(long paramLong)
  {
    this.parent.requestMore(paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OperatorGroupBy.GroupByProducer
 * JD-Core Version:    0.7.0.1
 */