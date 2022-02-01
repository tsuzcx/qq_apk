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
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.AbsBoxAdView;
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
  private volatile boolean mIsRequestingAd = false;
  private IJsService mJsService;
  
  AppBoxPlugin$MiniAppBox(AppBoxPlugin paramAppBoxPlugin, Activity paramActivity, int paramInt, String paramString1, String paramString2, IJsService paramIJsService)
  {
    this.mActivity = new WeakReference(paramActivity);
    this.appBoxId = paramInt;
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
    for (paramString = ApiUtil.wrapCallbackOk(paramString, getResultObj(paramInt1, paramInt2));; paramString = ApiUtil.wrapCallbackFail(paramString, getResultObj(paramInt1, paramInt2), (String)AppBoxPlugin.S_CodeMsg_Map.get(Integer.valueOf(paramInt2))))
    {
      paramString = paramString.toString();
      QMLog.i("SDK_MiniAppBox", "evaluateCallbackJs callbackId: " + paramInt3 + " content:" + paramString);
      this.mJsService.evaluateCallbackJs(paramInt3, paramString);
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
    String str3 = LoginManager.getInstance().getAccount();
    if (TextUtils.isEmpty(this.appId))
    {
      QMLog.e("SDK_MiniAppBox", "TextUtils.isEmpty(appid)");
      return false;
    }
    int i;
    label55:
    int j;
    label117:
    label126:
    Object localObject3;
    Object localObject1;
    label169:
    String str1;
    label187:
    String str2;
    Object localObject2;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2)
    {
      i = 1;
      if (i == 0) {
        break label286;
      }
      i = 90;
      QMLog.i("SDK_MiniAppBox", "handle initAdParam appId = " + this.appId + "， deviceOrient = " + i);
      if ((AppBoxPlugin.access$200(this.this$0) == null) || (!AppBoxPlugin.access$300(this.this$0).isEngineTypeMiniApp())) {
        break label291;
      }
      j = 0;
      if (j != 0) {
        break label297;
      }
      j = 7;
      localObject3 = AppBoxPlugin.access$400(this.this$0);
      if ((localObject3 == null) || (((MiniAppInfo)localObject3).launchParam == null)) {
        break label483;
      }
      if (((MiniAppInfo)localObject3).launchParam.entryPath == null) {
        break label304;
      }
      localObject1 = ((MiniAppInfo)localObject3).launchParam.entryPath;
      if (((MiniAppInfo)localObject3).launchParam == null) {
        break label312;
      }
      str1 = ((MiniAppInfo)localObject3).launchParam.reportData;
      str2 = String.valueOf(((MiniAppInfo)localObject3).launchParam.scene);
      localObject2 = localObject1;
      localObject1 = str2;
    }
    for (;;)
    {
      label228:
      String str4;
      if ((localObject3 != null) && (((MiniAppInfo)localObject3).via != null))
      {
        str2 = ((MiniAppInfo)localObject3).via;
        str4 = AdUtil.getSpAdGdtCookie(j);
        WnsConfig.getConfig("QZoneSetting", "MiniGameShareRate", 53);
        if (this.mActivity == null) {
          break label328;
        }
      }
      label286:
      label291:
      label297:
      label304:
      label312:
      label328:
      for (localObject3 = (Activity)this.mActivity.get();; localObject3 = null)
      {
        if (localObject3 != null) {
          break label334;
        }
        QMLog.e("SDK_MiniAppBox", "activity is null");
        return false;
        i = 0;
        break;
        i = 0;
        break label55;
        j = 1;
        break label117;
        j = 8;
        break label126;
        localObject1 = "";
        break label169;
        str1 = "";
        break label187;
        str2 = "";
        break label228;
      }
      label334:
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
      if (this.adBox != null)
      {
        this.adBox.loadAD();
        return true;
      }
      this.mIsRequestingAd = false;
      return false;
      label483:
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
  
  void setJsService(IJsService paramIJsService)
  {
    this.mJsService = paramIJsService;
  }
  
  boolean show(int paramInt1, int paramInt2)
  {
    if (this.adBox == null) {
      return false;
    }
    AppBrandTask.runTaskOnUiThread(new AppBoxPlugin.MiniAppBox.1(this, paramInt1, paramInt2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin.MiniAppBox
 * JD-Core Version:    0.7.0.1
 */