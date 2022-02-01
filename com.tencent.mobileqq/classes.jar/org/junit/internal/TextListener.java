package org.junit.internal;

import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class TextListener
  extends RunListener
{
  private final PrintStream writer;
  
  public TextListener(PrintStream paramPrintStream)
  {
    this.writer = paramPrintStream;
  }
  
  public TextListener(JUnitSystem paramJUnitSystem)
  {
    this(paramJUnitSystem.out());
  }
  
  private PrintStream getWriter()
  {
    return this.writer;
  }
  
  protected String elapsedTimeAsString(long paramLong)
  {
    return NumberFormat.getInstance().format(paramLong / 1000.0D);
  }
  
  protected void printFailure(Failure paramFailure, String paramString)
  {
    getWriter().println(paramString + ") " + paramFailure.getTestHeader());
    getWriter().print(paramFailure.getTrace());
  }
  
  protected void printFailures(Result paramResult)
  {
    paramResult = paramResult.getFailures();
    if (paramResult.size() == 0) {
      return;
    }
    if (paramResult.size() == 1) {
      getWriter().println("There was " + paramResult.size() + " failure:");
    }
    for (;;)
    {
      paramResult = paramResult.iterator();
      int i = 1;
      while (paramResult.hasNext())
      {
        printFailure((Failure)paramResult.next(), "" + i);
        i += 1;
      }
      break;
      getWriter().println("There were " + paramResult.size() + " failures:");
    }
  }
  
  protected void printFooter(Result paramResult)
  {
    if (paramResult.wasSuccessful())
    {
      getWriter().println();
      getWriter().print("OK");
      PrintStream localPrintStream = getWriter();
      StringBuilder localStringBuilder = new StringBuilder().append(" (").append(paramResult.getRunCount()).append(" test");
      if (paramResult.getRunCount() == 1)
      {
        paramResult = "";
        localPrintStream.println(paramResult + ")");
      }
    }
    for (;;)
    {
      getWriter().println();
      return;
      paramResult = "s";
      break;
      getWriter().println();
      getWriter().println("FAILURES!!!");
      getWriter().println("Tests run: " + paramResult.getRunCount() + ",  Failures: " + paramResult.getFailureCount());
    }
  }
  
  protected void printHeader(long paramLong)
  {
    getWriter().println();
    getWriter().println("Time: " + elapsedTimeAsString(paramLong));
  }
  
  public void testFailure(Failure paramFailure)
  {
    this.writer.append('E');
  }
  
  public void testIgnored(Description paramDescription)
  {
    this.writer.append('I');
  }
  
  public void testRunFinished(Result paramResult)
  {
    printHeader(paramResult.getRunTime());
    printFailures(paramResult);
    printFooter(paramResult);
  }
  
  public void testStarted(Description paramDescription)
  {
    this.writer.append('.');
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.internal.TextListener
 * JD-Core Version:    0.7.0.1
 */