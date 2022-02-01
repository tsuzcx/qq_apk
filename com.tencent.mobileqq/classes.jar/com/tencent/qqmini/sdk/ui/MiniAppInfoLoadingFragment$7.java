package com.tencent.qqmini.sdk.ui;

import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppCacheProxy;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.report.MiniReportManager;
import org.json.JSONObject;

class MiniAppInfoLoadingFragment$7
  implements MiniAppInfoLoadingFragment.OnGetMiniAppInfoListener
{
  MiniAppInfoLoadingFragment$7(MiniAppInfoLoadingFragment paramMiniAppInfoLoadingFragment, LaunchParam paramLaunchParam, String paramString1, MiniAppCacheProxy paramMiniAppCacheProxy, String paramString2, int paramInt) {}
  
  public void onGetMiniAppInfo(JSONObject paramJSONObject, byte[] paramArrayOfByte, MiniAppInfo paramMiniAppInfo, String paramString1, long paramLong, String paramString2)
  {
    MiniAppInfoLoadingFragment.access$500(this.this$0, paramLong, paramString2, paramMiniAppInfo, paramString1, this.val$param, this.val$customInfo);
    MiniAppInfoLoadingFragment.access$400(this.this$0, paramJSONObject, paramArrayOfByte, paramString1, this.val$cacheProxy, this.val$link, this.val$linkType);
    MiniReportManager.reportEventType(paramMiniAppInfo, 1028, "main_loading", MiniReportManager.getAppType(paramMiniAppInfo));
    MiniAppInfoLoadingFragment.access$200(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.ui.MiniAppInfoLoadingFragment.7
 * JD-Core Version:    0.7.0.1
 */