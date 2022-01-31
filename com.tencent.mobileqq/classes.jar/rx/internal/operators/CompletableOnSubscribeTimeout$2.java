package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

class CompletableOnSubscribeTimeout$2
  implements Completable.CompletableSubscriber
{
  CompletableOnSubscribeTimeout$2(CompletableOnSubscribeTimeout paramCompletableOnSubscribeTimeout, CompositeSubscription paramCompositeSubscription, AtomicBoolean paramAtomicBoolean, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
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
    RxJavaPlugins.getInstance().getErrorHandler().handleError(paramThrowable);
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$set.add(paramSubscription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeTimeout.2
 * JD-Core Version:    0.7.0.1
 */