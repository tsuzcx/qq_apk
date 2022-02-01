package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.AdFrequencyLimit;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class RewardedVideoAdPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_REWARDED_VIDEO_SHOW_DONE = "onRewardedVideoShowDone";
  public static final String EVENT_REWARDED_VIDEO_STATE_CHANGE = "onRewardedVideoStateChange";
  private static final String TAG = "RewardedVideoAdPlugin";
  private static final HashMap<Integer, String> errCodeMsgMap = MiniSDKConst.AdConst.CODE_MSG_MAP;
  private boolean mGetRewarded = false;
  private boolean mHasShowGPToast = false;
  private boolean mIsOrientationLandscape = false;
  private volatile boolean mIsRequestingAd = false;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void createRewardVideoAdView(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3, Context paramContext, Bundle paramBundle)
  {
    AppBrandTask.runTaskOnUiThread(new RewardedVideoAdPlugin.1(this, paramContext, paramString3, paramString1, paramRequestEvent, paramString2, paramBundle));
  }
  
  private void handleErrorAndInformJs(RequestEvent paramRequestEvent, int paramInt, String paramString)
  {
    String str = (String)errCodeMsgMap.get(Integer.valueOf(paramInt));
    QMLog.d("RewardedVideoAdPlugin", "handleErrorAndInformJs errCode= " + paramInt + " errMsg=" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", str);
      localJSONObject.put("errCode", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(paramRequestEvent, localJSONObject, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException paramRequestEvent)
    {
      paramRequestEvent.printStackTrace();
    }
  }
  
  private void handleGetAdFailed(RequestEvent paramRequestEvent, int paramInt, String paramString)
  {
    handleErrorAndInformJs(paramRequestEvent, paramInt, paramString);
    handleShowAndInformJs(paramRequestEvent, false, paramString);
    handleLoadAndInformJs(paramRequestEvent, false, paramString);
  }
  
  private void handleLoadAndInformJs(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new RewardedVideoAdPlugin.2(this, paramString, paramBoolean, paramRequestEvent), 300L);
  }
  
  private void handleOnLoadAndInformJs(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    QMLog.d("RewardedVideoAdPlugin", "handleOnLoadAndInformJs isSucc= " + paramBoolean);
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("state", "load");
        if (TextUtils.isEmpty(paramString)) {
          break label93;
        }
        localJSONObject.put("compId", paramString);
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return;
      }
      localJSONObject.put("status", paramString);
      informJs(paramRequestEvent, localJSONObject, "onRewardedVideoStateChange");
      return;
      paramString = "error";
      continue;
      label93:
      if (paramBoolean) {
        paramString = "ok";
      }
    }
  }
  
  private void handleShowAndInformJs(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new RewardedVideoAdPlugin.3(this, paramString, paramBoolean, paramRequestEvent), 300L);
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    QMLog.d("RewardedVideoAdPlugin", "informJs d= " + String.valueOf(paramJSONObject) + " event=" + paramString);
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  private void initAdParam(RequestEvent paramRequestEvent, String paramString1, String paramString2)
  {
    int j = 0;
    int k = 1;
    this.mRewardedVideoAd = null;
    String str3 = LoginManager.getInstance().getAccount();
    String str4 = this.mApkgInfo.appId;
    if (this.mIsOrientationLandscape) {}
    for (int i = 90;; i = 0)
    {
      QMLog.i("RewardedVideoAdPlugin", "handle initAdParam appId = " + str4 + "， deviceOrient = " + i);
      if ((!TextUtils.isEmpty(str4)) && (!TextUtils.isEmpty(paramString1))) {
        break;
      }
      QMLog.e("RewardedVideoAdPlugin", "appid or pos_id is empty");
      handleGetAdFailed(paramRequestEvent, 1003, paramString2);
      return;
    }
    String str5;
    Object localObject3;
    label185:
    String str1;
    label203:
    String str2;
    Object localObject2;
    if (this.mMiniAppInfo.isEngineTypeMiniApp())
    {
      this.mIsRequestingAd = true;
      if (j == 0) {
        k = 3;
      }
      str5 = AdUtil.getSpAdGdtCookie(k);
      localObject3 = this.mMiniAppInfo;
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label462;
      }
      if (((MiniAppInfo)localObject3).launchParam.entryPath == null) {
        break label421;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
      if (((MiniAppInfo)localObject3).launchParam == null) {
        break label428;
      }
      str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
      j = ((MiniAppInfo)localObject3).launchParam.scene;
      str2 = String.valueOf(j);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = "")
    {
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
      {
        str2 = ((MiniAppInfo)localObject3).via;
        label248:
        QMLog.i("RewardedVideoAdPlugin", "getRewardedVideoADInfo account= " + str3 + " pos_id=" + paramString1);
        if (this.mMiniAppContext.getAttachedActivity() == null) {
          break label442;
        }
      }
      label421:
      label428:
      label442:
      for (localObject3 = this.mMiniAppContext.getAttachedActivity();; localObject3 = MiniAppEnv.g().getContext())
      {
        if (localObject3 == null) {
          break label453;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString(AdProxy.KEY_ACCOUNT, str3);
        localBundle.putInt(AdProxy.KEY_AD_TYPE, k);
        localBundle.putInt(AdProxy.KEY_ORIENTATION, i);
        localBundle.putString(AdProxy.KEY_GDT_COOKIE, str5);
        localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject2);
        localBundle.putString(AdProxy.KEY_REPORT_DATA, str1);
        localBundle.putString(AdProxy.KEY_REFER, (String)localObject1);
        localBundle.putString(AdProxy.KEY_VIA, str2);
        createRewardVideoAdView(paramRequestEvent, paramString1, paramString2, str4, (Context)localObject3, localBundle);
        return;
        j = 1;
        break;
        localObject1 = "";
        break label185;
        str1 = "";
        break label203;
        str2 = "";
        break label248;
      }
      label453:
      QMLog.e("RewardedVideoAdPlugin", "context is null");
      return;
      label462:
      str1 = "";
      localObject2 = "";
    }
  }
  
  private void onCloseAd(RequestEvent paramRequestEvent, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "close");
      localJSONObject.put("isEnded", this.mGetRewarded);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(paramRequestEvent, localJSONObject, "onRewardedVideoStateChange");
      this.mGetRewarded = false;
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("RewardedVideoAdPlugin", "doOnActivityResult failed e:", localJSONException);
      handleErrorAndInformJs(paramRequestEvent, 1003, paramString);
    }
  }
  
  @JsEvent({"createRewardedVideoAd"})
  public String createRewardedVideoAd(RequestEvent paramRequestEvent)
  {
    boolean bool;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.mIsOrientationLandscape = bool;
      if (this.mRewardedVideoAd != null) {}
    }
    for (;;)
    {
      Object localObject2;
      try
      {
        Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject2 = ((JSONObject)localObject1).optString("adUnitId");
        String str2 = ((JSONObject)localObject1).optString("compId");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          handleErrorAndInformJs(paramRequestEvent, 1002, str2);
          JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
          if (localJSONObject == null) {
            break label205;
          }
          localObject1 = localJSONObject.toString();
          paramRequestEvent.fail(localJSONObject.toString());
          if (localObject1 != null) {
            return localObject1;
          }
        }
        this.mPosID = ((String)localObject2);
        initAdParam(paramRequestEvent, this.mPosID, str2);
        return "";
      }
      catch (Exception localException)
      {
        QMLog.e("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
        localObject2 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        if (localObject2 == null) {}
      }
      for (String str1 = ((JSONObject)localObject2).toString();; str1 = "")
      {
        handleErrorAndInformJs(paramRequestEvent, 1003, "");
        paramRequestEvent.fail(((JSONObject)localObject2).toString());
        if (str1 == null) {
          break;
        }
        return str1;
      }
      bool = false;
      break;
      label205:
      str1 = "";
    }
  }
  
  public void onDestroy()
  {
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if ((localAdProxy != null) && (localAdProxy != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.getAttachedActivity() != null)) {
      localAdProxy.destroy(this.mMiniAppContext.getAttachedActivity());
    }
    super.onDestroy();
  }
  
  @JsEvent({"operateRewardedAd"})
  public void operateRewardedAd(RequestEvent paramRequestEvent)
  {
    int i = 1;
    boolean bool;
    Object localObject;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.mIsOrientationLandscape = bool;
      try
      {
        localObject = new JSONObject(paramRequestEvent.jsonParams);
        paramRequestEvent.ok();
        String str = ((JSONObject)localObject).optString("type");
        localObject = ((JSONObject)localObject).optString("compId");
        if ("load".equals(str))
        {
          if ((this.mRewardedVideoAd != null) && (!this.mIsRequestingAd))
          {
            handleLoadAndInformJs(paramRequestEvent, true, (String)localObject);
            return;
          }
          if (this.mIsRequestingAd) {
            break label229;
          }
          initAdParam(paramRequestEvent, this.mPosID, (String)localObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
        handleErrorAndInformJs(paramRequestEvent, 1003, "");
        paramRequestEvent.fail();
        return;
      }
      if ("show".equals(localJSONException))
      {
        if ((this.mIsRequestingAd) || (this.mRewardedVideoAd == null)) {
          break label235;
        }
        label170:
        if (i != 0) {
          if (this.mMiniAppContext == null) {
            break label240;
          }
        }
      }
    }
    label229:
    label235:
    label240:
    for (Activity localActivity = this.mMiniAppContext.getAttachedActivity();; localActivity = null)
    {
      this.mRewardedVideoAd.showAD(localActivity, (String)localObject);
      handleShowAndInformJs(paramRequestEvent, true, (String)localObject);
      this.mRewardedVideoAd = null;
      AdFrequencyLimit.setRewardVideoAdShowing(true);
      return;
      handleShowAndInformJs(paramRequestEvent, false, (String)localObject);
      return;
      bool = false;
      break;
      i = 0;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */