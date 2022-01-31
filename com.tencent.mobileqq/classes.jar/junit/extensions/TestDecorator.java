package junit.extensions;

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestResult;

public class TestDecorator
  extends Assert
  implements Test
{
  protected Test fTest;
  
  public TestDecorator(Test paramTest)
  {
    this.fTest = paramTest;
  }
  
  public void basicRun(TestResult paramTestResult)
  {
    this.fTest.run(paramTestResult);
  }
  
  public int countTestCases()
  {
    return this.fTest.countTestCases();
  }
  
  public Test getTest()
  {
    return this.fTest;
  }
  
  public void run(TestResult paramTestResult)
  {
    basicRun(paramTestResult);
  }
  
  public String toString()
  {
    return this.fTest.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     junit.extensions.TestDecorator
 * JD-Core Version:    0.7.0.1
 */