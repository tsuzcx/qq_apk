package com.tencent.mobileqq.minigame.ui;

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

class GameActivity$20
  implements MiniAppCmdInterface
{
  GameActivity$20(GameActivity paramGameActivity, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      if (paramJSONObject == null) {
        break label229;
      }
      localObject = paramJSONObject.optString("errMsg");
      label23:
      QLog.i("[minigame] GameActivity", 1, "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      if (!paramBoolean) {
        break label279;
      }
      if (paramJSONObject == null) {
        break label322;
      }
    }
    label279:
    label322:
    for (paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");; paramJSONObject = null)
    {
      if (paramJSONObject != null)
      {
        localObject = new MiniAppConfig(paramJSONObject);
        if (this.val$param != null)
        {
          ((MiniAppConfig)localObject).launchParam = this.val$param;
          ((MiniAppConfig)localObject).launchParam.miniAppId = paramJSONObject.appId;
        }
        if (((MiniAppConfig)localObject).launchParam.reportData == null) {
          ((MiniAppConfig)localObject).launchParam.reportData = new HashMap();
        }
        if (paramJSONObject.reportData != null) {
          ((MiniAppConfig)localObject).launchParam.reportData.putAll(paramJSONObject.reportData);
        }
        if (paramJSONObject.verType != 3) {
          ((MiniAppConfig)localObject).forceReroad = 3;
        }
        MiniAppStartUtils.saveMiniAppInfoToFile((MiniAppConfig)localObject, BaseApplicationImpl.getApplication().getQQProcessName());
        this.this$0.gameConfig = ((MiniAppConfig)localObject);
        MiniAppUtils.notityPullDownEntryInMainProcess((MiniAppConfig)localObject);
        this.this$0.runOnUiThread(new GameActivity.20.1(this));
        return;
        l = 0L;
        break;
        label229:
        localObject = "";
        break label23;
      }
      MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.gameConfig);
      GameActivity.access$2700(this.this$0, l, (String)localObject);
      return;
      MiniProgramLpReportDC04239.reportPageView(this.this$0.gameConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.gameConfig);
      GameActivity.access$2700(this.this$0, l, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.20
 * JD-Core Version:    0.7.0.1
 */