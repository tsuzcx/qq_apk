package com.tencent.open.agent;

import android.content.res.Resources;
import android.os.Bundle;
import com.tencent.open.agent.util.AuthReporter;
import com.tencent.open.agent.util.AuthUIUtil;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.open.data.SharedPrefs;
import mqq.observer.SSOAccountObserver;
import oicq.wlogin_sdk.tools.ErrMsg;

class SwitchAccountActivity$1
  extends SSOAccountObserver
{
  SwitchAccountActivity$1(SwitchAccountActivity paramSwitchAccountActivity) {}
  
  public void onFailed(String paramString, int paramInt1, int paramInt2, Bundle paramBundle)
  {
    SwitchAccountActivity.access$000(this.a);
    String str = paramBundle.getString("error");
    paramInt1 = paramBundle.getInt("code");
    long l = SwitchAccountActivity.access$200(this.a);
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ret: ");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(" | error: ");
    ((StringBuilder)localObject).append(str);
    AuthReporter.a("agent_login", l, 0L, 0L, paramInt1, paramString, ((StringBuilder)localObject).toString());
    if (paramInt2 == -1000)
    {
      paramBundle = this.a;
      AuthUIUtil.a(paramBundle, paramBundle.getResources().getString(2131694647));
    }
    else if ((paramInt2 != 1) && (paramInt2 != -1004))
    {
      localObject = (ErrMsg)paramBundle.getParcelable("lastError");
      paramBundle = null;
      if (localObject != null) {
        paramBundle = ((ErrMsg)localObject).getMessage();
      }
      if (paramBundle != null)
      {
        localObject = paramBundle;
        if (paramBundle.length() != 0) {}
      }
      else
      {
        localObject = this.a.getString(2131720117);
      }
      AuthUIUtil.a(this.a, (String)localObject);
    }
    else
    {
      SwitchAccountActivity.access$300(this.a);
    }
    paramBundle = new StringBuilder();
    paramBundle.append("rec | cmd: g_t_n_p | uin : *");
    paramBundle.append(AuthorityUtil.a(paramString));
    paramBundle.append(" | ret : ");
    paramBundle.append(paramInt2);
    paramBundle.append(" - error: ");
    paramBundle.append(str);
    paramBundle.append(" | code: ");
    paramBundle.append(paramInt1);
    SSOLog.a("SwitchAccountActivity", new Object[] { paramBundle.toString() });
  }
  
  public void onGetTicketNoPasswd(String paramString, byte[] paramArrayOfByte, int paramInt, Bundle paramBundle)
  {
    if ((!paramBundle.getBoolean("fake_callback")) && (paramInt == 4096)) {
      SharedPrefs.a(paramString, System.currentTimeMillis());
    }
    SwitchAccountActivity.access$000(this.a);
    String str = null;
    if (paramInt == 4096) {
      str = new String(paramArrayOfByte);
    }
    SwitchAccountActivity.access$100(this.a, paramString, str, paramBundle);
    paramInt = paramBundle.getInt("code");
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("rec | cmd: g_t_n_p | uin : *");
    paramArrayOfByte.append(AuthorityUtil.a(paramString));
    paramArrayOfByte.append(" | ret : success | code: ");
    paramArrayOfByte.append(paramInt);
    SSOLog.a("SwitchAccountActivity", new Object[] { paramArrayOfByte.toString() });
    AuthReporter.a("agent_login", SwitchAccountActivity.access$200(this.a), 0L, 0L, 0, paramString, null);
  }
  
  public void onUserCancel(String paramString, int paramInt, Bundle paramBundle)
  {
    SwitchAccountActivity.access$000(this.a);
    paramInt = paramBundle.getInt("code");
    paramBundle = new StringBuilder();
    paramBundle.append("rec | cmd: g_t_n_p | uin : *");
    paramBundle.append(AuthorityUtil.a(paramString));
    paramBundle.append(" | ret : on_user_cancel | code: ");
    paramBundle.append(paramInt);
    SSOLog.a("SwitchAccountActivity", new Object[] { paramBundle.toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.SwitchAccountActivity.1
 * JD-Core Version:    0.7.0.1
 */