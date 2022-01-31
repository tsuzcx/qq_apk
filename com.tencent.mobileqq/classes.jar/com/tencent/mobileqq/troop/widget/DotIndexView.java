package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class DotIndexView
  extends LinearLayout
{
  protected int a;
  protected Context a;
  protected LinearLayout a;
  protected int b;
  protected int c = 8;
  
  public DotIndexView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 2130841482;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
  }
  
  public DotIndexView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 2130841482;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(paramContext);
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_AndroidWidgetLinearLayout.getContext();
  }
  
  public void setDotDrawable(int paramInt)
  {
    if (this.jdField_a_of_type_Int != paramInt)
    {
      this.jdField_a_of_type_Int = paramInt;
      if ((this.jdField_a_of_type_AndroidWidgetLinearLayout != null) && (this.b != 0))
      {
        Drawable localDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(this.jdField_a_of_type_Int);
        paramInt = 0;
        while (paramInt < this.b)
        {
          View localView = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
          if ((localView != null) && ((localView instanceof ImageView))) {
            ((ImageView)localView).setImageDrawable(localDrawable);
          }
          paramInt += 1;
        }
      }
    }
  }
  
  public void setDotSelected(int paramInt, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout == null) {}
    do
    {
      return;
      if (paramBoolean)
      {
        int i = 0;
        while (i < this.b)
        {
          if (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i) != null) {
            this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(i).setSelected(false);
          }
          i += 1;
        }
      }
    } while (this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt) == null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt).setSelected(paramBoolean);
  }
  
  public void setMargin(int paramInt)
  {
    this.c = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.DotIndexView
 * JD-Core Version:    0.7.0.1
 */