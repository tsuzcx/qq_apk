package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class Stopwatch
  implements TestRule
{
  private final Stopwatch.Clock clock;
  private volatile long endNanos;
  private volatile long startNanos;
  
  public Stopwatch()
  {
    this(new Stopwatch.Clock());
  }
  
  Stopwatch(Stopwatch.Clock paramClock)
  {
    this.clock = paramClock;
  }
  
  private long getNanos()
  {
    if (this.startNanos == 0L) {
      throw new IllegalStateException("Test has not started");
    }
    long l2 = this.endNanos;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = this.clock.nanoTime();
    }
    return l1 - this.startNanos;
  }
  
  private void starting()
  {
    this.startNanos = this.clock.nanoTime();
    this.endNanos = 0L;
  }
  
  private void stopping()
  {
    this.endNanos = this.clock.nanoTime();
  }
  
  public final Statement apply(Statement paramStatement, Description paramDescription)
  {
    return new Stopwatch.InternalWatcher(this, null).apply(paramStatement, paramDescription);
  }
  
  protected void failed(long paramLong, Throwable paramThrowable, Description paramDescription) {}
  
  protected void finished(long paramLong, Description paramDescription) {}
  
  public long runtime(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(getNanos(), TimeUnit.NANOSECONDS);
  }
  
  protected void skipped(long paramLong, AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription) {}
  
  protected void succeeded(long paramLong, Description paramDescription) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.rules.Stopwatch
 * JD-Core Version:    0.7.0.1
 */