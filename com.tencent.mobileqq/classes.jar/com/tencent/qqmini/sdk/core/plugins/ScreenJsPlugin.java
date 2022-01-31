package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import bdcz;
import bdfz;
import bdgi;
import bdnw;
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
          bdnw.d("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
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
  
  public String getScreenBrightness(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mActivity));
      parambdfz.a(localJSONObject);
      return "";
    }
    catch (Throwable parambdfz)
    {
      for (;;)
      {
        bdnw.d("ScreenJsPlugin", parambdfz.getMessage(), parambdfz);
      }
    }
  }
  
  public void onCreate(bdcz parambdcz)
  {
    super.onCreate(parambdcz);
    this.mActivity = parambdcz.a();
  }
  
  public String setKeepScreenOn(bdfz parambdfz)
  {
    bdgi.a(new ScreenJsPlugin.2(this, parambdfz));
    return "";
  }
  
  public String setScreenBrightness(bdfz parambdfz)
  {
    bdgi.a(new ScreenJsPlugin.1(this, parambdfz));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */