package junit.framework;

import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

class JUnit4TestAdapterCache$1
  extends RunListener
{
  JUnit4TestAdapterCache$1(JUnit4TestAdapterCache paramJUnit4TestAdapterCache, TestResult paramTestResult) {}
  
  public void testFailure(Failure paramFailure)
  {
    this.val$result.addError(this.this$0.asTest(paramFailure.getDescription()), paramFailure.getException());
  }
  
  public void testFinished(Description paramDescription)
  {
    this.val$result.endTest(this.this$0.asTest(paramDescription));
  }
  
  public void testStarted(Description paramDescription)
  {
    this.val$result.startTest(this.this$0.asTest(paramDescription));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     junit.framework.JUnit4TestAdapterCache.1
 * JD-Core Version:    0.7.0.1
 */