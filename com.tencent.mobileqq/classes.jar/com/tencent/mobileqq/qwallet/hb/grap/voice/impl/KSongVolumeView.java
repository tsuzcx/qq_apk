package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqpay.ui.R.styleable;

public class KSongVolumeView
  extends View
{
  public int[] a;
  private boolean b = true;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private Paint g;
  private int h = 0;
  private int i = 0;
  private int j = 0;
  
  public KSongVolumeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.cq);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int k = R.styleable.cs;
    boolean bool = false;
    if (paramTypedArray.getInt(k, 0) == 0) {
      bool = true;
    }
    this.b = bool;
    this.c = paramTypedArray.getInt(R.styleable.ct, 5);
    this.d = ((int)paramTypedArray.getDimension(R.styleable.cv, 8.0F));
    this.e = paramTypedArray.getColor(R.styleable.cr, -16776961);
    this.a = new int[this.c];
    this.j = ((int)paramTypedArray.getDimension(R.styleable.cu, this.d));
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = this.a;
    int k = this.f;
    arrayOfInt[k] = paramInt;
    this.f = (k + 1);
    if (this.f >= this.c) {
      this.f = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = this.f - 1;
    int m = 0;
    for (;;)
    {
      int i1 = this.c;
      if (m >= i1) {
        break;
      }
      int n = k;
      if (k < 0) {
        n = i1 - 1;
      }
      float f2 = this.a[n];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f2 = f2 / 2.0F * this.j + this.i / 2;
      if (this.b)
      {
        f1 = m * 2.0F * this.d;
      }
      else
      {
        f1 = this.c - 1 - m;
        k = this.d;
        f1 = f1 * 2.0F * k + k;
      }
      k = this.h;
      paramCanvas.drawRect(f1, k - f2, f1 + this.d, k + f2, this.g);
      k = n - 1;
      m += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.c;
    paramInt2 = this.d;
    int k = this.j;
    int m = this.i;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), k * 8 + m + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.h = (paramInt2 / 2);
    if (this.g == null)
    {
      this.g = new Paint();
      this.g.setStyle(Paint.Style.FILL);
      this.g.setColor(this.e);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.e = paramInt;
    Paint localPaint = this.g;
    if (localPaint != null) {
      localPaint.setColor(this.e);
    }
  }
  
  public void setCount(int paramInt)
  {
    this.c = paramInt;
    this.a = new int[this.c];
    requestLayout();
  }
  
  public void setSquareWidth(int paramInt)
  {
    this.d = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongVolumeView
 * JD-Core Version:    0.7.0.1
 */