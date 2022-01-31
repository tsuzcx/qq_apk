package rx;

import rx.functions.Action0;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.MultipleAssignmentSubscription;

class Completable$26
  implements Completable.CompletableSubscriber
{
  Completable$26(Completable paramCompletable, Action0 paramAction0, MultipleAssignmentSubscription paramMultipleAssignmentSubscription) {}
  
  public void onCompleted()
  {
    try
    {
      this.val$onComplete.call();
      return;
    }
    catch (Throwable localThrowable)
    {
      Completable.ERROR_HANDLER.handleError(localThrowable);
      Completable.access$000(localThrowable);
      return;
    }
    finally
    {
      this.val$mad.unsubscribe();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    Completable.ERROR_HANDLER.handleError(paramThrowable);
    this.val$mad.unsubscribe();
    Completable.access$000(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$mad.set(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Completable.26
 * JD-Core Version:    0.7.0.1
 */