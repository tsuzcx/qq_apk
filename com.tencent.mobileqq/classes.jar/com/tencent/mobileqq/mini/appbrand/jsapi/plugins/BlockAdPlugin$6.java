package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import NS_MINI_AD.MiniAppAd.StGetAdRsp;
import NS_MINI_INTERFACE.INTERFACE.StApiAppInfo;
import android.text.TextUtils;
import anni;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.appbrand.jsapi.PluginConst.AdConst;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.mobileqq.minigame.data.BlockAdInfo;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.manager.BlockAdManager;
import com.tencent.mobileqq.minigame.ui.GameActivity;
import com.tencent.mobileqq.minigame.widget.BlockAdView;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BlockAdPlugin$6
  implements MiniAppCmdInterface
{
  BlockAdPlugin$6(BlockAdPlugin paramBlockAdPlugin, JsRuntime paramJsRuntime, BlockAdInfo paramBlockAdInfo) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      BlockAdPlugin.access$200(this.this$0, this.val$webview, 1000, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1000)), this.val$blockAdInfo.getCompId());
    }
    for (;;)
    {
      return;
      MiniAppAd.StGetAdRsp localStGetAdRsp;
      int i;
      if (paramBoolean)
      {
        String str2;
        String str1;
        for (;;)
        {
          try
          {
            QLog.i("[minigame] BlockAdPlugin", 1, "createBlockAd requeset success");
            localStGetAdRsp = (MiniAppAd.StGetAdRsp)paramJSONObject.get("response");
            i = paramJSONObject.getInt("retCode");
            str2 = paramJSONObject.getString("errMsg");
            str1 = localStGetAdRsp.strAdsJson.get();
            StringBuilder localStringBuilder = new StringBuilder().append("getBlockADInfo receive retCode= ").append(i).append(" errMsg=").append(str2).append(" adJson=");
            if ((str1 != null) && (str1.length() > 1024))
            {
              paramJSONObject = str1.substring(0, 1024);
              QLog.i("[minigame] BlockAdPlugin", 1, paramJSONObject);
              if (i != 0) {
                break;
              }
              paramBoolean = TextUtils.isEmpty(str1);
              if (paramBoolean) {
                break;
              }
              try
              {
                if (new JSONObject(str1).optJSONArray("pos_ads_info").getJSONObject(0).optInt("ret", -1) == 0) {
                  break label414;
                }
                BlockAdPlugin.access$200(this.this$0, this.val$webview, 1004, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1004)), this.val$blockAdInfo.getCompId());
                return;
              }
              catch (Throwable paramJSONObject)
              {
                QLog.e("[minigame] BlockAdPlugin", 1, "check adsJson exception:", paramJSONObject);
                BlockAdPlugin.access$200(this.this$0, this.val$webview, 1000, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1000)), this.val$blockAdInfo.getCompId());
                return;
              }
            }
            paramJSONObject = str1;
          }
          catch (JSONException paramJSONObject)
          {
            BlockAdPlugin.access$200(this.this$0, this.val$webview, 1000, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1000)), this.val$blockAdInfo.getCompId());
            return;
          }
        }
        int j = PluginConst.AdConst.getRetCodeByServerResult(i);
        if (j != -1)
        {
          BlockAdPlugin.access$200(this.this$0, this.val$webview, j, (String)BlockAdPlugin.access$100().get(Integer.valueOf(j)), this.val$blockAdInfo.getCompId());
          return;
        }
        PluginConst.AdConst.CodeMsgMap.put(Integer.valueOf(i), str2);
        BlockAdPlugin.access$200(this.this$0, this.val$webview, i, str2, this.val$blockAdInfo.getCompId());
        return;
        label414:
        paramJSONObject = AdUtils.convertJson2GdtAds(str1);
        this.val$blockAdInfo.setAdMiniAppInfo(paramJSONObject);
        i = BlockAdManager.getInstance().genarateBlockAdView(this.this$0.jsPluginEngine.activityContext, this.val$blockAdInfo).getRealAdNum();
        if (i < 1)
        {
          BlockAdPlugin.access$200(this.this$0, this.val$webview, 1009, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1009)), this.val$blockAdInfo.getCompId());
          return;
        }
        if (paramJSONObject != null)
        {
          paramBoolean = this.this$0.jsPluginEngine.activityContext instanceof GameActivity;
          if (!paramBoolean) {}
        }
      }
      try
      {
        paramJSONObject = new JSONObject();
        paramJSONObject.put("state", "load");
        paramJSONObject.put("adUnitId", this.val$blockAdInfo.getAdUnitId());
        paramJSONObject.put("compId", this.val$blockAdInfo.getCompId());
        paramJSONObject.put("realAdNum", i);
        paramJSONObject.put("realWidth", this.val$blockAdInfo.getRealWidth());
        paramJSONObject.put("realHeight", this.val$blockAdInfo.getRealHeight());
        BlockAdPlugin.access$000(this.this$0, this.val$webview, paramJSONObject, "onBlockAdStateChange");
        paramJSONObject = new JSONObject();
        paramJSONObject.put("state", "resize");
        paramJSONObject.put("compId", this.val$blockAdInfo.getCompId());
        paramJSONObject.put("width", this.val$blockAdInfo.getRealWidth());
        paramJSONObject.put("height", this.val$blockAdInfo.getRealHeight());
        BlockAdPlugin.access$000(this.this$0, this.val$webview, paramJSONObject, "onBlockAdStateChange");
        label684:
        if (localStGetAdRsp == null) {
          continue;
        }
        try
        {
          if ((localStGetAdRsp.vecAppInfo == null) || (localStGetAdRsp.vecAppInfo.size() <= 0) || (localStGetAdRsp.iPreLoadLevel.get() != 2L)) {
            continue;
          }
          i = 0;
          while (i < localStGetAdRsp.vecAppInfo.size())
          {
            GpkgManager.preloadGpkgByConfig(new MiniAppConfig(MiniAppInfo.from((INTERFACE.StApiAppInfo)localStGetAdRsp.vecAppInfo.get(i))));
            i += 1;
          }
          QLog.e("[minigame] BlockAdPlugin", 1, "getBlockAd no ads");
        }
        catch (Throwable paramJSONObject)
        {
          QLog.e("[minigame] BlockAdPlugin", 1, "preloadGpkgByConfig failed:" + paramJSONObject.getMessage());
          return;
        }
        if (paramJSONObject != null) {}
        try
        {
          i = paramJSONObject.getInt("resultCode");
          BlockAdPlugin.access$200(this.this$0, this.val$webview, i, anni.a(2131699711), this.val$blockAdInfo.getCompId());
          for (;;)
          {
            QLog.e("[minigame] BlockAdPlugin", 1, "getBlockAd request error");
            return;
            BlockAdPlugin.access$200(this.this$0, this.val$webview, 1003, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1003)), this.val$blockAdInfo.getCompId());
          }
        }
        catch (Exception paramJSONObject)
        {
          for (;;)
          {
            BlockAdPlugin.access$200(this.this$0, this.val$webview, 1003, (String)BlockAdPlugin.access$100().get(Integer.valueOf(1003)), this.val$blockAdInfo.getCompId());
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        break label684;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.BlockAdPlugin.6
 * JD-Core Version:    0.7.0.1
 */