package com.tencent.mobileqq.mini.sdk;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.mainpage.MainPageFragment;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

final class MiniAppLauncher$1
  implements MiniAppCmdInterface
{
  MiniAppLauncher$1(String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("appInfo");
      if (localMiniAppInfo != null)
      {
        paramJSONObject = paramJSONObject.optString("shareTicket", "");
        MiniAppConfig localMiniAppConfig = new MiniAppConfig(localMiniAppInfo);
        localMiniAppConfig.launchParam = new LaunchParam();
        localMiniAppConfig.launchParam.miniAppId = localMiniAppInfo.appId;
        localMiniAppConfig.launchParam.shareTicket = paramJSONObject;
        MainPageFragment.launch(BaseActivity.sTopActivity, localMiniAppConfig, localMiniAppInfo.verType);
      }
    }
    else
    {
      AppBrandTask.runTaskOnUiThread(new MiniAppLauncher.1.1(this, paramJSONObject));
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("jumpToDetailPage: launch failed with url ");
      paramJSONObject.append(this.val$url);
      QLog.e("MiniAppLauncher", 1, paramJSONObject.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.sdk.MiniAppLauncher.1
 * JD-Core Version:    0.7.0.1
 */