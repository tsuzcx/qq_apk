package com.tencent.mobileqq.vas.wallpaper.model;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model.DrawCallback;

class DrawDrawableWallpaperModel$1
  implements Drawable.Callback
{
  DrawDrawableWallpaperModel$1(DrawDrawableWallpaperModel paramDrawDrawableWallpaperModel, DrawWallpaperContract.Model.DrawCallback paramDrawCallback) {}
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    DrawWallpaperContract.Model.DrawCallback localDrawCallback = this.a;
    if (localDrawCallback != null) {
      localDrawCallback.a(paramDrawable);
    }
  }
  
  public void scheduleDrawable(Drawable paramDrawable, Runnable paramRunnable, long paramLong) {}
  
  public void unscheduleDrawable(Drawable paramDrawable, Runnable paramRunnable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.model.DrawDrawableWallpaperModel.1
 * JD-Core Version:    0.7.0.1
 */