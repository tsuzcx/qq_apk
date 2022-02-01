package com.tencent.qqconnect.wtlogin;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import android.widget.EditText;
import com.tencent.mobileqq.app.LoginFailedHelper;
import com.tencent.mobileqq.app.security.FrozenNotifyDlgHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;
import mqq.os.MqqHandler;

class Login$8
  extends MqqHandler
{
  Login$8(Login paramLogin) {}
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject = paramMessage.getData();
    this.a.d();
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
        this.a.a(String.format(this.a.getResources().getString(2131696476), new Object[] { this.a.getResources().getString(2131694678), Integer.valueOf(3100) }));
        paramMessage = new HashMap();
        paramMessage.put("error", "3100");
        StatisticCollector.getInstance(this.a).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
        return;
        int i = ((Bundle)localObject).getInt("ret");
        int j = ((Bundle)localObject).getInt("code");
        paramMessage = ((Bundle)localObject).getString("OTHER_ERROR");
        if (((Bundle)localObject).getBoolean("pwdblank", false)) {
          this.a.b.setText("");
        }
        ReportController.a(null, "dc00898", "", "", "0X800B298", "0X800B298", 0, 0, "", "", paramMessage, "");
        boolean bool = FrozenNotifyDlgHelper.a().a(((Bundle)localObject).getByteArray("tlverror"));
        if ((i == 40) && (bool)) {
          this.a.a((Bundle)localObject);
        }
        for (;;)
        {
          paramMessage = new HashMap();
          paramMessage.put("error", "3101");
          StatisticCollector.getInstance(this.a).collectPerformance("0", "connect_sso_authfail", false, 0L, 0L, paramMessage, "");
          return;
          if (i == 1)
          {
            localObject = this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
            paramMessage = String.format(this.a.getResources().getString(2131696476), new Object[] { paramMessage, Integer.valueOf(j) });
            Login.a(this.a).a(this.a.jdField_a_of_type_ComTencentQqconnectWtloginOpenSDKAppInterface, this.a, (String)localObject, 4, paramMessage, new Login.8.1(this));
          }
          else
          {
            this.a.a(String.format(this.a.getResources().getString(2131696476), new Object[] { paramMessage, Integer.valueOf(j) }));
          }
        }
      } while (this.a.isFinishing());
      this.a.d();
      return;
    } while (this.a.isFinishing());
    this.a.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.8
 * JD-Core Version:    0.7.0.1
 */