package rx;

import rx.functions.Action0;
import rx.plugins.RxJavaErrorHandler;

class Completable$17$1$1
  implements Action0
{
  Completable$17$1$1(Completable.17.1 param1, Subscription paramSubscription) {}
  
  public void call()
  {
    try
    {
      this.this$2.this$1.val$onUnsubscribe.call();
    }
    catch (Throwable localThrowable)
    {
      Completable.ERROR_HANDLER.handleError(localThrowable);
    }
    this.val$d.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.17.1.1
 * JD-Core Version:    0.7.0.1
 */