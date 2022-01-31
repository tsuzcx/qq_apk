package org.junit.rules;

import java.util.concurrent.TimeUnit;

public class Timeout$Builder
{
  private boolean lookForStuckThread = false;
  private TimeUnit timeUnit = TimeUnit.SECONDS;
  private long timeout = 0L;
  
  public Timeout build()
  {
    return new Timeout(this);
  }
  
  protected boolean getLookingForStuckThread()
  {
    return this.lookForStuckThread;
  }
  
  protected TimeUnit getTimeUnit()
  {
    return this.timeUnit;
  }
  
  protected long getTimeout()
  {
    return this.timeout;
  }
  
  public Builder withLookingForStuckThread(boolean paramBoolean)
  {
    this.lookForStuckThread = paramBoolean;
    return this;
  }
  
  public Builder withTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.timeout = paramLong;
    this.timeUnit = paramTimeUnit;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.rules.Timeout.Builder
 * JD-Core Version:    0.7.0.1
 */