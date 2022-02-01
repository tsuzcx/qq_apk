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
  protected SurfaceHolder a;
  protected Rect b = new Rect();
  private boolean c = true;
  
  public AbstractDrawWallpaperView(SurfaceHolder paramSurfaceHolder)
  {
    this.a = paramSurfaceHolder;
  }
  
  private void b(Drawable paramDrawable)
  {
    if ((paramDrawable instanceof IGLDrawable))
    {
      ((IGLDrawable)paramDrawable).setLockWH(true);
      paramDrawable.setBounds(this.b);
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
    float f1 = this.b.width() / localRect.width();
    float f2 = this.b.height() / localRect.height();
    if (f1 > f2)
    {
      localRect.right = this.b.right;
      localRect.bottom = ((int)(localRect.bottom * f1));
    }
    else
    {
      localRect.bottom = this.b.bottom;
      localRect.right = ((int)(localRect.right * f2));
    }
    Gravity.apply(17, localRect.width(), localRect.height(), this.b, localRect);
    paramDrawable.setBounds(localRect);
  }
  
  abstract Canvas a(SurfaceHolder paramSurfaceHolder);
  
  public final void a(Rect paramRect)
  {
    this.b.set(paramRect);
    this.c = true;
  }
  
  public final void a(Drawable paramDrawable)
  {
    if (paramDrawable == null) {
      return;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((SurfaceHolder)localObject).getSurface() != null) && (this.a.getSurface().isValid()))
    {
      localObject = a(this.a);
      if (localObject != null)
      {
        if (this.c)
        {
          if (this.b.width() == 0) {
            this.b.set(0, 0, ((Canvas)localObject).getWidth(), ((Canvas)localObject).getHeight());
          }
          this.c = false;
          b(paramDrawable);
        }
        paramDrawable.draw((Canvas)localObject);
        this.a.unlockCanvasAndPost((Canvas)localObject);
      }
    }
  }
  
  public void b()
  {
    this.c = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.wallpaper.view.AbstractDrawWallpaperView
 * JD-Core Version:    0.7.0.1
 */