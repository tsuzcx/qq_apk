package com.tencent.qqmini.sdk.plugins;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import com.tencent.qqmini.sdk.annotation.JsEvent;
import com.tencent.qqmini.sdk.annotation.JsPlugin;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.RequestEvent;
import com.tencent.qqmini.sdk.launcher.core.plugins.BaseJsPlugin;
import com.tencent.qqmini.sdk.launcher.core.utils.AppBrandTask;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import org.json.JSONObject;

@JsPlugin(lazyLoad=false)
public class ScreenJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
  private static final String TAG = "ScreenJsPlugin";
  
  public static float getScreenBrightness(Activity paramActivity)
  {
    Window localWindow;
    if (paramActivity != null) {
      localWindow = paramActivity.getWindow();
    } else {
      localWindow = null;
    }
    if (localWindow == null) {
      return -1.0F;
    }
    float f1;
    try
    {
      float f2 = localWindow.getAttributes().screenBrightness;
      if (f2 >= 0.0F)
      {
        f1 = f2;
        if (f2 <= 1.0F) {
          break label63;
        }
      }
      try
      {
        int i = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
        f1 = i / 255.0F;
        label63:
        f2 = f1;
        if (f1 > 1.0F) {
          f2 = 1.0F;
        }
        f1 = f2;
        if (f2 >= 0.0F) {
          return f1;
        }
        return 0.0F;
      }
      catch (Exception paramActivity)
      {
        f1 = f2;
      }
      QMLog.e("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
    }
    catch (Exception paramActivity)
    {
      f1 = 0.0F;
    }
    return f1;
  }
  
  public static boolean keepScreenOn(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity != null) {
      paramActivity = paramActivity.getWindow();
    } else {
      paramActivity = null;
    }
    if (paramActivity == null) {
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
    if (paramActivity == null) {
      return;
    }
    paramActivity = paramActivity.getWindow();
    if (paramActivity == null) {
      return;
    }
    WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
    localLayoutParams.screenBrightness = paramFloat;
    paramActivity.setAttributes(localLayoutParams);
  }
  
  @JsEvent({"getScreenBrightness"})
  public String getScreenBrightness(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mMiniAppContext.getAttachedActivity()));
      paramRequestEvent.ok(localJSONObject);
    }
    catch (Throwable paramRequestEvent)
    {
      QMLog.e("ScreenJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
    }
    return "";
  }
  
  public void onCreate(IMiniAppContext paramIMiniAppContext)
  {
    super.onCreate(paramIMiniAppContext);
    AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.1(this));
  }
  
  @JsEvent({"setKeepScreenOn"})
  public String setKeepScreenOn(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.3(this, paramRequestEvent));
    return "";
  }
  
  @JsEvent({"setScreenBrightness"})
  public String setScreenBrightness(RequestEvent paramRequestEvent)
  {
    AppBrandTask.runTaskOnUiThread(new ScreenJsPlugin.2(this, paramRequestEvent));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */