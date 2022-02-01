package com.tencent.mobileqq.vashealth;

import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigBean;
import com.tencent.mobileqq.vashealth.config.HealthTimerConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class StepAlarmReceiver$2
  implements Runnable
{
  StepAlarmReceiver$2(StepAlarmReceiver paramStepAlarmReceiver) {}
  
  public void run()
  {
    String str = String.valueOf(SSOHttpUtils.a());
    if ((!TextUtils.isEmpty(StepAlarmReceiver.c)) && (!str.equals(StepAlarmReceiver.c))) {
      SSOHttpUtils.a = 0.0F;
    }
    Object localObject = HealthTimerConfigProcessor.a();
    if (((HealthTimerConfigBean)localObject).n())
    {
      this.this$0.a = ((HealthTimerConfigBean)localObject).a();
      this.this$0.b = ((HealthTimerConfigBean)localObject).b();
    }
    StepAlarmReceiver.c = str;
    try
    {
      localObject = SSOHttpUtils.d();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      localObject = new JSONObject((String)localObject);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_total");
      int i = ((JSONObject)localObject).getInt(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_init");
      int j = ((JSONObject)localObject).getInt(localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("_offset");
      float f1 = i - j + ((JSONObject)localObject).getInt(localStringBuilder.toString());
      float f2 = SSOHttpUtils.a;
      long l1 = NetConnInfoCenter.getServerTimeMillis();
      long l2 = SSOHttpUtils.c;
      str = ((JSONObject)localObject).toString();
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receiver long time report max report steps:");
      ((StringBuilder)localObject).append(this.this$0.b);
      ((StringBuilder)localObject).append(",report interval:");
      ((StringBuilder)localObject).append(this.this$0.a);
      QLog.i("StepAlarmReceiver", 1, ((StringBuilder)localObject).toString());
      if ((f1 - f2 > this.this$0.b) || (l1 - l2 > this.this$0.a))
      {
        SSOHttpUtils.a(this.this$0.d, str);
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("long time report Exception:");
        ((StringBuilder)localObject).append(localException);
        QLog.e("health_manager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver.2
 * JD-Core Version:    0.7.0.1
 */