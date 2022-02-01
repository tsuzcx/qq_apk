package com.tencent.mobileqq.qroute.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.concurrent.ConcurrentHashMap;

public class QRouteUtil
{
  private static final Object[] IMPL_CLASS_LOCK_ARRAY;
  private static final ConcurrentHashMap<Class<?>, String> IMPL_CLASS_NAME_HASH_MAP = new ConcurrentHashMap(2048);
  
  static
  {
    IMPL_CLASS_LOCK_ARRAY = new Object[10];
    int i = 0;
    for (;;)
    {
      Object[] arrayOfObject = IMPL_CLASS_LOCK_ARRAY;
      if (i >= arrayOfObject.length) {
        break;
      }
      arrayOfObject[i] = new Object();
      i += 1;
    }
  }
  
  public static String convertApiToImplClass(Class<?> paramClass)
  {
    Object localObject1 = (String)IMPL_CLASS_NAME_HASH_MAP.get(paramClass);
    if (localObject1 == null) {
      synchronized (IMPL_CLASS_LOCK_ARRAY[(paramClass.hashCode() % 10)])
      {
        String str = (String)IMPL_CLASS_NAME_HASH_MAP.get(paramClass);
        localObject1 = str;
        if (str == null)
        {
          localObject1 = getImplNameInner(paramClass);
          IMPL_CLASS_NAME_HASH_MAP.put(paramClass, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  private static String getImplNameInner(Class<?> paramClass)
  {
    paramClass = new StringBuilder(paramClass.getName());
    paramClass.append("Impl");
    int i = paramClass.lastIndexOf(".");
    if (i > 0)
    {
      i += 1;
      paramClass.deleteCharAt(i);
      paramClass.insert(i, "impl.");
      return paramClass.toString();
    }
    return "";
  }
  
  public static <T extends QRouteApi> void isAnnotationQAPI(Class<T> paramClass)
  {
    if (paramClass.isAnnotationPresent(QAPI.class)) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QRouteApi should have QAPI Annotation, class=");
    localStringBuilder.append(paramClass.getName());
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public static <T extends QRouteApi> boolean isSingleton(Class<T> paramClass)
  {
    if (paramClass.isAnnotationPresent(QRouteFactory.class))
    {
      paramClass = (QRouteFactory)paramClass.getAnnotation(QRouteFactory.class);
      if (paramClass != null) {
        return paramClass.singleton();
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.utils.QRouteUtil
 * JD-Core Version:    0.7.0.1
 */