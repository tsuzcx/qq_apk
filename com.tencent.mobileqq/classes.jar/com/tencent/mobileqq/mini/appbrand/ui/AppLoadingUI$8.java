package com.tencent.mobileqq.mini.appbrand.ui;

import android.os.Bundle;
import android.text.TextUtils;
import bhpc;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.FirstPageInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.mini.entry.MiniAppUtils;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class AppLoadingUI$8
  implements MiniAppCmdInterface
{
  AppLoadingUI$8(AppLoadingUI paramAppLoadingUI, LaunchParam paramLaunchParam) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null))
    {
      long l = paramJSONObject.optLong("retCode");
      Object localObject = paramJSONObject.optString("errMsg");
      QLog.d("miniapp-start_AppLoadingUI", 2, "getAppInfoByLink, retCode = " + l + ",errMsg = " + (String)localObject);
      MiniAppInfo localMiniAppInfo = (MiniAppInfo)paramJSONObject.opt("appInfo");
      paramJSONObject = paramJSONObject.optString("shareTicket", "");
      if ((l == 0L) && (localMiniAppInfo != null) && (!TextUtils.isEmpty(localMiniAppInfo.appId)))
      {
        localObject = new MiniAppConfig(localMiniAppInfo);
        if (this.val$param == null)
        {
          ((MiniAppConfig)localObject).launchParam = new LaunchParam();
          ((MiniAppConfig)localObject).launchParam.miniAppId = localMiniAppInfo.appId;
          ((MiniAppConfig)localObject).launchParam.shareTicket = paramJSONObject;
          ((MiniAppConfig)localObject).launchParam.navigateExtData = localMiniAppInfo.extraData;
          if (!TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.shareTicket)) {
            ((MiniAppConfig)localObject).launchParam.scene = 1044;
          }
          if (!TextUtils.isEmpty(((MiniAppConfig)localObject).launchParam.reportData)) {
            break label441;
          }
          ((MiniAppConfig)localObject).launchParam.reportData = localMiniAppInfo.reportData;
          label217:
          if ((localMiniAppInfo.verType != 3) && (localMiniAppInfo.verType != 1)) {
            ((MiniAppConfig)localObject).forceReroad = 3;
          }
          if ((localMiniAppInfo.firstPage != null) && (((MiniAppConfig)localObject).launchParam != null) && (!TextUtils.isEmpty(localMiniAppInfo.firstPage.pagePath)))
          {
            if (localMiniAppInfo.firstPage.pagePath.startsWith("/")) {
              localMiniAppInfo.firstPage.pagePath = localMiniAppInfo.firstPage.pagePath.substring(1);
            }
            if (!localMiniAppInfo.firstPage.pagePath.contains(".html")) {
              break label497;
            }
            ((MiniAppConfig)localObject).launchParam.entryPath = localMiniAppInfo.firstPage.pagePath;
          }
        }
        for (;;)
        {
          if (localMiniAppInfo.clearAuths == 1)
          {
            l = bhpc.a().a();
            if (l > 0L)
            {
              AuthorizeCenter.clearAuth(localMiniAppInfo.appId, String.valueOf(l));
              ((MiniAppConfig)localObject).config.clearAuths = 0;
            }
          }
          try
          {
            AppLoadingUI.access$002(this.this$0, (MiniAppConfig)localObject);
            this.this$0.getArgumentBundle().putParcelable("CONFIG", AppLoadingUI.access$000(this.this$0));
            MiniAppUtils.notityPullDownEntryInMainProcess(AppLoadingUI.access$000(this.this$0));
            AppLoadingUI.access$500(this.this$0);
            return;
          }
          catch (Throwable paramJSONObject)
          {
            QLog.e("miniapp-start_AppLoadingUI", 1, "MiniAppController.startApp exception ", paramJSONObject);
            return;
          }
          ((MiniAppConfig)localObject).launchParam = this.val$param;
          break;
          label441:
          if (TextUtils.isEmpty(localMiniAppInfo.reportData)) {
            break label217;
          }
          ((MiniAppConfig)localObject).launchParam.reportData = (((MiniAppConfig)localObject).launchParam.reportData + "&" + localMiniAppInfo.reportData);
          break label217;
          label497:
          if (localMiniAppInfo.firstPage.pagePath.contains("?")) {
            ((MiniAppConfig)localObject).launchParam.entryPath = localMiniAppInfo.firstPage.pagePath.replaceFirst("\\?", ".html\\?");
          } else {
            ((MiniAppConfig)localObject).launchParam.entryPath = (localMiniAppInfo.firstPage.pagePath + ".html");
          }
        }
      }
      ThreadManager.getUIHandler().post(new AppLoadingUI.8.1(this, (String)localObject, l));
      return;
    }
    ThreadManager.getUIHandler().post(new AppLoadingUI.8.2(this, paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.ui.AppLoadingUI.8
 * JD-Core Version:    0.7.0.1
 */