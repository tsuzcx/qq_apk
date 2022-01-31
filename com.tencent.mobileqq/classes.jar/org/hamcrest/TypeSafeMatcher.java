package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class TypeSafeMatcher<T>
  extends BaseMatcher<T>
{
  private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("matchesSafely", 1, 0);
  private final Class<?> expectedType;
  
  protected TypeSafeMatcher()
  {
    this(TYPE_FINDER);
  }
  
  protected TypeSafeMatcher(Class<?> paramClass)
  {
    this.expectedType = paramClass;
  }
  
  protected TypeSafeMatcher(ReflectiveTypeFinder paramReflectiveTypeFinder)
  {
    this.expectedType = paramReflectiveTypeFinder.findExpectedType(getClass());
  }
  
  public final void describeMismatch(Object paramObject, Description paramDescription)
  {
    if (paramObject == null)
    {
      super.describeMismatch(paramObject, paramDescription);
      return;
    }
    if (!this.expectedType.isInstance(paramObject))
    {
      paramDescription.appendText("was a ").appendText(paramObject.getClass().getName()).appendText(" (").appendValue(paramObject).appendText(")");
      return;
    }
    describeMismatchSafely(paramObject, paramDescription);
  }
  
  protected void describeMismatchSafely(T paramT, Description paramDescription)
  {
    super.describeMismatch(paramT, paramDescription);
  }
  
  public final boolean matches(Object paramObject)
  {
    return (paramObject != null) && (this.expectedType.isInstance(paramObject)) && (matchesSafely(paramObject));
  }
  
  protected abstract boolean matchesSafely(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.TypeSafeMatcher
 * JD-Core Version:    0.7.0.1
 */