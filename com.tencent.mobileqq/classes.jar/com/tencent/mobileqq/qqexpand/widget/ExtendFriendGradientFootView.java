package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class ExtendFriendGradientFootView
  extends View
{
  LinearGradient jdField_a_of_type_AndroidGraphicsLinearGradient;
  private final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  
  public ExtendFriendGradientFootView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendGradientFootView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendGradientFootView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsLinearGradient = new LinearGradient(0.0F, 0.0F, 0.0F, getHeight(), 0, paramInt, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(this.jdField_a_of_type_AndroidGraphicsLinearGradient);
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendGradientFootView
 * JD-Core Version:    0.7.0.1
 */