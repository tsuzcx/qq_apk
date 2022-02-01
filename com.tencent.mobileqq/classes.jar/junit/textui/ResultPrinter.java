package junit.textui;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Enumeration;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestFailure;
import junit.framework.TestListener;
import junit.framework.TestResult;
import junit.runner.BaseTestRunner;

public class ResultPrinter
  implements TestListener
{
  int fColumn = 0;
  PrintStream fWriter;
  
  public ResultPrinter(PrintStream paramPrintStream)
  {
    this.fWriter = paramPrintStream;
  }
  
  public void addError(Test paramTest, Throwable paramThrowable)
  {
    getWriter().print("E");
  }
  
  public void addFailure(Test paramTest, AssertionFailedError paramAssertionFailedError)
  {
    getWriter().print("F");
  }
  
  protected String elapsedTimeAsString(long paramLong)
  {
    return NumberFormat.getInstance().format(paramLong / 1000.0D);
  }
  
  public void endTest(Test paramTest) {}
  
  public PrintStream getWriter()
  {
    return this.fWriter;
  }
  
  void print(TestResult paramTestResult, long paramLong)
  {
    try
    {
      printHeader(paramLong);
      printErrors(paramTestResult);
      printFailures(paramTestResult);
      printFooter(paramTestResult);
      return;
    }
    finally
    {
      paramTestResult = finally;
      throw paramTestResult;
    }
  }
  
  public void printDefect(TestFailure paramTestFailure, int paramInt)
  {
    printDefectHeader(paramTestFailure, paramInt);
    printDefectTrace(paramTestFailure);
  }
  
  protected void printDefectHeader(TestFailure paramTestFailure, int paramInt)
  {
    getWriter().print(paramInt + ") " + paramTestFailure.failedTest());
  }
  
  protected void printDefectTrace(TestFailure paramTestFailure)
  {
    getWriter().print(BaseTestRunner.getFilteredTrace(paramTestFailure.trace()));
  }
  
  protected void printDefects(Enumeration<TestFailure> paramEnumeration, int paramInt, String paramString)
  {
    if (paramInt == 0) {
      return;
    }
    if (paramInt == 1) {
      getWriter().println("There was " + paramInt + " " + paramString + ":");
    }
    for (;;)
    {
      paramInt = 1;
      while (paramEnumeration.hasMoreElements())
      {
        printDefect((TestFailure)paramEnumeration.nextElement(), paramInt);
        paramInt += 1;
      }
      break;
      getWriter().println("There were " + paramInt + " " + paramString + "s:");
    }
  }
  
  protected void printErrors(TestResult paramTestResult)
  {
    printDefects(paramTestResult.errors(), paramTestResult.errorCount(), "error");
  }
  
  protected void printFailures(TestResult paramTestResult)
  {
    printDefects(paramTestResult.failures(), paramTestResult.failureCount(), "failure");
  }
  
  protected void printFooter(TestResult paramTestResult)
  {
    if (paramTestResult.wasSuccessful())
    {
      getWriter().println();
      getWriter().print("OK");
      PrintStream localPrintStream = getWriter();
      StringBuilder localStringBuilder = new StringBuilder().append(" (").append(paramTestResult.runCount()).append(" test");
      if (paramTestResult.runCount() == 1)
      {
        paramTestResult = "";
        localPrintStream.println(paramTestResult + ")");
      }
    }
    for (;;)
    {
      getWriter().println();
      return;
      paramTestResult = "s";
      break;
      getWriter().println();
      getWriter().println("FAILURES!!!");
      getWriter().println("Tests run: " + paramTestResult.runCount() + ",  Failures: " + paramTestResult.failureCount() + ",  Errors: " + paramTestResult.errorCount());
    }
  }
  
  protected void printHeader(long paramLong)
  {
    getWriter().println();
    getWriter().println("Time: " + elapsedTimeAsString(paramLong));
  }
  
  void printWaitPrompt()
  {
    getWriter().println();
    getWriter().println("<RETURN> to continue");
  }
  
  public void startTest(Test paramTest)
  {
    getWriter().print(".");
    int i = this.fColumn;
    this.fColumn = (i + 1);
    if (i >= 40)
    {
      getWriter().println();
      this.fColumn = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     junit.textui.ResultPrinter
 * JD-Core Version:    0.7.0.1
 */