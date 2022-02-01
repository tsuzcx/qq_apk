package com.tencent.mobileqq.mini.launch;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class AppBrandLaunchManager$9
  implements MiniAppCmdInterface
{
  AppBrandLaunchManager$9(AppBrandLaunchManager paramAppBrandLaunchManager, IMiniCallback paramIMiniCallback) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      AppBrandLaunchManager.access$400(this.this$0, -1, "request MiniAppInfo error! ret is null.", this.val$miniCallback);
      return;
    }
    if (paramBoolean)
    {
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        MiniSdkLauncher.preDownloadPkg(BaseApplicationImpl.getContext(), new MiniAppConfig(paramJSONObject), this.val$miniCallback);
        return;
      }
      AppBrandLaunchManager.access$400(this.this$0, -1, "request MiniAppInfo error! appInfo is null.", this.val$miniCallback);
      return;
    }
    int i = (int)paramJSONObject.optLong("retCode");
    paramJSONObject = paramJSONObject.optString("errMsg");
    AppBrandLaunchManager.access$400(this.this$0, i, paramJSONObject, this.val$miniCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.9
 * JD-Core Version:    0.7.0.1
 */