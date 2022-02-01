package org.junit.experimental.results;

import org.hamcrest.Matcher;

public class ResultMatchers
{
  public static Matcher<PrintableResult> failureCountIs(int paramInt)
  {
    return new ResultMatchers.1(paramInt);
  }
  
  public static Matcher<PrintableResult> hasFailureContaining(String paramString)
  {
    return new ResultMatchers.3(paramString);
  }
  
  public static Matcher<Object> hasSingleFailureContaining(String paramString)
  {
    return new ResultMatchers.2(paramString);
  }
  
  public static Matcher<PrintableResult> isSuccessful()
  {
    return failureCountIs(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     org.junit.experimental.results.ResultMatchers
 * JD-Core Version:    0.7.0.1
 */