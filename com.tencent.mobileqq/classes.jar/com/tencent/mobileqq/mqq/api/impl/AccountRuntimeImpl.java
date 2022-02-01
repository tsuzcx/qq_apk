package com.tencent.mobileqq.mqq.api.impl;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;

public class AccountRuntimeImpl
  implements IAccountRuntime
{
  public static final String TAG = "AccountRuntimeImpl";
  
  public String getA2()
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = "";
    if ((localAppRuntime != null) && (!TextUtils.isEmpty(localAppRuntime.getAccount())))
    {
      TicketManager localTicketManager = (TicketManager)localAppRuntime.getManager(2);
      if (localTicketManager != null) {
        str = localTicketManager.getA2(localAppRuntime.getAccount());
      }
      return str;
    }
    QLog.d("AccountRuntimeImpl", 1, "appruntime or account is null");
    return "";
  }
  
  public String getAccount()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null).getAccount();
  }
  
  public Context getApplicationContext()
  {
    return MobileQQ.sMobileQQ.getApplicationContext();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mqq.api.impl.AccountRuntimeImpl
 * JD-Core Version:    0.7.0.1
 */