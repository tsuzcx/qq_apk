package rx.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.Scheduler.Worker;
import rx.Subscription;
import rx.functions.Action0;
import rx.internal.schedulers.GenericScheduledExecutorService;
import rx.internal.schedulers.ScheduledAction;
import rx.plugins.RxJavaErrorHandler;
import rx.plugins.RxJavaPlugins;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.MultipleAssignmentSubscription;
import rx.subscriptions.Subscriptions;

final class ExecutorScheduler$ExecutorSchedulerWorker
  extends Scheduler.Worker
  implements Runnable
{
  final Executor executor;
  final ConcurrentLinkedQueue<ScheduledAction> queue;
  final ScheduledExecutorService service;
  final CompositeSubscription tasks;
  final AtomicInteger wip;
  
  public ExecutorScheduler$ExecutorSchedulerWorker(Executor paramExecutor)
  {
    this.executor = paramExecutor;
    this.queue = new ConcurrentLinkedQueue();
    this.wip = new AtomicInteger();
    this.tasks = new CompositeSubscription();
    this.service = GenericScheduledExecutorService.getInstance();
  }
  
  public boolean isUnsubscribed()
  {
    return this.tasks.isUnsubscribed();
  }
  
  public void run()
  {
    do
    {
      ScheduledAction localScheduledAction = (ScheduledAction)this.queue.poll();
      if (!localScheduledAction.isUnsubscribed()) {
        localScheduledAction.run();
      }
    } while (this.wip.decrementAndGet() > 0);
  }
  
  public Subscription schedule(Action0 paramAction0)
  {
    if (isUnsubscribed()) {
      paramAction0 = Subscriptions.unsubscribed();
    }
    ScheduledAction localScheduledAction;
    do
    {
      return paramAction0;
      localScheduledAction = new ScheduledAction(paramAction0, this.tasks);
      this.tasks.add(localScheduledAction);
      this.queue.offer(localScheduledAction);
      paramAction0 = localScheduledAction;
    } while (this.wip.getAndIncrement() != 0);
    try
    {
      this.executor.execute(this);
      return localScheduledAction;
    }
    catch (RejectedExecutionException paramAction0)
    {
      this.tasks.remove(localScheduledAction);
      this.wip.decrementAndGet();
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramAction0);
      throw paramAction0;
    }
  }
  
  public Subscription schedule(Action0 paramAction0, long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L) {
      return schedule(paramAction0);
    }
    if (isUnsubscribed()) {
      return Subscriptions.unsubscribed();
    }
    MultipleAssignmentSubscription localMultipleAssignmentSubscription1 = new MultipleAssignmentSubscription();
    MultipleAssignmentSubscription localMultipleAssignmentSubscription2 = new MultipleAssignmentSubscription();
    localMultipleAssignmentSubscription2.set(localMultipleAssignmentSubscription1);
    this.tasks.add(localMultipleAssignmentSubscription2);
    Subscription localSubscription = Subscriptions.create(new ExecutorScheduler.ExecutorSchedulerWorker.1(this, localMultipleAssignmentSubscription2));
    paramAction0 = new ScheduledAction(new ExecutorScheduler.ExecutorSchedulerWorker.2(this, localMultipleAssignmentSubscription2, paramAction0, localSubscription));
    localMultipleAssignmentSubscription1.set(paramAction0);
    try
    {
      paramAction0.add(this.service.schedule(paramAction0, paramLong, paramTimeUnit));
      return localSubscription;
    }
    catch (RejectedExecutionException paramAction0)
    {
      RxJavaPlugins.getInstance().getErrorHandler().handleError(paramAction0);
      throw paramAction0;
    }
  }
  
  public void unsubscribe()
  {
    this.tasks.unsubscribe();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rx.schedulers.ExecutorScheduler.ExecutorSchedulerWorker
 * JD-Core Version:    0.7.0.1
 */