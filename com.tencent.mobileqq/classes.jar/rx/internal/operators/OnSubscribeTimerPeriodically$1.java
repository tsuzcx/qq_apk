package rx.internal.operators;

import rx.Scheduler.Worker;
import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

class OnSubscribeTimerPeriodically$1
  implements Action0
{
  long counter;
  
  OnSubscribeTimerPeriodically$1(OnSubscribeTimerPeriodically paramOnSubscribeTimerPeriodically, Subscriber paramSubscriber, Scheduler.Worker paramWorker) {}
  
  public void call()
  {
    try
    {
      Subscriber localSubscriber = this.val$child;
      long l = this.counter;
      this.counter = (1L + l);
      localSubscriber.onNext(Long.valueOf(l));
      return;
    }
    catch (Throwable localThrowable)
    {
      try
      {
        this.val$worker.unsubscribe();
        return;
      }
      finally
      {
        Exceptions.throwOrReport(localThrowable, this.val$child);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeTimerPeriodically.1
 * JD-Core Version:    0.7.0.1
 */