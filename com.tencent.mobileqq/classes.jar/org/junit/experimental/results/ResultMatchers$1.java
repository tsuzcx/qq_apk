package org.junit.experimental.results;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class ResultMatchers$1
  extends TypeSafeMatcher<PrintableResult>
{
  ResultMatchers$1(int paramInt) {}
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("has " + this.val$count + " failures");
  }
  
  public boolean matchesSafely(PrintableResult paramPrintableResult)
  {
    return paramPrintableResult.failureCount() == this.val$count;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.experimental.results.ResultMatchers.1
 * JD-Core Version:    0.7.0.1
 */