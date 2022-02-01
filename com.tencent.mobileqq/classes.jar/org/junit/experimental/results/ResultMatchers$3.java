package org.junit.experimental.results;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

class ResultMatchers$3
  extends BaseMatcher<PrintableResult>
{
  ResultMatchers$3(String paramString) {}
  
  public void describeTo(Description paramDescription)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("has failure containing ");
    localStringBuilder.append(this.val$string);
    paramDescription.appendText(localStringBuilder.toString());
  }
  
  public boolean matches(Object paramObject)
  {
    return paramObject.toString().contains(this.val$string);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.results.ResultMatchers.3
 * JD-Core Version:    0.7.0.1
 */