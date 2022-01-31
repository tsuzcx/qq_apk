package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeDelayErrorArray
  implements Completable.CompletableOnSubscribe
{
  final Completable[] sources;
  
  public CompletableOnSubscribeMergeDelayErrorArray(Completable[] paramArrayOfCompletable)
  {
    this.sources = paramArrayOfCompletable;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    AtomicInteger localAtomicInteger = new AtomicInteger(this.sources.length + 1);
    ConcurrentLinkedQueue localConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    paramCompletableSubscriber.onSubscribe(localCompositeSubscription);
    Completable[] arrayOfCompletable = this.sources;
    int j = arrayOfCompletable.length;
    int i = 0;
    if (i < j)
    {
      localCompletable = arrayOfCompletable[i];
      if (!localCompositeSubscription.isUnsubscribed()) {}
    }
    while (localAtomicInteger.decrementAndGet() != 0)
    {
      Completable localCompletable;
      return;
      if (localCompletable == null)
      {
        localConcurrentLinkedQueue.offer(new NullPointerException("A completable source is null"));
        localAtomicInteger.decrementAndGet();
      }
      for (;;)
      {
        i += 1;
        break;
        localCompletable.subscribe(new CompletableOnSubscribeMergeDelayErrorArray.1(this, localCompositeSubscription, localConcurrentLinkedQueue, localAtomicInteger, paramCompletableSubscriber));
      }
    }
    if (localConcurrentLinkedQueue.isEmpty())
    {
      paramCompletableSubscriber.onCompleted();
      return;
    }
    paramCompletableSubscriber.onError(CompletableOnSubscribeMerge.collectErrors(localConcurrentLinkedQueue));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeDelayErrorArray
 * JD-Core Version:    0.7.0.1
 */