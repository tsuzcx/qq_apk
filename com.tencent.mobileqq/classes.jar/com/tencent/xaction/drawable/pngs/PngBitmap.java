package com.tencent.xaction.drawable.pngs;

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
      if ((paramBitmap != null) && (NinePatch.isNinePatchChunk(paramBitmap)))
      {
        this.jdField_a_of_type_AndroidGraphicsNinePatch = new NinePatch(this.jdField_a_of_type_AndroidGraphicsBitmap, paramBitmap, null);
        return;
      }
      this.jdField_a_of_type_AndroidGraphicsNinePatch = null;
    }
  }
  
  public void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    Object localObject = this.jdField_a_of_type_AndroidGraphicsNinePatch;
    if (localObject != null)
    {
      if (paramPaint != null) {
        ((NinePatch)localObject).draw(paramCanvas, paramRect2, paramPaint);
      }
    }
    else
    {
      localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
      if ((localObject != null) && (!((Bitmap)localObject).isRecycled()) && (paramPaint != null)) {
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, paramRect1, paramRect2, paramPaint);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.drawable.pngs.PngBitmap
 * JD-Core Version:    0.7.0.1
 */