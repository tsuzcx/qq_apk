package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;

public class ProgressViewRed
  extends TimeDownTextView
{
  private Drawable c;
  private Drawable d;
  private int e;
  private long f = 10000L;
  private long g = 0L;
  private int[] h = { 2130846840, 2130846841, 2130846842, 2130846843, 2130846844, 2130846845, 2130846846, 2130846847, 2130846848, 2130846849, 2130846850, 2130846851, 2130846852, 2130846853, 2130846854, 2130846855, 2130846856, 2130846857, 2130846858, 2130846859 };
  private Bitmap[] i = null;
  private Rect j;
  private RectF k;
  private int l = 0;
  
  public ProgressViewRed(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public ProgressViewRed(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.a.setColor(-1);
    this.c = new ColorDrawable(Color.parseColor("#FF9F89"));
    this.d = new ColorDrawable(Color.parseColor("#F34112"));
    try
    {
      this.i = new Bitmap[this.h.length];
      int m = 0;
      while (m < this.h.length)
      {
        this.i[m] = BitmapFactory.decodeResource(getResources(), this.h[m]);
        m += 1;
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      this.j = new Rect();
      this.k = new RectF();
    }
  }
  
  public void a(long paramLong1, long paramLong2, CharSequence paramCharSequence)
  {
    this.f = paramLong2;
    this.g = (paramLong2 - paramLong1);
    setText(paramCharSequence);
  }
  
  public void draw(Canvas paramCanvas)
  {
    if (this.e == 0) {
      return;
    }
    int i1 = getWidth();
    int i2 = getHeight();
    long l1 = i1;
    long l2 = this.g;
    int i3 = (int)(l1 * l2 / this.f);
    if (l2 > 0L)
    {
      this.c.setBounds(0, 0, i3, i2);
      this.c.draw(paramCanvas);
    }
    if (this.g < this.f)
    {
      this.d.setBounds(i3, 0, i1, i2);
      this.d.draw(paramCanvas);
      int n = this.l;
      Object localObject = this.h;
      int m = n;
      if (n >= localObject.length) {
        m = n % localObject.length;
      }
      n = this.i[m].getWidth();
      int i4 = this.i[m].getHeight();
      this.j.set(0, 0, n, i4);
      int i5 = i1 - i3;
      if (n <= i5)
      {
        localObject = this.i[m];
        this.k.set(i3, 0.0F, i3 + n, i2);
      }
      else if (i5 > 0)
      {
        localObject = Bitmap.createBitmap(this.i[m], 0, 0, i5, i4, null, false);
        this.k.set(i3, 0.0F, i1, i2);
      }
      else
      {
        localObject = null;
      }
      if (localObject != null) {
        paramCanvas.drawBitmap((Bitmap)localObject, null, this.k, null);
      }
      this.l += 1;
    }
    super.draw(paramCanvas);
  }
  
  public int getProgressViewAlpha()
  {
    return this.e;
  }
  
  public void setAlpha(int paramInt)
  {
    this.d.setAlpha(paramInt);
    this.c.setAlpha(paramInt);
    setTextColor(Color.argb(paramInt, 255, 255, 255));
    this.e = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.portal.ProgressViewRed
 * JD-Core Version:    0.7.0.1
 */