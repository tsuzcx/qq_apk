package rx;

import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.MultipleAssignmentSubscription;

class Completable$25
  implements Completable.CompletableSubscriber
{
  Completable$25(Completable paramCompletable, MultipleAssignmentSubscription paramMultipleAssignmentSubscription) {}
  
  public void onCompleted()
  {
    this.val$mad.unsubscribe();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.25
 * JD-Core Version:    0.7.0.1
 */