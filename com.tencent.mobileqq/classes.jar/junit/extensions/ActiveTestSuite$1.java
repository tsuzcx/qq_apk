package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;

class ActiveTestSuite$1
  extends Thread
{
  ActiveTestSuite$1(ActiveTestSuite paramActiveTestSuite, Test paramTest, TestResult paramTestResult) {}
  
  public void run()
  {
    try
    {
      this.val$test.run(this.val$result);
      return;
    }
    finally
    {
      this.this$0.runFinished();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.extensions.ActiveTestSuite.1
 * JD-Core Version:    0.7.0.1
 */