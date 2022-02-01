package com.tencent.mobileqq.kandian.glue.report;

import android.content.Context;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

final class RIJStatisticCollectorReport$1
  implements Runnable
{
  RIJStatisticCollectorReport$1(HashMap paramHashMap, boolean paramBoolean, Context paramContext, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      Object localObject2 = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
        ((StringBuilder)localObject1).append((String)localEntry.getKey());
        ((StringBuilder)localObject1).append(":");
        ((StringBuilder)localObject1).append((String)localEntry.getValue());
        ((StringBuilder)localObject1).append(" ");
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("reportKandianVideoInfo, success =");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_Boolean);
      ((StringBuilder)localObject2).append(", data=");
      ((StringBuilder)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d("Q.readinjoy.video", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new HashMap(this.jdField_a_of_type_JavaUtilHashMap);
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_JavaLangString, "actKandianVideoWithExtraInfo", this.jdField_a_of_type_Boolean, -1L, 0L, (HashMap)localObject1, null);
    try
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove("param_speedList");
    }
    catch (Throwable localThrowable1)
    {
      QLog.e("RIJStatisticCollectorReport", 2, localThrowable1.getMessage());
    }
    StatisticCollector.getInstance(this.jdField_a_of_type_AndroidContentContext).collectPerformance(this.jdField_a_of_type_JavaLangString, "actKandianVideo", this.jdField_a_of_type_Boolean, -1L, 0L, this.jdField_a_of_type_JavaUtilHashMap, null);
    try
    {
      JSONObject localJSONObject = new JSONObject(this.jdField_a_of_type_JavaUtilHashMap);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, null, "0X80096D9", "0X80096D9", 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (Throwable localThrowable2)
    {
      QLog.e("RIJStatisticCollectorReport", 2, localThrowable2.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.report.RIJStatisticCollectorReport.1
 * JD-Core Version:    0.7.0.1
 */