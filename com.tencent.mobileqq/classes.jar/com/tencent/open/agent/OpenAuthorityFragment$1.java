package com.tencent.open.agent;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.mobileqq.forward.ForwardStatisticsReporter;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.open.agent.report.ReportDef.AuthCmdCost.Record;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.business.cgireport.ReportManager;
import com.tencent.open.business.viareport.OpenSdkStatic;
import com.tencent.open.data.SharedPrefs;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.util.HandlerPlus;
import mqq.observer.SSOAccountObserver;

class OpenAuthorityFragment$1
  extends SSOAccountObserver
{
  OpenAuthorityFragment$1(OpenAuthorityFragment paramOpenAuthorityFragment) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "ssoLoginObserver onFailed");
    OpenAuthorityFragment.a(this.a, true);
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    try
    {
      ReportManager.a().a("agent_login", OpenAuthorityFragment.b(this.a), 0L, 0L, paramInt1, Long.parseLong(paramString), "1000069", "ret: " + paramInt2 + " | error: " + str, true);
      OpenSdkStatic.a().a(1, "LOGIN_GETTICKT", paramString, OpenAuthorityFragment.a(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), paramInt1, 1, str);
      ReportCenter.a().a(paramString, "", OpenAuthorityFragment.a(this.a), "1", "1", "" + paramInt1, false, true);
      ReportCenter.a().a(paramString, "", OpenAuthorityFragment.a(this.a), "1", "6", "" + paramInt1, false, true);
      ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, OpenAuthorityFragment.c(this.a), null, false);
      ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : " + paramInt2 + " - error: " + str + " | code: " + paramInt1);
      if ((paramInt2 == -1000) || (paramInt2 == 154))
      {
        OpenAuthorityFragment.a(this.a, SystemClock.elapsedRealtime());
        QLog.d("SSOAccountObserver", 1, "<TimeStamp> login cost : " + (OpenAuthorityFragment.a(this.a) - OpenAuthorityFragment.b(this.a)));
        if ((paramInt1 == 1002) && (OpenAuthorityFragment.a(this.a) < 2))
        {
          OpenAuthorityFragment.b(this.a);
          this.a.e();
          return;
        }
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "report login error : ", paramBundle);
      }
      this.a.a(3003, this.a.getResources().getString(2131694678));
      paramString = this.a.a.obtainMessage();
      paramString.what = 6;
      paramString.arg1 = 3003;
      paramString.obj = this.a.getResources().getString(2131694678);
      this.a.a.sendMessage(paramString);
      return;
    }
    this.a.c(paramString);
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    boolean bool = paramBundle.getBoolean("fake_callback");
    if ((!bool) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, l);
    }
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, new Object[] { "ssoLoginObserver onGetTicketNoPasswd fakeCb=", Boolean.valueOf(bool) });
    int i;
    Object localObject;
    if (!bool)
    {
      i = paramBundle.getInt("code");
      localObject = new Bundle();
      ((Bundle)localObject).putString("report_type", "103");
      ((Bundle)localObject).putString("act_type", "10");
      ((Bundle)localObject).putString("stringext_1", "GetTicketNoPassword");
      ((Bundle)localObject).putString("intext_2", "" + i);
      ((Bundle)localObject).putString("intext_5", "" + (l - OpenAuthorityFragment.a(this.a).a));
      ReportCenter.a().a((Bundle)localObject, OpenAuthorityFragment.a(this.a), paramString, false, true);
      QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "onGetTicketNoPasswd | uin : *" + AuthorityUtil.a(paramString) + " | ret : success | code: " + i + " | cost" + (OpenAuthorityFragment.a(this.a) - OpenAuthorityFragment.b(this.a)));
    }
    try
    {
      ReportManager.a().a("agent_login", OpenAuthorityFragment.b(this.a), OpenAuthorityFragment.b(this.a).length(), paramArrayOfByte.length, 0, Long.parseLong(paramString), "1000069", null, true);
      OpenSdkStatic.a().a(0, "LOGIN_GETTICKT", paramString, OpenAuthorityFragment.a(this.a), null, Long.valueOf(SystemClock.elapsedRealtime()), i, 1, null);
      ReportCenter.a().a(paramString, "", OpenAuthorityFragment.a(this.a), "1", "1", "0", false, true);
      OpenAuthorityFragment.a(this.a, false);
      OpenAuthorityFragment.a(this.a, 0);
      localObject = null;
      if (paramInt == 4096) {
        localObject = new String(paramArrayOfByte);
      }
      this.a.a(paramString, (String)localObject, paramBundle);
      OpenAuthorityFragment.a(this.a, SystemClock.elapsedRealtime());
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("SDK_LOGIN.OpenAuthorityFragment", 1, "report login error : ", localException);
      }
    }
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "ssoLoginObserver onUserCancel");
    paramInt = paramBundle.getInt("code");
    OpenAuthorityFragment.a(this.a, 0);
    OpenAuthorityFragment.a(this.a, SystemClock.elapsedRealtime());
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "<TimeStamp> login cost : " + (OpenAuthorityFragment.a(this.a) - OpenAuthorityFragment.b(this.a)));
    ForwardStatisticsReporter.a("KEY_LOGIN_STAGE_1_TOTAL", paramString, OpenAuthorityFragment.c(this.a), null, false);
    ForwardStatisticsReporter.a("KEY_DELEGATE_GET_TICKET_NO_PASSWD", paramString, false);
    QLog.d("SDK_LOGIN.OpenAuthorityFragment", 1, "rec | cmd: g_t_n_p | uin : *" + AuthorityUtil.a(paramString) + " | ret : on_user_cancel | code: " + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.1
 * JD-Core Version:    0.7.0.1
 */