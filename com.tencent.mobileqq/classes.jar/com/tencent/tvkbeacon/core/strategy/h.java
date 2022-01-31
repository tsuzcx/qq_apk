package com.tencent.tvkbeacon.core.strategy;

import android.content.Context;
import com.tencent.tvkbeacon.core.b.j;
import com.tencent.tvkbeacon.core.info.d;
import com.tencent.tvkbeacon.core.info.e;
import com.tencent.tvkbeacon.core.protocol.common.RequestPackage;
import com.tencent.tvkbeacon.event.UserAction;
import com.tencent.tvkbeacon.g.QimeiSDK;
import java.util.HashMap;
import java.util.Map;

public final class h
  extends com.tencent.tvkbeacon.core.b.a
{
  public h(Context paramContext, String paramString)
  {
    super(paramContext, 0, 100, paramString);
  }
  
  public final RequestPackage a()
  {
    Object localObject1 = e.b(this.c);
    Object localObject2 = "".getBytes();
    int i = c();
    for (;;)
    {
      try
      {
        localObject2 = j.a(i, (com.tencent.tvkbeacon.core.info.b)localObject1, (byte[])localObject2, -1, -1, this.f);
        if ((localObject2 == null) || (c() != 100)) {
          break;
        }
        HashMap localHashMap = new HashMap();
        localHashMap.put("A1", UserAction.getUserID(null));
        com.tencent.tvkbeacon.core.info.c localc = com.tencent.tvkbeacon.core.info.c.a(((e)localObject1).j());
        localHashMap.put("A2", localc.a());
        localHashMap.put("A4", localc.c());
        localHashMap.put("A6", localc.b());
        localHashMap.put("A7", localc.d());
        localHashMap.put("A3", QimeiSDK.getInstance().getQimeiInternal());
        localHashMap.put("A23", ((e)localObject1).a(null));
        localHashMap.put("A31", localc.e());
        d.a(((e)localObject1).j());
        localHashMap.put("A33", d.j(((e)localObject1).j()));
        if (com.tencent.tvkbeacon.core.info.a.e(((e)localObject1).j()))
        {
          localHashMap.put("A66", "F");
          localHashMap.put("A67", com.tencent.tvkbeacon.core.info.a.g(((e)localObject1).j()));
          localHashMap.put("A68", com.tencent.tvkbeacon.core.info.a.f(((e)localObject1).j()));
          if (com.tencent.tvkbeacon.core.info.a.a)
          {
            localObject1 = "Y";
            localHashMap.put("A85", localObject1);
            ((RequestPackage)localObject2).reserved = com.tencent.tvkbeacon.core.c.b.a(localHashMap);
            return localObject2;
          }
        }
        else
        {
          localHashMap.put("A66", "B");
          continue;
        }
        String str = "N";
      }
      catch (Throwable localThrowable)
      {
        com.tencent.tvkbeacon.core.c.c.a(localThrowable);
        com.tencent.tvkbeacon.core.c.c.d("[event] encode empty package failed", new Object[0]);
        return null;
      }
    }
    return localObject2;
  }
  
  public final void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.strategy.h
 * JD-Core Version:    0.7.0.1
 */