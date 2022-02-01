package rx.schedulers;

import rx.Scheduler;
import rx.Scheduler.Worker;

public final class TrampolineScheduler
  extends Scheduler
{
  private static final TrampolineScheduler INSTANCE = new TrampolineScheduler();
  
  static int compare(int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2) {
      return -1;
    }
    if (paramInt1 == paramInt2) {
      return 0;
    }
    return 1;
  }
  
  static TrampolineScheduler instance()
  {
    return INSTANCE;
  }
  
  public Scheduler.Worker createWorker()
  {
    return new TrampolineScheduler.InnerCurrentThreadScheduler();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     rx.schedulers.TrampolineScheduler
 * JD-Core Version:    0.7.0.1
 */