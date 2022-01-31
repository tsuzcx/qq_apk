package org.hamcrest.core;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

public abstract class SubstringMatcher
  extends TypeSafeMatcher<String>
{
  protected final String substring;
  
  protected SubstringMatcher(String paramString)
  {
    this.substring = paramString;
  }
  
  public void describeMismatchSafely(String paramString, Description paramDescription)
  {
    paramDescription.appendText("was \"").appendText(paramString).appendText("\"");
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("a string ").appendText(relationship()).appendText(" ").appendValue(this.substring);
  }
  
  protected abstract boolean evalSubstringOf(String paramString);
  
  public boolean matchesSafely(String paramString)
  {
    return evalSubstringOf(paramString);
  }
  
  protected abstract String relationship();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.SubstringMatcher
 * JD-Core Version:    0.7.0.1
 */