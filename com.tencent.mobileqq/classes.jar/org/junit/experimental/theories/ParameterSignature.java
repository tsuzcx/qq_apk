package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ParameterSignature
{
  private static final Map<Class<?>, Class<?>> CONVERTABLE_TYPES_MAP = ;
  private final Annotation[] annotations;
  private final Class<?> type;
  
  private ParameterSignature(Class<?> paramClass, Annotation[] paramArrayOfAnnotation)
  {
    this.type = paramClass;
    this.annotations = paramArrayOfAnnotation;
  }
  
  private static Map<Class<?>, Class<?>> buildConvertableTypesMap()
  {
    HashMap localHashMap = new HashMap();
    putSymmetrically(localHashMap, Boolean.TYPE, Boolean.class);
    putSymmetrically(localHashMap, Byte.TYPE, Byte.class);
    putSymmetrically(localHashMap, Short.TYPE, Short.class);
    putSymmetrically(localHashMap, Character.TYPE, Character.class);
    putSymmetrically(localHashMap, Integer.TYPE, Integer.class);
    putSymmetrically(localHashMap, Long.TYPE, Long.class);
    putSymmetrically(localHashMap, Float.TYPE, Float.class);
    putSymmetrically(localHashMap, Double.TYPE, Double.class);
    return Collections.unmodifiableMap(localHashMap);
  }
  
  private <T extends Annotation> T findDeepAnnotation(Annotation[] paramArrayOfAnnotation, Class<T> paramClass, int paramInt)
  {
    if (paramInt == 0) {}
    for (;;)
    {
      return null;
      int j = paramArrayOfAnnotation.length;
      int i = 0;
      while (i < j)
      {
        Annotation localAnnotation = paramArrayOfAnnotation[i];
        if (paramClass.isInstance(localAnnotation)) {
          return (Annotation)paramClass.cast(localAnnotation);
        }
        localAnnotation = findDeepAnnotation(localAnnotation.annotationType().getAnnotations(), paramClass, paramInt - 1);
        if (localAnnotation != null) {
          return (Annotation)paramClass.cast(localAnnotation);
        }
        i += 1;
      }
    }
  }
  
  private boolean isAssignableViaTypeConversion(Class<?> paramClass1, Class<?> paramClass2)
  {
    if (CONVERTABLE_TYPES_MAP.containsKey(paramClass2)) {
      return paramClass1.isAssignableFrom((Class)CONVERTABLE_TYPES_MAP.get(paramClass2));
    }
    return false;
  }
  
  private static <T> void putSymmetrically(Map<T, T> paramMap, T paramT1, T paramT2)
  {
    paramMap.put(paramT1, paramT2);
    paramMap.put(paramT2, paramT1);
  }
  
  public static ArrayList<ParameterSignature> signatures(Method paramMethod)
  {
    return signatures(paramMethod.getParameterTypes(), paramMethod.getParameterAnnotations());
  }
  
  private static ArrayList<ParameterSignature> signatures(Class<?>[] paramArrayOfClass, Annotation[][] paramArrayOfAnnotation)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfClass.length)
    {
      localArrayList.add(new ParameterSignature(paramArrayOfClass[i], paramArrayOfAnnotation[i]));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<ParameterSignature> signatures(Constructor<?> paramConstructor)
  {
    return signatures(paramConstructor.getParameterTypes(), paramConstructor.getParameterAnnotations());
  }
  
  public boolean canAcceptType(Class<?> paramClass)
  {
    return (this.type.isAssignableFrom(paramClass)) || (isAssignableViaTypeConversion(this.type, paramClass));
  }
  
  public boolean canAcceptValue(Object paramObject)
  {
    if (paramObject == null) {
      return !this.type.isPrimitive();
    }
    return canAcceptType(paramObject.getClass());
  }
  
  public boolean canPotentiallyAcceptType(Class<?> paramClass)
  {
    return (paramClass.isAssignableFrom(this.type)) || (isAssignableViaTypeConversion(paramClass, this.type)) || (canAcceptType(paramClass));
  }
  
  public <T extends Annotation> T findDeepAnnotation(Class<T> paramClass)
  {
    return findDeepAnnotation(this.annotations, paramClass, 3);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Iterator localIterator = getAnnotations().iterator();
    while (localIterator.hasNext())
    {
      Annotation localAnnotation = (Annotation)localIterator.next();
      if (paramClass.isInstance(localAnnotation)) {
        return (Annotation)paramClass.cast(localAnnotation);
      }
    }
    return null;
  }
  
  public List<Annotation> getAnnotations()
  {
    return Arrays.asList(this.annotations);
  }
  
  public Class<?> getType()
  {
    return this.type;
  }
  
  public boolean hasAnnotation(Class<? extends Annotation> paramClass)
  {
    return getAnnotation(paramClass) != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     org.junit.experimental.theories.ParameterSignature
 * JD-Core Version:    0.7.0.1
 */