package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;

class OperatorTimeout$1
  implements OperatorTimeoutBase.FirstTimeoutStub<T>
{
  OperatorTimeout$1(long paramLong, TimeUnit paramTimeUnit) {}
  
  public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, Long paramLong, Scheduler.Worker paramWorker)
  {
    return paramWorker.schedule(new OperatorTimeout.1.1(this, paramTimeoutSubscriber, paramLong), this.val$timeout, this.val$timeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeout.1
 * JD-Core Version:    0.7.0.1
 */