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
    if (this.mJsService != null)
    {
      if (paramBoolean) {
        paramString = ApiUtil.wrapCallbackOk(paramString, getResultObj(paramInt1, paramInt2));
      } else {
        paramString = ApiUtil.wrapCallbackFail(paramString, getResultObj(paramInt1, paramInt2), (String)AppBoxPlugin.S_CODE_MSG_MAP.get(Integer.valueOf(paramInt2)));
      }
      paramString = paramString.toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("evaluateCallbackJs callbackId: ");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append(" content:");
      localStringBuilder.append(paramString);
      QMLog.i("SDK_MiniAppBox", localStringBuilder.toString());
      this.mJsService.evaluateCallbackJs(paramInt3, paramString);
    }
  }
  
  private void createBoxAdView(int paramInt1, int paramInt2, Activity paramActivity, Bundle paramBundle)
  {
    this.adBox = ((AdProxy)ProxyManager.get(AdProxy.class)).createBoxAdView(paramActivity, this.appId, this.adUnitId, new AppBoxPlugin.MiniAppBox.2(this, paramInt1, paramInt2), paramBundle);
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
    String str = LoginManager.getInstance().getAccount();
    if (TextUtils.isEmpty(this.appId))
    {
      QMLog.e("SDK_MiniAppBox", "TextUtils.isEmpty(appid)");
      return false;
    }
    int i;
    if (MiniAppEnv.g().getContext().getResources().getConfiguration().orientation == 2) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      i = 90;
    } else {
      i = 0;
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handle initAdParam appId = ");
    ((StringBuilder)localObject1).append(this.appId);
    ((StringBuilder)localObject1).append("， deviceOrient = ");
    ((StringBuilder)localObject1).append(i);
    QMLog.i("SDK_MiniAppBox", ((StringBuilder)localObject1).toString());
    int j;
    if ((AppBoxPlugin.access$200(this.this$0) != null) && (AppBoxPlugin.access$300(this.this$0).isEngineTypeMiniApp())) {
      j = 0;
    } else {
      j = 1;
    }
    if (j == 0) {
      j = 7;
    } else {
      j = 8;
    }
    Object localObject6 = AppBoxPlugin.access$400(this.this$0);
    Object localObject5 = "";
    Object localObject2;
    Object localObject3;
    if ((localObject6 != null) && (((MiniAppInfo)localObject6).launchParam != null))
    {
      if (((MiniAppInfo)localObject6).launchParam.entryPath != null) {
        localObject1 = ((MiniAppInfo)localObject6).launchParam.entryPath;
      } else {
        localObject1 = "";
      }
      if (((MiniAppInfo)localObject6).launchParam != null) {
        localObject2 = ((MiniAppInfo)localObject6).launchParam.reportData;
      } else {
        localObject2 = "";
      }
      localObject3 = String.valueOf(((MiniAppInfo)localObject6).launchParam.scene);
    }
    else
    {
      localObject4 = "";
      localObject1 = localObject4;
      localObject3 = localObject1;
      localObject2 = localObject1;
      localObject1 = localObject4;
    }
    Object localObject4 = localObject5;
    if (localObject6 != null)
    {
      localObject4 = localObject5;
      if (((MiniAppInfo)localObject6).via != null) {
        localObject4 = ((MiniAppInfo)localObject6).via;
      }
    }
    localObject6 = AdUtil.getSpAdGdtCookie(j);
    WnsConfig.getConfig("QZoneSetting", "MiniGameShareRate", 53);
    localObject5 = this.mActivity;
    if (localObject5 != null) {
      localObject5 = (Activity)((WeakReference)localObject5).get();
    } else {
      localObject5 = null;
    }
    if (localObject5 == null)
    {
      QMLog.e("SDK_MiniAppBox", "activity is null");
      return false;
    }
    Bundle localBundle = new Bundle();
    localBundle.putString(AdProxy.KEY_ACCOUNT, str);
    localBundle.putInt(AdProxy.KEY_AD_TYPE, j);
    localBundle.putInt(AdProxy.KEY_ORIENTATION, i);
    localBundle.putString(AdProxy.KEY_GDT_COOKIE, (String)localObject6);
    localBundle.putString(AdProxy.KEY_ENTRY_PATH, (String)localObject1);
    localBundle.putString(AdProxy.KEY_REPORT_DATA, (String)localObject2);
    localBundle.putString(AdProxy.KEY_REFER, (String)localObject3);
    localBundle.putString(AdProxy.KEY_VIA, (String)localObject4);
    createBoxAdView(paramInt1, paramInt2, (Activity)localObject5, localBundle);
    localObject1 = this.adBox;
    if (localObject1 != null)
    {
      ((AdProxy.AbsBoxAdView)localObject1).loadAD();
      return true;
    }
    this.mIsRequestingAd = false;
    return false;
  }
  
  boolean destroy()
  {
    AdProxy.AbsBoxAdView localAbsBoxAdView = this.adBox;
    if (localAbsBoxAdView != null)
    {
      localAbsBoxAdView.destroy();
      this.adBox = null;
    }
    return true;
  }
  
  boolean load(int paramInt1, int paramInt2)
  {
    if (!this.mIsRequestingAd)
    {
      this.mIsRequestingAd = true;
      return initAdParam(paramInt1, paramInt2);
    }
    return true;
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
    if (this.adBox == null)
    {
      QMLog.e("SDK_MiniAppBox", "adBox is null");
      return false;
    }
    AppBrandTask.runTaskOnUiThread(new AppBoxPlugin.MiniAppBox.1(this, paramInt1, paramInt2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.AppBoxPlugin.MiniAppBox
 * JD-Core Version:    0.7.0.1
 */