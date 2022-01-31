package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable.CompletableSubscriber;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

class CompletableOnSubscribeMergeDelayErrorIterable$1
  implements Completable.CompletableSubscriber
{
  CompletableOnSubscribeMergeDelayErrorIterable$1(CompletableOnSubscribeMergeDelayErrorIterable paramCompletableOnSubscribeMergeDelayErrorIterable, CompositeSubscription paramCompositeSubscription, Queue paramQueue, AtomicInteger paramAtomicInteger, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    tryTerminate();
  }
  
  public void onError(Throwable paramThrowable)
  {
    this.val$queue.offer(paramThrowable);
    tryTerminate();
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.val$set.add(paramSubscription);
  }
  
  void tryTerminate()
  {
    if (this.val$wip.decrementAndGet() == 0)
    {
      if (this.val$queue.isEmpty()) {
        this.val$s.onCompleted();
      }
    }
    else {
      return;
    }
    this.val$s.onError(CompletableOnSubscribeMerge.collectErrors(this.val$queue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeDelayErrorIterable.1
 * JD-Core Version:    0.7.0.1
 */