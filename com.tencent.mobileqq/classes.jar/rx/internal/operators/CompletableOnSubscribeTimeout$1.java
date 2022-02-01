package rx.internal.operators;

import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Completable;
import rx.Completable.CompletableSubscriber;
import rx.functions.Action0;
import rx.subscriptions.CompositeSubscription;

class CompletableOnSubscribeTimeout$1
  implements Action0
{
  CompletableOnSubscribeTimeout$1(CompletableOnSubscribeTimeout paramCompletableOnSubscribeTimeout, AtomicBoolean paramAtomicBoolean, CompositeSubscription paramCompositeSubscription, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void call()
  {
    if (this.val$once.compareAndSet(false, true))
    {
      this.val$set.clear();
      if (this.this$0.other == null) {
        this.val$s.onError(new TimeoutException());
      }
    }
    else
    {
      return;
    }
    this.this$0.other.subscribe(new CompletableOnSubscribeTimeout.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeTimeout.1
 * JD-Core Version:    0.7.0.1
 */