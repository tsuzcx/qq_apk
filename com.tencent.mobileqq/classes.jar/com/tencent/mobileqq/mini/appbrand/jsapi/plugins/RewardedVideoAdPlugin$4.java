package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import ackk;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class RewardedVideoAdPlugin$4
  implements MiniAppCmdInterface
{
  RewardedVideoAdPlugin$4(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt1, int paramInt2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "getRewardedVideoADInfo receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    RewardedVideoAdPlugin.access$402(this.this$0, false);
    if (paramJSONObject == null) {
      RewardedVideoAdPlugin.access$500(this.this$0, 1000, this.val$compId);
    }
    int i;
    for (;;)
    {
      return;
      if (!paramBoolean) {
        break label658;
      }
      MiniAppAd.StGetAdRsp localStGetAdRsp;
      for (;;)
      {
        try
        {
          localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
          i = paramJSONObject.getInt("retCode");
          paramJSONObject = paramJSONObject.getString("errMsg");
          Object localObject = localStGetAdRsp.strAdsJson.get();
          QLog.d("[minigame] RewardedVideoAdPlugin", 1, "getRewardedVideoADInfo receive retCode= " + i + " errMsg=" + paramJSONObject + " adJson=" + (String)localObject);
          if ((i != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label547;
          }
          paramJSONObject = RewardedVideoAdPlugin.access$600(this.this$0, (String)localObject, this.val$compId);
          if (TextUtils.isEmpty(paramJSONObject)) {
            break;
          }
          RewardedVideoAdPlugin.access$700(this.this$0, paramJSONObject);
          if (RewardedVideoAdPlugin.access$800(this.this$0) == null) {
            break;
          }
          RewardedVideoAdPlugin.access$902(this.this$0, new GdtAd(RewardedVideoAdPlugin.access$800(this.this$0)));
          if ((!RewardedVideoAdPlugin.access$900(this.this$0).isValid()) || (TextUtils.isEmpty(paramJSONObject))) {
            break label431;
          }
          ackk.a().a(RewardedVideoAdPlugin.access$900(this.this$0));
          localObject = this.this$0;
          GdtAd localGdtAd = RewardedVideoAdPlugin.access$900(this.this$0);
          if (RewardedVideoAdPlugin.access$1100(this.this$0))
          {
            i = 0;
            RewardedVideoAdPlugin.access$1002((RewardedVideoAdPlugin)localObject, RewardedVideoAdPlugin.mockMVPageData(localGdtAd, paramJSONObject, i));
            if (RewardedVideoAdPlugin.access$1000(this.this$0) == null) {
              break label431;
            }
            RewardedVideoAdPlugin.access$1200(this.this$0, true, this.val$compId);
            RewardedVideoAdPlugin.access$1300(this.this$0, true, this.val$compId);
            this.this$0.jsPluginEngine.callbackJsEventOK(this.val$webview, this.val$event, null, this.val$callbackId);
            RewardedVideoAdPlugin.access$1400(this.this$0, localStGetAdRsp.strAdsJson.get(), this.val$adType);
            return;
          }
        }
        catch (Exception paramJSONObject)
        {
          QLog.e("[minigame] RewardedVideoAdPlugin", 1, "onCmdListener failed e:", paramJSONObject);
          RewardedVideoAdPlugin.access$500(this.this$0, 1003, this.val$compId);
          this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
          return;
        }
        i = 1;
      }
      label431:
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
          QLog.e("[minigame] RewardedVideoAdPlugin", 1, "preloadGpkgByConfig failed:" + paramJSONObject.getMessage());
          return;
        }
      }
    }
    label547:
    int j;
    if (j != -1)
    {
      RewardedVideoAdPlugin.access$500(this.this$0, j, this.val$compId);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
      return;
    }
    RewardedVideoAdPlugin.access$1500().put(Integer.valueOf(i), paramJSONObject);
    RewardedVideoAdPlugin.access$500(this.this$0, i, this.val$compId);
    this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
    return;
    try
    {
      label658:
      i = paramJSONObject.getInt("resultCode");
      RewardedVideoAdPlugin.access$500(this.this$0, i, this.val$compId);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
      RewardedVideoAdPlugin.access$500(this.this$0, 1000, this.val$compId);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin.4
 * JD-Core Version:    0.7.0.1
 */