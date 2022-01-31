package rx;

import java.util.concurrent.TimeUnit;

public abstract class Scheduler
{
  static final long CLOCK_DRIFT_TOLERANCE_NANOS = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15L).longValue());
  
  public abstract Scheduler.Worker createWorker();
  
  public long now()
  {
    return System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     rx.Scheduler
 * JD-Core Version:    0.7.0.1
 */