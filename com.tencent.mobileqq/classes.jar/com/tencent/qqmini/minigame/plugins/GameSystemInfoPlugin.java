package com.tencent.qqmini.minigame.plugins;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
import com.tencent.qqmini.sdk.utils.ImmersiveUtils;
import org.json.JSONException;
import org.json.JSONObject;

@JsPlugin
public class GameSystemInfoPlugin
  extends BaseJsPlugin
{
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  public static final String TAG = "SystemInfoPlugin";
  private MiniAppProxy mMiniAppProxy = (MiniAppProxy)ProxyManager.get(MiniAppProxy.class);
  
  private JSONObject getGameSystemInfo(Context paramContext, MiniAppProxy paramMiniAppProxy, DisplayMetrics paramDisplayMetrics, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Activity localActivity;
    JSONObject localJSONObject;
    if ((paramContext != null) && (paramDisplayMetrics != null))
    {
      localActivity = this.mMiniAppContext.getAttachedActivity();
      localJSONObject = new JSONObject();
    }
    for (;;)
    {
      try
      {
        double d1 = paramDisplayMetrics.density;
        int i = paramDisplayMetrics.widthPixels;
        int m = paramDisplayMetrics.heightPixels;
        int k = DisplayUtil.getStatusBarHeight(paramContext);
        boolean bool = processHuaweiNotchStatus(paramContext, false);
        localJSONObject.put("brand", Build.BRAND);
        localJSONObject.put("model", Build.MODEL);
        if (paramBoolean)
        {
          j = Math.min(i, m);
          i = Math.max(i, m);
        }
        else
        {
          j = Math.max(i, m);
          i = Math.min(i, m);
        }
        double d2 = j;
        Double.isNaN(d2);
        Double.isNaN(d1);
        int j = (int)(d2 / d1);
        d2 = i;
        Double.isNaN(d2);
        Double.isNaN(d1);
        m = (int)(d2 / d1);
        localJSONObject.put("pixelRatio", d1);
        localJSONObject.put("devicePixelRatio", d1);
        d2 = k;
        Double.isNaN(d2);
        Double.isNaN(d1);
        int n = (int)(d2 / d1);
        i = m;
        if (paramBoolean)
        {
          i = m;
          if (bool) {
            i = m - n;
          }
        }
        if ((paramInt1 > 0) && (paramInt2 > 0))
        {
          d2 = paramInt1;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramInt1 = (int)(d2 / d1);
          d2 = paramInt2;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramInt2 = (int)(d2 / d1);
          if ((paramInt1 != 0) && (paramInt2 != 0)) {}
        }
        else
        {
          paramInt1 = i;
          paramInt2 = j;
        }
        i = getSafeAreaTop(localActivity, d1, n);
        paramDisplayMetrics = new JSONObject();
        try
        {
          paramDisplayMetrics.put("left", 0);
          paramDisplayMetrics.put("top", i);
          paramDisplayMetrics.put("right", paramInt1);
          paramDisplayMetrics.put("bottom", paramInt2);
          paramDisplayMetrics.put("width", paramInt1 + 0);
          paramDisplayMetrics.put("height", paramInt2 - i);
        }
        catch (JSONException localJSONException)
        {
          QMLog.e("SystemInfoPlugin", "getSafeArea", localJSONException);
        }
        localJSONObject.put("screenWidth", paramInt1);
        localJSONObject.put("screenHeight", paramInt2);
        localJSONObject.put("windowWidth", paramInt1);
        localJSONObject.put("windowHeight", paramInt2);
        localJSONObject.put("statusBarHeight", n);
        localJSONObject.put("language", "zh_CN");
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Android ");
        localStringBuilder.append(Build.VERSION.RELEASE);
        localJSONObject.put("system", localStringBuilder.toString());
        localJSONObject.put("platform", "android");
        localJSONObject.put("fontSizeSetting", 16);
        localJSONObject.put("benchmarkLevel", DeviceUtil.getDeviceBenchmarkLevel());
        localJSONObject.put("safeArea", paramDisplayMetrics);
        if (paramMiniAppProxy != null)
        {
          localJSONObject.put("version", paramMiniAppProxy.getAppVersion());
          localJSONObject.put("AppPlatform", paramMiniAppProxy.getAppName());
        }
        paramMiniAppProxy = new JSONObject();
        paramInt2 = DisplayUtil.dip2px(paramContext, 9.0F);
        if ((!LiuHaiUtils.isLiuHaiUseValid()) || (paramBoolean)) {
          break label763;
        }
        paramInt1 = k;
        paramMiniAppProxy.put("marginTop", paramInt2 + paramInt1);
        paramMiniAppProxy.put("navbarHeight", DisplayUtil.dip2px(paramContext, 30.0F));
        paramMiniAppProxy.put("marginRight", DisplayUtil.dip2px(paramContext, 12.5F));
        paramMiniAppProxy.put("navbarWidth", DisplayUtil.dip2px(paramContext, 80.0F));
        localJSONObject.put("navbarPosition", paramMiniAppProxy);
        paramContext = new StringBuilder();
        paramContext.append("minigame getSystemInfo : ");
        paramContext.append(localJSONObject.toString());
        QMLog.i("SystemInfoPlugin", paramContext.toString());
        return localJSONObject;
      }
      catch (Exception paramContext)
      {
        paramMiniAppProxy = new StringBuilder();
        paramMiniAppProxy.append("getSystemInfo error ");
        paramMiniAppProxy.append(paramContext.getMessage());
        QMLog.e("SystemInfoPlugin", paramMiniAppProxy.toString());
        return localJSONObject;
      }
      return null;
      label763:
      paramInt1 = 0;
    }
  }
  
  private int getSafeAreaTop(Activity paramActivity, double paramDouble, int paramInt)
  {
    double d = ImmersiveUtils.getNotchHeight(paramActivity, paramActivity);
    Double.isNaN(d);
    int i = (int)(d / paramDouble);
    if ((i == 0) && (!TextUtils.isEmpty(this.mApkgInfo.mConfigStr))) {
      try
      {
        boolean bool = new JSONObject(this.mApkgInfo.mConfigStr).optBoolean("showStatusBar", false);
        if (bool) {
          return paramInt;
        }
      }
      catch (JSONException paramActivity)
      {
        QMLog.e("SystemInfoPlugin", "safeAreaTop JSONException:", paramActivity);
      }
    }
    return i;
  }
  
  private boolean processHuaweiNotchStatus(Context paramContext, boolean paramBoolean)
  {
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei"))
    {
      paramContext = paramContext.getContentResolver();
      paramBoolean = false;
      if (Settings.Secure.getInt(paramContext, "display_notch_status", 0) == 1) {
        paramBoolean = true;
      }
    }
    return paramBoolean;
  }
  
  @JsEvent({"getSystemInfo", "getSystemInfoSync"})
  public String handleGetSystemInfo(RequestEvent paramRequestEvent)
  {
    if ((this.mMiniAppContext != null) && (this.mMiniAppContext.getContext() != null))
    {
      Object localObject = DisplayUtil.getDisplayMetrics(this.mContext);
      JSONObject localJSONObject = null;
      if (localObject != null)
      {
        int i = PageAction.obtain(this.mMiniAppContext).getSurfaceViewWidth();
        int j = PageAction.obtain(this.mMiniAppContext).getSurfaceViewHeight();
        localJSONObject = getGameSystemInfo(this.mMiniAppContext.getContext(), this.mMiniAppProxy, (DisplayMetrics)localObject, i, j, this.mMiniAppContext.isOrientationLandscape());
      }
      if (localJSONObject == null) {
        return paramRequestEvent.fail();
      }
      localObject = localJSONObject.toString();
      if ("getSystemInfo".equals(paramRequestEvent.event))
      {
        paramRequestEvent.evaluateCallbackJs((String)localObject);
        return localObject;
      }
      return localJSONObject.toString();
    }
    QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
    return paramRequestEvent.fail();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameSystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */