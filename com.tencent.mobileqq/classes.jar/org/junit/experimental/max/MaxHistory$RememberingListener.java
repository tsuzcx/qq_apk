package org.junit.experimental.max;

import java.util.HashMap;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

final class MaxHistory$RememberingListener
  extends RunListener
{
  private long overallStart = System.currentTimeMillis();
  private Map<Description, Long> starts = new HashMap();
  
  private MaxHistory$RememberingListener(MaxHistory paramMaxHistory) {}
  
  public void testFailure(Failure paramFailure)
  {
    this.this$0.putTestFailureTimestamp(paramFailure.getDescription(), this.overallStart);
  }
  
  public void testFinished(Description paramDescription)
  {
    long l1 = System.nanoTime();
    long l2 = ((Long)this.starts.get(paramDescription)).longValue();
    this.this$0.putTestDuration(paramDescription, l1 - l2);
  }
  
  public void testRunFinished(Result paramResult)
  {
    MaxHistory.access$000(this.this$0);
  }
  
  public void testStarted(Description paramDescription)
  {
    this.starts.put(paramDescription, Long.valueOf(System.nanoTime()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.experimental.max.MaxHistory.RememberingListener
 * JD-Core Version:    0.7.0.1
 */