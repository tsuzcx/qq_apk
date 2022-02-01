package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.guild.api.IGuildOpenApi;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopAbilityUtils
{
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, Intent paramIntent, boolean paramBoolean)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onThirdAppJoinAppFinished activity is null: ");
    boolean bool;
    if (paramActivity == null) {
      bool = true;
    } else {
      bool = false;
    }
    ((StringBuilder)localObject).append(bool);
    QLog.i("TroopAbility.Utils", 1, ((StringBuilder)localObject).toString());
    if ((paramActivity != null) && (paramIntent != null))
    {
      if (paramIntent.getExtras() == null) {
        return;
      }
      paramIntent = paramIntent.getExtras();
      if (!paramIntent.getBoolean("fromThirdAppByOpenSDK")) {
        return;
      }
      localObject = paramIntent.getString("appid");
      paramIntent.getString("app_name");
      String str = paramIntent.getString("pkg_name");
      int i = paramIntent.getInt("action");
      if (i == 1) {}
      for (paramQQAppInterface = HardCodeUtil.a(2131912404);; paramQQAppInterface = HardCodeUtil.a(2131912405))
      {
        paramIntent = "bindGroup";
        break label159;
        if (i != 2) {
          break;
        }
      }
      if (i == 3)
      {
        paramQQAppInterface = HardCodeUtil.a(2131912416);
        paramIntent = "joinGroup";
        label159:
        if (paramActivity.isFinishing()) {
          return;
        }
        ThreadManager.getUIHandler().postDelayed(new TroopAbilityUtils.1(paramActivity, paramBoolean, (String)localObject, paramIntent, str, paramQQAppInterface), 300L);
        return;
      }
      if (i == 4) {
        ((IGuildOpenApi)paramQQAppInterface.getRuntimeService(IGuildOpenApi.class, "")).handleTroopBackToAppDialog(paramActivity, paramIntent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityUtils
 * JD-Core Version:    0.7.0.1
 */