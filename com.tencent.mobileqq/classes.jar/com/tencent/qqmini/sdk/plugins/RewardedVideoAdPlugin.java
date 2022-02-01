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
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.ExpParam;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class RewardedVideoAdPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_REWARDED_VIDEO_SHOW_DONE = "onRewardedVideoShowDone";
  public static final String EVENT_REWARDED_VIDEO_STATE_CHANGE = "onRewardedVideoStateChange";
  private static final String REAL_TIME_TAG = "RealTimeRewardedVideoAdPlugin";
  private static final String TAG = "RewardedVideoAdPlugin";
  private static final HashMap<Integer, String> errCodeMsgMap = MiniSDKConst.AdConst.CODE_MSG_MAP;
  private boolean mGetRewarded = false;
  private boolean mHasClosedAd = true;
  private boolean mHasShowGPToast = false;
  private boolean mIsOrientationLandscape = false;
  private volatile boolean mIsRequestingAd = false;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void createRewardVideoAdView(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3, Context paramContext, Bundle paramBundle, boolean paramBoolean)
  {
    AppBrandTask.runTaskOnUiThread(new RewardedVideoAdPlugin.1(this, paramContext, paramString3, paramString1, paramBoolean, paramRequestEvent, paramString2, paramBundle));
  }
  
  private void doCreateRewardVideoAdView(RequestEvent paramRequestEvent, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, boolean paramBoolean)
  {
    Object localObject;
    if (this.mMiniAppContext.getAttachedActivity() != null) {
      localObject = this.mMiniAppContext.getAttachedActivity();
    } else {
      localObject = MiniAppEnv.g().getContext();
    }
    if (localObject != null)
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
      createRewardVideoAdView(paramRequestEvent, paramString1, paramString2, paramString4, (Context)localObject, localBundle, paramBoolean);
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
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleErrorAndInformJs errCode= ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg=");
    ((StringBuilder)localObject).append(str);
    QMLog.d("RewardedVideoAdPlugin", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("state", "error");
      ((JSONObject)localObject).put("errMsg", str);
      ((JSONObject)localObject).put("errCode", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        ((JSONObject)localObject).put("compId", paramString);
      }
      informJs(paramRequestEvent, (JSONObject)localObject, "onRewardedVideoStateChange");
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
  
  private void handleGooglePlay()
  {
    ChannelProxy localChannelProxy = (ChannelProxy)ProxyManager.get(ChannelProxy.class);
    if ((localChannelProxy != null) && (localChannelProxy.isGooglePlayVersion()))
    {
      int i = 0;
      if (WnsConfig.getConfig("qqminiapp", "mini_app_google_play_ad_switch", 0) == 1) {
        i = 1;
      }
      if ((i == 0) && (!this.mHasShowGPToast))
      {
        AppBrandTask.runTaskOnUiThread(new RewardedVideoAdPlugin.2(this));
        this.mHasShowGPToast = true;
      }
    }
  }
  
  private void handleInterval(Context paramContext, RequestEvent paramRequestEvent, String paramString, boolean paramBoolean, List<AdProxy.ExpParam> paramList)
  {
    AdProxy.AbsRewardVideoAdView localAbsRewardVideoAdView = this.mRewardedVideoAd;
    if (localAbsRewardVideoAdView != null)
    {
      localAbsRewardVideoAdView.loadTime = (System.currentTimeMillis() / 1000L);
      this.mRewardedVideoAd.loadInterval = AdUtil.getLoadIntervalFromExpParam(paramList);
      if (paramBoolean)
      {
        QMLog.i("RealTimeRewardedVideoAdPlugin", "showAdAfterLoad 展示实施拉取的新广告");
        handleLoadAndShow(this.mRewardedVideoAd, paramContext, paramRequestEvent, paramString);
      }
    }
  }
  
  private void handleLoad(RequestEvent paramRequestEvent, String paramString)
  {
    if ((this.mRewardedVideoAd != null) && (!this.mIsRequestingAd) && (!this.mRewardedVideoAd.needToLoadNewAd()))
    {
      QMLog.i("RealTimeRewardedVideoAdPlugin", "operateRewardedAd load 拉取广告信息 有现成的广告且没有超过时间限制");
      handleLoadAndInformJs(paramRequestEvent, true, paramString);
      return;
    }
    if (!this.mIsRequestingAd)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("operateRewardedAd load 拉取广告信息 是否因为广告过期：");
      localStringBuilder.append(this.mRewardedVideoAd.needToLoadNewAd());
      QMLog.i("RealTimeRewardedVideoAdPlugin", localStringBuilder.toString());
      initAdParam(paramRequestEvent, this.mPosID, paramString, false);
    }
  }
  
  private void handleLoadAndInformJs(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new RewardedVideoAdPlugin.3(this, paramString, paramBoolean, paramRequestEvent), 300L);
  }
  
  private void handleLoadAndShow(AdProxy.AbsRewardVideoAdView paramAbsRewardVideoAdView, Context paramContext, RequestEvent paramRequestEvent, String paramString)
  {
    boolean bool = isRewardedAdValid(paramAbsRewardVideoAdView);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleLoadAndShow isRewardedAdValid:");
    localStringBuilder.append(bool);
    QMLog.i("RealTimeRewardedVideoAdPlugin", localStringBuilder.toString());
    if (bool)
    {
      paramAbsRewardVideoAdView.showAD(paramContext, paramString);
      handleShowAndInformJs(paramRequestEvent, true, paramString);
      this.mRewardedVideoAd = null;
      this.mHasClosedAd = false;
      AdFrequencyLimit.setRewardVideoAdShowing(true);
      return;
    }
    handleShowAndInformJs(paramRequestEvent, false, paramString);
  }
  
  private void handleOnLoadAndInformJs(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleOnLoadAndInformJs isSucc= ");
    ((StringBuilder)localObject).append(paramBoolean);
    QMLog.d("RewardedVideoAdPlugin", ((StringBuilder)localObject).toString());
    localObject = new JSONObject();
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("state", "load");
        if (TextUtils.isEmpty(paramString)) {
          break label102;
        }
        ((JSONObject)localObject).put("compId", paramString);
      }
      catch (JSONException paramRequestEvent)
      {
        paramRequestEvent.printStackTrace();
        return;
      }
      ((JSONObject)localObject).put("status", paramString);
      informJs(paramRequestEvent, (JSONObject)localObject, "onRewardedVideoStateChange");
      return;
      label102:
      if (paramBoolean) {
        paramString = "ok";
      } else {
        paramString = "error";
      }
    }
  }
  
  private void handleShow(RequestEvent paramRequestEvent, String paramString)
  {
    if (isRewardedAdValid(this.mRewardedVideoAd))
    {
      QMLog.i("RealTimeRewardedVideoAdPlugin", "operateRewardedAd show 立即展示");
      Activity localActivity;
      if (this.mMiniAppContext != null) {
        localActivity = this.mMiniAppContext.getAttachedActivity();
      } else {
        localActivity = null;
      }
      this.mRewardedVideoAd.showAD(localActivity, paramString);
      handleShowAndInformJs(paramRequestEvent, true, paramString);
      this.mRewardedVideoAd = null;
      this.mHasClosedAd = false;
      AdFrequencyLimit.setRewardVideoAdShowing(true);
      return;
    }
    if (this.mRewardedVideoAd.needToLoadNewAd())
    {
      QMLog.i("RealTimeRewardedVideoAdPlugin", "operateRewardedAd show 拉取广告信息 是否因为广告过期：true 期望拉取后立即展示");
      initAdParam(paramRequestEvent, this.mPosID, paramString, true);
      return;
    }
    handleShowAndInformJs(paramRequestEvent, false, paramString);
  }
  
  private void handleShowAndInformJs(RequestEvent paramRequestEvent, boolean paramBoolean, String paramString)
  {
    AppBrandTask.runTaskOnUiThreadDelay(new RewardedVideoAdPlugin.4(this, paramString, paramBoolean, paramRequestEvent), 300L);
  }
  
  private void informJs(RequestEvent paramRequestEvent, JSONObject paramJSONObject, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("informJs d= ");
    localStringBuilder.append(String.valueOf(paramJSONObject));
    localStringBuilder.append(" event=");
    localStringBuilder.append(paramString);
    QMLog.d("RewardedVideoAdPlugin", localStringBuilder.toString());
    paramRequestEvent.jsService.evaluateSubscribeJS(paramString, paramJSONObject.toString(), 0);
  }
  
  private void initAdParam(RequestEvent paramRequestEvent, String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mIsRequestingAd = true;
    String str2 = LoginManager.getInstance().getAccount();
    String str3 = this.mApkgInfo.appId;
    int i;
    if (this.mIsOrientationLandscape) {
      i = 90;
    } else {
      i = 0;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle initAdParam appId = ");
    ((StringBuilder)localObject1).append(str3);
    ((StringBuilder)localObject1).append("， deviceOrient = ");
    ((StringBuilder)localObject1).append(i);
    ((StringBuilder)localObject1).append(" showAdAfterLoad:");
    ((StringBuilder)localObject1).append(paramBoolean);
    QMLog.i("RewardedVideoAdPlugin", ((StringBuilder)localObject1).toString());
    if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(paramString1)))
    {
      int j = getAdType(getMiniType());
      String str4 = AdUtil.getSpAdGdtCookie(j);
      Object localObject4 = this.mMiniAppInfo;
      Object localObject2;
      Object localObject3;
      String str1;
      if ((localObject4 != null) && (((MiniAppInfo)localObject4).launchParam != null))
      {
        if (((MiniAppInfo)localObject4).launchParam.entryPath != null) {
          localObject1 = ((MiniAppInfo)localObject4).launchParam.entryPath;
        } else {
          localObject1 = "";
        }
        if (((MiniAppInfo)localObject4).launchParam != null) {
          localObject2 = ((MiniAppInfo)localObject4).launchParam.reportData;
        } else {
          localObject2 = "";
        }
        localObject3 = String.valueOf(((MiniAppInfo)localObject4).launchParam.scene);
      }
      else
      {
        str1 = "";
        localObject1 = str1;
        localObject3 = localObject1;
        localObject2 = localObject1;
        localObject1 = str1;
      }
      if ((localObject4 != null) && (((MiniAppInfo)localObject4).via != null)) {
        str1 = ((MiniAppInfo)localObject4).via;
      } else {
        str1 = "";
      }
      localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("getRewardedVideoADInfo account= ");
      ((StringBuilder)localObject4).append(str2);
      ((StringBuilder)localObject4).append(" pos_id=");
      ((StringBuilder)localObject4).append(paramString1);
      QMLog.i("RewardedVideoAdPlugin", ((StringBuilder)localObject4).toString());
      doCreateRewardVideoAdView(paramRequestEvent, paramString1, paramString2, str2, str3, i, j, str4, (String)localObject1, (String)localObject2, (String)localObject3, str1, paramBoolean);
      return;
    }
    QMLog.e("RewardedVideoAdPlugin", "appid or pos_id is empty");
    handleGetAdFailed(paramRequestEvent, 1003, paramString2);
  }
  
  private boolean isRewardedAdValid(AdProxy.AbsRewardVideoAdView paramAbsRewardVideoAdView)
  {
    return (!this.mIsRequestingAd) && (paramAbsRewardVideoAdView != null) && (!paramAbsRewardVideoAdView.needToLoadNewAd()) && (this.mHasClosedAd);
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
    int i = MiniAppEnv.g().getContext().getResources().getConfiguration().orientation;
    boolean bool2 = true;
    boolean bool1;
    if (i == 2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.mIsOrientationLandscape = bool1;
    Object localObject1 = this.mRewardedVideoAd;
    if ((localObject1 == null) || (((AdProxy.AbsRewardVideoAdView)localObject1).needToLoadNewAd())) {}
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(paramRequestEvent.jsonParams);
        localObject2 = ((JSONObject)localObject1).optString("adUnitId");
        String str2 = ((JSONObject)localObject1).optString("compId");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          handleErrorAndInformJs(paramRequestEvent, 1002, str2);
          JSONObject localJSONObject = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
          if (localJSONObject == null) {
            break label290;
          }
          localObject1 = localJSONObject.toString();
          paramRequestEvent.fail(localJSONObject.toString());
          if (localObject1 != null) {
            return localObject1;
          }
        }
        this.mPosID = ((String)localObject2);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("createRewardedVideoAd 拉取广告信息 是否因为广告过期：");
        if (this.mRewardedVideoAd == null) {
          break label297;
        }
        bool1 = bool2;
        ((StringBuilder)localObject1).append(bool1);
        QMLog.i("RealTimeRewardedVideoAdPlugin", ((StringBuilder)localObject1).toString());
        initAdParam(paramRequestEvent, this.mPosID, str2, false);
        return "";
      }
      catch (Exception localException)
      {
        QMLog.e("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
        Object localObject2 = ApiUtil.wrapCallbackFail(paramRequestEvent.event, null);
        if (localObject2 != null) {
          str1 = ((JSONObject)localObject2).toString();
        } else {
          str1 = "";
        }
        handleErrorAndInformJs(paramRequestEvent, 1003, "");
        paramRequestEvent.fail(((JSONObject)localObject2).toString());
        if (str1 != null) {
          return str1;
        }
      }
      return "";
      label290:
      String str1 = "";
      continue;
      label297:
      bool1 = false;
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
    boolean bool;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
      bool = true;
    } else {
      bool = false;
    }
    this.mIsOrientationLandscape = bool;
    try
    {
      Object localObject = new JSONObject(paramRequestEvent.jsonParams);
      paramRequestEvent.ok();
      String str = ((JSONObject)localObject).optString("type");
      localObject = ((JSONObject)localObject).optString("compId");
      if ("load".equals(str))
      {
        handleLoad(paramRequestEvent, (String)localObject);
        return;
      }
      if ("show".equals(str))
      {
        handleShow(paramRequestEvent, (String)localObject);
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
      handleErrorAndInformJs(paramRequestEvent, 1003, "");
      paramRequestEvent.fail();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */