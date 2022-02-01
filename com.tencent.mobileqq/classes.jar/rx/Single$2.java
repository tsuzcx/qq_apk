package rx;

import rx.exceptions.Exceptions;
import rx.plugins.RxJavaSingleExecutionHook;

class Single$2
  implements Observable.OnSubscribe<R>
{
  Single$2(Single paramSingle, Observable.Operator paramOperator) {}
  
  public void call(Subscriber<? super R> paramSubscriber)
  {
    try
    {
      Subscriber localSubscriber = (Subscriber)Single.hook.onLift(this.val$lift).call(paramSubscriber);
      try
      {
        localSubscriber.onStart();
        this.this$0.onSubscribe.call(localSubscriber);
        return;
      }
      catch (Throwable localThrowable2)
      {
        Exceptions.throwOrReport(localThrowable2, localSubscriber);
        return;
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      Exceptions.throwOrReport(localThrowable1, paramSubscriber);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.Single.2
 * JD-Core Version:    0.7.0.1
 */