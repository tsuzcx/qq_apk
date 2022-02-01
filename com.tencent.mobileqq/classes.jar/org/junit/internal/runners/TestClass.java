package org.junit.internal.runners;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.internal.MethodSorter;

@Deprecated
public class TestClass
{
  private final Class<?> klass;
  
  public TestClass(Class<?> paramClass)
  {
    this.klass = paramClass;
  }
  
  private List<Class<?>> getSuperClasses(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      localArrayList.add(paramClass);
      paramClass = paramClass.getSuperclass();
    }
    return localArrayList;
  }
  
  private boolean isShadowed(Method paramMethod1, Method paramMethod2)
  {
    if (!paramMethod2.getName().equals(paramMethod1.getName())) {
      return false;
    }
    if (paramMethod2.getParameterTypes().length != paramMethod1.getParameterTypes().length) {
      return false;
    }
    int i = 0;
    while (i < paramMethod2.getParameterTypes().length)
    {
      if (!paramMethod2.getParameterTypes()[i].equals(paramMethod1.getParameterTypes()[i])) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private boolean isShadowed(Method paramMethod, List<Method> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      if (isShadowed(paramMethod, (Method)paramList.next())) {
        return true;
      }
    }
    return false;
  }
  
  private boolean runsTopToBottom(Class<? extends Annotation> paramClass)
  {
    return (paramClass.equals(Before.class)) || (paramClass.equals(BeforeClass.class));
  }
  
  List<Method> getAfters()
  {
    return getAnnotatedMethods(AfterClass.class);
  }
  
  public List<Method> getAnnotatedMethods(Class<? extends Annotation> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getSuperClasses(this.klass).iterator();
    while (localIterator.hasNext())
    {
      Method[] arrayOfMethod = MethodSorter.getDeclaredMethods((Class)localIterator.next());
      int j = arrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = arrayOfMethod[i];
        if ((localMethod.getAnnotation(paramClass) != null) && (!isShadowed(localMethod, localArrayList))) {
          localArrayList.add(localMethod);
        }
        i += 1;
      }
    }
    if (runsTopToBottom(paramClass)) {
      Collections.reverse(localArrayList);
    }
    return localArrayList;
  }
  
  List<Method> getBefores()
  {
    return getAnnotatedMethods(BeforeClass.class);
  }
  
  public Constructor<?> getConstructor()
  {
    return this.klass.getConstructor(new Class[0]);
  }
  
  public Class<?> getJavaClass()
  {
    return this.klass;
  }
  
  public String getName()
  {
    return this.klass.getName();
  }
  
  public List<Method> getTestMethods()
  {
    return getAnnotatedMethods(Test.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.internal.runners.TestClass
 * JD-Core Version:    0.7.0.1
 */