package org.junit.internal.requests;

import org.junit.internal.runners.ErrorReportingRunner;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;

public final class FilterRequest
  extends Request
{
  private final Filter fFilter;
  private final Request request;
  
  public FilterRequest(Request paramRequest, Filter paramFilter)
  {
    this.request = paramRequest;
    this.fFilter = paramFilter;
  }
  
  public Runner getRunner()
  {
    try
    {
      Runner localRunner = this.request.getRunner();
      this.fFilter.apply(localRunner);
      return localRunner;
    }
    catch (NoTestsRemainException localNoTestsRemainException)
    {
      label18:
      break label18;
    }
    return new ErrorReportingRunner(Filter.class, new Exception(String.format("No tests found matching %s from %s", new Object[] { this.fFilter.describe(), this.request.toString() })));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.internal.requests.FilterRequest
 * JD-Core Version:    0.7.0.1
 */