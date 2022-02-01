package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Deprecated
public class MethodValidator
{
  private final List<Throwable> errors = new ArrayList();
  private TestClass testClass;
  
  public MethodValidator(TestClass paramTestClass)
  {
    this.testClass = paramTestClass;
  }
  
  private void validateTestMethods(Class<? extends Annotation> paramClass, boolean paramBoolean)
  {
    Iterator localIterator = this.testClass.getAnnotatedMethods(paramClass).iterator();
    while (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      Object localObject;
      if (Modifier.isStatic(localMethod.getModifiers()) != paramBoolean)
      {
        if (paramBoolean) {
          paramClass = "should";
        } else {
          paramClass = "should not";
        }
        localObject = this.errors;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Method ");
        localStringBuilder.append(localMethod.getName());
        localStringBuilder.append("() ");
        localStringBuilder.append(paramClass);
        localStringBuilder.append(" be static");
        ((List)localObject).add(new Exception(localStringBuilder.toString()));
      }
      if (!Modifier.isPublic(localMethod.getDeclaringClass().getModifiers()))
      {
        paramClass = this.errors;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Class ");
        ((StringBuilder)localObject).append(localMethod.getDeclaringClass().getName());
        ((StringBuilder)localObject).append(" should be public");
        paramClass.add(new Exception(((StringBuilder)localObject).toString()));
      }
      if (!Modifier.isPublic(localMethod.getModifiers()))
      {
        paramClass = this.errors;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Method ");
        ((StringBuilder)localObject).append(localMethod.getName());
        ((StringBuilder)localObject).append(" should be public");
        paramClass.add(new Exception(((StringBuilder)localObject).toString()));
      }
      if (localMethod.getReturnType() != Void.TYPE)
      {
        paramClass = this.errors;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Method ");
        ((StringBuilder)localObject).append(localMethod.getName());
        ((StringBuilder)localObject).append(" should be void");
        paramClass.add(new Exception(((StringBuilder)localObject).toString()));
      }
      if (localMethod.getParameterTypes().length != 0)
      {
        paramClass = this.errors;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Method ");
        ((StringBuilder)localObject).append(localMethod.getName());
        ((StringBuilder)localObject).append(" should have no parameters");
        paramClass.add(new Exception(((StringBuilder)localObject).toString()));
      }
    }
  }
  
  public void assertValid()
  {
    if (this.errors.isEmpty()) {
      return;
    }
    throw new InitializationError(this.errors);
  }
  
  public void validateInstanceMethods()
  {
    validateTestMethods(After.class, false);
    validateTestMethods(Before.class, false);
    validateTestMethods(Test.class, false);
    if (this.testClass.getAnnotatedMethods(Test.class).size() == 0) {
      this.errors.add(new Exception("No runnable methods"));
    }
  }
  
  public List<Throwable> validateMethodsForDefaultRunner()
  {
    validateNoArgConstructor();
    validateStaticMethods();
    validateInstanceMethods();
    return this.errors;
  }
  
  public void validateNoArgConstructor()
  {
    try
    {
      this.testClass.getConstructor();
      return;
    }
    catch (Exception localException)
    {
      this.errors.add(new Exception("Test class should have public zero-argument constructor", localException));
    }
  }
  
  public void validateStaticMethods()
  {
    validateTestMethods(BeforeClass.class, true);
    validateTestMethods(AfterClass.class, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.MethodValidator
 * JD-Core Version:    0.7.0.1
 */