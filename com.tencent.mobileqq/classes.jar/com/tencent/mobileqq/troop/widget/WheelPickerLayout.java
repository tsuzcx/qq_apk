package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import bcpg;
import bcph;
import bcpi;
import bcpj;
import bcpk;
import bcpl;
import bcpm;
import bhqr;
import bhxz;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;

public class WheelPickerLayout
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private bcpk jdField_a_of_type_Bcpk;
  private bcpl jdField_a_of_type_Bcpl;
  private bcpm jdField_a_of_type_Bcpm;
  private bhqr jdField_a_of_type_Bhqr = new bcpg(this);
  private bhxz jdField_a_of_type_Bhxz = new bcph(this);
  private bcpj[] jdField_a_of_type_ArrayOfBcpj;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  
  public WheelPickerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Bcpl.b);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Bcpl.c);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_Bcpl.e);
    ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_Bcpl.f);
  }
  
  private void a(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      StringBuilder localStringBuilder = new StringBuilder(((WheelTextView)paramView).getText());
      ((WheelTextView)paramView).setContentDescription(localStringBuilder);
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    bcpj localbcpj = new bcpj(this, paramInt, this.jdField_a_of_type_Bcpl.jdField_a_of_type_Int);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfBcpj[paramInt] = localbcpj;
    paramWheelView.setAdapter(localbcpj);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_Bhqr);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_Bhxz);
    paramWheelView.setOnEndMovementListener(new bcpi(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfBcpj.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfBcpj[paramInt].notifyDataSetChanged();
  }
  
  public void a(bcpk parambcpk, bcpl parambcpl)
  {
    this.jdField_a_of_type_Bcpl = parambcpl;
    if (parambcpl == null) {
      throw new RuntimeException("ViewStyle can not be null!");
    }
    this.jdField_a_of_type_Bcpk = parambcpk;
    this.jdField_a_of_type_Int = getChildCount();
    if (this.jdField_a_of_type_Int <= 0) {
      throw new RuntimeException("Unsupportted column count " + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.jdField_a_of_type_Int];
    this.jdField_a_of_type_ArrayOfBcpj = new bcpj[this.jdField_a_of_type_Int];
    int i = 0;
    while (i < this.jdField_a_of_type_Int)
    {
      a((WheelView)getChildAt(i), i);
      i += 1;
    }
  }
  
  public void setPickListener(bcpm parambcpm)
  {
    this.jdField_a_of_type_Bcpm = parambcpm;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */