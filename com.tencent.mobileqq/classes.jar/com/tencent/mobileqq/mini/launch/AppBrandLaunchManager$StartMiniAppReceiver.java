package com.tencent.mobileqq.mini.launch;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class AppBrandLaunchManager$StartMiniAppReceiver
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("opType");
    String str1 = paramIntent.getStringExtra("appid");
    String str3 = paramIntent.getStringExtra("fakeUrl");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("miniapp.debugger receiver opType:");
    localStringBuilder.append(str2);
    localStringBuilder.append(" appid:");
    localStringBuilder.append(str1);
    localStringBuilder.append(" fakeUrl:");
    localStringBuilder.append(str3);
    QLog.i("miniapp-process_AppBrandLaunchManager", 1, localStringBuilder.toString());
    if ("op-clear".equals(str2))
    {
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("miniapp-process_AppBrandLaunchManager", 2, "appid is null, return.");
        return;
      }
      ThreadManagerV2.executeOnSubThread(new AppBrandLaunchManager.StartMiniAppReceiver.1(this, str1, paramContext, paramIntent.getStringExtra("uin")));
      return;
    }
    if ("op-miniapp".equals(str2))
    {
      int i = paramIntent.getIntExtra("scene", 0);
      if (!TextUtils.isEmpty(str1))
      {
        paramContext = new ArrayList();
        paramContext.add(str1);
        MiniAppCmdUtil.getInstance().getBatchQueryAppInfo(null, paramContext, new AppBrandLaunchManager.StartMiniAppReceiver.2(this, i));
        return;
      }
      if (!TextUtils.isEmpty(str3)) {
        MiniAppCmdUtil.getInstance().getAppInfoByLink(str3, 0, new AppBrandLaunchManager.StartMiniAppReceiver.3(this, i));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver
 * JD-Core Version:    0.7.0.1
 */