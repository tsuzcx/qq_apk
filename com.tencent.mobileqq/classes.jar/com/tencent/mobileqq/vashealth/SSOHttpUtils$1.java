package com.tencent.mobileqq.vashealth;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.vashealth.websso.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import org.json.JSONObject;

final class SSOHttpUtils$1
  implements BusinessObserver
{
  SSOHttpUtils$1(AppRuntime paramAppRuntime) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject;
    if (paramBoolean)
    {
      try
      {
        localObject = paramBundle.getByteArray("extra_data");
        if (localObject == null)
        {
          QLog.e("SSOHttpUtils", 1, "report failed response data is null");
          return;
        }
        paramBundle = new WebSSOAgent.UniSsoServerRsp();
        paramBundle.mergeFrom((byte[])localObject);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report result:");
        ((StringBuilder)localObject).append(paramBundle.rspdata.get());
        ((StringBuilder)localObject).append(",ret:");
        ((StringBuilder)localObject).append(paramBundle.ret.get());
        QLog.i("SSOHttpUtils", 1, ((StringBuilder)localObject).toString());
        long l = paramBundle.ret.get();
        if (0L == l)
        {
          localObject = new NewIntent(this.a.getApplication(), StepCounterServlert.class);
          ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_update_lastreport_time");
          ((NewIntent)localObject).putExtra("last_report_time", new Long(NetConnInfoCenter.getServerTimeMillis()));
          ((NewIntent)localObject).putExtra("has_report_yes", new Boolean(SSOHttpUtils.jdField_a_of_type_Boolean));
          this.a.startServlet((NewIntent)localObject);
          SSOHttpUtils.jdField_a_of_type_Float = SSOHttpUtils.jdField_a_of_type_Int - SSOHttpUtils.b + SSOHttpUtils.c;
          localObject = this.a.getAccount();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            SSOHttpUtils.jdField_a_of_type_JavaLangString = (String)localObject;
          }
          SSOHttpUtils.jdField_a_of_type_Long = NetConnInfoCenter.getServerTimeMillis();
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("SSOHttpUtils do report success steps:");
          ((StringBuilder)localObject).append(SSOHttpUtils.jdField_a_of_type_Float);
          QLog.i("SSOHttpUtils", 1, ((StringBuilder)localObject).toString());
        }
        paramBundle = new JSONObject(paramBundle.rspdata.get());
        if (paramBundle.has("svr_steps"))
        {
          paramInt = paramBundle.getInt("svr_steps");
          paramBundle = new StringBuilder();
          paramBundle.append("step reset from server:");
          paramBundle.append(paramInt);
          QLog.e("SSOHttpUtils", 1, paramBundle.toString());
          paramBundle = new NewIntent(this.a.getApplication(), StepCounterServlert.class);
          paramBundle.putExtra("msf_cmd_type", "cmd_reset_step");
          paramBundle.putExtra("server_step", paramInt);
          this.a.startServlet(paramBundle);
        }
      }
      catch (Exception paramBundle)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Parse response exception:");
        ((StringBuilder)localObject).append(paramBundle.getMessage());
        QLog.e("SSOHttpUtils", 1, ((StringBuilder)localObject).toString());
      }
      paramBundle = "";
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SSO sent Failed!!");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.i("SSOHttpUtils", 1, ((StringBuilder)localObject).toString());
      paramBundle = paramBundle.toString();
    }
    ThreadManager.post(new SSOHttpUtils.1.1(this, -1, paramBundle), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.SSOHttpUtils.1
 * JD-Core Version:    0.7.0.1
 */