package rx.android.schedulers;

import android.os.Handler;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;

class HandlerScheduler$HandlerWorker$1
  implements Action0
{
  HandlerScheduler$HandlerWorker$1(HandlerScheduler.HandlerWorker paramHandlerWorker, ScheduledAction paramScheduledAction) {}
  
  public void call()
  {
    HandlerScheduler.HandlerWorker.access$0(this.this$1).removeCallbacks(this.val$scheduledAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rx.android.schedulers.HandlerScheduler.HandlerWorker.1
 * JD-Core Version:    0.7.0.1
 */