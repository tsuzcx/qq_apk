package org.hamcrest.core;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

public class IsSame<T>
  extends BaseMatcher<T>
{
  private final T object;
  
  public IsSame(T paramT)
  {
    this.object = paramT;
  }
  
  @Factory
  public static <T> Matcher<T> sameInstance(T paramT)
  {
    return new IsSame(paramT);
  }
  
  @Factory
  public static <T> Matcher<T> theInstance(T paramT)
  {
    return new IsSame(paramT);
  }
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("sameInstance(").appendValue(this.object).appendText(")");
  }
  
  public boolean matches(Object paramObject)
  {
    return paramObject == this.object;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.core.IsSame
 * JD-Core Version:    0.7.0.1
 */