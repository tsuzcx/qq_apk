package com.tencent.mobileqq.vas.wallpaper;

import java.lang.ref.WeakReference;

class WallpaperHelper$ReTryRunnable
  implements Runnable
{
  VipWallpaperService.WallpaperConfig jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig;
  WeakReference<WallpaperHelper> jdField_a_of_type_JavaLangRefWeakReference;
  
  public WallpaperHelper$ReTryRunnable(WallpaperHelper paramWallpaperHelper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWallpaperHelper);
  }
  
  public void a(VipWallpaperService.WallpaperConfig paramWallpaperConfig)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig = paramWallpaperConfig;
  }
  
  public void run()
  {
    WallpaperHelper localWallpaperHelper = (WallpaperHelper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localWallpaperHelper != null) && (this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig != null)) {
      WallpaperHelper.a(localWallpaperHelper, this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ReTryRunnable
 * JD-Core Version:    0.7.0.1
 */