package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class NumberCheckBox
  extends CheckBox
{
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private boolean jdField_a_of_type_Boolean;
  
  public NumberCheckBox(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramContext.getResources().getColor(2131167140));
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean) {
      paramCanvas.drawCircle(getWidth() / 2.0F, getHeight() / 2.0F, Math.min(getWidth() / 2.0F, getHeight() / 2.0F), this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    String str2 = "";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (this.jdField_a_of_type_Int >= 0) {
        str1 = String.valueOf(this.jdField_a_of_type_Int);
      }
    }
    if (!str1.equals(getText())) {
      setText(str1);
    }
  }
  
  public void setCheckedNumber(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      setText(String.valueOf(paramInt));
    }
    setChecked(true);
  }
  
  public void setForegroundColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setNeedForeground(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NumberCheckBox
 * JD-Core Version:    0.7.0.1
 */