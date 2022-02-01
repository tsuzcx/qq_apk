package com.tencent.open.agent;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class SwitchAccountActivity$1
  extends SSOAccountObserver
{
  SwitchAccountActivity$1(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    this.a.e();
    String str = paramBundle.getString("error");
    try
    {
      paramInt1 = paramBundle.getInt("code");
      ReportManager.a().a("agent_login", this.a.jdField_a_of_type_Long, 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str, true);
      if (paramInt2 == -1000) {
        this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, this.a.getResources().getString(2131694678));
      }
      for (;;)
      {
        paramInt1 = paramBundle.getInt("code");
        QLog.d("SwitchAccountActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
        return;
        if ((paramInt2 == 1) || (paramInt2 == -1004))
        {
          this.a.b();
        }
        else
        {
          Object localObject1 = (ErrMsg)paramBundle.getParcelable("lastError");
          if (localObject1 == null) {
            break;
          }
          localObject1 = ((ErrMsg)localObject1).getMessage();
          Object localObject3;
          if (localObject1 != null)
          {
            localObject3 = localObject1;
            if (((String)localObject1).length() != 0) {}
          }
          else
          {
            localObject3 = this.a.getString(2131720378);
          }
          this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface.a(this.a, (String)localObject3);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        Object localObject2 = null;
      }
    }
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    this.a.e();
    String str = null;
    if (paramInt == 4096) {
      str = new String(paramArrayOfByte);
    }
    this.a.a(paramString, str, paramBundle);
    paramInt = paramBundle.getInt("code");
    QLog.d("SwitchAccountActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : success | code: " + paramInt);
    try
    {
      ReportManager.a().a("agent_login", this.a.jdField_a_of_type_Long, 0L, 0L, 0, Long.parseLong(paramString), "1000069", null, true);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("SwitchAccountActivity", 2, "report login error : " + paramString.toString());
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    this.a.e();
    paramInt = paramBundle.getInt("code");
    QLog.d("SwitchAccountActivity", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */