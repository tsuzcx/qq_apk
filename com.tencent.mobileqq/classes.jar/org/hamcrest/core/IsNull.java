package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsNull<T>
  extends BaseMatcher<T>
{
  @Factory
  public static Matcher<Object> notNullValue()
  {
    return IsNot.not(nullValue());
  }
  
  @Factory
  public static <T> Matcher<T> notNullValue(Class<T> paramClass)
  {
    return IsNot.not(nullValue(paramClass));
  }
  
  @Factory
  public static Matcher<Object> nullValue()
  {
    return new IsNull();
  }
  
  @Factory
  public static <T> Matcher<T> nullValue(Class<T> paramClass)
  {
    return new IsNull();
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("null");
  }
  
  public boolean matches(Object paramObject)
  {
    return paramObject == null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.IsNull
 * JD-Core Version:    0.7.0.1
 */