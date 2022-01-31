package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringStartsWith
  extends SubstringMatcher
{
  public StringStartsWith(String paramString)
  {
    super(paramString);
  }
  
  @Factory
  public static Matcher<String> startsWith(String paramString)
  {
    return new StringStartsWith(paramString);
  }
  
  protected boolean evalSubstringOf(String paramString)
  {
    return paramString.startsWith(this.substring);
  }
  
  protected String relationship()
  {
    return "starting with";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.StringStartsWith
 * JD-Core Version:    0.7.0.1
 */