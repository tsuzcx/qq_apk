package com.tencent.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.tencent.qphone.base.util.QLog;

public class BottomDrawable
  extends Drawable
{
  Rect a = new Rect();
  Rect b = new Rect();
  private Bitmap c;
  private Paint d = new Paint();
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public BottomDrawable(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    this.e = paramBitmap.getWidth();
    this.f = paramBitmap.getHeight();
    this.c = paramBitmap;
    this.g = paramInt1;
    this.h = paramInt2;
    if (this.g <= 0) {
      this.g = 1080;
    }
    if (this.h <= 0) {
      this.h = 1920;
    }
    this.j = (this.h * this.e / this.g);
    int k = this.f;
    int m = this.j;
    if (k > m) {
      this.i = (k - m);
    }
    if (QLog.isColorLevel())
    {
      paramBitmap = new StringBuilder();
      paramBitmap.append("displayWidth");
      paramBitmap.append(paramInt1);
      paramBitmap.append(" displayHeight ");
      paramBitmap.append(paramInt2);
      QLog.i("UserGuideWeiShiActivity", 2, paramBitmap.toString());
      paramBitmap = new StringBuilder();
      paramBitmap.append("mWidth");
      paramBitmap.append(this.e);
      paramBitmap.append(" mHeight ");
      paramBitmap.append(this.f);
      QLog.i("UserGuideWeiShiActivity", 2, paramBitmap.toString());
      paramBitmap = new StringBuilder();
      paramBitmap.append("mNewBitmMapHeight");
      paramBitmap.append(this.j);
      paramBitmap.append(" mTop ");
      paramBitmap.append(this.i);
      QLog.i("UserGuideWeiShiActivity", 2, paramBitmap.toString());
    }
  }
  
  public void draw(Canvas paramCanvas)
  {
    this.a.set(0, this.i, this.e, this.f);
    this.b.set(0, 0, this.e, this.j);
    paramCanvas.drawBitmap(this.c, this.a, this.b, this.d);
  }
  
  public int getIntrinsicHeight()
  {
    return this.j;
  }
  
  public int getIntrinsicWidth()
  {
    return this.e;
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    if (paramInt != this.d.getAlpha())
    {
      this.d.setAlpha(paramInt);
      super.invalidateSelf();
    }
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.d.setColorFilter(paramColorFilter);
    super.invalidateSelf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.BottomDrawable
 * JD-Core Version:    0.7.0.1
 */