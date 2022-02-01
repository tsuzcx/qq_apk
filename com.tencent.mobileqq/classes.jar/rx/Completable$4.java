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
    Object localObject = new Completable.4.1(this, localAtomicBoolean, localCompositeSubscription, paramCompletableSubscriber);
    try
    {
      Iterator localIterator = this.val$sources.iterator();
      if (localIterator == null)
      {
        paramCompletableSubscriber.onError(new NullPointerException("The iterator returned is null"));
        return;
      }
      int i = 1;
      for (;;)
      {
        if (!localAtomicBoolean.get())
        {
          if (localCompositeSubscription.isUnsubscribed()) {
            return;
          }
          try
          {
            boolean bool = localIterator.hasNext();
            if (!bool)
            {
              if (i != 0) {
                paramCompletableSubscriber.onCompleted();
              }
              return;
            }
            if (!localAtomicBoolean.get())
            {
              if (localCompositeSubscription.isUnsubscribed()) {
                return;
              }
              try
              {
                Completable localCompletable = (Completable)localIterator.next();
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
                if (!localAtomicBoolean.get())
                {
                  if (localCompositeSubscription.isUnsubscribed()) {
                    return;
                  }
                  localCompletable.subscribe((Completable.CompletableSubscriber)localObject);
                  i = 0;
                  continue;
                }
                return;
              }
              catch (Throwable localThrowable2)
              {
                if (localAtomicBoolean.compareAndSet(false, true))
                {
                  localCompositeSubscription.unsubscribe();
                  paramCompletableSubscriber.onError(localThrowable2);
                  return;
                }
                Completable.ERROR_HANDLER.handleError(localThrowable2);
              }
            }
            else
            {
              return;
            }
          }
          catch (Throwable localThrowable3)
          {
            if (localAtomicBoolean.compareAndSet(false, true))
            {
              localCompositeSubscription.unsubscribe();
              paramCompletableSubscriber.onError(localThrowable3);
              return;
            }
            Completable.ERROR_HANDLER.handleError(localThrowable3);
          }
        }
      }
      return;
    }
    catch (Throwable localThrowable1)
    {
      paramCompletableSubscriber.onError(localThrowable1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.4
 * JD-Core Version:    0.7.0.1
 */