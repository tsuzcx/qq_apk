package org.junit.runners.model;

import java.util.concurrent.TimeUnit;

public class TestTimedOutException
  extends Exception
{
  private static final long serialVersionUID = 31935685163547539L;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  public TestTimedOutException(long paramLong, TimeUnit paramTimeUnit)
  {
    super(String.format("test timed out after %d %s", new Object[] { Long.valueOf(paramLong), paramTimeUnit.name().toLowerCase() }));
    this.timeUnit = paramTimeUnit;
    this.timeout = paramLong;
  }
  
  public TimeUnit getTimeUnit()
  {
    return this.timeUnit;
  }
  
  public long getTimeout()
  {
    return this.timeout;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.runners.model.TestTimedOutException
 * JD-Core Version:    0.7.0.1
 */