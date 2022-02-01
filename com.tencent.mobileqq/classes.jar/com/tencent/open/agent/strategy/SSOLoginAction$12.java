package com.tencent.open.agent.strategy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.open.agent.util.SSOLog;

class SSOLoginAction$12
  extends BroadcastReceiver
{
  SSOLoginAction$12(SSOLoginAction paramSSOLoginAction, Bundle paramBundle, String paramString) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      SSOLog.a("SSOLoginAction", new Object[] { "registerExpiredReceiver onReceive null == intent" });
      return;
    }
    paramContext = paramIntent.getStringExtra("serviceCmd");
    SSOLog.a("SSOLoginAction", new Object[] { "registerExpiredReceiver onReceive serviceCmd=", paramContext });
    if (!"QQConnectLogin.pre_auth".equals(paramContext)) {
      return;
    }
    SSOLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategySSOLoginAction);
    SSOLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategySSOLoginAction, this.jdField_a_of_type_AndroidOsBundle, this.jdField_a_of_type_JavaLangString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.SSOLoginAction.12
 * JD-Core Version:    0.7.0.1
 */