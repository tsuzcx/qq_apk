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
    Object localObject1 = MiniAppReportManager.access$200();
    if (localObject1 != null)
    {
      if (((List)localObject1).size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        MiniAppReportEntity localMiniAppReportEntity = (MiniAppReportEntity)((Iterator)localObject1).next();
        long l1;
        if (localMiniAppReportEntity != null) {
          l1 = 0L;
        }
        try
        {
          long l2 = Long.valueOf(localMiniAppReportEntity.launchId).longValue();
          l1 = l2;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          label85:
          Object localObject2;
          boolean bool1;
          boolean bool2;
          break label85;
        }
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("checkReportDataFromDB, launchId: ");
        ((StringBuilder)localObject2).append(localMiniAppReportEntity.launchId);
        QLog.e("MiniAppReportManager", 1, ((StringBuilder)localObject2).toString());
        bool1 = MiniAppReportManager.x5EnableSet.contains(localMiniAppReportEntity.launchId);
        bool2 = MiniAppReportManager.hasPkgSet.contains(localMiniAppReportEntity.launchId);
        if ("click".equals(localMiniAppReportEntity.subActionType))
        {
          if (System.currentTimeMillis() - l1 > MiniAppReportManager.OPEN_TIME_OUT)
          {
            if (MiniAppReportManager.jsErrorSet.contains(localMiniAppReportEntity.launchId))
            {
              MiniAppReportManager.access$400(localMiniAppReportEntity, "load_fail", "jsError", MiniAppReportManager.access$300(bool1, bool2), null);
            }
            else
            {
              l1 = MiniAppReportManager.access$500(localMiniAppReportEntity.launchId);
              MiniAppReportManager.access$400(localMiniAppReportEntity, "load_fail", MiniAppReportManager.access$600(l1), MiniAppReportManager.access$300(bool1, bool2), String.valueOf(l1));
            }
            MiniAppReportManager.jsErrorSet.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.appPauseTimeMap.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.x5EnableSet.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.hasPkgSet.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.access$700(localMiniAppReportEntity);
            localArrayList.add(localMiniAppReportEntity);
          }
        }
        else if ("load".equals(localMiniAppReportEntity.subActionType))
        {
          if (System.currentTimeMillis() - l1 > MiniAppReportManager.OPEN_TIME_OUT)
          {
            if (MiniAppReportManager.jsErrorSet.contains(localMiniAppReportEntity.launchId))
            {
              MiniAppReportManager.access$400(localMiniAppReportEntity, "show_fail", "jsError", MiniAppReportManager.access$300(bool1, bool2), null);
            }
            else
            {
              l1 = MiniAppReportManager.access$500(localMiniAppReportEntity.launchId);
              MiniAppReportManager.access$400(localMiniAppReportEntity, "show_fail", MiniAppReportManager.access$600(l1), MiniAppReportManager.access$300(bool1, bool2), String.valueOf(l1));
            }
            MiniAppReportManager.jsErrorSet.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.appPauseTimeMap.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.x5EnableSet.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.hasPkgSet.remove(localMiniAppReportEntity.launchId);
            MiniAppReportManager.access$700(localMiniAppReportEntity);
            localArrayList.add(localMiniAppReportEntity);
          }
        }
        else if ("show".equals(localMiniAppReportEntity.subActionType))
        {
          localObject2 = MiniAppReportManager.access$800(localMiniAppReportEntity);
          if (localObject2 != null)
          {
            MiniAppReportManager.access$400(localMiniAppReportEntity, "hide", null, "delay_report", (String)localObject2);
            localArrayList.add(localMiniAppReportEntity);
          }
          MiniAppReportManager.access$700(localMiniAppReportEntity);
        }
        else
        {
          MiniAppReportManager.access$700(localMiniAppReportEntity);
        }
      }
      if (localArrayList.size() > 0) {
        MiniProgramReporter.getInstance().reportImmediatelyLaunchDcData();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.report.MiniAppReportManager.5
 * JD-Core Version:    0.7.0.1
 */