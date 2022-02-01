package com.tencent.mobileqq.mini.manager;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo.TraceInfo;

class MiniLoadingAdManager$1$1
  implements MiniAppCmdInterface
{
  MiniLoadingAdManager$1$1(MiniLoadingAdManager.1 param1) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramBoolean) {}
    try
    {
      Object localObject = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
      int i = paramJSONObject.getInt("retCode");
      paramJSONObject = paramJSONObject.getString("errMsg");
      localObject = ((MiniAppAd.StGetAdRsp)localObject).strAdsJson.get();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("选单接口 receive retCode= ");
      localStringBuilder.append(i);
      localStringBuilder.append(" errMsg=");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append(" adJson=");
      localStringBuilder.append((String)localObject);
      QLog.d("MiniLoadingAdManager", 1, localStringBuilder.toString());
      if ((i == 0) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramJSONObject = AdUtils.convertJson2GdtAds((String)localObject);
        if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
        {
          paramJSONObject = (GdtAd)paramJSONObject.get(0);
          if ((paramJSONObject != null) && (paramJSONObject.info != null) && (paramJSONObject.info.report_info != null) && (paramJSONObject.info.report_info.trace_info != null))
          {
            long l = paramJSONObject.info.report_info.trace_info.aid.get();
            localObject = (String)MiniLoadingAdManager.access$100().get(Long.valueOf(l));
            this.this$1.val$onChooseAdEndListener.onChooseAdEnd((String)localObject, paramJSONObject);
          }
        }
      }
      else
      {
        this.this$1.val$onChooseAdEndListener.onChooseAdEnd(null, null);
      }
      return;
    }
    catch (JSONException paramJSONObject) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.mini.manager.MiniLoadingAdManager.1.1
 * JD-Core Version:    0.7.0.1
 */