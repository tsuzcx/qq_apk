package com.tencent.mobileqq.richstatus.sign;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class BoxShadowLayout
  extends FrameLayout
{
  int jdField_a_of_type_Int;
  View jdField_a_of_type_AndroidViewView;
  BoxShadow jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadow;
  int b;
  
  public BoxShadowLayout(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BoxShadowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BoxShadowLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt)
  {
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadow.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt - (int)(this.b * 0.5F));
    localLayoutParams.rightMargin = (paramInt - (int)(this.b * 0.5F));
    localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.leftMargin = paramInt;
    localLayoutParams.rightMargin = paramInt;
    localLayoutParams.bottomMargin = ((int)(this.b * 0.75F));
    this.jdField_a_of_type_AndroidViewView.setMinimumHeight(0);
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
  }
  
  public void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadow = new BoxShadow(getContext(), paramInt1, paramInt2, paramInt3);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.b = paramInt1;
    paramInt2 = (int)(0.5F * paramInt1);
    paramView = new FrameLayout.LayoutParams(-1, -1);
    addView(this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadow, paramView);
    paramView = new FrameLayout.LayoutParams(-1, -2);
    paramView.leftMargin = paramInt2;
    paramView.topMargin = 0;
    paramView.rightMargin = paramInt2;
    paramView.bottomMargin = paramInt1;
    addView(this.jdField_a_of_type_AndroidViewView, paramView);
  }
  
  public void setScrolling(boolean paramBoolean) {}
  
  public void setShadowColor(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadow.setShadowColor(paramInt);
  }
  
  public void setYOffset(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqRichstatusSignBoxShadow.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
    localLayoutParams = (FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewView.getLayoutParams();
    localLayoutParams.topMargin += paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.sign.BoxShadowLayout
 * JD-Core Version:    0.7.0.1
 */