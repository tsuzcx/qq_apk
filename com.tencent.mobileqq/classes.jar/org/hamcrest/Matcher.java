package org.hamcrest;

public abstract interface Matcher<T>
  extends SelfDescribing
{
  @Deprecated
  public abstract void _dont_implement_Matcher___instead_extend_BaseMatcher_();
  
  public abstract void describeMismatch(Object paramObject, Description paramDescription);
  
  public abstract boolean matches(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.Matcher
 * JD-Core Version:    0.7.0.1
 */