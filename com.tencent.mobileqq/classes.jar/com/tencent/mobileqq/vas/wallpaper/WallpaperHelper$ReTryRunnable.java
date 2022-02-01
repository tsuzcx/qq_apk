package com.tencent.mobileqq.vas.wallpaper;

import java.lang.ref.WeakReference;

class WallpaperHelper$ReTryRunnable
  implements Runnable
{
  WeakReference<WallpaperHelper> a;
  VipWallpaperService.WallpaperConfig b;
  
  public WallpaperHelper$ReTryRunnable(WallpaperHelper paramWallpaperHelper)
  {
    this.a = new WeakReference(paramWallpaperHelper);
  }
  
  public void a(VipWallpaperService.WallpaperConfig paramWallpaperConfig)
  {
    this.b = paramWallpaperConfig;
  }
  
  public void run()
  {
    WallpaperHelper localWallpaperHelper = (WallpaperHelper)this.a.get();
    if (localWallpaperHelper != null)
    {
      VipWallpaperService.WallpaperConfig localWallpaperConfig = this.b;
      if (localWallpaperConfig != null) {
        WallpaperHelper.a(localWallpaperHelper, localWallpaperConfig, false);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ReTryRunnable
 * JD-Core Version:    0.7.0.1
 */