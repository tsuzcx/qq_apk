package com.tencent.mobileqq.vas.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;

public class VipPngBitmap
  implements INinePathBitmap
{
  public Bitmap a;
  public NinePatch b;
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (paramBitmap != null)
    {
      this.a = paramBitmap;
      paramBitmap = this.a.getNinePatchChunk();
      if ((paramBitmap != null) && (NinePatch.isNinePatchChunk(paramBitmap)))
      {
        this.b = new NinePatch(this.a, paramBitmap, null);
        return;
      }
      this.b = null;
    }
  }
  
  public void a(Canvas paramCanvas, Rect paramRect1, Rect paramRect2, Paint paramPaint)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      if (paramPaint != null) {
        ((NinePatch)localObject).draw(paramCanvas, paramRect2, paramPaint);
      }
    }
    else
    {
      localObject = this.a;
      if ((localObject != null) && (paramPaint != null)) {
        paramCanvas.drawBitmap((Bitmap)localObject, paramRect1, paramRect2, paramPaint);
      }
    }
  }
  
  public void b()
  {
    Bitmap localBitmap = this.a;
    if (localBitmap != null)
    {
      localBitmap.recycle();
      this.a = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ui.VipPngBitmap
 * JD-Core Version:    0.7.0.1
 */