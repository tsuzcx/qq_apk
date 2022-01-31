package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdReq;
import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import aanh;
import aani;
import android.app.Activity;
import android.text.TextUtils;
import com.tencent.gdtad.api.adbox.GdtAdBoxData;
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

class AppBoxPlugin$MiniAppBox$2
  implements MiniAppCmdInterface
{
  AppBoxPlugin$MiniAppBox$2(AppBoxPlugin.MiniAppBox paramMiniAppBox, int paramInt1, int paramInt2, Activity paramActivity, MiniAppAd.StGetAdReq paramStGetAdReq) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("[minigame] MiniAppBox", 1, "getAppBoxADInfo receive isSuc= " + paramBoolean + " ret=" + paramJSONObject);
    AppBoxPlugin.MiniAppBox.access$202(this.this$0, false);
    if ((!paramBoolean) || (paramJSONObject == null)) {
      AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, 1000, this.val$callbackId);
    }
    int i;
    String str2;
    for (;;)
    {
      return;
      MiniAppAd.StGetAdRsp localStGetAdRsp;
      String str1;
      for (;;)
      {
        try
        {
          localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
          i = paramJSONObject.getInt("retCode");
          str2 = paramJSONObject.getString("errMsg");
          str1 = localStGetAdRsp.strAdsJson.get();
          StringBuilder localStringBuilder = new StringBuilder().append("getAppBoxADInfo receive retCode= ").append(i).append(" errMsg=").append(str2).append(" adJson=");
          if ((str1 != null) && (str1.length() > 1024))
          {
            paramJSONObject = str1.substring(0, 1024);
            QLog.i("[minigame] MiniAppBox", 1, paramJSONObject);
            if (i != 0) {
              break label524;
            }
            paramBoolean = TextUtils.isEmpty(str1);
            if (paramBoolean) {
              break label524;
            }
            try
            {
              if (new JSONObject(str1).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) == 0) {
                break;
              }
              AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, 1004, this.val$callbackId);
              return;
            }
            catch (Throwable paramJSONObject)
            {
              QLog.e("[minigame] MiniAppBox", 1, "check adsJson exception:", paramJSONObject);
              AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, 1003, this.val$callbackId);
              return;
            }
          }
          paramJSONObject = str1;
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("[minigame] MiniAppBox", 1, "onCmdListener exception:", paramJSONObject);
          AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, 1003, this.val$callbackId);
          return;
        }
      }
      this.this$0.destroy();
      AppBoxPlugin.MiniAppBox.access$002(this.this$0, aanh.a(this.val$activity).a(new GdtAdBoxData(str1)).a(new AppBoxPlugin.MiniAppBox.2.1(this)).a());
      AppBoxPlugin.MiniAppBox.access$100(this.this$0, true, "operateAppBox", this.val$compId, i, this.val$callbackId);
      AppBoxPlugin.MiniAppBox.access$500(this.this$0, localStGetAdRsp.strAdsJson.get(), this.val$adReq.ad_type.get());
      if (localStGetAdRsp != null) {
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
            j = PluginConst.AdConst.getRetCodeByServerResult(i);
          }
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("[minigame] MiniAppBox", 1, "preloadGpkgByConfig failed:" + paramJSONObject.getMessage());
          return;
        }
      }
    }
    label524:
    int j;
    if (j != -1)
    {
      AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, j, this.val$callbackId);
      return;
    }
    AppBoxPlugin.S_CodeMsg_Map.put(Integer.valueOf(i), str2);
    AppBoxPlugin.MiniAppBox.access$100(this.this$0, false, "operateAppBox", this.val$compId, i, this.val$callbackId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.AppBoxPlugin.MiniAppBox.2
 * JD-Core Version:    0.7.0.1
 */