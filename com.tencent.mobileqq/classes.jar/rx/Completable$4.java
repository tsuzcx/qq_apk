package rx;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.CompositeSubscription;

final class Completable$4
  implements Completable.CompletableOnSubscribe
{
  Completable$4(Iterable paramIterable) {}
  
  public void call(Completable.CompletableSubscriber paramCompletableSubscriber)
  {
    CompositeSubscription localCompositeSubscription = new CompositeSubscription();
    paramCompletableSubscriber.onSubscribe(localCompositeSubscription);
    AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    Completable.4.1 local1 = new Completable.4.1(this, localAtomicBoolean, localCompositeSubscription, paramCompletableSubscriber);
    label272:
    label298:
    for (;;)
    {
      Iterator localIterator;
      try
      {
        localIterator = this.val$sources.iterator();
        if (localIterator == null)
        {
          paramCompletableSubscriber.onError(new NullPointerException("The iterator returned is null"));
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        paramCompletableSubscriber.onError(localThrowable1);
        return;
      }
      for (int i = 1;; i = 0)
      {
        for (;;)
        {
          if ((localAtomicBoolean.get()) || (localThrowable1.isUnsubscribed())) {
            break label298;
          }
          try
          {
            boolean bool = localIterator.hasNext();
            if (!bool)
            {
              if (i == 0) {
                break;
              }
              paramCompletableSubscriber.onCompleted();
              return;
            }
          }
          catch (Throwable localThrowable2)
          {
            if (localAtomicBoolean.compareAndSet(false, true))
            {
              localThrowable1.unsubscribe();
              paramCompletableSubscriber.onError(localThrowable2);
              return;
            }
            Completable.ERROR_HANDLER.handleError(localThrowable2);
            return;
          }
        }
        if ((localAtomicBoolean.get()) || (localThrowable1.isUnsubscribed())) {
          break;
        }
        Completable localCompletable;
        try
        {
          localCompletable = (Completable)localIterator.next();
          if (localCompletable != null) {
            break label272;
          }
          NullPointerException localNullPointerException = new NullPointerException("One of the sources is null");
          if (localAtomicBoolean.compareAndSet(false, true))
          {
            localThrowable1.unsubscribe();
            paramCompletableSubscriber.onError(localNullPointerException);
            return;
          }
        }
        catch (Throwable localThrowable3)
        {
          if (localAtomicBoolean.compareAndSet(false, true))
          {
            localThrowable1.unsubscribe();
            paramCompletableSubscriber.onError(localThrowable3);
            return;
          }
          Completable.ERROR_HANDLER.handleError(localThrowable3);
          return;
        }
        Completable.ERROR_HANDLER.handleError(localThrowable3);
        return;
        if ((localAtomicBoolean.get()) || (localThrowable1.isUnsubscribed())) {
          break;
        }
        localCompletable.subscribe(localThrowable3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.4
 * JD-Core Version:    0.7.0.1
 */