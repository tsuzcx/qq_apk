package com.tencent.mobileqq.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.TextPaint;

public class PhoneContactFaceDrawable
  extends Drawable
{
  private Bitmap a;
  private TextPaint b = new TextPaint();
  private Paint c = new Paint(7);
  private int d;
  private Context e;
  private String f;
  
  public PhoneContactFaceDrawable(Context paramContext, String paramString)
  {
    this.e = paramContext;
    this.f = paramString;
    this.a = BitmapManager.b(this.e.getResources(), 2130843087);
    this.b.setAntiAlias(true);
    this.b.setColor(-1);
    this.d = Math.min(this.a.getWidth(), this.a.getHeight());
  }
  
  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    float f1 = localRect.width();
    int i = this.d;
    f1 /= i;
    float f2 = i / 2;
    this.b.setTextSize(f2 * f1);
    Paint.FontMetrics localFontMetrics = this.b.getFontMetrics();
    paramCanvas.drawBitmap(this.a, 0.0F, 0.0F, this.c);
    String str = this.f;
    if (str != null)
    {
      if (str == null) {
        i = 0;
      } else {
        i = (int)Layout.getDesiredWidth(str, this.b);
      }
      f1 = localFontMetrics.descent;
      f1 = localFontMetrics.ascent;
      int j = localRect.left;
      i = (localRect.width() - i) / 2;
      int k = (int)(localRect.top + localRect.height() / 2.0F - (localFontMetrics.bottom - localFontMetrics.top) / 2.0F - localFontMetrics.top);
      paramCanvas.drawText(this.f, j + i, k, this.b);
    }
  }
  
  public int getIntrinsicHeight()
  {
    return this.a.getHeight();
  }
  
  public int getIntrinsicWidth()
  {
    return this.a.getWidth();
  }
  
  public int getOpacity()
  {
    return -3;
  }
  
  public void setAlpha(int paramInt)
  {
    this.c.setAlpha(paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.c.setColorFilter(paramColorFilter);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.PhoneContactFaceDrawable
 * JD-Core Version:    0.7.0.1
 */