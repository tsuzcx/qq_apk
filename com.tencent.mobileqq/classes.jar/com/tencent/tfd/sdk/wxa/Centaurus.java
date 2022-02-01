package com.tencent.tfd.sdk.wxa;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Centaurus
{
  public static Centaurus ad = new Centaurus();
  public static Map<Integer, Integer> sd = new HashMap();
  public Map<Integer, Integer> td = new HashMap();
  public Map<Integer, Integer> ud = new HashMap();
  public Map<Integer, Integer> vd = new HashMap();
  public CanisMajor wd;
  
  static
  {
    Map localMap = sd;
    int i = volatile._d.value;
    Integer localInteger = Integer.valueOf(0);
    localMap.put(Integer.valueOf(i), localInteger);
    if (final.Rb == 105668) {
      sd.put(Integer.valueOf(volatile.Zd.value), localInteger);
    }
    if (final.Rb == 105928)
    {
      sd.put(Integer.valueOf(volatile.ne.value), localInteger);
      sd.put(Integer.valueOf(volatile.Zd.value), localInteger);
    }
    if (final.Rb == 108168)
    {
      sd.put(Integer.valueOf(volatile.ne.value), localInteger);
      sd.put(Integer.valueOf(volatile.Zd.value), localInteger);
      sd.put(Integer.valueOf(volatile.Qd.value), localInteger);
    }
    sd.put(Integer.valueOf(10001), localInteger);
    sd.put(Integer.valueOf(volatile.Yd.value), localInteger);
    sd.put(Integer.valueOf(volatile.te.value), localInteger);
  }
  
  public String N()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.td.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.td.get(localObject3)).intValue() == 0) {
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
  
  public String O(Context paramContext)
  {
    return Cassiopeia.ad.J(paramContext);
  }
  
  public void P(Context paramContext)
  {
    try
    {
      this.td.clear();
      Object localObject = sd.keySet().iterator();
      Integer localInteger;
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.td.putAll(sd);
      paramContext = Cassiopeia.ad.I(paramContext);
      localObject = paramContext.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.td.putAll(paramContext);
      paramContext = this.ud.keySet().iterator();
      int i;
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (h(i)) {
          this.td.put(Integer.valueOf(i), this.ud.get(Integer.valueOf(i)));
        }
      }
      paramContext = this.vd.keySet().iterator();
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (h(i)) {
          this.td.put(Integer.valueOf(i), this.vd.get(Integer.valueOf(i)));
        }
      }
      if (h(volatile.Yd.value))
      {
        this.td.put(Integer.valueOf(volatile.re.value), Integer.valueOf(0));
        this.td.put(Integer.valueOf(volatile.te.value), Integer.valueOf(0));
      }
      paramContext = this.td.keySet().iterator();
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
  
  public boolean a(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    try
    {
      long l = Cassiopeia.ad.L(paramContext);
      paramLong = Math.abs(System.currentTimeMillis() - paramLong);
      if (paramLong <= l * 1000L) {
        return false;
      }
      localObject = new byte[0];
      localHashMap = new HashMap();
      do.a(do.b(""), final.Rb, localHashMap, "1");
      localHashMap.put("101", paramString1);
      localHashMap.put("2002", Cassiopeia.ad.K(paramContext));
      localHashMap.put("207", paramString2);
    }
    finally
    {
      HashMap localHashMap;
      label130:
      int i;
      boolean bool;
      label435:
      label437:
      for (;;)
      {
        label219:
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
      break label130;
    }
    i = paramString1.length;
    bool = true;
    if (i != 0)
    {
      paramString1 = Ara.a(((synchronized)this.wd).this$0, paramContext, paramString1, 8119, 18119);
      if (paramString1.Oc != 0) {
        paramString1 = new byte[0];
      } else {
        paramString1 = paramString1.od;
      }
      if (paramInt != 1) {}
    }
    try
    {
      paramString1 = TNative.aa.f(void.k(), paramString1, paramInt);
      paramString1 = void.a(paramString1);
      break label219;
      if (paramInt != 0) {
        paramString1 = new byte[0];
      }
      paramString2 = new protected();
      paramString1 = new int(paramString1);
      paramString2.B = paramString1.a(paramString2.B, 0, true);
      paramString2.C = ((interface)paramString1.a(protected.A, 1, false));
      paramString2.D = paramString1.a(paramString2.D, 2, true);
      if (paramString2.B >= 0)
      {
        if (paramString2.B == 1)
        {
          paramString1 = new interface();
          break label437;
        }
        paramString2 = paramString2.C;
        if (paramString2 == null)
        {
          paramString1 = new interface();
          break label437;
        }
        paramString1 = paramString2.t.keySet().iterator();
        while (paramString1.hasNext()) {
          localObject = (Integer)paramString1.next();
        }
        localObject = paramString2.v;
        paramString1 = paramString2;
        if (localObject == null) {
          break label437;
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
      break label435;
    }
    paramString1 = null;
    if (paramString1 == null)
    {
      bool = false;
    }
    else
    {
      paramString2 = paramString1.t;
      localObject = Cassiopeia.ad;
      if ((paramString2 != null) && (paramString2.size() != 0)) {
        ((Cassiopeia)localObject).a(paramContext, paramString1);
      } else {
        ((Cassiopeia)localObject).H(paramContext);
      }
    }
    return bool;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.ud.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.vd.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public boolean h(int paramInt)
  {
    if (!this.td.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.td.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.Centaurus
 * JD-Core Version:    0.7.0.1
 */