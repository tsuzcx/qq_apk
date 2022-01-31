package org.hamcrest;

public abstract class BaseMatcher<T>
  implements Matcher<T>
{
  @Deprecated
  public final void _dont_implement_Matcher___instead_extend_BaseMatcher_() {}
  
  public void describeMismatch(Object paramObject, Description paramDescription)
  {
    paramDescription.appendText("was ").appendValue(paramObject);
  }
  
  public String toString()
  {
    return StringDescription.toString(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.BaseMatcher
 * JD-Core Version:    0.7.0.1
 */