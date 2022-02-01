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
    if ((paramBoolean) && (paramJSONObject != null)) {
      try
      {
        Object localObject2 = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
        int i = paramJSONObject.getInt("retCode");
        Object localObject1 = paramJSONObject.getString("errMsg");
        paramJSONObject = ((MiniAppAd.StGetAdRsp)localObject2).strAdsJson.get();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("selectAd receive retCode= ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" errMsg=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.d("MiniLoadingAdManager", 1, ((StringBuilder)localObject2).toString());
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("adJson=");
          ((StringBuilder)localObject1).append(paramJSONObject);
          QLog.d("AdProxyImpl", 2, ((StringBuilder)localObject1).toString());
        }
        if ((i == 0) && (!TextUtils.isEmpty(paramJSONObject)))
        {
          localObject1 = AdUtils.convertJson2GdtAds(paramJSONObject);
          if ((localObject1 != null) && (((List)localObject1).size() > 0))
          {
            localObject1 = (GdtAd)((List)localObject1).get(0);
            if ((localObject1 != null) && (((GdtAd)localObject1).info != null) && (((GdtAd)localObject1).info.report_info != null) && (((GdtAd)localObject1).info.report_info.trace_info != null))
            {
              long l = ((GdtAd)localObject1).info.report_info.trace_info.aid.get();
              this.a.onSelectAdProcessDone(paramJSONObject, l);
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
    paramJSONObject = this.a;
    if (paramJSONObject != null) {
      paramJSONObject.onSelectAdProcessDone(null, -1L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.AdProxyImpl.2
 * JD-Core Version:    0.7.0.1
 */