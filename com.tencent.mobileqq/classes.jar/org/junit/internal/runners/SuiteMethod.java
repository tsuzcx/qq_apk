package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import junit.framework.Test;

public class SuiteMethod
  extends JUnit38ClassRunner
{
  public SuiteMethod(Class<?> paramClass)
  {
    super(testFromSuiteMethod(paramClass));
  }
  
  public static Test testFromSuiteMethod(Class<?> paramClass)
  {
    try
    {
      Object localObject = paramClass.getMethod("suite", new Class[0]);
      if (Modifier.isStatic(((Method)localObject).getModifiers())) {
        return (Test)((Method)localObject).invoke(null, new Object[0]);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(".suite() must be static");
      throw new Exception(((StringBuilder)localObject).toString());
    }
    catch (InvocationTargetException paramClass)
    {
      throw paramClass.getCause();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.SuiteMethod
 * JD-Core Version:    0.7.0.1
 */