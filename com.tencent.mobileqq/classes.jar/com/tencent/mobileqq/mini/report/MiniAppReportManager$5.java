package com.tencent.mobileqq.mini.report;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

final class MiniAppReportManager$5
  implements Runnable
{
  public void run()
  {
    Object localObject = MiniAppReportManager.access$200();
    if ((localObject == null) || (((List)localObject).size() == 0)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MiniAppReportEntity localMiniAppReportEntity = (MiniAppReportEntity)((Iterator)localObject).next();
        if (localMiniAppReportEntity != null)
        {
          long l1 = 0L;
          try
          {
            long l2 = Long.valueOf(localMiniAppReportEntity.launchId).longValue();
            l1 = l2;
            bool1 = MiniAppReportManager.x5EnableSet.contains(localMiniAppReportEntity.launchId);
            bool2 = MiniAppReportManager.hasPkgSet.contains(localMiniAppReportEntity.launchId);
            if ("click".equals(localMiniAppReportEntity.subActionType))
            {
              if (System.currentTimeMillis() - l1 <= MiniAppReportManager.OPEN_TIME_OUT) {
                continue;
              }
              if (MiniAppReportManager.jsErrorSet.contains(localMiniAppReportEntity.launchId))
              {
                MiniAppReportManager.access$400(localMiniAppReportEntity, "load_fail", "jsError", MiniAppReportManager.access$300(bool1, bool2), null);
                MiniAppReportManager.jsErrorSet.remove(localMiniAppReportEntity.launchId);
                MiniAppReportManager.appPauseTimeMap.remove(localMiniAppReportEntity.launchId);
                MiniAppReportManager.x5EnableSet.remove(localMiniAppReportEntity.launchId);
                MiniAppReportManager.hasPkgSet.remove(localMiniAppReportEntity.launchId);
                MiniAppReportManager.access$700(localMiniAppReportEntity);
                localArrayList.add(localMiniAppReportEntity);
              }
            }
          }
          catch (NumberFormatException localNumberFormatException)
          {
            boolean bool1;
            boolean bool2;
            for (;;)
            {
              QLog.e("MiniAppReportManager", 1, "checkReportDataFromDB, launchId: " + localMiniAppReportEntity.launchId);
              continue;
              l1 = MiniAppReportManager.access$500(localMiniAppReportEntity.launchId);
              MiniAppReportManager.access$400(localMiniAppReportEntity, "load_fail", MiniAppReportManager.access$600(l1), MiniAppReportManager.access$300(bool1, bool2), String.valueOf(l1));
            }
            if ("load".equals(localMiniAppReportEntity.subActionType))
            {
              if (System.currentTimeMillis() - l1 > MiniAppReportManager.OPEN_TIME_OUT)
              {
                if (MiniAppReportManager.jsErrorSet.contains(localMiniAppReportEntity.launchId)) {
                  MiniAppReportManager.access$400(localMiniAppReportEntity, "show_fail", "jsError", MiniAppReportManager.access$300(bool1, bool2), null);
                }
                for (;;)
                {
                  MiniAppReportManager.jsErrorSet.remove(localMiniAppReportEntity.launchId);
                  MiniAppReportManager.appPauseTimeMap.remove(localMiniAppReportEntity.launchId);
                  MiniAppReportManager.x5EnableSet.remove(localMiniAppReportEntity.launchId);
                  MiniAppReportManager.hasPkgSet.remove(localMiniAppReportEntity.launchId);
                  MiniAppReportManager.access$700(localMiniAppReportEntity);
                  localArrayList.add(localMiniAppReportEntity);
                  break;
                  l1 = MiniAppReportManager.access$500(localMiniAppReportEntity.launchId);
                  MiniAppReportManager.access$400(localMiniAppReportEntity, "show_fail", MiniAppReportManager.access$600(l1), MiniAppReportManager.access$300(bool1, bool2), String.valueOf(l1));
                }
              }
            }
            else if ("show".equals(localMiniAppReportEntity.subActionType))
            {
              String str = MiniAppReportManager.access$800(localMiniAppReportEntity);
              if (str != null)
              {
                MiniAppReportManager.access$400(localMiniAppReportEntity, "hide", null, "delay_report", str);
                localArrayList.add(localMiniAppReportEntity);
              }
              MiniAppReportManager.access$700(localMiniAppReportEntity);
            }
            else
            {
              MiniAppReportManager.access$700(localMiniAppReportEntity);
            }
          }
        }
      }
    } while (localArrayList.size() <= 0);
    MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.5
 * JD-Core Version:    0.7.0.1
 */