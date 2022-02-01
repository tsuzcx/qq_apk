package org.junit.rules;

import java.util.List;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class TestWatcher
  implements TestRule
{
  private void failedQuietly(Throwable paramThrowable, Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      failed(paramThrowable, paramDescription);
      return;
    }
    catch (Throwable paramThrowable)
    {
      paramList.add(paramThrowable);
    }
  }
  
  private void finishedQuietly(Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      finished(paramDescription);
      return;
    }
    catch (Throwable paramDescription)
    {
      paramList.add(paramDescription);
    }
  }
  
  private void skippedQuietly(org.junit.internal.AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      if ((paramAssumptionViolatedException instanceof org.junit.AssumptionViolatedException))
      {
        skipped((org.junit.AssumptionViolatedException)paramAssumptionViolatedException, paramDescription);
        return;
      }
      skipped(paramAssumptionViolatedException, paramDescription);
      return;
    }
    catch (Throwable paramAssumptionViolatedException)
    {
      paramList.add(paramAssumptionViolatedException);
    }
  }
  
  private void startingQuietly(Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      starting(paramDescription);
      return;
    }
    catch (Throwable paramDescription)
    {
      paramList.add(paramDescription);
    }
  }
  
  private void succeededQuietly(Description paramDescription, List<Throwable> paramList)
  {
    try
    {
      succeeded(paramDescription);
      return;
    }
    catch (Throwable paramDescription)
    {
      paramList.add(paramDescription);
    }
  }
  
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    return new TestWatcher.1(this, paramDescription, paramStatement);
  }
  
  protected void failed(Throwable paramThrowable, Description paramDescription) {}
  
  protected void finished(Description paramDescription) {}
  
  protected void skipped(org.junit.AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription)
  {
    skipped(paramAssumptionViolatedException, paramDescription);
  }
  
  @Deprecated
  protected void skipped(org.junit.internal.AssumptionViolatedException paramAssumptionViolatedException, Description paramDescription) {}
  
  protected void starting(Description paramDescription) {}
  
  protected void succeeded(Description paramDescription) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.rules.TestWatcher
 * JD-Core Version:    0.7.0.1
 */