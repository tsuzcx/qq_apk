package com.tencent.qqmini.sdk.minigame.plugins;

import android.app.Activity;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import bdcz;
import bdfz;
import bdgg;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import com.tencent.qqmini.sdk.core.plugins.BaseJsPlugin;
import org.json.JSONObject;

public class ImmersiveJsPlugin
  extends BaseJsPlugin
{
  public static final String API_SET_MEUN_STYLE = "setMenuStyle";
  public static final String API_SET_STATUS_BAR_STYLE = "setStatusBarStyle";
  private static final String STATUS_BAR_STYLE_BLACK = "black";
  private static final String STATUS_BAR_STYLE_WHITE = "white";
  private static final String STYLE_TAG = "style";
  private static final String TAG = "ImmersivePlugin";
  
  private static void setStatusBarTextColor(Activity paramActivity, boolean paramBoolean)
  {
    if (paramActivity == null) {}
    for (;;)
    {
      return;
      paramActivity = paramActivity.getWindow();
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramActivity.getDecorView().setSystemUiVisibility(1282);
        paramActivity.setStatusBarColor(0);
        paramActivity.setNavigationBarColor(0);
      }
      while ((Build.VERSION.SDK_INT >= 23) && (paramBoolean))
      {
        paramActivity.getDecorView().setSystemUiVisibility(9218);
        return;
        if (Build.VERSION.SDK_INT >= 19)
        {
          WindowManager.LayoutParams localLayoutParams = paramActivity.getAttributes();
          localLayoutParams.flags = (0x4000000 | localLayoutParams.flags);
        }
      }
    }
  }
  
  public boolean onInterceptJsEvent(bdfz parambdfz)
  {
    if (!this.mIsMiniGame)
    {
      parambdfz.b();
      return true;
    }
    return super.onInterceptJsEvent(parambdfz);
  }
  
  public String setMenuStyle(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      if (this.mMiniAppContext.a() == null) {
        return bdgg.a(parambdfz.a, null, "activity not exist").toString();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localObject = new JSONObject();
      }
      Object localObject = ((JSONObject)localObject).optString("style", null);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("light".equals(localObject)) || ("dark".equals(localObject))))
      {
        MiniAppEnv.g().setMenuStyle((String)localObject);
        return parambdfz.a();
      }
      return parambdfz.a("invalid style " + (String)localObject);
    }
  }
  
  public String setStatusBarStyle(bdfz parambdfz)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(parambdfz.b);
      localActivity = this.mMiniAppContext.a();
      if (localActivity == null) {
        return bdgg.a(parambdfz.a, null, "activity not exist").toString();
      }
    }
    catch (Throwable localThrowable)
    {
      Activity localActivity;
      for (;;)
      {
        localObject = new JSONObject();
      }
      Object localObject = ((JSONObject)localObject).optString("style", null);
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (("white".equals(localObject)) || ("black".equals(localObject))))
      {
        localActivity.runOnUiThread(new ImmersiveJsPlugin.1(this, localActivity, (String)localObject));
        return parambdfz.a();
      }
      return parambdfz.a("invalid style " + (String)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.minigame.plugins.ImmersiveJsPlugin
 * JD-Core Version:    0.7.0.1
 */