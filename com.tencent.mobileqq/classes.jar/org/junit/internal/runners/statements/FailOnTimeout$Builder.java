package org.junit.internal.runners.statements;

import java.util.concurrent.TimeUnit;
import org.junit.runners.model.Statement;

public class FailOnTimeout$Builder
{
  private boolean lookForStuckThread = false;
  private long timeout = 0L;
  private TimeUnit unit = TimeUnit.SECONDS;
  
  public FailOnTimeout build(Statement paramStatement)
  {
    if (paramStatement != null) {
      return new FailOnTimeout(this, paramStatement, null);
    }
    throw new NullPointerException("statement cannot be null");
  }
  
  public Builder withLookingForStuckThread(boolean paramBoolean)
  {
    this.lookForStuckThread = paramBoolean;
    return this;
  }
  
  public Builder withTimeout(long paramLong, TimeUnit paramTimeUnit)
  {
    if (paramLong >= 0L)
    {
      if (paramTimeUnit != null)
      {
        this.timeout = paramLong;
        this.unit = paramTimeUnit;
        return this;
      }
      throw new NullPointerException("TimeUnit cannot be null");
    }
    throw new IllegalArgumentException("timeout must be non-negative");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.runners.statements.FailOnTimeout.Builder
 * JD-Core Version:    0.7.0.1
 */