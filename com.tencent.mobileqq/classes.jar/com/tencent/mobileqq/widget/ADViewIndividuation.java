package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class ADViewIndividuation
  extends ADView
{
  private int a;
  
  public ADViewIndividuation(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = 0;
    this.i = 8;
    this.j = 18;
    this.g = 2130847260;
    this.h = this.g;
  }
  
  public ADViewIndividuation(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Int = 0;
    this.i = 4;
    this.j = 8;
    this.g = 2130847260;
    this.h = this.g;
  }
  
  public void a(View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    setNavVisible(this.jdField_a_of_type_Int, false);
  }
  
  protected void a(LinearLayout paramLinearLayout)
  {
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.addRule(8, 100000);
    localLayoutParams.addRule(7, 100000);
    localLayoutParams.setMargins(0, 0, 0, (int)(this.jdField_a_of_type_Float * 6.0F));
    paramLinearLayout.setGravity(16);
    paramLinearLayout.setPadding((int)(this.jdField_a_of_type_Float * 4.0F), 0, (int)(this.jdField_a_of_type_Float * 2.0F), 0);
    paramLinearLayout.setLayoutParams(localLayoutParams);
  }
  
  public void setNavVisible(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return;
    }
    Object localObject = (ViewGroup)this.b.getChildAt(0);
    if (localObject != null)
    {
      localObject = (LinearLayout)((ViewGroup)localObject).getChildAt(1);
      if (localObject != null)
      {
        if (paramInt > 0) {
          paramInt = 0;
        } else {
          paramInt = 8;
        }
        ((LinearLayout)localObject).setVisibility(paramInt);
        if (paramBoolean) {
          this.jdField_a_of_type_Int = 0;
        }
        return;
      }
    }
    if (paramBoolean) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ADViewIndividuation
 * JD-Core Version:    0.7.0.1
 */