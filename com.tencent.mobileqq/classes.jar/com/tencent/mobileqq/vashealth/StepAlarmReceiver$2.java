package com.tencent.mobileqq.vashealth;

import android.content.SharedPreferences;
import android.text.TextUtils;
import bhww;
import bhwz;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class StepAlarmReceiver$2
  implements Runnable
{
  StepAlarmReceiver$2(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    String str = String.valueOf(bhww.a());
    if ((!TextUtils.isEmpty(StepAlarmReceiver.jdField_a_of_type_JavaLangString)) && (!str.equals(StepAlarmReceiver.jdField_a_of_type_JavaLangString))) {
      bhww.jdField_a_of_type_Float = 0.0F;
    }
    Object localObject = bhwz.a();
    if (((SharedPreferences)localObject).getBoolean("config_ready", false))
    {
      this.this$0.jdField_a_of_type_Long = ((SharedPreferences)localObject).getInt("max_interval", 0);
      this.this$0.jdField_a_of_type_Int = ((SharedPreferences)localObject).getInt("max_increment", 0);
    }
    StepAlarmReceiver.jdField_a_of_type_JavaLangString = str;
    try
    {
      localObject = bhww.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).getInt(str + "_total");
      int j = ((JSONObject)localObject).getInt(str + "_init");
      float f1 = ((JSONObject)localObject).getInt(str + "_offset") + (i - j);
      float f2 = bhww.jdField_a_of_type_Float;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = bhww.jdField_a_of_type_Long;
      str = ((JSONObject)localObject).toString();
      QLog.i("StepAlarmReceiver", 1, "receiver long time report max report steps:" + this.this$0.jdField_a_of_type_Int + ",report interval:" + this.this$0.jdField_a_of_type_Long);
      if ((f1 - f2 > this.this$0.jdField_a_of_type_Int) || (l1 - l2 > this.this$0.jdField_a_of_type_Long))
      {
        bhww.a(str);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("health_manager", 2, "long time report Exception:" + localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.2
 * JD-Core Version:    0.7.0.1
 */