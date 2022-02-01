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
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  
  public KSongVolumeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bX);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int i = R.styleable.n;
    boolean bool = false;
    if (paramTypedArray.getInt(i, 0) == 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = paramTypedArray.getInt(R.styleable.o, 5);
    this.b = ((int)paramTypedArray.getDimension(R.styleable.q, 8.0F));
    this.c = paramTypedArray.getColor(R.styleable.m, -16776961);
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
    this.g = ((int)paramTypedArray.getDimension(R.styleable.p, this.b));
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = this.d;
    arrayOfInt[i] = paramInt;
    this.d = (i + 1);
    if (this.d >= this.jdField_a_of_type_Int) {
      this.d = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.d - 1;
    int j = 0;
    for (;;)
    {
      int m = this.jdField_a_of_type_Int;
      if (j >= m) {
        break;
      }
      int k = i;
      if (i < 0) {
        k = m - 1;
      }
      float f2 = this.jdField_a_of_type_ArrayOfInt[k];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f2 = f2 / 2.0F * this.g + this.f / 2;
      if (this.jdField_a_of_type_Boolean)
      {
        f1 = j * 2.0F * this.b;
      }
      else
      {
        f1 = this.jdField_a_of_type_Int - 1 - j;
        i = this.b;
        f1 = f1 * 2.0F * i + i;
      }
      i = this.e;
      paramCanvas.drawRect(f1, i - f2, f1 + this.b, i + f2, this.jdField_a_of_type_AndroidGraphicsPaint);
      i = k - 1;
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.b;
    int i = this.g;
    int j = this.f;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), i * 8 + j + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = (paramInt2 / 2);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColor(this.c);
    }
  }
  
  public void setCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
    requestLayout();
  }
  
  public void setSquareWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.KSongVolumeView
 * JD-Core Version:    0.7.0.1
 */