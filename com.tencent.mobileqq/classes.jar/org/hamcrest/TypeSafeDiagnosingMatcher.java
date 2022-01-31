package org.hamcrest;

import org.hamcrest.internal.ReflectiveTypeFinder;

public abstract class TypeSafeDiagnosingMatcher<T>
  extends BaseMatcher<T>
{
  private static final ReflectiveTypeFinder TYPE_FINDER = new ReflectiveTypeFinder("matchesSafely", 2, 0);
  private final Class<?> expectedType;
  
  protected TypeSafeDiagnosingMatcher()
  {
    this(TYPE_FINDER);
  }
  
  protected TypeSafeDiagnosingMatcher(Class<?> paramClass)
  {
    this.expectedType = paramClass;
  }
  
  protected TypeSafeDiagnosingMatcher(ReflectiveTypeFinder paramReflectiveTypeFinder)
  {
    this.expectedType = paramReflectiveTypeFinder.findExpectedType(getClass());
  }
  
  public final void describeMismatch(Object paramObject, Description paramDescription)
  {
    if ((paramObject == null) || (!this.expectedType.isInstance(paramObject)))
    {
      super.describeMismatch(paramObject, paramDescription);
      return;
    }
    matchesSafely(paramObject, paramDescription);
  }
  
  public final boolean matches(Object paramObject)
  {
    return (paramObject != null) && (this.expectedType.isInstance(paramObject)) && (matchesSafely(paramObject, new Description.NullDescription()));
  }
  
  protected abstract boolean matchesSafely(T paramT, Description paramDescription);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.hamcrest.TypeSafeDiagnosingMatcher
 * JD-Core Version:    0.7.0.1
 */