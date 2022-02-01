package com.tencent.qqconnect.wtlogin;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.login.ui.AddAccountBaseUI;
import com.tencent.mobileqq.qqsec.api.ISafeBlockApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.os.MqqHandler;

class Login$6
  extends MqqHandler
{
  Login$6(Login paramLogin) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    this.a.hideLoginTip();
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 2001)
        {
          if (i != 2002) {
            return;
          }
          if (!this.a.isFinishing()) {
            this.a.showLoginTip();
          }
        }
        else if (!this.a.isFinishing())
        {
          this.a.hideLoginTip();
        }
      }
      else
      {
        i = ((Bundle)localObject).getInt("ret");
        int j = ((Bundle)localObject).getInt("code");
        paramMessage = ((Bundle)localObject).getString("OTHER_ERROR");
        if (((Bundle)localObject).getBoolean("pwdblank", false)) {
          this.a.mBaseUI.b("");
        }
        ReportController.a(null, "dc00898", "", "", "0X800B298", "0X800B298", 0, 0, "", "", paramMessage, "");
        boolean bool = ((ISafeBlockApi)QRoute.api(ISafeBlockApi.class)).shouldHandleByDlgHelper(((Bundle)localObject).getByteArray("tlverror"));
        if ((i == 40) && (bool))
        {
          this.a.showFrozenDlg((Bundle)localObject);
        }
        else if (i == 1)
        {
          localObject = this.a.mBaseUI.m();
          paramMessage = String.format(this.a.getResources().getString(2131894269), new Object[] { paramMessage, Integer.valueOf(j) });
          Login.access$300(this.a).a(this.a.app, this.a, (String)localObject, 4, paramMessage, new Login.6.1(this));
        }
        else
        {
          localObject = this.a;
          ((Login)localObject).showDialog(String.format(((Login)localObject).getResources().getString(2131894269), new Object[] { paramMessage, Integer.valueOf(j) }));
        }
        paramMessage = new HashMap();
        paramMessage.put("error", "3101");
        StatisticCollector.getInstance(this.a).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
      }
    }
    else
    {
      paramMessage = this.a;
      paramMessage.showDialog(String.format(paramMessage.getResources().getString(2131894269), new Object[] { this.a.getResources().getString(2131892333), Integer.valueOf(3100) }));
      paramMessage = new HashMap();
      paramMessage.put("error", "3100");
      StatisticCollector.getInstance(this.a).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.6
 * JD-Core Version:    0.7.0.1
 */