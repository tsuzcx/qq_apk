package com.tencent.tvkbeacon.event;

import android.content.Context;
import com.tencent.tvkbeacon.core.a;
import com.tencent.tvkbeacon.core.b;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.core.event.TunnelModule;
import com.tencent.tvkbeacon.core.event.UserEventModule;
import com.tencent.tvkbeacon.core.strategy.StrategyQueryModule;
import com.tencent.tvkbeacon.upload.InitHandleListener;
import java.util.Iterator;
import java.util.List;

final class UserAction$1
  implements Runnable
{
  UserAction$1(InitHandleListener paramInitHandleListener, long paramLong) {}
  
  public final void run()
  {
    UserAction.beaconModules.add(UserEventModule.getInstance(UserAction.mContext));
    UserAction.beaconModules.add(TunnelModule.getInstance(UserAction.mContext));
    Iterator localIterator = a.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      try
      {
        Object localObject = UserAction.mContext;
        localObject = (b)com.tencent.tvkbeacon.core.c.e.a(str, "getInstance", new Class[] { Context.class }, new Object[] { localObject });
        if (localObject != null)
        {
          c.a("[core] %s module load successfully.", new Object[] { str });
          UserAction.beaconModules.add(localObject);
        }
      }
      catch (Exception localException) {}
    }
    StrategyQueryModule.getInstance(UserAction.mContext).setInitHandleListener(this.a);
    UserAction.beaconModules.add(StrategyQueryModule.getInstance(UserAction.mContext));
    localIterator = UserAction.beaconModules.iterator();
    while (localIterator.hasNext()) {
      ((b)localIterator.next()).onSDKInit(UserAction.mContext);
    }
    long l2 = this.b;
    if (l2 > 0L)
    {
      long l1 = l2;
      if (l2 > 10000L) {
        l1 = 10000L;
      }
      com.tencent.tvkbeacon.core.strategy.e.a(l1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.event.UserAction.1
 * JD-Core Version:    0.7.0.1
 */