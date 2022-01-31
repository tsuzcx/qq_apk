package com.tencent.tvkbeacon.core.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.b.i;
import com.tencent.tvkbeacon.event.UserAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class g
{
  private RDBean a;
  private Context b;
  private final boolean c;
  private boolean d = false;
  private int e = 20000;
  private int f = 0;
  private Runnable g = new g.1(this);
  
  public g(Context paramContext)
  {
    this.b = paramContext;
    this.c = com.tencent.tvkbeacon.core.info.a.e(this.b);
    this.d = com.tencent.tvkbeacon.core.info.a.a;
  }
  
  private void a(int paramInt)
  {
    try
    {
      this.f = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Context paramContext)
  {
    com.tencent.tvkbeacon.core.a.b.d().a(108, true);
    com.tencent.tvkbeacon.core.a.c.a(paramContext).a().a("HEART_DENGTA", com.tencent.tvkbeacon.core.c.a.a()).b();
    com.tencent.tvkbeacon.core.c.c.a("[event] heartbeat uploaded success!", new Object[0]);
  }
  
  private Map d()
  {
    HashMap localHashMap = new HashMap(4);
    com.tencent.tvkbeacon.core.info.d.a(this.b);
    localHashMap.put("A33", com.tencent.tvkbeacon.core.info.d.j(this.b));
    if (this.c)
    {
      localHashMap.put("A66", "F");
      localHashMap.put("A68", com.tencent.tvkbeacon.core.info.a.f(this.b));
      if (!this.d) {
        break label148;
      }
    }
    label148:
    for (String str = "Y";; str = "N")
    {
      localHashMap.put("A85", str);
      localHashMap.put("A20", com.tencent.tvkbeacon.core.info.d.g(this.b));
      localHashMap.put("A69", com.tencent.tvkbeacon.core.info.d.h(this.b));
      return localHashMap;
      localHashMap.put("A66", "B");
      break;
    }
  }
  
  private int e()
  {
    try
    {
      int i = this.f;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  protected final void a()
  {
    if (!com.tencent.tvkbeacon.core.c.d.b(this.b)) {}
    do
    {
      return;
      h localh = h.a(this.b);
      if (localh != null)
      {
        ArrayList localArrayList = new ArrayList(2);
        localArrayList.add(this.a);
        Iterator localIterator = h.a(this.b).c().iterator();
        while (localIterator.hasNext()) {
          ((i)localIterator.next()).incRealTimeEventCalls();
        }
        localh.a(new j(this.b, com.tencent.tvkbeacon.core.info.b.a(this.b).b(), localArrayList));
      }
      a(e() + 1);
      if (e() % 10 == 0)
      {
        com.tencent.tvkbeacon.core.a.b.d().a(108, this.g, 600000L, this.e);
        a(0);
      }
    } while (!this.d);
    com.tencent.tvkbeacon.core.a.c.a(this.b).a().a("active_user_date", com.tencent.tvkbeacon.core.c.a.a()).b();
  }
  
  public final void b()
  {
    Object localObject1 = com.tencent.tvkbeacon.core.c.a.a();
    Object localObject2 = com.tencent.tvkbeacon.core.a.c.a(this.b);
    String str = ((com.tencent.tvkbeacon.core.a.c)localObject2).a("HEART_DENGTA", "");
    localObject2 = ((com.tencent.tvkbeacon.core.a.c)localObject2).a("active_user_date", "");
    if ((((String)localObject1).equals(str)) || (((String)localObject2).equals(localObject1)))
    {
      com.tencent.tvkbeacon.core.c.c.c("[event] heartbeat had upload!", new Object[0]);
      return;
    }
    localObject1 = EventStrategyBean.getInstance();
    if (((EventStrategyBean)localObject1).isInPreventEventCode("rqd_heartbeat"))
    {
      com.tencent.tvkbeacon.core.c.c.c("[event] rqd_heartbeat not allowed in strategy!", new Object[0]);
      return;
    }
    if (!((EventStrategyBean)localObject1).isUploadByRate("rqd_heartbeat"))
    {
      com.tencent.tvkbeacon.core.c.c.c("[event] rqd_heartbeat is sampled by svr rate!", new Object[0]);
      return;
    }
    localObject1 = d();
    this.a = k.a(this.b, null, "rqd_heartbeat", true, 0L, 0L, (Map)localObject1, true, false);
    com.tencent.tvkbeacon.core.a.b.d().a(108, this.g, 0L, this.e);
  }
  
  public final void c()
  {
    com.tencent.tvkbeacon.core.a.c localc = com.tencent.tvkbeacon.core.a.c.a(this.b);
    String str = localc.a("active_user_date", "");
    if (!com.tencent.tvkbeacon.core.c.a.a().equals(str))
    {
      com.tencent.tvkbeacon.core.c.c.b("[event] recover a heart beat for active user.", new Object[0]);
      if (UserAction.onUserAction("rqd_heartbeat", true, 0L, 0L, d(), true)) {
        localc.a().a("active_user_date", com.tencent.tvkbeacon.core.c.a.a()).b();
      }
      return;
    }
    com.tencent.tvkbeacon.core.c.c.c("[event] active user event had upload.", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.event.g
 * JD-Core Version:    0.7.0.1
 */