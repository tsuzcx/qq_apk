package com.tencent.mobileqq.qroute.utils;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;
import java.util.concurrent.ConcurrentHashMap;

public class QRouteUtil
{
  private static final Object[] IMPL_CLASS_LOCK_ARRAY;
  private static final ConcurrentHashMap<Class<?>, QRouteUtil.QRouteApiAttribute> QROUTE_API_ATTRIBUTE_MAP = new ConcurrentHashMap(2048);
  
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
    Object localObject1 = (QRouteUtil.QRouteApiAttribute)QROUTE_API_ATTRIBUTE_MAP.get(paramClass);
    if ((localObject1 != null) && (QRouteUtil.QRouteApiAttribute.access$000((QRouteUtil.QRouteApiAttribute)localObject1) != null)) {
      return QRouteUtil.QRouteApiAttribute.access$000((QRouteUtil.QRouteApiAttribute)localObject1);
    }
    synchronized (IMPL_CLASS_LOCK_ARRAY[(paramClass.hashCode() % 10)])
    {
      QRouteUtil.QRouteApiAttribute localQRouteApiAttribute = (QRouteUtil.QRouteApiAttribute)QROUTE_API_ATTRIBUTE_MAP.get(paramClass);
      if ((localQRouteApiAttribute != null) && (QRouteUtil.QRouteApiAttribute.access$000(localQRouteApiAttribute) != null))
      {
        paramClass = QRouteUtil.QRouteApiAttribute.access$000(localQRouteApiAttribute);
        return paramClass;
      }
      localObject1 = localQRouteApiAttribute;
      if (localQRouteApiAttribute == null) {
        localObject1 = new QRouteUtil.QRouteApiAttribute(null);
      }
      QRouteUtil.QRouteApiAttribute.access$002((QRouteUtil.QRouteApiAttribute)localObject1, getImplNameInner(paramClass));
      QROUTE_API_ATTRIBUTE_MAP.put(paramClass, localObject1);
      return QRouteUtil.QRouteApiAttribute.access$000((QRouteUtil.QRouteApiAttribute)localObject1);
    }
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
    Object localObject1 = (QRouteUtil.QRouteApiAttribute)QROUTE_API_ATTRIBUTE_MAP.get(paramClass);
    if ((localObject1 != null) && (QRouteUtil.QRouteApiAttribute.access$200((QRouteUtil.QRouteApiAttribute)localObject1) != null)) {
      return QRouteUtil.QRouteApiAttribute.access$200((QRouteUtil.QRouteApiAttribute)localObject1).booleanValue();
    }
    for (;;)
    {
      synchronized (IMPL_CLASS_LOCK_ARRAY[(paramClass.hashCode() % 10)])
      {
        QRouteUtil.QRouteApiAttribute localQRouteApiAttribute = (QRouteUtil.QRouteApiAttribute)QROUTE_API_ATTRIBUTE_MAP.get(paramClass);
        if ((localQRouteApiAttribute != null) && (QRouteUtil.QRouteApiAttribute.access$200(localQRouteApiAttribute) != null))
        {
          bool = QRouteUtil.QRouteApiAttribute.access$200(localQRouteApiAttribute).booleanValue();
          return bool;
        }
        QRouteFactory localQRouteFactory = null;
        localObject1 = localQRouteApiAttribute;
        if (localQRouteApiAttribute == null) {
          localObject1 = new QRouteUtil.QRouteApiAttribute(null);
        }
        if (paramClass.isAnnotationPresent(QRouteFactory.class)) {
          localQRouteFactory = (QRouteFactory)paramClass.getAnnotation(QRouteFactory.class);
        }
        if (localQRouteFactory == null) {
          break label179;
        }
        if (localQRouteFactory.singleton())
        {
          break label179;
          QRouteUtil.QRouteApiAttribute.access$202((QRouteUtil.QRouteApiAttribute)localObject1, Boolean.valueOf(bool));
          QROUTE_API_ATTRIBUTE_MAP.put(paramClass, localObject1);
          return QRouteUtil.QRouteApiAttribute.access$200((QRouteUtil.QRouteApiAttribute)localObject1).booleanValue();
        }
      }
      boolean bool = false;
      continue;
      label179:
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qroute.utils.QRouteUtil
 * JD-Core Version:    0.7.0.1
 */