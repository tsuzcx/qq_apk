package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.report.MiniProgramLpReportDC04239;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class MiniLoadingAdManager$5
  implements MiniAppCmdInterface
{
  MiniLoadingAdManager$5(long paramLong, MiniAppConfig paramMiniAppConfig, String paramString) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniLoadingAdManager", 1, "预加载接口 receive isSuc= " + paramBoolean);
    if ((paramBoolean) && (paramJSONObject != null)) {}
    for (;;)
    {
      try
      {
        Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
        i = paramJSONObject.getInt("retCode");
        String str = paramJSONObject.getString("errMsg");
        localObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
        QLog.d("MiniLoadingAdManager", 1, "预加载接口 receive retCode= " + i + " errMsg=" + str + " adJson=" + (String)localObject);
        if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
        {
          long l1 = System.currentTimeMillis();
          long l2 = this.val$preloadStartTime;
          MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "preload_success", String.valueOf(l1 - l2));
          MiniLoadingAdManager.downloadAndSaveLoadingAd((String)localObject, this.val$uin, this.val$miniAppConfig.config.appId);
          MiniLoadingAdManager.access$200(this.val$miniAppConfig.config.appId, this.val$uin, 1);
          MiniLoadingAdManager.access$300(this.val$miniAppConfig.config.appId, this.val$uin);
          return;
        }
        if (paramJSONObject != null)
        {
          i = paramJSONObject.optInt("retCode", -1);
          MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "preload_fail", i + "");
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        return;
      }
      int i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.5
 * JD-Core Version:    0.7.0.1
 */