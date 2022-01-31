package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bdcy;
import bdcz;
import bdew;
import bdfx;
import bdfz;
import bdgg;
import bdgi;
import bdnw;
import bdyg;
import bdza;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsRewardVideoAdView;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
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
  private static final HashMap<Integer, String> errCodeMsgMap = bdza.a;
  private boolean mGetRewarded;
  private boolean mIsOrientationLandscape;
  private boolean mIsRequestingAd;
  private String mPosID = "";
  private AdProxy.AbsRewardVideoAdView mRewardedVideoAd;
  
  private void handleErrorAndInformJs(bdfz parambdfz, int paramInt, String paramString)
  {
    String str = (String)errCodeMsgMap.get(Integer.valueOf(paramInt));
    bdnw.a("RewardedVideoAdPlugin", "handleErrorAndInformJs errCode= " + paramInt + " errMsg=" + str);
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("state", "error");
      localJSONObject.put("errMsg", str);
      localJSONObject.put("errCode", paramInt);
      if (!TextUtils.isEmpty(paramString)) {
        localJSONObject.put("compId", paramString);
      }
      informJs(parambdfz, localJSONObject, "onRewardedVideoStateChange");
      return;
    }
    catch (JSONException parambdfz)
    {
      parambdfz.printStackTrace();
    }
  }
  
  private void handleGetAdFailed(bdfz parambdfz, int paramInt, String paramString)
  {
    handleErrorAndInformJs(parambdfz, paramInt, paramString);
    handleShowAndInformJs(parambdfz, false, paramString);
    handleLoadAndInformJs(parambdfz, false, paramString);
  }
  
  private void handleLoadAndInformJs(bdfz parambdfz, boolean paramBoolean, String paramString)
  {
    bdgi.a(new RewardedVideoAdPlugin.3(this, paramString, paramBoolean, parambdfz), 300L);
  }
  
  private void handleOnLoadAndInformJs(bdfz parambdfz, boolean paramBoolean, String paramString)
  {
    bdnw.a("RewardedVideoAdPlugin", "handleOnLoadAndInformJs isSucc= " + paramBoolean);
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
      catch (JSONException parambdfz)
      {
        parambdfz.printStackTrace();
        return;
      }
      localJSONObject.put("status", paramString);
      informJs(parambdfz, localJSONObject, "onRewardedVideoStateChange");
      return;
      paramString = "error";
      continue;
      label93:
      if (paramBoolean) {
        paramString = "ok";
      }
    }
  }
  
  private void handleShowAndInformJs(bdfz parambdfz, boolean paramBoolean, String paramString)
  {
    bdgi.a(new RewardedVideoAdPlugin.4(this, paramString, paramBoolean, parambdfz), 300L);
  }
  
  private void informJs(bdfz parambdfz, JSONObject paramJSONObject, String paramString)
  {
    bdnw.a("RewardedVideoAdPlugin", "informJs d= " + String.valueOf(paramJSONObject) + " event=" + paramString);
    parambdfz.jdField_a_of_type_Bdcy.a(paramString, paramJSONObject.toString(), 0);
  }
  
  private void initAdParam(bdfz parambdfz, String paramString1, String paramString2)
  {
    int j = 0;
    this.mRewardedVideoAd = null;
    String str3 = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
    String str4 = this.mApkgInfo.d;
    if (this.mIsOrientationLandscape) {}
    for (int i = 90;; i = 0)
    {
      bdnw.a("RewardedVideoAdPlugin", "handle initAdParam appId = " + str4 + "， deviceOrient = " + i);
      if (!TextUtils.isEmpty(str4)) {
        break;
      }
      bdnw.d("RewardedVideoAdPlugin", "TextUtils.isEmpty(appid)");
      handleGetAdFailed(parambdfz, 1003, paramString2);
      return;
    }
    label117:
    String str5;
    label130:
    Object localObject3;
    label177:
    String str1;
    label198:
    String str2;
    Object localObject2;
    if (this.mMiniAppInfo.isEngineTypeMiniApp())
    {
      this.mIsRequestingAd = true;
      if (j != 0) {
        break label407;
      }
      j = 3;
      str5 = bdyg.a(j);
      localObject3 = this.mMiniAppInfo;
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label434;
      }
      if (((MiniAppInfo)localObject3).launchParam.c == null) {
        break label413;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.c;
      if (((MiniAppInfo)localObject3).launchParam == null) {
        break label420;
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
        bdnw.a("RewardedVideoAdPlugin", "getRewardedVideoADInfo account= " + str3 + " pos_id=" + paramString1);
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
        bdgi.a(new RewardedVideoAdPlugin.2(this, (Activity)localObject3, str4, paramString1, parambdfz, paramString2, localBundle));
        return;
        j = 1;
        break label117;
        label407:
        j = 1;
        break label130;
        label413:
        localObject1 = "";
        break label177;
        label420:
        str1 = "";
        break label198;
      }
      label434:
      str1 = "";
      localObject2 = "";
    }
  }
  
  private void onCloseAd(bdfz parambdfz, boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.mGetRewarded) && (!paramBoolean))
    {
      this.mGetRewarded = false;
      return;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("state", "close");
      localJSONObject.put("isEnded", paramBoolean);
      if (!TextUtils.isEmpty(paramString2)) {
        localJSONObject.put("compId", paramString2);
      }
      informJs(parambdfz, localJSONObject, "onRewardedVideoStateChange");
      bdew.a(new RewardedVideoAdPlugin.1(this, parambdfz, paramString1, paramString2), 16, null, true);
      return;
    }
    catch (JSONException paramString1)
    {
      bdnw.d("RewardedVideoAdPlugin", "doOnActivityResult failed e:", paramString1);
      handleErrorAndInformJs(parambdfz, 1003, paramString2);
    }
  }
  
  public String createRewardedVideoAd(bdfz parambdfz)
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
        Object localObject1 = new JSONObject(parambdfz.b);
        localObject2 = ((JSONObject)localObject1).optString("adUnitId");
        String str2 = ((JSONObject)localObject1).optString("compId");
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          handleErrorAndInformJs(parambdfz, 1002, str2);
          JSONObject localJSONObject = bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null);
          if (localJSONObject == null) {
            break label205;
          }
          localObject1 = localJSONObject.toString();
          parambdfz.a(localJSONObject.toString());
          if (localObject1 != null) {
            return localObject1;
          }
        }
        this.mPosID = ((String)localObject2);
        initAdParam(parambdfz, this.mPosID, str2);
        return "";
      }
      catch (Exception localException)
      {
        bdnw.d("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localException);
        localObject2 = bdgg.b(parambdfz.jdField_a_of_type_JavaLangString, null);
        if (localObject2 == null) {}
      }
      for (String str1 = ((JSONObject)localObject2).toString();; str1 = "")
      {
        handleErrorAndInformJs(parambdfz, 1003, "");
        parambdfz.a(((JSONObject)localObject2).toString());
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
  
  public void operateRewardedAd(bdfz parambdfz)
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
        localObject = new JSONObject(parambdfz.b);
        parambdfz.a();
        String str = ((JSONObject)localObject).optString("type");
        localObject = ((JSONObject)localObject).optString("compId");
        if ("load".equals(str))
        {
          if (this.mRewardedVideoAd != null)
          {
            handleLoadAndInformJs(parambdfz, true, (String)localObject);
            return;
          }
          if (this.mIsRequestingAd) {
            break label189;
          }
          initAdParam(parambdfz, this.mPosID, (String)localObject);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        bdnw.d("RewardedVideoAdPlugin", "API_AD_CREATE_REWARDED_VIDEO_AD failed e:", localJSONException);
        handleErrorAndInformJs(parambdfz, 1003, "");
        parambdfz.b();
        return;
      }
      if ("show".equals(localJSONException)) {
        if (this.mRewardedVideoAd == null) {
          break label195;
        }
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        this.mRewardedVideoAd.showAD();
        handleShowAndInformJs(parambdfz, true, (String)localObject);
        this.mRewardedVideoAd = null;
        return;
      }
      handleShowAndInformJs(parambdfz, false, (String)localObject);
      label189:
      return;
      bool = false;
      break;
      label195:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.RewardedVideoAdPlugin
 * JD-Core Version:    0.7.0.1
 */