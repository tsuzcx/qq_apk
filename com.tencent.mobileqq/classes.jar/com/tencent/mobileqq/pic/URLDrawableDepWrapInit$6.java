package com.tencent.mobileqq.pic;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ReportBean;
import com.tencent.image.api.IReport;
import com.tencent.image.api.ReportEventBean;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

final class URLDrawableDepWrapInit$6
  implements IReport
{
  private Set<String> a = new HashSet();
  
  protected void a(Object[] paramArrayOfObject)
  {
    String str2;
    String str3;
    String str4;
    String str5;
    Exception localException;
    int i;
    String str1;
    if (paramArrayOfObject.length == 5)
    {
      str2 = (String)paramArrayOfObject[0];
      str3 = (String)paramArrayOfObject[1];
      str4 = (String)paramArrayOfObject[2];
      str5 = (String)paramArrayOfObject[3];
      localException = (Exception)paramArrayOfObject[4];
      i = paramArrayOfObject.length;
      str1 = "";
      if (i > 5) {
        paramArrayOfObject = (String)paramArrayOfObject[5];
      } else {
        paramArrayOfObject = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject = str2.split("\\(|,|\\)");
        int k = Integer.parseInt(localObject[1]);
        int m = Integer.parseInt(localObject[2]);
        localObject = str3.split("\\(|,|\\)");
        i = Integer.parseInt(localObject[1]);
        int j = Integer.parseInt(localObject[2]);
        if ((i > 0) && (j > 0) && (k > 0) && (m > 0))
        {
          k = Math.max(Math.round(i / k), Math.round(j / m));
          if (k < 2) {
            break label392;
          }
          i *= j;
          i -= i / (k * k);
          if (i > 0)
          {
            i = i * 4 / 1024;
            HashMap localHashMap = new HashMap(8);
            localObject = URLDrawableDepWrapInit.a(localException, false);
            String str6 = URLDrawableDepWrapInit.a((String)localObject, 1);
            if (localObject == null) {
              break label397;
            }
            localHashMap.put("stack", localObject);
            localHashMap.put("title", str6);
            localHashMap.put("viewsize", str2);
            localHashMap.put("picsize", str3);
            localHashMap.put("req_info", paramArrayOfObject);
            localObject = str1;
            if (str4 != null) {
              localObject = str4.replace('&', ' ');
            }
            localHashMap.put("img_url", localObject);
            UnifiedMonitor.a().addEvent(2, str5, i, 0, localHashMap);
            if (i >= 512)
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append(str2);
              ((StringBuilder)localObject).append(paramArrayOfObject);
              URLDrawableDepWrapInit.a(localException, str6, str5, ((StringBuilder)localObject).toString(), str3, str4, i);
            }
          }
        }
        return;
      }
      catch (Throwable paramArrayOfObject)
      {
        return;
      }
      label392:
      i = 0;
      continue;
      label397:
      Object localObject = "";
    }
  }
  
  public void debug(int paramInt, Object paramObject)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          URLDrawableDepWrapInit.a((Long)paramObject);
          return;
        }
        URLDrawableDepWrapInit.b((Long)paramObject);
        return;
      }
      URLDrawableDepWrapInit.a((Object[])paramObject);
      return;
    }
    a((Object[])paramObject);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pic.URLDrawableDepWrapInit.6
 * JD-Core Version:    0.7.0.1
 */