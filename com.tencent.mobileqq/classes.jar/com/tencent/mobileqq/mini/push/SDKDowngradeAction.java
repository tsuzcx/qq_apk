package com.tencent.mobileqq.mini.push;

import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.proxyimpl.MiniSdkUtil;
import java.util.Map;
import mqq.os.MqqHandler;

public class SDKDowngradeAction
  implements PushAction
{
  public static final String KEY_DOWNGRADE = "downgrade";
  public static final String TAG = "SDKDowngradeAction";
  
  public void exec(MiniAppControlInfo paramMiniAppControlInfo)
  {
    if (paramMiniAppControlInfo.data.containsKey("downgrade"))
    {
      int i = Integer.parseInt((String)paramMiniAppControlInfo.data.get("downgrade"));
      if (i == 1) {}
      for (boolean bool = true;; bool = false)
      {
        paramMiniAppControlInfo = Boolean.valueOf(bool);
        QLog.d("SDKDowngradeAction", 1, "SDKDowngradeAction downgrade:" + i);
        if (MiniSdkUtil.a() == paramMiniAppControlInfo.booleanValue()) {
          break;
        }
        QLog.d("SDKDowngradeAction", 1, "SDKDowngradeAction do downgrade:" + i);
        Intent localIntent = new Intent("com.tencent.mobile.mini.process.exit");
        localIntent.setPackage("com.tencent.mobileqq");
        BaseApplication.getContext().sendBroadcast(localIntent);
        MiniSdkUtil.a(paramMiniAppControlInfo.booleanValue());
        ThreadManager.getSubThreadHandler().postDelayed(new SDKDowngradeAction.1(this), 3000L);
        return;
      }
      QLog.d("SDKDowngradeAction", 1, "SDKDowngradeAction not do downgrade:" + i);
      return;
    }
    QLog.d("SDKDowngradeAction", 1, "UploadLogAction has no appid parameter! " + paramMiniAppControlInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.SDKDowngradeAction
 * JD-Core Version:    0.7.0.1
 */