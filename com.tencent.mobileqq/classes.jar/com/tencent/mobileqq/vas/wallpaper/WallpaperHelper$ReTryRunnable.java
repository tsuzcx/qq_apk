package com.tencent.mobileqq.vas.wallpaper;

import bieh;
import java.lang.ref.WeakReference;

class WallpaperHelper$ReTryRunnable
  implements Runnable
{
  bieh jdField_a_of_type_Bieh;
  WeakReference<WallpaperHelper> jdField_a_of_type_JavaLangRefWeakReference;
  
  public WallpaperHelper$ReTryRunnable(WallpaperHelper paramWallpaperHelper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWallpaperHelper);
  }
  
  public void a(bieh parambieh)
  {
    this.jdField_a_of_type_Bieh = parambieh;
  }
  
  public void run()
  {
    WallpaperHelper localWallpaperHelper = (WallpaperHelper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localWallpaperHelper != null) && (this.jdField_a_of_type_Bieh != null)) {
      WallpaperHelper.a(localWallpaperHelper, this.jdField_a_of_type_Bieh, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ReTryRunnable
 * JD-Core Version:    0.7.0.1
 */