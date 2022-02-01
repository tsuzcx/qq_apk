package com.tencent.mtt.hippy.dom;

import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.dom.node.StyleNode;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c<T>
{
  static Map<Class, Map<String, c.a>> a = new HashMap();
  
  private Map<String, c.a> a(Class paramClass)
  {
    HashMap localHashMap = new HashMap();
    a(paramClass, localHashMap);
    return localHashMap;
  }
  
  private void a(Class paramClass, Map<String, c.a> paramMap)
  {
    if (paramClass != StyleNode.class) {
      a(paramClass.getSuperclass(), paramMap);
    }
    Object localObject1 = (Map)a.get(paramClass);
    if (localObject1 == null)
    {
      localObject1 = paramClass.getDeclaredMethods();
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        Object localObject2 = localObject1[i];
        HippyControllerProps localHippyControllerProps = (HippyControllerProps)localObject2.getAnnotation(HippyControllerProps.class);
        if (localHippyControllerProps != null)
        {
          String str = localHippyControllerProps.name();
          c.a locala = new c.a();
          locala.d = localHippyControllerProps.defaultNumber();
          locala.b = localHippyControllerProps.defaultType();
          locala.c = localHippyControllerProps.defaultString();
          locala.e = localHippyControllerProps.defaultBoolean();
          locala.a = localObject2;
          locala.f = localObject2.getGenericParameterTypes();
          paramMap.put(str, locala);
        }
        i += 1;
      }
      a.put(paramClass, new HashMap(paramMap));
      return;
    }
    paramMap.putAll((Map)localObject1);
  }
  
  public void a(T paramT, HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    Object localObject = paramT.getClass();
    Map localMap = (Map)a.get(localObject);
    label39:
    label50:
    String str;
    c.a locala;
    if (localMap == null)
    {
      localMap = a((Class)localObject);
      localObject = paramHippyMap.keySet().iterator();
      if (((Iterator)localObject).hasNext())
      {
        str = (String)((Iterator)localObject).next();
        locala = (c.a)localMap.get(str);
        if (locala == null) {}
      }
    }
    for (;;)
    {
      int i;
      try
      {
        if (paramHippyMap.get(str) != null) {
          break label328;
        }
        str = locala.b;
        i = -1;
        switch (str.hashCode())
        {
        case 64711720: 
          locala.a.invoke(paramT, new Object[] { null });
        }
      }
      catch (Throwable localThrowable)
      {
        LogUtils.e("ControllerUpdateManager", localThrowable.getMessage(), localThrowable);
        localThrowable.printStackTrace();
      }
      break label50;
      if (str.equals("boolean"))
      {
        i = 0;
        break label403;
        if (str.equals("number"))
        {
          i = 1;
          break label403;
          if (str.equals("string"))
          {
            i = 2;
            break label403;
            localThrowable.a.invoke(paramT, new Object[] { Boolean.valueOf(localThrowable.e) });
            break label50;
            localThrowable.a.invoke(paramT, new Object[] { ArgumentUtils.parseArgument(localThrowable.f[0], Double.valueOf(localThrowable.d)) });
            break label50;
            localThrowable.a.invoke(paramT, new Object[] { localThrowable.c });
            break label50;
            label328:
            localThrowable.a.invoke(paramT, new Object[] { ArgumentUtils.parseArgument(localThrowable.f[0], paramHippyMap, str) });
            break label50;
            if ((!(paramHippyMap.get(str) instanceof HippyMap)) || (!str.equals("style"))) {
              break label50;
            }
            a(paramT, (HippyMap)paramHippyMap.get(str));
            break label50;
            break;
            break label39;
          }
        }
      }
      label403:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.c
 * JD-Core Version:    0.7.0.1
 */