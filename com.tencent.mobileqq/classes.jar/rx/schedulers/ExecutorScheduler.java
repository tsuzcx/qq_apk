package rx.schedulers;

import java.util.concurrent.Executor;
import rx.Scheduler;
import rx.Scheduler.Worker;

final class ExecutorScheduler
  extends Scheduler
{
  final Executor executor;
  
  public ExecutorScheduler(Executor paramExecutor)
  {
    this.executor = paramExecutor;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new ExecutorScheduler.ExecutorSchedulerWorker(this.executor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     rx.schedulers.ExecutorScheduler
 * JD-Core Version:    0.7.0.1
 */