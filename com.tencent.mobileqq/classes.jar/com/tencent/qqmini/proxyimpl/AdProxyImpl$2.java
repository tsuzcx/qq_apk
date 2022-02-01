package com.tencent.qqmini.proxyimpl;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ILoadingAdListener;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

class AdProxyImpl$2
  implements MiniAppCmdInterface
{
  AdProxyImpl$2(AdProxyImpl paramAdProxyImpl, AdProxy.ILoadingAdListener paramILoadingAdListener) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if ((paramBoolean) && (paramJSONObject != null)) {}
    while (this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener == null) {
      try
      {
        Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("retCode");
        String str = paramJSONObject.getString("errMsg");
        paramJSONObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
        QLog.d("MiniLoadingAdManager", 1, "selectAd receive retCode= " + i + " errMsg=" + str);
        if (QLog.isColorLevel()) {
          QLog.d("AdProxyImpl", 2, "adJson=" + paramJSONObject);
        }
        if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          localObject = AdUtils.convertJson2GdtAds(paramJSONObject);
          if ((localObject != null) && (((List)localObject).size() > 0))
          {
            localObject = (GdtAd)((List)localObject).get(0);
            if ((localObject != null) && (((GdtAd)localObject).info != null) && (((GdtAd)localObject).info.report_info != null) && (((GdtAd)localObject).info.report_info.trace_info != null))
            {
              long l = ((GdtAd)localObject).info.report_info.trace_info.aid.get();
              this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onSelectAdProcessDone(paramJSONObject, l);
              return;
            }
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        QLog.e("MiniLoadingAdManager", 1, "selectAd getRewardedVideoADInfo error", paramJSONObject);
      }
    }
    this.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$ILoadingAdListener.onSelectAdProcessDone(null, -1L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */