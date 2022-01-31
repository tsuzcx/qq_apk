package com.tencent.mobileqq.mini.appbrand.ui;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class AppBrandLaunchUI$1
  implements MiniAppCmdInterface
{
  AppBrandLaunchUI$1(AppBrandLaunchUI paramAppBrandLaunchUI, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    if (paramBoolean)
    {
      l = paramJSONObject.optLong("retCode");
      localObject = paramJSONObject.optString("errMsg");
      QLog.i("miniapp-start_AppBrandLaunchUI", 1, "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        localObject = new MiniAppConfig(paramJSONObject);
        if (this.val$param != null)
        {
          ((MiniAppConfig)localObject).launchParam = this.val$param;
          ((MiniAppConfig)localObject).launchParam.miniAppId = paramJSONObject.appId;
        }
        if ((paramJSONObject.verType != 3) && (paramJSONObject.verType != 1)) {
          ((MiniAppConfig)localObject).forceReroad = 3;
        }
        AppBrandLaunchUI.access$000(this.this$0, (MiniAppConfig)localObject);
      }
    }
    for (;;)
    {
      this.this$0.finish();
      return;
      ThreadManager.getUIHandler().post(new AppBrandLaunchUI.1.1(this, (String)localObject, l));
      continue;
      ThreadManager.getUIHandler().post(new AppBrandLaunchUI.1.2(this, paramJSONObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI.1
 * JD-Core Version:    0.7.0.1
 */