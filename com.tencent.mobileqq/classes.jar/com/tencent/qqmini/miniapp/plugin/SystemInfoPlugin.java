package com.tencent.qqmini.miniapp.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.qqmini.miniapp.util.logmonitor.LogBeanUtil;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.StringUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.core.utils.ApiUtil;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class SystemInfoPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  private DisplayMetrics getDisplayMetrics()
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(localDisplayMetrics);
      return localDisplayMetrics;
    }
    return this.mContext.getResources().getDisplayMetrics();
  }
  
  private String getNavBarSytle(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.mApkgInfo.getAppConfigInfo().getPageInfo(paramString).windowInfo.navigationBarInfo.style;
    }
    return "default";
  }
  
  private String getPageUrl()
  {
    Object localObject = PageAction.obtain(this.mMiniAppContext).getPageUrl();
    if (!StringUtil.isEmpty((String)localObject)) {
      return localObject;
    }
    String str1 = this.mMiniAppInfo.launchParam.entryPath;
    String str2 = this.mApkgInfo.mAppConfigInfo.entryPagePath;
    localObject = str1;
    if (!this.mApkgInfo.isUrlFileExist(str1)) {
      localObject = str2;
    }
    return localObject;
  }
  
  private int getRelHeight(DisplayMetrics paramDisplayMetrics, Activity paramActivity)
  {
    boolean bool1;
    if ((!DisplayUtil.checkNavigationBarShow(this.mContext)) && (!DisplayUtil.isFlymeOS7NavBarShow())) {
      bool1 = false;
    } else {
      bool1 = true;
    }
    boolean bool2 = bool1;
    if (paramActivity != null)
    {
      bool2 = bool1;
      if (!paramActivity.isFinishing())
      {
        bool2 = bool1;
        if (!Build.MANUFACTURER.equalsIgnoreCase("HUAWEI")) {
          if (((DisplayUtil.hasNavBar(paramActivity)) && (DisplayUtil.isNavigationBarExist(paramActivity))) || (DisplayUtil.isFlymeOS7NavBarShow())) {
            bool2 = true;
          } else {
            bool2 = false;
          }
        }
      }
    }
    paramActivity = new StringBuilder();
    paramActivity.append(" hasNavBar : ");
    paramActivity.append(bool2);
    paramActivity.append("; ");
    paramActivity.append(Build.BRAND);
    QMLog.d("SystemInfoPlugin", paramActivity.toString());
    int j = (int)(Math.round(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density) + 0.5F);
    int i = j;
    if (bool2) {
      i = j - (int)(DisplayUtil.getNavigationBarHeight(this.mContext) / paramDisplayMetrics.density);
    }
    return i;
  }
  
  private int getRelWindowHeight(double paramDouble, int paramInt1, int paramInt2)
  {
    double d = DisplayUtil.dip2px(this.mContext, 44.0F);
    Double.isNaN(d);
    int k = (int)(d / paramDouble + 0.5D);
    d = DisplayUtil.dip2px(this.mContext, 54.0F);
    Double.isNaN(d);
    int j = (int)(d / paramDouble + 0.5D);
    String str1 = getPageUrl();
    String str2 = getNavBarSytle(str1);
    if ((this.mApkgInfo != null) && (this.mApkgInfo.getAppConfigInfo() != null) && (this.mApkgInfo.getAppConfigInfo().tabBarInfo != null) && (this.mApkgInfo.isTabBarPage(str1)) && (this.mApkgInfo.getAppConfigInfo().tabBarInfo.isShow())) {
      i = 1;
    } else {
      i = 0;
    }
    if ("default".equals(str2))
    {
      paramInt2 = paramInt2 - paramInt1 - k;
      paramInt1 = paramInt2;
      if (i != 0)
      {
        i = j;
        paramInt1 = paramInt2;
        break label197;
      }
    }
    else
    {
      paramInt1 = paramInt2;
      if (i != 0)
      {
        i = j;
        paramInt1 = paramInt2;
        break label197;
      }
    }
    int i = 0;
    label197:
    return paramInt1 - i;
  }
  
  @JsEvent({"detectAbnormalLog"})
  public void detectAbnormalLog(RequestEvent paramRequestEvent)
  {
    if (this.mContext == null)
    {
      QMLog.e("SystemInfoPlugin", "detectAbnormalLog error, context is NULL");
      paramRequestEvent.fail("detectAbnormalLog error, context is NULL");
      return;
    }
    Object localObject3 = null;
    String str;
    try
    {
      Object localObject1 = new JSONObject(paramRequestEvent.jsonParams);
      str = ((JSONObject)localObject1).optString("logTab", null);
      try
      {
        localObject1 = ((JSONObject)localObject1).optString("keyErr", null);
      }
      catch (JSONException localJSONException1) {}
      QMLog.e("SystemInfoPlugin", "detectAbnormalLog get a JSONException:", localJSONException2);
    }
    catch (JSONException localJSONException2)
    {
      str = null;
    }
    Object localObject2 = localObject3;
    if (str == null)
    {
      paramRequestEvent.fail("logTab is null");
      return;
    }
    LogBeanUtil.loadLogBeanList(str, "E", localObject2, new SystemInfoPlugin.1(this, paramRequestEvent));
  }
  
  @JsEvent({"getSystemInfo", "getSystemInfoSync"})
  public String handleGetSystemInfo(RequestEvent paramRequestEvent)
  {
    if (this.mContext == null)
    {
      QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
      return paramRequestEvent.fail();
    }
    Object localObject1 = this.mMiniAppContext.getAttachedActivity();
    DisplayMetrics localDisplayMetrics = getDisplayMetrics();
    double d1 = localDisplayMetrics.density;
    double d2 = Math.round(DisplayUtil.getStatusBarHeight(this.mContext));
    Double.isNaN(d2);
    Double.isNaN(d1);
    int j = (int)(d2 / d1);
    d2 = localDisplayMetrics.widthPixels;
    Double.isNaN(d2);
    Double.isNaN(d1);
    int m = (int)((float)Math.round(d2 / d1) + 0.5F);
    int n = getRelHeight(localDisplayMetrics, (Activity)localObject1);
    int i1 = getRelWindowHeight(d1, j, n);
    int k = ImmersiveUtils.getNotchHeight(this.mMiniAppContext.getContext(), (Activity)localObject1);
    int i = k;
    if (k == 0) {
      i = j;
    }
    localObject1 = new JSONObject();
    try
    {
      ((JSONObject)localObject1).put("left", 0);
      ((JSONObject)localObject1).put("top", i);
      ((JSONObject)localObject1).put("right", m);
      ((JSONObject)localObject1).put("bottom", n);
      ((JSONObject)localObject1).put("width", m + 0);
      ((JSONObject)localObject1).put("height", n - i);
    }
    catch (JSONException localJSONException)
    {
      QMLog.e("SystemInfoPlugin", "getSafeArea", localJSONException);
    }
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("brand", Build.BRAND);
      ((JSONObject)localObject2).put("model", Build.MODEL);
      ((JSONObject)localObject2).put("pixelRatio", d1);
      ((JSONObject)localObject2).put("screenWidth", m);
      ((JSONObject)localObject2).put("screenHeight", n);
      ((JSONObject)localObject2).put("windowWidth", m);
      ((JSONObject)localObject2).put("windowHeight", i1);
      ((JSONObject)localObject2).put("statusBarHeight", j);
      ((JSONObject)localObject2).put("language", "zh_CN");
      ((JSONObject)localObject2).put("version", this.mMiniAppProxy.getAppVersion());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Android ");
      localStringBuilder.append(Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("system", localStringBuilder.toString());
      ((JSONObject)localObject2).put("platform", "android");
      ((JSONObject)localObject2).put("fontSizeSetting", 16);
      ((JSONObject)localObject2).put("SDKVersion", this.mMiniAppContext.getBaseLibVersion());
      ((JSONObject)localObject2).put("AppPlatform", this.mMiniAppProxy.getAppName());
      ((JSONObject)localObject2).put("safeArea", localObject1);
      ((JSONObject)localObject2).put("runtimeVersion", "1.15.0.0");
      if (this.mApkgInfo.getAppConfigInfo().darkmode) {
        ((JSONObject)localObject2).put("theme", ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserTheme());
      }
      localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject2).toString();
      if ("getSystemInfo".equals(paramRequestEvent.event)) {
        paramRequestEvent.evaluateCallbackJs((String)localObject1);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSystemInfo ： ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QMLog.i("SystemInfoPlugin", ((StringBuilder)localObject2).toString());
      return localObject1;
    }
    catch (Exception localException)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSystemInfo exception: ");
      ((StringBuilder)localObject2).append(new Throwable(localException));
      QMLog.e("SystemInfoPlugin", ((StringBuilder)localObject2).toString());
    }
    return paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.SystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */