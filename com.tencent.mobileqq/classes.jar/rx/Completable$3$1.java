package rx;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.CompositeSubscription;

class Completable$3$1
  implements Completable.CompletableSubscriber
{
  Completable$3$1(Completable.3 param3, AtomicBoolean paramAtomicBoolean, CompositeSubscription paramCompositeSubscription, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    if (this.val$once.compareAndSet(false, true))
    {
      this.val$set.unsubscribe();
      this.val$s.onCompleted();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    if (this.val$once.compareAndSet(false, true))
    {
      this.val$set.unsubscribe();
      this.val$s.onError(paramThrowable);
      return;
    }
    Completable.ERROR_HANDLER.handleError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$set.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Completable.3.1
 * JD-Core Version:    0.7.0.1
 */