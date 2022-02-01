package com.tencent.mobileqq.vas.wallpaper.model;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.Model.DrawCallback;

public class DrawDrawableWallpaperModel
  implements DrawWallpaperContract.Model
{
  private Drawable.Callback jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  
  public DrawDrawableWallpaperModel(Drawable paramDrawable)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
  }
  
  private void a(boolean paramBoolean)
  {
    Drawable localDrawable = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
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
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      a(true);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(true, false);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.invalidateSelf();
    }
  }
  
  public void a(DrawWallpaperContract.Model.DrawCallback paramDrawCallback)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback = new DrawDrawableWallpaperModel.1(this, paramDrawCallback);
    paramDrawCallback = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
    if (paramDrawCallback != null) {
      paramDrawCallback.setCallback(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable$Callback);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null)
    {
      a(false);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setVisible(false, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.model.DrawDrawableWallpaperModel
 * JD-Core Version:    0.7.0.1
 */