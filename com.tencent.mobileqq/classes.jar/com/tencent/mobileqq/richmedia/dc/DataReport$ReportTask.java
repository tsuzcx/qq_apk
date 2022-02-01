package com.tencent.mobileqq.richmedia.dc;

import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class DataReport$ReportTask
  implements Runnable
{
  String jdField_a_of_type_JavaLangString;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap;
  
  public DataReport$ReportTask(String paramString, HashMap<String, String> paramHashMap)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaUtilHashMap = paramHashMap;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaLangString != null)
    {
      Object localObject = this.jdField_a_of_type_JavaUtilHashMap;
      if ((localObject != null) && (!((HashMap)localObject).isEmpty()))
      {
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, this.jdField_a_of_type_JavaLangString, true, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("eventCode:");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append("\n");
          ((StringBuilder)localObject).append(localStringBuilder.toString());
          ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilHashMap.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask
 * JD-Core Version:    0.7.0.1
 */