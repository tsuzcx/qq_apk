package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import bghn;
import bgki;
import bgkk;
import bglq;
import bgte;
import com.tencent.qqmini.sdk.core.proxy.AdProxy;
import com.tencent.qqmini.sdk.core.proxy.AdProxy.AbsBoxAdView;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.IMiniAppEnv;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.AdUtil;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import org.json.JSONObject;

class AppBoxPlugin$MiniAppBox
{
  private static final String ADUNIT_ID = "adUnitId";
  private static final String APP_BOX_ID = "id";
  private static final String COMP_ID = "compId";
  private static final String OPERATION_TYPE = "type";
  private static final String TAG = "SDK_MiniAppBox";
  private AdProxy.AbsBoxAdView adBox;
  private String adUnitId;
  private int appBoxId;
  private String appId;
  private WeakReference<Activity> mActivity;
  private volatile boolean mIsRequestingAd;
  private bghn mJsService;
  
  AppBoxPlugin$MiniAppBox(AppBoxPlugin paramAppBoxPlugin, Activity paramActivity, int paramInt, String paramString1, String paramString2, bghn parambghn)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.appBoxId = paramInt;
    this.adUnitId = paramString1;
    this.appId = paramString2;
    this.mJsService = parambghn;
  }
  
  private void callbackJs(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mJsService != null) {
      if (!paramBoolean) {
        break label75;
      }
    }
    label75:
    for (paramString = bgki.a(paramString, getResultObj(paramInt1, paramInt2));; paramString = bgki.a(paramString, getResultObj(paramInt1, paramInt2), (String)AppBoxPlugin.S_CodeMsg_Map.get(Integer.valueOf(paramInt2))))
    {
      paramString = paramString.toString();
      QMLog.i("SDK_MiniAppBox", "evaluateCallbackJs callbackId: " + paramInt3 + " content:" + paramString);
      this.mJsService.a(paramInt3, paramString);
      return;
    }
  }
  
  private JSONObject getResultObj(int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.appBoxId);
      localJSONObject.put("compId", paramInt1);
      localJSONObject.put("adUnitId", this.adUnitId);
      localJSONObject.put("errCode", paramInt2);
      return localJSONObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable = localThrowable;
      QMLog.e("SDK_MiniAppBox", "getResultObj e:", localThrowable);
      return localJSONObject;
    }
    finally {}
    return localJSONObject;
  }
  
  private boolean initAdParam(int paramInt1, int paramInt2)
  {
    String str3 = bgte.a().a();
    if (TextUtils.isEmpty(this.appId))
    {
      QMLog.e("SDK_MiniAppBox", "TextUtils.isEmpty(appid)");
      return false;
    }
    int i;
    label60:
    int j;
    label122:
    Object localObject3;
    label131:
    Object localObject1;
    label174:
    String str1;
    label192:
    String str2;
    Object localObject2;
    if (AppLoaderFactory.g().getMiniAppEnv().getContext().getResources().getConfiguration().orientation == 2)
    {
      i = 1;
      if (i == 0) {
        break label421;
      }
      i = 90;
      QMLog.i("SDK_MiniAppBox", "handle initAdParam appId = " + this.appId + "， deviceOrient = " + i);
      if ((this.this$0.mMiniAppInfo == null) || (!this.this$0.mMiniAppInfo.isEngineTypeMiniApp())) {
        break label426;
      }
      j = 0;
      if (j != 0) {
        break label432;
      }
      j = 7;
      localObject3 = this.this$0.mMiniAppInfo;
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label469;
      }
      if (((MiniAppInfo)localObject3).launchParam.entryPath == null) {
        break label439;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
      if (((MiniAppInfo)localObject3).launchParam == null) {
        break label447;
      }
      str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
      str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
      localObject2 = localObject1;
      localObject1 = str2;
    }
    for (;;)
    {
      label233:
      String str4;
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
      {
        str2 = ((MiniAppInfo)localObject3).via;
        str4 = AdUtil.getSpAdGdtCookie(j);
        bglq.a("QZoneSetting", "MiniGameShareRate", 53);
        if (this.mActivity == null) {
          break label463;
        }
      }
      label421:
      label426:
      label432:
      label439:
      label447:
      label463:
      for (localObject3 = (Activity)this.mActivity.get();; localObject3 = null)
      {
        if (localObject3 == null) {
          break label467;
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
        this.adBox = ((AdProxy)ProxyManager.get(AdProxy.class)).createBoxAdView((Activity)localObject3, this.appId, this.adUnitId, new AppBoxPlugin.MiniAppBox.2(this, paramInt1, paramInt2), localBundle);
        if (this.adBox != null) {
          this.adBox.loadAD();
        }
        return true;
        i = 0;
        break;
        i = 0;
        break label60;
        j = 1;
        break label122;
        j = 8;
        break label131;
        localObject1 = "";
        break label174;
        str1 = "";
        break label192;
        str2 = "";
        break label233;
      }
      label467:
      break;
      label469:
      localObject1 = "";
      str1 = "";
      localObject2 = "";
    }
  }
  
  boolean destroy()
  {
    if (this.adBox != null)
    {
      this.adBox.destroy();
      this.adBox = null;
    }
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
  
  void setJsService(bghn parambghn)
  {
    this.mJsService = parambghn;
  }
  
  boolean show(int paramInt1, int paramInt2)
  {
    if (this.adBox == null) {
      return false;
    }
    bgkk.a(new AppBoxPlugin.MiniAppBox.1(this, paramInt1, paramInt2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.AppBoxPlugin.MiniAppBox
 * JD-Core Version:    0.7.0.1
 */