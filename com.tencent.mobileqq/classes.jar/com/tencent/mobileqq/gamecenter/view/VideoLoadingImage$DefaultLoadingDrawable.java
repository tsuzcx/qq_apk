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
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private int jdField_b_of_type_Int = 0;
  private Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  private Rect c = new Rect();
  private Rect d = new Rect();
  
  VideoLoadingImage$DefaultLoadingDrawable(@NonNull Resources paramResources)
  {
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramResources, 2130840220);
    Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
    if (localBitmap != null) {
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, localBitmap.getWidth(), this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight());
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(paramResources, 2130840221);
    paramResources = this.jdField_b_of_type_AndroidGraphicsBitmap;
    if (paramResources != null) {
      this.jdField_b_of_type_AndroidGraphicsRect.set(0, 0, paramResources.getWidth(), this.jdField_b_of_type_AndroidGraphicsBitmap.getHeight());
    }
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (this.jdField_b_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_Float += 2.5F;
      paramCanvas.save();
      paramCanvas.rotate(this.jdField_a_of_type_Float, this.jdField_b_of_type_Int >> 1, this.jdField_a_of_type_Int >> 1);
      paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsRect, this.c, null);
      paramCanvas.restore();
      paramCanvas.rotate(-this.jdField_a_of_type_Float, this.jdField_b_of_type_Int >> 1, this.jdField_a_of_type_Int >> 1);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsRect, this.d, null);
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
    this.jdField_b_of_type_Int = paramRect.width();
    this.jdField_a_of_type_Int = paramRect.height();
    this.c.set(0, 0, this.jdField_b_of_type_Int, this.jdField_a_of_type_Int);
    paramRect = this.d;
    int i = this.jdField_b_of_type_Int;
    int j = this.jdField_a_of_type_Int;
    paramRect.set(i >> 2, j >> 2, i * 3 / 4, j * 3 / 4);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(@Nullable ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.VideoLoadingImage.DefaultLoadingDrawable
 * JD-Core Version:    0.7.0.1
 */