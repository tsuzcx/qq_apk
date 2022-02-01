package junit.extensions;

import junit.framework.Test;
import junit.framework.TestResult;

public class RepeatedTest
  extends TestDecorator
{
  private int fTimesRepeat;
  
  public RepeatedTest(Test paramTest, int paramInt)
  {
    super(paramTest);
    if (paramInt >= 0)
    {
      this.fTimesRepeat = paramInt;
      return;
    }
    throw new IllegalArgumentException("Repetition count must be >= 0");
  }
  
  public int countTestCases()
  {
    return super.countTestCases() * this.fTimesRepeat;
  }
  
  public void run(TestResult paramTestResult)
  {
    int i = 0;
    while (i < this.fTimesRepeat)
    {
      if (paramTestResult.shouldStop()) {
        return;
      }
      super.run(paramTestResult);
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append("(repeated)");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     junit.extensions.RepeatedTest
 * JD-Core Version:    0.7.0.1
 */