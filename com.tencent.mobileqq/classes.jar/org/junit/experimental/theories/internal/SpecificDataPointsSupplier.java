package org.junit.experimental.theories.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class SpecificDataPointsSupplier
  extends AllMembersSupplier
{
  public SpecificDataPointsSupplier(TestClass paramTestClass)
  {
    super(paramTestClass);
  }
  
  protected Collection<Field> getDataPointsFields(ParameterSignature paramParameterSignature)
  {
    Object localObject = super.getDataPointsFields(paramParameterSignature);
    paramParameterSignature = ((FromDataPoints)paramParameterSignature.getAnnotation(FromDataPoints.class)).value();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Field localField = (Field)((Iterator)localObject).next();
      if (Arrays.asList(((DataPoints)localField.getAnnotation(DataPoints.class)).value()).contains(paramParameterSignature)) {
        localArrayList.add(localField);
      }
    }
    return localArrayList;
  }
  
  protected Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature paramParameterSignature)
  {
    Object localObject = super.getDataPointsMethods(paramParameterSignature);
    paramParameterSignature = ((FromDataPoints)paramParameterSignature.getAnnotation(FromDataPoints.class)).value();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)((Iterator)localObject).next();
      if (Arrays.asList(((DataPoints)localFrameworkMethod.getAnnotation(DataPoints.class)).value()).contains(paramParameterSignature)) {
        localArrayList.add(localFrameworkMethod);
      }
    }
    return localArrayList;
  }
  
  protected Collection<Field> getSingleDataPointFields(ParameterSignature paramParameterSignature)
  {
    Object localObject = super.getSingleDataPointFields(paramParameterSignature);
    paramParameterSignature = ((FromDataPoints)paramParameterSignature.getAnnotation(FromDataPoints.class)).value();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Field localField = (Field)((Iterator)localObject).next();
      if (Arrays.asList(((DataPoint)localField.getAnnotation(DataPoint.class)).value()).contains(paramParameterSignature)) {
        localArrayList.add(localField);
      }
    }
    return localArrayList;
  }
  
  protected Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature paramParameterSignature)
  {
    Object localObject = super.getSingleDataPointMethods(paramParameterSignature);
    paramParameterSignature = ((FromDataPoints)paramParameterSignature.getAnnotation(FromDataPoints.class)).value();
    ArrayList localArrayList = new ArrayList();
    localObject = ((Collection)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)((Iterator)localObject).next();
      if (Arrays.asList(((DataPoint)localFrameworkMethod.getAnnotation(DataPoint.class)).value()).contains(paramParameterSignature)) {
        localArrayList.add(localFrameworkMethod);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.junit.experimental.theories.internal.SpecificDataPointsSupplier
 * JD-Core Version:    0.7.0.1
 */