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
    NumberFormat localNumberFormat = NumberFormat.getInstance();
    double d = paramLong;
    Double.isNaN(d);
    return localNumberFormat.format(d / 1000.0D);
  }
  
  protected void printFailure(Failure paramFailure, String paramString)
  {
    PrintStream localPrintStream = getWriter();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(") ");
    localStringBuilder.append(paramFailure.getTestHeader());
    localPrintStream.println(localStringBuilder.toString());
    getWriter().print(paramFailure.getTrace());
  }
  
  protected void printFailures(Result paramResult)
  {
    paramResult = paramResult.getFailures();
    if (paramResult.size() == 0) {
      return;
    }
    int j = paramResult.size();
    int i = 1;
    Object localObject;
    StringBuilder localStringBuilder;
    if (j == 1)
    {
      localObject = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("There was ");
      localStringBuilder.append(paramResult.size());
      localStringBuilder.append(" failure:");
      ((PrintStream)localObject).println(localStringBuilder.toString());
    }
    else
    {
      localObject = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("There were ");
      localStringBuilder.append(paramResult.size());
      localStringBuilder.append(" failures:");
      ((PrintStream)localObject).println(localStringBuilder.toString());
    }
    paramResult = paramResult.iterator();
    while (paramResult.hasNext())
    {
      localObject = (Failure)paramResult.next();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      printFailure((Failure)localObject, localStringBuilder.toString());
      i += 1;
    }
  }
  
  protected void printFooter(Result paramResult)
  {
    PrintStream localPrintStream;
    StringBuilder localStringBuilder;
    if (paramResult.wasSuccessful())
    {
      getWriter().println();
      getWriter().print("OK");
      localPrintStream = getWriter();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(" (");
      localStringBuilder.append(paramResult.getRunCount());
      localStringBuilder.append(" test");
      if (paramResult.getRunCount() == 1) {
        paramResult = "";
      } else {
        paramResult = "s";
      }
      localStringBuilder.append(paramResult);
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
      localStringBuilder.append(paramResult.getRunCount());
      localStringBuilder.append(",  Failures: ");
      localStringBuilder.append(paramResult.getFailureCount());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.TextListener
 * JD-Core Version:    0.7.0.1
 */