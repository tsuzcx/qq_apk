package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONObject;

@JsPlugin
public class InterstitialAdPlugin
  extends BaseJsPlugin
{
  public static final String API_OPERATE_DESTROY = "destroy";
  public static final String API_OPERATE_INTERSTITIAL_AD = "operateInterstitialAd";
  public static final String API_OPERATE_LOAD = "load";
  public static final String API_OPERATE_SHOW = "show";
  private static final String ERRCODE = "errCode";
  private static final String ERRMSG = "errMsg";
  public static final String EVENT_INTERSTITIAL_CLOSE = "onInterstitialAdClose";
  public static final String KEY_REF_ID = "biz_src_miniapp";
  public static final HashMap<Integer, String> S_CodeMsg_Map = MiniSDKConst.AdConst.CODE_MSG_MAP;
  private static final String TAG = "InterstitialAdPlugin";
  private Map<Integer, InterstitialAdPlugin.MiniInterstitialAd> mInterstitialMap = new HashMap();
  
  private int getAdType()
  {
    int i;
    if ((this.mMiniAppInfo != null) && (this.mMiniAppInfo.isEngineTypeMiniApp())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0) {
      return 10;
    }
    return 11;
  }
  
  static boolean isAdUnitIdValid(String paramString)
  {
    return TextUtils.isEmpty(paramString) ^ true;
  }
  
  InterstitialAdPlugin.MiniInterstitialAd getMiniInterstitialAd(int paramInt, String paramString, RequestEvent paramRequestEvent)
  {
    boolean bool = this.mInterstitialMap.containsKey(Integer.valueOf(paramInt));
    Object localObject2 = null;
    Object localObject1;
    if (bool)
    {
      paramString = (InterstitialAdPlugin.MiniInterstitialAd)this.mInterstitialMap.get(Integer.valueOf(paramInt));
    }
    else
    {
      if ((this.mMiniAppContext != null) && (this.mApkgInfo != null)) {
        localObject1 = this.mApkgInfo.appId;
      } else {
        localObject1 = "";
      }
      Activity localActivity;
      if (this.mMiniAppContext != null) {
        localActivity = this.mMiniAppContext.getAttachedActivity();
      } else {
        localActivity = null;
      }
      paramString = new InterstitialAdPlugin.MiniInterstitialAd(this, localActivity, paramInt, paramString, (String)localObject1, paramRequestEvent.jsService);
      this.mInterstitialMap.put(Integer.valueOf(paramInt), paramString);
    }
    if (paramString != null)
    {
      localObject1 = localObject2;
      if (this.mMiniAppContext != null) {
        localObject1 = this.mMiniAppContext.getAttachedActivity();
      }
      paramString.setJsService(paramRequestEvent.jsService);
      paramString.setActivity((Activity)localObject1);
    }
    return paramString;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Iterator localIterator = this.mInterstitialMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      InterstitialAdPlugin.MiniInterstitialAd localMiniInterstitialAd = (InterstitialAdPlugin.MiniInterstitialAd)((Map.Entry)localIterator.next()).getValue();
      if (localMiniInterstitialAd != null) {
        localMiniInterstitialAd.destroy();
      }
    }
  }
  
  @JsEvent({"operateInterstitialAd"})
  public String operateInterstitialAd(RequestEvent paramRequestEvent)
  {
    JSONObject localJSONObject;
    try
    {
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("operateInterstitialAd, jsonParams = ");
      ((StringBuilder)localObject1).append(paramRequestEvent.jsonParams);
      QMLog.e("InterstitialAdPlugin", ((StringBuilder)localObject1).toString());
      localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      int j = ((JSONObject)localObject1).optInt("id", -1);
      Object localObject2 = ((JSONObject)localObject1).optString("adUnitId", null);
      if (!isAdUnitIdValid((String)localObject2))
      {
        localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
        ((JSONObject)localObject1).put("errCode", 1002);
        localObject2 = ((JSONObject)localObject1).toString();
        paramRequestEvent.fail((JSONObject)localObject1, "广告单元无效");
        return localObject2;
      }
      localObject2 = getMiniInterstitialAd(j, (String)localObject2, paramRequestEvent);
      String str = ((JSONObject)localObject1).optString("type");
      int i = ((JSONObject)localObject1).optInt("compId", -1);
      if ("load".equals(str))
      {
        if (!((InterstitialAdPlugin.MiniInterstitialAd)localObject2).load(i, paramRequestEvent.callbackId))
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
          ((JSONObject)localObject1).put("errCode", 1003);
          paramRequestEvent.fail((JSONObject)localObject1, "内部错误");
        }
      }
      else if ("show".equals(str))
      {
        j = AdFrequencyLimit.canShowInterstitialAdNow();
        if (j != 0)
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
          ((JSONObject)localObject1).put("errCode", j);
          paramRequestEvent.fail((JSONObject)localObject1, "内部错误");
          return ((JSONObject)localObject1).toString();
        }
        if (!((InterstitialAdPlugin.MiniInterstitialAd)localObject2).show(i, paramRequestEvent.callbackId))
        {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1);
          ((JSONObject)localObject1).put("errCode", 1003);
          paramRequestEvent.fail((JSONObject)localObject1, "内部错误");
        }
      }
      else if ("destroy".equals(str))
      {
        if (((InterstitialAdPlugin.MiniInterstitialAd)localObject2).destroy()) {
          localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject1);
        } else {
          localObject1 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, (JSONObject)localObject1, "内部错误").put("errCode", 1003).put("errMsg", "内部错误");
        }
        paramRequestEvent.jsService.evaluateCallbackJs(paramRequestEvent.callbackId, ((JSONObject)localObject1).toString());
        this.mInterstitialMap.remove(Integer.valueOf(j));
      }
      return "";
    }
    catch (Throwable localThrowable)
    {
      QMLog.e("InterstitialAdPlugin", "operateInterstitialAdfailed e:", localThrowable);
      localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
    }
    try
    {
      localJSONObject.put("errCode", 1003);
      paramRequestEvent.fail(localJSONObject, "内部错误");
      label446:
      return localJSONObject.toString();
    }
    catch (Throwable paramRequestEvent)
    {
      break label446;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin
 * JD-Core Version:    0.7.0.1
 */