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
    if (localIterator.hasNext())
    {
      Method localMethod = (Method)localIterator.next();
      if (Modifier.isStatic(localMethod.getModifiers()) != paramBoolean) {
        if (!paramBoolean) {
          break label338;
        }
      }
      label338:
      for (paramClass = "should";; paramClass = "should not")
      {
        this.errors.add(new Exception("Method " + localMethod.getName() + "() " + paramClass + " be static"));
        if (!Modifier.isPublic(localMethod.getDeclaringClass().getModifiers())) {
          this.errors.add(new Exception("Class " + localMethod.getDeclaringClass().getName() + " should be public"));
        }
        if (!Modifier.isPublic(localMethod.getModifiers())) {
          this.errors.add(new Exception("Method " + localMethod.getName() + " should be public"));
        }
        if (localMethod.getReturnType() != Void.TYPE) {
          this.errors.add(new Exception("Method " + localMethod.getName() + " should be void"));
        }
        if (localMethod.getParameterTypes().length == 0) {
          break;
        }
        this.errors.add(new Exception("Method " + localMethod.getName() + " should have no parameters"));
        break;
      }
    }
  }
  
  public void assertValid()
  {
    if (!this.errors.isEmpty()) {
      throw new InitializationError(this.errors);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     org.junit.internal.runners.MethodValidator
 * JD-Core Version:    0.7.0.1
 */