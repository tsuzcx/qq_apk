package org.junit.experimental.theories.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ParameterizedAssertionError
  extends AssertionError
{
  private static final long serialVersionUID = 1L;
  
  public ParameterizedAssertionError(Throwable paramThrowable, String paramString, Object... paramVarArgs)
  {
    super(String.format("%s(%s)", new Object[] { paramString, join(", ", paramVarArgs) }));
    initCause(paramThrowable);
  }
  
  public static String join(String paramString, Collection<Object> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      localStringBuilder.append(stringValueOf(paramCollection.next()));
      if (paramCollection.hasNext()) {
        localStringBuilder.append(paramString);
      }
    }
    return localStringBuilder.toString();
  }
  
  public static String join(String paramString, Object... paramVarArgs)
  {
    return join(paramString, Arrays.asList(paramVarArgs));
  }
  
  private static String stringValueOf(Object paramObject)
  {
    try
    {
      paramObject = String.valueOf(paramObject);
      return paramObject;
    }
    catch (Throwable paramObject) {}
    return "[toString failed]";
  }
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof ParameterizedAssertionError)) && (toString().equals(paramObject.toString()));
  }
  
  public int hashCode()
  {
    return toString().hashCode();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.experimental.theories.internal.ParameterizedAssertionError
 * JD-Core Version:    0.7.0.1
 */