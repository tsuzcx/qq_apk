package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class Theories
  extends BlockJUnit4ClassRunner
{
  public Theories(Class<?> paramClass)
  {
    super(paramClass);
  }
  
  private void validateDataPointFields(List<Throwable> paramList)
  {
    Field[] arrayOfField = getTestClass().getJavaClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((localField.getAnnotation(DataPoint.class) != null) || (localField.getAnnotation(DataPoints.class) != null))
      {
        StringBuilder localStringBuilder;
        if (!Modifier.isStatic(localField.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint field ");
          localStringBuilder.append(localField.getName());
          localStringBuilder.append(" must be static");
          paramList.add(new Error(localStringBuilder.toString()));
        }
        if (!Modifier.isPublic(localField.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint field ");
          localStringBuilder.append(localField.getName());
          localStringBuilder.append(" must be public");
          paramList.add(new Error(localStringBuilder.toString()));
        }
      }
      i += 1;
    }
  }
  
  private void validateDataPointMethods(List<Throwable> paramList)
  {
    Method[] arrayOfMethod = getTestClass().getJavaClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if ((localMethod.getAnnotation(DataPoint.class) != null) || (localMethod.getAnnotation(DataPoints.class) != null))
      {
        StringBuilder localStringBuilder;
        if (!Modifier.isStatic(localMethod.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint method ");
          localStringBuilder.append(localMethod.getName());
          localStringBuilder.append(" must be static");
          paramList.add(new Error(localStringBuilder.toString()));
        }
        if (!Modifier.isPublic(localMethod.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint method ");
          localStringBuilder.append(localMethod.getName());
          localStringBuilder.append(" must be public");
          paramList.add(new Error(localStringBuilder.toString()));
        }
      }
      i += 1;
    }
  }
  
  private void validateParameterSupplier(Class<? extends ParameterSupplier> paramClass, List<Throwable> paramList)
  {
    Object localObject = paramClass.getConstructors();
    if (localObject.length != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ParameterSupplier ");
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(" must have only one constructor (either empty or taking only a TestClass)");
      paramList.add(new Error(((StringBuilder)localObject).toString()));
      return;
    }
    localObject = localObject[0].getParameterTypes();
    if ((localObject.length != 0) && (!localObject[0].equals(TestClass.class)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ParameterSupplier ");
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(" constructor must take either nothing or a single TestClass instance");
      paramList.add(new Error(((StringBuilder)localObject).toString()));
    }
  }
  
  protected void collectInitializationErrors(List<Throwable> paramList)
  {
    super.collectInitializationErrors(paramList);
    validateDataPointFields(paramList);
    validateDataPointMethods(paramList);
  }
  
  protected List<FrameworkMethod> computeTestMethods()
  {
    ArrayList localArrayList = new ArrayList(super.computeTestMethods());
    List localList = getTestClass().getAnnotatedMethods(Theory.class);
    localArrayList.removeAll(localList);
    localArrayList.addAll(localList);
    return localArrayList;
  }
  
  public Statement methodBlock(FrameworkMethod paramFrameworkMethod)
  {
    return new Theories.TheoryAnchor(paramFrameworkMethod, getTestClass());
  }
  
  protected void validateConstructor(List<Throwable> paramList)
  {
    validateOnlyOneConstructor(paramList);
  }
  
  protected void validateTestMethods(List<Throwable> paramList)
  {
    Iterator localIterator = computeTestMethods().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FrameworkMethod)localIterator.next();
      if (((FrameworkMethod)localObject).getAnnotation(Theory.class) != null)
      {
        ((FrameworkMethod)localObject).validatePublicVoid(false, paramList);
        ((FrameworkMethod)localObject).validateNoTypeParametersOnArgs(paramList);
      }
      else
      {
        ((FrameworkMethod)localObject).validatePublicVoidNoArg(false, paramList);
      }
      localObject = ParameterSignature.signatures(((FrameworkMethod)localObject).getMethod()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ParametersSuppliedBy localParametersSuppliedBy = (ParametersSuppliedBy)((ParameterSignature)((Iterator)localObject).next()).findDeepAnnotation(ParametersSuppliedBy.class);
        if (localParametersSuppliedBy != null) {
          validateParameterSupplier(localParametersSuppliedBy.value(), paramList);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.theories.Theories
 * JD-Core Version:    0.7.0.1
 */