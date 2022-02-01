package org.junit.experimental;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.junit.runners.model.RunnerScheduler;

class ParallelComputer$1
  implements RunnerScheduler
{
  private final ExecutorService fService = Executors.newCachedThreadPool();
  
  public void finished()
  {
    try
    {
      this.fService.shutdown();
      this.fService.awaitTermination(9223372036854775807L, TimeUnit.NANOSECONDS);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      localInterruptedException.printStackTrace(System.err);
    }
  }
  
  public void schedule(Runnable paramRunnable)
  {
    this.fService.submit(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.ParallelComputer.1
 * JD-Core Version:    0.7.0.1
 */