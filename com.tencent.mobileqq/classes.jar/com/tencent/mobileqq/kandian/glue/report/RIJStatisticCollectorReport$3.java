package com.tencent.mobileqq.kandian.glue.report;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.AppRuntime;
import org.json.JSONObject;

final class RIJStatisticCollectorReport$3
  implements Runnable
{
  RIJStatisticCollectorReport$3(JSONObject paramJSONObject, AppRuntime paramAppRuntime, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      HashMap localHashMap = new HashMap();
      localObject = this.a.keys();
      while (((Iterator)localObject).hasNext())
      {
        String str = ((Iterator)localObject).next().toString();
        localHashMap.put(str, this.a.optString(str));
      }
      StatisticCollector.getInstance(this.b.getApplication()).collectPerformance(null, "actKanDianViolaPageDataNew", this.c, -1L, -1L, localHashMap, null, true);
      return;
    }
    catch (Exception localException)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reportViolaPageProcessNew , error : ");
      ((StringBuilder)localObject).append(localException.getMessage());
      QLog.e("RIJStatisticCollectorReport", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport.3
 * JD-Core Version:    0.7.0.1
 */