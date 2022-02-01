package com.tencent.open.agent.strategy;

import android.os.Bundle;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.model.AccountInfo;
import com.tencent.open.model.AccountManage.GetTicketCallback;

class SSOLoginAction$3
  implements AccountManage.GetTicketCallback
{
  SSOLoginAction$3(SSOLoginAction paramSSOLoginAction, Bundle paramBundle, String paramString1, long paramLong, String paramString2, int paramInt) {}
  
  public void a(AccountInfo paramAccountInfo)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "getTicketNoPasswd onSuccess:", Long.valueOf(System.currentTimeMillis() - this.c) });
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramAccountInfo);
    SSOLoginAction.a(this.f, paramAccountInfo, this.b, this.d, this.a, this.e);
  }
  
  public void a(String paramString, Bundle paramBundle)
  {
    AuthReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", "", false);
    SSOLoginAction.a(this.f, paramString, this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.3
 * JD-Core Version:    0.7.0.1
 */