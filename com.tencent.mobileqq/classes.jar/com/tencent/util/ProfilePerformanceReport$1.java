package com.tencent.util;

import awrn;
import befb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ProfilePerformanceReport$1
  implements Runnable
{
  public ProfilePerformanceReport$1(befb parambefb, String paramString, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    awrn.a(BaseApplicationImpl.getContext()).a(this.jdField_a_of_type_JavaLangString, befb.a(this.this$0), true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
    if (QLog.isDevelopLevel()) {
      QLog.i("ProfilePerformanceReport", 4, "end of report");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.util.ProfilePerformanceReport.1
 * JD-Core Version:    0.7.0.1
 */