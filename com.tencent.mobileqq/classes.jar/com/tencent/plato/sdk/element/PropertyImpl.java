package com.tencent.plato.sdk.element;

import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.core.IFunction;
import com.tencent.plato.core.IReadableArray;
import com.tencent.plato.core.IReadableMap;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class PropertyImpl
  implements IProperty
{
  public static final String TAG = "PropertyImpl";
  private static volatile Map<Class<?>, Map<String, IProperty.IPropSetter>> sElementPropSetters = new HashMap();
  private final Class<?> mClazz = getClass();
  
  private static HashMap<String, IProperty.IPropSetter> findElementProps(Class<?> paramClass)
  {
    HashMap localHashMap = new HashMap();
    findElementProps(paramClass, localHashMap);
    return localHashMap;
  }
  
  private static void findElementProps(Class<?> paramClass, HashMap<String, IProperty.IPropSetter> paramHashMap)
  {
    if ((paramClass == null) || (paramClass == PropertyImpl.class) || (paramClass == Object.class)) {
      return;
    }
    findElementProps(paramClass.getSuperclass(), paramHashMap);
    Method[] arrayOfMethod = paramClass.getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    label37:
    Method localMethod;
    Object localObject;
    if (i < j)
    {
      localMethod = arrayOfMethod[i];
      localObject = (Property)localMethod.getAnnotation(Property.class);
      if (localObject != null) {
        break label72;
      }
    }
    for (;;)
    {
      i += 1;
      break label37;
      break;
      label72:
      localObject = ((Property)localObject).value();
      if (paramHashMap.containsKey(localObject)) {
        throw new IllegalStateException(paramClass.getName() + " method name already registered: " + (String)localObject);
      }
      paramHashMap.put(localObject, new IProperty.PropSetter(paramClass, (String)localObject, localMethod));
    }
  }
  
  private static Map<String, IProperty.IPropSetter> findExportedMethods(Class<?> paramClass)
  {
    return findElementProps(paramClass);
  }
  
  private IProperty.IPropSetter getPropSetter(String paramString)
  {
    return (IProperty.IPropSetter)((Map)sElementPropSetters.get(this.mClazz)).get(paramString);
  }
  
  public static void init(Class<?> paramClass)
  {
    if ((Map)sElementPropSetters.get(paramClass) == null)
    {
      Map localMap = findExportedMethods(paramClass);
      sElementPropSetters.put(paramClass, localMap);
    }
  }
  
  private void invokeSetProperty(IPlatoRuntime paramIPlatoRuntime, IProperty.IPropSetter paramIPropSetter, String paramString, IReadableMap paramIReadableMap)
  {
    Class[] arrayOfClass = paramIPropSetter.getParameterTypes();
    Object[] arrayOfObject = new Object[arrayOfClass.length];
    int i = 0;
    if (i < arrayOfClass.length)
    {
      Class localClass = arrayOfClass[i];
      if (IPlatoRuntime.class == localClass) {
        arrayOfObject[i] = paramIPlatoRuntime;
      }
      for (;;)
      {
        i += 1;
        break;
        if ((localClass == Boolean.class) || (localClass == Boolean.TYPE))
        {
          arrayOfObject[i] = Boolean.valueOf(paramIReadableMap.getBoolean(paramString, false));
        }
        else if ((localClass == Integer.class) || (localClass == Integer.TYPE))
        {
          arrayOfObject[i] = Integer.valueOf(paramIReadableMap.getInt(paramString, 0));
        }
        else if ((localClass == Double.class) || (localClass == Double.TYPE))
        {
          arrayOfObject[i] = Double.valueOf(paramIReadableMap.getDouble(paramString, 0.0D));
        }
        else if ((localClass == Long.class) || (localClass == Long.TYPE))
        {
          arrayOfObject[i] = Long.valueOf(paramIReadableMap.getLong(paramString, 0L));
        }
        else if ((localClass == Float.class) || (localClass == Float.TYPE))
        {
          arrayOfObject[i] = Float.valueOf(paramIReadableMap.getFloat(paramString, 0.0F));
        }
        else if (localClass == String.class)
        {
          arrayOfObject[i] = paramIReadableMap.getString(paramString, null);
        }
        else if (localClass == IReadableArray.class)
        {
          arrayOfObject[i] = paramIReadableMap.getReadableArray(paramString);
        }
        else if (localClass == IReadableMap.class)
        {
          arrayOfObject[i] = paramIReadableMap.getReadableMap(paramString);
        }
        else
        {
          if (localClass != IFunction.class) {
            break label324;
          }
          arrayOfObject[i] = paramIReadableMap.getFunction(paramString);
        }
      }
      label324:
      throw new RuntimeException(String.format(Locale.CHINESE, "unknown argument type:%s in class:%s[%s]", new Object[] { localClass.getSimpleName(), getClass().getName(), paramIPropSetter.getName() }));
    }
    paramIPropSetter.invoke(this, arrayOfObject);
  }
  
  public void setProperty(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    Iterator localIterator = paramIReadableMap.names().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if ("style".equals(str))
      {
        setStyle(paramIPlatoRuntime, paramIReadableMap.getReadableMap(str));
      }
      else
      {
        IProperty.IPropSetter localIPropSetter = getPropSetter(str);
        if (localIPropSetter != null) {
          invokeSetProperty(paramIPlatoRuntime, localIPropSetter, str, paramIReadableMap);
        }
      }
    }
  }
  
  public void setStyle(IPlatoRuntime paramIPlatoRuntime, IReadableMap paramIReadableMap)
  {
    Iterator localIterator = paramIReadableMap.names().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      IProperty.IPropSetter localIPropSetter = getPropSetter(str);
      if (localIPropSetter != null) {
        invokeSetProperty(paramIPlatoRuntime, localIPropSetter, str, paramIReadableMap);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.element.PropertyImpl
 * JD-Core Version:    0.7.0.1
 */