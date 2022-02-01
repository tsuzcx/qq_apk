package org.junit;

import org.hamcrest.Matcher;

public class AssumptionViolatedException
  extends org.junit.internal.AssumptionViolatedException
{
  private static final long serialVersionUID = 1L;
  
  public <T> AssumptionViolatedException(T paramT, Matcher<T> paramMatcher)
  {
    super(paramT, paramMatcher);
  }
  
  public AssumptionViolatedException(String paramString)
  {
    super(paramString);
  }
  
  public <T> AssumptionViolatedException(String paramString, T paramT, Matcher<T> paramMatcher)
  {
    super(paramString, paramT, paramMatcher);
  }
  
  public AssumptionViolatedException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.AssumptionViolatedException
 * JD-Core Version:    0.7.0.1
 */