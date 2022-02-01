package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import java.util.Map;

final class MonitorConfig$1
  implements Runnable
{
  MonitorConfig$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    MonitorConfig.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (MonitorConfig.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString) != null)
    {
      Monitor.b(String.valueOf(((MonitorConfig)MonitorConfig.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString)).jdField_a_of_type_Int));
      return;
    }
    Monitor.b("3235983");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1
 * JD-Core Version:    0.7.0.1
 */