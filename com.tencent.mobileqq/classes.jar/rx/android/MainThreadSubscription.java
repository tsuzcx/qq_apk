package rx.android;

import android.os.Looper;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.Scheduler;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;

public abstract class MainThreadSubscription
  implements Subscription
{
  private final AtomicBoolean unsubscribed = new AtomicBoolean();
  
  public static void verifyMainThread()
  {
    if (Looper.myLooper() != Looper.getMainLooper()) {
      throw new IllegalStateException("Expected to be called on the main thread but was " + Thread.currentThread().getName());
    }
  }
  
  public final boolean isUnsubscribed()
  {
    return this.unsubscribed.get();
  }
  
  protected abstract void onUnsubscribe();
  
  public final void unsubscribe()
  {
    if (this.unsubscribed.compareAndSet(false, true))
    {
      if (Looper.myLooper() == Looper.getMainLooper()) {
        onUnsubscribe();
      }
    }
    else {
      return;
    }
    AndroidSchedulers.mainThread().createWorker().schedule(new MainThreadSubscription.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.android.MainThreadSubscription
 * JD-Core Version:    0.7.0.1
 */