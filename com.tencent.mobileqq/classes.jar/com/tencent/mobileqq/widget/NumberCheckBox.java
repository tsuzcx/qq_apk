package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class NumberCheckBox
  extends CheckBox
{
  private int a = -1;
  
  public NumberCheckBox(Context paramContext)
  {
    super(paramContext);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NumberCheckBox(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
  }
  
  public void setChecked(boolean paramBoolean)
  {
    super.setChecked(paramBoolean);
    String str2 = "";
    String str1 = str2;
    if (paramBoolean)
    {
      str1 = str2;
      if (this.a >= 0) {
        str1 = String.valueOf(this.a);
      }
    }
    if (!str1.equals(getText())) {
      setText(str1);
    }
  }
  
  public void setCheckedNumber(int paramInt)
  {
    if (this.a != paramInt)
    {
      this.a = paramInt;
      setText(String.valueOf(paramInt));
    }
    setChecked(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.NumberCheckBox
 * JD-Core Version:    0.7.0.1
 */