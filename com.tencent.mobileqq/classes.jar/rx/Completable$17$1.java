package rx;

import java.util.Arrays;
import rx.exceptions.CompositeException;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.Subscriptions;

class Completable$17$1
  implements Completable.CompletableSubscriber
{
  Completable$17$1(Completable.17 param17, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  public void onCompleted()
  {
    try
    {
      this.this$1.val$onComplete.call();
      this.val$s.onCompleted();
      return;
    }
    catch (Throwable localThrowable1)
    {
      try
      {
        this.this$1.val$onAfterComplete.call();
        return;
      }
      catch (Throwable localThrowable2)
      {
        Completable.ERROR_HANDLER.handleError(localThrowable2);
      }
      localThrowable1 = localThrowable1;
      this.val$s.onError(localThrowable1);
      return;
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    try
    {
      this.this$1.val$onError.call(paramThrowable);
      this.val$s.onError(paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        paramThrowable = new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable }));
      }
    }
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    try
    {
      this.this$1.val$onSubscribe.call(paramSubscription);
      this.val$s.onSubscribe(Subscriptions.create(new Completable.17.1.1(this, paramSubscription)));
      return;
    }
    catch (Throwable localThrowable)
    {
      paramSubscription.unsubscribe();
      this.val$s.onSubscribe(Subscriptions.unsubscribed());
      this.val$s.onError(localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.Completable.17.1
 * JD-Core Version:    0.7.0.1
 */