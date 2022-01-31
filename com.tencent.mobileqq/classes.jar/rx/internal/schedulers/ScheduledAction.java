package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;
import rx.Subscription;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.internal.util.SubscriptionList;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;

public final class ScheduledAction
  extends AtomicReference<Thread>
  implements Runnable, Subscription
{
  private static final long serialVersionUID = -3962399486978279857L;
  final Action0 action;
  final SubscriptionList cancel;
  
  public ScheduledAction(Action0 paramAction0)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList();
  }
  
  public ScheduledAction(Action0 paramAction0, SubscriptionList paramSubscriptionList)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList(new ScheduledAction.Remover2(this, paramSubscriptionList));
  }
  
  public ScheduledAction(Action0 paramAction0, CompositeSubscription paramCompositeSubscription)
  {
    this.action = paramAction0;
    this.cancel = new SubscriptionList(new ScheduledAction.Remover(this, paramCompositeSubscription));
  }
  
  public void add(Future<?> paramFuture)
  {
    this.cancel.add(new ScheduledAction.FutureCompleter(this, paramFuture));
  }
  
  public void add(Subscription paramSubscription)
  {
    this.cancel.add(paramSubscription);
  }
  
  public void addParent(SubscriptionList paramSubscriptionList)
  {
    this.cancel.add(new ScheduledAction.Remover2(this, paramSubscriptionList));
  }
  
  public void addParent(CompositeSubscription paramCompositeSubscription)
  {
    this.cancel.add(new ScheduledAction.Remover(this, paramCompositeSubscription));
  }
  
  public boolean isUnsubscribed()
  {
    return this.cancel.isUnsubscribed();
  }
  
  public void run()
  {
    try
    {
      lazySet(Thread.currentThread());
      this.action.call();
      return;
    }
    catch (Throwable localThrowable)
    {
      if ((localThrowable instanceof OnErrorNotImplementedException)) {}
      for (IllegalStateException localIllegalStateException = new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", localThrowable);; localIllegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", localIllegalStateException))
      {
        RxJavaPlugins.getInstance().getErrorHandler().handleError(localIllegalStateException);
        Thread localThread = Thread.currentThread();
        localThread.getUncaughtExceptionHandler().uncaughtException(localThread, localIllegalStateException);
        return;
      }
    }
    finally
    {
      unsubscribe();
    }
  }
  
  public void unsubscribe()
  {
    if (!this.cancel.isUnsubscribed()) {
      this.cancel.unsubscribe();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.internal.schedulers.ScheduledAction
 * JD-Core Version:    0.7.0.1
 */