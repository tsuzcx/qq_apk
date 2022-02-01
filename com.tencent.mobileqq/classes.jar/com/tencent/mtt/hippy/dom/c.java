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
    Object localObject3 = paramT.getClass();
    Object localObject2 = (Map)a.get(localObject3);
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = a((Class)localObject3);
    }
    localObject2 = paramHippyMap.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      String str = (String)((Iterator)localObject2).next();
      localObject3 = (c.a)((Map)localObject1).get(str);
      if (localObject3 != null) {
        try
        {
          if (paramHippyMap.get(str) == null)
          {
            str = ((c.a)localObject3).b;
            int i = -1;
            int j = str.hashCode();
            if (j != -1034364087)
            {
              if (j != -891985903)
              {
                if ((j == 64711720) && (str.equals("boolean"))) {
                  i = 0;
                }
              }
              else if (str.equals("string")) {
                i = 2;
              }
            }
            else if (str.equals("number")) {
              i = 1;
            }
            if (i != 0)
            {
              if (i != 1)
              {
                if (i != 2)
                {
                  ((c.a)localObject3).a.invoke(paramT, new Object[] { null });
                  continue;
                }
                ((c.a)localObject3).a.invoke(paramT, new Object[] { ((c.a)localObject3).c });
                continue;
              }
              ((c.a)localObject3).a.invoke(paramT, new Object[] { ArgumentUtils.parseArgument(localObject3.f[0], Double.valueOf(((c.a)localObject3).d)) });
              continue;
            }
            ((c.a)localObject3).a.invoke(paramT, new Object[] { Boolean.valueOf(((c.a)localObject3).e) });
            continue;
          }
          ((c.a)localObject3).a.invoke(paramT, new Object[] { ArgumentUtils.parseArgument(localObject3.f[0], paramHippyMap, str) });
        }
        catch (Throwable localThrowable)
        {
          LogUtils.e("ControllerUpdateManager", localThrowable.getMessage(), localThrowable);
          localThrowable.printStackTrace();
        }
      } else if (((paramHippyMap.get(str) instanceof HippyMap)) && (str.equals("style"))) {
        a(paramT, (HippyMap)paramHippyMap.get(str));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.dom.c
 * JD-Core Version:    0.7.0.1
 */