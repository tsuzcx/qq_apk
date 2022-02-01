package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class AllMembersSupplier
  extends ParameterSupplier
{
  private final TestClass clazz;
  
  public AllMembersSupplier(TestClass paramTestClass)
  {
    this.clazz = paramTestClass;
  }
  
  private void addArrayValues(ParameterSignature paramParameterSignature, String paramString, List<PotentialAssignment> paramList, Object paramObject)
  {
    int i = 0;
    while (i < Array.getLength(paramObject))
    {
      Object localObject = Array.get(paramObject, i);
      if (paramParameterSignature.canAcceptValue(localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        paramList.add(PotentialAssignment.forValue(localStringBuilder.toString(), localObject));
      }
      i += 1;
    }
  }
  
  private void addDataPointsValues(Class<?> paramClass, ParameterSignature paramParameterSignature, String paramString, List<PotentialAssignment> paramList, Object paramObject)
  {
    if (paramClass.isArray())
    {
      addArrayValues(paramParameterSignature, paramString, paramList, paramObject);
      return;
    }
    if (Iterable.class.isAssignableFrom(paramClass)) {
      addIterableValues(paramParameterSignature, paramString, paramList, (Iterable)paramObject);
    }
  }
  
  private void addIterableValues(ParameterSignature paramParameterSignature, String paramString, List<PotentialAssignment> paramList, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramParameterSignature.canAcceptValue(localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        paramList.add(PotentialAssignment.forValue(localStringBuilder.toString(), localObject));
      }
      i += 1;
    }
  }
  
  private void addMultiPointFields(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getDataPointsFields(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      addDataPointsValues(localField.getType(), paramParameterSignature, localField.getName(), paramList, getStaticFieldValue(localField));
    }
  }
  
  private void addMultiPointMethods(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getDataPointsMethods(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)localIterator.next();
      Class localClass = localFrameworkMethod.getReturnType();
      if (((localClass.isArray()) && (paramParameterSignature.canPotentiallyAcceptType(localClass.getComponentType()))) || (Iterable.class.isAssignableFrom(localClass))) {
        try
        {
          addDataPointsValues(localClass, paramParameterSignature, localFrameworkMethod.getName(), paramList, localFrameworkMethod.invokeExplosively(null, new Object[0]));
        }
        catch (Throwable paramParameterSignature)
        {
          paramList = (DataPoints)localFrameworkMethod.getAnnotation(DataPoints.class);
          if ((paramList != null) && (isAssignableToAnyOf(paramList.ignoredExceptions(), paramParameterSignature))) {
            return;
          }
          throw paramParameterSignature;
        }
      }
    }
  }
  
  private void addSinglePointFields(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getSingleDataPointFields(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      Object localObject = getStaticFieldValue(localField);
      if (paramParameterSignature.canAcceptValue(localObject)) {
        paramList.add(PotentialAssignment.forValue(localField.getName(), localObject));
      }
    }
  }
  
  private void addSinglePointMethods(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getSingleDataPointMethods(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)localIterator.next();
      if (paramParameterSignature.canAcceptType(localFrameworkMethod.getType())) {
        paramList.add(new AllMembersSupplier.MethodParameterValue(localFrameworkMethod, null));
      }
    }
  }
  
  private Object getStaticFieldValue(Field paramField)
  {
    try
    {
      paramField = paramField.get(null);
      return paramField;
    }
    catch (IllegalArgumentException paramField)
    {
      break label18;
    }
    catch (IllegalAccessException paramField)
    {
      label8:
      label18:
      break label8;
    }
    throw new RuntimeException("unexpected: getFields returned an inaccessible field");
    throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
  }
  
  private static boolean isAssignableToAnyOf(Class<?>[] paramArrayOfClass, Object paramObject)
  {
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfClass[i].isAssignableFrom(paramObject.getClass())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected Collection<Field> getDataPointsFields(ParameterSignature paramParameterSignature)
  {
    Object localObject = this.clazz.getAnnotatedFields(DataPoints.class);
    paramParameterSignature = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParameterSignature.add(((FrameworkField)((Iterator)localObject).next()).getField());
    }
    return paramParameterSignature;
  }
  
  protected Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature paramParameterSignature)
  {
    return this.clazz.getAnnotatedMethods(DataPoints.class);
  }
  
  protected Collection<Field> getSingleDataPointFields(ParameterSignature paramParameterSignature)
  {
    Object localObject = this.clazz.getAnnotatedFields(DataPoint.class);
    paramParameterSignature = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParameterSignature.add(((FrameworkField)((Iterator)localObject).next()).getField());
    }
    return paramParameterSignature;
  }
  
  protected Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature paramParameterSignature)
  {
    return this.clazz.getAnnotatedMethods(DataPoint.class);
  }
  
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
  {
    ArrayList localArrayList = new ArrayList();
    addSinglePointFields(paramParameterSignature, localArrayList);
    addMultiPointFields(paramParameterSignature, localArrayList);
    addSinglePointMethods(paramParameterSignature, localArrayList);
    addMultiPointMethods(paramParameterSignature, localArrayList);
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.junit.experimental.theories.internal.AllMembersSupplier
 * JD-Core Version:    0.7.0.1
 */