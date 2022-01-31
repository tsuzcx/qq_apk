package com.tencent.mobileqq.minigame.ui;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.launch.MiniAppStartUtils;
import com.tencent.mobileqq.mini.report.MiniAppReportManager2;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class GameActivity$22
  implements MiniAppCmdInterface
{
  GameActivity$22(GameActivity paramGameActivity, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    label23:
    MiniAppInfo localMiniAppInfo;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      if (paramJSONObject == null) {
        break label276;
      }
      localObject = paramJSONObject.optString("errMsg");
      QLog.i("[minigame] GameActivity", 1, "doRequestByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (!paramBoolean) {
        break label382;
      }
      if (paramJSONObject == null) {
        break label425;
      }
      localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("appInfo");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
    }
    for (;;)
    {
      if (localMiniAppInfo != null)
      {
        localObject = new MiniAppConfig(localMiniAppInfo);
        if (this.val$param != null) {
          ((MiniAppConfig)localObject).launchParam = this.val$param;
        }
        ((MiniAppConfig)localObject).launchParam.miniAppId = localMiniAppInfo.appId;
        ((MiniAppConfig)localObject).launchParam.shareTicket = paramJSONObject;
        ((MiniAppConfig)localObject).launchParam.navigateExtData = localMiniAppInfo.extraData;
        if (!TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.shareTicket)) {
          ((MiniAppConfig)localObject).launchParam.scene = 1044;
        }
        if (TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.reportData)) {
          ((MiniAppConfig)localObject).launchParam.reportData = localMiniAppInfo.reportData;
        }
        for (;;)
        {
          if ((localMiniAppInfo.verType != 3) && (localMiniAppInfo.verType != 1)) {
            ((MiniAppConfig)localObject).forceReroad = 3;
          }
          MiniAppStartUtils.saveMiniAppInfoToFile((MiniAppConfig)localObject, BaseApplicationImpl.getApplication().getQQProcessName());
          this.this$0.mGameAppConfig = ((MiniAppConfig)localObject);
          MiniAppUtils.notityPullDownEntryInMainProcess((MiniAppConfig)localObject);
          this.this$0.runOnUiThread(new GameActivity.22.1(this));
          return;
          l = 0L;
          break;
          label276:
          localObject = "";
          break label23;
          if (!TextUtils.isEmpty(localMiniAppInfo.reportData)) {
            ((MiniAppConfig)localObject).launchParam.reportData = (((MiniAppConfig)localObject).launchParam.reportData + "&" + localMiniAppInfo.reportData);
          }
        }
      }
      MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.mGameAppConfig);
      GameActivity.access$3100(this.this$0, l, (String)localObject);
      return;
      label382:
      MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.mGameAppConfig);
      GameActivity.access$3100(this.this$0, l, (String)localObject);
      return;
      label425:
      paramJSONObject = null;
      localMiniAppInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.22
 * JD-Core Version:    0.7.0.1
 */