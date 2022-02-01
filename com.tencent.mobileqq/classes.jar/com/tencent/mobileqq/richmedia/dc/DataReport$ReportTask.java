package com.tencent.mobileqq.richmedia.dc;

import bctj;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class DataReport$ReportTask
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
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.isEmpty())) {
      if (QLog.isColorLevel()) {
        QLog.i("DataReport", 2, "You must set mEventCode before report data!");
      }
    }
    do
    {
      return;
      bctj.a(BaseApplication.getContext()).a(null, this.jdField_a_of_type_JavaLangString, true, 0L, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    } while (!QLog.isColorLevel());
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("eventCode:" + this.jdField_a_of_type_JavaLangString + "\n");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilHashMap.toString());
    QLog.i("DataReport", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.dc.DataReport.ReportTask
 * JD-Core Version:    0.7.0.1
 */