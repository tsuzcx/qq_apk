package junit.extensions;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;

public class ActiveTestSuite
  extends TestSuite
{
  private volatile int fActiveTestDeathCount;
  
  public ActiveTestSuite() {}
  
  public ActiveTestSuite(Class<? extends TestCase> paramClass)
  {
    super(paramClass);
  }
  
  public ActiveTestSuite(Class<? extends TestCase> paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  public ActiveTestSuite(String paramString)
  {
    super(paramString);
  }
  
  public void run(TestResult paramTestResult)
  {
    this.fActiveTestDeathCount = 0;
    super.run(paramTestResult);
    waitUntilFinished();
  }
  
  public void runFinished()
  {
    try
    {
      this.fActiveTestDeathCount += 1;
      notifyAll();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void runTest(Test paramTest, TestResult paramTestResult)
  {
    new ActiveTestSuite.1(this, paramTest, paramTestResult).start();
  }
  
  void waitUntilFinished()
  {
    try
    {
      for (;;)
      {
        int i = this.fActiveTestDeathCount;
        int j = testCount();
        if (i < j) {
          try
          {
            wait();
          }
          catch (InterruptedException localInterruptedException) {}
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     junit.extensions.ActiveTestSuite
 * JD-Core Version:    0.7.0.1
 */