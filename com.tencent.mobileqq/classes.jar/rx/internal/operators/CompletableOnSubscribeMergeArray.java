package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Completable;
import rx.Completable.CompletableOnSubscribe;
import rx.Completable.CompletableSubscriber;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

public final class CompletableOnSubscribeMergeArray
  implements Completable.CompletableOnSubscribe
{
  final Completable[] sources;
  
  public CompletableOnSubscribeMergeArray(Completable[] paramArrayOfCompletable)
  {
    this.sources = paramArrayOfCompletable;
  }
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    AtomicInteger localAtomicInteger = new AtomicInteger(this.sources.length + 1);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    paramCompletableSubscriber.onSubscribe(localCompositeSubscription);
    Completable[] arrayOfCompletable = this.sources;
    int j = arrayOfCompletable.length;
    int i = 0;
    if (i < j)
    {
      localCompletable = arrayOfCompletable[i];
      if (!localCompositeSubscription.isUnsubscribed()) {}
    }
    while ((localAtomicInteger.decrementAndGet() != 0) || (!localAtomicBoolean.compareAndSet(false, true)))
    {
      Completable localCompletable;
      return;
      if (localCompletable == null)
      {
        localCompositeSubscription.unsubscribe();
        NullPointerException localNullPointerException = new NullPointerException("A completable source is null");
        if (localAtomicBoolean.compareAndSet(false, true))
        {
          paramCompletableSubscriber.onError(localNullPointerException);
          return;
        }
        RxJavaPlugins.getInstance().getErrorHandler().handleError(localNullPointerException);
      }
      localCompletable.subscribe(new CompletableOnSubscribeMergeArray.1(this, localCompositeSubscription, localAtomicBoolean, paramCompletableSubscriber, localAtomicInteger));
      i += 1;
      break;
    }
    paramCompletableSubscriber.onCompleted();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.operators.CompletableOnSubscribeMergeArray
 * JD-Core Version:    0.7.0.1
 */