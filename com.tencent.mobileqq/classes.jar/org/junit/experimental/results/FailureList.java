package org.junit.experimental.results;

import java.util.Iterator;
import java.util.List;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

class FailureList
{
  private final List<Failure> failures;
  
  public FailureList(List<Failure> paramList)
  {
    this.failures = paramList;
  }
  
  public Result result()
  {
    Result localResult = new Result();
    RunListener localRunListener = localResult.createListener();
    Iterator localIterator = this.failures.iterator();
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label62;
      }
      Failure localFailure = (Failure)localIterator.next();
      try
      {
        localRunListener.testFailure(localFailure);
      }
      catch (Exception localException)
      {
        label52:
        break label52;
      }
    }
    throw new RuntimeException("I can't believe this happened");
    label62:
    return localResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.results.FailureList
 * JD-Core Version:    0.7.0.1
 */