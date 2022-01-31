package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import android.text.TextUtils;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.ApiUtil;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;
import ysx;

class RewardedVideoAdPlugin$4
  implements MiniAppCmdInterface
{
  RewardedVideoAdPlugin$4(RewardedVideoAdPlugin paramRewardedVideoAdPlugin, String paramString1, JsRuntime paramJsRuntime, String paramString2, int paramInt1, int paramInt2) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    int i = 0;
    QLog.d("[minigame] RewardedVideoAdPlugin", 1, "getRewardedVideoADInfo receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    RewardedVideoAdPlugin.access$402(this.this$0, false);
    if (paramJSONObject == null)
    {
      RewardedVideoAdPlugin.access$500(this.this$0, 1000, this.val$compId);
      return;
    }
    if (paramBoolean)
    {
      int j;
      for (;;)
      {
        try
        {
          MiniAppAd.StGetAdRsp localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
          j = paramJSONObject.getInt("retCode");
          paramJSONObject = paramJSONObject.getString("errMsg");
          Object localObject = localStGetAdRsp.strAdsJson.get();
          QLog.d("[minigame] RewardedVideoAdPlugin", 1, "getRewardedVideoADInfo receive retCode= " + j + " errMsg=" + paramJSONObject + " adJson=" + (String)localObject);
          if ((j != 0) || (TextUtils.isEmpty((CharSequence)localObject))) {
            break label434;
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
            break;
          }
          ysx.a().a(RewardedVideoAdPlugin.access$900(this.this$0));
          localObject = this.this$0;
          GdtAd localGdtAd = RewardedVideoAdPlugin.access$900(this.this$0);
          if (RewardedVideoAdPlugin.access$1100(this.this$0))
          {
            RewardedVideoAdPlugin.access$1002((RewardedVideoAdPlugin)localObject, RewardedVideoAdPlugin.mockMVPageData(localGdtAd, paramJSONObject, i));
            if (RewardedVideoAdPlugin.access$1000(this.this$0) == null) {
              break;
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
      label434:
      i = PluginConst.AdConst.getRetCodeByServerResult(j);
      if (i != -1)
      {
        RewardedVideoAdPlugin.access$500(this.this$0, i, this.val$compId);
        this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
        return;
      }
      RewardedVideoAdPlugin.access$1500().put(Integer.valueOf(j), paramJSONObject);
      RewardedVideoAdPlugin.access$500(this.this$0, j, this.val$compId);
      this.this$0.jsPluginEngine.callbackJsEventFail(this.val$webview, this.val$event, ApiUtil.wrapCallbackFail(this.val$event, null), this.val$callbackId);
      return;
    }
    try
    {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.RewardedVideoAdPlugin.4
 * JD-Core Version:    0.7.0.1
 */