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
import java.util.Map<Ljava.lang.Integer;Lcom.tencent.turingfd.sdk.xq.interface;>;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class implements
{
  public static int[] Ag = { 0, 5, 10, 30, 60, 120, 180, 240, 420, 660, 1080, 1800 };
  public static long Bg = TimeUnit.MINUTES.toMillis(5L);
  public static implements zg = new implements();
  public Andromeda Cg;
  public Handler Dg;
  public final byte[] Eg = new byte[0];
  public String Fg = final.jf + "_" + "xqFull";
  public int Gg = 3;
  
  public final Andromeda H()
  {
    Andromeda localAndromeda = this.Cg;
    Object localObject = localAndromeda;
    if (localAndromeda == null)
    {
      if (this.Dg == null)
      {
        localObject = new HandlerThread(this.Fg, -8);
        ((HandlerThread)localObject).start();
        this.Dg = new Handler(((HandlerThread)localObject).getLooper());
      }
      localObject = new Andromeda(this.Dg);
    }
    return localObject;
  }
  
  public implements.do a(Map<Integer, interface> paramMap)
  {
    synchronized (this.Eg)
    {
      Context localContext = this.get();
      int i = 0;
      Object localObject = null;
      boolean bool = false;
      try
      {
        for (;;)
        {
          implements.do localdo;
          if (i < this.Gg)
          {
            if (i != 0) {
              bool = true;
            }
            localdo = a(paramMap, localContext, bool);
            if ((localdo == null) || (localdo.R != 0L)) {
              break label91;
            }
            localObject = localdo;
          }
          label91:
          long l;
          do
          {
            paramMap = localObject;
            if (localObject == null) {
              paramMap = implements.do.a(-10000000L, new HashMap());
            }
            return paramMap;
            if (localdo == null) {
              break;
            }
            l = localdo.R;
            localObject = localdo;
          } while (l > -2000000L);
          i += 1;
          localObject = localdo;
        }
        paramMap = finally;
      }
      catch (Throwable paramMap)
      {
        Almond.e(localContext, paramMap.toString());
        paramMap = implements.do.a(-6000000L, new HashMap());
        return paramMap;
      }
    }
  }
  
  public final implements.do a(Map<Integer, interface> paramMap, Context paramContext, boolean paramBoolean)
  {
    Object localObject1 = H().o(paramContext);
    int i;
    if (((finally)localObject1).size() == 0)
    {
      i = 1;
      label21:
      if (i != 0) {
        break label296;
      }
      paramMap = new volatile.do(null);
      paramMap.fg = -5000000L;
      paramMap.hg = 0L;
      paramMap.gg = 0L;
      Almond.e(paramContext, paramMap.build().y());
      paramMap = implements.do.a(-5000000L, new HashMap());
    }
    label96:
    label99:
    long l2;
    label246:
    label248:
    label1405:
    do
    {
      return paramMap;
      long l1 = H().n(paramContext);
      if (l1 <= 0L)
      {
        i = 1;
        if (i != 0) {
          break label248;
        }
        if (paramBoolean) {
          break;
        }
      }
      Object localObject2;
      int j;
      do
      {
        i = 0;
        break label21;
        l2 = ((Long)((finally)localObject1).Xf.getLast()).longValue();
        l2 = Math.abs(System.currentTimeMillis() - l2);
        localObject2 = Ag;
        if (l1 < localObject2.length) {}
        for (i = (int)l1;; i = localObject2.length - 1)
        {
          if (i < 1) {
            break label246;
          }
          localObject2 = Ag;
          j = localObject2[(i - 1)];
          i = localObject2[i];
          if (j >= i) {
            break label2265;
          }
          i = new Random().nextInt(i - j + 1);
          if (l2 > TimeUnit.SECONDS.toMillis(i + j)) {
            break;
          }
          i = 0;
          break label99;
        }
        break label96;
        localObject2 = (Long)((finally)localObject1).Xf.getFirst();
        if (((finally)localObject1).size() < ((finally)localObject1).limit) {
          break;
        }
      } while (Math.abs(System.currentTimeMillis() - ((Long)localObject2).longValue()) < Bg);
      break;
      volatile localvolatile = new volatile.do(null).build();
      HashMap localHashMap = new HashMap();
      Aquila localAquila = new Aquila(paramMap, localHashMap);
      localAquila.mContext = paramContext;
      paramMap = localAquila.mContext;
      paramMap = localAquila.Lg;
      if ((paramMap == null) || (paramMap.size() == 0))
      {
        paramMap = null;
        if (paramMap != null) {
          break label1440;
        }
        l1 = localAquila.b(-1100000L);
      }
      for (;;)
      {
        if (l1 != 0L)
        {
          paramMap = H().o(paramContext);
          paramMap.offer(Long.valueOf(System.currentTimeMillis()));
          H().a(paramContext, paramMap);
        }
        localObject1 = implements.do.a(l1, localHashMap);
        l1 = ((implements.do)localObject1).R;
        localvolatile.fg = l1;
        Almond.e(paramContext, localvolatile.y());
        l2 = H().n(paramContext);
        if (l1 >= 0L) {
          break label2243;
        }
        H().a(paramContext, 1L + l2);
        return localObject1;
        l1 = System.currentTimeMillis();
        Object localObject3 = new Cepheus();
        j = Chamaeleon.qj.value;
        localObject2 = new Crux();
        paramMap = new Orion();
        paramMap.Hc = 11;
        paramMap.Ic = 1;
        paramMap.Jc = 1;
        paramMap.Kc = 0;
        paramMap.Lc = 0;
        paramMap.v = null;
        paramMap.Mc = 0;
        paramMap.Rc = 1;
        localObject1 = new Leo();
        ((Leo)localObject1)._b = 1;
        paramMap.Tc = ((Leo)localObject1);
        ((Crux)localObject2).Za = paramMap;
        Object localObject4 = new Pegasus();
        for (;;)
        {
          try
          {
            ((Pegasus)localObject4).Uc = this.d(Build.FINGERPRINT);
            ((Pegasus)localObject4).Vc = this.a(false);
            ((Pegasus)localObject4).Wc = this.d(Build.BRAND);
            ((Pegasus)localObject4).Xc = this.d(Build.MODEL);
            ((Pegasus)localObject4).Yc = Build.VERSION.SDK_INT;
            ((Pegasus)localObject4).Zc = this.d(Build.CPU_ABI);
          }
          catch (Exception paramMap)
          {
            Object localObject5;
            Object localObject6;
            Object localObject7;
            long l3;
            Object localObject8;
            int k;
            transient.do localdo;
            continue;
            continue;
          }
          try
          {
            paramMap = Class.forName("android.os.SystemProperties");
            paramMap = paramMap.getMethod("get", new Class[] { String.class });
            paramMap.setAccessible(true);
            localObject1 = (String)paramMap.invoke(null, new Object[] { "ro.board.platform" });
            paramMap = (Map<Integer, interface>)localObject1;
            if (localObject1 == null) {
              paramMap = "";
            }
          }
          catch (Throwable paramMap)
          {
            paramMap = "";
          }
        }
        ((Pegasus)localObject4).ua = this.d(paramMap);
        if (Aquila.Kg != -1) {
          new SparseArray();
        }
        try
        {
          localObject1 = (String)this.a(TuringNative.aa.d(this.c()), 201, String.class);
          paramMap = (Map<Integer, interface>)localObject1;
          if (localObject1 == null) {
            paramMap = "";
          }
          Aquila.Kg = Integer.parseInt(paramMap);
          i = Aquila.Kg;
        }
        catch (Throwable paramMap)
        {
          for (;;)
          {
            i = -1;
            continue;
            localObject1 = new Octans();
            ((Octans)localObject1).eb = i;
            localObject2 = ((interface)localObject6).getFileMd5();
            paramMap = (Map<Integer, interface>)localObject2;
            if (localObject2 == null) {
              paramMap = "";
            }
            ((Octans)localObject1).hb = this.e(paramMap);
            localObject2 = ((interface)localObject6).getPkgName();
            paramMap = (Map<Integer, interface>)localObject2;
            if (localObject2 == null) {
              paramMap = "";
            }
            ((Octans)localObject1).fb = paramMap;
            localObject2 = ((interface)localObject6).A();
            paramMap = (Map<Integer, interface>)localObject2;
            if (localObject2 == null) {
              paramMap = "";
            }
            ((Octans)localObject1).nc = this.e(paramMap);
            ((Octans)localObject1).gb = ((interface)localObject6).F();
            ((Octans)localObject1).rc = 0;
            ((Octans)localObject1).sc = "";
            ((Octans)localObject1).qb = 0;
            ((Octans)localObject1).rb = 0;
            ((Octans)localObject1).sb = 0;
            ((Octans)localObject1).tc = null;
            ((Octans)localObject1).uc = 0;
            ((Octans)localObject1).vc = false;
            ((Octans)localObject1).wc = 0;
            ((Octans)localObject1).xc = 0;
            paramMap = (Map<Integer, interface>)localObject1;
          }
          ((Cepheus)localObject3).Ea = ((List)localObject4);
          paramMap = new byte();
          paramMap.b(Aquila.DEFAULT_CHARSET);
          localObject1 = ((Cepheus)localObject3).Da;
          if (localObject1 == null) {
            break label1348;
          }
          paramMap.a((case)localObject1, 0);
          localObject1 = ((Cepheus)localObject3).Ea;
          if (localObject1 == null) {
            break label1367;
          }
          paramMap.a((Collection)localObject1, 1);
          localObject1 = ((Cepheus)localObject3).Fa;
          if (localObject1 == null) {
            break label1386;
          }
          paramMap.a((Collection)localObject1, 2);
          localObject1 = ((Cepheus)localObject3).Ga;
          if (localObject1 == null) {
            break label1405;
          }
          paramMap.a((Collection)localObject1, 3);
          paramMap = paramMap.toByteArray();
          l2 = System.currentTimeMillis();
          l3 = paramMap.length;
          localvolatile.hg = (l2 - l1);
          localvolatile.gg = l3;
        }
        ((Pegasus)localObject4)._c = i;
        ((Crux)localObject2)._a = ((Pegasus)localObject4);
        ((Crux)localObject2).ab = j;
        ((Crux)localObject2).cb = "";
        ((Crux)localObject2).bb = ((Serpens)class.g(this.get())).Og;
        ((Cepheus)localObject3).Da = ((Crux)localObject2);
        localObject4 = new ArrayList();
        localObject5 = localAquila.Lg.keySet().iterator();
        for (;;)
        {
          if (!((Iterator)localObject5).hasNext()) {
            break label1306;
          }
          paramMap = (Integer)((Iterator)localObject5).next();
          localObject6 = (interface)localAquila.Lg.get(paramMap);
          localObject7 = new ComaBerenices();
          i = paramMap.intValue();
          if (localObject6 != null) {
            break;
          }
          paramMap = null;
          ((ComaBerenices)localObject7).Na = paramMap;
          localObject1 = ((interface)localObject6).getFileName();
          paramMap = (Map<Integer, interface>)localObject1;
          if (localObject1 == null) {
            paramMap = "";
          }
          ((ComaBerenices)localObject7).Oa = paramMap;
          localObject1 = ((interface)localObject6).E();
          paramMap = (Map<Integer, interface>)localObject1;
          if (localObject1 == null) {
            paramMap = "";
          }
          ((ComaBerenices)localObject7).Pa = paramMap;
          ((ComaBerenices)localObject7).Ra = ((interface)localObject6).z();
          localObject1 = ((interface)localObject6).getFileSha1();
          paramMap = (Map<Integer, interface>)localObject1;
          if (localObject1 == null) {
            paramMap = "";
          }
          ((ComaBerenices)localObject7).Sa = this.e(paramMap);
          ((ComaBerenices)localObject7).Ta = ((interface)localObject6).B();
          localObject1 = ((interface)localObject6).G();
          paramMap = (Map<Integer, interface>)localObject1;
          if (localObject1 == null) {
            paramMap = "";
          }
          ((ComaBerenices)localObject7).Ua = paramMap;
          localObject1 = localAquila.Ng;
          if ((localObject1 != null) && (((String)localObject1).isEmpty()) && (!paramMap.isEmpty())) {
            localAquila.Ng = paramMap;
          }
          ((ComaBerenices)localObject7).Va = ((interface)localObject6).C();
          ((ComaBerenices)localObject7).Wa = ((interface)localObject6).D();
          ((List)localObject4).add(localObject7);
        }
        break;
        paramMap = Cranberry.zg.a(paramMap, localAquila.Ng);
        l1 = paramMap.fg;
        if (l1 == 0L)
        {
          localObject1 = paramMap.eh;
          if ((localObject1 == null) || (localObject1.length == 0)) {
            l1 = localAquila.b(-3000000L);
          } else {
            try
            {
              paramMap = new Gemini();
              localObject1 = new try((byte[])localObject1);
              ((try)localObject1).b(Aquila.DEFAULT_CHARSET);
              paramMap.a((try)localObject1);
              l1 = paramMap.R;
              if (l1 != 0L)
              {
                l1 = localAquila.b(-3200000L + l1);
                continue;
              }
              paramMap = paramMap.Bb;
              if (paramMap == null)
              {
                l1 = localAquila.b(-4000000L);
                continue;
              }
              if (paramMap.R != 0L)
              {
                l1 = localAquila.b(-4100000L + l1);
                continue;
              }
              paramMap = paramMap.Ea;
              if ((paramMap == null) || (paramMap.size() == 0))
              {
                l1 = localAquila.b(-4200000L);
                continue;
              }
              localObject6 = paramMap.iterator();
              while (((Iterator)localObject6).hasNext())
              {
                localObject7 = (Draco)((Iterator)localObject6).next();
                paramMap = ((Draco)localObject7).ob;
                if (paramMap != null) {
                  break label2280;
                }
                paramMap = "";
                localObject8 = ((Draco)localObject7).lb;
                if (localObject8 != null)
                {
                  i = ((Perseus)localObject8).pb;
                  if (localAquila.Lg.containsKey(Integer.valueOf(i)))
                  {
                    localObject5 = (interface)localAquila.Lg.get(Integer.valueOf(i));
                    localObject1 = ((interface)localObject5).getFileName();
                    localObject2 = localObject1;
                    if (localObject1 == null) {
                      localObject2 = "";
                    }
                    localObject1 = ((interface)localObject5).getFileSha1();
                    localObject3 = localObject1;
                    if (localObject1 == null) {
                      localObject3 = "";
                    }
                    localObject1 = ((interface)localObject5).getPkgName();
                    localObject4 = localObject1;
                    if (localObject1 == null) {
                      localObject4 = "";
                    }
                    localObject1 = ((interface)localObject5).getFileMd5();
                    localObject5 = localObject1;
                    if (localObject1 == null) {
                      localObject5 = "";
                    }
                    k = ((Perseus)localObject8).qb;
                    j = ((Perseus)localObject8).sb;
                    localObject1 = paramMap;
                    if (paramMap.isEmpty())
                    {
                      if ((k >= 1) && (k <= 3)) {
                        localObject1 = const.get(const.ff);
                      }
                    }
                    else
                    {
                      l1 = 0L;
                      paramBoolean = true;
                      paramMap = (Map<Integer, interface>)localObject3;
                      localObject3 = localObject4;
                      localObject4 = localObject5;
                    }
                  }
                }
                for (;;)
                {
                  if (i == -1) {
                    break label2120;
                  }
                  localObject8 = localAquila.Mg;
                  localdo = new transient.do(paramBoolean, l1, null);
                  localdo.ig = ((String)localObject3);
                  localdo.qb = k;
                  localdo.vg = j;
                  localObject5 = ((Draco)localObject7).mb;
                  localObject3 = localObject5;
                  if (localObject5 == null) {
                    localObject3 = "";
                  }
                  localdo.wg = ((String)localObject3);
                  localdo.mg = paramMap;
                  localdo.ng = ((String)localObject4);
                  localdo.og = ((String)localObject2);
                  localdo.xg = ((String)localObject1);
                  ((Map)localObject8).put(Integer.valueOf(i), localdo.build());
                  break;
                  if (k != 0)
                  {
                    localObject1 = paramMap;
                    if (k != 4) {
                      break label1868;
                    }
                  }
                  localObject1 = const.get(const.gf);
                  break label1868;
                  i = -1;
                  j = -1;
                  k = -1;
                  paramBoolean = false;
                  l1 = -10000000L;
                  localObject3 = "";
                  localObject5 = "";
                  localObject2 = "";
                  localObject4 = "";
                  localObject1 = paramMap;
                  paramMap = (Map<Integer, interface>)localObject5;
                  continue;
                  i = -1;
                  j = -1;
                  k = -1;
                  paramBoolean = false;
                  l1 = -10000000L;
                  localObject3 = "";
                  localObject5 = "";
                  localObject2 = "";
                  localObject4 = "";
                  localObject1 = paramMap;
                  paramMap = (Map<Integer, interface>)localObject5;
                }
              }
              paramMap = localAquila.Lg.keySet().iterator();
              l2 = -4200000L;
              for (;;)
              {
                l1 = l2;
                if (!paramMap.hasNext()) {
                  break;
                }
                localObject1 = (Integer)paramMap.next();
                if (!localAquila.Mg.containsKey(localObject1)) {
                  localAquila.Mg.put(localObject1, transient.a(-4200000L).build());
                } else {
                  l2 = 0L;
                }
              }
            }
            catch (Throwable paramMap)
            {
              l1 = localAquila.b(-3100000L);
            }
          }
        }
        else
        {
          l1 = localAquila.b(-2000000L + l1);
        }
      }
      paramMap = (Map<Integer, interface>)localObject1;
    } while (l2 == 0L);
    label296:
    label1348:
    label1367:
    label1386:
    H().a(paramContext, 0L);
    label1306:
    label1440:
    label1868:
    return localObject1;
    label2120:
    label2265:
    throw new IllegalArgumentException("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.implements
 * JD-Core Version:    0.7.0.1
 */