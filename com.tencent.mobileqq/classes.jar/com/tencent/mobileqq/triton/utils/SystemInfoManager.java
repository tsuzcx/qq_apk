package com.tencent.mobileqq.triton.utils;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.engine.TTLog;
import com.tencent.mobileqq.triton.sdk.IQQEnv;
import com.tencent.mobileqq.triton.sdk.game.IGameLauncher;
import com.tencent.mobileqq.triton.sdk.game.MiniGameInfo;
import org.json.JSONObject;

public class SystemInfoManager
{
  private static final String DISPLAY_NOTCH_STATUS = "display_notch_status";
  private static final String TAG = "SystemInfoManager";
  private Context appContext;
  private float mDensity;
  private boolean mIsHideNotchSwitchOpen;
  private int mScreenHeightPixels;
  private final int mScreenRefreshRate;
  private int mScreenWidthPixels;
  private int mStatusBarHeight;
  private JSONObject mSystemInfo;
  private TTEngine mTritonEngine;
  
  public SystemInfoManager(TTEngine paramTTEngine, Context paramContext)
  {
    this.mTritonEngine = paramTTEngine;
    this.appContext = paramContext.getApplicationContext();
    paramTTEngine = this.appContext.getResources().getDisplayMetrics();
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramTTEngine = new DisplayMetrics();
      ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getRealMetrics(paramTTEngine);
    }
    this.mDensity = paramTTEngine.density;
    this.mScreenWidthPixels = paramTTEngine.widthPixels;
    this.mScreenHeightPixels = paramTTEngine.heightPixels;
    this.mScreenRefreshRate = getScreenRefreshRate(paramContext);
    this.mStatusBarHeight = DisplayUtil.getStatusBarHeight(paramContext);
    if (Build.MANUFACTURER.equalsIgnoreCase("huawei")) {
      if (Settings.Secure.getInt(paramContext.getContentResolver(), "display_notch_status", 0) != 1) {
        break label136;
      }
    }
    label136:
    for (boolean bool = true;; bool = false)
    {
      this.mIsHideNotchSwitchOpen = bool;
      return;
    }
  }
  
  private int getScreenRefreshRate(Context paramContext)
  {
    paramContext = ((DisplayManager)paramContext.getSystemService("display")).getDisplays();
    if ((paramContext != null) && (paramContext.length > 0)) {
      return (int)paramContext[0].getRefreshRate();
    }
    return 60;
  }
  
  private boolean isLandscape()
  {
    MiniGameInfo localMiniGameInfo = this.mTritonEngine.getGameLauncher().getCurrentGame();
    if (localMiniGameInfo != null) {
      return localMiniGameInfo.isOrientationLandscape();
    }
    return true;
  }
  
  public float getDensity()
  {
    return this.mDensity;
  }
  
  public int getScreenHeight()
  {
    return this.mScreenHeightPixels;
  }
  
  public int getScreenRefreshRate()
  {
    return this.mScreenRefreshRate;
  }
  
  public float getScreenWidth()
  {
    return this.mScreenWidthPixels;
  }
  
  public JSONObject getSystemInfo()
  {
    if (this.mSystemInfo != null) {
      return this.mSystemInfo;
    }
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject1.put("brand", Build.BRAND);
        localJSONObject1.put("model", Build.MODEL);
        if (isLandscape())
        {
          j = Math.min(this.mScreenWidthPixels, this.mScreenHeightPixels);
          i = Math.max(this.mScreenWidthPixels, this.mScreenHeightPixels);
          int k = (int)(j / this.mDensity);
          j = (int)(i / this.mDensity);
          localJSONObject1.put("pixelRatio", this.mDensity);
          localJSONObject1.put("devicePixelRatio", this.mDensity);
          int m = (int)(this.mStatusBarHeight / this.mDensity);
          i = j;
          if (isLandscape())
          {
            i = j;
            if (this.mIsHideNotchSwitchOpen) {
              i = j - m;
            }
          }
          localJSONObject1.put("screenWidth", i);
          localJSONObject1.put("screenHeight", k);
          localJSONObject1.put("windowWidth", i);
          localJSONObject1.put("windowHeight", k);
          localJSONObject1.put("statusBarHeight", m);
          localJSONObject1.put("language", "zh_CN");
          localJSONObject1.put("system", "Android " + Build.VERSION.RELEASE);
          localJSONObject1.put("platform", "android");
          localJSONObject1.put("fontSizeSetting", 16);
          localJSONObject1.put("SDKVersion", "0.1.0");
          localJSONObject1.put("benchmarkLevel", this.mTritonEngine.getQQEnv().getBenchmarkLevel());
          localJSONObject1.put("version", this.mTritonEngine.getQQEnv().getPlatformVersion());
          localJSONObject1.put("SDKVersion", "1.1.2.1581929008032");
          localJSONObject1.put("AppPlatform", this.mTritonEngine.getQQEnv().getPlatformName());
          JSONObject localJSONObject2 = new JSONObject();
          j = DisplayUtil.dip2px(this.appContext, 9.0F);
          if ((!this.mTritonEngine.getQQEnv().isNotchValid()) || (isLandscape())) {
            break label540;
          }
          i = this.mStatusBarHeight;
          localJSONObject2.put("marginTop", i + j);
          localJSONObject2.put("navbarHeight", DisplayUtil.dip2px(this.appContext, 30.0F));
          localJSONObject2.put("marginRight", DisplayUtil.dip2px(this.appContext, 12.5F));
          localJSONObject2.put("navbarWidth", DisplayUtil.dip2px(this.appContext, 80.0F));
          localJSONObject1.put("navbarPosition", localJSONObject2);
          this.mSystemInfo = localJSONObject1;
          return localJSONObject1;
        }
      }
      catch (Exception localException)
      {
        TTLog.e("SystemInfoManager", "getSystemInfo error " + localException.getMessage());
        return localJSONObject1;
      }
      int j = Math.max(this.mScreenWidthPixels, this.mScreenHeightPixels);
      int i = Math.min(this.mScreenWidthPixels, this.mScreenHeightPixels);
      continue;
      label540:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.triton.utils.SystemInfoManager
 * JD-Core Version:    0.7.0.1
 */