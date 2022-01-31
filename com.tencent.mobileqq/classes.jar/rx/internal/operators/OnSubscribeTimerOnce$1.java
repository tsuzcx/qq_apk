package rx.internal.operators;

import rx.Subscriber;
import rx.exceptions.Exceptions;
import rx.functions.Action0;

class OnSubscribeTimerOnce$1
  implements Action0
{
  OnSubscribeTimerOnce$1(OnSubscribeTimerOnce paramOnSubscribeTimerOnce, Subscriber paramSubscriber) {}
  
  public void call()
  {
    try
    {
      this.val$child.onNext(Long.valueOf(0L));
      this.val$child.onCompleted();
      return;
    }
    catch (Throwable localThrowable)
    {
      Exceptions.throwOrReport(localThrowable, this.val$child);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.OnSubscribeTimerOnce.1
 * JD-Core Version:    0.7.0.1
 */