package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import bglv;
import bgok;
import bgor;
import com.tencent.qqmini.sdk.log.QMLog;
import org.json.JSONObject;

public class ScreenJsPlugin
  extends BaseJsPlugin
{
  private static final String EVENT_ON_USER_CAPTURE_SCREEN = "onUserCaptureScreen";
  private static final String TAG = "ScreenJsPlugin";
  
  public static float getScreenBrightness(Activity paramActivity)
  {
    Window localWindow;
    float f1;
    if (paramActivity != null)
    {
      localWindow = paramActivity.getWindow();
      if (localWindow != null) {
        break label26;
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
        label26:
        f2 = localWindow.getAttributes().screenBrightness;
        f1 = f2;
        if (f2 < 0.0F)
        {
          int i;
          QMLog.e("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
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
          break label62;
        }
        paramActivity = paramActivity;
        f2 = 0.0F;
      }
    }
    label62:
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
  
  public String getScreenBrightness(bgok parambgok)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mMiniAppContext.a()));
      parambgok.a(localJSONObject);
      return "";
    }
    catch (Throwable parambgok)
    {
      for (;;)
      {
        QMLog.e("ScreenJsPlugin", parambgok.getMessage(), parambgok);
      }
    }
  }
  
  public void onCreate(bglv parambglv)
  {
    super.onCreate(parambglv);
    bgor.a(new ScreenJsPlugin.1(this));
  }
  
  public String setKeepScreenOn(bgok parambgok)
  {
    bgor.a(new ScreenJsPlugin.3(this, parambgok));
    return "";
  }
  
  public String setScreenBrightness(bgok parambgok)
  {
    bgor.a(new ScreenJsPlugin.2(this, parambgok));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */