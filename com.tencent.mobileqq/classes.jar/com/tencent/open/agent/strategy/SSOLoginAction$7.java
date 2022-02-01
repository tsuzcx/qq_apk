package com.tencent.open.agent.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.open.agent.util.AuthParamUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import eipc.EIPCClient;

class SSOLoginAction$7
  extends BroadcastReceiver
{
  SSOLoginAction$7(SSOLoginAction paramSSOLoginAction) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    SSOLog.a("SSOLoginAction", new Object[] { "onReceive, intent.getAction : ", paramIntent.getAction() });
    SSOLoginAction.b(this.a);
    if (!"action_login_sucess".equals(paramIntent.getAction())) {
      return;
    }
    if (paramIntent.getBooleanExtra("param_is_qr_code_login", false))
    {
      SSOLoginAction.c(this.a).a(3, paramIntent);
      QIPCClientHelper.getInstance().getClient().callServer("open_sdk_qipc_module", "action_on_qr_code_login_success", new Bundle());
      return;
    }
    paramContext = AuthParamUtil.b(paramIntent, "login_success_uin");
    if (!TextUtils.isEmpty(paramContext)) {
      SSOLoginAction.d(this.a).putExtra("login_success_uin", paramContext);
    }
    boolean bool = SSOLoginAction.d(this.a).getBooleanExtra("intent_router", false);
    paramContext = this.a;
    SSOLoginAction.a(paramContext, bool, SSOLoginAction.d(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.7
 * JD-Core Version:    0.7.0.1
 */