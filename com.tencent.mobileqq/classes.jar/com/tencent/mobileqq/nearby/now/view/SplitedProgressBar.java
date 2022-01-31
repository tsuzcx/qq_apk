package com.tencent.mobileqq.nearby.now.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;

public class SplitedProgressBar
  extends View
{
  public int a;
  public Paint a;
  public int b = 1;
  public int c;
  public int d;
  public int e = 872415231;
  public int f = 2147483647;
  public int g = 3;
  public int h = 4;
  public int i = 0;
  public int j = 1;
  
  public SplitedProgressBar(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public SplitedProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_Int = 50;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = super.getWidth();
    if (this.b == 0) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
    float f1 = (k - (this.j - this.i - 1) * this.h) / (this.j - this.i);
    k = this.i;
    label69:
    int m;
    int n;
    if (k < this.j)
    {
      m = (int)((k - this.i) * (this.h + f1));
      n = (int)((k - this.i) * (this.h + f1) + f1);
      if (k >= this.c) {
        break label213;
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
      paramCanvas.drawLine(m + 1, 1.0F, n - 1, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      paramCanvas.drawPoint(m, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      paramCanvas.drawPoint(n - 1, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      k += 1;
      break label69;
      break;
      label213:
      if (k == this.c)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
        float f2 = m + 1;
        float f3 = m;
        paramCanvas.drawLine(f2, 1.0F, this.d * f1 / 100.0F + f3, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(m + this.d * f1 / 100.0F, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawPoint(m, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
        f2 = m;
        paramCanvas.drawLine(this.d * f1 / 100.0F + f2, 1.0F, n - 1, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(n - 1, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      else
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.g);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
        paramCanvas.drawLine(m + 1, 1.0F, n - 1, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        paramCanvas.drawPoint(m, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
        paramCanvas.drawPoint(n - 1, 1.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  public void setProgress(int paramInt1, int paramInt2)
  {
    if (this.b <= 0) {}
    while ((paramInt1 < 0) || (paramInt1 >= this.b) || (paramInt2 < 0) || (paramInt2 > 100)) {
      return;
    }
    this.c = paramInt1;
    this.d = paramInt2;
    if (this.c < this.jdField_a_of_type_Int)
    {
      this.i = 0;
      if (this.b < this.jdField_a_of_type_Int) {}
      for (paramInt1 = this.b;; paramInt1 = this.jdField_a_of_type_Int)
      {
        this.j = paramInt1;
        if (Looper.myLooper() != Looper.getMainLooper()) {
          break;
        }
        super.invalidate();
        return;
      }
    }
    for (this.i = this.jdField_a_of_type_Int; this.i + this.jdField_a_of_type_Int <= this.c; this.i += this.jdField_a_of_type_Int) {}
    if (this.b < this.i + this.jdField_a_of_type_Int) {}
    for (paramInt1 = this.b;; paramInt1 = this.i + this.jdField_a_of_type_Int)
    {
      this.j = paramInt1;
      break;
    }
    super.postInvalidate();
  }
  
  public void setShowMaxCount(int paramInt)
  {
    if (paramInt < 1) {
      throw new IllegalArgumentException("setShowMaxCount Exception, count is < 1, count = " + paramInt);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
  
  public void setTotalCount(int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("setTotalCount Exception, count is < 0, count = " + paramInt);
    }
    this.b = paramInt;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.SplitedProgressBar
 * JD-Core Version:    0.7.0.1
 */