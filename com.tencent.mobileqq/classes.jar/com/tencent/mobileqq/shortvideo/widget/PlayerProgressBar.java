package com.tencent.mobileqq.shortvideo.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public class PlayerProgressBar
  extends View
{
  public int a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  public int b = 1;
  public int c = 1;
  private int d = -14342358;
  private int e = -15550475;
  private int f = -10066330;
  private int g;
  
  public PlayerProgressBar(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 1;
  }
  
  public PlayerProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 1;
  }
  
  private int a(int paramInt)
  {
    if (this.g == this.c) {
      return paramInt;
    }
    int i = this.g * paramInt / this.c;
    paramInt = i;
    if (i <= 0) {
      paramInt = 1;
    }
    return paramInt;
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == this.jdField_a_of_type_Int) {
      return paramInt2;
    }
    paramInt2 = paramInt2 * paramInt1 / this.jdField_a_of_type_Int;
    paramInt1 = paramInt2;
    if (paramInt2 <= 0) {
      paramInt1 = 1;
    }
    return paramInt1;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (super.isInEditMode()) {}
    int j;
    int i;
    do
    {
      return;
      if (this.b > this.jdField_a_of_type_Int) {
        this.b = this.jdField_a_of_type_Int;
      }
      j = super.getWidth();
      int k = super.getHeight();
      i = a(this.b, j);
      this.jdField_a_of_type_AndroidGraphicsRect.top = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = k;
      this.jdField_a_of_type_AndroidGraphicsRect.left = i;
      this.jdField_a_of_type_AndroidGraphicsRect.right = j;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
      j = a(i);
      this.jdField_a_of_type_AndroidGraphicsRect.left = 0;
      this.jdField_a_of_type_AndroidGraphicsRect.right = j;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    } while (j >= i);
    this.jdField_a_of_type_AndroidGraphicsRect.left = j;
    this.jdField_a_of_type_AndroidGraphicsRect.right = i;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.f);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setCurrentProgress(int paramInt, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (this.g = this.c;; this.g = paramInt)
    {
      super.postInvalidate();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.widget.PlayerProgressBar
 * JD-Core Version:    0.7.0.1
 */