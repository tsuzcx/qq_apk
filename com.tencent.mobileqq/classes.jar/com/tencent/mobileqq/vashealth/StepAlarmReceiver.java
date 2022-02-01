package com.tencent.mobileqq.vashealth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.ISportManager;
import com.tencent.mobileqq.vashealth.config.StepConfigBean;
import com.tencent.mobileqq.vashealth.config.StepConfigProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.app.AppRuntime;

public class StepAlarmReceiver
  extends BroadcastReceiver
{
  static String c;
  long a = 7200000L;
  int b = 1000;
  AppRuntime d;
  
  public StepAlarmReceiver(AppRuntime paramAppRuntime)
  {
    this.d = paramAppRuntime;
  }
  
  public void a()
  {
    this.d = null;
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isSupportStepCounter(this.d.getApplicationContext()))
    {
      QLog.e("StepAlarmReceiver", 1, "onReceive:step counter not support");
      return;
    }
    paramContext = paramIntent.getAction();
    if ("action_sport_timer1".equals(paramContext))
    {
      paramContext = this.d;
      if (paramContext != null)
      {
        if (!SSOHttpUtils.a(2, paramContext.getAccount())) {
          return;
        }
        ThreadManager.post(new StepAlarmReceiver.1(this), 5, null, true);
        return;
      }
      return;
    }
    if ("action_sport_timer2".equals(paramContext))
    {
      paramContext = this.d;
      if (paramContext == null) {
        return;
      }
      paramContext = (ISportManager)paramContext.getRuntimeService(ISportManager.class, "multi");
      if (paramContext != null) {
        paramContext.doOnTimer2();
      }
    }
    else
    {
      if ("StepAlarmReceiver_long_time_report".equals(paramContext))
      {
        QLog.i("StepAlarmReceiver", 1, "StepAlarmReceiver_long_time_report!");
        if (StepConfigProcessor.a().a() == 2)
        {
          SSOHttpUtils.a(this.d, paramIntent.getExtras());
          return;
        }
        if (!paramIntent.getBooleanExtra("VerifyResult", true)) {
          SSOHttpUtils.b(-1000, "verifyFailed");
        }
        ThreadManager.post(new StepAlarmReceiver.2(this), 5, null, true);
        return;
      }
      if ("action_step_compare_report".equals(paramContext))
      {
        paramContext = (HashMap)paramIntent.getSerializableExtra("health_compare_report_params");
        paramIntent = SSOHttpUtils.e();
        if (paramIntent[1] != -1)
        {
          paramContext.put("data1", String.valueOf(paramIntent[1]));
          VSHealthReportUtil.a(this.d.getCurrentUin(), "qqsport_getbyxiaomi_usersteps", paramContext);
          return;
        }
        VSHealthReportUtil.a(this.d.getCurrentUin(), "qqsport_compare_usersteps", paramContext);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepAlarmReceiver
 * JD-Core Version:    0.7.0.1
 */