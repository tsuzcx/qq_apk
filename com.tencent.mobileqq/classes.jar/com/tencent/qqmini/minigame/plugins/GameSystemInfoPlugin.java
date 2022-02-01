package com.tencent.qqmini.minigame.plugins;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import com.tencent.qqmini.sdk.action.PageAction;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.DeviceUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.launcher.utils.LiuHaiUtils;
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
    if ((paramContext == null) || (paramDisplayMetrics == null)) {
      return null;
    }
    JSONObject localJSONObject = new JSONObject();
    int i;
    int j;
    for (;;)
    {
      int k;
      try
      {
        d = paramDisplayMetrics.density;
        n = paramDisplayMetrics.widthPixels;
        i1 = paramDisplayMetrics.heightPixels;
        m = DisplayUtil.getStatusBarHeight(paramContext);
        if (!Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
          break label573;
        }
        if (Settings.Secure.getInt(paramContext.getContentResolver(), "display_notch_status", 0) != 1) {
          break label589;
        }
        i = 1;
      }
      catch (Exception paramContext)
      {
        double d;
        int n;
        int i1;
        int m;
        QMLog.e("SystemInfoPlugin", "getSystemInfo error " + paramContext.getMessage());
        break;
      }
      localJSONObject.put("brand", Build.BRAND);
      localJSONObject.put("model", Build.MODEL);
      if (paramBoolean)
      {
        k = Math.min(n, i1);
        i = Math.max(n, i1);
        k = (int)(k / d);
        n = (int)(i / d);
        localJSONObject.put("pixelRatio", d);
        localJSONObject.put("devicePixelRatio", d);
        i1 = (int)(m / d);
        i = n;
        if (paramBoolean)
        {
          i = n;
          if (j != 0) {
            i = n - i1;
          }
        }
        if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
          break label562;
        }
        j = (int)(paramInt1 / d);
        paramInt1 = (int)(paramInt2 / d);
        if ((j == 0) || (paramInt1 == 0)) {
          break label562;
        }
        paramInt2 = j;
        localJSONObject.put("screenWidth", paramInt2);
        localJSONObject.put("screenHeight", paramInt1);
        localJSONObject.put("windowWidth", paramInt2);
        localJSONObject.put("windowHeight", paramInt1);
        localJSONObject.put("statusBarHeight", i1);
        localJSONObject.put("language", "zh_CN");
        localJSONObject.put("system", "Android " + Build.VERSION.RELEASE);
        localJSONObject.put("platform", "android");
        localJSONObject.put("fontSizeSetting", 16);
        localJSONObject.put("benchmarkLevel", DeviceUtil.getDeviceBenchmarkLevel());
        if (paramMiniAppProxy != null)
        {
          localJSONObject.put("version", paramMiniAppProxy.getAppVersion());
          localJSONObject.put("AppPlatform", paramMiniAppProxy.getAppName());
        }
        paramMiniAppProxy = new JSONObject();
        paramInt2 = DisplayUtil.dip2px(paramContext, 9.0F);
        if ((LiuHaiUtils.isLiuHaiUseValid()) && (!paramBoolean))
        {
          paramInt1 = m;
          paramMiniAppProxy.put("marginTop", paramInt1 + paramInt2);
          paramMiniAppProxy.put("navbarHeight", DisplayUtil.dip2px(paramContext, 30.0F));
          paramMiniAppProxy.put("marginRight", DisplayUtil.dip2px(paramContext, 12.5F));
          paramMiniAppProxy.put("navbarWidth", DisplayUtil.dip2px(paramContext, 80.0F));
          localJSONObject.put("navbarPosition", paramMiniAppProxy);
          QMLog.i("SystemInfoPlugin", "minigame getSystemInfo : " + localJSONObject.toString());
          break;
        }
      }
      else
      {
        k = Math.max(n, i1);
        i = Math.min(n, i1);
        continue;
      }
      paramInt1 = 0;
      continue;
      label562:
      paramInt1 = k;
      paramInt2 = i;
      continue;
      label573:
      j = 0;
    }
    for (;;)
    {
      j = i;
      break;
      return localJSONObject;
      label589:
      i = 0;
    }
  }
  
  @JsEvent({"getSystemInfo", "getSystemInfoSync"})
  public String handleGetSystemInfo(RequestEvent paramRequestEvent)
  {
    if ((this.mMiniAppContext == null) || (this.mMiniAppContext.getContext() == null))
    {
      QMLog.e("SystemInfoPlugin", "getSystemInfo error,context is NULL");
      return paramRequestEvent.fail();
    }
    Object localObject = DisplayUtil.getDisplayMetrics(this.mContext);
    int i;
    int j;
    if (localObject != null)
    {
      i = PageAction.obtain(this.mMiniAppContext).getSurfaceViewWidth();
      j = PageAction.obtain(this.mMiniAppContext).getSurfaceViewHeight();
    }
    for (localObject = getGameSystemInfo(this.mMiniAppContext.getContext(), this.mMiniAppProxy, (DisplayMetrics)localObject, i, j, this.mMiniAppContext.isOrientationLandscape());; localObject = null)
    {
      if (localObject == null) {
        return paramRequestEvent.fail();
      }
      String str = ((JSONObject)localObject).toString();
      if ("getSystemInfo".equals(paramRequestEvent.event))
      {
        paramRequestEvent.evaluateCallbackJs(str);
        return str;
      }
      return ((JSONObject)localObject).toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.minigame.plugins.GameSystemInfoPlugin
 * JD-Core Version:    0.7.0.1
 */