package rx.internal.operators;

import rx.Observable;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.subscriptions.Subscriptions;

class OperatorTimeoutWithSelector$2
  implements OperatorTimeoutBase.TimeoutStub<T>
{
  OperatorTimeoutWithSelector$2(Func1 paramFunc1) {}
  
  public Subscription call(OperatorTimeoutBase.TimeoutSubscriber<T> paramTimeoutSubscriber, Long paramLong, T paramT, Scheduler.Worker paramWorker)
  {
    try
    {
      paramT = (Observable)this.val$timeoutSelector.call(paramT);
      return paramT.unsafeSubscribe(new OperatorTimeoutWithSelector.2.1(this, paramTimeoutSubscriber, paramLong));
    }
    catch (Throwable paramLong)
    {
      Exceptions.throwOrReport(paramLong, paramTimeoutSubscriber);
    }
    return Subscriptions.unsubscribed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OperatorTimeoutWithSelector.2
 * JD-Core Version:    0.7.0.1
 */