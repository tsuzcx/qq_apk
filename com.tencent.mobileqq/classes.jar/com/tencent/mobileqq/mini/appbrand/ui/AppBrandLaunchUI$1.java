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
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject1 = paramJSONObject.optString("errMsg");
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getAppInfoById, retCode = ");
      ((StringBuilder)localObject2).append(l);
      ((StringBuilder)localObject2).append(",errMsg = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("miniapp-start_AppBrandLaunchUI", 1, ((StringBuilder)localObject2).toString());
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        localObject1 = new MiniAppConfig(paramJSONObject);
        localObject2 = this.val$param;
        if (localObject2 != null)
        {
          ((MiniAppConfig)localObject1).launchParam = ((LaunchParam)localObject2);
          ((MiniAppConfig)localObject1).launchParam.miniAppId = paramJSONObject.appId;
        }
        if ((paramJSONObject.verType != 3) && (paramJSONObject.verType != 1)) {
          ((MiniAppConfig)localObject1).launchParam.forceReload = 3;
        }
        AppBrandLaunchUI.access$000(this.this$0, (MiniAppConfig)localObject1);
      }
      else
      {
        ThreadManager.getUIHandler().post(new AppBrandLaunchUI.1.1(this, (String)localObject1, l));
      }
    }
    else
    {
      ThreadManager.getUIHandler().post(new AppBrandLaunchUI.1.2(this, paramJSONObject));
    }
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppBrandLaunchUI.1
 * JD-Core Version:    0.7.0.1
 */