package com.tencent.mobileqq.mini.report;

import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class MiniAppReportManager2$2
  implements Runnable
{
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        MiniAppReportManager2.access$002(false);
        long l = NetConnInfoCenter.getServerTimeMillis();
        Iterator localIterator = MiniAppReportManager2.launchStateMap.entrySet().iterator();
        if (localIterator.hasNext())
        {
          Object localObject = (Map.Entry)localIterator.next();
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (MiniAppReportManager2.AppLaunchState)((Map.Entry)localObject).getValue();
          if ((((MiniAppReportManager2.AppLaunchState)localObject).launchResult == 0) && (l - ((MiniAppReportManager2.AppLaunchState)localObject).activeTime > MiniAppReportManager2.LAUNCH_TIME_OUT)) {
            MiniAppReportManager2.access$100((MiniAppReportManager2.AppLaunchState)localObject);
          }
          if (((MiniAppReportManager2.AppLaunchState)localObject).launchResult == 0) {
            i = 1;
          }
        }
        else
        {
          if (i != 0) {
            MiniAppReportManager2.access$200();
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("MiniAppReportManager2", 2, "", localThrowable);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager2.2
 * JD-Core Version:    0.7.0.1
 */