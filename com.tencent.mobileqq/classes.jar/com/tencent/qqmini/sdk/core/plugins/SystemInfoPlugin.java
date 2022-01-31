package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import bglv;
import bgml;
import bgod;
import bgok;
import bgop;
import bgpv;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.model.AppConfigInfo;
import com.tencent.qqmini.sdk.launcher.model.LaunchParam;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.model.NavigationBarInfo;
import com.tencent.qqmini.sdk.launcher.model.PageInfo;
import com.tencent.qqmini.sdk.launcher.model.TabBarInfo;
import com.tencent.qqmini.sdk.launcher.model.WindowInfo;
import com.tencent.qqmini.sdk.log.QMLog;
import com.tencent.qqmini.sdk.utils.DisplayUtil;
import org.json.JSONObject;

public class SystemInfoPlugin
  extends BaseJsPlugin
{
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy;
  
  public String handleGetSystemInfo(bgok parambgok)
  {
    int n = 1;
    int m = 0;
    Object localObject3 = this.mMiniAppContext.a();
    Object localObject1;
    if ((this.mContext == null) || (localObject3 == null))
    {
      QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
      localObject1 = parambgok.b();
      return localObject1;
    }
    label84:
    int i;
    label109:
    double d;
    int i1;
    int k;
    int j;
    int i2;
    int i3;
    if (Build.VERSION.SDK_INT >= 17)
    {
      localObject1 = new DisplayMetrics();
      ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getRealMetrics((DisplayMetrics)localObject1);
      if (((!DisplayUtil.hasNavBar((Context)localObject3)) || (!DisplayUtil.isNavigationBarExist((Activity)localObject3))) && (!DisplayUtil.isFlymeOS7NavBarShow())) {
        break label673;
      }
      i = 1;
      d = ((DisplayMetrics)localObject1).density;
      i1 = (int)((float)Math.round(((DisplayMetrics)localObject1).widthPixels / d) + 0.5F);
      k = (int)((float)Math.round(((DisplayMetrics)localObject1).heightPixels / d) + 0.5F);
      j = k;
      if (i != 0) {
        j = k - (int)(DisplayUtil.getNavigationBarHeight(this.mContext) / d);
      }
      i2 = (int)(Math.round(DisplayUtil.getStatusBarHeight(this.mContext)) / d);
      i3 = (int)(DisplayUtil.dip2px(this.mContext, 44.0F) / d + 0.5D);
      k = (int)(DisplayUtil.dip2px(this.mContext, 54.0F) / d + 0.5D);
      localObject1 = bgml.a(this.mMiniAppContext).a();
      if (bgpv.a((String)localObject1)) {
        break label679;
      }
      label252:
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label755;
      }
    }
    label673:
    label679:
    label728:
    label755:
    for (localObject3 = this.mApkgInfo.a().getPageInfo((String)localObject1).windowInfo.navigationBarInfo.style;; localObject3 = "default")
    {
      if ((this.mApkgInfo != null) && (this.mApkgInfo.a() != null)) {
        if ((this.mApkgInfo.a().tabBarInfo != null) && (this.mApkgInfo.a((String)localObject1)) && (this.mApkgInfo.a().tabBarInfo.isShow())) {
          i = n;
        }
      }
      for (;;)
      {
        for (;;)
        {
          if (!"default".equals(localObject3)) {
            break label728;
          }
          if (i != 0) {
            m = k;
          }
          i = j - i2 - i3 - m;
          try
          {
            localObject1 = new JSONObject();
            ((JSONObject)localObject1).put("brand", Build.BRAND);
            ((JSONObject)localObject1).put("model", Build.MODEL);
            ((JSONObject)localObject1).put("pixelRatio", d);
            ((JSONObject)localObject1).put("screenWidth", i1);
            ((JSONObject)localObject1).put("screenHeight", j);
            ((JSONObject)localObject1).put("windowWidth", i1);
            ((JSONObject)localObject1).put("windowHeight", i);
            ((JSONObject)localObject1).put("statusBarHeight", i2);
            ((JSONObject)localObject1).put("language", "zh_CN");
            ((JSONObject)localObject1).put("version", this.mMiniAppProxy.getAppVersion());
            ((JSONObject)localObject1).put("system", "Android " + Build.VERSION.RELEASE);
            ((JSONObject)localObject1).put("platform", "android");
            ((JSONObject)localObject1).put("fontSizeSetting", 16);
            ((JSONObject)localObject1).put("SDKVersion", this.mMiniAppContext.a());
            ((JSONObject)localObject1).put("AppPlatform", this.mMiniAppProxy.getAppName());
            localObject3 = bgop.a(parambgok.a, (JSONObject)localObject1).toString();
            localObject1 = localObject3;
            if (!"getSystemInfo".equals(parambgok.a)) {
              break;
            }
            parambgok.a((String)localObject3);
            return localObject3;
          }
          catch (Exception localException)
          {
            QMLog.e("SystemInfoPlugin", "getSystemInfo exception: " + new Throwable(localException));
            return parambgok.b();
          }
        }
        Object localObject2 = this.mContext.getResources().getDisplayMetrics();
        break label84;
        i = 0;
        break label109;
        localObject3 = this.mMiniAppInfo.launchParam.entryPath;
        localObject2 = this.mApkgInfo.a.entryPagePath;
        if (!this.mApkgInfo.c((String)localObject3)) {
          break label252;
        }
        localObject2 = localObject3;
        break label252;
        i = 0;
        continue;
        if (i != 0) {}
        for (;;)
        {
          i = j - k;
          break;
          k = 0;
        }
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.SystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */