package com.tencent.qqmini.sdk.core.plugins;

import android.app.Activity;
import android.provider.Settings.System;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import begz;
import beka;
import beki;
import besl;
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
          besl.d("ScreenJsPlugin", paramActivity.getMessage(), paramActivity);
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
  
  public String getScreenBrightness(beka parambeka)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("value", getScreenBrightness(this.mActivity));
      parambeka.a(localJSONObject);
      return "";
    }
    catch (Throwable parambeka)
    {
      for (;;)
      {
        besl.d("ScreenJsPlugin", parambeka.getMessage(), parambeka);
      }
    }
  }
  
  public void onCreate(begz parambegz)
  {
    super.onCreate(parambegz);
    this.mActivity = parambegz.a();
  }
  
  public String setKeepScreenOn(beka parambeka)
  {
    beki.a(new ScreenJsPlugin.2(this, parambeka));
    return "";
  }
  
  public String setScreenBrightness(beka parambeka)
  {
    beki.a(new ScreenJsPlugin.1(this, parambeka));
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.plugins.ScreenJsPlugin
 * JD-Core Version:    0.7.0.1
 */