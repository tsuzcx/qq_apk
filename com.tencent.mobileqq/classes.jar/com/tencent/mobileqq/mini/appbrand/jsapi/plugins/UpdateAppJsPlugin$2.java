package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Intent;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.sdk.MiniAppController.ActivityResultListener;
import com.tencent.qphone.base.util.QLog;

class UpdateAppJsPlugin$2
  implements MiniAppController.ActivityResultListener
{
  UpdateAppJsPlugin$2(UpdateAppJsPlugin paramUpdateAppJsPlugin, UpdateAppJsPlugin.IAppUpdateListener paramIAppUpdateListener) {}
  
  public boolean doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    MiniAppController.getInstance().removeActivityResultListener(this);
    boolean bool;
    if (paramInt1 == 1003)
    {
      if ((paramInt2 != -1) || (paramIntent == null)) {
        break label86;
      }
      bool = paramIntent.getBooleanExtra("getUpgradeInfo", true);
      if (!bool) {
        break label54;
      }
      paramIntent = "最新版本无需更新";
    }
    for (;;)
    {
      this.val$listener.onGetAppUpdateResult(bool, paramIntent);
      return true;
      label54:
      paramIntent = "获取版本信息失败";
      QLog.d("UpdateAppJsPlugin", 1, "getUpgradeInfo: " + bool);
    }
    label86:
    this.val$listener.onGetAppUpdateResult(true, "版本过低需要更新");
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.UpdateAppJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */