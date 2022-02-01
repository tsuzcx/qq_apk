package rx.android.schedulers;

import android.os.Handler;
import java.util.concurrent.TimeUnit;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

class HandlerScheduler$HandlerWorker
  extends Scheduler.Worker
{
  private final CompositeSubscription compositeSubscription = new CompositeSubscription();
  private final Handler handler;
  
  HandlerScheduler$HandlerWorker(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public boolean isUnsubscribed()
  {
    return this.compositeSubscription.isUnsubscribed();
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    return schedule(paramAction0, 0L, TimeUnit.MILLISECONDS);
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (this.compositeSubscription.isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    paramAction0 = new ScheduledAction(RxAndroidPlugins.getInstance().getSchedulersHook().onSchedule(paramAction0));
    paramAction0.addParent(this.compositeSubscription);
    this.compositeSubscription.add(paramAction0);
    this.handler.postDelayed(paramAction0, paramTimeUnit.toMillis(paramLong));
    paramAction0.add(Subscriptions.create(new HandlerScheduler.HandlerWorker.1(this, paramAction0)));
    return paramAction0;
  }
  
  public void unsubscribe()
  {
    this.compositeSubscription.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.android.schedulers.HandlerScheduler.HandlerWorker
 * JD-Core Version:    0.7.0.1
 */