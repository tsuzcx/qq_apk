package rx.schedulers;

import rx.Scheduler;
import rx.Scheduler.Worker;

public final class ImmediateScheduler
  extends Scheduler
{
  private static final ImmediateScheduler INSTANCE = new ImmediateScheduler();
  
  static ImmediateScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new ImmediateScheduler.InnerImmediateScheduler(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.schedulers.ImmediateScheduler
 * JD-Core Version:    0.7.0.1
 */