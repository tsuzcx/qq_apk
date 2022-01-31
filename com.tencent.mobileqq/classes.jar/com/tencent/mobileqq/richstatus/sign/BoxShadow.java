package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.BlurMaskFilter.Blur;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class BoxShadow
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  int b;
  int c;
  private int d;
  private int e;
  
  public BoxShadow(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BoxShadow(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramContext);
    this.b = paramInt2;
    this.c = paramInt1;
    this.jdField_a_of_type_Int = paramInt3;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramInt1 = (int)(0.5F * paramInt1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setMaskFilter(new BlurMaskFilter(paramInt1, BlurMaskFilter.Blur.NORMAL));
    setLayerType(1, null);
  }
  
  public BoxShadow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BoxShadow(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRectF != null) {
      paramCanvas.drawRoundRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.b, this.b, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    super.dispatchDraw(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((this.jdField_a_of_type_AndroidGraphicsRectF == null) || (this.d != getMeasuredWidth()) || (this.e != getMeasuredHeight()))
    {
      paramInt1 = (int)(0.5F * this.c);
      this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(paramInt1, paramInt1, getMeasuredWidth() - paramInt1, getMeasuredHeight() - paramInt1 * 1.15F);
      this.d = getMeasuredWidth();
      this.e = getMeasuredHeight();
    }
  }
  
  public void setShadowColor(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BoxShadow
 * JD-Core Version:    0.7.0.1
 */