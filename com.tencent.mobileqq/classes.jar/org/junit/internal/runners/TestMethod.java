package org.junit.internal.runners;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.Test.None;

@Deprecated
public class TestMethod
{
  private final Method method;
  private TestClass testClass;
  
  public TestMethod(Method paramMethod, TestClass paramTestClass)
  {
    this.method = paramMethod;
    this.testClass = paramTestClass;
  }
  
  boolean expectsException()
  {
    return getExpectedException() != null;
  }
  
  List<Method> getAfters()
  {
    return this.testClass.getAnnotatedMethods(After.class);
  }
  
  List<Method> getBefores()
  {
    return this.testClass.getAnnotatedMethods(Before.class);
  }
  
  protected Class<? extends Throwable> getExpectedException()
  {
    Test localTest = (Test)this.method.getAnnotation(Test.class);
    if ((localTest == null) || (localTest.expected() == Test.None.class)) {
      return null;
    }
    return localTest.expected();
  }
  
  public long getTimeout()
  {
    Test localTest = (Test)this.method.getAnnotation(Test.class);
    if (localTest == null) {
      return 0L;
    }
    return localTest.timeout();
  }
  
  public void invoke(Object paramObject)
  {
    this.method.invoke(paramObject, new Object[0]);
  }
  
  public boolean isIgnored()
  {
    return this.method.getAnnotation(Ignore.class) != null;
  }
  
  boolean isUnexpected(Throwable paramThrowable)
  {
    return !getExpectedException().isAssignableFrom(paramThrowable.getClass());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.internal.runners.TestMethod
 * JD-Core Version:    0.7.0.1
 */