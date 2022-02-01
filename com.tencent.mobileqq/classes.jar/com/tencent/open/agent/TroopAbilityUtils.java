package com.tencent.open.agent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopAbilityUtils
{
  public static void a(Activity paramActivity, Intent paramIntent, boolean paramBoolean)
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
      String str1 = paramIntent.getString("appid");
      paramIntent.getString("app_name");
      String str2 = paramIntent.getString("pkg_name");
      int i = paramIntent.getInt("action");
      localObject = "bindGroup";
      if (i == 1) {
        paramIntent = HardCodeUtil.a(2131714906);
      }
      for (;;)
      {
        break;
        if (i == 2)
        {
          paramIntent = HardCodeUtil.a(2131714907);
        }
        else
        {
          if (i != 3) {
            return;
          }
          paramIntent = HardCodeUtil.a(2131714918);
          localObject = "joinGroup";
        }
      }
      if (paramActivity.isFinishing()) {
        return;
      }
      ThreadManager.getUIHandler().postDelayed(new TroopAbilityUtils.1(paramActivity, paramBoolean, str1, (String)localObject, str2, paramIntent), 300L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.agent.TroopAbilityUtils
 * JD-Core Version:    0.7.0.1
 */