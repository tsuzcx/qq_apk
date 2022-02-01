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
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    double d = paramLong;
    Double.isNaN(d);
    return localNumberFormat.format(d / 1000.0D);
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
    PrintStream localPrintStream = getWriter();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramTestFailure.failedTest());
    localPrintStream.print(localStringBuilder.toString());
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
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (paramInt == 1)
    {
      localPrintStream = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("There was ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(":");
      localPrintStream.println(localStringBuilder.toString());
    }
    else
    {
      localPrintStream = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("There were ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      localStringBuilder.append("s:");
      localPrintStream.println(localStringBuilder.toString());
    }
    paramInt = 1;
    while (paramEnumeration.hasMoreElements())
    {
      printDefect((TestFailure)paramEnumeration.nextElement(), paramInt);
      paramInt += 1;
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
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (paramTestResult.wasSuccessful())
    {
      getWriter().println();
      getWriter().print("OK");
      localPrintStream = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" (");
      localStringBuilder.append(paramTestResult.runCount());
      localStringBuilder.append(" test");
      if (paramTestResult.runCount() == 1) {
        paramTestResult = "";
      } else {
        paramTestResult = "s";
      }
      localStringBuilder.append(paramTestResult);
      localStringBuilder.append(")");
      localPrintStream.println(localStringBuilder.toString());
    }
    else
    {
      getWriter().println();
      getWriter().println("FAILURES!!!");
      localPrintStream = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tests run: ");
      localStringBuilder.append(paramTestResult.runCount());
      localStringBuilder.append(",  Failures: ");
      localStringBuilder.append(paramTestResult.failureCount());
      localStringBuilder.append(",  Errors: ");
      localStringBuilder.append(paramTestResult.errorCount());
      localPrintStream.println(localStringBuilder.toString());
    }
    getWriter().println();
  }
  
  protected void printHeader(long paramLong)
  {
    getWriter().println();
    PrintStream localPrintStream = getWriter();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Time: ");
    localStringBuilder.append(elapsedTimeAsString(paramLong));
    localPrintStream.println(localStringBuilder.toString());
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