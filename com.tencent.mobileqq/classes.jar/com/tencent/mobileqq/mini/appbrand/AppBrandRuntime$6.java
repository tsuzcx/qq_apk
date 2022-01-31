package com.tencent.mobileqq.mini.appbrand;

import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage;
import com.tencent.mobileqq.mini.appbrand.page.AppBrandPageContainer;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandUtil;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import org.json.JSONObject;

class AppBrandRuntime$6
  implements Runnable
{
  AppBrandRuntime$6(AppBrandRuntime paramAppBrandRuntime) {}
  
  public void run()
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      localJSONObject1.put("miniAppId", this.this$0.apkgInfo.appId);
      localJSONObject1.put("scene", this.this$0.apkgInfo.appConfig.launchParam.scene);
      localJSONObject2.put("page", AppBrandUtil.getUrlWithoutParams(this.this$0.pageContainer.getCurrentPage().getUrl()));
      this.this$0.mReportSeqNo = VACDReportUtil.a(localJSONObject1.toString(), "MiniAppStat", "MiniAppVisitReport", "PageVisit", localJSONObject2.toString(), 0, null);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.AppBrandRuntime.6
 * JD-Core Version:    0.7.0.1
 */