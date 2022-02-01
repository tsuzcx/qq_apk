package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;

public class TestSetup
  extends TestDecorator
{
  public TestSetup(Test paramTest)
  {
    super(paramTest);
  }
  
  public void run(TestResult paramTestResult)
  {
    paramTestResult.runProtected(this, new TestSetup.1(this, paramTestResult));
  }
  
  protected void setUp() {}
  
  protected void tearDown() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     junit.extensions.TestSetup
 * JD-Core Version:    0.7.0.1
 */