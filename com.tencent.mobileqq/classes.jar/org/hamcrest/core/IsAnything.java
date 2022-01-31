package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsAnything<T>
  extends BaseMatcher<T>
{
  private final String message;
  
  public IsAnything()
  {
    this("ANYTHING");
  }
  
  public IsAnything(String paramString)
  {
    this.message = paramString;
  }
  
  @Factory
  public static Matcher<Object> anything()
  {
    return new IsAnything();
  }
  
  @Factory
  public static Matcher<Object> anything(String paramString)
  {
    return new IsAnything(paramString);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText(this.message);
  }
  
  public boolean matches(Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.IsAnything
 * JD-Core Version:    0.7.0.1
 */