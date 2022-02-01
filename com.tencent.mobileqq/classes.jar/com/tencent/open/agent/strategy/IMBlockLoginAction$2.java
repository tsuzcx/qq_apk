package com.tencent.open.agent.strategy;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.open.agent.util.AuthorityUtil;
import com.tencent.open.agent.util.SSOLog;

class IMBlockLoginAction$2
  extends BroadcastReceiver
{
  IMBlockLoginAction$2(IMBlockLoginAction paramIMBlockLoginAction, Activity paramActivity) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent == null)
    {
      SSOLog.a("IMBlockLoginAction", new Object[] { "mPuzzleVerifyCodeReceiver onReceive null == intent" });
      return;
    }
    SSOLog.a("IMBlockLoginAction", new Object[] { "mPuzzleVerifyCodeReceiver onReceive" });
    AuthorityUtil.a(paramIntent, paramContext);
    IMBlockLoginAction.a(this.jdField_a_of_type_ComTencentOpenAgentStrategyIMBlockLoginAction, this.jdField_a_of_type_AndroidAppActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.strategy.IMBlockLoginAction.2
 * JD-Core Version:    0.7.0.1
 */