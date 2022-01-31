package com.tencent.mobileqq.mini.launch;

import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import org.json.JSONObject;

class AppBrandLaunchManager$StartMiniAppReceiver$3
  implements MiniAppCmdInterface
{
  AppBrandLaunchManager$StartMiniAppReceiver$3(AppBrandLaunchManager.StartMiniAppReceiver paramStartMiniAppReceiver, int paramInt) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("appInfo");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      AppBrandLaunchManager.access$500(localMiniAppInfo, this.val$scene, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.launch.AppBrandLaunchManager.StartMiniAppReceiver.3
 * JD-Core Version:    0.7.0.1
 */