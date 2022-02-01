package com.tencent.mobileqq.richmedia.dc;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DataReport$ReportTask
  implements Runnable
{
  HashMap<String, String> a;
  String b;
  
  public DataReport$ReportTask(String paramString, HashMap<String, String> paramHashMap)
  {
    this.b = paramString;
    this.a = paramHashMap;
  }
  
  public void run()
  {
    if (this.b != null)
    {
      Object localObject = this.a;
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()))
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.b, true, 0L, 0L, this.a, "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("eventCode:");
          localStringBuilder.append(this.b);
          localStringBuilder.append("\n");
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          ((StringBuilder)localObject).append(this.a.toString());
          QLog.i("DataReport", 2, ((StringBuilder)localObject).toString());
        }
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("DataReport", 2, "You must set mEventCode before report data!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask
 * JD-Core Version:    0.7.0.1
 */