package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import ajjy;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BannerAdPosInfo;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import yju;

class BannerAdPlugin$2
  implements MiniAppCmdInterface
{
  BannerAdPlugin$2(BannerAdPlugin paramBannerAdPlugin, JsRuntime paramJsRuntime, BannerAdPosInfo paramBannerAdPosInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      BannerAdPlugin.access$100(this.this$0, this.val$webview, 1000, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1000)));
      return;
    }
    int i;
    if (paramBoolean)
    {
      try
      {
        QLog.i("[minigame] BannerAdPlugin", 1, "createBannerAd requeset success");
        i = paramJSONObject.getInt("resultCode");
        paramJSONObject = ((MiniAppAd.StGetAdRsp)paramJSONObject.opt("response")).strAdsJson.get();
        if (QLog.isColorLevel()) {
          QLog.i("[minigame] BannerAdPlugin", 2, "getBannerADInfo receive resultCode= " + i + " adJson=" + paramJSONObject);
        }
        if ((i != 1000) || (TextUtils.isEmpty(paramJSONObject)))
        {
          BannerAdPlugin.access$100(this.this$0, this.val$webview, 1000, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1000)));
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        BannerAdPlugin.access$100(this.this$0, this.val$webview, 1003, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1003)));
        return;
      }
      Object localObject = BannerAdPlugin.access$200(this.this$0, this.val$webview, paramJSONObject);
      if (localObject != null) {
        if ((this.this$0.jsPluginEngine.activityContext instanceof GameActivity))
        {
          GdtAd localGdtAd = new GdtAd((qq_ad_get.QQAdGetRsp.AdInfo)localObject);
          yju.a().a(localGdtAd);
          paramBoolean = ((GameActivity)this.this$0.jsPluginEngine.activityContext).createBannerAd(this.val$adPosInfo, (qq_ad_get.QQAdGetRsp.AdInfo)localObject);
          if (!paramBoolean) {
            break label493;
          }
        }
      }
      for (;;)
      {
        try
        {
          localObject = new JSONObject();
          ((JSONObject)localObject).put("state", "load");
          ((JSONObject)localObject).put("adUnitId", this.val$adPosInfo.mAdUnitId);
          ((JSONObject)localObject).put("left", this.val$adPosInfo.mAdLeft);
          ((JSONObject)localObject).put("top", this.val$adPosInfo.mAdTop);
          ((JSONObject)localObject).put("width", this.val$adPosInfo.mAdWidth);
          ((JSONObject)localObject).put("height", this.val$adPosInfo.mAdHeight);
          ((JSONObject)localObject).put("realWidth", this.val$adPosInfo.mAdRealWidth);
          ((JSONObject)localObject).put("realHeight", this.val$adPosInfo.mAdRealHeight);
          BannerAdPlugin.access$300(this.this$0, this.val$webview, (JSONObject)localObject, "onBannerAdStateChange");
          localObject = new JSONObject();
          ((JSONObject)localObject).put("state", "resize");
          ((JSONObject)localObject).put("width", this.val$adPosInfo.mAdRealWidth);
          ((JSONObject)localObject).put("height", this.val$adPosInfo.mAdRealHeight);
          BannerAdPlugin.access$300(this.this$0, this.val$webview, (JSONObject)localObject, "onBannerAdStateChange");
          BannerAdPlugin.access$400(this.this$0, paramJSONObject, 0);
          return;
        }
        catch (JSONException localJSONException)
        {
          QLog.e("[minigame] BannerAdPlugin", 1, "informJs success", localJSONException);
          continue;
        }
        label493:
        BannerAdPlugin.access$100(this.this$0, this.val$webview, 1003, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1003)));
        QLog.i("[minigame] BannerAdPlugin", 1, "createBannerAd error" + paramJSONObject);
        continue;
        QLog.e("[minigame] BannerAdPlugin", 1, "getBannerAd no ads");
      }
    }
    if (paramJSONObject != null) {}
    try
    {
      i = paramJSONObject.getInt("resultCode");
      BannerAdPlugin.access$100(this.this$0, this.val$webview, i, ajjy.a(2131635111));
      for (;;)
      {
        QLog.e("[minigame] BannerAdPlugin", 1, "getBannerAd request error");
        return;
        BannerAdPlugin.access$100(this.this$0, this.val$webview, 1003, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1003)));
      }
    }
    catch (Exception paramJSONObject)
    {
      for (;;)
      {
        BannerAdPlugin.access$100(this.this$0, this.val$webview, 1003, (String)BannerAdPlugin.access$000().get(Integer.valueOf(1003)));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BannerAdPlugin.2
 * JD-Core Version:    0.7.0.1
 */