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
    f1 = 0.0F;
    float f3 = 0.0F;
    Window localWindow;
    if (paramActivity != null)
    {
      localWindow = paramActivity.getWindow();
      if (localWindow != null) {
        break label30;
      }
      f1 = -1.0F;
    }
    for (;;)
    {
      return f1;
      localWindow = null;
      break;
      try
      {
        label30:
        f2 = localWindow.getAttributes().screenBrightness;
        if (f2 >= 0.0F)
        {
          f1 = f2;
          if (f2 <= 1.0F) {
            break label71;
          }
        }
      }
      catch (Exception paramActivity)
      {
        try
        {
          int i = Settings.System.getInt(paramActivity.getContentResolver(), "screen_brightness");
          f1 = i / 255.0F;
          label71:
          f2 = f1;
          if (f1 > 1.0F) {
            f2 = 1.0F;
          }
          f1 = f3;
          if (f2 < 0.0F) {
            continue;
          }
          return f2;
        }
        catch (Exception paramActivity)
        {
          for (;;)
          {
            float f2;
            f1 = f2;
          }
        }
        paramActivity = paramActivity;
      }
    }
    QMLog.e("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
    return f1;
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
  
  @JsEvent({"getScreenBrightness"})
  public String getScreenBrightness(RequestEvent paramRequestEvent)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mMiniAppContext.getAttachedActivity()));
      paramRequestEvent.ok(localJSONObject);
      return "";
    }
    catch (Throwable paramRequestEvent)
    {
      for (;;)
      {
        QMLog.e("ScreenJsPlugin", paramRequestEvent.getMessage(), paramRequestEvent);
      }
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */