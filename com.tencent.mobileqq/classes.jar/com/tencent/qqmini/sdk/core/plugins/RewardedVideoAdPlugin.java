package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import begv;
import begy;
import begz;
import bejy;
import beka;
import bekg;
import beki;
import besl;
import beuc;
import bffm;
import bfgq;
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
  private static final HashMap<Integer, String> errCodeMsgMap = bfgq.a;
  private boolean mGetRewarded;
  private boolean mIsOrientationLandscape;
  private boolean mIsRequestingAd;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void handleErrorAndInformJs(beka parambeka, int paramInt, String paramString)
  {
    String str = (String)errCodeMsgMap.get(Integer.valueOf(paramInt));
    besl.a("RewardedVideoAdPlugin", "handleErrorAndInformJs errCode= " + paramInt + " errMsg=" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", str);
      localJSONObject.put("errCode", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(parambeka, localJSONObject, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException parambeka)
    {
      parambeka.printStackTrace();
    }
  }
  
  private void handleGetAdFailed(beka parambeka, int paramInt, String paramString)
  {
    handleErrorAndInformJs(parambeka, paramInt, paramString);
    handleShowAndInformJs(parambeka, false, paramString);
    handleLoadAndInformJs(parambeka, false, paramString);
  }
  
  private void handleLoadAndInformJs(beka parambeka, boolean paramBoolean, String paramString)
  {
    beki.a(new RewardedVideoAdPlugin.2(this, paramString, paramBoolean, parambeka), 300L);
  }
  
  private void handleOnLoadAndInformJs(beka parambeka, boolean paramBoolean, String paramString)
  {
    besl.a("RewardedVideoAdPlugin", "handleOnLoadAndInformJs isSucc= " + paramBoolean);
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
      catch (JSONException parambeka)
      {
        parambeka.printStackTrace();
        return;
      }
      localJSONObject.put("status", paramString);
      informJs(parambeka, localJSONObject, "onRewardedVideoStateChange");
      return;
      paramString = "error";
      continue;
      label93:
      if (paramBoolean) {
        paramString = "ok";
      }
    }
  }
  
  private void handleShowAndInformJs(beka parambeka, boolean paramBoolean, String paramString)
  {
    beki.a(new RewardedVideoAdPlugin.3(this, paramString, paramBoolean, parambeka), 300L);
  }
  
  private void informJs(beka parambeka, JSONObject paramJSONObject, String paramString)
  {
    besl.a("RewardedVideoAdPlugin", "informJs d= " + String.valueOf(paramJSONObject) + " event=" + paramString);
    parambeka.jdField_a_of_type_Begy.a(paramString, paramJSONObject.toString(), 0);
  }
  
  private void initAdParam(beka parambeka, String paramString1, String paramString2)
  {
    int j = 0;
    this.mRewardedVideoAd = null;
    String str3 = beuc.a().a();
    String str4 = this.mApkgInfo.d;
    if (this.mIsOrientationLandscape) {}
    for (int i = 90;; i = 0)
    {
      besl.b("RewardedVideoAdPlugin", "handle initAdParam appId = " + str4 + "， deviceOrient = " + i);
      if (!TextUtils.isEmpty(str4)) {
        break;
      }
      besl.d("RewardedVideoAdPlugin", "TextUtils.isEmpty(appid)");
      handleGetAdFailed(parambeka, 1003, paramString2);
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
      str5 = bffm.a(j);
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
        besl.b("RewardedVideoAdPlugin", "getRewardedVideoADInfo account= " + str3 + " pos_id=" + paramString1);
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
        beki.a(new RewardedVideoAdPlugin.1(this, (Activity)localObject3, str4, paramString1, parambeka, paramString2, localBundle));
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
  
  private void onCloseAd(beka parambeka, boolean paramBoolean, String paramString1, String paramString2)
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
      informJs(parambeka, paramString1, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException paramString1)
    {
      besl.d("RewardedVideoAdPlugin", "doOnActivityResult failed e:", paramString1);
      handleErrorAndInformJs(parambeka, 1003, paramString2);
    }
  }
  
  public String createRewardedVideoAd(beka parambeka)
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
        Object localObject1 = new JSONObject(parambeka.b);
        localObject2 = ((JSONObject)localObject1).optString("adUnitId");
        String str2 = ((JSONObject)localObject1).optString("compId");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          handleErrorAndInformJs(parambeka, 1002, str2);
          JSONObject localJSONObject = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
          if (localJSONObject == null) {
            break label205;
          }
          localObject1 = localJSONObject.toString();
          parambeka.a(localJSONObject.toString());
          if (localObject1 != null) {
            return localObject1;
          }
        }
        this.mPosID = ((String)localObject2);
        initAdParam(parambeka, this.mPosID, str2);
        return "";
      }
      catch (Exception localException)
      {
        besl.d("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
        localObject2 = bekg.b(parambeka.jdField_a_of_type_JavaLangString, null);
        if (localObject2 == null) {}
      }
      for (String str1 = ((JSONObject)localObject2).toString();; str1 = "")
      {
        handleErrorAndInformJs(parambeka, 1003, "");
        parambeka.a(((JSONObject)localObject2).toString());
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
  
  public void operateRewardedAd(beka parambeka)
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
        localObject = new JSONObject(parambeka.b);
        parambeka.a();
        String str = ((JSONObject)localObject).optString("type");
        localObject = ((JSONObject)localObject).optString("compId");
        if ("load".equals(str))
        {
          if (this.mRewardedVideoAd != null)
          {
            handleLoadAndInformJs(parambeka, true, (String)localObject);
            return;
          }
          if (this.mIsRequestingAd) {
            break label193;
          }
          initAdParam(parambeka, this.mPosID, (String)localObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        besl.d("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
        handleErrorAndInformJs(parambeka, 1003, "");
        parambeka.b();
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
        handleShowAndInformJs(parambeka, true, (String)localObject);
        this.mRewardedVideoAd = null;
        begv.a(true);
        return;
      }
      handleShowAndInformJs(parambeka, false, (String)localObject);
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