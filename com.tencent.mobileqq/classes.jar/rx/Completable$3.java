package rx;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.CompositeSubscription;

final class Completable$3
  implements Completable.CompletableOnSubscribe
{
  Completable$3(Completable[] paramArrayOfCompletable) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    paramCompletableSubscriber.onSubscribe(localCompositeSubscription);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    Object localObject = new Completable.3.1(this, localAtomicBoolean, localCompositeSubscription, paramCompletableSubscriber);
    Completable[] arrayOfCompletable = this.val$sources;
    int j = arrayOfCompletable.length;
    int i = 0;
    for (;;)
    {
      Completable localCompletable;
      if (i < j)
      {
        localCompletable = arrayOfCompletable[i];
        if (!localCompositeSubscription.isUnsubscribed()) {
          break label73;
        }
      }
      label73:
      do
      {
        return;
        if (localCompletable == null)
        {
          localObject = new NullPointerException("One of the sources is null");
          if (localAtomicBoolean.compareAndSet(false, true))
          {
            localCompositeSubscription.unsubscribe();
            paramCompletableSubscriber.onError((Throwable)localObject);
            return;
          }
          Completable.ERROR_HANDLER.handleError((Throwable)localObject);
          return;
        }
      } while ((localAtomicBoolean.get()) || (localCompositeSubscription.isUnsubscribed()));
      localCompletable.subscribe((Completable.CompletableSubscriber)localObject);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.3
 * JD-Core Version:    0.7.0.1
 */