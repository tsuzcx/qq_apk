package org.junit.rules;

import java.util.concurrent.TimeUnit;
import org.junit.internal.runners.statements.FailOnTimeout;
import org.junit.internal.runners.statements.FailOnTimeout.Builder;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class Timeout
  implements TestRule
{
  private final boolean lookForStuckThread;
  private final TimeUnit timeUnit;
  private final long timeout;
  
  @Deprecated
  public Timeout(int paramInt)
  {
    this(paramInt, TimeUnit.MILLISECONDS);
  }
  
  public Timeout(long paramLong, TimeUnit paramTimeUnit)
  {
    this.timeout = paramLong;
    this.timeUnit = paramTimeUnit;
    this.lookForStuckThread = false;
  }
  
  protected Timeout(Timeout.Builder paramBuilder)
  {
    this.timeout = paramBuilder.getTimeout();
    this.timeUnit = paramBuilder.getTimeUnit();
    this.lookForStuckThread = paramBuilder.getLookingForStuckThread();
  }
  
  public static Timeout.Builder builder()
  {
    return new Timeout.Builder();
  }
  
  public static Timeout millis(long paramLong)
  {
    return new Timeout(paramLong, TimeUnit.MILLISECONDS);
  }
  
  public static Timeout seconds(long paramLong)
  {
    return new Timeout(paramLong, TimeUnit.SECONDS);
  }
  
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    try
    {
      paramStatement = createFailOnTimeoutStatement(paramStatement);
      return paramStatement;
    }
    catch (Exception paramStatement) {}
    return new Timeout.1(this, paramStatement);
  }
  
  protected Statement createFailOnTimeoutStatement(Statement paramStatement)
  {
    return FailOnTimeout.builder().withTimeout(this.timeout, this.timeUnit).withLookingForStuckThread(this.lookForStuckThread).build(paramStatement);
  }
  
  protected final boolean getLookingForStuckThread()
  {
    return this.lookForStuckThread;
  }
  
  protected final long getTimeout(TimeUnit paramTimeUnit)
  {
    return paramTimeUnit.convert(this.timeout, this.timeUnit);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.rules.Timeout
 * JD-Core Version:    0.7.0.1
 */