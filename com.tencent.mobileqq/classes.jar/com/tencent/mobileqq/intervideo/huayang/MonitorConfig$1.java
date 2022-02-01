package com.tencent.mobileqq.intervideo.huayang;

import android.content.Context;
import avjb;
import avjc;
import java.util.Map;

public final class MonitorConfig$1
  implements Runnable
{
  public MonitorConfig$1(Context paramContext, String paramString) {}
  
  public void run()
  {
    avjc.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_JavaLangString);
    if (avjc.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString) != null)
    {
      avjb.b(String.valueOf(((avjc)avjc.jdField_a_of_type_JavaUtilMap.get(this.jdField_a_of_type_JavaLangString)).jdField_a_of_type_Int));
      return;
    }
    avjb.b("3235983");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.MonitorConfig.1
 * JD-Core Version:    0.7.0.1
 */