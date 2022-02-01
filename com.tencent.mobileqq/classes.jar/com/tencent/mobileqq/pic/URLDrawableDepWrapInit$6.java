package com.tencent.mobileqq.pic;

import android.os.SystemClock;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ReportBean;
import com.tencent.image.api.IReport;
import com.tencent.image.api.ReportEventBean;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qqperf.UnifiedMonitor;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class URLDrawableDepWrapInit$6
  implements IReport
{
  private Set<String> a = new HashSet();
  
  public void debug(int paramInt, Object paramObject)
  {
    String str1;
    String str2;
    String str3;
    String str4;
    Exception localException;
    switch (paramInt)
    {
    default: 
    case 1: 
      do
      {
        return;
        paramObject = (Object[])paramObject;
      } while (paramObject.length != 5);
      str1 = (String)paramObject[0];
      str2 = (String)paramObject[1];
      str3 = (String)paramObject[2];
      str4 = (String)paramObject[3];
      localException = (Exception)paramObject[4];
      if (paramObject.length > 5) {
        paramObject = (String)paramObject[5];
      }
      break;
    }
    label525:
    for (;;)
    {
      try
      {
        Object localObject = str1.split("\\(|,|\\)");
        int j = Integer.parseInt(localObject[1]);
        int k = Integer.parseInt(localObject[2]);
        localObject = str2.split("\\(|,|\\)");
        paramInt = Integer.parseInt(localObject[1]);
        int i = Integer.parseInt(localObject[2]);
        if ((paramInt <= 0) || (i <= 0) || (j <= 0) || (k <= 0)) {
          break;
        }
        j = Math.max(Math.round(paramInt / j), Math.round(i / k));
        if (j >= 2)
        {
          paramInt = paramInt * i - i * paramInt / (j * j);
          if (paramInt <= 0) {
            break;
          }
          paramInt = paramInt * 4 / 1024;
          HashMap localHashMap = new HashMap(8);
          localObject = URLDrawableDepWrapInit.a(localException, false);
          String str5 = URLDrawableDepWrapInit.a((String)localObject, 1);
          if (localObject == null) {
            break label525;
          }
          localHashMap.put("stack", localObject);
          localHashMap.put("title", str5);
          localHashMap.put("viewsize", str1);
          localHashMap.put("picsize", str2);
          localHashMap.put("req_info", paramObject);
          if (str3 != null)
          {
            localObject = str3.replace('&', ' ');
            localHashMap.put("img_url", localObject);
            UnifiedMonitor.a().addEvent(2, str4, paramInt, 0, localHashMap);
            if (paramInt < 512) {
              break;
            }
            URLDrawableDepWrapInit.a(localException, str5, str4, str1 + paramObject, str2, str3, paramInt);
            return;
          }
          localObject = "";
          continue;
          paramObject = (Object[])paramObject;
          if (paramObject.length != 2) {
            break;
          }
          localObject = (String)paramObject[0];
          paramObject = (Exception)paramObject[1];
          return;
          paramObject = (Long)paramObject;
          if (SystemClock.uptimeMillis() % 100L != 0L) {
            break;
          }
          StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "AioPicDownloadWait", true, paramObject.longValue(), 0L, null, null);
          return;
          paramObject = (Long)paramObject;
          if (SystemClock.uptimeMillis() % 100L != 0L) {
            break;
          }
          StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "AioPicDispatchWait", true, paramObject.longValue(), 0L, null, null);
          return;
        }
        paramInt = 0;
        continue;
        paramObject = "";
        continue;
        localObject = "";
      }
      catch (Throwable paramObject)
      {
        return;
      }
    }
  }
  
  public void report(ReportBean paramReportBean)
  {
    if ((paramReportBean != null) && (paramReportBean.tag != null)) {
      StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, paramReportBean.tag, paramReportBean.suc, paramReportBean.time, paramReportBean.size, paramReportBean.params, null);
    }
  }
  
  public void reportEvent(ReportEventBean paramReportEventBean)
  {
    ReportController.b(null, paramReportEventBean.getTag(), paramReportEventBean.getMainAction(), paramReportEventBean.getToUin(), paramReportEventBean.getSubAction(), paramReportEventBean.getActionName(), paramReportEventBean.getFromType(), paramReportEventBean.getResult(), paramReportEventBean.getR2(), paramReportEventBean.getR3(), paramReportEventBean.getR3(), paramReportEventBean.getR4());
  }
  
  public void reportException(String paramString1, String paramString2)
  {
    CaughtExceptionReport.a(new IllegalArgumentException(paramString1), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit.6
 * JD-Core Version:    0.7.0.1
 */