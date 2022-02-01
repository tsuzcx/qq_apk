package com.tencent.mtt.hippy.uimanager;

import android.view.View;
import com.tencent.mtt.hippy.annotation.HippyControllerProps;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.utils.ArgumentUtils;
import com.tencent.mtt.hippy.utils.LogUtils;
import com.tencent.mtt.hippy.views.custom.HippyCustomPropsController;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class c<T, G>
{
  static Map<Class, Map<String, c.a>> a = new HashMap();
  private T c;
  
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
  
  private void a(T paramT, G paramG, HippyMap paramHippyMap, String paramString)
  {
    if ((!b) && (!(paramG instanceof View))) {
      throw new AssertionError();
    }
    if ((!b) && (!(this.c instanceof HippyCustomPropsController))) {
      throw new AssertionError();
    }
    int j = 0;
    if (!(paramG instanceof View)) {
      return;
    }
    Object localObject2 = paramHippyMap.get(paramString);
    Object localObject1 = this.c;
    int i = j;
    if (localObject1 != null)
    {
      i = j;
      if ((localObject1 instanceof HippyCustomPropsController))
      {
        Class localClass = localObject1.getClass();
        Map localMap = (Map)a.get(localClass);
        localObject1 = localMap;
        if (localMap == null) {
          localObject1 = a(localClass);
        }
        localObject1 = (c.a)((Map)localObject1).get(paramString);
        i = j;
        if (localObject1 != null) {
          try
          {
            a(this.c, paramG, paramHippyMap, paramString, (c.a)localObject1);
            i = 1;
          }
          catch (Throwable paramHippyMap)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("customProps ");
            ((StringBuilder)localObject1).append(paramHippyMap.getMessage());
            LogUtils.e("ControllerUpdateManager", ((StringBuilder)localObject1).toString(), paramHippyMap);
            paramHippyMap.printStackTrace();
            i = j;
          }
        }
      }
    }
    if ((i == 0) && ((paramT instanceof HippyViewController))) {
      ((HippyViewController)paramT).setCustomProp((View)paramG, paramString, localObject2);
    }
  }
  
  private void a(T paramT, G paramG, HippyMap paramHippyMap, String paramString, c.a parama)
  {
    try
    {
      if (paramHippyMap.get(paramString) == null)
      {
        paramHippyMap = parama.b;
        int i = -1;
        int j = paramHippyMap.hashCode();
        if (j != -1034364087)
        {
          if (j != -891985903)
          {
            if ((j == 64711720) && (paramHippyMap.equals("boolean"))) {
              i = 0;
            }
          }
          else if (paramHippyMap.equals("string")) {
            i = 2;
          }
        }
        else if (paramHippyMap.equals("number")) {
          i = 1;
        }
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              parama.a.invoke(paramT, new Object[] { paramG, null });
              return;
            }
            parama.a.invoke(paramT, new Object[] { paramG, parama.c });
            return;
          }
          if (parama.f == null) {
            parama.f = parama.a.getGenericParameterTypes();
          }
          parama.a.invoke(paramT, new Object[] { paramG, ArgumentUtils.parseArgument(parama.f[1], Double.valueOf(parama.d)) });
          return;
        }
        parama.a.invoke(paramT, new Object[] { paramG, Boolean.valueOf(parama.e) });
        return;
      }
      Object localObject2 = paramHippyMap.get(paramString);
      Object localObject1 = localObject2;
      if ((localObject2 instanceof Number))
      {
        if (parama.f == null) {
          parama.f = parama.a.getGenericParameterTypes();
        }
        localObject1 = ArgumentUtils.parseArgument(parama.f[1], paramHippyMap, paramString);
      }
      parama.a.invoke(paramT, new Object[] { paramG, localObject1 });
      return;
    }
    catch (Throwable paramT)
    {
      LogUtils.e("ControllerUpdateManager", paramT.getMessage(), paramT);
      paramT.printStackTrace();
    }
  }
  
  public void a(T paramT)
  {
    if ((!b) && (paramT == null)) {
      throw new AssertionError();
    }
    this.c = paramT;
  }
  
  public void a(T paramT, G paramG, HippyMap paramHippyMap)
  {
    if ((!b) && (paramHippyMap == null)) {
      throw new AssertionError();
    }
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
      localObject3 = (String)((Iterator)localObject2).next();
      c.a locala = (c.a)((Map)localObject1).get(localObject3);
      if (locala != null) {
        a(paramT, paramG, paramHippyMap, (String)localObject3, locala);
      } else if ((((String)localObject3).equals("style")) && ((paramHippyMap.get((String)localObject3) instanceof HippyMap))) {
        a(paramT, paramG, (HippyMap)paramHippyMap.get((String)localObject3));
      } else {
        a(paramT, paramG, paramHippyMap, (String)localObject3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.uimanager.c
 * JD-Core Version:    0.7.0.1
 */