package com.tencent.open.agent;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqconnect.wtlogin.OpenSDKAppInterface;
import eipc.EIPCClient;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

class AgentActivity$9
  extends BroadcastReceiver
{
  AgentActivity$9(AgentActivity paramAgentActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    QLog.d("SDK_LOGIN.AgentActivity", 1, new Object[] { "-->onReceive, intent.getAction : ", paramIntent.getAction() });
    if ("action_login_sucess".equals(paramIntent.getAction()))
    {
      if (!paramIntent.getBooleanExtra("param_is_qr_code_login", false)) {
        break label272;
      }
      AgentActivity.a(this.a, 0, paramIntent);
      AgentActivity.a(this.a);
      QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_on_qr_code_login_success", new Bundle());
    }
    for (;;)
    {
      boolean bool = paramIntent.getBooleanExtra("forbid_quick_login_after", false);
      if ((AgentActivity.a(this.a)) && (!AgentActivity.a(this.a).isLogin()) && (!bool))
      {
        paramContext = AgentActivity.a(this.a).getAccount();
        QLog.i("SDK_LOGIN.AgentActivity", 1, "mLoginReceiver() OpenSDKAppinterface not login, logined uin= " + paramContext);
        paramIntent = AgentActivity.a(this.a).getApplication().getAllAccounts();
        if ((paramIntent != null) && (paramIntent.size() > 0) && (!TextUtils.isEmpty(paramContext)))
        {
          paramIntent = paramIntent.iterator();
          while (paramIntent.hasNext())
          {
            SimpleAccount localSimpleAccount = (SimpleAccount)paramIntent.next();
            if (paramContext.equals(localSimpleAccount.getUin()))
            {
              AgentActivity.a(this.a).login(localSimpleAccount);
              QLog.i("SDK_LOGIN.AgentActivity", 1, "mLoginReceiver() OpenSDKAppinterface do login uin= " + paramContext);
            }
          }
        }
      }
      this.a.unregisterReceiver(this);
      return;
      label272:
      if (AgentActivity.a(this.a) != null)
      {
        paramContext = AuthorityUtil.a(paramIntent, "login_success_uin");
        if (!TextUtils.isEmpty(paramContext)) {
          AgentActivity.a(this.a).putExtra("login_success_uin", paramContext);
        }
        if (AgentActivity.a(this.a).getIntExtra("intent_router", 0) == 1) {
          PublicFragmentActivity.Launcher.a(this.a, AgentActivity.a(this.a), PublicFragmentActivityForOpenSDK.class, OpenAuthorityFragment.class, 0);
        } else {
          this.a.startActivityForResult(AgentActivity.a(this.a), 0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.open.agent.AgentActivity.9
 * JD-Core Version:    0.7.0.1
 */