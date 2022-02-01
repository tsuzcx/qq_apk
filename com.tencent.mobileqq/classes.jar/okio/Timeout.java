package okio;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class Timeout
{
  public static final Timeout NONE = new Timeout.1();
  private long deadlineNanoTime;
  private boolean hasDeadline;
  private long timeoutNanos;
  
  public Timeout clearDeadline()
  {
    this.hasDeadline = false;
    return this;
  }
  
  public Timeout clearTimeout()
  {
    this.timeoutNanos = 0L;
    return this;
  }
  
  public final Timeout deadline(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong <= 0L) {
      throw new IllegalArgumentException("duration <= 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    return deadlineNanoTime(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
  }
  
  public long deadlineNanoTime()
  {
    if (!this.hasDeadline) {
      throw new IllegalStateException("No deadline");
    }
    return this.deadlineNanoTime;
  }
  
  public Timeout deadlineNanoTime(long paramLong)
  {
    this.hasDeadline = true;
    this.deadlineNanoTime = paramLong;
    return this;
  }
  
  public boolean hasDeadline()
  {
    return this.hasDeadline;
  }
  
  public void throwIfReached()
  {
    if (Thread.interrupted())
    {
      Thread.currentThread().interrupt();
      throw new InterruptedIOException("interrupted");
    }
    if ((this.hasDeadline) && (this.deadlineNanoTime - System.nanoTime() <= 0L)) {
      throw new InterruptedIOException("deadline reached");
    }
  }
  
  public Timeout timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong < 0L) {
      throw new IllegalArgumentException("timeout < 0: " + paramLong);
    }
    if (paramTimeUnit == null) {
      throw new IllegalArgumentException("unit == null");
    }
    this.timeoutNanos = paramTimeUnit.toNanos(paramLong);
    return this;
  }
  
  public long timeoutNanos()
  {
    return this.timeoutNanos;
  }
  
  public final void waitUntilNotified(Object paramObject)
  {
    long l2 = 0L;
    for (;;)
    {
      boolean bool;
      long l1;
      long l3;
      try
      {
        bool = hasDeadline();
        l1 = timeoutNanos();
        if ((!bool) && (l1 == 0L))
        {
          paramObject.wait();
          return;
        }
        l3 = System.nanoTime();
        if ((bool) && (l1 != 0L))
        {
          l1 = Math.min(l1, deadlineNanoTime() - l3);
          if (l1 > 0L)
          {
            l2 = l1 / 1000000L;
            paramObject.wait(l2, (int)(l1 - l2 * 1000000L));
            l2 = System.nanoTime() - l3;
          }
          if (l2 < l1) {
            break;
          }
          throw new InterruptedIOException("timeout");
        }
      }
      catch (InterruptedException paramObject)
      {
        Thread.currentThread().interrupt();
        throw new InterruptedIOException("interrupted");
      }
      if (bool)
      {
        l1 = deadlineNanoTime();
        l1 -= l3;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     okio.Timeout
 * JD-Core Version:    0.7.0.1
 */