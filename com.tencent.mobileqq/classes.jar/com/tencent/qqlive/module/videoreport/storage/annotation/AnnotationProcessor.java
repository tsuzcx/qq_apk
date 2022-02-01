package com.tencent.qqlive.module.videoreport.storage.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;

public class AnnotationProcessor
{
  private static volatile AnnotationProcessor sInstance;
  private final ConcurrentHashMap<Class<?>, String> mClassIdMap = new ConcurrentHashMap();
  private final ConcurrentHashMap<Class<?>, Member> mObjectIdMap = new ConcurrentHashMap();
  
  public static AnnotationProcessor getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new AnnotationProcessor();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  private Member getObjectIdMember(Class<?> paramClass)
  {
    Field[] arrayOfField = paramClass.getDeclaredFields();
    int k = arrayOfField.length;
    int j = 0;
    int i = 0;
    while (i < k)
    {
      Field localField = arrayOfField[i];
      if ((localField.isAnnotationPresent(ObjectId.class)) && (localField.getType() == String.class)) {
        return new FieldMember(localField);
      }
      i += 1;
    }
    paramClass = paramClass.getMethods();
    k = paramClass.length;
    i = j;
    while (i < k)
    {
      arrayOfField = paramClass[i];
      if ((arrayOfField.isAnnotationPresent(ObjectId.class)) && (arrayOfField.getParameterTypes().length == 0) && (arrayOfField.getReturnType() == String.class)) {
        return new MethodMember(arrayOfField);
      }
      i += 1;
    }
    return null;
  }
  
  public String getClassId(Class<?> paramClass)
  {
    if (paramClass != null)
    {
      Object localObject1 = (String)this.mClassIdMap.get(paramClass);
      if (localObject1 != null) {
        return localObject1;
      }
      localObject1 = null;
      for (Object localObject2 = paramClass; localObject2 != null; localObject2 = ((Class)localObject2).getSuperclass())
      {
        localObject1 = (ClassId)((Class)localObject2).getAnnotation(ClassId.class);
        if (localObject1 != null) {
          break;
        }
      }
      if (localObject1 == null) {
        localObject1 = paramClass.getName();
      } else {
        localObject1 = ((ClassId)localObject1).value();
      }
      this.mClassIdMap.put(paramClass, localObject1);
      return localObject1;
    }
    paramClass = new IllegalArgumentException("Class cannot be null.");
    for (;;)
    {
      throw paramClass;
    }
  }
  
  public String getObjectId(Object paramObject)
  {
    Class localClass = paramObject.getClass();
    Member localMember = (Member)this.mObjectIdMap.get(localClass);
    if (localMember != null) {
      return (String)localMember.getValue(paramObject);
    }
    localMember = getObjectIdMember(localClass);
    if (localMember != null)
    {
      this.mObjectIdMap.put(localClass, localMember);
      return (String)localMember.getValue(paramObject);
    }
    throw new IllegalArgumentException("Object does not have an object id. Please specify an object id when invoking method. Otherwise you can add @ObjectId on the field or the non-arg method which provides the object id.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor
 * JD-Core Version:    0.7.0.1
 */