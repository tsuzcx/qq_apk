package com.tencent.mobileqq.vas.wallpaper.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.android.gldrawable.api.IGLDrawable;
import com.tencent.image.ApngDrawable;
import com.tencent.image.ApngImage;
import com.tencent.mobileqq.vas.wallpaper.contract.DrawWallpaperContract.View;

public abstract class AbstractDrawWallpaperView
  implements DrawWallpaperContract.View
{
  protected Rect a;
  protected SurfaceHolder a;
  private boolean a;
  
  public AbstractDrawWallpaperView(SurfaceHolder paramSurfaceHolder)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewSurfaceHolder = paramSurfaceHolder;
  }
  
  private void b(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof IGLDrawable))
    {
      ((IGLDrawable)paramDrawable).setLockWH(true);
      paramDrawable.setBounds(this.jdField_a_of_type_AndroidGraphicsRect);
      return;
    }
    Rect localRect = new Rect();
    Object localObject;
    if ((paramDrawable instanceof BitmapDrawable))
    {
      localObject = (BitmapDrawable)paramDrawable;
      localRect.set(0, 0, ((BitmapDrawable)localObject).getBitmap().getWidth(), ((BitmapDrawable)localObject).getBitmap().getHeight());
    }
    else if ((paramDrawable instanceof ApngDrawable))
    {
      localObject = (ApngDrawable)paramDrawable;
      localRect.set(0, 0, ((ApngDrawable)localObject).getImage().getWidth(), ((ApngDrawable)localObject).getImage().getHeight());
    }
    float f1 = this.jdField_a_of_type_AndroidGraphicsRect.width() / localRect.width();
    float f2 = this.jdField_a_of_type_AndroidGraphicsRect.height() / localRect.height();
    if (f1 > f2)
    {
      localRect.right = this.jdField_a_of_type_AndroidGraphicsRect.right;
      localRect.bottom = ((int)(localRect.bottom * f1));
    }
    else
    {
      localRect.bottom = this.jdField_a_of_type_AndroidGraphicsRect.bottom;
      localRect.right = ((int)(localRect.right * f2));
    }
    Gravity.apply(17, localRect.width(), localRect.height(), this.jdField_a_of_type_AndroidGraphicsRect, localRect);
    paramDrawable.setBounds(localRect);
  }
  
  abstract Canvas a(SurfaceHolder paramSurfaceHolder);
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect.set(paramRect);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    Object localObject = this.jdField_a_of_type_AndroidViewSurfaceHolder;
    if ((localObject != null) && (((SurfaceHolder)localObject).getSurface() != null) && (this.jdField_a_of_type_AndroidViewSurfaceHolder.getSurface().isValid()))
    {
      localObject = a(this.jdField_a_of_type_AndroidViewSurfaceHolder);
      if (localObject != null)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          if (this.jdField_a_of_type_AndroidGraphicsRect.width() == 0) {
            this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, ((Canvas)localObject).getWidth(), ((Canvas)localObject).getHeight());
          }
          this.jdField_a_of_type_Boolean = false;
          b(paramDrawable);
        }
        paramDrawable.draw((Canvas)localObject);
        this.jdField_a_of_type_AndroidViewSurfaceHolder.unlockCanvasAndPost((Canvas)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.view.AbstractDrawWallpaperView
 * JD-Core Version:    0.7.0.1
 */