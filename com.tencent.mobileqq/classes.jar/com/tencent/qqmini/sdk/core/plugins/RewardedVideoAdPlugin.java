package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import behm;
import behp;
import behq;
import bekp;
import bekr;
import bekx;
import bekz;
import betc;
import beut;
import bfgd;
import bfhh;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public class RewardedVideoAdPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_REWARDED_VIDEO_SHOW_DONE = "onRewardedVideoShowDone";
  public static final String EVENT_REWARDED_VIDEO_STATE_CHANGE = "onRewardedVideoStateChange";
  private static final String TAG = "RewardedVideoAdPlugin";
  private static final HashMap<Integer, String> errCodeMsgMap = bfhh.a;
  private boolean mGetRewarded;
  private boolean mIsOrientationLandscape;
  private boolean mIsRequestingAd;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void handleErrorAndInformJs(bekr parambekr, int paramInt, String paramString)
  {
    String str = (String)errCodeMsgMap.get(Integer.valueOf(paramInt));
    betc.a("RewardedVideoAdPlugin", "handleErrorAndInformJs errCode= " + paramInt + " errMsg=" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", str);
      localJSONObject.put("errCode", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(parambekr, localJSONObject, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException parambekr)
    {
      parambekr.printStackTrace();
    }
  }
  
  private void handleGetAdFailed(bekr parambekr, int paramInt, String paramString)
  {
    handleErrorAndInformJs(parambekr, paramInt, paramString);
    handleShowAndInformJs(parambekr, false, paramString);
    handleLoadAndInformJs(parambekr, false, paramString);
  }
  
  private void handleLoadAndInformJs(bekr parambekr, boolean paramBoolean, String paramString)
  {
    bekz.a(new RewardedVideoAdPlugin.2(this, paramString, paramBoolean, parambekr), 300L);
  }
  
  private void handleOnLoadAndInformJs(bekr parambekr, boolean paramBoolean, String paramString)
  {
    betc.a("RewardedVideoAdPlugin", "handleOnLoadAndInformJs isSucc= " + paramBoolean);
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
      catch (JSONException parambekr)
      {
        parambekr.printStackTrace();
        return;
      }
      localJSONObject.put("status", paramString);
      informJs(parambekr, localJSONObject, "onRewardedVideoStateChange");
      return;
      paramString = "error";
      continue;
      label93:
      if (paramBoolean) {
        paramString = "ok";
      }
    }
  }
  
  private void handleShowAndInformJs(bekr parambekr, boolean paramBoolean, String paramString)
  {
    bekz.a(new RewardedVideoAdPlugin.3(this, paramString, paramBoolean, parambekr), 300L);
  }
  
  private void informJs(bekr parambekr, JSONObject paramJSONObject, String paramString)
  {
    betc.a("RewardedVideoAdPlugin", "informJs d= " + String.valueOf(paramJSONObject) + " event=" + paramString);
    parambekr.jdField_a_of_type_Behp.a(paramString, paramJSONObject.toString(), 0);
  }
  
  private void initAdParam(bekr parambekr, String paramString1, String paramString2)
  {
    int j = 0;
    this.mRewardedVideoAd = null;
    String str3 = beut.a().a();
    String str4 = this.mApkgInfo.d;
    if (this.mIsOrientationLandscape) {}
    for (int i = 90;; i = 0)
    {
      betc.b("RewardedVideoAdPlugin", "handle initAdParam appId = " + str4 + "， deviceOrient = " + i);
      if (!TextUtils.isEmpty(str4)) {
        break;
      }
      betc.d("RewardedVideoAdPlugin", "TextUtils.isEmpty(appid)");
      handleGetAdFailed(parambekr, 1003, paramString2);
      return;
    }
    label112:
    label125:
    String str5;
    Object localObject3;
    label172:
    String str1;
    label193:
    String str2;
    Object localObject2;
    if (this.mMiniAppInfo.isEngineTypeMiniApp())
    {
      this.mIsRequestingAd = true;
      if (j != 0) {
        break label402;
      }
      j = 3;
      str5 = bfgd.a(j);
      localObject3 = this.mMiniAppInfo;
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label429;
      }
      if (((MiniAppInfo)localObject3).launchParam.c == null) {
        break label408;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.c;
      if (((MiniAppInfo)localObject3).launchParam == null) {
        break label415;
      }
      str1 = MiniAppInfo.getReportDataString(((MiniAppInfo)localObject3).launchParam.jdField_a_of_type_JavaUtilMap);
      str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.jdField_a_of_type_Int);
      localObject2 = localObject1;
    }
    for (Object localObject1 = str2;; localObject1 = "")
    {
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null)) {}
      for (str2 = ((MiniAppInfo)localObject3).via;; str2 = "")
      {
        betc.b("RewardedVideoAdPlugin", "getRewardedVideoADInfo account= " + str3 + " pos_id=" + paramString1);
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
        bekz.a(new RewardedVideoAdPlugin.1(this, (Activity)localObject3, str4, paramString1, parambekr, paramString2, localBundle));
        return;
        j = 1;
        break label112;
        label402:
        j = 1;
        break label125;
        label408:
        localObject1 = "";
        break label172;
        label415:
        str1 = "";
        break label193;
      }
      label429:
      str1 = "";
      localObject2 = "";
    }
  }
  
  private void onCloseAd(bekr parambekr, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.mGetRewarded) && (!paramBoolean))
    {
      this.mGetRewarded = false;
      return;
    }
    try
    {
      paramString1 = new JSONObject();
      paramString1.put("state", "close");
      paramString1.put("isEnded", paramBoolean);
      if (!TextUtils.isEmpty(paramString2)) {
        paramString1.put("compId", paramString2);
      }
      informJs(parambekr, paramString1, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException paramString1)
    {
      betc.d("RewardedVideoAdPlugin", "doOnActivityResult failed e:", paramString1);
      handleErrorAndInformJs(parambekr, 1003, paramString2);
    }
  }
  
  public String createRewardedVideoAd(bekr parambekr)
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
        Object localObject1 = new JSONObject(parambekr.b);
        localObject2 = ((JSONObject)localObject1).optString("adUnitId");
        String str2 = ((JSONObject)localObject1).optString("compId");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          handleErrorAndInformJs(parambekr, 1002, str2);
          JSONObject localJSONObject = bekx.b(parambekr.jdField_a_of_type_JavaLangString, null);
          if (localJSONObject == null) {
            break label205;
          }
          localObject1 = localJSONObject.toString();
          parambekr.a(localJSONObject.toString());
          if (localObject1 != null) {
            return localObject1;
          }
        }
        this.mPosID = ((String)localObject2);
        initAdParam(parambekr, this.mPosID, str2);
        return "";
      }
      catch (Exception localException)
      {
        betc.d("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
        localObject2 = bekx.b(parambekr.jdField_a_of_type_JavaLangString, null);
        if (localObject2 == null) {}
      }
      for (String str1 = ((JSONObject)localObject2).toString();; str1 = "")
      {
        handleErrorAndInformJs(parambekr, 1003, "");
        parambekr.a(((JSONObject)localObject2).toString());
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
    if (localAdProxy != null) {
      localAdProxy.destroy();
    }
    super.onDestroy();
  }
  
  public void operateRewardedAd(bekr parambekr)
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
        localObject = new JSONObject(parambekr.b);
        parambekr.a();
        String str = ((JSONObject)localObject).optString("type");
        localObject = ((JSONObject)localObject).optString("compId");
        if ("load".equals(str))
        {
          if (this.mRewardedVideoAd != null)
          {
            handleLoadAndInformJs(parambekr, true, (String)localObject);
            return;
          }
          if (this.mIsRequestingAd) {
            break label193;
          }
          initAdParam(parambekr, this.mPosID, (String)localObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        betc.d("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
        handleErrorAndInformJs(parambekr, 1003, "");
        parambekr.b();
        return;
      }
      if ("show".equals(localJSONException)) {
        if (this.mRewardedVideoAd == null) {
          break label199;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.mRewardedVideoAd.showAD();
        handleShowAndInformJs(parambekr, true, (String)localObject);
        this.mRewardedVideoAd = null;
        behm.a(true);
        return;
      }
      handleShowAndInformJs(parambekr, false, (String)localObject);
      label193:
      return;
      bool = false;
      break;
      label199:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */