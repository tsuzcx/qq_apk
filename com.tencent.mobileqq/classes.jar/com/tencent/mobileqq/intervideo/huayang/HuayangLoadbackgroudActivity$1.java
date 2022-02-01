package com.tencent.mobileqq.intervideo.huayang;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

final class HuayangLoadbackgroudActivity$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IHuayangPluginLauncher", 2, "onReceive ACTION_FORCE_UPDATE");
    }
    if (TextUtils.equals(paramIntent.getAction(), "action_iv_plugin_update"))
    {
      paramIntent = (InstalledPlugin)paramIntent.getSerializableExtra("plugin");
      if (paramIntent != null)
      {
        boolean bool = ((IHuayangPluginLauncher)QRoute.api(IHuayangPluginLauncher.class)).getInstance(paramContext, paramIntent).isStartPluginCalled();
        if (QLog.isColorLevel())
        {
          paramContext = new StringBuilder();
          paramContext.append("onReceive isCalled:");
          paramContext.append(bool);
          QLog.d("IHuayangPluginLauncher", 2, paramContext.toString());
        }
        if (!bool)
        {
          HuayangLoadbackgroudActivity.a = 0L;
          Process.killProcess(Process.myPid());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.huayang.HuayangLoadbackgroudActivity.1
 * JD-Core Version:    0.7.0.1
 */