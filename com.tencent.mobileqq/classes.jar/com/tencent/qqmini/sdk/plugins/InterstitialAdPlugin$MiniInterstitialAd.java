package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IJsService;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsInterstitialAdView;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.InterstitialADLisener;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.manager.LoginManager;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

class InterstitialAdPlugin$MiniInterstitialAd
{
  private static final String ADUNIT_ID = "adUnitId";
  private static final String APP_Interstitial_ID = "id";
  private static final String COMP_ID = "compId";
  private static final String OPERATION_TYPE = "type";
  private static final String TAG = "SDK_MiniInterstitialAd";
  private AdProxy.AbsInterstitialAdView adInterstitial;
  private String adUnitId;
  private String appId;
  private int appInterstitialId;
  private WeakReference<Activity> mActivity;
  private volatile boolean mIsRequestingAd = false;
  private IJsService mJsService;
  private AdProxy.InterstitialADLisener mListener;
  
  InterstitialAdPlugin$MiniInterstitialAd(InterstitialAdPlugin paramInterstitialAdPlugin, Activity paramActivity, int paramInt, String paramString1, String paramString2, IJsService paramIJsService)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.appInterstitialId = paramInt;
    this.adUnitId = paramString1;
    this.appId = paramString2;
    this.mJsService = paramIJsService;
  }
  
  private void callbackJs(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mJsService != null) {
      if (!paramBoolean) {
        break label75;
      }
    }
    label75:
    for (paramString = ApiUtil.wrapCallbackOk(paramString, getResultObj(paramInt1, paramInt2));; paramString = ApiUtil.wrapCallbackFail(paramString, getResultObj(paramInt1, paramInt2), (String)InterstitialAdPlugin.S_CodeMsg_Map.get(Integer.valueOf(paramInt2))))
    {
      paramString = paramString.toString();
      QMLog.i("SDK_MiniInterstitialAd", "evaluateCallbackJs callbackId: " + paramInt3 + " content:" + paramString);
      this.mJsService.evaluateCallbackJs(paramInt3, paramString);
      return;
    }
  }
  
  private JSONObject getResultObj(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.appInterstitialId);
      localJSONObject.put("compId", paramInt1);
      localJSONObject.put("adUnitId", this.adUnitId);
      localJSONObject.put("errCode", paramInt2);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      QMLog.e("SDK_MiniInterstitialAd", "getResultObj e:", localThrowable);
      return localJSONObject;
    }
    finally {}
    return localJSONObject;
  }
  
  private boolean initAdParam(int paramInt1, int paramInt2)
  {
    String str3 = LoginManager.getInstance().getAccount();
    if (TextUtils.isEmpty(this.appId))
    {
      QMLog.e("SDK_MiniInterstitialAd", "TextUtils.isEmpty(appid)");
      return false;
    }
    int i;
    label55:
    int j;
    Object localObject3;
    Object localObject1;
    label143:
    String str1;
    String str2;
    Object localObject2;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2)
    {
      i = 1;
      if (i == 0) {
        break label399;
      }
      i = 90;
      QMLog.i("SDK_MiniInterstitialAd", "handle initAdParam appId = " + this.appId + "， deviceOrient = " + i);
      j = InterstitialAdPlugin.access$400(this.this$0);
      localObject3 = InterstitialAdPlugin.access$500(this.this$0);
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label426;
      }
      if (((MiniAppInfo)localObject3).launchParam.entryPath == null) {
        break label404;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
      str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
      str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
      localObject2 = localObject1;
      localObject1 = str2;
    }
    for (;;)
    {
      label194:
      String str4;
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
      {
        str2 = ((MiniAppInfo)localObject3).via;
        str4 = AdUtil.getSpAdGdtCookie(j);
        WnsConfig.getConfig("QZoneSetting", "MiniGameShareRate", 53);
        if (this.mActivity == null) {
          break label420;
        }
      }
      label399:
      label404:
      label420:
      for (localObject3 = (Activity)this.mActivity.get();; localObject3 = null)
      {
        if (localObject3 == null) {
          break label424;
        }
        Bundle localBundle = new Bundle();
        localBundle.putString(AdProxy.KEY_ACCOUNT, str3);
        localBundle.putInt(AdProxy.KEY_AD_TYPE, j);
        localBundle.putInt(AdProxy.KEY_ORIENTATION, i);
        localBundle.putString(AdProxy.KEY_GDT_COOKIE, str4);
        localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject2);
        localBundle.putString(AdProxy.KEY_REPORT_DATA, str1);
        localBundle.putString(AdProxy.KEY_REFER, (String)localObject1);
        localBundle.putString(AdProxy.KEY_VIA, str2);
        this.mListener = new InterstitialAdPlugin.MiniInterstitialAd.2(this, paramInt1, paramInt2);
        this.adInterstitial = ((AdProxy)ProxyManager.get(AdProxy.class)).createInterstitialAdView((Activity)localObject3, this.appId, this.adUnitId, this.mListener, localBundle, InterstitialAdPlugin.access$900(this.this$0));
        if (this.adInterstitial != null) {
          this.adInterstitial.loadAD();
        }
        return true;
        i = 0;
        break;
        i = 0;
        break label55;
        localObject1 = "";
        break label143;
        str2 = "";
        break label194;
      }
      label424:
      break;
      label426:
      localObject1 = "";
      str1 = "";
      localObject2 = "";
    }
  }
  
  boolean destroy()
  {
    if (this.adInterstitial != null)
    {
      this.adInterstitial.destroy();
      this.adInterstitial = null;
    }
    this.mListener = null;
    return true;
  }
  
  boolean load(int paramInt1, int paramInt2)
  {
    boolean bool = true;
    if (!this.mIsRequestingAd)
    {
      this.mIsRequestingAd = true;
      bool = initAdParam(paramInt1, paramInt2);
    }
    return bool;
  }
  
  void setActivity(Activity paramActivity)
  {
    this.mActivity = new WeakReference(paramActivity);
  }
  
  void setJsService(IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
  boolean show(int paramInt1, int paramInt2)
  {
    if ((this.adInterstitial == null) || (this.mActivity == null) || (this.mActivity.get() == null)) {
      return false;
    }
    AppBrandTask.runTaskOnUiThread(new InterstitialAdPlugin.MiniInterstitialAd.1(this, paramInt1, paramInt2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InterstitialAdPlugin.MiniInterstitialAd
 * JD-Core Version:    0.7.0.1
 */