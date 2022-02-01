package com.tencent.mobileqq.kandian.biz.playfeeds;

import android.content.Context;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class VideoFeedsStartStatistic
{
  public static long a;
  
  public static void a()
  {
    a = System.currentTimeMillis();
  }
  
  public static void a(Context paramContext)
  {
    long l = System.currentTimeMillis();
    if (l - a < 10000L)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("param_starttime", String.valueOf(l - a));
      RIJStatisticCollectorReport.c(paramContext, RIJQQAppInterfaceUtil.a(), true, localHashMap);
      if (QLog.isColorLevel())
      {
        paramContext = new StringBuilder();
        paramContext.append("doReportStartTime param_starttime=");
        paramContext.append(l - a);
        QLog.d("VideoFeedsStartStatistic", 2, paramContext.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsStartStatistic
 * JD-Core Version:    0.7.0.1
 */