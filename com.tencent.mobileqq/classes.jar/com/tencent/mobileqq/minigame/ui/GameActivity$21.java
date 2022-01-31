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
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

class GameActivity$21
  implements MiniAppCmdInterface
{
  GameActivity$21(GameActivity paramGameActivity, LaunchParam paramLaunchParam) {}
  
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
        break label292;
      }
      localObject = paramJSONObject.optString("errMsg");
      QLog.i("[minigame] GameActivity", 1, "doRequestByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      if (!paramBoolean) {
        break label342;
      }
      if (paramJSONObject == null) {
        break label385;
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
        if (((MiniAppConfig)localObject).launchParam.reportData == null) {
          ((MiniAppConfig)localObject).launchParam.reportData = new HashMap();
        }
        if (localMiniAppInfo.reportData != null) {
          ((MiniAppConfig)localObject).launchParam.reportData.putAll(localMiniAppInfo.reportData);
        }
        if (localMiniAppInfo.verType != 3) {
          ((MiniAppConfig)localObject).forceReroad = 3;
        }
        MiniAppStartUtils.saveMiniAppInfoToFile((MiniAppConfig)localObject, BaseApplicationImpl.getApplication().getQQProcessName());
        this.this$0.gameConfig = ((MiniAppConfig)localObject);
        MiniAppUtils.notityPullDownEntryInMainProcess((MiniAppConfig)localObject);
        this.this$0.runOnUiThread(new GameActivity.21.1(this));
        return;
        l = 0L;
        break;
        label292:
        localObject = "";
        break label23;
      }
      MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.gameConfig);
      GameActivity.access$2700(this.this$0, l, (String)localObject);
      return;
      label342:
      MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.gameConfig);
      GameActivity.access$2700(this.this$0, l, (String)localObject);
      return;
      label385:
      paramJSONObject = null;
      localMiniAppInfo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.21
 * JD-Core Version:    0.7.0.1
 */