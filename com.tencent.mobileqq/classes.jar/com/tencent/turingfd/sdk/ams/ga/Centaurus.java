package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Centaurus
{
  public static Map<Integer, Integer> Gd;
  public static Centaurus rd = new Centaurus();
  public Map<Integer, Integer> Hd = new HashMap();
  public Map<Integer, Integer> Id = new HashMap();
  public Map<Integer, Integer> Jd = new HashMap();
  public CanisMajor Kd;
  
  static
  {
    Gd = new HashMap();
    Object localObject = Gd;
    Integer localInteger1 = Integer.valueOf(0);
    ((Map)localObject).put(Integer.valueOf(6), localInteger1);
    Gd.put(Integer.valueOf(19), localInteger1);
    Gd.put(Integer.valueOf(10001), localInteger1);
    Gd.put(Integer.valueOf(17), localInteger1);
    Gd.put(Integer.valueOf(43), localInteger1);
    Map localMap = Gd;
    localObject = Integer.valueOf(36);
    localMap.put(localObject, localInteger1);
    Gd.put(Integer.valueOf(45), localInteger1);
    localMap = Gd;
    Integer localInteger2 = Integer.valueOf(10002);
    localMap.put(localInteger2, localInteger1);
    Gd.put(Integer.valueOf(10003), localInteger1);
    int i = final.gc;
    if (i == 108098)
    {
      Gd.put(localInteger2, localInteger1);
      return;
    }
    if (i == 105668)
    {
      Gd.put(Integer.valueOf(18), localInteger1);
      return;
    }
    if (i == 105928)
    {
      Gd.put(localObject, localInteger1);
      Gd.put(Integer.valueOf(18), localInteger1);
      return;
    }
    if (i == 108168)
    {
      Gd.put(localObject, localInteger1);
      Gd.put(Integer.valueOf(18), localInteger1);
      Gd.put(Integer.valueOf(2), localInteger1);
      return;
    }
    if (i == 108388) {
      Gd.put(Integer.valueOf(40), localInteger1);
    }
  }
  
  public String Q()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.Hd.keySet().iterator();
    Object localObject3;
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.Hd.get(localObject3)).intValue() == 0) {
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
  
  public String T(Context paramContext)
  {
    return Cassiopeia.rd.O(paramContext);
  }
  
  public void U(Context paramContext)
  {
    try
    {
      this.Hd.clear();
      Object localObject = Gd.keySet().iterator();
      Integer localInteger;
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.Hd.putAll(Gd);
      paramContext = Cassiopeia.rd.N(paramContext);
      localObject = paramContext.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.Hd.putAll(paramContext);
      paramContext = this.Id.keySet().iterator();
      int i;
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (h(i)) {
          this.Hd.put(Integer.valueOf(i), this.Id.get(Integer.valueOf(i)));
        }
      }
      paramContext = this.Jd.keySet().iterator();
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (h(i)) {
          this.Hd.put(Integer.valueOf(i), this.Jd.get(Integer.valueOf(i)));
        }
      }
      if (h(17))
      {
        this.Hd.put(Integer.valueOf(40), Integer.valueOf(0));
        this.Hd.put(Integer.valueOf(43), Integer.valueOf(0));
      }
      paramContext = this.Hd.keySet().iterator();
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
      long l = Cassiopeia.rd.Q(paramContext);
      paramLong = Math.abs(System.currentTimeMillis() - paramLong);
      if (paramLong <= l * 1000L) {
        return false;
      }
      localObject = new byte[0];
      localHashMap = new HashMap();
      do.a(do.b(""), final.gc, localHashMap, "1");
      localHashMap.put("101", paramString1);
      localHashMap.put("2002", Cassiopeia.rd.P(paramContext));
      localHashMap.put("207", paramString2);
    }
    finally
    {
      HashMap localHashMap;
      label130:
      int i;
      boolean bool;
      label436:
      label438:
      for (;;)
      {
        label220:
        throw paramContext;
      }
    }
    try
    {
      paramString1 = TNative.aa.e(goto.l(), paramContext, localHashMap, paramInt);
      if (goto.b(paramString1) != 0) {
        paramString1 = (String)localObject;
      } else {
        paramString1 = goto.a(paramString1);
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
      paramString1 = Ara.a(((instanceof)this.Kd).this$0, paramContext, 4, paramString1, 8119, 18119);
      if (paramString1.cd != 0) {
        paramString1 = new byte[0];
      } else {
        paramString1 = paramString1.Cd;
      }
      if (paramInt != 1) {}
    }
    try
    {
      paramString1 = TNative.aa.f(goto.l(), paramString1, paramInt);
      paramString1 = goto.a(paramString1);
      break label220;
      if (paramInt != 0) {
        paramString1 = new byte[0];
      }
      paramString2 = new interface();
      paramString1 = new int(paramString1);
      paramString2.C = paramString1.a(paramString2.C, 0, true);
      paramString2.D = ((volatile)paramString1.a(interface.B, 1, false));
      paramString2.F = paramString1.a(paramString2.F, 2, true);
      if (paramString2.C >= 0)
      {
        if (paramString2.C == 1)
        {
          paramString1 = new volatile();
          break label438;
        }
        paramString2 = paramString2.D;
        if (paramString2 == null)
        {
          paramString1 = new volatile();
          break label438;
        }
        paramString1 = paramString2.u.keySet().iterator();
        while (paramString1.hasNext()) {
          localObject = (Integer)paramString1.next();
        }
        localObject = paramString2.A;
        paramString1 = paramString2;
        if (localObject == null) {
          break label438;
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
      break label436;
    }
    paramString1 = null;
    if (paramString1 == null)
    {
      bool = false;
    }
    else
    {
      paramString2 = paramString1.u;
      localObject = Cassiopeia.rd;
      if ((paramString2 != null) && (paramString2.size() != 0)) {
        ((Cassiopeia)localObject).a(paramContext, paramString1);
      } else {
        ((Cassiopeia)localObject).M(paramContext);
      }
    }
    return bool;
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.Id.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void d(int paramInt1, int paramInt2)
  {
    this.Jd.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public boolean h(int paramInt)
  {
    if (!this.Hd.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.Hd.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.Centaurus
 * JD-Core Version:    0.7.0.1
 */