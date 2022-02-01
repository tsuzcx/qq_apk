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
      boolean bool;
      if (i == 1) {
        bool = true;
      } else {
        bool = false;
      }
      paramMiniAppControlInfo = Boolean.valueOf(bool);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("SDKDowngradeAction downgrade:");
      ((StringBuilder)localObject).append(i);
      QLog.d("SDKDowngradeAction", 1, ((StringBuilder)localObject).toString());
      if (MiniSdkUtil.a() != paramMiniAppControlInfo.booleanValue())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SDKDowngradeAction do downgrade:");
        ((StringBuilder)localObject).append(i);
        QLog.d("SDKDowngradeAction", 1, ((StringBuilder)localObject).toString());
        localObject = new Intent("com.tencent.mobile.mini.process.exit");
        ((Intent)localObject).setPackage("com.tencent.mobileqq");
        BaseApplication.getContext().sendBroadcast((Intent)localObject);
        MiniSdkUtil.b(paramMiniAppControlInfo.booleanValue());
        ThreadManager.getSubThreadHandler().postDelayed(new SDKDowngradeAction.1(this), 3000L);
        return;
      }
      paramMiniAppControlInfo = new StringBuilder();
      paramMiniAppControlInfo.append("SDKDowngradeAction not do downgrade:");
      paramMiniAppControlInfo.append(i);
      QLog.d("SDKDowngradeAction", 1, paramMiniAppControlInfo.toString());
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("UploadLogAction has no appid parameter! ");
    ((StringBuilder)localObject).append(paramMiniAppControlInfo);
    QLog.d("SDKDowngradeAction", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.push.SDKDowngradeAction
 * JD-Core Version:    0.7.0.1
 */