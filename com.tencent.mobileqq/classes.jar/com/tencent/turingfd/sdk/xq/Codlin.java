package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Codlin
{
  public static Codlin Tg = new Codlin();
  public static Map<Integer, Integer> _h = new HashMap();
  public Map<Integer, Integer> ai = new HashMap();
  public Map<Integer, Integer> bi = new HashMap();
  public Map<Integer, Integer> ci = new HashMap();
  public Chestnut di;
  
  static
  {
    Object localObject = _h;
    Integer localInteger1 = Integer.valueOf(0);
    ((Map)localObject).put(Integer.valueOf(6), localInteger1);
    _h.put(Integer.valueOf(19), localInteger1);
    _h.put(Integer.valueOf(10001), localInteger1);
    _h.put(Integer.valueOf(17), localInteger1);
    _h.put(Integer.valueOf(43), localInteger1);
    Map localMap = _h;
    localObject = Integer.valueOf(36);
    localMap.put(localObject, localInteger1);
    localMap = _h;
    Integer localInteger2 = Integer.valueOf(10002);
    localMap.put(localInteger2, localInteger1);
    _h.put(Integer.valueOf(10003), localInteger1);
    int i = float.rf;
    if (i == 108098)
    {
      _h.put(localInteger2, localInteger1);
      return;
    }
    if (i == 105668)
    {
      _h.put(Integer.valueOf(18), localInteger1);
      return;
    }
    if (i == 105928)
    {
      _h.put(localObject, localInteger1);
      _h.put(Integer.valueOf(18), localInteger1);
      return;
    }
    if (i == 108168)
    {
      _h.put(localObject, localInteger1);
      _h.put(Integer.valueOf(18), localInteger1);
      _h.put(Integer.valueOf(2), localInteger1);
    }
  }
  
  public String Y()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.ai.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.ai.get(localObject3)).intValue() == 0) {
        ((Set)localObject1).add(localObject3);
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    localObject2 = new StringBuilder();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject2).append(((StringBuilder)localObject3).toString());
      if (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(",");
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    try
    {
      long l = Coconut.Tg.Z(paramContext);
      paramLong = Math.abs(System.currentTimeMillis() - paramLong);
      if (paramLong <= l * 1000L) {
        return false;
      }
      localObject = new byte[0];
      localHashMap = new HashMap();
      StringBuilder localStringBuilder = do.b("");
      localStringBuilder.append(float.rf);
      localHashMap.put("1", localStringBuilder.toString());
      localHashMap.put("101", paramString1);
      localHashMap.put("2002", Coconut.Tg.Y(paramContext));
      localHashMap.put("207", paramString2);
    }
    finally
    {
      HashMap localHashMap;
      label144:
      int i;
      boolean bool;
      label450:
      label452:
      for (;;)
      {
        label234:
        throw paramContext;
      }
    }
    try
    {
      paramString1 = TNative.aa.e(void.k(), paramContext, localHashMap, paramInt);
      if (void.b(paramString1) != 0) {
        paramString1 = (String)localObject;
      } else {
        paramString1 = void.a(paramString1);
      }
    }
    catch (Throwable paramString1)
    {
      paramString1 = (String)localObject;
      break label144;
    }
    i = paramString1.length;
    bool = true;
    if (i != 0)
    {
      paramString1 = Bullace.a(((Blackberry)this.di).this$0, paramContext, 4, paramString1, 8119, 18119);
      if (paramString1.zg != 0) {
        paramString1 = new byte[0];
      } else {
        paramString1 = paramString1.X();
      }
      if (paramInt != 1) {}
    }
    try
    {
      paramString1 = TNative.aa.f(void.k(), paramString1, paramInt);
      paramString1 = void.a(paramString1);
      break label234;
      if (paramInt != 0) {
        paramString1 = new byte[0];
      }
      paramString2 = new LeoMinor();
      paramString1 = new try(paramString1);
      paramString2.ba = paramString1.a(paramString2.ba, 0, true);
      paramString2.ca = ((Lacerta)paramString1.a(LeoMinor.aa, 1, false));
      paramString2.da = paramString1.a(paramString2.da, 2, true);
      if (paramString2.ba >= 0)
      {
        if (paramString2.ba == 1)
        {
          paramString1 = new Lacerta();
          break label452;
        }
        paramString2 = paramString2.ca;
        if (paramString2 == null)
        {
          paramString1 = new Lacerta();
          break label452;
        }
        paramString1 = paramString2.S.keySet().iterator();
        while (paramString1.hasNext()) {
          localObject = (Integer)paramString1.next();
        }
        localObject = paramString2.W;
        paramString1 = paramString2;
        if (localObject == null) {
          break label452;
        }
        localObject = ((Map)localObject).keySet().iterator();
        for (;;)
        {
          paramString1 = paramString2;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          paramString1 = (String)((Iterator)localObject).next();
        }
      }
    }
    catch (Throwable paramString1)
    {
      break label450;
    }
    paramString1 = null;
    if (paramString1 == null)
    {
      bool = false;
    }
    else
    {
      paramString2 = paramString1.S;
      localObject = Coconut.Tg;
      if ((paramString2 != null) && (paramString2.size() != 0)) {
        ((Coconut)localObject).a(paramContext, paramString1);
      } else {
        ((Coconut)localObject).V(paramContext);
      }
    }
    return bool;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.bi.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public String ca(Context paramContext)
  {
    return Coconut.Tg.X(paramContext);
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.ci.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void da(Context paramContext)
  {
    try
    {
      this.ai.clear();
      Object localObject = _h.keySet().iterator();
      Integer localInteger;
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.ai.putAll(_h);
      paramContext = Coconut.Tg.W(paramContext);
      localObject = paramContext.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.ai.putAll(paramContext);
      paramContext = this.bi.keySet().iterator();
      int i;
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (h(i)) {
          this.ai.put(Integer.valueOf(i), this.bi.get(Integer.valueOf(i)));
        }
      }
      paramContext = this.ci.keySet().iterator();
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (h(i)) {
          this.ai.put(Integer.valueOf(i), this.ci.get(Integer.valueOf(i)));
        }
      }
      if (h(17))
      {
        this.ai.put(Integer.valueOf(40), Integer.valueOf(0));
        this.ai.put(Integer.valueOf(43), Integer.valueOf(0));
      }
      paramContext = this.ai.keySet().iterator();
      while (paramContext.hasNext()) {
        localObject = (Integer)paramContext.next();
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramContext;
    }
  }
  
  public boolean h(int paramInt)
  {
    if (!this.ai.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.ai.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Codlin
 * JD-Core Version:    0.7.0.1
 */