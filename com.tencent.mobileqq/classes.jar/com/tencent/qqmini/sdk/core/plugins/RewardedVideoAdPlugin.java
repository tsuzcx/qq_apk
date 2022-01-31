package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bglr;
import bglu;
import bglv;
import bgod;
import bgok;
import bgop;
import bgor;
import bgxl;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.AdUtil;
import com.tencent.qqmini.sdk.utils.MiniSDKConst.AdConst;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RewardedVideoAdPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_REWARDED_VIDEO_SHOW_DONE = "onRewardedVideoShowDone";
  public static final String EVENT_REWARDED_VIDEO_STATE_CHANGE = "onRewardedVideoStateChange";
  private static final String TAG = "RewardedVideoAdPlugin";
  private static final HashMap<Integer, String> errCodeMsgMap = MiniSDKConst.AdConst.CodeMsgMap;
  private boolean mGetRewarded;
  private boolean mHasShowGPToast;
  private boolean mIsOrientationLandscape;
  private volatile boolean mIsRequestingAd;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void handleErrorAndInformJs(bgok parambgok, int paramInt, String paramString)
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
      informJs(parambgok, localJSONObject, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException parambgok)
    {
      parambgok.printStackTrace();
    }
  }
  
  private void handleGetAdFailed(bgok parambgok, int paramInt, String paramString)
  {
    handleErrorAndInformJs(parambgok, paramInt, paramString);
    handleShowAndInformJs(parambgok, false, paramString);
    handleLoadAndInformJs(parambgok, false, paramString);
  }
  
  private void handleLoadAndInformJs(bgok parambgok, boolean paramBoolean, String paramString)
  {
    bgor.a(new RewardedVideoAdPlugin.2(this, paramString, paramBoolean, parambgok), 300L);
  }
  
  private void handleOnLoadAndInformJs(bgok parambgok, boolean paramBoolean, String paramString)
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
      catch (JSONException parambgok)
      {
        parambgok.printStackTrace();
        return;
      }
      localJSONObject.put("status", paramString);
      informJs(parambgok, localJSONObject, "onRewardedVideoStateChange");
      return;
      paramString = "error";
      continue;
      label93:
      if (paramBoolean) {
        paramString = "ok";
      }
    }
  }
  
  private void handleShowAndInformJs(bgok parambgok, boolean paramBoolean, String paramString)
  {
    bgor.a(new RewardedVideoAdPlugin.3(this, paramString, paramBoolean, parambgok), 300L);
  }
  
  private void informJs(bgok parambgok, JSONObject paramJSONObject, String paramString)
  {
    QMLog.d("RewardedVideoAdPlugin", "informJs d= " + String.valueOf(paramJSONObject) + " event=" + paramString);
    parambgok.jdField_a_of_type_Bglu.a(paramString, paramJSONObject.toString(), 0);
  }
  
  private void initAdParam(bgok parambgok, String paramString1, String paramString2)
  {
    int j = 0;
    this.mRewardedVideoAd = null;
    String str3 = bgxl.a().a();
    String str4 = this.mApkgInfo.appId;
    if (this.mIsOrientationLandscape) {}
    for (int i = 90;; i = 0)
    {
      QMLog.i("RewardedVideoAdPlugin", "handle initAdParam appId = " + str4 + "， deviceOrient = " + i);
      if (!TextUtils.isEmpty(str4)) {
        break;
      }
      QMLog.e("RewardedVideoAdPlugin", "TextUtils.isEmpty(appid)");
      handleGetAdFailed(parambgok, 1003, paramString2);
      return;
    }
    label112:
    label125:
    String str5;
    Object localObject3;
    label172:
    String str1;
    label190:
    String str2;
    Object localObject2;
    if (this.mMiniAppInfo.isEngineTypeMiniApp())
    {
      this.mIsRequestingAd = true;
      if (j != 0) {
        break label399;
      }
      j = 3;
      str5 = AdUtil.getSpAdGdtCookie(j);
      localObject3 = this.mMiniAppInfo;
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label426;
      }
      if (((MiniAppInfo)localObject3).launchParam.entryPath == null) {
        break label405;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
      if (((MiniAppInfo)localObject3).launchParam == null) {
        break label412;
      }
      str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
      str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = "")
    {
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null)) {}
      for (str2 = ((MiniAppInfo)localObject3).via;; str2 = "")
      {
        QMLog.i("RewardedVideoAdPlugin", "getRewardedVideoADInfo account= " + str3 + " pos_id=" + paramString1);
        localObject3 = this.mMiniAppContext.a();
        if (localObject3 == null) {
          break;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString(AdProxy.KEY_ACCOUNT, str3);
        localBundle.putInt(AdProxy.KEY_AD_TYPE, j);
        localBundle.putInt(AdProxy.KEY_ORIENTATION, i);
        localBundle.putString(AdProxy.KEY_GDT_COOKIE, str5);
        localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject2);
        localBundle.putString(AdProxy.KEY_REPORT_DATA, str1);
        localBundle.putString(AdProxy.KEY_REFER, (String)localObject1);
        localBundle.putString(AdProxy.KEY_VIA, str2);
        bgor.a(new RewardedVideoAdPlugin.1(this, (Activity)localObject3, str4, paramString1, parambgok, paramString2, localBundle));
        return;
        j = 1;
        break label112;
        label399:
        j = 1;
        break label125;
        label405:
        localObject1 = "";
        break label172;
        label412:
        str1 = "";
        break label190;
      }
      label426:
      str1 = "";
      localObject2 = "";
    }
  }
  
  private void onCloseAd(bgok parambgok, String paramString)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "close");
      localJSONObject.put("isEnded", this.mGetRewarded);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(parambgok, localJSONObject, "onRewardedVideoStateChange");
      this.mGetRewarded = false;
      return;
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("RewardedVideoAdPlugin", "doOnActivityResult failed e:", localJSONException);
      handleErrorAndInformJs(parambgok, 1003, paramString);
    }
  }
  
  public String createRewardedVideoAd(bgok parambgok)
  {
    boolean bool;
    if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation == 2)
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
        Object localObject1 = new JSONObject(parambgok.b);
        localObject2 = ((JSONObject)localObject1).optString("adUnitId");
        String str2 = ((JSONObject)localObject1).optString("compId");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          handleErrorAndInformJs(parambgok, 1002, str2);
          JSONObject localJSONObject = bgop.b(parambgok.jdField_a_of_type_JavaLangString, null);
          if (localJSONObject == null) {
            break label210;
          }
          localObject1 = localJSONObject.toString();
          parambgok.a(localJSONObject.toString());
          if (localObject1 != null) {
            return localObject1;
          }
        }
        this.mPosID = ((String)localObject2);
        initAdParam(parambgok, this.mPosID, str2);
        return "";
      }
      catch (Exception localException)
      {
        QMLog.e("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
        localObject2 = bgop.b(parambgok.jdField_a_of_type_JavaLangString, null);
        if (localObject2 == null) {}
      }
      for (String str1 = ((JSONObject)localObject2).toString();; str1 = "")
      {
        handleErrorAndInformJs(parambgok, 1003, "");
        parambgok.a(((JSONObject)localObject2).toString());
        if (str1 == null) {
          break;
        }
        return str1;
      }
      bool = false;
      break;
      label210:
      str1 = "";
    }
  }
  
  public void onDestroy()
  {
    AdProxy localAdProxy = (AdProxy)ProxyManager.get(AdProxy.class);
    if ((localAdProxy != null) && (localAdProxy != null) && (this.mMiniAppContext != null) && (this.mMiniAppContext.a() != null)) {
      localAdProxy.destroy(this.mMiniAppContext.a());
    }
    super.onDestroy();
  }
  
  public void operateRewardedAd(bgok parambgok)
  {
    int i = 1;
    boolean bool;
    Object localObject;
    if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation == 2)
    {
      bool = true;
      this.mIsOrientationLandscape = bool;
      try
      {
        localObject = new JSONObject(parambgok.b);
        parambgok.a();
        String str = ((JSONObject)localObject).optString("type");
        localObject = ((JSONObject)localObject).optString("compId");
        if ("load".equals(str))
        {
          if (this.mRewardedVideoAd != null)
          {
            handleLoadAndInformJs(parambgok, true, (String)localObject);
            return;
          }
          if (this.mIsRequestingAd) {
            break label205;
          }
          initAdParam(parambgok, this.mPosID, (String)localObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QMLog.e("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
        handleErrorAndInformJs(parambgok, 1003, "");
        parambgok.b();
        return;
      }
      if ("show".equals(localJSONException)) {
        if ((this.mIsRequestingAd) || (this.mRewardedVideoAd == null)) {
          break label211;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.mRewardedVideoAd.showAD();
        handleShowAndInformJs(parambgok, true, (String)localObject);
        this.mRewardedVideoAd = null;
        bglr.a(true);
        return;
      }
      handleShowAndInformJs(parambgok, false, (String)localObject);
      label205:
      return;
      bool = false;
      break;
      label211:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */