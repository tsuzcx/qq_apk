package com.tencent.mobileqq.vas.wallpaper;

import bdss;
import java.lang.ref.WeakReference;

class WallpaperHelper$ReTryRunnable
  implements Runnable
{
  bdss jdField_a_of_type_Bdss;
  WeakReference<WallpaperHelper> jdField_a_of_type_JavaLangRefWeakReference;
  
  public WallpaperHelper$ReTryRunnable(WallpaperHelper paramWallpaperHelper)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramWallpaperHelper);
  }
  
  public void a(bdss parambdss)
  {
    this.jdField_a_of_type_Bdss = parambdss;
  }
  
  public void run()
  {
    WallpaperHelper localWallpaperHelper = (WallpaperHelper)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if ((localWallpaperHelper != null) && (this.jdField_a_of_type_Bdss != null)) {
      WallpaperHelper.a(localWallpaperHelper, this.jdField_a_of_type_Bdss, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.WallpaperHelper.ReTryRunnable
 * JD-Core Version:    0.7.0.1
 */