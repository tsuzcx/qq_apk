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

class GameActivity$21
  implements MiniAppCmdInterface
{
  GameActivity$21(GameActivity paramGameActivity, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    long l;
    Object localObject;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      if (paramJSONObject == null) {
        break label213;
      }
      localObject = paramJSONObject.optString("errMsg");
      label23:
      QLog.i("[minigame] GameActivity", 1, "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      if (!paramBoolean) {
        break label317;
      }
      if (paramJSONObject == null) {
        break label360;
      }
    }
    label213:
    label360:
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
        if (TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.reportData)) {
          ((MiniAppConfig)localObject).launchParam.reportData = paramJSONObject.reportData;
        }
        for (;;)
        {
          if ((paramJSONObject.verType != 3) && (paramJSONObject.verType != 1)) {
            ((MiniAppConfig)localObject).forceReroad = 3;
          }
          MiniAppStartUtils.saveMiniAppInfoToFile((MiniAppConfig)localObject, BaseApplicationImpl.getApplication().getQQProcessName());
          this.this$0.mGameAppConfig = ((MiniAppConfig)localObject);
          MiniAppUtils.notityPullDownEntryInMainProcess((MiniAppConfig)localObject);
          this.this$0.runOnUiThread(new GameActivity.21.1(this));
          return;
          l = 0L;
          break;
          localObject = "";
          break label23;
          if (!TextUtils.isEmpty(paramJSONObject.reportData)) {
            ((MiniAppConfig)localObject).launchParam.reportData = (((MiniAppConfig)localObject).launchParam.reportData + "&" + paramJSONObject.reportData);
          }
        }
      }
      MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.mGameAppConfig);
      GameActivity.access$3100(this.this$0, l, (String)localObject);
      return;
      MiniProgramLpReportDC04239.reportPageView(this.this$0.mGameAppConfig, "1", null, "load_fail", "shortcut_request_fail");
      MiniAppReportManager2.reportPageView("2launch_fail", "shotcut_request_fail", null, this.this$0.mGameAppConfig);
      GameActivity.access$3100(this.this$0, l, (String)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.21
 * JD-Core Version:    0.7.0.1
 */