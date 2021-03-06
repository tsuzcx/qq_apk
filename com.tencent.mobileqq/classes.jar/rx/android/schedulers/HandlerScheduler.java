package rx.android.schedulers;

import android.os.Handler;
import rx.Scheduler;
import rx.Scheduler.Worker;

public final class HandlerScheduler
  extends Scheduler
{
  private final Handler handler;
  
  HandlerScheduler(Handler paramHandler)
  {
    this.handler = paramHandler;
  }
  
  public static HandlerScheduler from(Handler paramHandler)
  {
    if (paramHandler != null) {
      return new HandlerScheduler(paramHandler);
    }
    throw new NullPointerException("handler == null");
  }
  
  public Scheduler.Worker createWorker()
  {
    return new HandlerScheduler.HandlerWorker(this.handler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     rx.android.schedulers.HandlerScheduler
 * JD-Core Version:    0.7.0.1
 */