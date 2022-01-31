package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.webview.JsRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.Set;
import org.json.JSONObject;

public class ScreenJsPlugin
  extends BaseJsPlugin
{
  public static final String EVENT_GET_SCREEN_BRIGHTNESS = "getScreenBrightness";
  private static final String EVENT_ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
  public static final String EVENT_SET_KEEP_SCREEN_ON = "setKeepScreenOn";
  public static final String EVENT_SET_SCREEN_BRIGHTNESS = "setScreenBrightness";
  private static final Set<String> S_EVENT_MAP = new ScreenJsPlugin.1();
  private static final String TAG = "[mini] ScreenJsPlugin";
  
  public static float getScreenBrightness(Activity paramActivity)
  {
    Window localWindow = paramActivity.getWindow();
    float f1;
    if (localWindow == null) {
      f1 = -1.0F;
    }
    for (;;)
    {
      return f1;
      try
      {
        f2 = localWindow.getAttributes().screenBrightness;
        f1 = f2;
        if (f2 < 0.0F)
        {
          int i;
          QLog.e("[mini] ScreenJsPlugin", 1, paramActivity, new Object[0]);
        }
      }
      catch (Exception paramActivity)
      {
        try
        {
          i = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
          return i / 255.0F;
        }
        catch (Exception paramActivity)
        {
          float f2;
          break;
        }
        paramActivity = paramActivity;
        f2 = 0.0F;
      }
    }
    return f2;
  }
  
  public static boolean keepScreenOn(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != null) {}
    for (paramActivity = paramActivity.getWindow(); paramActivity == null; paramActivity = null) {
      return false;
    }
    if (paramBoolean)
    {
      paramActivity.addFlags(128);
      paramActivity.clearFlags(1);
      return true;
    }
    paramActivity.clearFlags(128);
    paramActivity.addFlags(1);
    return true;
  }
  
  public static void setScreenBrightness(Activity paramActivity, float paramFloat)
  {
    if (paramActivity == null) {}
    do
    {
      return;
      paramActivity = paramActivity.getWindow();
    } while (paramActivity == null);
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  public String handleNativeRequest(String paramString1, String paramString2, JsRuntime paramJsRuntime, int paramInt)
  {
    QLog.d("[mini] ScreenJsPlugin", 2, "handleNativeRequest event=" + paramString1 + ",jsonParams=" + paramString2 + ",callbackId=" + paramInt + ",webview=" + paramJsRuntime);
    if ("setScreenBrightness".equals(paramString1)) {
      AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.3(this, paramString2, paramJsRuntime, paramString1, paramInt));
    }
    for (;;)
    {
      return super.handleNativeRequest(paramString1, paramString2, paramJsRuntime, paramInt);
      if ("getScreenBrightness".equals(paramString1)) {
        try
        {
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("value", getScreenBrightness(this.jsPluginEngine.appBrandRuntime.activity));
          this.jsPluginEngine.callbackJsEventOK(paramJsRuntime, paramString1, localJSONObject, paramInt);
        }
        catch (Throwable localThrowable)
        {
          QLog.e("[mini] ScreenJsPlugin", 2, localThrowable, new Object[0]);
        }
      } else if ("setKeepScreenOn".equals(paramString1)) {
        AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.4(this, paramString2, paramJsRuntime, paramString1, paramInt));
      }
    }
  }
  
  public void onCreate(BaseJsPluginEngine paramBaseJsPluginEngine)
  {
    super.onCreate(paramBaseJsPluginEngine);
    paramBaseJsPluginEngine = ScreenJsPlugin.ScreenShotListenManager.newInstance(paramBaseJsPluginEngine.appBrandRuntime.activity);
    paramBaseJsPluginEngine.setListener(new ScreenJsPlugin.2(this));
    paramBaseJsPluginEngine.startListen();
  }
  
  public Set<String> supportedEvents()
  {
    return S_EVENT_MAP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */