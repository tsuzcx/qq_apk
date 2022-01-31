package org.junit.internal.matchers;

import java.lang.reflect.Method;
import org.hamcrest.BaseMatcher;
import org.junit.internal.MethodSorter;

@Deprecated
public abstract class TypeSafeMatcher<T>
  extends BaseMatcher<T>
{
  private Class<?> expectedType;
  
  protected TypeSafeMatcher()
  {
    this.expectedType = findExpectedType(getClass());
  }
  
  protected TypeSafeMatcher(Class<T> paramClass)
  {
    this.expectedType = paramClass;
  }
  
  private static Class<?> findExpectedType(Class<?> paramClass)
  {
    while (paramClass != Object.class)
    {
      Method[] arrayOfMethod = MethodSorter.getDeclaredMethods(paramClass);
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if (isMatchesSafelyMethod(localMethod)) {
          return localMethod.getParameterTypes()[0];
        }
        i += 1;
      }
      paramClass = paramClass.getSuperclass();
    }
    throw new Error("Cannot determine correct type for matchesSafely() method.");
  }
  
  private static boolean isMatchesSafelyMethod(Method paramMethod)
  {
    return (paramMethod.getName().equals("matchesSafely")) && (paramMethod.getParameterTypes().length == 1) && (!paramMethod.isSynthetic());
  }
  
  public final boolean matches(Object paramObject)
  {
    return (paramObject != null) && (this.expectedType.isInstance(paramObject)) && (matchesSafely(paramObject));
  }
  
  public abstract boolean matchesSafely(T paramT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.internal.matchers.TypeSafeMatcher
 * JD-Core Version:    0.7.0.1
 */