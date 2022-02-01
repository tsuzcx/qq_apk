package org.junit.rules;

import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;

class Stopwatch$InternalWatcher
  extends TestWatcher
{
  private Stopwatch$InternalWatcher(Stopwatch paramStopwatch) {}
  
  protected void failed(Throwable paramThrowable, Description paramDescription)
  {
    Stopwatch.access$300(this.this$0);
    Stopwatch localStopwatch = this.this$0;
    localStopwatch.failed(Stopwatch.access$200(localStopwatch), paramThrowable, paramDescription);
  }
  
  protected void finished(Description paramDescription)
  {
    Stopwatch localStopwatch = this.this$0;
    localStopwatch.finished(Stopwatch.access$200(localStopwatch), paramDescription);
  }
  
  protected void skipped(AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription)
  {
    Stopwatch.access$300(this.this$0);
    Stopwatch localStopwatch = this.this$0;
    localStopwatch.skipped(Stopwatch.access$200(localStopwatch), paramAssumptionViolatedException, paramDescription);
  }
  
  protected void starting(Description paramDescription)
  {
    Stopwatch.access$100(this.this$0);
  }
  
  protected void succeeded(Description paramDescription)
  {
    Stopwatch.access$300(this.this$0);
    Stopwatch localStopwatch = this.this$0;
    localStopwatch.succeeded(Stopwatch.access$200(localStopwatch), paramDescription);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.rules.Stopwatch.InternalWatcher
 * JD-Core Version:    0.7.0.1
 */