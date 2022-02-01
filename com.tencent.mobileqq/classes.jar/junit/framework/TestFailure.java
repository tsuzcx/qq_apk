package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;

public class TestFailure
{
  protected Test fFailedTest;
  protected Throwable fThrownException;
  
  public TestFailure(Test paramTest, Throwable paramThrowable)
  {
    this.fFailedTest = paramTest;
    this.fThrownException = paramThrowable;
  }
  
  public String exceptionMessage()
  {
    return thrownException().getMessage();
  }
  
  public Test failedTest()
  {
    return this.fFailedTest;
  }
  
  public boolean isFailure()
  {
    return thrownException() instanceof AssertionFailedError;
  }
  
  public Throwable thrownException()
  {
    return this.fThrownException;
  }
  
  public String toString()
  {
    return this.fFailedTest + ": " + this.fThrownException.getMessage();
  }
  
  public String trace()
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    thrownException().printStackTrace(localPrintWriter);
    return localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     junit.framework.TestFailure
 * JD-Core Version:    0.7.0.1
 */