package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import behq;
import bekr;
import bekz;
import betc;
import org.json.JSONObject;

public class ScreenJsPlugin
  extends BaseJsPlugin
{
  private static final String TAG = "ScreenJsPlugin";
  private Activity mActivity;
  
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
          betc.d("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
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
  
  public String getScreenBrightness(bekr parambekr)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mActivity));
      parambekr.a(localJSONObject);
      return "";
    }
    catch (Throwable parambekr)
    {
      for (;;)
      {
        betc.d("ScreenJsPlugin", parambekr.getMessage(), parambekr);
      }
    }
  }
  
  public void onCreate(behq parambehq)
  {
    super.onCreate(parambehq);
    this.mActivity = parambehq.a();
  }
  
  public String setKeepScreenOn(bekr parambekr)
  {
    bekz.a(new ScreenJsPlugin.2(this, parambekr));
    return "";
  }
  
  public String setScreenBrightness(bekr parambekr)
  {
    bekz.a(new ScreenJsPlugin.1(this, parambekr));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */