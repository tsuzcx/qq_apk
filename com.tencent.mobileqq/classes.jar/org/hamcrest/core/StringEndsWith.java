package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringEndsWith
  extends SubstringMatcher
{
  public StringEndsWith(String paramString)
  {
    super(paramString);
  }
  
  @Factory
  public static Matcher<String> endsWith(String paramString)
  {
    return new StringEndsWith(paramString);
  }
  
  protected boolean evalSubstringOf(String paramString)
  {
    return paramString.endsWith(this.substring);
  }
  
  protected String relationship()
  {
    return "ending with";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.StringEndsWith
 * JD-Core Version:    0.7.0.1
 */