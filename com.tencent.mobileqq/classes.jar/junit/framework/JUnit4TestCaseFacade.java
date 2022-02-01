package junit.framework;

import org.junit.runner.Describable;
import org.junit.runner.Description;

public class JUnit4TestCaseFacade
  implements Test, Describable
{
  private final Description fDescription;
  
  JUnit4TestCaseFacade(Description paramDescription)
  {
    this.fDescription = paramDescription;
  }
  
  public int countTestCases()
  {
    return 1;
  }
  
  public Description getDescription()
  {
    return this.fDescription;
  }
  
  public void run(TestResult paramTestResult)
  {
    throw new RuntimeException("This test stub created only for informational purposes.");
  }
  
  public String toString()
  {
    return getDescription().toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.framework.JUnit4TestCaseFacade
 * JD-Core Version:    0.7.0.1
 */