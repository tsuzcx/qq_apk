package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class AppLoadingUI$7
  implements MiniAppCmdInterface
{
  AppLoadingUI$7(AppLoadingUI paramAppLoadingUI, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean)
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      QLog.i("miniapp-start_AppLoadingUI", 1, "getAppInfoById, retCode = " + l + ",errMsg = " + (String)localObject);
      paramJSONObject = (MiniAppInfo)paramJSONObject.opt("mini_app_info_data");
      if (paramJSONObject != null)
      {
        localObject = new MiniAppConfig(paramJSONObject);
        if (this.val$param != null)
        {
          ((MiniAppConfig)localObject).launchParam = this.val$param;
          ((MiniAppConfig)localObject).launchParam.miniAppId = paramJSONObject.appId;
          if (!TextUtils.isEmpty(this.val$param.extendData)) {
            ((MiniAppConfig)localObject).config.extendData = this.val$param.extendData;
          }
        }
        if ((paramJSONObject.verType != 3) && (paramJSONObject.verType != 1)) {
          ((MiniAppConfig)localObject).forceReroad = 3;
        }
        if ((paramJSONObject.firstPage != null) && (((MiniAppConfig)localObject).launchParam != null) && (!TextUtils.isEmpty(paramJSONObject.firstPage.pagePath)))
        {
          if (paramJSONObject.firstPage.pagePath.startsWith("/")) {
            paramJSONObject.firstPage.pagePath = paramJSONObject.firstPage.pagePath.substring(1);
          }
          if (!paramJSONObject.firstPage.pagePath.contains(".html")) {
            break label294;
          }
          ((MiniAppConfig)localObject).launchParam.entryPath = paramJSONObject.firstPage.pagePath;
        }
        for (;;)
        {
          AppLoadingUI.access$002(this.this$0, (MiniAppConfig)localObject);
          this.this$0.getArgumentBundle().putParcelable("CONFIG", AppLoadingUI.access$000(this.this$0));
          MiniAppUtils.notityPullDownEntryInMainProcess(AppLoadingUI.access$000(this.this$0));
          AppLoadingUI.access$500(this.this$0);
          return;
          label294:
          if (paramJSONObject.firstPage.pagePath.contains("?")) {
            ((MiniAppConfig)localObject).launchParam.entryPath = paramJSONObject.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
          } else {
            ((MiniAppConfig)localObject).launchParam.entryPath = (paramJSONObject.firstPage.pagePath + ".html");
          }
        }
      }
      ThreadManager.getUIHandler().post(new AppLoadingUI.7.1(this, (String)localObject, l));
      return;
    }
    ThreadManager.getUIHandler().post(new AppLoadingUI.7.2(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.7
 * JD-Core Version:    0.7.0.1
 */