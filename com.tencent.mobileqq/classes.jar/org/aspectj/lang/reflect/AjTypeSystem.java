package org.aspectj.lang.reflect;

import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import org.aspectj.internal.lang.reflect.AjTypeImpl;

public class AjTypeSystem
{
  private static Map<Class, WeakReference<AjType>> ajTypes = Collections.synchronizedMap(new WeakHashMap());
  
  public static <T> AjType<T> getAjType(Class<T> paramClass)
  {
    Object localObject = (WeakReference)ajTypes.get(paramClass);
    if (localObject != null)
    {
      localObject = (AjType)((WeakReference)localObject).get();
      if (localObject != null) {
        return localObject;
      }
      localObject = new AjTypeImpl(paramClass);
      ajTypes.put(paramClass, new WeakReference(localObject));
      return localObject;
    }
    localObject = new AjTypeImpl(paramClass);
    ajTypes.put(paramClass, new WeakReference(localObject));
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.aspectj.lang.reflect.AjTypeSystem
 * JD-Core Version:    0.7.0.1
 */