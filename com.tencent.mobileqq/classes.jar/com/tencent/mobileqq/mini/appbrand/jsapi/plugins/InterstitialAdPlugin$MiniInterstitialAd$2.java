package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import aaon;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.interstitial.GdtInterstitialParams;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

class InterstitialAdPlugin$MiniInterstitialAd$2
  implements MiniAppCmdInterface
{
  InterstitialAdPlugin$MiniInterstitialAd$2(InterstitialAdPlugin.MiniInterstitialAd paramMiniInterstitialAd, int paramInt1, int paramInt2, Activity paramActivity, MiniAppAd.StGetAdReq paramStGetAdReq) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("[minigame] MiniInterstitialAd", 1, "getInterstitialADInfo receive isSuc= " + paramBoolean + " ret=" + paramJSONObject);
    InterstitialAdPlugin.MiniInterstitialAd.access$502(this.this$0, false);
    if ((!paramBoolean) || (paramJSONObject == null)) {
      InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, 1000, this.val$callbackId);
    }
    int j;
    String str;
    for (;;)
    {
      return;
      MiniAppAd.StGetAdRsp localStGetAdRsp;
      for (;;)
      {
        try
        {
          localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
          j = paramJSONObject.getInt("retCode");
          str = paramJSONObject.getString("errMsg");
          localObject = localStGetAdRsp.strAdsJson.get();
          StringBuilder localStringBuilder = new StringBuilder().append("getInterstitialADInfo receive retCode= ").append(j).append(" errMsg=").append(str).append(" adJson=");
          if ((localObject != null) && (((String)localObject).length() > 1024))
          {
            paramJSONObject = ((String)localObject).substring(0, 1024);
            QLog.i("[minigame] MiniInterstitialAd", 1, paramJSONObject);
            if (j != 0) {
              break label564;
            }
            paramBoolean = TextUtils.isEmpty((CharSequence)localObject);
            if (paramBoolean) {
              break label564;
            }
            try
            {
              paramJSONObject = new JSONObject((String)localObject).optJSONArray("pos_ads_info").getJSONObject(0);
              if (paramJSONObject.optInt("ret", -1) == 0) {
                break;
              }
              InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, 1004, this.val$callbackId);
              return;
            }
            catch (Throwable paramJSONObject)
            {
              QLog.e("[minigame] MiniInterstitialAd", 1, "check adsJson exception:", paramJSONObject);
              InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, 1003, this.val$callbackId);
              return;
            }
          }
          paramJSONObject = (JSONObject)localObject;
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("[minigame] MiniInterstitialAd", 1, "onCmdListener exception:", paramJSONObject);
          InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, 1003, this.val$callbackId);
          return;
        }
      }
      paramJSONObject = paramJSONObject.getJSONArray("ads_info").getJSONObject(0);
      Object localObject = new GdtInterstitialParams();
      ((GdtInterstitialParams)localObject).jdField_a_of_type_ComTencentGdtadAditemGdtHandler$Options = InterstitialAdPlugin.MiniInterstitialAd.access$600(this.this$0, paramJSONObject);
      if (InterstitialAdPlugin.MiniInterstitialAd.access$700(this.this$0))
      {
        i = 0;
        ((GdtInterstitialParams)localObject).jdField_a_of_type_Int = i;
        ((GdtInterstitialParams)localObject).jdField_a_of_type_Boolean = true;
        InterstitialAdPlugin.MiniInterstitialAd.access$102(this.this$0, new aaon(this.val$activity, (GdtInterstitialParams)localObject));
        InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, true, "operateInterstitialAd", this.val$compId, j, this.val$callbackId);
        InterstitialAdPlugin.MiniInterstitialAd.access$800(this.this$0, localStGetAdRsp.strAdsJson.get(), this.val$adReq.ad_type.get());
        if (localStGetAdRsp == null) {}
      }
      else
      {
        try
        {
          if ((localStGetAdRsp.vecAppInfo != null) && (localStGetAdRsp.vecAppInfo.size() > 0) && (localStGetAdRsp.iPreLoadLevel.get() == 2L))
          {
            i = 0;
            while (i < localStGetAdRsp.vecAppInfo.size())
            {
              GpkgManager.preloadGpkgByConfig(new MiniAppConfig(MiniAppInfo.from((INTERFACE.StApiAppInfo)localStGetAdRsp.vecAppInfo.get(i))));
              i += 1;
            }
            i = 1;
          }
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("[minigame] MiniInterstitialAd", 1, "preloadGpkgByConfig failed:" + paramJSONObject.getMessage());
          return;
        }
      }
    }
    label564:
    int i = PluginConst.AdConst.getRetCodeByServerResult(j);
    if (i != -1)
    {
      InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, i, this.val$callbackId);
      return;
    }
    InterstitialAdPlugin.S_CodeMsg_Map.put(Integer.valueOf(j), str);
    InterstitialAdPlugin.MiniInterstitialAd.access$200(this.this$0, false, "operateInterstitialAd", this.val$compId, j, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.InterstitialAdPlugin.MiniInterstitialAd.2
 * JD-Core Version:    0.7.0.1
 */