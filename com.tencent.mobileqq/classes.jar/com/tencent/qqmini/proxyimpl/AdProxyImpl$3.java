package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.manager.MiniLoadingAdManager;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import org.json.JSONException;
import org.json.JSONObject;

class AdProxyImpl$3
  implements MiniAppCmdInterface
{
  AdProxyImpl$3(AdProxyImpl paramAdProxyImpl, String paramString1, String paramString2, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("requestPreloadLoadingAd receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("MiniLoadingAdManager", 1, ((StringBuilder)localObject1).toString());
    if (paramBoolean) {}
    try
    {
      Object localObject2 = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
      i = paramJSONObject.getInt("retCode");
      localObject1 = paramJSONObject.getString("errMsg");
      localObject2 = ((MiniAppAd.StGetAdRsp)localObject2).strAdsJson.get();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("requestPreloadLoadingAd receive retCode= ");
        localStringBuilder.append(i);
        localStringBuilder.append(" errMsg=");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append(" adJson=");
        localStringBuilder.append((String)localObject2);
        QLog.d("MiniLoadingAdManager", 2, localStringBuilder.toString());
      }
      if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject2)))
      {
        MiniLoadingAdManager.downloadAndSaveLoadingAd((String)localObject2, this.jdField_a_of_type_JavaLangString, this.b);
        if (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener != null) {
          this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onPreloadAdReceive(i);
        }
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      int i;
      label191:
      break label191;
    }
    i = -1;
    if (paramJSONObject != null) {
      i = paramJSONObject.optInt("retCode", -1);
    }
    paramJSONObject = this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener;
    if (paramJSONObject != null) {
      paramJSONObject.onPreloadAdReceive(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.3
 * JD-Core Version:    0.7.0.1
 */