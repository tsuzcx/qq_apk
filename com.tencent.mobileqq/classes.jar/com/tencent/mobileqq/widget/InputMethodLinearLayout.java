package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.LinearLayout;
import bips;

public class InputMethodLinearLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  protected bips a;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c;
  private int d;
  
  public InputMethodLinearLayout(Context paramContext)
  {
    super(paramContext);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.c = paramContext.getWidth();
    this.d = paramContext.getHeight();
  }
  
  public InputMethodLinearLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = ((Activity)paramContext).getWindowManager().getDefaultDisplay();
    this.c = paramContext.getWidth();
    this.d = paramContext.getHeight();
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    super.onMeasure(paramInt1, paramInt2);
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((this.jdField_a_of_type_Bips != null) && (paramInt1 == paramInt3) && (paramInt3 != 0) && (paramInt4 != 0)) {
      if ((paramInt2 >= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= this.d * 1 / 4)) {
        break label90;
      }
    }
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_a_of_type_Bips.a(this.jdField_a_of_type_Boolean);
      measure(this.jdField_a_of_type_Int - paramInt1 + getWidth(), this.b - paramInt2 + getHeight());
      label90:
      do
      {
        return;
      } while ((paramInt2 <= paramInt4) || (Math.abs(paramInt2 - paramInt4) <= this.d * 1 / 4));
    }
  }
  
  public void setOnSizeChangedListenner(bips parambips)
  {
    this.jdField_a_of_type_Bips = parambips;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.InputMethodLinearLayout
 * JD-Core Version:    0.7.0.1
 */