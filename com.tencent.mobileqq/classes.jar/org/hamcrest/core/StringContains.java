package org.hamcrest.core;

import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class StringContains
  extends SubstringMatcher
{
  public StringContains(String paramString)
  {
    super(paramString);
  }
  
  @Factory
  public static Matcher<String> containsString(String paramString)
  {
    return new StringContains(paramString);
  }
  
  protected boolean evalSubstringOf(String paramString)
  {
    return paramString.indexOf(this.substring) >= 0;
  }
  
  protected String relationship()
  {
    return "containing";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.StringContains
 * JD-Core Version:    0.7.0.1
 */