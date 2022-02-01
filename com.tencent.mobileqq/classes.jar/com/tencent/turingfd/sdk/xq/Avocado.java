package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Avocado
{
  public static Map<Integer, Integer> gh;
  public static Avocado zg = new Avocado();
  public Map<Integer, Integer> hh = new HashMap();
  public Map<Integer, Integer> ih = new HashMap();
  public Map<Integer, Integer> jh = new HashMap();
  public Apricot kh;
  
  static
  {
    gh = new HashMap();
    gh.put(Integer.valueOf(Auriga.ci.value), Integer.valueOf(0));
    if (final.jf == 105668) {
      gh.put(Integer.valueOf(Auriga.bi.value), Integer.valueOf(0));
    }
    gh.put(Integer.valueOf(10001), Integer.valueOf(0));
    gh.put(Integer.valueOf(Auriga.ai.value), Integer.valueOf(0));
    gh.put(Integer.valueOf(Auriga.wi.value), Integer.valueOf(0));
  }
  
  public String K(Context paramContext)
  {
    return Arbutus.zg.F(paramContext);
  }
  
  public String L()
  {
    Object localObject1 = new HashSet();
    Object localObject2 = this.hh.keySet().iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      if (((Integer)this.hh.get(localInteger)).intValue() == 0) {
        ((Set)localObject1).add(localInteger);
      }
    }
    localObject1 = ((Set)localObject1).iterator();
    localObject2 = new StringBuilder();
    while (((Iterator)localObject1).hasNext())
    {
      int i = ((Integer)((Iterator)localObject1).next()).intValue();
      ((StringBuilder)localObject2).append("" + i);
      if (((Iterator)localObject1).hasNext()) {
        ((StringBuilder)localObject2).append(",");
      }
    }
    return ((StringBuilder)localObject2).toString();
  }
  
  public void L(Context paramContext)
  {
    Object localObject;
    int i;
    try
    {
      this.hh.clear();
      localObject = gh.keySet().iterator();
      Integer localInteger;
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.hh.putAll(gh);
      paramContext = Arbutus.zg.E(paramContext);
      localObject = paramContext.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      this.hh.putAll(paramContext);
      paramContext = this.ih.keySet().iterator();
      while (paramContext.hasNext())
      {
        i = ((Integer)paramContext.next()).intValue();
        if (g(i)) {
          this.hh.put(Integer.valueOf(i), this.ih.get(Integer.valueOf(i)));
        }
      }
      paramContext = this.jh.keySet().iterator();
    }
    finally {}
    while (paramContext.hasNext())
    {
      i = ((Integer)paramContext.next()).intValue();
      if (g(i)) {
        this.hh.put(Integer.valueOf(i), this.jh.get(Integer.valueOf(i)));
      }
    }
    if (g(Auriga.ai.value))
    {
      this.hh.put(Integer.valueOf(Auriga.ui.value), Integer.valueOf(0));
      this.hh.put(Integer.valueOf(Auriga.wi.value), Integer.valueOf(0));
    }
    paramContext = this.hh.keySet().iterator();
    while (paramContext.hasNext()) {
      localObject = (Integer)paramContext.next();
    }
  }
  
  public boolean a(Context paramContext, int paramInt, String paramString1, long paramLong, String paramString2)
  {
    boolean bool;
    Object localObject;
    label481:
    label494:
    for (;;)
    {
      HashMap localHashMap;
      try
      {
        long l = Arbutus.zg.H(paramContext);
        paramLong = Math.abs(System.currentTimeMillis() - paramLong);
        if (paramLong <= l * 1000L)
        {
          bool = false;
          return bool;
        }
        localObject = new byte[0];
        localHashMap = new HashMap();
        do.a(do.a(""), final.jf, localHashMap, "1");
        localHashMap.put("101", paramString1);
        localHashMap.put("2002", Arbutus.zg.G(paramContext));
        localHashMap.put("207", paramString2);
      }
      finally {}
      try
      {
        paramString1 = TuringNative.aa.e(this.c(), paramContext, localHashMap, paramInt);
        if (this.b(paramString1) == 0) {
          continue;
        }
        paramString1 = (String)localObject;
      }
      catch (Throwable paramString1)
      {
        paramString1 = (String)localObject;
        continue;
        bool = true;
      }
      if (paramString1.length == 0)
      {
        break label481;
        paramString1 = this.a(paramString1);
      }
      else
      {
        paramString1 = UrsaMajor.a(((Solar)this.kh).this$0, paramContext, paramString1, 8119, 18119);
        if (paramString1.fg != 0)
        {
          paramString1 = new byte[0];
          if (paramInt != 1) {
            continue;
          }
        }
      }
      try
      {
        paramString1 = TuringNative.aa.f(this.c(), paramString1, paramInt);
        paramString1 = this.a(paramString1);
        paramString2 = new Caelum();
        paramString1 = new try(paramString1);
        paramString2.R = paramString1.a(paramString2.R, 0, true);
        paramString2.S = ((Bootes)paramString1.a(Caelum.Q, 1, false));
        paramString2.U = paramString1.a(paramString2.U, 2, true);
        paramInt = paramString2.R;
        if (paramInt >= 0) {
          continue;
        }
      }
      catch (Throwable paramString1)
      {
        continue;
      }
      paramString1 = null;
      if (paramString1 != null)
      {
        paramString2 = paramString1.I;
        localObject = Arbutus.zg;
        if ((paramString2 == null) || (paramString2.size() == 0))
        {
          ((Arbutus)localObject).D(paramContext);
          break label494;
          paramString1 = paramString1.K();
          continue;
          if (paramInt == 0) {
            continue;
          }
          paramString1 = new byte[0];
          continue;
          if (paramString2.R == 1)
          {
            paramString1 = new Bootes();
            continue;
          }
          paramString1 = paramString2.S;
          if (paramString1 == null)
          {
            paramString1 = new Bootes();
            continue;
          }
          paramString2 = paramString1.I.keySet().iterator();
          while (paramString2.hasNext()) {
            localObject = (Integer)paramString2.next();
          }
          paramString2 = paramString1.K;
          if (paramString2 != null) {
            paramString2 = paramString2.keySet().iterator();
          }
        }
        else
        {
          while (paramString2.hasNext())
          {
            localObject = (String)paramString2.next();
            continue;
            ((Arbutus)localObject).a(paramContext, paramString1);
            break label494;
          }
        }
        continue;
      }
      else
      {
        bool = false;
        continue;
      }
    }
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    this.ih.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public void c(int paramInt1, int paramInt2)
  {
    this.jh.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public boolean g(int paramInt)
  {
    if (!this.hh.containsKey(Integer.valueOf(paramInt))) {
      return true;
    }
    return ((Integer)this.hh.get(Integer.valueOf(paramInt))).intValue() != 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Avocado
 * JD-Core Version:    0.7.0.1
 */