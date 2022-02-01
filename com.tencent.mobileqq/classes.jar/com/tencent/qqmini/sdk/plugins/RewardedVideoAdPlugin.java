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
  private boolean mHasClosedAd = true;
  private boolean mHasShowGPToast = false;
  private boolean mIsOrientationLandscape = false;
  private volatile boolean mIsRequestingAd = false;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void createRewardVideoAdView(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3, Context paramContext, Bundle paramBundle)
  {
    AppBrandTask.runTaskOnUiThread(new RewardedVideoAdPlugin.1(this, paramContext, paramString3, paramString1, paramRequestEvent, paramString2, paramBundle));
  }
  
  private void doCreateRewardVideoAdView(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    if (this.mMiniAppContext.getAttachedActivity() != null) {}
    for (Object localObject = this.mMiniAppContext.getAttachedActivity(); localObject != null; localObject = MiniAppEnv.g().getContext())
    {
      Bundle localBundle = new Bundle();
      localBundle.putString(AdProxy.KEY_ACCOUNT, paramString3);
      localBundle.putInt(AdProxy.KEY_AD_TYPE, paramInt2);
      localBundle.putInt(AdProxy.KEY_ORIENTATION, paramInt1);
      localBundle.putString(AdProxy.KEY_GDT_COOKIE, paramString5);
      localBundle.putString(AdProxy.KEY_ENTRY_PATH, paramString6);
      localBundle.putString(AdProxy.KEY_REPORT_DATA, paramString7);
      localBundle.putString(AdProxy.KEY_REFER, paramString8);
      localBundle.putString(AdProxy.KEY_VIA, paramString9);
      createRewardVideoAdView(paramRequestEvent, paramString1, paramString2, paramString4, (Context)localObject, localBundle);
      return;
    }
    QMLog.e("RewardedVideoAdPlugin", "context is null");
  }
  
  private int getAdType(int paramInt)
  {
    if (paramInt == 0) {
      return 3;
    }
    return 1;
  }
  
  private int getMiniType()
  {
    if (this.mMiniAppInfo.isEngineTypeMiniApp()) {
      return 0;
    }
    return 1;
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
          break label97;
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
      label97:
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
    this.mRewardedVideoAd = null;
    String str6 = LoginManager.getInstance().getAccount();
    String str7 = this.mApkgInfo.appId;
    if (this.mIsOrientationLandscape) {}
    for (int i = 90;; i = 0)
    {
      QMLog.i("RewardedVideoAdPlugin", "handle initAdParam appId = " + str7 + "， deviceOrient = " + i);
      if ((!TextUtils.isEmpty(str7)) && (!TextUtils.isEmpty(paramString1))) {
        break;
      }
      QMLog.e("RewardedVideoAdPlugin", "appid or pos_id is empty");
      handleGetAdFailed(paramRequestEvent, 1003, paramString2);
      return;
    }
    int j = getMiniType();
    this.mIsRequestingAd = true;
    j = getAdType(j);
    String str8 = AdUtil.getSpAdGdtCookie(j);
    MiniAppInfo localMiniAppInfo = this.mMiniAppInfo;
    String str3 = "";
    String str4 = "";
    String str5 = "";
    Object localObject = str3;
    String str2 = str4;
    String str1 = str5;
    if (localMiniAppInfo != null)
    {
      localObject = str3;
      str2 = str4;
      str1 = str5;
      if (localMiniAppInfo.launchParam != null)
      {
        if (localMiniAppInfo.launchParam.entryPath == null) {
          break label332;
        }
        str1 = localMiniAppInfo.launchParam.entryPath;
        if (localMiniAppInfo.launchParam == null) {
          break label339;
        }
        str2 = localMiniAppInfo.launchParam.reportData;
        label229:
        str3 = String.valueOf(localMiniAppInfo.launchParam.scene);
        localObject = str1;
        str1 = str3;
      }
    }
    if ((localMiniAppInfo != null) && (localMiniAppInfo.via != null)) {}
    for (str3 = localMiniAppInfo.via;; str3 = "")
    {
      QMLog.i("RewardedVideoAdPlugin", "getRewardedVideoADInfo account= " + str6 + " pos_id=" + paramString1);
      doCreateRewardVideoAdView(paramRequestEvent, paramString1, paramString2, str6, str7, i, j, str8, (String)localObject, str2, str1, str3);
      return;
      label332:
      str1 = "";
      break;
      label339:
      str2 = "";
      break label229;
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
            break label206;
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
      label206:
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
            break label243;
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
        if ((this.mIsRequestingAd) || (this.mRewardedVideoAd == null) || (!this.mHasClosedAd)) {
          break label249;
        }
        label179:
        if (i != 0) {
          if (this.mMiniAppContext == null) {
            break label254;
          }
        }
      }
    }
    label243:
    label249:
    label254:
    for (Activity localActivity = this.mMiniAppContext.getAttachedActivity();; localActivity = null)
    {
      this.mRewardedVideoAd.showAD(localActivity, (String)localObject);
      handleShowAndInformJs(paramRequestEvent, true, (String)localObject);
      this.mRewardedVideoAd = null;
      this.mHasClosedAd = false;
      AdFrequencyLimit.setRewardVideoAdShowing(true);
      return;
      handleShowAndInformJs(paramRequestEvent, false, (String)localObject);
      return;
      bool = false;
      break;
      i = 0;
      break label179;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */