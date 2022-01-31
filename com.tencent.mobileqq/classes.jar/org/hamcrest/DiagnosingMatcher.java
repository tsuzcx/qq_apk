package org.hamcrest;

public abstract class DiagnosingMatcher<T>
  extends BaseMatcher<T>
{
  public final void describeMismatch(Object paramObject, Description paramDescription)
  {
    matches(paramObject, paramDescription);
  }
  
  public final boolean matches(Object paramObject)
  {
    return matches(paramObject, Description.NONE);
  }
  
  protected abstract boolean matches(Object paramObject, Description paramDescription);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.DiagnosingMatcher
 * JD-Core Version:    0.7.0.1
 */