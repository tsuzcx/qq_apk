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
    String str = "default";
    if (!TextUtils.isEmpty(paramString)) {
      str = this.mApkgInfo.getAppConfigInfo().getPageInfo(paramString).windowInfo.navigationBarInfo.style;
    }
    return str;
  }
  
  private String getPageUrl()
  {
    String str1 = PageAction.obtain(this.mMiniAppContext).getPageUrl();
    if (!StringUtil.isEmpty(str1)) {}
    String str2;
    do
    {
      return str1;
      str2 = this.mMiniAppInfo.launchParam.entryPath;
      str1 = this.mApkgInfo.mAppConfigInfo.entryPagePath;
    } while (!this.mApkgInfo.isUrlFileExist(str2));
    return str2;
  }
  
  private int getRelHeight(DisplayMetrics paramDisplayMetrics, Activity paramActivity)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((DisplayUtil.checkNavigationBarShow(this.mContext)) || (DisplayUtil.isFlymeOS7NavBarShow()))
    {
      bool1 = true;
      if ((paramActivity == null) || (paramActivity.isFinishing()) || (Build.MANUFACTURER.equalsIgnoreCase("HUAWEI"))) {
        break label156;
      }
      if ((!DisplayUtil.hasNavBar(paramActivity)) || (!DisplayUtil.isNavigationBarExist(paramActivity)))
      {
        bool1 = bool2;
        if (!DisplayUtil.isFlymeOS7NavBarShow()) {}
      }
      else
      {
        bool1 = true;
      }
    }
    label156:
    for (;;)
    {
      QMLog.d("SystemInfoPlugin", " hasNavBar : " + bool1 + "; " + Build.BRAND);
      int i = (int)(Math.round(paramDisplayMetrics.heightPixels / paramDisplayMetrics.density) + 0.5F);
      if (bool1)
      {
        return i - (int)(DisplayUtil.getNavigationBarHeight(this.mContext) / paramDisplayMetrics.density);
        bool1 = false;
        break;
      }
      return i;
    }
  }
  
  private int getRelWindowHeight(double paramDouble, int paramInt1, int paramInt2)
  {
    int k = 0;
    int m = (int)(DisplayUtil.dip2px(this.mContext, 44.0F) / paramDouble + 0.5D);
    int j = (int)(DisplayUtil.dip2px(this.mContext, 54.0F) / paramDouble + 0.5D);
    String str1 = getPageUrl();
    String str2 = getNavBarSytle(str1);
    int i;
    if ((this.mApkgInfo != null) && (this.mApkgInfo.getAppConfigInfo() != null)) {
      if ((this.mApkgInfo.getAppConfigInfo().tabBarInfo != null) && (this.mApkgInfo.isTabBarPage(str1)) && (this.mApkgInfo.getAppConfigInfo().tabBarInfo.isShow())) {
        i = 1;
      }
    }
    for (;;)
    {
      if ("default".equals(str2))
      {
        if (i != 0) {
          k = j;
        }
        return paramInt2 - paramInt1 - m - k;
        i = 0;
      }
      else
      {
        if (i != 0) {}
        for (;;)
        {
          return paramInt2 - j;
          j = 0;
        }
        i = 0;
      }
    }
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
    Object localObject2 = getDisplayMetrics();
    double d = ((DisplayMetrics)localObject2).density;
    int j = (int)(Math.round(DisplayUtil.getStatusBarHeight(this.mContext)) / d);
    int m = (int)((float)Math.round(((DisplayMetrics)localObject2).widthPixels / d) + 0.5F);
    int n = getRelHeight((DisplayMetrics)localObject2, (Activity)localObject1);
    int i1 = getRelWindowHeight(d, j, n);
    int k = ImmersiveUtils.getNotchHeight((Context)localObject1, (Activity)localObject1);
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
      ((JSONObject)localObject1).put("width", m - 0);
      ((JSONObject)localObject1).put("height", n - i);
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("brand", Build.BRAND);
        ((JSONObject)localObject2).put("model", Build.MODEL);
        ((JSONObject)localObject2).put("pixelRatio", d);
        ((JSONObject)localObject2).put("screenWidth", m);
        ((JSONObject)localObject2).put("screenHeight", n);
        ((JSONObject)localObject2).put("windowWidth", m);
        ((JSONObject)localObject2).put("windowHeight", i1);
        ((JSONObject)localObject2).put("statusBarHeight", j);
        ((JSONObject)localObject2).put("language", "zh_CN");
        ((JSONObject)localObject2).put("version", this.mMiniAppProxy.getAppVersion());
        ((JSONObject)localObject2).put("system", "Android " + Build.VERSION.RELEASE);
        ((JSONObject)localObject2).put("platform", "android");
        ((JSONObject)localObject2).put("fontSizeSetting", 16);
        ((JSONObject)localObject2).put("SDKVersion", this.mMiniAppContext.getBaseLibVersion());
        ((JSONObject)localObject2).put("AppPlatform", this.mMiniAppProxy.getAppName());
        ((JSONObject)localObject2).put("safeArea", localObject1);
        ((JSONObject)localObject2).put("runtimeVersion", "1.7.0.0");
        if (this.mApkgInfo.getAppConfigInfo().darkmode) {
          ((JSONObject)localObject2).put("theme", ((ChannelProxy)ProxyManager.get(ChannelProxy.class)).getUserTheme());
        }
        localObject1 = ApiUtil.wrapCallbackOk(paramRequestEvent.event, (JSONObject)localObject2).toString();
        if ("getSystemInfo".equals(paramRequestEvent.event)) {
          paramRequestEvent.evaluateCallbackJs((String)localObject1);
        }
        QMLog.i("SystemInfoPlugin", "getSystemInfo ： " + (String)localObject1);
        return localObject1;
      }
      catch (Exception localException)
      {
        QMLog.e("SystemInfoPlugin", "getSystemInfo exception: " + new Throwable(localException));
        return paramRequestEvent.fail();
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QMLog.e("SystemInfoPlugin", "getSafeArea", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.plugin.SystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */