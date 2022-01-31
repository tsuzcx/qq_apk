package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.strategy.StrategyQueryModule;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class d
{
  public boolean a;
  private Context b;
  private String c;
  private Map<String, String> d = null;
  private final Object e = new Object();
  private h f = null;
  private h g = null;
  private String h = "10000";
  
  public d(Context paramContext, String paramString)
  {
    this.b = paramContext;
    this.c = paramString;
    this.f = new a(paramContext, this);
    this.g = new i(paramContext, this);
  }
  
  private int i()
  {
    if (this.a) {
      return l.a(this.b, this.c);
    }
    return -1;
  }
  
  public final h a()
  {
    return this.f;
  }
  
  public final void a(String paramString)
  {
    this.c = paramString;
  }
  
  public final void a(Map<String, String> paramMap)
  {
    if ((paramMap != null) && (paramMap.size() <= 20))
    {
      if (this.d == null) {
        this.d = new HashMap();
      }
      this.d.putAll(paramMap);
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    h localh = this.f;
    if (localh != null) {
      localh.b(paramBoolean);
    }
    localh = this.g;
    if (localh != null) {
      localh.b(paramBoolean);
    }
    this.a = paramBoolean;
  }
  
  public final boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map<String, String> paramMap, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (com.tencent.tvkbeacon.core.c.i.a(paramString)) {
      paramString = null;
    }
    Object localObject;
    while (paramString == null)
    {
      return false;
      String str = paramString.replace('|', '_').trim();
      if (str.length() == 0)
      {
        c.d("[core] eventName is invalid!! eventName length == 0!", new Object[0]);
        paramString = null;
      }
      else if (com.tencent.tvkbeacon.core.c.b.b(str))
      {
        localObject = str;
        if (str.length() > 128)
        {
          c.c("[core] eventName length should be less than 128! eventName:".concat(String.valueOf(paramString)), new Object[0]);
          localObject = str.substring(0, 128);
        }
        paramString = (String)localObject;
      }
      else
      {
        c.d("[core] eventName should be ASCII code in 32-126! eventName:".concat(String.valueOf(paramString)), new Object[0]);
        paramString = null;
      }
    }
    c.a("[event] UserEvent: %s, %b, %d, %d, %b, %b", new Object[] { paramString, Boolean.valueOf(paramBoolean1), Long.valueOf(paramLong1), Long.valueOf(paramLong2), Boolean.valueOf(paramBoolean2), Boolean.valueOf(paramBoolean3) });
    if (EventStrategyBean.getInstance().isInPreventEventCode(paramString))
    {
      c.d("[event] '%s' is not allowed in strategy (false).", new Object[] { paramString });
      return false;
    }
    if ((!paramBoolean1) || (EventStrategyBean.getInstance().isUploadByRate(paramString))) {
      if (paramBoolean2) {
        localObject = this.g;
      }
    }
    while (localObject != null)
    {
      paramMap = k.a(this.b, this.c, paramString, paramBoolean1, paramLong1, paramLong2, paramMap, paramBoolean2, paramBoolean3);
      if (paramMap == null)
      {
        c.d("[event] RDBean:%s is null, return false!", new Object[] { paramString });
        return false;
        localObject = this.f;
      }
      else
      {
        return ((h)localObject).a(paramMap);
        c.d("[event] '%s' is sampled by svr rate (false).", new Object[] { paramString });
        return false;
      }
    }
    return false;
  }
  
  public final h b()
  {
    return this.g;
  }
  
  public final void b(String paramString)
  {
    this.h = paramString;
  }
  
  public final boolean b(boolean paramBoolean)
  {
    if (!TunnelModule.isModuleAble())
    {
      c.d("[module] this module not ready!", new Object[0]);
      return false;
    }
    synchronized (this.e)
    {
      int i = i();
      if (i > 0) {
        try
        {
          if (com.tencent.tvkbeacon.core.b.h.a(this.b) != null)
          {
            b localb = new b(this.b, this.c);
            localb.a(paramBoolean);
            com.tencent.tvkbeacon.core.b.h.a(this.b).a(localb);
          }
          return true;
        }
        catch (Throwable localThrowable)
        {
          c.d("[event] up common error: %s", new Object[] { localThrowable.toString() });
          c.a(localThrowable);
        }
      }
      return false;
    }
  }
  
  public final void c()
  {
    synchronized (this.e)
    {
      int i = i();
      int j = 20;
      while ((i > 0) && (j > 0))
      {
        j -= 1;
        c.a("[db] -> upload db events, [%d] need to upload.", new Object[] { Integer.valueOf(i) });
        if (!b(false)) {
          return;
        }
        i = i();
      }
      return;
    }
  }
  
  public final void d()
  {
    for (;;)
    {
      try
      {
        Object localObject = StrategyQueryModule.getInstance(this.b).getStrategy();
        if (localObject == null) {
          return;
        }
        localObject = ((com.tencent.tvkbeacon.core.strategy.b)localObject).f();
        if ((localObject != null) && (EventStrategyBean.getInstance() != null))
        {
          Set localSet = ((com.tencent.tvkbeacon.core.strategy.a)localObject).c();
          if ((localSet != null) && (localSet.size() > 0)) {
            EventStrategyBean.getInstance().setPreventEventCode(localSet);
          }
          localSet = ((com.tencent.tvkbeacon.core.strategy.a)localObject).e();
          if ((localSet != null) && (localSet.size() > 0)) {
            EventStrategyBean.getInstance().setSampleEvent(localSet);
          }
        }
        if ((!this.a) || (localObject == null)) {
          break;
        }
        if (i() > 0)
        {
          i = 1;
          if (i == 0) {
            return;
          }
          c.e("[event] asyn up module %d", new Object[] { Integer.valueOf(1) });
          com.tencent.tvkbeacon.core.a.b.d().a(new d.1(this));
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        c.a(localThrowable);
        c.d("[event] common query end error %s", new Object[] { localThrowable.toString() });
        return;
      }
      int i = 0;
    }
    c.d("[event] module is disable", new Object[0]);
  }
  
  public final void e()
  {
    this.f.b();
    this.g.b();
  }
  
  public final String f()
  {
    return this.c;
  }
  
  public final Map<String, String> g()
  {
    return this.d;
  }
  
  public final String h()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.d
 * JD-Core Version:    0.7.0.1
 */