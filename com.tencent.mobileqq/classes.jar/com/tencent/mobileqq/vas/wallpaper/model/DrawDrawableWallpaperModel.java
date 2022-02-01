package com.tencent.mobileqq.vas.wallpaper.model;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model.DrawCallback;

public class DrawDrawableWallpaperModel
  implements DrawWallpaperContract.Model
{
  private Drawable a;
  private Drawable.Callback b;
  
  public DrawDrawableWallpaperModel(Drawable paramDrawable)
  {
    this.a = paramDrawable;
  }
  
  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = this.a;
    if ((localDrawable instanceof ApngDrawable))
    {
      if (paramBoolean)
      {
        ((ApngDrawable)localDrawable).resume();
        return;
      }
      ((ApngDrawable)localDrawable).pause();
    }
  }
  
  public void a()
  {
    if (this.a != null)
    {
      a(true);
      this.a.setVisible(true, false);
      this.a.invalidateSelf();
    }
  }
  
  public void a(DrawWallpaperContract.Model.DrawCallback paramDrawCallback)
  {
    this.b = new DrawDrawableWallpaperModel.1(this, paramDrawCallback);
    paramDrawCallback = this.a;
    if (paramDrawCallback != null) {
      paramDrawCallback.setCallback(this.b);
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      a(false);
      this.a.setVisible(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.model.DrawDrawableWallpaperModel
 * JD-Core Version:    0.7.0.1
 */