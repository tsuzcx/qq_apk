package com.tencent.mobileqq.vas.wallpaper.presenter;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model.DrawCallback;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.View;
import com.tencent.qphone.base.util.QLog;

class DrawWallpaperPresenter$1
  implements DrawWallpaperContract.Model.DrawCallback
{
  DrawWallpaperPresenter$1(DrawWallpaperPresenter paramDrawWallpaperPresenter) {}
  
  public void a(Drawable paramDrawable)
  {
    QLog.i("VipWallpaper", 1, "mView#draw");
    DrawWallpaperPresenter.a(this.a).a(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.presenter.DrawWallpaperPresenter.1
 * JD-Core Version:    0.7.0.1
 */