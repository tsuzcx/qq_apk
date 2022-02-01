package com.tencent.tkd.comment.panel.base.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.tkd.comment.panel.base.R.color;
import com.tencent.tkd.comment.panel.base.R.styleable;

public class PageIndicator
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public PageIndicator(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  @SuppressLint({"CustomViewStyleable"})
  public PageIndicator(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    Context localContext1 = null;
    Context localContext2 = null;
    try
    {
      try
      {
        paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.jdField_a_of_type_ArrayOfInt);
        localContext2 = paramContext;
        localContext1 = paramContext;
        int i = paramContext.getIndexCount();
        paramInt = 0;
        while (paramInt < i)
        {
          localContext2 = paramContext;
          localContext1 = paramContext;
          a(paramContext, paramInt);
          paramInt += 1;
        }
        if (paramContext == null) {
          break label93;
        }
      }
      finally
      {
        if (localContext2 != null) {
          localContext2.recycle();
        }
      }
    }
    catch (Throwable paramContext)
    {
      label81:
      break label81;
    }
    if (localContext1 != null)
    {
      paramContext = localContext1;
      paramContext.recycle();
    }
    label93:
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.f = 0;
    this.jdField_a_of_type_Float = 1.0F;
  }
  
  private void a(TypedArray paramTypedArray, int paramInt)
  {
    paramInt = paramTypedArray.getIndex(paramInt);
    if (paramInt == R.styleable.b)
    {
      this.c = paramTypedArray.getInt(paramInt, 0);
      return;
    }
    if (paramInt == R.styleable.jdField_a_of_type_Int)
    {
      this.jdField_a_of_type_Int = paramTypedArray.getColor(paramInt, getResources().getColor(R.color.jdField_a_of_type_Int));
      return;
    }
    if (paramInt == R.styleable.e)
    {
      this.b = paramTypedArray.getColor(paramInt, getResources().getColor(R.color.b));
      return;
    }
    if (paramInt == R.styleable.c)
    {
      this.e = paramTypedArray.getDimensionPixelSize(paramInt, (int)TypedValue.applyDimension(1, 4.0F, getResources().getDisplayMetrics()));
      return;
    }
    if (paramInt == R.styleable.d) {
      this.d = paramTypedArray.getDimensionPixelOffset(paramInt, (int)TypedValue.applyDimension(1, 24.0F, getResources().getDisplayMetrics()));
    }
  }
  
  private void a(Canvas paramCanvas, int paramInt1, int paramInt2, float paramFloat)
  {
    int i = this.e;
    double d1 = i;
    Double.isNaN(d1);
    float f1 = (float)(d1 / 2.0D);
    float f2 = paramInt1 * (this.d + i);
    float f3 = getHeight() / 2.0F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)Math.ceil(paramFloat * 255.0F));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setDither(true);
    paramCanvas.drawCircle(f2 + f1, f3, f1, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(int paramInt, float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.f = paramInt;
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.c <= 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    int i = 0;
    while (i < this.c)
    {
      a(paramCanvas, i, this.b, 1.0F);
      i += 1;
    }
    a(paramCanvas, this.f, this.jdField_a_of_type_Int, 1.0F - this.jdField_a_of_type_Float);
    a(paramCanvas, (this.f + 1) % this.c, this.jdField_a_of_type_Int, this.jdField_a_of_type_Float);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    int j = View.MeasureSpec.getMode(paramInt1);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    int i = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (j != 1073741824)
    {
      paramInt1 = getPaddingLeft();
      j = getPaddingRight();
      int k = this.c;
      paramInt1 = paramInt1 + j + this.e * k + (k - 1) * this.d;
    }
    if (i != 1073741824) {
      paramInt2 = getPaddingTop() + getPaddingBottom() + this.e;
    }
    setMeasuredDimension(paramInt1, paramInt2);
  }
  
  public void setPageCount(int paramInt)
  {
    this.c = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.comment.panel.base.view.PageIndicator
 * JD-Core Version:    0.7.0.1
 */