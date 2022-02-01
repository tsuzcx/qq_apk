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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("预加载接口 receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("MiniLoadingAdManager", 1, ((StringBuilder)localObject1).toString());
    if ((paramBoolean) && (paramJSONObject != null)) {}
    try
    {
      Object localObject2 = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("retCode");
      localObject1 = paramJSONObject.getString("errMsg");
      localObject2 = ((MiniAppAd.StGetAdRsp)localObject2).strAdsJson.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("预加载接口 receive retCode= ");
      localStringBuilder.append(i);
      localStringBuilder.append(" errMsg=");
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" adJson=");
      localStringBuilder.append((String)localObject2);
      QLog.d("MiniLoadingAdManager", 1, localStringBuilder.toString());
      if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        long l1 = System.currentTimeMillis();
        long l2 = this.val$preloadStartTime;
        MiniProgramLpReportDC04239.reportMiniAppEvent(this.val$miniAppConfig, MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig), null, "ad", "ad_loading", "preload_success", String.valueOf(l1 - l2));
        MiniLoadingAdManager.downloadAndSaveLoadingAd((String)localObject2, this.val$uin, this.val$miniAppConfig.config.appId);
        MiniLoadingAdManager.access$200(this.val$miniAppConfig.config.appId, this.val$uin, 1);
        MiniLoadingAdManager.access$300(this.val$miniAppConfig.config.appId, this.val$uin);
        return;
      }
      i = -1;
      if (paramJSONObject != null) {
        i = paramJSONObject.optInt("retCode", -1);
      }
      paramJSONObject = this.val$miniAppConfig;
      localObject1 = MiniProgramLpReportDC04239.getAppType(this.val$miniAppConfig);
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append("");
      MiniProgramLpReportDC04239.reportMiniAppEvent(paramJSONObject, (String)localObject1, null, "ad", "ad_loading", "preload_fail", ((StringBuilder)localObject2).toString());
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.5
 * JD-Core Version:    0.7.0.1
 */