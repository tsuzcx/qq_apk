package com.tencent.xweb.xwalk;

import android.text.TextUtils;
import com.tencent.xweb.xwalk.updater.Scheduler;
import com.tencent.xweb.xwalk.updater.XWebCoreScheduler;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;
import org.xwalk.core.XWalkUpdater;

public class a
{
  public static com.tencent.xweb.a.a a(Object paramObject)
  {
    for (;;)
    {
      com.tencent.xweb.a.a locala;
      int i;
      try
      {
        locala = new com.tencent.xweb.a.a();
        if ((paramObject != null) && ((paramObject instanceof com.tencent.xweb.internal.a.a)))
        {
          Object localObject2 = (com.tencent.xweb.internal.a.a)paramObject;
          localObject1 = ((com.tencent.xweb.internal.a.a)localObject2).b;
          paramObject = ((com.tencent.xweb.internal.a.a)localObject2).c;
          if (((com.tencent.xweb.internal.a.a)localObject2).b.equals("executeCommand"))
          {
            paramObject = com.tencent.xweb.a.i(((com.tencent.xweb.internal.a.a)localObject2).c);
            if ((paramObject != null) && (paramObject.length >= 2))
            {
              localObject1 = paramObject[0];
              paramObject = paramObject[1];
            }
            else
            {
              return locala;
            }
          }
          i = -1;
          switch (((String)localObject1).hashCode())
          {
          case 1108642905: 
            if (!((String)localObject1).equals("revertToVersion")) {
              break;
            }
            i = 0;
            break;
          case -638079348: 
            if (!((String)localObject1).equals("cStrClearInstallEmbedVersionRecord")) {
              break;
            }
            i = 2;
            break;
          case -844092179: 
            if (!((String)localObject1).equals("fix_dex")) {
              break;
            }
            i = 1;
            break;
          case -1436151804: 
            if (!((String)localObject1).equals("clearSchedule")) {
              break;
            }
            i = 3;
            break;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("got command : ");
            ((StringBuilder)localObject2).append((String)localObject1);
            Log.i("ConfigCmdProc", ((StringBuilder)localObject2).toString());
            localObject1 = com.tencent.xweb.a.a("clearSchedule", "tools");
            if ((TextUtils.isEmpty(paramObject)) || (paramObject.equals(localObject1))) {
              break label452;
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("this command value changed from ");
            ((StringBuilder)localObject2).append((String)localObject1);
            ((StringBuilder)localObject2).append(" to ");
            ((StringBuilder)localObject2).append(paramObject);
            Log.i("ConfigCmdProc", ((StringBuilder)localObject2).toString());
            i = 1;
            if (i != 0)
            {
              Scheduler.b(false).e();
              Scheduler.b(true).e();
              continue;
              locala.a = true;
              XWalkUpdater.clearLastTryEmebedVersion();
              continue;
              locala.a = true;
              p.f();
            }
            return locala;
            locala.a = true;
          }
        }
      }
      finally {}
      try
      {
        i = Integer.parseInt(paramObject);
        p.a(XWalkEnvironment.getApplicationContext(), i);
        return locala;
      }
      catch (Exception localException)
      {
        continue;
      }
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("parse revertapk cmdvalue to int failed , value is ");
      ((StringBuilder)localObject1).append(paramObject);
      Log.e("ConfigCmdProc", ((StringBuilder)localObject1).toString());
      return locala;
      return locala;
      if (i != 0) {
        if (i != 1) {
          if (i != 2) {
            if (i != 3)
            {
              continue;
              label452:
              i = 0;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.xweb.xwalk.a
 * JD-Core Version:    0.7.0.1
 */