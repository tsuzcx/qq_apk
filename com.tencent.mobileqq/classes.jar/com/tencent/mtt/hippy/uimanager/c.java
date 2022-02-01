package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c<T, G>
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
    if (paramClass != HippyViewController.class) {
      a(paramClass.getSuperclass(), paramMap);
    }
    Object localObject1 = (Map)a.get(paramClass);
    if (localObject1 == null)
    {
      localObject1 = paramClass.getMethods();
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
          paramMap.put(str, locala);
        }
        i += 1;
      }
      a.put(paramClass, new HashMap(paramMap));
      return;
    }
    paramMap.putAll((Map)localObject1);
  }
  
  public void a(T paramT, G paramG, HippyMap paramHippyMap)
  {
    if (paramHippyMap == null) {
      return;
    }
    Object localObject1 = paramT.getClass();
    Map localMap = (Map)a.get(localObject1);
    label39:
    label50:
    String str;
    c.a locala;
    if (localMap == null)
    {
      localMap = a((Class)localObject1);
      Iterator localIterator = paramHippyMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        str = (String)localIterator.next();
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
          break label368;
        }
        localObject1 = locala.b;
        i = -1;
        switch (((String)localObject1).hashCode())
        {
        case 64711720: 
          locala.a.invoke(paramT, new Object[] { paramG, null });
        }
      }
      catch (Throwable localThrowable1)
      {
        LogUtils.e("ControllerUpdateManager", localThrowable1.getMessage(), localThrowable1);
        localThrowable1.printStackTrace();
      }
      break label50;
      if (localThrowable1.equals("boolean"))
      {
        i = 0;
        break label573;
        if (localThrowable1.equals("number"))
        {
          i = 1;
          break label573;
          if (localThrowable1.equals("string"))
          {
            i = 2;
            break label573;
            locala.a.invoke(paramT, new Object[] { paramG, Boolean.valueOf(locala.e) });
            break label50;
            if (locala.f == null) {
              locala.f = locala.a.getGenericParameterTypes();
            }
            locala.a.invoke(paramT, new Object[] { paramG, ArgumentUtils.parseArgument(locala.f[1], Double.valueOf(locala.d)) });
            break label50;
            locala.a.invoke(paramT, new Object[] { paramG, locala.c });
            break label50;
            label368:
            Object localObject2 = paramHippyMap.get(str);
            if ((localObject2 instanceof Number))
            {
              if (locala.f == null) {
                locala.f = locala.a.getGenericParameterTypes();
              }
              localObject2 = ArgumentUtils.parseArgument(locala.f[1], paramHippyMap, str);
            }
            for (;;)
            {
              for (;;)
              {
                locala.a.invoke(paramT, new Object[] { paramG, localObject2 });
                break;
                if ((str.equals("style")) && ((paramHippyMap.get(str) instanceof HippyMap)))
                {
                  a(paramT, paramG, (HippyMap)paramHippyMap.get(str));
                  break;
                }
                try
                {
                  localObject2 = paramHippyMap.get(str);
                  if ((!(paramT instanceof HippyViewController)) || (!(paramG instanceof View))) {
                    break;
                  }
                  ((HippyViewController)paramT).setCustomProp((View)paramG, str, localObject2);
                }
                catch (Throwable localThrowable2)
                {
                  LogUtils.e("ControllerUpdateManager", "customProps " + localThrowable2.getMessage(), localThrowable2);
                  localThrowable2.printStackTrace();
                }
              }
              break label50;
              break;
            }
            break label39;
          }
        }
      }
      label573:
      switch (i)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.c
 * JD-Core Version:    0.7.0.1
 */