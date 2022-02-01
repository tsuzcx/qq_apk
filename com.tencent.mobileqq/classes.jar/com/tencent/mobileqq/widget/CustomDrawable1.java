package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;

public class CustomDrawable1
  extends AnimationDrawable
{
  private int a;
  private int b;
  private int c;
  private int d;
  private Rect e;
  
  private float a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == paramInt1) {
      return 0.9F;
    }
    if (paramInt1 > 1) {
      return a(paramInt1 - 1, paramInt2) + 0.2F;
    }
    return 0.3F;
  }
  
  private void a(int paramInt, Canvas paramCanvas, Paint paramPaint)
  {
    paramPaint.setColor(16777215);
    paramPaint.setAlpha((int)(a(1, paramInt) * 255.0F));
    paramCanvas.drawRect(b(1, paramInt), paramPaint);
    paramPaint.setAlpha((int)(a(2, paramInt) * 255.0F));
    paramCanvas.drawRect(b(2, paramInt), paramPaint);
    paramPaint.setAlpha((int)(a(3, paramInt) * 255.0F));
    paramCanvas.drawRect(b(3, paramInt), paramPaint);
    paramPaint.setAlpha((int)(a(4, paramInt) * 255.0F));
    paramCanvas.drawRect(b(4, paramInt), paramPaint);
  }
  
  private Rect b(int paramInt1, int paramInt2)
  {
    int i;
    if (paramInt1 == paramInt2) {
      i = this.a;
    } else {
      i = this.c;
    }
    int j;
    if (paramInt1 == paramInt2) {
      j = this.b;
    } else {
      j = this.d;
    }
    int k = 0;
    if (paramInt1 > 1) {
      this.e.left = (b(paramInt1 - 1, paramInt2).right + 5);
    } else {
      this.e.left = 0;
    }
    Rect localRect = this.e;
    if (paramInt1 == paramInt2) {
      paramInt1 = k;
    } else {
      paramInt1 = (this.b - this.d) / 2;
    }
    localRect.top = paramInt1;
    localRect = this.e;
    localRect.right = (localRect.left + i);
    localRect = this.e;
    localRect.bottom = (localRect.top + j);
    return this.e;
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (getNumberOfFrames() == 0)
    {
      Paint localPaint = new Paint();
      int i = 1;
      while (i <= 4)
      {
        Bitmap localBitmap = Bitmap.createBitmap(getIntrinsicWidth(), getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        a(i, new Canvas(localBitmap), localPaint);
        paramCanvas.drawBitmap(localBitmap, 0.0F, 0.0F, localPaint);
        addFrame(new BitmapDrawable(localBitmap), 200);
        i += 1;
      }
    }
    super.draw(paramCanvas);
    start();
  }
  
  public int getIntrinsicHeight()
  {
    return this.b;
  }
  
  public int getIntrinsicWidth()
  {
    return this.a + this.c * 3 + 15;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomDrawable1
 * JD-Core Version:    0.7.0.1
 */