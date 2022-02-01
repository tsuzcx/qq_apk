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
    if (paramLong > 0L)
    {
      if (paramTimeUnit != null) {
        return deadlineNanoTime(System.nanoTime() + paramTimeUnit.toNanos(paramLong));
      }
      throw new IllegalArgumentException("unit == null");
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("duration <= 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public long deadlineNanoTime()
  {
    if (this.hasDeadline) {
      return this.deadlineNanoTime;
    }
    throw new IllegalStateException("No deadline");
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
    if (!Thread.interrupted())
    {
      if (this.hasDeadline)
      {
        if (this.deadlineNanoTime - System.nanoTime() > 0L) {
          return;
        }
        throw new InterruptedIOException("deadline reached");
      }
      return;
    }
    Thread.currentThread().interrupt();
    throw new InterruptedIOException("interrupted");
  }
  
  public Timeout timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L)
    {
      if (paramTimeUnit != null)
      {
        this.timeoutNanos = paramTimeUnit.toNanos(paramLong);
        return this;
      }
      throw new IllegalArgumentException("unit == null");
    }
    paramTimeUnit = new StringBuilder();
    paramTimeUnit.append("timeout < 0: ");
    paramTimeUnit.append(paramLong);
    throw new IllegalArgumentException(paramTimeUnit.toString());
  }
  
  public long timeoutNanos()
  {
    return this.timeoutNanos;
  }
  
  public final void waitUntilNotified(Object paramObject)
  {
    try
    {
      boolean bool = hasDeadline();
      l1 = timeoutNanos();
      l2 = 0L;
      if ((!bool) && (l1 == 0L))
      {
        paramObject.wait();
        return;
      }
      long l3 = System.nanoTime();
      if ((bool) && (l1 != 0L)) {
        l1 = Math.min(l1, deadlineNanoTime() - l3);
      } else if (bool) {
        l1 = deadlineNanoTime() - l3;
      }
      if (l1 <= 0L) {
        break label156;
      }
      l2 = l1 / 1000000L;
      Long.signum(l2);
      int i = (int)(l1 - 1000000L * l2);
      paramObject.wait(l2, i);
      l2 = System.nanoTime() - l3;
    }
    catch (InterruptedException paramObject)
    {
      long l1;
      long l2;
      label136:
      label156:
      do
      {
        break label136;
      } while (l2 >= l1);
    }
    throw new InterruptedIOException("timeout");
    Thread.currentThread().interrupt();
    throw new InterruptedIOException("interrupted");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     okio.Timeout
 * JD-Core Version:    0.7.0.1
 */