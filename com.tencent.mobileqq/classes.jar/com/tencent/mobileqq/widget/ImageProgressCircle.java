package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class ImageProgressCircle
  extends View
{
  boolean a = true;
  Bitmap b;
  Matrix c = new Matrix();
  Paint d = new Paint();
  boolean e = false;
  String f = "";
  boolean g = true;
  private int h;
  private int i;
  private int j;
  private int k;
  
  public ImageProgressCircle(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public ImageProgressCircle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    try
    {
      this.b = BitmapFactory.decodeResource(paramContext.getResources(), 2130848705);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
    int m = (int)(paramContext.getResources().getDisplayMetrics().density * 12.0F);
    this.d.setAntiAlias(true);
    this.d.setColor(-1);
    this.d.setTextSize(m);
    this.d.setTypeface(Typeface.DEFAULT_BOLD);
    this.g = true;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297641);
    m = this.j;
    this.h = (m / 2);
    this.i = (m / 2);
  }
  
  public String getProgressText()
  {
    return this.f;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if ((this.a) && (this.b != null))
    {
      paramCanvas.save();
      paramCanvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
      int m = this.b.getWidth() / 2;
      int n = this.b.getHeight() / 2;
      if (!this.e)
      {
        this.c.reset();
        this.c.postTranslate(this.h - m, this.i - n);
        this.e = true;
      }
      this.c.postRotate(5.0F, this.h, this.i);
      paramCanvas.drawBitmap(this.b, this.c, null);
      if (this.g)
      {
        String str;
        double d1;
        double d2;
        float f1;
        if (this.k >= 10)
        {
          str = this.f;
          d1 = this.h;
          d2 = m;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f1 = (float)(d1 - d2 * 0.66D);
          d1 = this.i;
          d2 = n;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramCanvas.drawText(str, f1, (float)(d1 + d2 * 0.25D), this.d);
        }
        else
        {
          str = this.f;
          d1 = this.h;
          d2 = m;
          Double.isNaN(d2);
          Double.isNaN(d1);
          f1 = (float)(d1 - d2 * 0.25D);
          d1 = this.i;
          d2 = n;
          Double.isNaN(d2);
          Double.isNaN(d1);
          paramCanvas.drawText(str, f1, (float)(d1 + d2 * 0.25D), this.d);
        }
      }
      paramCanvas.restore();
    }
    postInvalidate();
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int m;
    if (paramInt3 - paramInt1 == 0)
    {
      m = this.j;
      layout(paramInt1 - m / 2, paramInt2, paramInt3 + m / 2, paramInt4);
      return;
    }
    if (paramInt4 - paramInt2 == 0)
    {
      m = this.j;
      layout(paramInt1, paramInt2 - m / 2, paramInt3, paramInt4 + m / 2);
      return;
    }
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt >= 100) {
      this.a = false;
    }
    int m = paramInt * 100 / 85;
    paramInt = m;
    if (m > 99) {
      paramInt = 99;
    }
    this.k = paramInt;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.k);
    localStringBuilder.append("%");
    this.f = localStringBuilder.toString();
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ImageProgressCircle
 * JD-Core Version:    0.7.0.1
 */