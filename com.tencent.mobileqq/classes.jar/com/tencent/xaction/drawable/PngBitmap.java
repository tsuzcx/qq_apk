package com.tencent.xaction.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;

public class PngBitmap
{
  public Bitmap a;
  public NinePatch a;
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
      paramBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap.getNinePatchChunk();
      if ((paramBitmap != null) && (NinePatch.isNinePatchChunk(paramBitmap))) {
        this.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch(this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, null);
      }
    }
    else
    {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsNinePatch = null;
  }
  
  public void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    if (this.jdField_a_of_type_AndroidGraphicsNinePatch != null) {
      if (paramPaint != null) {
        this.jdField_a_of_type_AndroidGraphicsNinePatch.draw(paramCanvas, paramRect2, paramPaint);
      }
    }
    while ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) || (paramPaint == null)) {
      return;
    }
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramRect1, paramRect2, paramPaint);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.drawable.PngBitmap
 * JD-Core Version:    0.7.0.1
 */