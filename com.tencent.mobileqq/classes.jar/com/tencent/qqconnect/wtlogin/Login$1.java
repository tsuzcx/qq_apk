package com.tencent.qqconnect.wtlogin;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Message;
import com.tencent.mobileqq.app.LoginForbiddenDialogReporter;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import mqq.observer.SSOAccountObserver;
import mqq.os.MqqHandler;
import oicq.wlogin_sdk.tools.ErrMsg;

class Login$1
  extends SSOAccountObserver
{
  Login$1(Login paramLogin) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    Login.access$000(this.a);
    String str = paramBundle.getString("error");
    int i = paramBundle.getInt("code");
    long l = this.a.mLoginBTS;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ret: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" | error: ");
    ((StringBuilder)localObject).append(str);
    AuthReporter.a("agent_login", l, 0L, 0L, i, paramString, ((StringBuilder)localObject).toString());
    LoginForbiddenDialogReporter.a(this.a.getAppRuntime(), paramString, 4, String.valueOf(paramInt2), paramInt2, str);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFail:account=");
    ((StringBuilder)localObject).append(AuthorityUtil.a(paramString));
    ((StringBuilder)localObject).append(" action=");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(" ret=");
    ((StringBuilder)localObject).append(paramInt2);
    SSOLog.a("SSOAccountObserver", new Object[] { ((StringBuilder)localObject).toString() });
    localObject = new Message();
    if (paramInt2 == -1000)
    {
      ((Message)localObject).what = 1;
    }
    else
    {
      ((Message)localObject).what = 2;
      ErrMsg localErrMsg = (ErrMsg)paramBundle.getParcelable("lastError");
      Bundle localBundle = ((Message)localObject).getData();
      localBundle.putInt("ret", paramInt2);
      if (paramInt2 == 40)
      {
        localBundle.putString("loginalias", paramString);
        localBundle.putString("msg", localErrMsg.getMessage());
        localBundle.putInt("errorver", localErrMsg.getVersion());
        localBundle.putByteArray("tlverror", paramBundle.getByteArray("tlverror"));
        localBundle.putString("errortitle", localErrMsg.getTitle());
        localBundle.putString("errorUrl", paramBundle.getString("errorUrl"));
      }
      localBundle.putInt("code", i);
      if (localErrMsg != null) {
        localBundle.putString("OTHER_ERROR", localErrMsg.getMessage());
      } else {
        localBundle.putString("OTHER_ERROR", this.a.getResources().getString(2131892333));
      }
      if (this.a.autoFillInPasswd) {
        localBundle.putBoolean("pwdblank", true);
      } else {
        localBundle.putBoolean("pwdblank", false);
      }
    }
    this.a.loginHandler.sendMessage((Message)localObject);
    paramBundle = new StringBuilder();
    paramBundle.append("rec | cmd:  | uin : *");
    paramBundle.append(AuthorityUtil.a(paramString));
    paramBundle.append(" | ret : ");
    paramBundle.append(paramInt2);
    paramBundle.append(" - error: ");
    paramBundle.append(str);
    paramBundle.append(" | code: ");
    paramBundle.append(i);
    SSOLog.a("Login", new Object[] { paramBundle.toString() });
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    } else {
      paramArrayOfByte = null;
    }
    this.a.loginSucess(paramString, paramArrayOfByte, paramBundle);
    paramInt = paramBundle.getInt("code");
    paramBundle = new StringBuilder();
    paramBundle.append("rec | cmd: g_t_n_p | uin : *");
    paramBundle.append(AuthorityUtil.a(paramString));
    paramBundle.append(" | ret : success | code: ");
    paramBundle.append(paramInt);
    SSOLog.a("Login", new Object[] { paramBundle.toString() });
    long l;
    if (paramArrayOfByte == null) {
      l = 0L;
    } else {
      l = paramArrayOfByte.length();
    }
    AuthReporter.a("agent_login", this.a.mLoginBTS, this.a.mReqSize, l, paramInt, paramString, null);
  }
  
  public void onLoginSuccess(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    Login.access$000(this.a);
    if (paramInt == 4096) {
      paramArrayOfByte = new String(paramArrayOfByte);
    } else {
      paramArrayOfByte = null;
    }
    this.a.loginSucess(paramString, paramArrayOfByte, paramBundle);
    paramInt = paramBundle.getInt("code");
    paramBundle = new StringBuilder();
    paramBundle.append("rec | cmd: s_s_o_l | uin : *");
    paramBundle.append(AuthorityUtil.a(paramString));
    paramBundle.append(" | ret : success | code: ");
    paramBundle.append(paramInt);
    SSOLog.a("Login", new Object[] { paramBundle.toString() });
    long l;
    if (paramArrayOfByte == null) {
      l = 0L;
    } else {
      l = paramArrayOfByte.length();
    }
    AuthReporter.a("agent_login", this.a.mLoginBTS, this.a.mReqSize, l, 0, paramString, null);
    LoginForbiddenDialogReporter.a(this.a.getAppRuntime(), paramString, 4);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUserCancel ssoAccount=");
    localStringBuilder.append(AuthorityUtil.a(paramString));
    localStringBuilder.append(" action=");
    localStringBuilder.append(paramInt);
    SSOLog.a("SSOAccountObserver", new Object[] { localStringBuilder.toString() });
    this.a.hideLoginTip();
    Login.access$000(this.a);
    paramInt = paramBundle.getInt("code");
    paramBundle = new StringBuilder();
    paramBundle.append("rec | cmd:  | uin : *");
    paramBundle.append(AuthorityUtil.a(paramString));
    paramBundle.append(" | ret : on_user_cancel | code: ");
    paramBundle.append(paramInt);
    SSOLog.a("Login", new Object[] { paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqconnect.wtlogin.Login.1
 * JD-Core Version:    0.7.0.1
 */