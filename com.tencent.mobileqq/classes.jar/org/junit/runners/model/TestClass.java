package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.internal.MethodSorter;

public class TestClass
  implements Annotatable
{
  private static final TestClass.FieldComparator FIELD_COMPARATOR = new TestClass.FieldComparator(null);
  private static final TestClass.MethodComparator METHOD_COMPARATOR = new TestClass.MethodComparator(null);
  private final Class<?> clazz;
  private final Map<Class<? extends Annotation>, List<FrameworkField>> fieldsForAnnotations;
  private final Map<Class<? extends Annotation>, List<FrameworkMethod>> methodsForAnnotations;
  
  public TestClass(Class<?> paramClass)
  {
    this.clazz = paramClass;
    if ((paramClass != null) && (paramClass.getConstructors().length > 1)) {
      throw new IllegalArgumentException("Test class can only have one constructor");
    }
    paramClass = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    scanAnnotatedMembers(paramClass, localLinkedHashMap);
    this.methodsForAnnotations = makeDeeplyUnmodifiable(paramClass);
    this.fieldsForAnnotations = makeDeeplyUnmodifiable(localLinkedHashMap);
  }
  
  protected static <T extends FrameworkMember<T>> void addToAnnotationLists(T paramT, Map<Class<? extends Annotation>, List<T>> paramMap)
  {
    Annotation[] arrayOfAnnotation = paramT.getAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfAnnotation[i].annotationType();
      List localList = getAnnotatedMembers(paramMap, localClass, true);
      if (paramT.isShadowedBy(localList)) {
        return;
      }
      if (runsTopToBottom(localClass)) {
        localList.add(0, paramT);
      } else {
        localList.add(paramT);
      }
      i += 1;
    }
  }
  
  private <T> List<T> collectValues(Map<?, List<T>> paramMap)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      localLinkedHashSet.addAll((List)paramMap.next());
    }
    return new ArrayList(localLinkedHashSet);
  }
  
  private static <T> List<T> getAnnotatedMembers(Map<Class<? extends Annotation>, List<T>> paramMap, Class<? extends Annotation> paramClass, boolean paramBoolean)
  {
    if ((!paramMap.containsKey(paramClass)) && (paramBoolean)) {
      paramMap.put(paramClass, new ArrayList());
    }
    paramClass = (List)paramMap.get(paramClass);
    paramMap = paramClass;
    if (paramClass == null) {
      paramMap = Collections.emptyList();
    }
    return paramMap;
  }
  
  private static Field[] getSortedDeclaredFields(Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredFields();
    Arrays.sort(paramClass, FIELD_COMPARATOR);
    return paramClass;
  }
  
  private static List<Class<?>> getSuperClasses(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      localArrayList.add(paramClass);
      paramClass = paramClass.getSuperclass();
    }
    return localArrayList;
  }
  
  private static <T extends FrameworkMember<T>> Map<Class<? extends Annotation>, List<T>> makeDeeplyUnmodifiable(Map<Class<? extends Annotation>, List<T>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), Collections.unmodifiableList((List)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static boolean runsTopToBottom(Class<? extends Annotation> paramClass)
  {
    return (paramClass.equals(Before.class)) || (paramClass.equals(BeforeClass.class));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (TestClass)paramObject;
    return this.clazz == paramObject.clazz;
  }
  
  public <T> List<T> getAnnotatedFieldValues(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass = getAnnotatedFields(paramClass).iterator();
    while (paramClass.hasNext())
    {
      Object localObject = (FrameworkField)paramClass.next();
      try
      {
        localObject = ((FrameworkField)localObject).get(paramObject);
        if (paramClass1.isInstance(localObject)) {
          localArrayList.add(paramClass1.cast(localObject));
        }
      }
      catch (IllegalAccessException paramObject)
      {
        throw new RuntimeException("How did getFields return a field we couldn't access?", paramObject);
      }
    }
    return localArrayList;
  }
  
  public List<FrameworkField> getAnnotatedFields()
  {
    return collectValues(this.fieldsForAnnotations);
  }
  
  public List<FrameworkField> getAnnotatedFields(Class<? extends Annotation> paramClass)
  {
    return Collections.unmodifiableList(getAnnotatedMembers(this.fieldsForAnnotations, paramClass, false));
  }
  
  public <T> List<T> getAnnotatedMethodValues(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getAnnotatedMethods(paramClass).iterator();
    while (localIterator.hasNext())
    {
      paramClass = (FrameworkMethod)localIterator.next();
      try
      {
        if (paramClass1.isAssignableFrom(paramClass.getReturnType())) {
          localArrayList.add(paramClass1.cast(paramClass.invokeExplosively(paramObject, new Object[0])));
        }
      }
      catch (Throwable paramObject)
      {
        paramClass1 = new StringBuilder();
        paramClass1.append("Exception in ");
        paramClass1.append(paramClass.getName());
        throw new RuntimeException(paramClass1.toString(), paramObject);
      }
    }
    return localArrayList;
  }
  
  public List<FrameworkMethod> getAnnotatedMethods()
  {
    List localList = collectValues(this.methodsForAnnotations);
    Collections.sort(localList, METHOD_COMPARATOR);
    return localList;
  }
  
  public List<FrameworkMethod> getAnnotatedMethods(Class<? extends Annotation> paramClass)
  {
    return Collections.unmodifiableList(getAnnotatedMembers(this.methodsForAnnotations, paramClass, false));
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return null;
    }
    return localClass.getAnnotation(paramClass);
  }
  
  public Annotation[] getAnnotations()
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return new Annotation[0];
    }
    return localClass.getAnnotations();
  }
  
  public Class<?> getJavaClass()
  {
    return this.clazz;
  }
  
  public String getName()
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return "null";
    }
    return localClass.getName();
  }
  
  public Constructor<?> getOnlyConstructor()
  {
    Constructor[] arrayOfConstructor = this.clazz.getConstructors();
    Assert.assertEquals(1L, arrayOfConstructor.length);
    return arrayOfConstructor[0];
  }
  
  public int hashCode()
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return 0;
    }
    return localClass.hashCode();
  }
  
  public boolean isANonStaticInnerClass()
  {
    return (this.clazz.isMemberClass()) && (!Modifier.isStatic(this.clazz.getModifiers()));
  }
  
  public boolean isPublic()
  {
    return Modifier.isPublic(this.clazz.getModifiers());
  }
  
  protected void scanAnnotatedMembers(Map<Class<? extends Annotation>, List<FrameworkMethod>> paramMap, Map<Class<? extends Annotation>, List<FrameworkField>> paramMap1)
  {
    Iterator localIterator = getSuperClasses(this.clazz).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      Method[] arrayOfMethod = MethodSorter.getDeclaredMethods((Class)localObject);
      int k = arrayOfMethod.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        addToAnnotationLists(new FrameworkMethod(arrayOfMethod[i]), paramMap);
        i += 1;
      }
      localObject = getSortedDeclaredFields((Class)localObject);
      k = localObject.length;
      i = j;
      while (i < k)
      {
        addToAnnotationLists(new FrameworkField(localObject[i]), paramMap1);
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     org.junit.runners.model.TestClass
 * JD-Core Version:    0.7.0.1
 */