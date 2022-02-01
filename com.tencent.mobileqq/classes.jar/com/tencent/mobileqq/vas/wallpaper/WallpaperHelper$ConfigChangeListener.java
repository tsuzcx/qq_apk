package com.tencent.mobileqq.vas.wallpaper;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.lang.ref.WeakReference;

class WallpaperHelper$ConfigChangeListener
  implements SharedPreferences.OnSharedPreferenceChangeListener
{
  private VipWallpaperService.WallpaperConfig jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig;
  private final WeakReference<WallpaperHelper> jdField_a_of_type_JavaLangRefWeakReference;
  
  WallpaperHelper$ConfigChangeListener(WallpaperHelper paramWallpaperHelper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWallpaperHelper);
  }
  
  public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
  {
    paramString = (WallpaperHelper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (paramString != null)
    {
      paramSharedPreferences = VipWallpaperService.a(paramSharedPreferences);
      VipWallpaperService.WallpaperConfig localWallpaperConfig = this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig;
      if ((localWallpaperConfig == null) || (!localWallpaperConfig.equals(paramSharedPreferences)))
      {
        this.jdField_a_of_type_ComTencentMobileqqVasWallpaperVipWallpaperService$WallpaperConfig = paramSharedPreferences;
        ThreadManagerV2.getUIHandlerV2().post(new WallpaperHelper.ConfigChangeListener.1(this, paramString, paramSharedPreferences));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ConfigChangeListener
 * JD-Core Version:    0.7.0.1
 */