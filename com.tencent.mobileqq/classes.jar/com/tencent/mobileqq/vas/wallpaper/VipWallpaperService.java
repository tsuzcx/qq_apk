package com.tencent.mobileqq.vas.wallpaper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.WallpaperManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.Drawable;
import android.service.wallpaper.WallpaperService;
import android.service.wallpaper.WallpaperService.Engine;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public final class VipWallpaperService
  extends WallpaperService
{
  private VipWallpaperService.RunningStateHelper a = new VipWallpaperService.RunningStateHelper(null);
  
  static SharedPreferences a(Context paramContext)
  {
    return paramContext.getApplicationContext().getSharedPreferences("qqvip_wallpaper", 4);
  }
  
  public static Drawable a()
  {
    try
    {
      QLog.i("VipWallpaper", 1, "use system wallpaper");
      Drawable localDrawable = ((WallpaperManager)BaseApplicationImpl.getApplication().getSystemService("wallpaper")).getDrawable();
      return localDrawable;
    }
    catch (Exception localException)
    {
      label25:
      break label25;
    }
    return null;
  }
  
  public static VipWallpaperService.WallpaperConfig a(Context paramContext, boolean paramBoolean)
  {
    if ((paramBoolean) && (!VipWallpaperService.RunningStateHelper.a(paramContext))) {
      return new VipWallpaperService.WallpaperConfig();
    }
    return a(a(paramContext));
  }
  
  static VipWallpaperService.WallpaperConfig a(SharedPreferences paramSharedPreferences)
  {
    return new VipWallpaperService.WallpaperConfig(paramSharedPreferences.getString("wallpaper_item_id", ""), paramSharedPreferences.getString("wallpaper_path_img", ""), paramSharedPreferences.getString("wallpaper_path_video", ""));
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void a(Activity paramActivity, VipWallpaperService.WallpaperConfig paramWallpaperConfig, AtomicBoolean paramAtomicBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set wallpaper = ");
    localStringBuilder.append(paramWallpaperConfig.toString());
    QLog.i("VipWallpaper", 1, localStringBuilder.toString());
    a(paramActivity).edit().putString("wallpaper_item_id", paramWallpaperConfig.a).putString("wallpaper_path_img", paramWallpaperConfig.b).putString("wallpaper_path_video", paramWallpaperConfig.c).commit();
    if ((paramWallpaperConfig.a != null) && (!paramWallpaperConfig.a.equals("0"))) {
      a(paramActivity, paramAtomicBoolean);
    }
  }
  
  private static void a(Activity paramActivity, AtomicBoolean paramAtomicBoolean)
  {
    if (!VipWallpaperService.RunningStateHelper.a(paramActivity))
    {
      Intent localIntent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
      localIntent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(paramActivity, VipWallpaperService.class));
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(localIntent);
      if (paramAtomicBoolean != null) {
        paramAtomicBoolean.set(true);
      }
    }
    else if (paramAtomicBoolean != null)
    {
      paramAtomicBoolean.set(false);
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
    QLog.i("VipWallpaper", 1, "onCreate");
  }
  
  public WallpaperService.Engine onCreateEngine()
  {
    return new VipWallpaperService.MyEngine(this, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QLog.i("VipWallpaper", 1, "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.VipWallpaperService
 * JD-Core Version:    0.7.0.1
 */