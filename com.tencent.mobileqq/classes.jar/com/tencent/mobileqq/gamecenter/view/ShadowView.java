package com.tencent.mobileqq.gamecenter.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ShadowView
  extends View
{
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  
  public ShadowView(Context paramContext)
  {
    super(paramContext);
  }
  
  public ShadowView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ShadowView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    setLayerType(1, null);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(getPaddingLeft(), getPaddingTop(), getWidth() - getPaddingRight(), getHeight() - getPaddingBottom(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setOriginColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setShadowProperties(float paramFloat1, float paramFloat2, float paramFloat3, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setShadowLayer(paramFloat1, paramFloat2, paramFloat3, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.ShadowView
 * JD-Core Version:    0.7.0.1
 */