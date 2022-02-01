package com.tencent.mobileqq.widget;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

public class PhotoProgressDrawable
  extends Drawable
{
  Bitmap a;
  Matrix b = new Matrix();
  Paint c = new Paint();
  boolean d = false;
  String e = "0%";
  boolean f = true;
  private int g;
  private int h;
  private int i;
  
  public PhotoProgressDrawable(Bitmap paramBitmap, int paramInt)
  {
    this(paramBitmap, paramInt, true);
  }
  
  public PhotoProgressDrawable(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    this.a = paramBitmap;
    this.c.setAntiAlias(true);
    this.c.setColor(-1);
    this.c.setTextSize(paramInt);
    this.c.setTypeface(Typeface.DEFAULT_BOLD);
    this.f = paramBoolean;
  }
  
  public void a()
  {
    this.f = false;
  }
  
  public void draw(Canvas paramCanvas)
  {
    paramCanvas.save();
    paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    int j = ((Bitmap)localObject).getWidth() / 2;
    int k = this.a.getHeight() / 2;
    if (!this.d)
    {
      this.b.reset();
      this.b.postTranslate(this.g - j, this.h - k);
      this.d = true;
    }
    this.b.postRotate(5.0F, this.g, this.h);
    paramCanvas.drawBitmap(this.a, this.b, null);
    if (this.f)
    {
      double d1;
      double d2;
      float f1;
      if (this.i >= 10)
      {
        localObject = this.e;
        d1 = this.g;
        d2 = j;
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 - d2 * 0.6D);
        d1 = this.h;
        d2 = k;
        Double.isNaN(d2);
        Double.isNaN(d1);
        paramCanvas.drawText((String)localObject, f1, (float)(d1 + d2 * 0.25D), this.c);
      }
      else
      {
        localObject = this.e;
        d1 = this.g;
        d2 = j;
        Double.isNaN(d2);
        Double.isNaN(d1);
        f1 = (float)(d1 - d2 * 0.375D);
        d1 = this.h;
        d2 = k;
        Double.isNaN(d2);
        Double.isNaN(d1);
        paramCanvas.drawText((String)localObject, f1, (float)(d1 + d2 * 0.25D), this.c);
      }
    }
    paramCanvas.restore();
    invalidateSelf();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  protected boolean onLevelChange(int paramInt)
  {
    int k = paramInt / 85;
    int j = k;
    if (k > 99) {
      j = 99;
    }
    this.i = j;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.i);
    localStringBuilder.append("%");
    this.e = localStringBuilder.toString();
    return super.onLevelChange(paramInt);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setBounds(Rect paramRect)
  {
    this.g = paramRect.centerX();
    this.h = paramRect.centerY();
    this.d = false;
    super.setBounds(paramRect);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.PhotoProgressDrawable
 * JD-Core Version:    0.7.0.1
 */