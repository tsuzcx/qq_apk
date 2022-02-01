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
    if (i < j)
    {
      Field localField = arrayOfField[i];
      if ((localField.getAnnotation(DataPoint.class) == null) && (localField.getAnnotation(DataPoints.class) == null)) {}
      for (;;)
      {
        i += 1;
        break;
        if (!Modifier.isStatic(localField.getModifiers())) {
          paramList.add(new Error("DataPoint field " + localField.getName() + " must be static"));
        }
        if (!Modifier.isPublic(localField.getModifiers())) {
          paramList.add(new Error("DataPoint field " + localField.getName() + " must be public"));
        }
      }
    }
  }
  
  private void validateDataPointMethods(List<Throwable> paramList)
  {
    Method[] arrayOfMethod = getTestClass().getJavaClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    if (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if ((localMethod.getAnnotation(DataPoint.class) == null) && (localMethod.getAnnotation(DataPoints.class) == null)) {}
      for (;;)
      {
        i += 1;
        break;
        if (!Modifier.isStatic(localMethod.getModifiers())) {
          paramList.add(new Error("DataPoint method " + localMethod.getName() + " must be static"));
        }
        if (!Modifier.isPublic(localMethod.getModifiers())) {
          paramList.add(new Error("DataPoint method " + localMethod.getName() + " must be public"));
        }
      }
    }
  }
  
  private void validateParameterSupplier(Class<? extends ParameterSupplier> paramClass, List<Throwable> paramList)
  {
    Object localObject = paramClass.getConstructors();
    if (localObject.length != 1) {
      paramList.add(new Error("ParameterSupplier " + paramClass.getName() + " must have only one constructor (either empty or taking only a TestClass)"));
    }
    do
    {
      return;
      localObject = localObject[0].getParameterTypes();
    } while ((localObject.length == 0) || (localObject[0].equals(TestClass.class)));
    paramList.add(new Error("ParameterSupplier " + paramClass.getName() + " constructor must take either nothing or a single TestClass instance"));
  }
  
  public void collectInitializationErrors(List<Throwable> paramList)
  {
    super.collectInitializationErrors(paramList);
    validateDataPointFields(paramList);
    validateDataPointMethods(paramList);
  }
  
  public List<FrameworkMethod> computeTestMethods()
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
  
  public void validateConstructor(List<Throwable> paramList)
  {
    validateOnlyOneConstructor(paramList);
  }
  
  public void validateTestMethods(List<Throwable> paramList)
  {
    Iterator localIterator = computeTestMethods().iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (FrameworkMethod)localIterator.next();
      if (((FrameworkMethod)localObject).getAnnotation(Theory.class) != null)
      {
        ((FrameworkMethod)localObject).validatePublicVoid(false, paramList);
        ((FrameworkMethod)localObject).validateNoTypeParametersOnArgs(paramList);
      }
      for (;;)
      {
        localObject = ParameterSignature.signatures(((FrameworkMethod)localObject).getMethod()).iterator();
        while (((Iterator)localObject).hasNext())
        {
          ParametersSuppliedBy localParametersSuppliedBy = (ParametersSuppliedBy)((ParameterSignature)((Iterator)localObject).next()).findDeepAnnotation(ParametersSuppliedBy.class);
          if (localParametersSuppliedBy != null) {
            validateParameterSupplier(localParametersSuppliedBy.value(), paramList);
          }
        }
        break;
        ((FrameworkMethod)localObject).validatePublicVoidNoArg(false, paramList);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.Theories
 * JD-Core Version:    0.7.0.1
 */