package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$2
  implements MiniAppInfoLoadingFragment.OnGetMiniAppInfoListener
{
  MiniAppInfoLoadingFragment$2(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, LaunchParam paramLaunchParam, String paramString1, String paramString2, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString3, String paramString4) {}
  
  public void onGetMiniAppInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, MiniAppInfo paramMiniAppInfo, String paramString1, long paramLong, String paramString2)
  {
    MiniAppInfoLoadingFragment.access$100(this.this$0, paramLong, paramString2, paramMiniAppInfo, this.val$param, this.val$customInfo);
    MiniAppInfoLoadingFragment.access$000(this.this$0, paramJSONObject, paramArrayOfByte, this.val$finalEnvVersion, this.val$cacheProxy, this.val$appid, this.val$finalEntryPath);
    MiniReportManager.reportEventType(paramMiniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(paramMiniAppInfo));
    MiniAppInfoLoadingFragment.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.2
 * JD-Core Version:    0.7.0.1
 */