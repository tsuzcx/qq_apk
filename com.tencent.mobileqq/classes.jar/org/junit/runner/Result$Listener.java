package org.junit.runner;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunListener.ThreadSafe;

@RunListener.ThreadSafe
class Result$Listener
  extends RunListener
{
  private Result$Listener(Result paramResult) {}
  
  public void testAssumptionFailure(Failure paramFailure) {}
  
  public void testFailure(Failure paramFailure)
  {
    Result.access$800(this.this$0).add(paramFailure);
  }
  
  public void testFinished(Description paramDescription)
  {
    Result.access$700(this.this$0).getAndIncrement();
  }
  
  public void testIgnored(Description paramDescription)
  {
    Result.access$900(this.this$0).getAndIncrement();
  }
  
  public void testRunFinished(Result paramResult)
  {
    long l = System.currentTimeMillis();
    Result.access$600(this.this$0).addAndGet(l - Result.access$500(this.this$0).get());
  }
  
  public void testRunStarted(Description paramDescription)
  {
    Result.access$500(this.this$0).set(System.currentTimeMillis());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.runner.Result.Listener
 * JD-Core Version:    0.7.0.1
 */