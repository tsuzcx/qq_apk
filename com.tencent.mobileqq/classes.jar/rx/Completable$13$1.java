package rx;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.exceptions.CompositeException;
import rx.functions.Action1;
import rx.plugins.RxJavaErrorHandler;
import rx.subscriptions.Subscriptions;

class Completable$13$1
  implements Completable.CompletableSubscriber
{
  Subscription d;
  
  Completable$13$1(Completable.13 param13, AtomicBoolean paramAtomicBoolean, Object paramObject, Completable.CompletableSubscriber paramCompletableSubscriber) {}
  
  void dispose()
  {
    this.d.unsubscribe();
    if (this.val$once.compareAndSet(false, true)) {
      try
      {
        this.this$0.val$disposer.call(this.val$resource);
        return;
      }
      catch (Throwable localThrowable)
      {
        Completable.ERROR_HANDLER.handleError(localThrowable);
      }
    }
  }
  
  public void onCompleted()
  {
    if ((this.this$0.val$eager) && (this.val$once.compareAndSet(false, true))) {
      try
      {
        this.this$0.val$disposer.call(this.val$resource);
      }
      catch (Throwable localThrowable)
      {
        this.val$s.onError(localThrowable);
        return;
      }
    }
    this.val$s.onCompleted();
    if (!this.this$0.val$eager) {
      dispose();
    }
  }
  
  public void onError(Throwable paramThrowable)
  {
    Throwable localThrowable1 = paramThrowable;
    CompositeException localCompositeException;
    if (this.this$0.val$eager)
    {
      localThrowable1 = paramThrowable;
      if (this.val$once.compareAndSet(false, true)) {
        try
        {
          this.this$0.val$disposer.call(this.val$resource);
          localThrowable1 = paramThrowable;
        }
        catch (Throwable localThrowable2)
        {
          localCompositeException = new CompositeException(Arrays.asList(new Throwable[] { paramThrowable, localThrowable2 }));
        }
      }
    }
    this.val$s.onError(localCompositeException);
    if (!this.this$0.val$eager) {
      dispose();
    }
  }
  
  public void onSubscribe(Subscription paramSubscription)
  {
    this.d = paramSubscription;
    this.val$s.onSubscribe(Subscriptions.create(new Completable.13.1.1(this)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.Completable.13.1
 * JD-Core Version:    0.7.0.1
 */