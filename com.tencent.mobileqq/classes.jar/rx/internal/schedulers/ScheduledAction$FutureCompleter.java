package rx.internal.schedulers;

import java.util.concurrent.Future;
import rx.Subscription;

final class ScheduledAction$FutureCompleter
  implements Subscription
{
  private final Future<?> f;
  
  ScheduledAction$FutureCompleter(Future<?> paramFuture)
  {
    Object localObject;
    this.f = localObject;
  }
  
  public boolean isUnsubscribed()
  {
    return this.f.isCancelled();
  }
  
  public void unsubscribe()
  {
    if (this.this$0.get() != Thread.currentThread())
    {
      this.f.cancel(true);
      return;
    }
    this.f.cancel(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.internal.schedulers.ScheduledAction.FutureCompleter
 * JD-Core Version:    0.7.0.1
 */