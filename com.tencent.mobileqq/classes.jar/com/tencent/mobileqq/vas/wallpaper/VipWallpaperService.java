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
import bdwz;
import bdxa;
import bdxb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

public final class VipWallpaperService
  extends WallpaperService
{
  private bdxa a = new bdxa(null);
  
  public static SharedPreferences a(Context paramContext)
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
    catch (Exception localException) {}
    return null;
  }
  
  public static bdxb a(Context paramContext, boolean paramBoolean)
  {
    if ((!paramBoolean) || (bdxa.a(paramContext))) {
      return a(a(paramContext));
    }
    return new bdxb();
  }
  
  public static bdxb a(SharedPreferences paramSharedPreferences)
  {
    return new bdxb(paramSharedPreferences.getString("wallpaper_item_id", ""), paramSharedPreferences.getString("wallpaper_path_img", ""), paramSharedPreferences.getString("wallpaper_path_video", ""));
  }
  
  public static File a(Context paramContext)
  {
    paramContext = new File(paramContext.getFilesDir(), "vas/wallpaper");
    if (!paramContext.exists()) {
      paramContext.mkdirs();
    }
    return paramContext;
  }
  
  @SuppressLint({"ApplySharedPref"})
  public static void a(Activity paramActivity, bdxb parambdxb, AtomicBoolean paramAtomicBoolean)
  {
    QLog.i("VipWallpaper", 1, "set wallpaper = " + parambdxb.toString());
    a(paramActivity).edit().putString("wallpaper_item_id", parambdxb.a).putString("wallpaper_path_img", parambdxb.b).putString("wallpaper_path_video", parambdxb.c).commit();
    if ((parambdxb.a != null) && (!parambdxb.a.equals("0"))) {
      a(paramActivity, paramAtomicBoolean);
    }
  }
  
  private static void a(Activity paramActivity, AtomicBoolean paramAtomicBoolean)
  {
    if (!bdxa.a(paramActivity))
    {
      localIntent = new Intent("android.service.wallpaper.CHANGE_LIVE_WALLPAPER");
      localIntent.putExtra("android.service.wallpaper.extra.LIVE_WALLPAPER_COMPONENT", new ComponentName(paramActivity, VipWallpaperService.class));
      localIntent.putExtra("big_brother_source_key", "biz_src_jc_vip");
      paramActivity.startActivity(localIntent);
      if (paramAtomicBoolean != null) {
        paramAtomicBoolean.set(true);
      }
    }
    while (paramAtomicBoolean == null)
    {
      Intent localIntent;
      return;
    }
    paramAtomicBoolean.set(false);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a.a(getBaseContext());
    QLog.i("VipWallpaper", 1, "onCreate");
  }
  
  public WallpaperService.Engine onCreateEngine()
  {
    return new bdwz(this, null);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.a.a();
    QLog.i("VipWallpaper", 1, "onDestroy");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.VipWallpaperService
 * JD-Core Version:    0.7.0.1
 */