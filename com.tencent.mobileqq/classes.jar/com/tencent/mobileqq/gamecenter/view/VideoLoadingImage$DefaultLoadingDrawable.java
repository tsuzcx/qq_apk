package com.tencent.mobileqq.gamecenter.view;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

class VideoLoadingImage$DefaultLoadingDrawable
  extends Drawable
{
  private Bitmap a;
  private Bitmap b;
  private int c = 0;
  private int d = 0;
  private float e = 0.0F;
  private Rect f = new Rect();
  private Rect g = new Rect();
  private Rect h = new Rect();
  private Rect i = new Rect();
  
  VideoLoadingImage$DefaultLoadingDrawable(@NonNull Resources paramResources)
  {
    this.a = BitmapFactory.decodeResource(paramResources, 2130840532);
    Bitmap localBitmap = this.a;
    if (localBitmap != null) {
      this.f.set(0, 0, localBitmap.getWidth(), this.a.getHeight());
    }
    this.b = BitmapFactory.decodeResource(paramResources, 2130840533);
    paramResources = this.b;
    if (paramResources != null) {
      this.g.set(0, 0, paramResources.getWidth(), this.b.getHeight());
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if ((this.a != null) && (this.b != null))
    {
      this.e += 2.5F;
      paramCanvas.save();
      paramCanvas.rotate(this.e, this.d >> 1, this.c >> 1);
      paramCanvas.drawBitmap(this.a, this.f, this.h, null);
      paramCanvas.restore();
      paramCanvas.rotate(-this.e, this.d >> 1, this.c >> 1);
      paramCanvas.drawBitmap(this.b, this.g, this.i, null);
      paramCanvas = getCallback();
      if (paramCanvas != null) {
        paramCanvas.invalidateDrawable(this);
      }
    }
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.d = paramRect.width();
    this.c = paramRect.height();
    this.h.set(0, 0, this.d, this.c);
    paramRect = this.i;
    int j = this.d;
    int k = this.c;
    paramRect.set(j >> 2, k >> 2, j * 3 / 4, k * 3 / 4);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.VideoLoadingImage.DefaultLoadingDrawable
 * JD-Core Version:    0.7.0.1
 */