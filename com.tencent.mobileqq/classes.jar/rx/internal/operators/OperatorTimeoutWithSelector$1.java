package rx.internal.operators;

import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func0;
import rx.subscriptions.Subscriptions;

class OperatorTimeoutWithSelector$1
  implements OperatorTimeoutBase.FirstTimeoutStub<T>
{
  OperatorTimeoutWithSelector$1(Func0 paramFunc0) {}
  
  public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, Long paramLong, Scheduler.Worker paramWorker)
  {
    paramWorker = this.val$firstTimeoutSelector;
    if (paramWorker != null) {
      try
      {
        paramWorker = (Observable)paramWorker.call();
        return paramWorker.unsafeSubscribe(new OperatorTimeoutWithSelector.1.1(this, paramTimeoutSubscriber, paramLong));
      }
      catch (Throwable paramLong)
      {
        Exceptions.throwOrReport(paramLong, paramTimeoutSubscriber);
        return Subscriptions.unsubscribed();
      }
    }
    return Subscriptions.unsubscribed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.1
 * JD-Core Version:    0.7.0.1
 */