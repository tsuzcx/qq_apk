package rx.schedulers;

import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.ScheduledAction;
import rx.subscriptions.MultipleAssignmentSubscription;

class ExecutorScheduler$ExecutorSchedulerWorker$2
  implements Action0
{
  ExecutorScheduler$ExecutorSchedulerWorker$2(ExecutorScheduler.ExecutorSchedulerWorker paramExecutorSchedulerWorker, MultipleAssignmentSubscription paramMultipleAssignmentSubscription, Action0 paramAction0, Subscription paramSubscription) {}
  
  public void call()
  {
    if (this.val$mas.isUnsubscribed()) {
      return;
    }
    Subscription localSubscription = this.this$0.schedule(this.val$action);
    this.val$mas.set(localSubscription);
    if (localSubscription.getClass() == ScheduledAction.class) {
      ((ScheduledAction)localSubscription).add(this.val$removeMas);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.ExecutorScheduler.ExecutorSchedulerWorker.2
 * JD-Core Version:    0.7.0.1
 */