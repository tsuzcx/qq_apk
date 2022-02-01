package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseArray;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map<Ljava.lang.Integer;Lcom.tencent.turingfd.sdk.xq.instanceof;>;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Aquila
{
  public static Aquila Tg = new Aquila();
  public static int[] Ug = { 0, 5, 10, 30, 60, 120, 180, 240, 420, 660, 1080, 1800 };
  public static long Vg = TimeUnit.MINUTES.toMillis(5L);
  public Bootes Wg;
  public Handler Xg;
  public final byte[] Yg = new byte[0];
  public String Zg;
  public int _g;
  
  public Aquila()
  {
    StringBuilder localStringBuilder = do.b("IAS_57_");
    localStringBuilder.append(float.rf);
    localStringBuilder.append("_");
    localStringBuilder.append("xqFull");
    this.Zg = localStringBuilder.toString();
    this._g = 3;
  }
  
  public final Bootes U()
  {
    Bootes localBootes = this.Wg;
    Object localObject = localBootes;
    if (localBootes == null)
    {
      if (this.Xg == null)
      {
        localObject = new HandlerThread(this.Zg, -8);
        ((HandlerThread)localObject).start();
        this.Xg = new Handler(((HandlerThread)localObject).getLooper());
      }
      localObject = new Bootes(this.Xg);
    }
    return localObject;
  }
  
  public Aquila.do a(Map<Integer, instanceof> paramMap)
  {
    int i;
    label151:
    synchronized (this.Yg)
    {
      Context localContext = void.get();
      i = 0;
      Aquila.do localdo = null;
      boolean bool = false;
      try
      {
        if (i < this._g)
        {
          if (i != 0) {
            bool = true;
          }
          localdo = a(paramMap, localContext, bool);
          if ((localdo == null) || (localdo.a != 0L)) {
            if ((localdo == null) || (localdo.a <= -2000000L)) {
              break label151;
            }
          }
        }
        paramMap = localdo;
        if (localdo == null) {
          paramMap = Aquila.do.a(-10000000L, new HashMap());
        }
        return paramMap;
      }
      catch (Throwable paramMap)
      {
        Cascara.g(localContext, paramMap.toString());
        paramMap = Aquila.do.a(-6000000L, new HashMap());
        return paramMap;
      }
    }
  }
  
  public final Aquila.do a(Map<Integer, instanceof> paramMap, Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = U().B(paramContext);
    int i = ((continue)localObject1).size();
    Object localObject4 = "";
    int j;
    if (i != 0)
    {
      l1 = U().A(paramContext);
      if (l1 > 0L)
      {
        l2 = ((Long)((continue)localObject1).qg.getLast()).longValue();
        l2 = Math.abs(System.currentTimeMillis() - l2);
        localObject2 = Ug;
        if (l1 < localObject2.length) {
          i = (int)l1;
        } else {
          i = localObject2.length - 1;
        }
        if (i >= 1)
        {
          localObject2 = Ug;
          j = localObject2[(i - 1)];
          i = localObject2[i];
          if (j >= i) {
            break label2304;
          }
          i = new Random().nextInt(i - j + 1);
          if (l2 <= TimeUnit.SECONDS.toMillis(i + j))
          {
            i = 0;
            break label189;
          }
        }
      }
      i = 1;
      label189:
      if (i == 0)
      {
        if (!paramBoolean) {
          break label255;
        }
      }
      else
      {
        localObject2 = (Long)((continue)localObject1).qg.getFirst();
        if ((((continue)localObject1).size() >= ((continue)localObject1).limit) && (Math.abs(System.currentTimeMillis() - ((Long)localObject2).longValue()) < Vg)) {
          break label255;
        }
      }
    }
    i = 1;
    break label258;
    label255:
    i = 0;
    label258:
    if (i == 0)
    {
      paramMap = new implements.do(null);
      paramMap.zg = -5000000L;
      paramMap.Bg = 0L;
      paramMap.Ag = 0L;
      Cascara.g(paramContext, paramMap.build().L());
      return Aquila.do.a(-5000000L, new HashMap());
    }
    Object localObject2 = new implements.do(null).build();
    localObject1 = new HashMap();
    Caelum localCaelum = new Caelum(paramMap, (Map)localObject1);
    localCaelum.mContext = paramContext;
    paramMap = localCaelum.mContext;
    paramMap = localCaelum.eh;
    Object localObject7;
    Object localObject5;
    Object localObject6;
    if ((paramMap != null) && (paramMap.size() != 0))
    {
      l1 = System.currentTimeMillis();
      localObject7 = new Orion();
      j = Pegasus.Oi.value;
      localObject5 = new Phoenix();
      paramMap = new Arbutus();
      paramMap.Mc = 11;
      paramMap.Nc = 1;
      paramMap.Oc = 1;
      paramMap.Pc = 0;
      paramMap.Qc = 0;
      paramMap.F = null;
      paramMap.Rc = 0;
      paramMap.Wc = 1;
      localObject3 = new Virgo();
      ((Virgo)localObject3).ec = 1;
      paramMap.Yc = ((Virgo)localObject3);
      ((Phoenix)localObject5).db = paramMap;
      localObject6 = new Avocado();
    }
    try
    {
      ((Avocado)localObject6).Zc = private.h(Build.FINGERPRINT);
      ((Avocado)localObject6)._c = private.b(false);
      ((Avocado)localObject6).ad = private.h(Build.BRAND);
      ((Avocado)localObject6).bd = private.h(Build.MODEL);
      ((Avocado)localObject6).cd = Build.VERSION.SDK_INT;
      ((Avocado)localObject6).dd = private.h(Build.CPU_ABI);
    }
    catch (Exception paramMap)
    {
      label617:
      label620:
      break label703;
    }
    try
    {
      paramMap = Class.forName("android.os.SystemProperties");
      paramMap = paramMap.getMethod("get", new Class[] { String.class });
      paramMap.setAccessible(true);
      localObject3 = (String)paramMap.invoke(null, new Object[] { "ro.board.platform" });
      paramMap = (Map<Integer, instanceof>)localObject3;
      if (localObject3 != null) {
        break label620;
      }
    }
    catch (Throwable paramMap)
    {
      break label617;
    }
    paramMap = "";
    ((Avocado)localObject6).za = private.h(paramMap);
    if (Caelum.dh != -1) {
      new SparseArray();
    }
    try
    {
      localObject3 = (String)void.a(TNative.aa.d(void.k()), 201, String.class);
      paramMap = (Map<Integer, instanceof>)localObject3;
      if (localObject3 == null) {
        paramMap = "";
      }
      Caelum.dh = Integer.parseInt(paramMap);
    }
    catch (Throwable paramMap)
    {
      label685:
      label696:
      label703:
      Object localObject8;
      Object localObject9;
      Object localObject10;
      long l3;
      break label685;
    }
    i = -1;
    break label696;
    i = Caelum.dh;
    ((Avocado)localObject6).ed = i;
    ((Phoenix)localObject5).eb = ((Avocado)localObject6);
    ((Phoenix)localObject5).fb = j;
    ((Phoenix)localObject5).hb = "";
    ((Phoenix)localObject5).gb = ((Bilberry)const.o(void.get())).Eh;
    ((Orion)localObject7).Ia = ((Phoenix)localObject5);
    localObject8 = new ArrayList();
    paramMap = localCaelum.eh.keySet().iterator();
    while (paramMap.hasNext())
    {
      localObject3 = (Integer)paramMap.next();
      localObject9 = (instanceof)localCaelum.eh.get(localObject3);
      localObject10 = new Perseus();
      i = ((Integer)localObject3).intValue();
      if (localObject9 == null)
      {
        localObject3 = null;
      }
      else
      {
        localObject5 = new Apricot();
        ((Apricot)localObject5).jb = i;
        localObject6 = ((instanceof)localObject9).getFileMd5();
        localObject3 = localObject6;
        if (localObject6 == null) {
          localObject3 = "";
        }
        ((Apricot)localObject5).mb = void.e((String)localObject3);
        localObject6 = ((instanceof)localObject9).getPkgName();
        localObject3 = localObject6;
        if (localObject6 == null) {
          localObject3 = "";
        }
        ((Apricot)localObject5).kb = ((String)localObject3);
        localObject6 = ((instanceof)localObject9).N();
        localObject3 = localObject6;
        if (localObject6 == null) {
          localObject3 = "";
        }
        ((Apricot)localObject5).sc = void.e((String)localObject3);
        ((Apricot)localObject5).lb = ((instanceof)localObject9).S();
        ((Apricot)localObject5).wc = 0;
        ((Apricot)localObject5).xc = "";
        ((Apricot)localObject5).vb = 0;
        ((Apricot)localObject5).wb = 0;
        ((Apricot)localObject5).xb = 0;
        ((Apricot)localObject5).yc = null;
        ((Apricot)localObject5).zc = 0;
        ((Apricot)localObject5).Ac = false;
        ((Apricot)localObject5).Bc = 0;
        ((Apricot)localObject5).Cc = 0;
        localObject3 = localObject5;
      }
      ((Perseus)localObject10).Sa = ((Apricot)localObject3);
      localObject5 = ((instanceof)localObject9).getFileName();
      localObject3 = localObject5;
      if (localObject5 == null) {
        localObject3 = "";
      }
      ((Perseus)localObject10).Ta = ((String)localObject3);
      localObject5 = ((instanceof)localObject9).R();
      localObject3 = localObject5;
      if (localObject5 == null) {
        localObject3 = "";
      }
      ((Perseus)localObject10).Ua = ((String)localObject3);
      ((Perseus)localObject10).Wa = ((instanceof)localObject9).M();
      localObject5 = ((instanceof)localObject9).getFileSha1();
      localObject3 = localObject5;
      if (localObject5 == null) {
        localObject3 = "";
      }
      ((Perseus)localObject10).Xa = void.e((String)localObject3);
      ((Perseus)localObject10).Ya = ((instanceof)localObject9).O();
      localObject5 = ((instanceof)localObject9).T();
      localObject3 = localObject5;
      if (localObject5 == null) {
        localObject3 = "";
      }
      ((Perseus)localObject10).Za = ((String)localObject3);
      localObject5 = localCaelum.gh;
      if ((localObject5 != null) && (((String)localObject5).isEmpty()) && (!((String)localObject3).isEmpty())) {
        localCaelum.gh = ((String)localObject3);
      }
      ((Perseus)localObject10)._a = ((instanceof)localObject9).P();
      ((Perseus)localObject10).ab = ((instanceof)localObject9).Q();
      ((List)localObject8).add(localObject10);
    }
    ((Orion)localObject7).Ja = ((List)localObject8);
    paramMap = new byte();
    paramMap.c(Caelum.DEFAULT_CHARSET);
    Object localObject3 = ((Orion)localObject7).Ia;
    if (localObject3 != null) {
      paramMap.a((case)localObject3, 0);
    }
    localObject3 = ((Orion)localObject7).Ja;
    if (localObject3 != null) {
      paramMap.a((Collection)localObject3, 1);
    }
    localObject3 = ((Orion)localObject7).Ka;
    if (localObject3 != null) {
      paramMap.a((Collection)localObject3, 2);
    }
    localObject3 = ((Orion)localObject7).La;
    if (localObject3 != null) {
      paramMap.a((Collection)localObject3, 3);
    }
    paramMap = paramMap.toByteArray();
    long l2 = System.currentTimeMillis();
    l3 = paramMap.length;
    ((implements)localObject2).Bg = (l2 - l1);
    ((implements)localObject2).Ag = l3;
    break label1360;
    paramMap = null;
    label1360:
    if (paramMap == null)
    {
      l1 = localCaelum.b(-1100000L);
      paramMap = (Map<Integer, instanceof>)localObject2;
    }
    for (;;)
    {
      for (;;)
      {
        break label2173;
        paramMap = Lemon.a.a(1, paramMap, localCaelum.gh);
        l1 = paramMap.a;
        if (l1 != 0L) {
          break label2154;
        }
        localObject3 = paramMap.b;
        if ((localObject3 == null) || (localObject3.length == 0)) {
          break label2138;
        }
        try
        {
          paramMap = new Taurus();
          localObject3 = new try((byte[])localObject3);
          ((try)localObject3).c(Caelum.DEFAULT_CHARSET);
          paramMap.a((try)localObject3);
          l1 = paramMap.ba;
          if (l1 != 0L)
          {
            l1 = localCaelum.b(l1 - 3200000L);
            break;
          }
          paramMap = paramMap.Gb;
          if (paramMap == null)
          {
            l1 = localCaelum.b(-4000000L);
            break;
          }
          if (paramMap.ba != 0L)
          {
            l1 = localCaelum.b(l1 - 4100000L);
            break;
          }
          paramMap = paramMap.Ja;
          if ((paramMap != null) && (paramMap.size() != 0))
          {
            localObject3 = paramMap.iterator();
            paramMap = (Map<Integer, instanceof>)localObject4;
            localObject4 = localObject3;
            while (((Iterator)localObject4).hasNext())
            {
              localObject10 = (Scorpius)((Iterator)localObject4).next();
              localObject5 = ((Scorpius)localObject10).tb;
              localObject3 = localObject5;
              if (localObject5 == null) {
                localObject3 = paramMap;
              }
              Object localObject11 = ((Scorpius)localObject10).qb;
              if (localObject11 != null)
              {
                k = ((Bagasse)localObject11).ub;
                if (localCaelum.eh.containsKey(Integer.valueOf(k)))
                {
                  localObject9 = (instanceof)localCaelum.eh.get(Integer.valueOf(k));
                  localObject5 = ((instanceof)localObject9).getFileName();
                  localObject6 = localObject5;
                  if (localObject5 == null) {
                    localObject6 = paramMap;
                  }
                  localObject7 = ((instanceof)localObject9).getFileSha1();
                  localObject5 = localObject7;
                  if (localObject7 == null) {
                    localObject5 = paramMap;
                  }
                  localObject8 = ((instanceof)localObject9).getPkgName();
                  localObject7 = localObject8;
                  if (localObject8 == null) {
                    localObject7 = paramMap;
                  }
                  localObject9 = ((instanceof)localObject9).getFileMd5();
                  localObject8 = localObject9;
                  if (localObject9 == null) {
                    localObject8 = paramMap;
                  }
                  i = ((Bagasse)localObject11).vb;
                  j = ((Bagasse)localObject11).xb;
                  if (((String)localObject3).isEmpty()) {
                    if ((i >= 1) && (i <= 3)) {
                      localObject3 = "文件存在风险，谨慎安装，查看详情。";
                    } else if ((i == 0) || (i == 4)) {
                      localObject3 = "此为可执行文件，安装可能有安全风险，请谨慎操作。";
                    }
                  }
                  localObject9 = localObject8;
                  localObject8 = localObject6;
                  localObject6 = localObject7;
                  paramBoolean = true;
                  localObject7 = localObject3;
                  localObject3 = localObject5;
                  l1 = 0L;
                  localObject5 = localObject9;
                  break label1885;
                }
              }
              localObject5 = paramMap;
              localObject6 = localObject5;
              localObject7 = localObject6;
              paramBoolean = false;
              i = -1;
              j = -1;
              l1 = -10000000L;
              int k = -1;
              localObject9 = localObject3;
              localObject3 = localObject7;
              localObject8 = localObject7;
              localObject7 = localObject9;
              label1885:
              if (k != -1)
              {
                localObject11 = localCaelum.fh;
                Andromeda.do localdo = new Andromeda.do(paramBoolean, l1, null);
                localdo.jdField_a_of_type_JavaLangString = ((String)localObject6);
                localdo.jdField_a_of_type_Int = i;
                localdo.jdField_b_of_type_Int = j;
                localObject9 = ((Scorpius)localObject10).rb;
                localObject6 = localObject9;
                if (localObject9 == null) {
                  localObject6 = paramMap;
                }
                localdo.jdField_b_of_type_JavaLangString = ((String)localObject6);
                localdo.c = ((String)localObject3);
                localdo.d = ((String)localObject5);
                localdo.e = ((String)localObject8);
                localdo.f = ((String)localObject7);
                ((Map)localObject11).put(Integer.valueOf(k), localdo.a());
              }
            }
            paramMap = (Map<Integer, instanceof>)localObject2;
            localObject2 = localCaelum.eh.keySet().iterator();
            l1 = -4200000L;
            while (((Iterator)localObject2).hasNext())
            {
              localObject3 = (Integer)((Iterator)localObject2).next();
              if (!localCaelum.fh.containsKey(localObject3)) {
                localCaelum.fh.put(localObject3, Andromeda.a(-4200000L).a());
              } else {
                l1 = 0L;
              }
            }
          }
          else
          {
            paramMap = (Map<Integer, instanceof>)localObject2;
            l1 = localCaelum.b(-4200000L);
          }
        }
        catch (Throwable paramMap)
        {
          label2122:
          label2138:
          label2154:
          break label2122;
        }
      }
      paramMap = (Map<Integer, instanceof>)localObject2;
      l1 = localCaelum.b(-3100000L);
      continue;
      paramMap = (Map<Integer, instanceof>)localObject2;
      l1 = localCaelum.b(-3000000L);
      continue;
      paramMap = (Map<Integer, instanceof>)localObject2;
      l1 = localCaelum.b(l1 - 2000000L);
    }
    label2173:
    if (l1 != 0L)
    {
      localObject3 = U();
      localObject2 = paramContext;
      localObject3 = ((Bootes)localObject3).B((Context)localObject2);
      ((continue)localObject3).offer(Long.valueOf(System.currentTimeMillis()));
      U().a((Context)localObject2, (continue)localObject3);
    }
    localObject1 = Aquila.do.a(l1, (Map)localObject1);
    long l1 = ((Aquila.do)localObject1).a;
    paramMap.zg = l1;
    Cascara.g(paramContext, paramMap.L());
    l2 = U().A(paramContext);
    if (l1 < 0L)
    {
      U().a(paramContext, l2 + 1L);
      return localObject1;
    }
    if (l2 != 0L) {
      U().a(paramContext, 0L);
    }
    return localObject1;
    label2304:
    paramMap = new IllegalArgumentException("");
    for (;;)
    {
      throw paramMap;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.Aquila
 * JD-Core Version:    0.7.0.1
 */