package okhttp3.internal.platform;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T>
{
  private final String methodName;
  private final Class[] methodParams;
  private final Class<?> returnType;
  
  OptionalMethod(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.returnType = paramClass;
    this.methodName = paramString;
    this.methodParams = paramVarArgs;
  }
  
  private Method getMethod(Class<?> paramClass)
  {
    if (this.methodName != null)
    {
      paramClass = getPublicMethod(paramClass, this.methodName, this.methodParams);
      if ((paramClass == null) || (this.returnType == null) || (this.returnType.isAssignableFrom(paramClass.getReturnType()))) {}
    }
    else
    {
      return null;
    }
    return paramClass;
  }
  
  private static Method getPublicMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    try
    {
      paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      int i;
      return paramClass;
    }
    catch (NoSuchMethodException paramClass)
    {
      try
      {
        i = paramClass.getModifiers();
        if ((i & 0x1) != 0) {
          return paramClass;
        }
        return null;
      }
      catch (NoSuchMethodException paramString)
      {
        return paramClass;
      }
      paramClass = paramClass;
      return null;
    }
  }
  
  public Object invoke(T paramT, Object... paramVarArgs)
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null) {
      throw new AssertionError("Method " + this.methodName + " not supported for object " + paramT);
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT)
    {
      paramVarArgs = new AssertionError("Unexpectedly could not call: " + localMethod);
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object invokeOptional(T paramT, Object... paramVarArgs)
  {
    Method localMethod = getMethod(paramT.getClass());
    if (localMethod == null) {
      return null;
    }
    try
    {
      paramT = localMethod.invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (IllegalAccessException paramT) {}
    return null;
  }
  
  public Object invokeOptionalWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = invokeOptional(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public Object invokeWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    try
    {
      paramT = invoke(paramT, paramVarArgs);
      return paramT;
    }
    catch (InvocationTargetException paramT)
    {
      paramT = paramT.getTargetException();
      if ((paramT instanceof RuntimeException)) {
        throw ((RuntimeException)paramT);
      }
      paramVarArgs = new AssertionError("Unexpected exception");
      paramVarArgs.initCause(paramT);
      throw paramVarArgs;
    }
  }
  
  public boolean isSupported(T paramT)
  {
    return getMethod(paramT.getClass()) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     okhttp3.internal.platform.OptionalMethod
 * JD-Core Version:    0.7.0.1
 */